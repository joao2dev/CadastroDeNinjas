package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaServices {
    private NinjasRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaServices(NinjasRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //    Listar todos os ninjas
    public List<NinjaDTO> mostrarNinjas(){
        List<NinjaModel> ninja = ninjaRepository.findAll();
        return ninja.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

//   Listar ninja por ID
    public NinjaDTO mostrarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO alterarNinjaPorId(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}
