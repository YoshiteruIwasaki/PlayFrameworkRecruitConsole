package controllers.site;

import java.util.List;

import models.CompanyBean;
import models.SiteBean;
import play.mvc.Result;
import services.CompanyBeanService;
import services.SiteBeanService;
import controllers.base.BaseController;

public class SiteController extends BaseController {

	public static Result detail(Long siteId) {
		SiteBean bean = SiteBeanService.getSiteBean(siteId);
		return ok(views.html.site.detail.render(bean));
	}

	public static Result listByCompany(Long companyId) {
		CompanyBean companyBean = CompanyBeanService.getCompanyBean(companyId);
		String title=companyBean != null ? companyBean.title : "";
		List<SiteBean> resultList = SiteBeanService
				.getSiteBeanResultListByCompany(companyId, 0);
		return ok(views.html.site.list.render(title, resultList));
	}
}
