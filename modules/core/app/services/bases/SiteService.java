package services.bases;

import java.util.List;

import models.bases.Site;
import play.db.ebean.Model.Finder;
import utils.base.ApplicationConfigUtils;
import utils.base.EbeanUtil;

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

	public static PagingList<Site> getSiteCriteriaByCompany(Long companyId) {
		return find.where().eq("company_id", companyId).orderBy()
				.desc("createDate")
				.findPagingList(ApplicationConfigUtils.MAX_PER_PAGE);
	}

	public static List<Site> getSiteResultListByCompany(Long companyId,
			Integer page) {
		PagingList<Site> pagingList = getSiteCriteriaByCompany(companyId);
		Page<Site> currentPage = pagingList.getPage(page);
		return currentPage.getList();
	}

	public static Integer getSiteResultCountByCompany(Long companyId,
			Integer page) {
		PagingList<Site> pagingList = getSiteCriteriaByCompany(companyId);
		return pagingList.getTotalPageCount();
	}

	public static PagingList<Site> getSiteCriteriaByCategory(Long categoryId) {
		return find.where().eq("category_id", categoryId).orderBy()
				.desc("createDate")
				.findPagingList(ApplicationConfigUtils.MAX_PER_PAGE);
	}

	public static List<Site> getSiteResultListByCategory(Long categoryId,
			Integer page) {
		PagingList<Site> pagingList = getSiteCriteriaByCategory(categoryId);
		Page<Site> currentPage = pagingList.getPage(page);
		return currentPage.getList();
	}

	public static Integer getSiteResultCountByCategory(Long categoryId,
			Integer page) {
		PagingList<Site> pagingList = getSiteCriteriaByCategory(categoryId);
		return pagingList.getTotalPageCount();
	}

	public static boolean hasSameSiteByUrl(String url) {
		int count = find.where().eq("url", url).findRowCount();
		return (count != 0);
	}

	public static List<Site> getSiteResultListBySameCompany(Long companyId,
			Long siteId) {
		return find.where().eq("company_id", companyId).ne("site_id", siteId)
				.orderBy(EbeanUtil.getRandom())
				.setMaxRows(ApplicationConfigUtils.MAX_ROWS_SUB).findList();
	}

	public static List<Site> getSiteResultListBySameCategory(Long categoryId,
			Long companyId) {
		return find.where().eq("category_id", categoryId)
				.ne("company_id", companyId).orderBy(EbeanUtil.getRandom())
				.setMaxRows(ApplicationConfigUtils.MAX_ROWS_SUB).findList();
	}

}
