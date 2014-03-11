package controllers.api;

import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import play.Logger;
import play.libs.Json;
import play.mvc.Result;
import utils.base.ControllersUtil;
import utils.base.SiteUtil;

import components.httpclient.HttpClient;

import controllers.base.BaseController;

public class SiteInfoApiController extends BaseController {

	public static Result index() {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String url = ControllersUtil.getParam("url");
		if (url != null && !"".equals(url) && HttpClient.isValidUrl(url)) {
			String title = "";
			try {
				title = HttpClient.perseTitleFromUrl(url);
				if (!StringUtils.isEmpty(title)) {
					hashMap.put("title", title);
					String companyName = SiteUtil.getCompanyName(title);
					if (!StringUtils.isEmpty(companyName)) {
						hashMap.put("company", companyName);
					}
				}
			} catch (IOException e) {
				Logger.error("SiteInfoApiController.index", e);
			} catch (Exception e) {
				Logger.error("SiteInfoApiController.index", e);
			}

		}
		return ok(Json.toJson(hashMap));
	}
}
