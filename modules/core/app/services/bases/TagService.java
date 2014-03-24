package services.bases;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.bases.Company;
import models.bases.Tag;
import play.Logger;
import play.db.ebean.Model.Finder;
import utils.base.ApplicationConfigUtils;

public class TagService {

	public static Finder<Long, Tag> find = new Finder<Long, Tag>(Long.class,
			Tag.class);

	public static List<Tag> getTagAllList() {
		return find.all();
	}

	public static Tag getTag(Long TagId) {
		return find.byId(TagId);
	}

	public static List<Tag> getTagListByTitle(String title) {
		return find.where().ilike("title", "%" + title + "%")
				.setMaxRows(ApplicationConfigUtils.MAX_PER_PAGE).findList();
	}

	public static Tag getTagByTitle(String title) {
		try {
			return find.where().eq("title", title).findUnique();
		} catch (Exception e) {
			Logger.error("TagService.getTagByTitle", e);
		}
		return null;
	}

	public static ArrayList<Tag> setTagList(String string) {
		String[] split = string.split(",");

		ArrayList<Tag> arrayList = new ArrayList<Tag>();
		for (String value : split) {
			value = StringUtils.trim(value);
			if (StringUtils.isNumeric(value)) {
				long tagId = Long.parseLong(value);
				Tag tag = getTag(tagId);
				if (tag != null) {
					arrayList.add(tag);
				}
			} else if (!StringUtils.isEmpty(value)) {
				Tag tag = getTagByTitle(value);
				if (tag == null) {
					tag = new Tag();
				}
				tag.title = value;
				tag.save();
				arrayList.add(tag);
			}
		}
		return arrayList;
	}

}
