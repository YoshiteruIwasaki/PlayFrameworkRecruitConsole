package components.encode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decode {

	public static String decodeHtml(String str) {
		Pattern pattern = Pattern.compile("&#(\\d+);|&#([\\da-fA-F]+);");
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		Character buf;
		while (matcher.find()) {
			if (matcher.group(1) != null) {
				buf = new Character((char) Integer.parseInt(matcher.group(1)));
			} else {
				buf = new Character((char) Integer.parseInt(matcher.group(2),
						16));
			}
			matcher.appendReplacement(sb, buf.toString());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}}
