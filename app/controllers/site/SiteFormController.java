package controllers.site;

import java.util.LinkedHashMap;
import java.util.List;

import models.CategoryBean;
import models.bases.Category;
import models.bases.Company;
import models.bases.Site;
import models.bases.Tag;
import models.bases.TagSiteMap;
import models.form.SiteFormBean;

import org.apache.commons.lang3.StringUtils;

import play.data.Form;
import play.db.ebean.Transactional;
import play.mvc.Result;
import services.CategoryBeanService;
import services.TagBeanService;
import services.bases.CategoryService;
import services.bases.CompanyService;
import services.bases.TagService;
import services.bases.TagSiteMapService;
import services.form.SiteFormBeanService;

import com.avaje.ebean.Ebean;

import controllers.base.BaseController;

public class SiteFormController extends BaseController {

	public static Result register() {
		LinkedHashMap<String, String> categoryList = CategoryBeanService
				.getCategoryAllMap();
		Form<SiteFormBean> siteForm = Form.form(SiteFormBean.class);
		return ok(views.html.site.register
				.render(siteForm, categoryList, false));
	}

	public static Result edit(Long siteId) {
		LinkedHashMap<String, String> categoryList = CategoryBeanService
				.getCategoryAllMap();
		SiteFormBean siteFormBean = SiteFormBeanService.getSiteFormBean(siteId);
		Form<SiteFormBean> siteForm = Form.form(SiteFormBean.class);
		siteForm = siteForm.fill(siteFormBean);
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
		SiteFormBean bean = siteForm.get();
		CategoryBean categoryBean = new CategoryBean();
		if (bean.category != null) {
			categoryBean = CategoryBeanService.getCategoryBean(bean.category.categoryId);
		}

		String tagBeanListString = TagBeanService.getTagListString(siteForm
				.data().get("tagList"));

		return ok(views.html.site.confirm.render(siteForm, categoryBean,
				tagBeanListString));
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

		if (!StringUtils.isEmpty(bean.companyName)) {
			Company company = CompanyService.getCompanyByName(bean.companyName);
			if (company == null) {
				company = new Company();
				company.title = bean.companyName;
				company.save();
			}
			site.company = company;
		}

		site.save();
		List<TagSiteMap> list = TagSiteMapService
				.getTagSiteMapListBySiste(site);
		if (list != null) {
			Ebean.delete(list);
		}

		List<Tag> tagList = TagService.setTagList(siteForm.data()
				.get("tagList"));
		for (Tag tag : tagList) {
			TagSiteMap tagSiteMap = new TagSiteMap();
			tagSiteMap.site = site;
			tagSiteMap.tag = tag;
			tagSiteMap.save();
		}

		return redirect(controllers.site.routes.SiteFormController.success());
	}

	public static Result success() {
		return ok(views.html.site.success.render(""));
	}
}
