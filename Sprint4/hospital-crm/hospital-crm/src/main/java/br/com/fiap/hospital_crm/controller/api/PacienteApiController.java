package br.com.fiap.hospital_crm.controller.api;

import br.com.fiap.hospital_crm.model.Paciente;
import br.com.fiap.hospital_crm.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// controller pra retornar os dados dos pacientes em formato json pra api
@RestController
@RequestMapping("/api/pacientes")
public class PacienteApiController {

    private final PacienteService pacienteService;

    // faz a injeção do service aqui
    public PacienteApiController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // pega todos os pacientes cadastrados
    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    // traz um paciente especifico pelo id da url
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    // salva paciente novo
    @PostMapping
    public ResponseEntity<Paciente> cadastrar(@RequestBody Paciente paciente) {
        Paciente novoPaciente = pacienteService.cadastrarPaciente(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPaciente); // devolve 201 created
    }

    // endpoint extra pra calcular o imc do paciente
    @GetMapping("/{id}/imc")
    public ResponseEntity<String> calcularImc(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(pacienteService.calcularIMC(paciente));
    }
}
