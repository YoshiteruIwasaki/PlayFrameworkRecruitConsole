package controllers.admin;

import play.mvc.Controller;
import play.mvc.Result;

public class ApplicationController extends Controller {

    public static Result index() {
        return ok(views.html.admin.index.render("Hello from Java"));
    }

}
