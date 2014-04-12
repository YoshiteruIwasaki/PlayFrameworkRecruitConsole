package services.bases;

import java.util.List;

import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;

import models.bases.Site;
import models.bases.TagSiteMap;
import play.db.ebean.Model.Finder;
import utils.base.ApplicationConfigUtils;

public class TagSiteMapService {

	public static Finder<Long, TagSiteMap> find = new Finder<Long, TagSiteMap>(
			Long.class, TagSiteMap.class);

	public static List<TagSiteMap> getTagSiteMapListBySiste(Site site) {
		return find.where().eq("site", site).findList();
	}

	public static PagingList<TagSiteMap> getTagSiteMapCriteriaByTag(Long tagId) {
		return find.fetch("site").where().eq("tag_id", tagId).orderBy()
				.desc("site.createDate")
				.findPagingList(ApplicationConfigUtils.MAX_PER_PAGE);
	}

	public static List<TagSiteMap> getTagSiteMapResultListByTag(Long tagId,
			Integer page) {
		PagingList<TagSiteMap> pagingList = getTagSiteMapCriteriaByTag(tagId);
		Page<TagSiteMap> currentPage = pagingList.getPage(page);
		return currentPage.getList();
	}

	public static Integer getTagSiteMapResultCountByTag(Long tagId, Integer page) {
		PagingList<TagSiteMap> pagingList = getTagSiteMapCriteriaByTag(tagId);
		return pagingList.getTotalPageCount();
	}

}
