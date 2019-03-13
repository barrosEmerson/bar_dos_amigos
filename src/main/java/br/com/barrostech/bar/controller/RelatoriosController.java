package br.com.barrostech.bar.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.barrostech.dto.*;
import br.com.barrostech.bar.service.*;


@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {	

	@Autowired
	private RelatorioService relatorioService;

	@GetMapping("/validade")
	public ModelAndView relatoriosValidade() {
		ModelAndView mv = new ModelAndView("relatorioValidade");
		mv.addObject(new PeriodoRelatorio());
		return mv;
	}

	@PostMapping("/validade")
	public ResponseEntity<byte[]> gerarRelatorioValidade(PeriodoRelatorio periodoRelatorio) throws Exception {
		byte[] relatorio = relatorioService.gerarRelatorioValidade(periodoRelatorio); 
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
				.body(relatorio);
	}

}