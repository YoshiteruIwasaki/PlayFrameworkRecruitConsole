package controllers.site;

import models.SiteBean;
import play.mvc.Result;
import services.SiteBeanService;
import controllers.base.BaseController;

public class SiteController extends BaseController {


	public static Result detail(Long siteId) {
		SiteBean bean = SiteBeanService.getSiteBean(siteId);
		return ok(views.html.site.detail.render(bean));
	}

}
