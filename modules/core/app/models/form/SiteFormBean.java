package models.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.bases.Site;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import services.SiteBeanService;
import validator.base.unique.Unique;

@Unique(modelClass = SiteFormBean.class, fields = { "url" }, message = "すでに同じURLが登録されています。")
public class SiteFormBean extends Site {

	private static final long serialVersionUID = -8848680118627807080L;

	@Required(message = "会社名を入力してください。")
	@MaxLength(value = 255, message = "会社名は255文字以下でご入力ください。")
	public String companyName;

	public boolean isNew;

	public Map<String, List<ValidationError>> validate() {
		Map<String, List<ValidationError>> errors = null;
		if (isNew && SiteBeanService.hasSameSiteBeanByUrl(url)) {
			errors = new HashMap<String, List<ValidationError>>();
			List<ValidationError> lists = new ArrayList<ValidationError>();
			lists.add(new ValidationError("url", "すでに同じURLが登録されています。",
					new ArrayList<Object>()));
			errors.put("url", lists);
		}
		return errors;
	}

	public String tagList;

}
