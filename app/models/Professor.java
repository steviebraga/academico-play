package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alfaville on 10/27/15.
 */
@Entity
public class Professor extends Model {

	@Id
	@GeneratedValue
	public Long id;

	@Column( nullable = false )
	public String nome;

	@Column( unique = true )
	public String cpf;

	@ManyToMany
	public List<Disciplina> disciplinas;

	public static Model.Finder<Long, Professor> finder = new Finder<>( Long.class, Professor.class);

}
