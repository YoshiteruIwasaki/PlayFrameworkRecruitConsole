package controllers.site;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.event.ServerConfigStartup;

import models.CategoryBean;
import models.CompanyBean;
import models.SiteBean;
import models.TagBean;
import play.Logger;
import play.db.DB;
import play.mvc.Result;
import services.CategoryBeanService;
import services.CompanyBeanService;
import services.SiteBeanService;
import services.TagBeanService;
import controllers.base.BaseController;

public class SiteController extends BaseController {

	public static Result detail(Long siteId) {
		List<SiteBean> sameCompanySiteList = new ArrayList<SiteBean>();
		List<SiteBean> sameCategorySiteList = new ArrayList<SiteBean>();
		SiteBean bean = SiteBeanService.getSiteBean(siteId);
		if (bean != null) {
			if (bean.company != null) {
				sameCompanySiteList = SiteBeanService
						.getSiteBeanResultListBySameCompany(
								bean.company.companyId, siteId);
			}
			if (bean.company != null && bean.category != null) {
				sameCategorySiteList = SiteBeanService
						.getSiteBeanResultListBySameCategory(
								bean.category.categoryId, bean.company.companyId);
			}
			return ok(views.html.site.detail.render(bean, sameCompanySiteList, sameCategorySiteList));
		}
		return notFound("ページがみつかりません");
	}

	public static Result listByCompany(Long companyId) {
		CompanyBean companyBean = CompanyBeanService.getCompanyBean(companyId);
		if (companyBean != null) {
			List<SiteBean> resultList = SiteBeanService
					.getSiteBeanResultListByCompany(companyId, 0);
			return ok(views.html.site.listByCompany.render(companyBean,
					resultList));
		}
		return notFound("ページがみつかりません");
	}

	public static Result listByCategory(Long categoryId) {
		CategoryBean categoryBean = CategoryBeanService
				.getCategoryBean(categoryId);
		if (categoryBean != null) {
			List<SiteBean> resultList = SiteBeanService
					.getSiteBeanResultListByCategory(categoryId, 0);
			return ok(views.html.site.listByCategory.render(categoryBean,
					resultList));
		}
		return notFound("ページがみつかりません");
	}

	public static Result listByTag(Long tagId) {
		TagBean tagBean = TagBeanService.getTagBean(tagId);
		if (tagBean != null) {
			List<SiteBean> resultList = SiteBeanService
					.getSiteBeanResultListByTag(tagId, 0);
			return ok(views.html.site.listByTag.render(tagBean, resultList));
		}
		return notFound("ページがみつかりません");
	}
}
