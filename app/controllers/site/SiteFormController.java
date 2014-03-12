package controllers.site;

import java.util.LinkedHashMap;

import models.beans.CategoryBean;
import models.beans.CompanyBean;
import models.beans.SiteBean;

import org.apache.commons.lang3.StringUtils;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Result;
import services.bases.CategoryService;
import services.beans.CategoryBeanService;
import services.beans.CompanyBeanService;
import controllers.base.BaseController;

public class SiteFormController extends BaseController {

	public static Result register() {
		LinkedHashMap<String, String> categoryList = CategoryBeanService
				.getCategoryAllMap();
		Form<SiteBean> siteForm = Form.form(SiteBean.class);
		return ok(views.html.site.register
				.render(siteForm, categoryList, false));
	}

	public static Result confirm() {
		Form<SiteBean> siteForm = Form.form(SiteBean.class).bindFromRequest();
		if (siteForm.hasErrors()) {
			LinkedHashMap<String, String> categoryList = CategoryBeanService
					.getCategoryAllMap();
			return ok(views.html.site.register.render(siteForm, categoryList,
					true));
		}
		DynamicForm requestData = Form.form().bindFromRequest();
		String categoryId = requestData.get("category.category_id");
		CategoryBean categoryBean = new CategoryBean();
		if (!StringUtils.isEmpty(categoryId)) {
			categoryBean = CategoryBeanService.getCategoryBean(Long
					.parseLong(categoryId));
		}
		return ok(views.html.site.confirm.render(siteForm, categoryBean));
	}

	public static Result submit() {
		Form<SiteBean> siteForm = Form.form(SiteBean.class).bindFromRequest();
		if (siteForm.hasErrors()) {
			LinkedHashMap<String, String> categoryList = CategoryBeanService
					.getCategoryAllMap();
			return ok(views.html.site.register.render(siteForm, categoryList,
					true));
		}
		SiteBean bean = siteForm.get();

		DynamicForm requestData = Form.form().bindFromRequest();
		String categoryId = requestData.get("category.category_id");
		if (!StringUtils.isEmpty(categoryId)) {
			bean.category = CategoryService.getCategory(Long
					.parseLong(categoryId));
		}
		if(!StringUtils.isEmpty(bean.companyName)){
			CompanyBean company = CompanyBeanService.getCompanyBeanByName(bean.companyName);
			if(company == null){
				company = new CompanyBean();
				company.title = bean.companyName;
				company.save();
				bean.company = company.getCompany();
			}
		}

		bean.save();
		return redirect(controllers.site.routes.SiteFormController.success());
	}

	public static Result success() {
		return ok(views.html.site.success.render(""));
	}
}
