package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaServices ninjaServices;


    public NinjaController(NinjaServices ninjaServices) {
        this.ninjaServices = ninjaServices;
    }



    // Adicionar ninja(CREATE)
    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja){
       NinjaDTO novoNinja = ninjaServices.criarNinja(ninja);
       return ResponseEntity.status(HttpStatus.CREATED)
               .body(ninja.getNome() + ", foi adicionado com sucesso!");
}


// mostrar ninja(READ)
    @GetMapping("/mostrartodos")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosNinja(){
        List<NinjaDTO> ninjas = ninjaServices.mostrarNinjas();
        return ResponseEntity.ok(ninjas);
}

// mostrar ninja POR ID(READ)
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarNinjaId(@PathVariable Long id){
        NinjaDTO ninja = ninjaServices.mostrarNinjaPorId(id);
        if (ninja != null){
            return ResponseEntity.ok("ninja encontrado:" + "\nid: "+ ninja.getId() + "\nnome: " + ninja.getNome() );
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja nao encontrado.");
        }
}

// Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjaPorId(@PathVariable Long id , @RequestBody NinjaDTO ninja){
        if (ninjaServices.mostrarNinjaPorId(id) != null){
            ninjaServices.alterarNinjaPorId(id,ninja);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("ninja alterado com sucesso!");}
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ninja nao encontrado");
        }
        }




// Deletar ninja(DELETE)
    @DeleteMapping("/deletarninja/{id}")
    public ResponseEntity<String> deletarNinjaId(@PathVariable Long id,NinjaDTO nome  ){

        if (ninjaServices.mostrarNinjaPorId(id) != null){
            ninjaServices.deletarNinjaPorId(id);
            return ResponseEntity.ok("id: "+id+", deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ninja nao encontrado");
        }
}


}
