package services;

import java.util.ArrayList;
import java.util.List;

import models.TagSiteMapBean;
import models.bases.TagSiteMap;
import services.bases.TagSiteMapService;

public class TagSiteMapBeanService extends TagSiteMapService {

	public static List<TagSiteMapBean> getTagSiteMapBeanListByTag(Long tagId,
			int page) {
		ArrayList<TagSiteMapBean> list = new ArrayList<TagSiteMapBean>();
		List<TagSiteMap> resultList = getTagSiteMapResultListByTag(tagId, page);
		for (TagSiteMap map : resultList) {
			list.add(setTagSiteMapBean(map));
		}
		return list;
	}

	private static TagSiteMapBean setTagSiteMapBean(TagSiteMap map) {
		TagSiteMapBean bean = new TagSiteMapBean();
		bean.mapId = map.mapId;
		bean.site = map.site;
		bean.tag = map.tag;
		bean.createDate = map.createDate;
		bean.updateDate = map.updateDate;
		return bean;
	}

}
