package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaServices {
    private NinjasRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaServices(NinjasRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
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
