package br.com.fiap.hospital_crm.controller.api;

import br.com.fiap.hospital_crm.model.Lead;
import br.com.fiap.hospital_crm.service.LeadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller da api pra gerenciar os leads (retorna json)
@RestController
@RequestMapping("/api/leads")
public class LeadApiController {

    private final LeadService leadService;

    // injeção de dependencia do service
    public LeadApiController(LeadService leadService) {
        this.leadService = leadService;
    }

    // devolve a lista completa de leads
    @GetMapping
    public ResponseEntity<List<Lead>> listarTodos() {
        return ResponseEntity.ok(leadService.listarTodos());
    }

    // acha um lead pelo id passado na url
    @GetMapping("/{id}")
    public ResponseEntity<Lead> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(leadService.buscarPorId(id));
    }

    // cria um lead novo no banco
    @PostMapping
    public ResponseEntity<Lead> cadastrar(@RequestBody Lead lead) {
        Lead novoLead = leadService.cadastrarLead(lead);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLead);
    }
}
