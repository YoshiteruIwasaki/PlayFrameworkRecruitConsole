package services.json;

import java.util.ArrayList;

import models.TagBean;
import models.json.TagJsonBean;
import services.TagBeanService;

public class TagJsonBeanService extends TagBeanService {

	private static TagJsonBean setTagJsonBean(TagBean tag) {
		TagJsonBean bean = new TagJsonBean();
		bean.id = tag.tagId;
		bean.text = tag.title;
		return bean;
	}

	public static ArrayList<TagJsonBean> getTagJsonListBeanByTitle(String keyword) {
		ArrayList<TagJsonBean> list = new ArrayList<TagJsonBean>();

		ArrayList<TagBean> resultList = getTagListBeanByTitle(keyword);
		for (TagBean tag : resultList) {
			list.add(setTagJsonBean(tag));
		}
		return list;
	}

}
