package services;

import models.CompanyBean;
import models.bases.Company;
import services.bases.CompanyService;

public class CompanyBeanService extends CompanyService {

	public static CompanyBean getCompanyBean(Long CompanyId) {
		Company Company = getCompany(CompanyId);
		if (Company != null) {
			CompanyBean CompanyBean = new CompanyBean();
			CompanyBean = setCompanyBean(Company);
			return CompanyBean;
		}
		return null;
	}

	public static CompanyBean getCompanyBeanByName(String CompanyName) {
		Company Company = getCompanyByName(CompanyName);
		if (Company != null) {
			CompanyBean CompanyBean = new CompanyBean();
			CompanyBean = setCompanyBean(Company);
			return CompanyBean;
		}
		return null;
	}

	private static CompanyBean setCompanyBean(Company Company) {
		CompanyBean bean = new CompanyBean();
		bean.companyId = Company.companyId;
		bean.title = Company.title;
		bean.createDate = Company.createDate;
		bean.updateDate = Company.updateDate;
		return bean;
	}

}
