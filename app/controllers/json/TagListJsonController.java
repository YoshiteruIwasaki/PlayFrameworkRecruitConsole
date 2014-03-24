package controllers.json;

import java.util.List;

import models.json.TagJsonBean;
import play.libs.Json;
import play.mvc.Result;
import services.json.TagJsonBeanService;
import utils.base.ControllersUtil;
import controllers.base.BaseController;

public class TagListJsonController extends BaseController {

	public static Result index() {
		String keyword = ControllersUtil.getParam("keyword");
		List<TagJsonBean> resultList = TagJsonBeanService
				.getTagJsonListBeanByTitle(keyword);
		return ok(Json.toJson(resultList));
	}

}
