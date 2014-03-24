package models.bases;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import com.avaje.ebean.annotation.CreatedTimestamp;

@Entity
public class TagSiteMap extends Model {

	private static final long serialVersionUID = 3890695880010099962L;

	@Id
	public Long mapId;

	@Required(message = "タグを選択してください。")
	@ManyToOne
	@JoinColumn(name = "tag_id", nullable = false)
	public Tag tag;

	@Required(message = "サイトを選択してください。")
	@ManyToOne
	@JoinColumn(name = "site_id", nullable = false)
	public Site site;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;

}
