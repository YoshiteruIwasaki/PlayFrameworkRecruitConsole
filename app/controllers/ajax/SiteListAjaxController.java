package controllers.ajax;

import java.util.List;

import models.SiteBean;
import play.mvc.Result;
import services.SiteBeanService;
import controllers.base.BaseController;

public class SiteListAjaxController extends BaseController {

	public static Result index(int page) {
		List<SiteBean> resultList = SiteBeanService.getSiteBeanResultList(page);
		return resultList.size() == 0 ? ok("")
				: ok(views.html.ajax.siteListAjax.render(page, resultList));
	}

	public static Result listByCompany(Long companyId, int page) {
		List<SiteBean> resultList = SiteBeanService
				.getSiteBeanResultListByCompany(companyId, page);
		return resultList.size() == 0 ? ok("")
				: ok(views.html.ajax.siteListAjax.render(page, resultList));
	}

}
