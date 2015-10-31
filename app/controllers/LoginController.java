package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.Constraints;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;

/**
 * Created by alfaville on 10/28/15.
 */
public class LoginController extends Controller {

	public static Result login() {
		return ok(views.html.login.render(Form.form()));
	}

	public static Result logar() {
		Form<Login> form = Form.form(Login.class).bindFromRequest(); //Captura os valores do form
		if(form.hasErrors()) {
			return badRequest(views.html.login.render( form )); //Retorna os valores preenchidos para o form de login
		}
		return ok(views.html.login.render(Form.form()));
	}

	public static class Login {

		@Constraints.Required( message = "Login deve ser informado." )
		public String login;

		@Constraints.Required( message = "A senha deve ser informada." )
		public String senha;

	}

}
