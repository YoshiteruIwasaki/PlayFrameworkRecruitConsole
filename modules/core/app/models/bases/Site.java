package models.bases;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import validator.base.BaseConstraints.Url;
import validator.base.unique.Unique;

import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity
@Unique(modelClass = Site.class, fields = { "url" }, message = "すでに同じURLが登録されています。")
public class Site extends Model {

	private static final long serialVersionUID = 3890695880010099962L;

	@Id
	public Long siteId;

	@Required(message = "タイトルをご入力ください。")
	@Column(nullable = false)
	@MaxLength(value = 255, message = "タイトルは255文字以下でご入力ください。")
	public String title;

	@Required(message = "URLをご入力ください。")
	@Url(message = "URLをご入力ください。")
	@Column(nullable = false, unique = true, columnDefinition = "varchar(191)")
	@MaxLength(value = 191, message = "URLは191文字以下でご入力ください。")
	public String url;

	@Required(message = "業種を選択してください。")
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	public Category category;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = true)
	public Company company;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;
}
