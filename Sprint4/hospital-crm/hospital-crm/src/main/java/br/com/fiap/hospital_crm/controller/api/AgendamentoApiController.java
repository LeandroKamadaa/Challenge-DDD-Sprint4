package br.com.fiap.hospital_crm.controller.api;

import br.com.fiap.hospital_crm.model.Agendamento;
import br.com.fiap.hospital_crm.service.AgendamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller pros agendamentos da api
@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoApiController {

    private final AgendamentoService agendamentoService;

    public AgendamentoApiController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    // lista tudo q tem de agendamento
    @GetMapping
    public ResponseEntity<List<Agendamento>> listarTodos() {
        return ResponseEntity.ok(agendamentoService.listarTodos());
    }

    // pega 1 so agendamento
    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(agendamentoService.buscarPorId(id));
    }

    // cria novo agendamento, cuidando pra dar conflito etc (no service)
    @PostMapping
    public ResponseEntity<Agendamento> agendar(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = agendamentoService.agendarConsulta(agendamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAgendamento);
    }

    // update de status pra n ter q passar objeto inteiro, usa PATCH
    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        agendamentoService.atualizarStatus(id, status);
        return ResponseEntity.noContent().build(); // devolve 204 se der certo
    }
}
