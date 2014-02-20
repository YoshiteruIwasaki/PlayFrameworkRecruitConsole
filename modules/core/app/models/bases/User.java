package models.bases;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.MinLength;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.validation.NotNull;

@Entity
public class User extends Model {

	private static final long serialVersionUID = 3890695880010099962L;

	@Id
	public Long userId;

	@Email(message = "正しいメールアドレスを入力して下さい。")
	@Required(message = "メールアドレスをご入力ください。")
	@MaxLength(value = 190, message = "メールアドレスは190文字以内でご入力ください。")
	@Column(unique = true,columnDefinition = "varchar(191)")
	public String email;

	@Required(message = "パスワードをご入力ください。")
	@MinLength(value = 4, message = "パスワードは4文字以上でご入力ください。")
	public String password;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;
}
