package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//   Listar ninja por ID
    public NinjaModel mostrarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

//  Criar Ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
//  Deletar Ninja
    public void deletarNinjaPorId(Long id){
         ninjaRepository.deleteById(id);
    }
//  Alterar informações de um ninja
    public NinjaModel alterarNinjaPorId(Long id, NinjaModel ninja){
        if (ninjaRepository.existsById(id)){
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }
}
