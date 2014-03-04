package models.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.bases.Site;
import play.data.validation.ValidationError;
import services.beans.SiteBeanService;
import validator.base.unique.Unique;

@Unique(modelClass = SiteBean.class, fields = { "url" }, message = "すでに同じURLが登録されています。")
public class SiteBean extends Site {

	private static final long serialVersionUID = -8848680118627807080L;

	public String thumbUrl;

	public void save() {
		Site site = new Site();
		site.title = this.title;
		site.url = this.url;
		site.save();
	}

	public Map<String, List<ValidationError>> validate() {
		Map<String, List<ValidationError>> errors = null;
		if (SiteBeanService.hasSameSiteBeanByUrl(url)) {
			errors = new HashMap<String, List<ValidationError>>();
			List<ValidationError> lists = new ArrayList<ValidationError>();
			lists.add(new ValidationError("url", "すでに同じURLが登録されています。",
					new ArrayList<Object>()));
			errors.put("url", lists);
		}
		return errors;
	}

}
