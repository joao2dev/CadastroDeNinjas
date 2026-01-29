package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaServices {
    private NinjasRepository ninjaRepository;

    public NinjaServices(NinjasRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //    Listar todos os ninjas
    public List<NinjaModel> mostrarNinjas(){
        return ninjaRepository.findAll();
    }
}
