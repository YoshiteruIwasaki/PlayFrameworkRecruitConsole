package components.httpclient;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;

public class HttpClient {

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
}
