package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninjas")
public class NinjaController {

// Adicionar ninja(CREATE)
@PostMapping("/adicionar")
public String adicionarNinja(){
    return "Ninja adicionado";
}


// mostrar ninja(READ)
@GetMapping("/mostrar")
public String mostrarNinja(){
    return "Mostrar Ninja";
}

// mostrar ninja(READ)
@GetMapping("/mostrartodos")
public String mostrarTodosNinja(){
    return "todos Ninjas";
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
