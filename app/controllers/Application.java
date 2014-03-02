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

		String title = ApplicationSiteConfigUtils.SITE_TITLE;
		String description = ApplicationSiteConfigUtils.SITE_DESCRIPTION;
        return ok(views.html.index.render(title, description, resultList));
    }

}
