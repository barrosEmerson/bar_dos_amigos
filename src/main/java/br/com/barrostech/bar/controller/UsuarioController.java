package br.com.barrostech.bar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.barrostech.bar.model.Usuario;
import br.com.barrostech.bar.repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastrousuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ModelAndView init() {
		ModelAndView view = new ModelAndView("cadastrousuario");
		return view;
	}
	
	@PostMapping("**/salvarusuario")
	public ModelAndView salvar(Usuario user) {
		repository.save(user);
		ModelAndView view = new ModelAndView("cadastrousuario");
		return view;
		
	}
}
