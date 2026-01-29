package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // Adicionar missao(CREATE)
    @PostMapping("/criar")
    public String criarMissao(){
        return "missao criada";
    }


    // mostrar todas as missoes(READ)
    @GetMapping("/mostrartodas")
    public String mostrarTodasMissoes(){
        return "todos missoes";
    }

    // mostrar missao POR ID(READ)
    @GetMapping("/mostrarID")
    public String mostrarMissaoId(){
        return "Mostrar missoes pelo ID";
    }

    // Alterar dados das missoes(UPDATE)
    @PutMapping("/alterarID")
    public String alterarMissaoPorId(){
        return "missao alterada";
    }

    // Deletar missao(DELETE)
    @DeleteMapping("/deletarID")
    public String deletarMissaoId(){
        return "missao deletada";
    }

}
