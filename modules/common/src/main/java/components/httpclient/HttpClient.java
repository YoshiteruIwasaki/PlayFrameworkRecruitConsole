package components.httpclient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

import org.apache.commons.validator.routines.UrlValidator;
import org.cyberneko.html.parsers.DOMParser;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class HttpClient {

	public static final String USER_AGENT = "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0; Avant Browser)";

	public static final String ACCEPT_ENCODING = "identity";

	private static final String DEFAULT_ENCODE = "UTF-8";

	private static final int CONNECT_TIMEOUT = 10000;

	public static byte[] getImageBibary(String string) throws Exception {
		URL url = new URL(string);
		URLConnection con = url.openConnection();
		con.setConnectTimeout(CONNECT_TIMEOUT);
		con.setUseCaches(false);
		con.addRequestProperty("_", UUID.randomUUID().toString());

		int length = con.getContentLength();
		if (length <= 0) {
			return null;
		}
		byte[] data = new byte[length];
		BufferedInputStream in = new BufferedInputStream(con.getInputStream());
		int offset = 0;
		int bytes = 0;
		while (offset < length
				&& (bytes = in.read(data, offset, length - offset)) != -1) {
			offset += bytes;
		}
		in.close();

		return data;
	}

	public static String perseTitleFromUrl(String url) throws Exception {
		Document document = getDocument(url);
		String title = "";
		if (document != null) {
			NodeList nodeListTitle = document.getElementsByTagName("title");
			for (int i = 0; i < nodeListTitle.getLength(); i++) {
				Element element = (Element) nodeListTitle.item(i);
				title = element.getFirstChild().getNodeValue();
			}
			return title;
		} else {
			return "";
		}
	}

	public static Document getDocument(String string) {
		return getDocument(string, "JISAutoDetect");
	}

	public static Document getDocument(String string, String defaultCharset) {
		DOMParser parser = new DOMParser();
		try {
			URL url = new URL(string);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(CONNECT_TIMEOUT);
			con.setUseCaches(false);
			con.addRequestProperty("_", UUID.randomUUID().toString());
			con.addRequestProperty("User-Agent", USER_AGENT);
			con.addRequestProperty("Accept-Encoding", ACCEPT_ENCODING);

			String contentType = con.getContentType();
			if (contentType == null) {
				return null;
			}
			String charsetSearch = contentType.replaceFirst(
					"(?i).*charset=(.*)", "$1");
			String contentTypeCharset = con.getContentEncoding();
			BufferedReader reader = null;
			if (!contentType.equals(charsetSearch)) {
				contentTypeCharset = charsetSearch;
			}
			if (contentTypeCharset == null) {
				reader = new BufferedReader(new InputStreamReader(
						con.getInputStream(), defaultCharset));
			} else {
				reader = new BufferedReader(new InputStreamReader(
						con.getInputStream(), contentTypeCharset));
			}

			InputSource source = new InputSource(reader);
			parser.setFeature("http://xml.org/sax/features/namespaces", false);
			parser.parse(source);

			Document document = parser.getDocument();
			String metaTagCharset = getMetaTagCharset(document);
			if (metaTagCharset != null
					&& !metaTagCharset.equals(contentTypeCharset)) {

				HttpURLConnection reconnection = (HttpURLConnection) url
						.openConnection();
				reconnection.setConnectTimeout(CONNECT_TIMEOUT);
				reconnection.setUseCaches(false);
				reconnection.addRequestProperty("_", UUID.randomUUID()
						.toString());
				reconnection.addRequestProperty("User-Agent", USER_AGENT);
				reconnection.addRequestProperty("Accept-Encoding",
						ACCEPT_ENCODING);

				reader = new BufferedReader(new InputStreamReader(
						reconnection.getInputStream(), metaTagCharset));
				source = new InputSource(reader);
				parser.setFeature("http://xml.org/sax/features/namespaces",
						false);
				parser.parse(source);
				document = parser.getDocument();
			}

			reader.close();
			return document;
		} catch (DOMException e) {
			if (!DEFAULT_ENCODE.equals(defaultCharset)) {
				return getDocument(string, DEFAULT_ENCODE);
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	public static String getMetaTagCharset(Document document) {
		String charset = null;
		NodeList metaList = document.getElementsByTagName("meta");
		for (int i = 0; i < metaList.getLength(); i++) {
			Element element = (Element) metaList.item(i);
			String src = element.getAttribute("content");
			if (src != null && src.contains("charset=")) {
				charset = src.replaceFirst("(?i).*charset=(.*)", "$1");
				break;
			}
			src = element.getAttribute("charset");
			if (src != null && !src.equals("")) {
				charset = src;
				break;
			}
		}
		return charset;
	}

	public static boolean isValidUrl(String object) {
		if (object == null || object.length() == 0) {
			return true;
		}
		UrlValidator urlValidator = new UrlValidator();
		return urlValidator.isValid(object);
	}

}
