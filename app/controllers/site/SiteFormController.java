package controllers.site;

import models.beans.SiteBean;
import play.data.Form;
import play.mvc.Result;
import controllers.base.BaseController;

public class SiteFormController extends BaseController {

	public static Result register() {
		Form<SiteBean> siteForm = Form.form(SiteBean.class);
		return ok(views.html.site.register.render(siteForm, false));
	}

	public static Result confirm() {
		Form<SiteBean> siteForm = Form.form(SiteBean.class).bindFromRequest();
		if (siteForm.hasErrors()) {
			return ok(views.html.site.register.render(siteForm, true));
		}
		return ok(views.html.site.confirm.render(siteForm));
	}

	public static Result submit() {
		Form<SiteBean> siteForm = Form.form(SiteBean.class).bindFromRequest();
		if (siteForm.hasErrors()) {
			return ok(views.html.site.register.render(siteForm, true));
		} else {
			SiteBean bean = siteForm.get();
			bean.save();
			return redirect(controllers.site.routes.SiteFormController.success());
		}
	}

	public static Result success() {
		return ok(views.html.site.success.render(""));
	}
}
