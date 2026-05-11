package br.com.fiap.hospital_crm.controller.view;

import br.com.fiap.hospital_crm.service.LeadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// controller que devolve a pagina html dos leads
@Controller
@RequestMapping("/leads")
public class LeadViewController {

    private final LeadService leadService;

    public LeadViewController(LeadService leadService) {
        this.leadService = leadService;
    }

    // pega os leads do banco e manda pra view
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("leads", leadService.listarTodos());
        return "leads/index"; // aponta pro thymeleaf
    }
}
