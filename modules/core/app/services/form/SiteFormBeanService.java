package services.form;

import java.util.List;

import models.bases.Site;
import models.bases.TagSiteMap;
import models.form.SiteFormBean;
import services.bases.SiteService;

public class SiteFormBeanService extends SiteService {

	public static SiteFormBean setSiteFormBean(Site site) {
		SiteFormBean bean = new SiteFormBean();
		bean.createDate = site.createDate;
		bean.siteId = site.siteId;
		bean.title = site.title;
		bean.updateDate = site.updateDate;
		bean.url = site.url;
		bean.isNew = false;
		bean.category = site.category;
		bean.company = site.company;
		bean.companyName = site.company != null ? site.company.title : "";
		List<TagSiteMap> list = site.tagSiteMapList;
		if (list.size() > 0) {
			StringBuilder builder = new StringBuilder();
			for (TagSiteMap tagSiteMap : list) {
				builder.append(tagSiteMap.tag.title).append(",");
			}
			bean.tagList = builder.substring(0, builder.length() - 1);
		}

		return bean;
	}

	public static SiteFormBean getSiteFormBean(Long siteId) {
		SiteFormBean siteBean = new SiteFormBean();
		Site site = getSite(siteId);
		if (site != null) {
			siteBean = setSiteFormBean(site);
		}
		return siteBean;
	}
}
