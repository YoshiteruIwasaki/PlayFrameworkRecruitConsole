package utils;

import java.util.List;

import models.CategoryBean;
import services.CategoryBeanService;

public class ViewUnitHelperUtils {

	public static List<CategoryBean> getCategoryBeanAllList() {
		return CategoryBeanService.getCategoryBeanAllList();
	}

}
