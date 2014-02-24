package controllers.ajax;

import java.util.List;

import models.beans.SiteBean;
import play.mvc.Controller;
import play.mvc.Result;
import services.beans.SiteBeanService;
import utils.ApplicationSiteConfigUtils;

public class ListAjaxController extends Controller {

	public static Result index(int page) {
		List<SiteBean> resultList = SiteBeanService.getSiteBeanResultList(page);
		return resultList.size() == 0 ? ok("") : ok(views.html.ajax.listAjax
				.render(page, resultList));
	}

}
