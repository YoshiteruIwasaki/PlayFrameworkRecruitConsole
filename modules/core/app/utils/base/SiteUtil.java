package utils.base;

public class SiteUtil {

	public static String getCompanyName(String title) {
		String[] array = title.split(" |¥|");
		if (array.length > 0) {
			return array[array.length - 1];
		}
		return "";
	}
}
