package controllers.site;

import java.util.List;

import models.CategoryBean;
import models.CompanyBean;
import models.SiteBean;
import play.mvc.Result;
import services.CategoryBeanService;
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
		List<SiteBean> resultList = SiteBeanService
				.getSiteBeanResultListByCompany(companyId, 0);
		return ok(views.html.site.listByCompany.render(companyBean, resultList));
	}

	public static Result listByCategory(Long categoryId) {
		CategoryBean categoryBean = CategoryBeanService.getCategoryBean(categoryId);
		List<SiteBean> resultList = SiteBeanService
				.getSiteBeanResultListByCategory(categoryId, 0);
		return ok(views.html.site.listByCategory.render(categoryBean, resultList));
	}
}
