package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

    NinjaServices ninjaServices;

    public NinjaController(NinjaServices ninjaServices) {
        this.ninjaServices = ninjaServices;
    }

    // Adicionar ninja(CREATE)
@PostMapping("/adicionar")
public String adicionarNinja(){
    return "Ninja adicionado";
}


// mostrar ninja(READ)
@GetMapping("/mostrartodos")
public List<NinjaModel> mostrarTodosNinja(){
    return ninjaServices.mostrarNinjas();
}

// mostrar ninja POR ID(READ)
@GetMapping("/mostrarID")
public String mostrarNinjaId(){
    return "Mostrar Ninja pelo ID";
}

// Alterar dados dos ninjas(UPDATE)
@PutMapping("/alterarID")
public String alterarNinjaPorId(){
    return "ninja alterado";
}

// Deletar ninja(DELETE)
@DeleteMapping("/deletarninjaID")
public String deletarNinjaId(){
    return "Ninja deletado";
}

}
