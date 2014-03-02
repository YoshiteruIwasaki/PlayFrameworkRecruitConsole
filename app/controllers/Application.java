package controllers;

import java.util.List;

import models.beans.SiteBean;
import play.mvc.Result;
import services.beans.SiteBeanService;
import utils.ApplicationSiteConfigUtils;
import controllers.base.BaseController;

public class Application extends BaseController {

    public static Result index() {
    	List<SiteBean> resultList = SiteBeanService.getSiteBeanResultList(0);

        return ok(views.html.index.render(resultList));
    }

}
