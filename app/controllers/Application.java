package controllers;

import java.util.List;

import models.beans.SiteBean;
import play.mvc.Controller;
import play.mvc.Result;
import services.beans.SiteBeanService;

public class Application extends Controller {

    public static Result index() {
    	List<SiteBean> resultList = SiteBeanService.getSiteBeanResultList(0);
        return ok(views.html.index.render("Hello Play Framework", resultList));
    }

}
