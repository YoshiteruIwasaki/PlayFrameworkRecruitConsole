package services.bases;

import java.util.List;

import models.bases.Site;
import play.db.ebean.Model.Finder;
import utils.base.ApplicationConfigUtils;

import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;

public class SiteService {

	public static Finder<Long, Site> find = new Finder<Long, Site>(Long.class,
			Site.class);

	public static List<Site> getSiteAllList() {
		return find.all();
	}

	public static Site getSite(Long siteId) {
		return find.byId(siteId);
	}

	public static PagingList<Site> getSiteCriteria() {
		return find.where().orderBy().desc("createDate")
				.findPagingList(ApplicationConfigUtils.MAX_PER_PAGE);
	}

	public static List<Site> getSiteResultList(Integer page) {
		PagingList<Site> pagingList = getSiteCriteria();
		Page<Site> currentPage = pagingList.getPage(page);
		return currentPage.getList();
	}

	public static Integer getSiteResultCount(Integer page) {
		PagingList<Site> pagingList = getSiteCriteria();
		return pagingList.getTotalPageCount();
	}

}