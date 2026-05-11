package br.com.fiap.hospital_crm.controller.view;

import br.com.fiap.hospital_crm.service.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// controller pra parte visual dos pacientes no navegador
@Controller
@RequestMapping("/pacientes")
public class PacienteViewController {

    private final PacienteService pacienteService;

    public PacienteViewController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // carrega a tela e joga a lista de pacientes pro html
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.listarTodos());
        return "pacientes/index"; // chama o arquivo html q ta no templates
    }
}
