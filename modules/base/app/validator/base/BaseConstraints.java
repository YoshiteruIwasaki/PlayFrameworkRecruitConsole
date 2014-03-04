package validator.base;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.Payload;

import org.apache.commons.validator.routines.UrlValidator;

import play.data.validation.Constraints;
import play.libs.F;
import play.libs.F.Tuple;

/**
 * Defines a set of built-in validation constraints.
 */
public class BaseConstraints extends Constraints {

	// --- Url

	/**
	 * Defines a url constraint for a string field.
	 */
	@Target({ FIELD })
	@Retention(RUNTIME)
	@Constraint(validatedBy = BaseUrlValidator.class)
	@play.data.Form.Display(name = "constraint.url", attributes = {})
	public static @interface Url {
		String message() default BaseUrlValidator.message;

		Class<?>[] groups() default {};

		Class<? extends Payload>[] payload() default {};
	}

	/**
	 * Validator for <code>@Url</code> fields.
	 */
	public static class BaseUrlValidator extends Validator<String> implements
			ConstraintValidator<Url, String> {

		final static public String message = "error.url";

		public BaseUrlValidator() {
		}

		public void initialize(Url constraintAnnotation) {
		}

		public boolean isValid(String object) {
			if (object == null || object.length() == 0) {
				return true;
			}
			UrlValidator urlValidator = new UrlValidator();
			return urlValidator.isValid(object);
		}

		public Tuple<String, Object[]> getErrorMessageKey() {
			return F.Tuple(message, new Object[] {});
		}

	}

	/**
	 * Constructs a 'url' validator.
	 */
	public static Validator<String> url() {
		return new BaseUrlValidator();
	}

}
