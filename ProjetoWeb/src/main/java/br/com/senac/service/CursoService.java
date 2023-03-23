package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Curso;
import br.com.senac.entity.Turma;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repoCurso;
	
	public List<Curso> buscarTodosCursos(){
		return repoCurso.findAll();
	}
	public Curso salvar(Curso curso) {
		return repoCurso.save(curso);
	}
	public Curso buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Curso> curso = repoCurso.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException(curso, "Curso nao encontrado. Id: " + id));
	}
	
	public Curso salvarAlteracao(Curso cursoAlterado) throws ObjectNotFoundException {
		Curso curso = buscaPorID(cursoAlterado.getId());
		curso.setId(cursoAlterado.getId());
		curso.setNomeCurso(cursoAlterado.getNomeCurso());
		return salvar(curso);
	}
	public void excluir(Integer id) {
		repoCurso.deleteById(id);
	}
}
