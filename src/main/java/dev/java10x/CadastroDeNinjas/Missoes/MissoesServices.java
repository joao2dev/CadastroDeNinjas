package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesServices {
    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesServices(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //  Mostrar todas as missoes
    public List<MissoesDTO> mostrarTodasMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    // Mostrar missoes por ID
    public MissoesDTO mostrarMissaoPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.map(missoesMapper::map).orElse(null);
    }
    // adicionar missoes
    public MissoesDTO adicionarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }
    // atualizar missoes por id
    public MissoesDTO atualizarMissaoPorId(Long id, MissoesDTO missaoDTO){
       Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
       if (missoesModel.isPresent()){
           MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
           missaoAtualizada.setId(id);
           MissoesModel novaMissao = missoesRepository.save(missaoAtualizada);
           return missoesMapper.map(novaMissao);
       }
       return null;
    }
    // Deletar missao por ID
    public void deletarMissao(Long id){
         missoesRepository.deleteById(id);
    }
}
