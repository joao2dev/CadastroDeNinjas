package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/missoes/ui")
public class MissoesControllerUi {
    private final MissoesServices missoesServices;

    public MissoesControllerUi(MissoesServices missoesServices) {
        this.missoesServices = missoesServices;
    }

    @GetMapping("/mostrartodas")
    public String mostrarTodasMissoes(Model model){
        List<MissoesDTO> missoes = missoesServices.mostrarTodasMissoes();
        model.addAttribute("missoes" , missoes);
        return "listarMissoes";
    }

}
