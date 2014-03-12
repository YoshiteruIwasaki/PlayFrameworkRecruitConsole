package services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import models.CategoryBean;
import models.bases.Category;
import services.bases.CategoryService;

public class CategoryBeanService extends CategoryService {

	public static List<CategoryBean> getCategoryBeanAllList() {
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		List<Category> resultList = getCategoryAllList();
		for (Category category : resultList) {
			list.add(setCategoryBean(category));
		}
		return list;
	}

	public static CategoryBean getCategoryBean(Long categoryId) {
		Category category = getCategory(categoryId);
		CategoryBean categoryBean = new CategoryBean();
		if (category != null) {
			categoryBean = setCategoryBean(category);
		}
		return categoryBean;
	}

	private static CategoryBean setCategoryBean(Category category) {
		CategoryBean bean = new CategoryBean();
		bean.categoryId = category.categoryId;
		bean.title = category.title;
		bean.sortOrder = category.sortOrder;
		bean.createDate = category.createDate;
		bean.updateDate = category.updateDate;
		return bean;
	}

	public static LinkedHashMap<String, String> getCategoryAllMap() {
		List<CategoryBean> list = getCategoryBeanAllList();
		LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>();
		for (CategoryBean category : list) {
			hashMap.put(category.categoryId.toString(), category.title);
		}
		return hashMap;
	}

}
