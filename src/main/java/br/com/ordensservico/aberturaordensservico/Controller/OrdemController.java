package br.com.ordensservico.aberturaordensservico.Controller;

import br.com.ordensservico.aberturaordensservico.Service.OrdemServicoService;
import br.com.ordensservico.aberturaordensservico.dto.OrdemRequest;
import br.com.ordensservico.aberturaordensservico.model.OrdemServico;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import br.com.ordensservico.aberturaordensservico.Repository.EquipamentoRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemController {

    private final OrdemServicoService ordemServicoService;


    public OrdemController(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

   @PostMapping
 public ResponseEntity<OrdemServico> cadastrar(@Valid @RequestBody OrdemRequest ordem) {

    if (ordem.getDescricao() == null || ordem.getEquipamentoId() == null) {
        return ResponseEntity.badRequest().build();
    }

     OrdemServico salvo = ordemServicoService.cadastrar(ordem);
    return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
}

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listar() {
        List<OrdemServico> ordens = ordemServicoService.listar();
        return ResponseEntity.ok(ordens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdemServico> buscarPorId(@PathVariable Integer id) {
        Optional<OrdemServico> ordem = ordemServicoService.buscarPorId(id);
        return ordem.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdemServico> atualizar(@PathVariable Integer id, @RequestBody OrdemServico novaOrdem) {
        Optional<OrdemServico> ordemAtualizada = ordemServicoService.atualizar(id, novaOrdem);

        if (ordemAtualizada.isPresent()) {
            return ResponseEntity.ok(ordemAtualizada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        boolean excluido = ordemServicoService.excluir(id);

        if (excluido) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
