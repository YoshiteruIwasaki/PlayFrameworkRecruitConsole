package utils.base;

public class SiteUtil {

	private static final String COMPANY_IDENTIFIER = "会社";

	public static String getCompanyName(String title) {
		String string = title.replaceAll("｜", " ");
		string = string.replaceAll("\\|", " ");
		string = string.replaceAll("：", " ");
		string = string.replaceAll(":", " ");
		string = string.replaceAll("\\-", " ");
		string = string.replaceAll("\\/", " ");

		String[] array = string.split(" ");
		if (array.length > 0) {
			for (String word : array) {
				if (word.indexOf(COMPANY_IDENTIFIER) != -1) {
					return word;
				}
			}

			return array[array.length - 1];
		}
		return "";
	}
}
