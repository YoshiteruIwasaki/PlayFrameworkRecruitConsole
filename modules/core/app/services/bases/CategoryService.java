package services.bases;

import java.util.List;

import models.bases.Category;
import play.db.ebean.Model.Finder;

public class CategoryService {

	public static Finder<Long, Category> find = new Finder<Long, Category>(
			Long.class, Category.class);

	public static List<Category> getCategoryAllList() {
		return find.order().asc("sort_order").findList();
	}

	public static Category getCategory(Long categoryId) {
		return find.byId(categoryId);
	}

}
