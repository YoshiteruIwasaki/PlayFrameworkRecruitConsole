package components.crypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class CryptUtil {

	/**
	 * Define a hash type enumeration for strong-typing
	 */
	public enum HashType {
		MD5("MD5"), SHA1("SHA-1"), SHA256("SHA-256"), SHA512("SHA-512");
		private String algorithm;

		HashType(String algorithm) {
			this.algorithm = algorithm;
		}

		@Override
		public String toString() {
			return this.algorithm;
		}
	}

	/**
	 * Set-up MD5 as the default hashing algorithm
	 */
	private static final HashType DEFAULT_HASH_TYPE = HashType.MD5;

	static final char[] HEX_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * Sign a message using the application secret key (HMAC-SHA1)
	 */
	public static String sign(String message, String secret) throws Exception {
		return sign(message, secret.getBytes());
	}

	/**
	 * Sign a message with a key
	 *
	 * @param message
	 *            The message to sign
	 * @param key
	 *            The key to use
	 * @return The signed message (in hexadecimal)
	 * @throws java.lang.Exception
	 */
	public static String sign(String message, byte[] key) throws Exception {

		if (key.length == 0) {
			return message;
		}

		Mac mac = Mac.getInstance("HmacSHA512");
		SecretKeySpec signingKey = new SecretKeySpec(key, "HmacSHA512");
		mac.init(signingKey);
		byte[] messageBytes = message.getBytes("utf-8");
		byte[] result = mac.doFinal(messageBytes);
		int len = result.length;
		char[] hexChars = new char[len * 2];

		for (int charIndex = 0, startIndex = 0; charIndex < hexChars.length;) {
			int bite = result[startIndex++] & 0xff;
			hexChars[charIndex++] = HEX_CHARS[bite >> 4];
			hexChars[charIndex++] = HEX_CHARS[bite & 0xf];
		}
		return new String(hexChars);

	}

	/**
	 * Create a password hash using the default hashing algorithm
	 *
	 * @param input
	 *            The password
	 * @return The password hash
	 */
	public static String passwordHash(String input) {
		return passwordHash(input, DEFAULT_HASH_TYPE);
	}

	/**
	 * Create a password hash using specific hashing algorithm
	 *
	 * @param input
	 *            The password
	 * @param hashType
	 *            The hashing algorithm
	 * @return The password hash
	 */
	public static String passwordHash(String input, HashType hashType) {
		try {
			MessageDigest m = MessageDigest.getInstance(hashType.toString());
			byte[] out = m.digest(input.getBytes());
			return new String(Base64.encodeBase64(out));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Encrypt a String with the AES encryption standard using the application
	 * secret
	 *
	 * @param value
	 *            The String to encrypt
	 * @return An hexadecimal encrypted string
	 * @throws Exception
	 */
	public static String encryptAES(String value, String secret)
			throws Exception {
		return encryptAESLogic(value, secret.substring(0, 16));
	}

	/**
	 * Encrypt a String with the AES encryption standard. Private key must have
	 * a length of 16 bytes
	 *
	 * @param value
	 *            The String to encrypt
	 * @param privateKey
	 *            The key used to encrypt
	 * @return An hexadecimal encrypted string
	 * @throws NoSuchPaddingException
	 * @throws Exception
	 */
	public static String encryptAESLogic(String value, String privateKey)
			throws Exception {
		byte[] raw = privateKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		return byteToHexString(cipher.doFinal(value.getBytes()));
	}

	/**
	 * Decrypt a String with the AES encryption standard using the application
	 * secret
	 *
	 * @param value
	 *            An hexadecimal encrypted string
	 * @return The decrypted String
	 * @throws Exception
	 */
	public static String decryptAES(String value, String secret)
			throws Exception {
		return decryptAESLogic(value, secret.substring(0, 16));
	}

	/**
	 * Decrypt a String with the AES encryption standard. Private key must have
	 * a length of 16 bytes
	 *
	 * @param value
	 *            An hexadecimal encrypted string
	 * @param privateKey
	 *            The key used to encrypt
	 * @return The decrypted String
	 * @throws Exception
	 */
	public static String decryptAESLogic(String value, String privateKey)
			throws Exception {
		byte[] raw = privateKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		return new String(cipher.doFinal(hexStringToByte(value)));
	}

	/**
	 * Write a byte array as hexadecimal String.
	 */
	public static String byteToHexString(byte[] bytes) {
		return String.valueOf(Hex.encodeHex(bytes));
	}

	/**
	 * Transform an hexadecimal String to a byte array.
	 *
	 * @throws Exception
	 */
	public static byte[] hexStringToByte(String hexString) throws Exception {
		return Hex.decodeHex(hexString.toCharArray());
	}

	public static String createDigest(String source)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		byte[] data = source.getBytes();
		md.update(data);

		byte[] digest = md.digest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			int b = (0xFF & digest[i]);
			if (b < 16)
				sb.append("0");
			sb.append(Integer.toHexString(b));
		}
		return sb.toString();
	}

	public static String createSha1Digest(String source)
			throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-1");

		byte[] data = source.getBytes();
		md.update(data);

		byte[] digest = md.digest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digest.length; i++) {
			int b = (0xFF & digest[i]);
			if (b < 16)
				sb.append("0");
			sb.append(Integer.toHexString(b));
		}
		return sb.toString();
	}

	/**
	 * パスワードを生成します。
	 *
	 * @param string
	 *            $length
	 * @return string
	 */
	public static String makePassword(int length) {
		String ALLOWED_SYMBOLS = "23456789abcdeghkmnpqsuvxyz";
		ALLOWED_SYMBOLS += "ABCDEFGHJKLMNPQRSTUVWXYZ";
		String password = "";
		for (int i = 0; i < length; i++) {
			Random rnd = new Random();
			password += ALLOWED_SYMBOLS.charAt(rnd.nextInt(ALLOWED_SYMBOLS
					.length() - 1));
		}
		return password;
	}

}
