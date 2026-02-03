package dev.java10x.CadastroDeNinjas.Missoes;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesServices missaoServices ;

    public MissoesController(MissoesServices missaoServices) {
        this.missaoServices = missaoServices;
    }

    // Adicionar missao(CREATE)
    @PostMapping("/adicionar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO novaMissao = missaoServices.adicionarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("missao adicionada!!!");
    }


    // mostrar todas as missoes(READ)
    @GetMapping("/mostrartodas")
    public ResponseEntity<List<MissoesDTO>> mostrarTodasMissoes(){
        List<MissoesDTO> missoes = missaoServices.mostrarTodasMissoes();
        return ResponseEntity.ok(missoes);
    }

    // mostrar missao POR ID(READ)
    @GetMapping("/mostrar/{id}")
    public ResponseEntity mostrarMissaoId(@PathVariable Long id ){
        MissoesDTO missao = missaoServices.mostrarMissaoPorId(id);
        if (missao != null){
          return ResponseEntity.ok("Id: "+missao.getId() + "\nNome: " + missao.getNome() + "\nDificuldade: " + missao.getDificuldade());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada");
        }
    }

    // Alterar dados das missoes(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missoes ){
        MissoesDTO missaoAlterda = missaoServices.mostrarMissaoPorId(id);
        if (missaoAlterda !=null){
            missaoServices.atualizarMissaoPorId(id,missoes);
            return ResponseEntity.ok("missao: " + missaoAlterda.getNome() + "alterada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada");
        }

    }

    // Deletar missao(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoId(@PathVariable Long id){
        MissoesDTO missaoApagada = missaoServices.mostrarMissaoPorId(id);
        if (missaoApagada !=null){
            missaoServices.deletarMissao(id);
            return ResponseEntity.ok("missao apagada com sucesso.");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao nao encontrada");
        }
    }

}
