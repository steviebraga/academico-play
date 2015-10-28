package models;

import play.db.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by alfaville on 10/27/15.
 */
@Entity
public class Disciplina extends Model {

	@Id
	@GeneratedValue
	public Long id;

	@Column( nullable = false )
	public String nome;

	public Integer cargaHoraria;

	public static Model.Finder<Long, Disciplina> finder = new Finder<>( Long.class, Disciplina.class);

}
