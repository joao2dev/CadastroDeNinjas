package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesDTO;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    private NinjaServices ninjaServices;
    @Autowired
    private MissoesServices missoesServices;

    public NinjaControllerUi(NinjaServices ninjaServices) {
        this.ninjaServices = ninjaServices;
    }

    @GetMapping("/mostrartodos")
    public String mostrarTodosNinja(Model model) {
        List<NinjaDTO> ninjas = ninjaServices.mostrarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";// tem que retornar o nome da pagina html
    }

    @GetMapping("/deletarninja/{id}")
    public String deletarNinjaId(@PathVariable Long id) {
         ninjaServices.deletarNinjaPorId(id);
         return "redirect:/ninjas/ui/mostrartodos";
    }
    @GetMapping("/mostrar/{id}")
    public String mostrarNinjaId(@PathVariable Long id ,Model model){
        NinjaDTO ninja = ninjaServices.mostrarNinjaPorId(id);
        model.addAttribute("ninja",ninja);
        return "detalhesNinja";
    }
    @GetMapping("/alterar/{id}")
    public String alterarNinjaPorId(@PathVariable Long id , Model model) {
        NinjaDTO ninja = ninjaServices.mostrarNinjaPorId(id);
        List<MissoesDTO> missoes = missoesServices.mostrarTodasMissoes();
        model.addAttribute("ninja",ninja);
        model.addAttribute("missao",missoes);
        return "editarNinja";
    }
    @PostMapping("/alterar/{id}")
    public String alterarNinjaPorId(@PathVariable Long id , @ModelAttribute NinjaDTO ninja) {
        ninjaServices.alterarNinjaPorId(id, ninja);
        return "redirect:/ninjas/ui/mostrartodos";
    }
    @GetMapping("/adicionar")
    public String adicionarNinja(Model model){
        model.addAttribute("ninja",new NinjaDTO());
        model.addAttribute("missao", missoesServices.mostrarTodasMissoes());
        return "adicionarNinja";
    }


    @PostMapping("/adicionar")
    public String adicionarNinja(@ModelAttribute NinjaDTO ninja){
        ninjaServices.criarNinja(ninja);
        return "redirect:/ninjas/ui/mostrartodos";
    }


}
