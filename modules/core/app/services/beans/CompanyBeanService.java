package services.beans;

import models.bases.Company;
import models.beans.CompanyBean;
import services.bases.CompanyService;

public class CompanyBeanService extends CompanyService {

	public static CompanyBean getCompanyBean(Long CompanyId) {
		Company Company = getCompany(CompanyId);
		CompanyBean CompanyBean = new CompanyBean();
		if (Company != null) {
			CompanyBean = setCompanyBean(Company);
		}
		return CompanyBean;
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
