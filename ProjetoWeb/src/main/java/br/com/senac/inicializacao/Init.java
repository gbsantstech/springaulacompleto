package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	AlunoService alunoService;
	@Autowired
	TurmaService turmaService;
	@Autowired
	CursoService cursoService;
	@Autowired
	ProfessorService professorService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		alunoService.salvar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("José");
		alunoService.salvar(aluno3);
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		for(Aluno aluno:listaAlunos) {
			System.out.println(aluno.getNome());
		}
		
		Professor professor1 = new Professor();
		professor1.setNomeProfessor("Diogo");
		professorService.salvar(professor1);
		
		Professor professor2 = new Professor();
		professor2.setNomeProfessor("Felipe");
		professorService.salvar(professor2);
		
		Professor professor3 = new Professor();
		professor3.setNomeProfessor("Gabriel");
		professorService.salvar(professor3);
		
		List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		
		for(Professor professor:listaProfessores) {
			System.out.println(professor.getNomeProfessor());
		}
		
		Curso curso1 = new Curso();
		curso1.setNomeCurso("Programação web");
		cursoService.salvar(curso1);

		Curso curso2 = new Curso();
		curso2.setNomeCurso("Tec web");
		cursoService.salvar(curso2);

		Curso curso3 = new Curso();
		curso3.setNomeCurso("Java");
		cursoService.salvar(curso3);
		
		List<Curso> listaCursos = cursoService.buscarTodosCursos();
		
		for(Curso curso:listaCursos) {
			System.out.println(curso.getNomeCurso());
		}
		
		Turma turma1 = new Turma();
		turma1.setNumero(601);
		turmaService.salvar(turma1);
		
		Turma turma2 = new Turma();
		turma2.setNumero(602);
		turmaService.salvar(turma2);
		
		Turma turma3 = new Turma();
		turma3.setNumero(603);
		turmaService.salvar(turma3);
		
		List<Turma> listaTurma = turmaService.buscarTodasTurmas();
		
		for(Turma turma:listaTurma) {
			System.out.println(turma.getNumero());
		}
	}
	
	

}
