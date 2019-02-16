package br.com.barrostech.bar.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.barrostech.bar.model.Produtos;
import br.com.barrostech.bar.repository.ProdutoRepository;

@Controller
public class HomeController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/")
	public ModelAndView init() {
		ModelAndView view = new ModelAndView("cadastroproduto");
		view.addObject("produtoObj", new Produtos());
		Iterable<Produtos> produtos = produtoRepository.findAll();
		view.addObject("produtos", produtos);
		return view;
	}

	@PostMapping("**/salvarproduto")
	public ModelAndView salvar(Produtos produto) {
		produtoRepository.save(produto);
		ModelAndView view = new ModelAndView("cadastroproduto");
		Iterable<Produtos> produtos = produtoRepository.findAll();
		view.addObject("produtos", produtos);
		view.addObject("produtoObj", new Produtos());
		return view;
	}

	@RequestMapping("/produtos")
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("cadastroproduto");
		Iterable<Produtos> produtos = produtoRepository.findAll();
		view.addObject("produtos", produtos);
		return view;
	}

	@GetMapping("/removerproduto/{idproduto}")
	public ModelAndView remover(@PathVariable("idproduto") Long id) {
		produtoRepository.deleteById(id);
		ModelAndView view = new ModelAndView("cadastroproduto");
		Iterable<Produtos> produtos = produtoRepository.findAll();
		view.addObject("produtos", produtos);
		view.addObject("produtoObj", new Produtos());
		return view;

	}
	
	@GetMapping("/editarproduto/{idproduto}")
	public ModelAndView editar(@PathVariable("idproduto")Long id) {
		Optional<Produtos> produto = produtoRepository.findById(id);
		ModelAndView view = new ModelAndView("cadastroproduto");
		view.addObject("produtoObj", produto.get());
		return view;
		
	}
	
	@PostMapping("**/pesquisaproduto")
	public ModelAndView pesquisar(@RequestParam("pesquisaprod") String produto) {
		ModelAndView view = new ModelAndView("cadastroproduto");
		view.addObject("produtos", produtoRepository.findProdByNome(produto));
		view.addObject("produtoObj", new Produtos());
		return view;
		
	}
	
	@PostMapping("**/pesquisacodigo")
	public ModelAndView pesquisarCod(@RequestParam("pesquisacod") String codigo) {
		ModelAndView view = new ModelAndView("cadastroproduto");
		view.addObject("produtos", produtoRepository.findProdByCod(codigo));
		view.addObject("produtoObj", new Produtos());
		return view;
		
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}



}
