package services;

import java.util.ArrayList;
import java.util.List;

import models.SiteBean;
import models.bases.Site;
import models.bases.TagSiteMap;
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

	public static List<SiteBean> getSiteBeanResultListByCompany(Long companyId,
			Integer page) {
		ArrayList<SiteBean> list = new ArrayList<SiteBean>();
		List<Site> resultList = getSiteResultListByCompany(companyId, page);
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
		bean.category = site.category;
		bean.thumbUrl = ApplicationConfigUtils.HEARTRAILS_URL + site.url;
		bean.company = site.company;
		bean.tagSiteMapList = site.tagSiteMapList;
		return bean;
	}

	public static boolean hasSameSiteBeanByUrl(String url) {
		return hasSameSiteByUrl(url);

	}

	public static SiteBean getSiteBean(Long siteId) {
		SiteBean bean = null;
		Site site = getSite(siteId);
		if (site != null) {
			bean = setSiteBean(site);
		}
		return bean;
	}

	public static List<SiteBean> getSiteBeanResultListByCategory(
			Long categoryId, int page) {
		ArrayList<SiteBean> list = new ArrayList<SiteBean>();
		List<Site> resultList = getSiteResultListByCategory(categoryId, page);
		for (Site site : resultList) {
			list.add(setSiteBean(site));
		}
		return list;
	}

	public static List<SiteBean> getSiteBeanResultListByTag(Long tagId, int page) {
		ArrayList<SiteBean> list = new ArrayList<SiteBean>();
		List<TagSiteMap> resultList = TagSiteMapBeanService
				.getTagSiteMapResultListByTag(tagId, page);
		for (TagSiteMap map : resultList) {
			list.add(setSiteBean(map.site));
		}
		return list;
	}

	public static List<SiteBean> getSiteBeanResultListBySameCompany(Long companyId,
			Long siteId) {
		ArrayList<SiteBean> list = new ArrayList<SiteBean>();
		List<Site> resultList = getSiteResultListBySameCompany(companyId, siteId);
		for (Site site : resultList) {
			list.add(setSiteBean(site));
		}
		return list;
	}

	public static List<SiteBean> getSiteBeanResultListBySameCategory(
			Long categoryId, Long companyId) {
		ArrayList<SiteBean> list = new ArrayList<SiteBean>();
		List<Site> resultList = getSiteResultListBySameCategory(categoryId, companyId);
		for (Site site : resultList) {
			list.add(setSiteBean(site));
		}
		return list;
	}

}
