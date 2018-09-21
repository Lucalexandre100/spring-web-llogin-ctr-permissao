package br.com.apl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/entrar")
    public String entrar() {	// Escuta a url para abrir a página entrar
        return "login";
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
    public String inicio() {
        return "index";
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/projetos")
    public String projetos() {
        return "projetos";
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/relatorio-custos")
    public String relatorioCustos() {
        return "relatorio-custos";
    }
	
	@RequestMapping(method = RequestMethod.GET, path = "/relatorio-equipe")
    public String relatorioEquipe() {
        return "relatorio-equipe";
    }

}
