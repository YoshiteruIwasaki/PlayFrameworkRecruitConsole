package components.text;

public class TextUtil {
	public static int getInitial(String s) {
		if (s.startsWith("あ") || s.startsWith("い") || s.startsWith("う")
				|| s.startsWith("え") || s.startsWith("お")) {
			return 1;
		} else if (s.startsWith("か") || s.startsWith("き") || s.startsWith("く")
				|| s.startsWith("け") || s.startsWith("こ") || s.startsWith("が")
				|| s.startsWith("ぎ") || s.startsWith("ぐ") || s.startsWith("げ")
				|| s.startsWith("ご")) {
			return 2;
		} else if (s.startsWith("さ") || s.startsWith("し") || s.startsWith("す")
				|| s.startsWith("せ") || s.startsWith("そ") || s.startsWith("ざ")
				|| s.startsWith("じ") || s.startsWith("ず") || s.startsWith("ぜ")
				|| s.startsWith("ぞ")) {
			return 3;
		} else if (s.startsWith("た") || s.startsWith("ち") || s.startsWith("つ")
				|| s.startsWith("て") || s.startsWith("と") || s.startsWith("だ")
				|| s.startsWith("ぢ") || s.startsWith("づ") || s.startsWith("で")
				|| s.startsWith("ど")) {
			return 4;
		} else if (s.startsWith("な") || s.startsWith("に") || s.startsWith("ぬ")
				|| s.startsWith("ね") || s.startsWith("の")) {
			return 5;
		} else if (s.startsWith("は") || s.startsWith("ひ") || s.startsWith("ふ")
				|| s.startsWith("へ") || s.startsWith("ほ") || s.startsWith("ば")
				|| s.startsWith("び") || s.startsWith("ぶ") || s.startsWith("べ")
				|| s.startsWith("ぼ") || s.startsWith("ぱ") || s.startsWith("ぴ")
				|| s.startsWith("ぷ") || s.startsWith("ぺ") || s.startsWith("ぽ")) {
			return 6;
		} else if (s.startsWith("ま") || s.startsWith("み") || s.startsWith("む")
				|| s.startsWith("め") || s.startsWith("も")) {
			return 7;
		} else if (s.startsWith("や") || s.startsWith("ゆ") || s.startsWith("よ")) {
			return 8;
		} else if (s.startsWith("ら") || s.startsWith("り") || s.startsWith("る")
				|| s.startsWith("れ") || s.startsWith("ろ")) {
			return 9;
		} else if (s.startsWith("わ") || s.startsWith("を") || s.startsWith("ん")) {
			return 10;
		} else {
			return 0;
		}
	}

	public static final int KANA_INDEX_LENGTH = 10;

	public static String getInitialLabel(int initial) {
		switch (initial) {
		case (1):
			return "あ行";
		case (2):
			return "か行";
		case (3):
			return "さ行";
		case (4):
			return "た行";
		case (5):
			return "な行";
		case (6):
			return "は行";
		case (7):
			return "ま行";
		case (8):
			return "や行";
		case (9):
			return "ら行";
		case (10):
			return "わ行";
		default:
			return "その他";
		}
	}

	public static String formatInt(String format, String text) {
		try {
			return String.format(format, Integer.parseInt(text));
		} catch (Exception e) {
			return text;
		}
	}

	private static final char[] ZENKAKU_KATAKANA = { 'ァ', 'ア', 'ィ', 'イ', 'ゥ',
			'ウ', 'ェ', 'エ', 'ォ', 'オ', 'カ', 'ガ', 'キ', 'ギ', 'ク', 'グ', 'ケ', 'ゲ',
			'コ', 'ゴ', 'サ', 'ザ', 'シ', 'ジ', 'ス', 'ズ', 'セ', 'ゼ', 'ソ', 'ゾ', 'タ',
			'ダ', 'チ', 'ヂ', 'ッ', 'ツ', 'ヅ', 'テ', 'デ', 'ト', 'ド', 'ナ', 'ニ', 'ヌ',
			'ネ', 'ノ', 'ハ', 'バ', 'パ', 'ヒ', 'ビ', 'ピ', 'フ', 'ブ', 'プ', 'ヘ', 'ベ',
			'ペ', 'ホ', 'ボ', 'ポ', 'マ', 'ミ', 'ム', 'メ', 'モ', 'ャ', 'ヤ', 'ュ', 'ユ',
			'ョ', 'ヨ', 'ラ', 'リ', 'ル', 'レ', 'ロ', 'ヮ', 'ワ', 'ヰ', 'ヱ', 'ヲ', 'ン',
			'ヴ', 'ヵ', 'ヶ' };

	private static final String[] HANKAKU_KATAKANA = { "ｧ", "ｱ", "ｨ", "ｲ", "ｩ",
			"ｳ", "ｪ", "ｴ", "ｫ", "ｵ", "ｶ", "ｶﾞ", "ｷ", "ｷﾞ", "ｸ", "ｸﾞ", "ｹ",
			"ｹﾞ", "ｺ", "ｺﾞ", "ｻ", "ｻﾞ", "ｼ", "ｼﾞ", "ｽ", "ｽﾞ", "ｾ", "ｾﾞ", "ｿ",
			"ｿﾞ", "ﾀ", "ﾀﾞ", "ﾁ", "ﾁﾞ", "ｯ", "ﾂ", "ﾂﾞ", "ﾃ", "ﾃﾞ", "ﾄ", "ﾄﾞ",
			"ﾅ", "ﾆ", "ﾇ", "ﾈ", "ﾉ", "ﾊ", "ﾊﾞ", "ﾊﾟ", "ﾋ", "ﾋﾞ", "ﾋﾟ", "ﾌ",
			"ﾌﾞ", "ﾌﾟ", "ﾍ", "ﾍﾞ", "ﾍﾟ", "ﾎ", "ﾎﾞ", "ﾎﾟ", "ﾏ", "ﾐ", "ﾑ", "ﾒ",
			"ﾓ", "ｬ", "ﾔ", "ｭ", "ﾕ", "ｮ", "ﾖ", "ﾗ", "ﾘ", "ﾙ", "ﾚ", "ﾛ", "ﾜ",
			"ﾜ", "ｲ", "ｴ", "ｦ", "ﾝ", "ｳﾞ", "ｶ", "ｹ" };

	private static final char ZENKAKU_KATAKANA_FIRST_CHAR = ZENKAKU_KATAKANA[0];

	private static final char ZENKAKU_KATAKANA_LAST_CHAR = ZENKAKU_KATAKANA[ZENKAKU_KATAKANA.length - 1];

	public static String toHankakuKana(char c) {
		if (c >= ZENKAKU_KATAKANA_FIRST_CHAR && c <= ZENKAKU_KATAKANA_LAST_CHAR) {
			return HANKAKU_KATAKANA[c - ZENKAKU_KATAKANA_FIRST_CHAR];
		} else {
			return String.valueOf(c);
		}
	}

	public static String toHankakuKana(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char originalChar = s.charAt(i);
			String convertedChar = toHankakuKana(originalChar);
			sb.append(convertedChar);
		}
		return sb.toString();

	}
}
