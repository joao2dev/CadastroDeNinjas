package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesServices {
    private MissoesRepository missoesRepository;

    public MissoesServices(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //  Mostrar todas as missoes
    public List<MissoesModel> mostrarTodasMissoes(){
        return missoesRepository.findAll();
    }
    // Mostrar missoes por ID
    public MissoesModel mostrarMissaoPorId(Long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }
    // adicionar missoes
    public MissoesModel adicionarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }
    // atualizar missoes por id
    public MissoesModel atualizarMissaoPorId(Long id, MissoesModel missao){
        if (missoesRepository.existsById(id)){
            missao.setId(id);
            return missoesRepository.save(missao);
        }
        return null;
    }
    // Deletar missao por ID
    public void deletarMissao(Long id){
         missoesRepository.deleteById(id);
    }
}
