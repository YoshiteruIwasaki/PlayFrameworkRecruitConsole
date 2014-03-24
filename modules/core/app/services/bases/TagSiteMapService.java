package services.bases;

import java.util.List;

import models.bases.Site;
import models.bases.TagSiteMap;
import play.db.ebean.Model.Finder;

public class TagSiteMapService {

	public static Finder<Long, TagSiteMap> find = new Finder<Long, TagSiteMap>(
			Long.class, TagSiteMap.class);

	public static List<TagSiteMap> getTagSiteMapListBySiste(Site site) {
		return find.where().eq("site", site).findList();
	}

}
