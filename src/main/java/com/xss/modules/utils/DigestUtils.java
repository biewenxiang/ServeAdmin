/**
 * MD5加密
 */
package com.xss.modules.utils;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

/**
 * 支持SHA-1/MD5消息摘要的工具类.
 *
 * 支持Hex与Base64两种编码方式.
 *
 * @author calvin
 */
public class DigestUtils {

	private static final String SHA1 = "SHA-1";
	private static final String MD5 = "MD5";

	// -- String Hash function --//
	/**
	 * 对输入字符串进行sha1散列, 返回Hex编码的结果.
	 */
	public static String sha1ToHex(String input) {
		byte[] digestResult = digest(input, SHA1);
		return EncodeUtils.hexEncode(digestResult);
	}

	/**
	 * 对输入的字符串进行md5加密，返回Hex编码的结果
	 *
	 * @param input
	 * @return
	 */
	public static String md5ToHex(String input) {
		byte[] digestResult = digest(input, MD5);
		return EncodeUtils.hexEncode(digestResult);
	}

//	/**
//	 * 对输入的字符串进行md5加密，返回Hex编码的结果
//	 * @author 张九怀
//	 * @email zjh1983314@163.com
//	 * @data 2013-3-25
//	 * @param input
//	 * @param key   statickey 里的 key必须保证有值，否则就是单个对象加密了。
//	 * @return
//	 */
//	public static String md5ToHex(String input,String key) {
//		byte[] digestResult = digest(input + StaticKeyCache.getStaticKey(key), MD5);
//		return EncodeUtils.hexEncode(digestResult);
//	}

	/**
	 * 对输入字符串进行sha1散列, 返回Base64编码的结果.
	 */
	public static String sha1ToBase64(String input) {
		byte[] digestResult = digest(input, SHA1);
		return EncodeUtils.base64Encode(digestResult);
	}

	/**
	 * 对输入字符串进行sha1散列, 返回Base64编码的URL安全的结果.
	 */
	public static String sha1ToBase64UrlSafe(String input) {
		byte[] digestResult = digest(input, SHA1);
		return EncodeUtils.base64UrlSafeEncode(digestResult);
	}

	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 */
	private static byte[] digest(String input, String algorithm) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			return messageDigest.digest(input.getBytes(Charset.forName("UTF-8")));
		} catch (GeneralSecurityException e) {
			throw new IllegalStateException("Security exception", e);
		}
	}

	// -- File Hash function --//
	/**
	 * 对文件进行md5散列,返回Hex编码结果.
	 */
	public static String md5ToHex(InputStream input) throws IOException {
		return digest(input, MD5);
	}

	/**
	 * 对文件进行sha1散列,返回Hex编码结果.
	 */
	public static String sha1ToHex(InputStream input) throws IOException {
		return digest(input, SHA1);
	}

	public static String randEncode(String str){
		Date dt = new Date();
		Random rand = new Random(dt.getTime());
		byte[] m_byteRand = new byte[8];
		int n = 0;
		while (n % 10 == 0) {
			n = rand.nextInt();
		}
		if (n < 0) {
			n = -n;
		}
		String strRand = String.valueOf(n);
		while (strRand.length() < 8) {
			strRand = "0" + strRand;
		}
		for (int i = 0; i < 8; i++) {
			m_byteRand[i] = strRand.getBytes()[i];
		}

		String strRandKey = new String(m_byteRand);
		String strResult = Bytes2Hex(RandEncode(str.getBytes(),m_byteRand));
		String strKey = Bytes2Hex(strRandKey.getBytes());
		return (strResult + strKey);
	}

	private static String Bytes2Hex(byte[] b) {
		String hs = "";
		String strtmp = "";
		for (int n = 0; n < b.length; n++) {
			strtmp = (Integer.toHexString(b[n] & 0xFF));
			if (strtmp.length() == 1) {
				hs = hs + "0" + strtmp;
			} else {
				hs = hs + strtmp;
			}
		}
		return hs.toUpperCase();
	}

	private static byte[] RandEncode(byte[] bySrc,byte[] m_byteRand) {
		byte[] byResult = bySrc;
		for (int n = 0; n < bySrc.length; n++) {
			byResult[n] += m_byteRand[m_byteRand.length - 1];
		}

		return byResult;
	}

	/**
	 * 对文件进行散列, 支持md5与sha1算法.
	 */
	private static String digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}

			return EncodeUtils.hexEncode(messageDigest.digest());

		} catch (GeneralSecurityException e) {
			throw new IllegalStateException("Security exception", e);
		}
	}
	/**
	 * 标准的读秀号加密
	 * @return
	 */
//	public static String md5ToDxid(String dxid){
//		return md5ToHex(dxid + StaticKeyCache.getStaticKey("detailmd5"));
//	}
//	//新版发现卡片页的加密
//	public static String detailParam(String dxid, int datatype, String ncxchannelname){
//		String param = "{\"dxid\":\""+dxid+"\",\"datatype\":\""+datatype+"\",\"d\":\""+md5ToDxid(dxid)+"\",\"ncxchannelname\":\""+ncxchannelname+"\"}";
//		return DESKey.encrypt(param, StaticKeyCache.getStaticKey("detaildes"));
//	}
//	//卡片页的加密
//	public static String detailParam(String dxid, int datatype){
//		String param = "{\"dxid\":\""+dxid+"\",\"datatype\":\""+datatype+"\",\"d\":\""+md5ToDxid(dxid)+"\"}";
//		return DESKey.encrypt(param, StaticKeyCache.getStaticKey("detaildes"));
//	}
//	//卡片页引文的加密
//	public static String detailYWParam(String dxid, String d){
//		String param = "{\"dxid\":\""+dxid+"\",\"d\":\""+d+"\"}";
//		return DESKey.encrypt(param, StaticKeyCache.getStaticKey("detaildes"));
//	}
//
//	/**
//	 * 引证接口的加密
//	 * @author byl
//	 */
//	public static String ctationParam(String dxid, String d,String channel,String type,String pubYear){
//		String param = "{\"dxid\":\""+dxid+"\",\"d\":\""+d+"\",\"channel\":\""+channel+"\",\"type\":\""+type+"\",\"year\":\""+pubYear+"\"}";
//		return DESKey.encrypt(param, StaticKeyCache.getStaticKey("detaildes"));
//	}
	/**
	 * 大雅引文加密
	 */
	public static String md5toFindRef(String dxid){
		return md5ToHex(dxid+TimeUtil.getFullDate()+"F012E4E687F074008EB0FAA7469D1F06").toUpperCase();
	}

}
