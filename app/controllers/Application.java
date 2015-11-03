package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Aluno;
import models.Disciplina;
import play.*;
import play.data.Form;
import play.libs.F;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    public static Result index() {
        return ok(views.html.index.render());
    }

}
