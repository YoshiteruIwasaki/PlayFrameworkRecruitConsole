package services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import models.TagBean;
import models.bases.Tag;

import org.apache.commons.lang3.StringUtils;

import services.bases.TagService;

public class TagBeanService extends TagService {

	public static List<TagBean> getTagBeanAllList() {
		ArrayList<TagBean> list = new ArrayList<TagBean>();
		List<Tag> resultList = getTagAllList();
		for (Tag tag : resultList) {
			list.add(setTagBean(tag));
		}
		return list;
	}

	public static TagBean getTagBean(Long tagId) {
		Tag tag = getTag(tagId);
		if (tag != null) {
			TagBean tagBean = new TagBean();
			tagBean = setTagBean(tag);
			return tagBean;
		}
		return null;
	}

	private static TagBean setTagBean(Tag tag) {
		TagBean bean = new TagBean();
		bean.tagId = tag.tagId;
		bean.title = tag.title;
		bean.createDate = tag.createDate;
		bean.updateDate = tag.updateDate;
		bean.tagSiteMapList = tag.tagSiteMapList;
		return bean;
	}

	public static LinkedHashMap<String, String> getTagAllMap() {
		List<TagBean> list = getTagBeanAllList();
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
		for (TagBean tag : list) {
			hashMap.put(tag.tagId.toString(), tag.title);
		}
		return hashMap;
	}

	public static ArrayList<TagBean> getTagListBeanByTitle(String keyword) {
		ArrayList<TagBean> list = new ArrayList<TagBean>();
		List<Tag> resultList = getTagListByTitle(keyword);
		for (Tag tag : resultList) {
			list.add(setTagBean(tag));
		}
		return list;
	}

	public static TagBean getTagBeanByTitle(String keyword) {
		TagBean tagBean = null;
		Tag tag = getTagByTitle(keyword);
		if (tag != null) {
			tagBean = setTagBean(tag);
		}
		return tagBean;
	}

	public static ArrayList<TagBean> getTagBeanList(String string) {
		String[] split = string.split(",");

		ArrayList<TagBean> arrayList = new ArrayList<TagBean>();
		for (String tag : split) {
			tag = StringUtils.trim(tag);
			if (StringUtils.isNumeric(tag)) {
				long tagId = Long.parseLong(tag);
				TagBean tagBean = getTagBean(tagId);
				if (tagBean != null) {
					arrayList.add(tagBean);
				}
			} else if (!StringUtils.isEmpty(tag)) {
				TagBean tagBean = getTagBeanByTitle(tag);
				if (tagBean == null) {
					tagBean = new TagBean();
				}
				tagBean.title = tag;
				arrayList.add(tagBean);
			}
		}
		return arrayList;
	}

	public static String getTagListString(String string) {
		ArrayList<TagBean> arrayList = getTagBeanList(string);
		String result = "";
		if (arrayList.size() > 0) {
			StringBuilder builder = new StringBuilder();
			for (TagBean bean : arrayList) {
				builder.append(bean.title).append(",");
			}
			result = builder.substring(0, builder.length() - 1);
		}
		return result;
	}

}
