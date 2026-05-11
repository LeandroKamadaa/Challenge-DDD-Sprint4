package br.com.fiap.hospital_crm.controller.view;

import br.com.fiap.hospital_crm.service.AgendamentoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// mostra as telas dos agendamentos
@Controller
@RequestMapping("/agendamentos")
public class AgendamentoViewController {

    private final AgendamentoService agendamentoService;

    public AgendamentoViewController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    // injeta a variavel agendamentos pro html ler
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("agendamentos", agendamentoService.listarTodos());
        return "agendamentos/index";
    }
}
