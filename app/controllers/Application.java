package controllers;

import java.util.List;

import models.SiteBean;
import play.mvc.Result;
import services.SiteBeanService;
import controllers.base.BaseController;

public class Application extends BaseController {

    public static Result index() {
    	List<SiteBean> resultList = SiteBeanService.getSiteBeanResultList(0);

        return ok(views.html.index.render(resultList));
    }

}
