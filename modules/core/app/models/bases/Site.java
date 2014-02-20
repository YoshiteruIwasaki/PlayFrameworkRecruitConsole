package models.bases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.validation.NotNull;

@Entity
public class Site extends Model {

	private static final long serialVersionUID = 3890695880010099962L;

	@Id
	public Long siteId;

	@Required
	@NotNull
	public String title;

	@Required
	@NotNull
	@Lob
	public String url;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;
}
