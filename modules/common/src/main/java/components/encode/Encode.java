package components.encode;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Encode {

	private static final String DEFAULT_ENCODE = "UTF-8";

	private static final String SJIS_ENCODE = "Shift_JIS";

	/**
	 * 引数の文字列(Shift_JIS)を、UTF-8にエンコードする。
	 *
	 * @param value
	 *            変換対象の文字列
	 * @return エンコードされた文字列
	 * @throws UnsupportedEncodingException
	 */
	public static String sjisToUtf8(String value)
			throws UnsupportedEncodingException {

		try {
			byte[] srcStream = value.getBytes(SJIS_ENCODE);
			byte[] destStream = (new String(srcStream, SJIS_ENCODE))
					.getBytes(DEFAULT_ENCODE);
			value = new String(destStream, DEFAULT_ENCODE);
			value = convert(value, SJIS_ENCODE, DEFAULT_ENCODE);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException(e.getMessage());

		}
		return value;
	}

	public static String[] sjisToUtf8(String[] values)
			throws UnsupportedEncodingException {
		List<String> list = new ArrayList<String>(values.length);
		for (String value : values) {
			list.add(sjisToUtf8(value));
		}
		return list.toArray(new String[list.size()]);
	}

	/**
	 * 引数の文字列(UTF-8)を、Shift_JISにエンコードする。
	 *
	 * @param value
	 *            変換対象の文字列
	 * @return エンコードされた文字列
	 * @throws UnsupportedEncodingException
	 */
	public static String utf8ToSjis(String value)
			throws UnsupportedEncodingException {
		try {
			byte[] srcStream = value.getBytes(DEFAULT_ENCODE);
			value = convert(new String(srcStream, DEFAULT_ENCODE),
					DEFAULT_ENCODE, SJIS_ENCODE);
			byte[] destStream = value.getBytes(SJIS_ENCODE);
			value = new String(destStream, SJIS_ENCODE);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedEncodingException(e.getMessage());

		}
		return value;
	}

	/**
	 * 引数の文字列を、エンコードする。
	 *
	 * @param value
	 *            変換対象の文字列
	 * @param src
	 *            変換前の文字コード
	 * @param dest
	 *            変換後の文字コード
	 * @return エンコードされた文字列
	 */
	private static String convert(String value, String src, String dest) {
		Map<String, String> conversion = createConversionMap(src, dest);
		char oldChar;
		char newChar;
		String key;
		for (Iterator<String> itr = conversion.keySet().iterator(); itr
				.hasNext();) {
			key = itr.next();
			oldChar = toChar(key);
			newChar = toChar(conversion.get(key));
			value = value.replace(oldChar, newChar);
		}
		return value;
	}

	/**
	 * エンコード情報を作成する
	 *
	 * @param src
	 *            変換前の文字コード
	 * @param dest
	 *            変換後の文字コード
	 * @return エンコードされた文字列
	 */
	private static Map<String, String> createConversionMap(String src,
			String dest) {

		Map<String, String> conversion = new HashMap<String, String>();
		if ((src.equals(DEFAULT_ENCODE)) && (dest.equals(SJIS_ENCODE))) {
			// －（全角マイナス）
			conversion.put("U+FF0D", "U+2212");
			// ～（全角チルダ）
			conversion.put("U+FF5E", "U+301C");
			// ￠（セント）
			conversion.put("U+FFE0", "U+00A2");
			// ￡（ポンド）
			conversion.put("U+FFE1", "U+00A3");
			// ￢（ノット）
			conversion.put("U+FFE2", "U+00AC");
			// ―（全角マイナスより少し幅のある文字）
			conversion.put("U+2015", "U+2014");
			// ∥（半角パイプが2つ並んだような文字）
			conversion.put("U+2225", "U+2016");

		} else if ((src.equals(SJIS_ENCODE)) && (dest.equals(DEFAULT_ENCODE))) {
			// －（全角マイナス）
			conversion.put("U+2212", "U+FF0D");
			// ～（全角チルダ）
			conversion.put("U+301C", "U+FF5E");
			// ￠（セント）
			conversion.put("U+00A2", "U+FFE0");
			// ￡（ポンド）
			conversion.put("U+00A3", "U+FFE1");
			// ￢（ノット）
			conversion.put("U+00AC", "U+FFE2");
			// ―（全角マイナスより少し幅のある文字）
			conversion.put("U+2014", "U+2015");
			// ∥（半角パイプが2つ並んだような文字）
			conversion.put("U+2016", "U+2225");

		}
		return conversion;
	}

	/**
	 * 16進表記の文字を取得する。
	 *
	 * @param value
	 *            変換対象の文字列
	 * @return 16進表記の文字
	 */
	private static char toChar(String value) {
		return (char) Integer.parseInt(value.trim().substring("U+".length()),
				16);
	}
}
