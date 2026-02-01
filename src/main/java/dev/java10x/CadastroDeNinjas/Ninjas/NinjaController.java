package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public NinjaDTO adicionarNinja(@RequestBody NinjaDTO ninja){
       return ninjaServices.criarNinja(ninja);
}


// mostrar ninja(READ)
    @GetMapping("/mostrartodos")
    public List<NinjaModel> mostrarTodosNinja(){
        return ninjaServices.mostrarNinjas();
}

// mostrar ninja POR ID(READ)
    @GetMapping("/mostrar/{id}")
    public NinjaModel mostrarNinjaId(@PathVariable Long id){
        return ninjaServices.mostrarNinjaPorId(id);
}

// Alterar dados dos ninjas(UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjaPorId(@PathVariable Long id , @RequestBody NinjaModel ninja){
        return ninjaServices.alterarNinjaPorId(id,ninja);
}

// Deletar ninja(DELETE)
    @DeleteMapping("/deletarninja/{id}")
    public void deletarNinjaId(@PathVariable Long id){
        ninjaServices.deletarNinjaPorId(id);
}


}
