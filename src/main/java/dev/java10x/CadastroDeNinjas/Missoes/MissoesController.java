package dev.java10x.CadastroDeNinjas.Missoes;



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
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao){
        return missaoServices.adicionarMissao(missao);
    }


    // mostrar todas as missoes(READ)
    @GetMapping("/mostrartodas")
    public List<MissoesDTO> mostrarTodasMissoes(){
        return missaoServices.mostrarTodasMissoes();
    }

    // mostrar missao POR ID(READ)
    @GetMapping("/mostrar/{id}")
    public MissoesDTO mostrarMissaoId(@PathVariable Long id ){
        return missaoServices.mostrarMissaoPorId(id);
    }

    // Alterar dados das missoes(UPDATE)
    @PutMapping("/alterar/{id}")
    public MissoesDTO alterarMissaoPorId(@PathVariable Long id, @RequestBody MissoesDTO missoes ){
        return missaoServices.atualizarMissaoPorId(id,missoes);
    }

    // Deletar missao(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissaoId(@PathVariable Long id){
        missaoServices.deletarMissao(id);
    }

}
