package controllers.site;

import java.util.LinkedHashMap;

import models.CategoryBean;
import models.bases.Category;
import models.bases.Company;
import models.bases.Site;
import models.form.SiteFormBean;

import org.apache.commons.lang3.StringUtils;

import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.Result;
import services.CategoryBeanService;
import services.bases.CategoryService;
import services.bases.CompanyService;
import controllers.base.BaseController;

public class SiteFormController extends BaseController {

	public static Result register() {
		LinkedHashMap<String, String> categoryList = CategoryBeanService
				.getCategoryAllMap();
		Form<SiteFormBean> siteForm = Form.form(SiteFormBean.class);
		return ok(views.html.site.register
				.render(siteForm, categoryList, false));
	}

	public static Result confirm() {
		Form<SiteFormBean> siteForm = Form.form(SiteFormBean.class)
				.bindFromRequest();
		if (siteForm.hasErrors()) {
			LinkedHashMap<String, String> categoryList = CategoryBeanService
					.getCategoryAllMap();
			return ok(views.html.site.register.render(siteForm, categoryList,
					true));
		}
		String categoryId = siteForm.data().get("category.category_id");
		CategoryBean categoryBean = new CategoryBean();
		if (!StringUtils.isEmpty(categoryId)) {
			categoryBean = CategoryBeanService.getCategoryBean(Long
					.parseLong(categoryId));
		}
		return ok(views.html.site.confirm.render(siteForm, categoryBean));
	}

	@Transactional
	public static Result submit() {
		Form<SiteFormBean> siteForm = Form.form(SiteFormBean.class)
				.bindFromRequest();
		if (siteForm.hasErrors()) {
			LinkedHashMap<String, String> categoryList = CategoryBeanService
					.getCategoryAllMap();
			return ok(views.html.site.register.render(siteForm, categoryList,
					true));
		}
		SiteFormBean bean = siteForm.get();

		Site site = Form.form(Site.class).bindFromRequest().get();

		String categoryId = siteForm.data().get("category.category_id");
		if (!StringUtils.isEmpty(categoryId)) {
			Category category = CategoryService.getCategory(Long
					.parseLong(categoryId));
			if (category != null) {
				site.category = category;
			}
		}

		if (!StringUtils.isEmpty(bean.companyName)) {
			Company company = CompanyService.getCompanyByName(bean.companyName);
			if (company == null) {
				company = new Company();
				company.title = bean.companyName;
				company.save();
				site.company = company;
			}
		}

		site.save();
		return redirect(controllers.site.routes.SiteFormController.success());
	}

	public static Result success() {
		return ok(views.html.site.success.render(""));
	}
}
