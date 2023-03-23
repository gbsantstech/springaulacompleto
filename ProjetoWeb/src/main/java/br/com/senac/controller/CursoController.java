package br.com.senac.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Curso;
import br.com.senac.entity.Turma;
import br.com.senac.service.CursoService;

@Controller
@RequestMapping("curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/listarCursos")
	public ModelAndView listaTodosCursos(){
		ModelAndView mv = new ModelAndView("curso/paginaListaCursos");
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarCurso() {
		ModelAndView mv = new ModelAndView("curso/cadastraCurso");
		mv.addObject("curso", new Curso());
		return mv;
	}
	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Curso curso) {
		cursoService.salvar(curso);
		return listaTodosCursos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCurso(@PathVariable("id") Integer idCurso) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("curso/alteraCurso");
		mv.addObject("curso", cursoService.buscaPorID(idCurso));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Curso cursoAlterado) throws ObjectNotFoundException {
		cursoService.salvarAlteracao(cursoAlterado);
		return listaTodosCursos();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirCurso(@PathVariable("id") Integer id) {
		cursoService.excluir(id);
		return listaTodosCursos();
	}
}
