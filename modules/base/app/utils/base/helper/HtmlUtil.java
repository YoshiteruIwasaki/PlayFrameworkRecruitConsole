package utils.base.helper;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;

import play.mvc.Http.Request;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class HtmlUtil {

	public static String simpleTextSource(String string, Request request) {
		if (string == null) {
			return "";
		}

		string = escapeXML(string);

		string = replaceToAutoCR(string);
		return string;
	}

	public static String simpleHtmlSource(String string, Request request) {
		if (string == null) {
			return "";
		}

		String _string = escapeXML(string);
		_string = autoLink(_string, string);
		return _string;
	}

	public static String simpleHtmlRawSource(String string) {
		if (string == null) {
			return "";
		}
		String html = autoLink(string, string);
		return html;
	}

	public static String simpleMobileHtmlSource(String string, Request request) {
		if (string == null) {
			return "";
		}

		String html = autoLink(string, string);
		return html;
	}

	public static String escapeXML(String string) {
		return StringEscapeUtils.escapeXml(string);
	}

	public static String sanitize(String str) {
		return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}

	private static String autoLink(String string, String raw) {
		String str = "(?i)\\b((?:https?://|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\p{javaWhitespace}()<>]+|\\(([^\\p{javaWhitespace}()<>]+|(\\([^\\p{javaWhitespace}()<>]+\\)))*\\))+(?:\\(([^\\p{javaWhitespace}()<>]+|(\\([^\\p{javaWhitespace}()<>]+\\)))*\\)|[^\\p{javaWhitespace}`!()\\[\\]{};:\'\".,<>?«»“”‘’&]))";
		Pattern patt = Pattern.compile(str);
		Matcher matcher = patt.matcher(raw);
		String marked = string;
		StringBuilder buf = new StringBuilder();
		while (matcher.find()) {
			String matchedString = matcher.group(1);
			int index = marked.indexOf(matchedString) + matchedString.length();
			String head = marked.substring(0, index);
			buf.append(head.replace(matchedString,
					String.format("<_link_:%s>", matchedString)));
			marked = marked.substring(index);
		}
		marked = buf.append(marked).toString();

		matcher = patt.matcher(raw);
		// String linked = replaceToAutoCR(replaceNLToBR(marked));
		String linked = replaceNLToBR(marked);
		while (matcher.find()) {
			String matchedString = matcher.group(1);
			String mark = String.format("<_link_:%s>", matchedString);
			linked = linked.replace(mark, String.format(
					"<a href=\"%s\">%s</a>", matchedString, matchedString));
		}
		return linked;
	}

	private static String replaceToAutoCRString(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}

		return str;
	}

	private static String replaceToAutoCRChild(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}

		StringBuffer res = null;
		String head, body, tail;
		int findex = str.indexOf("&");
		int lindex = str.indexOf(";");
		if ((findex == -1) && (lindex == -1)) {
			return replaceToAutoCRString(str);
		} else if (lindex != -1 && (findex == -1 || findex > lindex)) {
			// ";"のみ含まれる場合
			head = str.substring(0, lindex);
			body = str.substring(lindex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceToAutoCRString(head));
			res.append(body);
			res.append(replaceToAutoCR(tail));
		} else if (findex != -1 && lindex == -1) {
			// "&"のみ含まれる場合
			head = str.substring(0, findex);
			body = str.substring(findex, findex + 1);
			tail = str.substring(findex + 1);
			res = new StringBuffer();
			res.append(replaceToAutoCRString(head));
			res.append(body);
			res.append(replaceToAutoCR(tail));
		} else {
			head = str.substring(0, findex);
			body = str.substring(findex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceToAutoCRString(head));
			res.append(body);
			res.append(replaceToAutoCR(tail));
		}

		return res.toString();
	}

	/**
	 * * 長いアルファベットのテキストを自動的に折り返すヘルパー
	 *
	 * @subpackage helper
	 * @param string
	 *            $text
	 * @param int $step
	 * @return string
	 */
	private static String replaceToAutoCR(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}

		StringBuffer res = null;
		String head, body, tail;
		int findex = str.indexOf("<");
		int lindex = str.indexOf(">");
		if ((findex == -1) && (lindex == -1)) {
			return replaceToAutoCRChild(str);
		} else if (findex == -1 || findex > lindex) {
			// ">"のみ含まれる場合
			head = str.substring(0, lindex);
			body = str.substring(lindex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceToAutoCRChild(head));
			res.append(body);
			res.append(replaceToAutoCR(tail));
		} else if (lindex == -1) {
			// "<"のみ含まれる場合
			head = str.substring(0, findex);
			body = str.substring(findex, findex + 1);
			tail = str.substring(findex + 1);
			res = new StringBuffer();
			res.append(replaceToAutoCRChild(head));
			res.append(body);
			res.append(replaceToAutoCR(tail));
		} else {
			head = str.substring(0, findex);
			body = str.substring(findex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceToAutoCRChild(head));
			res.append(body);
			res.append(replaceToAutoCR(tail));
		}

		return res.toString();
	}

	private static String replaceNLToBRString(String str) {
		return escapeXML(str).replaceAll("\r", "").replaceAll("\n", "<br/>")
				.replaceAll(" ", "&nbsp;").replaceAll("\t", "&nbsp;&nbsp;");
	}

	private static String replaceNLToBRChild(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}

		StringBuffer res = null;
		String head, body, tail;
		int findex = str.indexOf("&");
		int lindex = str.indexOf(";");
		if ((findex == -1) && (lindex == -1)) {
			return replaceNLToBRString(str);
		} else if (lindex != -1 && (findex == -1 || findex > lindex)) {
			// ";"のみ含まれる場合
			head = str.substring(0, lindex);
			body = str.substring(lindex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceNLToBRString(head));
			res.append(body);
			res.append(replaceNLToBR(tail));
		} else if (findex != -1 && lindex == -1) {
			// "&"のみ含まれる場合
			head = str.substring(0, findex);
			body = str.substring(findex, findex + 1);
			tail = str.substring(findex + 1);
			res = new StringBuffer();
			res.append(replaceNLToBRString(head));
			res.append(body);
			res.append(replaceNLToBR(tail));
		} else {
			head = str.substring(0, findex);
			body = str.substring(findex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceNLToBRString(head));
			res.append(body);
			res.append(replaceNLToBR(tail));
		}

		return res.toString();
	}

	/**
	 * * 長いアルファベットのテキストを自動的に折り返すヘルパー
	 *
	 * @subpackage helper
	 * @param string
	 *            $text
	 * @param int $step
	 * @return string
	 */
	private static String replaceNLToBR(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}

		StringBuffer res = null;
		String head, body, tail;
		int findex = str.indexOf("<");
		int lindex = str.indexOf(">");
		if ((findex == -1) && (lindex == -1)) {
			return replaceNLToBRChild(str);
		} else if (findex == -1 || findex > lindex) {
			// ">"のみ含まれる場合
			head = str.substring(0, lindex);
			body = str.substring(lindex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceNLToBRChild(head));
			res.append(body);
			res.append(replaceNLToBR(tail));
		} else if (lindex == -1) {
			// "<"のみ含まれる場合
			head = str.substring(0, findex);
			body = str.substring(findex, findex + 1);
			tail = str.substring(findex + 1);
			res = new StringBuffer();
			res.append(replaceNLToBRChild(head));
			res.append(body);
			res.append(replaceNLToBR(tail));
		} else {
			head = str.substring(0, findex);
			body = str.substring(findex, lindex + 1);
			tail = str.substring(lindex + 1);
			res = new StringBuffer();
			res.append(replaceNLToBRChild(head));
			res.append(body);
			res.append(replaceNLToBR(tail));
		}

		return res.toString();
	}

	public static JsonNode recursive(JsonNode node, Request request) {

		if (node.isArray()) {

		} else if (node.isValueNode()) {

		} else {

		}

		Iterator<Entry<String, JsonNode>> i = node.getFields();
		if (i == null) {

		}

		return null;
	}

}
