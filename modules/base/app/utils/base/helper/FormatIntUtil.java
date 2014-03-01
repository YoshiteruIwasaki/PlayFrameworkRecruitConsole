package utils.base.helper;

public class FormatIntUtil {

	public static String formatInt(String format, String text) {
		try {
			return String.format(format, Integer.parseInt(text));
		} catch (Exception e) {
			return text;
		}
	}
}
