package services.bases;

import models.bases.Company;
import play.Logger;
import play.db.ebean.Model.Finder;

public class CompanyService {

	public static Finder<Long, Company> find = new Finder<Long, Company>(
			Long.class, Company.class);

	public static Company getCompany(Long CompanyId) {
		return find.byId(CompanyId);
	}

	public static Company getCompanyByName(String CompanyName) {
		try {
			return find.where().eq("title", CompanyName).findUnique();
		} catch (Exception e) {
			Logger.error("CompanyService.getCompanyByName", e);
		}
		return null;
	}

}
