package br.com.ordensservico.aberturaordensservico.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.ordensservico.aberturaordensservico.Repository.EquipamentoRepository;
import br.com.ordensservico.aberturaordensservico.Repository.OrdemServicoRepository;
import br.com.ordensservico.aberturaordensservico.dto.OrdemRequest;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.model.OrdemServico;

 @Service
public class OrdemServicoService {
    
    private final OrdemServicoRepository ordemServicoRepository;
    private final EquipamentoRepository equipamentoRepository; 

    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository, EquipamentoRepository equipamentoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public OrdemServico cadastrar(OrdemRequest ordem) {
        OrdemServico novaOrdem = new OrdemServico();
        novaOrdem.setDescricao(ordem.getDescricao());

        Equipamento equipamentoEncontrado = equipamentoRepository.findById(ordem.getEquipamentoId())
                .orElseThrow(() -> new RuntimeException("Equipamento não encontrado"));

        novaOrdem.setEquipamento(equipamentoEncontrado);

        return ordemServicoRepository.save(novaOrdem);
    }


    public Optional<OrdemServico> buscarPorId(Integer id) {
        return ordemServicoRepository.findById(id);
    }

    public Optional<OrdemServico> atualizar(Integer id, OrdemServico novaOrdem) {
    Optional<OrdemServico> ordemEncontrada = ordemServicoRepository.findById(id);

    if (ordemEncontrada.isEmpty()) {
        return Optional.empty();
    }

    OrdemServico ordemServico = ordemEncontrada.get();
    
    ordemServico.setDescricao(novaOrdem.getDescricao());
    ordemServico.setEquipamento(novaOrdem.getEquipamento());
    
    return Optional.of(ordemServicoRepository.save(ordemServico));
}

public boolean excluir(Integer id) {
    Optional<OrdemServico> ordemEncontrada = ordemServicoRepository.findById(id);

    if (ordemEncontrada.isEmpty()) {
        return false;
    }

    ordemServicoRepository.deleteById(id);
    return true;
 }

 public List<OrdemServico> listar() {
    return ordemServicoRepository.findAll();
}


}

   
