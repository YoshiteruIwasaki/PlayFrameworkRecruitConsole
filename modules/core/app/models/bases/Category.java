package models.bases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity
public class Category extends Model {

	private static final long serialVersionUID = 3890695880010099962L;

	@Id
	public Long categoryId;

	@Required(message = "カテゴリ名をご入力ください。")
	@Column(nullable = false)
	@MaxLength(value = 255, message = "カテゴリ名は255文字以下でご入力ください。")
	public String title;

	@Column(nullable = false, unique = true)
	public int sortOrder;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	public List<Site> siteList = new ArrayList<Site>();
}
