package services.beans;

import java.util.ArrayList;
import java.util.List;

import models.bases.Site;
import models.beans.SiteBean;
import services.bases.SiteService;
import utils.base.ApplicationConfigUtils;

public class SiteBeanService extends SiteService {

	public static List<SiteBean> getSiteBeanResultList(Integer page) {
		ArrayList<SiteBean> list = new ArrayList<SiteBean>();
		List<Site> resultList = getSiteResultList(page);
		for (Site site : resultList) {
			list.add(setSiteBean(site));
		}
		return list;
	}

	public static SiteBean setSiteBean(Site site) {
		SiteBean bean = new SiteBean();
		bean.createDate = site.createDate;
		bean.siteId = site.siteId;
		bean.title = site.title;
		bean.updateDate = site.updateDate;
		bean.url = site.url;
		bean.thumbUrl = ApplicationConfigUtils.HEARTRAILS_URL + site.url;
		return bean;
	}

	public static boolean hasSameSiteBeanByUrl(String url) {
		return hasSameSiteByUrl(url);

	}
}
