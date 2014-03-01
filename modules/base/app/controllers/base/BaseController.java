package controllers.base;

import java.util.Map;

import play.Logger;
import play.api.mvc.Codec;
import play.core.j.JavaResults;
import play.mvc.Controller;
import utils.base.ControllersUtil;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class BaseController extends Controller {

	protected static String asString(String key) {
		try {
			String[] values = request().queryString().get(key);
			String value = ((values != null) && values.length > 0) ? values[0]
					: null;
			if (value == null) {
				Map<String, String[]> formMap = request().body()
						.asFormUrlEncoded();
				if (formMap != null) {
					String[] values2 = formMap.get(key);
					value = ((values2 != null) && values2.length > 0) ? values2[0]
							: null;
				}
			}
			return value;
		} catch (Exception e) {
			Logger.error("[BaseController.asString]", e);
		}
		return null;
	}

	public static Status ok(JsonNode jsonnode) {
		return new Status(JavaResults.Ok(), jsonnode,
				Codec.javaSupported(ControllersUtil.DEFAULT_ENCODE));
	}
}