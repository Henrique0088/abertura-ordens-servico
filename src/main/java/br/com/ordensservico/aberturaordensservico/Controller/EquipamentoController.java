package br.com.ordensservico.aberturaordensservico.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordensservico.aberturaordensservico.Service.EquipamentoService;
import br.com.ordensservico.aberturaordensservico.model.Equipamento;
import jakarta.validation.Valid;



   @RestController
@RequestMapping("/equipamento")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @PostMapping
    public ResponseEntity<Equipamento> cadastrar(@Valid @RequestBody Equipamento equipamento) {

        if (equipamento.getNome() == null
                || equipamento.getNumeroPatrimonio() == null
                || equipamento.getSetor() == null) {
            return ResponseEntity.badRequest().build();
        }

        Equipamento salvo = equipamentoService.cadastrar(equipamento);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(salvo);
    }


     @GetMapping
     public ResponseEntity<List<Equipamento>> Listar() {
        List<Equipamento> equipamentos = equipamentoService.listar();
        return ResponseEntity.ok(equipamentos);
     }

    @GetMapping ("/{id}") 
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable Integer id) {
        Optional<Equipamento> equipamento = equipamentoService.buscarPorId(id);
        return equipamento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Equipamento> atualizar (@PathVariable Integer id, @RequestBody Equipamento novoDados) {
       Optional<Equipamento> equipamentoAtualizado = equipamentoService.atualizar(id, novoDados); 

       if(equipamentoAtualizado.isPresent()) {
        return ResponseEntity.ok(equipamentoAtualizado.get());
       } else {
         return  ResponseEntity.notFound().build();
       }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Integer id) {
    boolean excluido = equipamentoService.excluir(id);

    if(excluido) {
        return ResponseEntity.noContent().build();
    } else {
        return  ResponseEntity.notFound().build();
    }
 }

    
}


