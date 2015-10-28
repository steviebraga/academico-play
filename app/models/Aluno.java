package models;

import play.data.validation.Constraints;
import play.data.validation.ValidationError;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alfaville on 10/27/15.
 */
@Entity
public class Aluno extends Model {

	@Id
	@GeneratedValue
	public Long id;

	@Column( unique = true, nullable = false )
	@Constraints.Required( message = "Matricula é obrigatória" )
	public String matricula;

	@Column( nullable = false )
	@Constraints.Required( message = "Nome é obrigatório", groups = ValidacaoGrupo.ValidaNomeCpf.class )
	public String nome;

	@Column( unique = true, nullable = false )
	@Constraints.Required( groups = ValidacaoGrupo.ValidaNomeCpf.class )
	public String cpf;

	@Temporal( TemporalType.DATE )
	public Date dataNascimento;

	@ManyToMany
	public List<Turma> alunos;

	public static Finder<Long, Aluno> finder = new Finder<>( Long.class, Aluno.class);

	public List<ValidationError> validate() {
		List<ValidationError> errors = new ArrayList<>();
		if (cpf == null || nome.equals( "negro" ))
			errors.add(new ValidationError("sss", "O aluno não pode ser negro"));

		return errors.isEmpty() ? null : errors;
	}

	public interface ValidacaoGrupo {

		public interface ValidaNomeCpf{ }

	}

}
