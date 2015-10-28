package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alfaville on 10/27/15.
 */
@Entity
public class Turma extends Model {

	@Id
	@GeneratedValue
	public Long id;

	@ManyToOne( optional = false )
	public Professor professor;

	@ManyToOne( optional = false )
	public Disciplina disciplina;

	@ManyToMany
	public List<Aluno> alunos;

	public static Model.Finder<Long, Turma> finder = new Finder<>( Long.class, Turma.class);

}
