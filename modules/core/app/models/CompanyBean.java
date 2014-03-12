package models;

import models.bases.Company;

public class CompanyBean extends Company {

	private static final long serialVersionUID = -8848680118627807080L;

	public void save() {
		Company company = new Company();
		company.title = this.title;
		company.save();
		this.companyId = company.companyId;
	}

	public Company getCompany() {
		return (Company) this;
	}

}
