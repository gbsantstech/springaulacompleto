package br.com.senac.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("/listarTurmas")
	public ModelAndView listaTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
		mv.addObject("turmas", turmaService.buscarTodasTurmas());
		return mv;
		
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastraTurma");
		mv.addObject("turma", new Turma());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarTurma(Turma turma) {
		turmaService.salvar(turma);
		return listaTodasTurmas();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarTurma(@PathVariable("id") Integer idTurma) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("turma/alteraTurma");
		mv.addObject("turma", turmaService.buscaPorID(idTurma));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Turma turmaAlterada) throws ObjectNotFoundException {
		turmaService.salvarAlteracao(turmaAlterada);
		return listaTodasTurmas();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirTurma(@PathVariable("id") Integer id) {
		turmaService.excluir(id);
		return listaTodasTurmas();
	}
}
