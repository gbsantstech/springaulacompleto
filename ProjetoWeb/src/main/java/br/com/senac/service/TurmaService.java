package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository repoTurma;
	
	public List<Turma> buscarTodasTurmas(){
		return repoTurma.findAll();
	}
	
	public Turma salvar(Turma turma){
		return repoTurma.save(turma);
	}
	
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = repoTurma.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(turma, "Turma nao encontrada. Id: " + id));
	}
	
	public Turma salvarAlteracao(Turma turmaAlterada) throws ObjectNotFoundException {
		Turma turma = buscaPorID(turmaAlterada.getId());
		turma.setId(turmaAlterada.getId());
		turma.setNumero(turmaAlterada.getNumero());
		return salvar(turma);
	}
	
	public void excluir(Integer id) {
		repoTurma.deleteById(id);
	}
}
