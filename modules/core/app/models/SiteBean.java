package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.bases.Site;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.ValidationError;
import services.SiteBeanService;
import validator.base.unique.Unique;

@Unique(modelClass = SiteBean.class, fields = { "url" }, message = "すでに同じURLが登録されています。")
public class SiteBean extends Site {

	private static final long serialVersionUID = -8848680118627807080L;

	public String thumbUrl;

	@MaxLength(value = 255, message = "会社名は255文字以下でご入力ください。")
	public String companyName;

	public void save() {
		Site site = new Site();
		site.title = this.title;
		site.url = this.url;
		site.category = this.category;
		site.company = this.company;
		site.save();
		this.siteId = site.siteId;
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
