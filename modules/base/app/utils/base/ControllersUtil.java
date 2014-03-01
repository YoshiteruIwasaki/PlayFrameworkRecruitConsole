package utils.base;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import play.Logger;
import play.mvc.Call;
import play.mvc.Http.Context;
import play.mvc.Http.Request;

import com.fasterxml.jackson.databind.JsonNode;
import components.encode.Encode;

public class ControllersUtil {

	public static final String DEFAULT_ENCODE = "UTF-8";

	public static final String SJIS_ENCODE = "windows-31j";

	public static final String SJIS_CHARSET = "Shift_JIS";

	public static int getCurrentPage() {
		int num = 0;
		String[] page = getRequest().queryString().get("page");
		if (page != null && page.length > 0) {
			try {
				num = Integer.parseInt(page[0]);
			} catch (NumberFormatException e) {
				Logger.error(e.toString(), e);
			}
		}
		return num;
	}

	public static String getParam(String param) {
		return getParam(param, "");
	}

	public static String getParam(String param, String defaultParam) {
		String result = defaultParam;

		String postParam = getPostParam(param);
		if (postParam != null && postParam.length() > 0) {
			result = postParam;
		}

		String getParam = getGetParam(param);
		if (getParam != null && getParam.length() > 0) {
			result = getParam;
		}
		return result;
	}

	public static String getPostParam(String param) {
		return getPostParam(param, "");
	}

	public static String getPostParam(String param, String defaultParam) {
		String result = defaultParam;

		if (getRequest().body().asFormUrlEncoded() != null) {
			String[] postParams = getRequest().body().asFormUrlEncoded()
					.get(param);
			if (postParams != null && postParams.length > 0) {
				result = postParams[0];
				try {
					result = Encode.sjisToUtf8(result);
				} catch (UnsupportedEncodingException e) {
					Logger.error("[ControllersUtil.getPostParam]", e);
				}
			}
		}

		return result;
	}

	public static String getGetParam(String param) {
		return getGetParam(param, "");
	}

	public static String getGetParam(String param, String defaultParam) {
		String result = defaultParam;
		String[] getParams = getRequest().queryString().get(param);
		if (getParams != null && getParams.length > 0) {
			result = getParams[0];
			try {
				result = Encode.sjisToUtf8(result);
			} catch (UnsupportedEncodingException e) {
				Logger.error("[ControllersUtil.getGetParam]", e);
			}
		}
		return result;
	}

	public static String[] getPostParams(String param) {
		String[] array = { "" };
		return getPostParams(param, array);
	}

	public static String[] getPostParams(String param, String[] defaultparams) {
		String[] result = defaultparams;

		if (getRequest().body().asFormUrlEncoded() != null) {
			String[] postParams = getRequest().body().asFormUrlEncoded()
					.get(param);
			if (postParams != null && postParams.length > 0) {
				try {
					result = Encode.sjisToUtf8(postParams);
				} catch (UnsupportedEncodingException e) {
					Logger.error("[ControllersUtil.getPostParams]", e);
				}
			}
		}

		return result;
	}

	public static Request getRequest() {
		return Context.current().request();
	}

	public static String getJsonParam(String param) {
		return getJsonParam(param, "");
	}

	public static String getJsonParam(String param, String defaultParam) {
		String result = defaultParam;
		if (getRequest().body().asJson() != null) {
			JsonNode tmp = getRequest().body().asJson().get(param);
			if (tmp != null) {
				result = getRequest().body().asJson().get(param).asText();
			}
		}

		return result;
	}

	public static String getParamIncludeJson(String param, String defaultParam) {
		String result = getParam(param);
		if (result != null && !result.isEmpty()) {
			return result;
		}
		result = getJsonParam(param);
		if (result != null && !result.isEmpty()) {
			return result;
		}
		return defaultParam;
	}

	public static String getParamIncludeJson(String param) {
		return getParamIncludeJson(param, "");
	}

	public static Map<String, String> getParameterMap(byte[] bytea)
			throws Exception {
		Map<String, String> map = new HashMap<String, String>();

		String rawstr = new String(bytea, SJIS_ENCODE);
		String[] ampsplit = rawstr.split("&");

		for (String str : ampsplit) {
			String[] params = str.split("=");
			String value = "";
			if (params.length > 1 && (params[1] != null)
					&& (params[1].length() > 0)) {
				value = URLDecoder.decode(params[1], SJIS_ENCODE);
			}
			map.put(params[0], value);
		}

		return map;
	}

	public static String getAbsoluteUrl(Call route, Request request) {

		return route.absoluteURL(request);
	}

	public static Boolean isProduction() {
		return true;
	}

}
