package components.file;

public class FileUtil {

	public static final String FOLDER_TMP_FOR_ATTACHMENT_FILES = "tmp";

	public static String getFilePath(String uid, String dir) {
		return new StringBuilder(dir).append("/").append(uid).toString();
	}

	public static String getTmpFilePath(String dir) {
		return new StringBuilder(FOLDER_TMP_FOR_ATTACHMENT_FILES).append("/")
				.append(dir).toString();
	}
}
