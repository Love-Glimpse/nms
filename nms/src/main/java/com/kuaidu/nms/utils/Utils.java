package com.kuaidu.nms.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import com.kuaidu.nms.config.Config;
import com.kuaidu.nms.entity.ChapterList;
import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.ReplaceConfig;
import com.kuaidu.nms.entity.SpiderConfig;
import com.kuaidu.nms.entity.Sys_user;
import com.kuaidu.nms.spider.down.DownChapterSpider;
import com.kuaidu.nms.spider.down.DownChapterSpider.ChapterNamesAndUrls;

import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.utils.HttpConstant;

public class Utils {
	/** 汉字转数字 */
/*	public static int chineseToNumber(String str) {
		String str1 = new String();
		String str2 = new String();
		String str3 = new String();
		String str4 = str;
		int k = 0;
		boolean dealflag = true;
		for (int i = 0; i < str.length(); i++) {// 先把字符串中的“零”除去
			if ('零' == (str.charAt(i))) {
				str = str.substring(0, i) + str.substring(i + 1);
			}
		}

		for (int i = 0; i < str.length(); i++) {// 去掉非数字字符
			Boolean isChineseNum = false;
			char tempChar = str.charAt(i);

			for (int j = 0; j < NumTools.chnNumChineseAndUnits.length; j++) {
				if (NumTools.chnNumChineseAndUnits[j] == tempChar) {
					isChineseNum = true;
					break;
				}
			}
			if (!isChineseNum) {
				str4 = str4.replace(String.valueOf(tempChar), "");
			}

		}
		if (str == null || str.length() < 1) {
			return 0;
		}
		String chineseNum = str4;
		for (int i = 0; i < chineseNum.length(); i++) {
			if (chineseNum.charAt(i) == '亿') {
				str1 = chineseNum.substring(0, i);// 截取亿前面的数字，逐个对照表格，然后转换
				k = i + 1;
				dealflag = false;// 已经处理
			}
			if (chineseNum.charAt(i) == '万') {
				str2 = chineseNum.substring(k, i);
				str3 = str4.substring(i + 1);
				dealflag = false;// 已经处理
			}
		}
		if (dealflag) {// 如果没有处理
			str3 = chineseNum;
		}
		int result = sectionChinese(str1) * 100000000 + sectionChinese(str2) * 10000 + sectionChinese(str3);
		return result;
	}
	public static int sectionChinese(String str) {
		int value = 0;
		int sectionNum = 1;
		for (int i = 0; i < str.length(); i++) {
			int v = (int) NumTools.intList.get(str.charAt(i));
			if (v == 10 || v == 100 || v == 1000) {// 如果数值是权位则相乘
				sectionNum = v * sectionNum;
				value = value + sectionNum;
			} else if (i == str.length() - 1) {
				value = value + v;
			} else {
				sectionNum = v;
			}
		}
		return value;
	}*/

	/** 修正小说内容 **/
	/*public static String fixNovelContent(String content, String bookName) {
		try {
			content = content.substring(content.indexOf("m.biqu.la") + 10, content.lastIndexOf(bookName))
					.replace("<br>", System.getProperty("line.separator")).replace("&nbsp;", " ").replace("笔趣阁", "快读网");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			content.replace("buqu.la", "kuaidu.la");
		}
		return content;
	}*/

	/*** 去掉章节名称到特殊HTML字符 **/
	public static String replace(String content, List<ReplaceConfig> replaces) {
		try {
			String line = System.getProperty("line.separator");
			// <p>段落替换为换行
			content = content.replaceAll("<\\s*/?[p|P][^>]*>", line)
			// <br><br/>替换为换行
			.replaceAll("<br\\s*/?>", line)
			// 去掉其它的<>之间的东西
			.replaceAll("\\<.*?>", "")
			// 去掉 \r
			.replaceAll("\r", "")
			// \n 替换成\r\n
			.replaceAll("\n", line)
			.replaceAll(line + "\\s+" + line + "\\s+" + line, line);

			if (replaces != null) {
				for (ReplaceConfig replace : replaces) {
					content = content.replaceAll(replace.getTarget(), replace.getReplacement());
				}
			}

			if (!content.trim().contains(line)) {
				// 没有换行的用3-4个空格后加换行
				content = content.replaceAll("\\s+", line + "    ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content.trim();
	}
	
	/**
	 * 解析出url请求的路径，包括页面
	 * 
	 * @param strURL
	 *            url地址
	 * @return url路径
	 */
	public static String UrlPage(String strURL) {
		String strPage = null;
		String[] arrSplit = null;

		strURL = strURL.trim().toLowerCase();

		arrSplit = strURL.split("[?]");
		if (strURL.length() > 0) {
			if (arrSplit.length > 1) {
				if (arrSplit[0] != null) {
					strPage = arrSplit[0];
				}
			}
		}

		return strPage;
	}

	/**
	 * 去掉url中的路径，留下请求参数部分
	 * 
	 * @param strURL
	 *            url地址
	 * @return url请求参数部分
	 */
	private static String TruncateUrlPage(String strURL) {
		String strAllParam = null;
		String[] arrSplit = null;

		strURL = strURL.trim().toLowerCase();

		arrSplit = strURL.split("[?]");
		if (strURL.length() > 1) {
			if (arrSplit.length > 1) {
				if (arrSplit[1] != null) {
					strAllParam = arrSplit[1];
				}
			}
		}

		return strAllParam;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	 * 
	 * @param URL
	 *            url地址
	 * @return url请求参数部分
	 */
	public static Map<String, String> URLRequest(String URL) {
		Map<String, String> mapRequest = new HashMap<String, String>();

		String[] arrSplit = null;

		String strUrlParam = TruncateUrlPage(URL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组
		arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");

			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	 * 
	 * @param URL
	 *            url地址
	 * @return url请求参数部分
	 */
	public static Map<String, Object> URLRequest2(String URL) {
		Map<String, Object> mapRequest = new HashMap<String, Object>();

		String[] arrSplit = null;

		String strUrlParam = TruncateUrlPage(URL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组
		arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");

			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

	/**
	 * 正则表达式校验url
	 * 
	 * @return 匹配成功返回true 否则返回false;
	 */
	public static boolean IsUrl(String url) {
		String RULE_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
		Pattern p = Pattern.compile(RULE_URL);
		// 正则表达式的匹配器
		Matcher m = p.matcher(url);
		// 进行正则匹配.
		return m.matches();
	}

	/** MD5加密 */
	public static String MD5(String key, int length) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] btInput = key.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			if (length == 16) {
				return new String(str).substring(8, 24);
			} else {
				return new String(str);
			}
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param path
	 *            保存路径
	 * @param content
	 *            byte 保存文件内容
	 **/
	public static Boolean saveFile(String path, byte[] content) {
		try {
			File file = new File(path);// 小说内容保存地址
			File fileParent = file.getParentFile();
			if (!fileParent.exists()) {
				fileParent.mkdirs();
			}
			file.createNewFile();
			@SuppressWarnings("resource")
			FileOutputStream op = new FileOutputStream(file);
			op.write(content);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 保存文件
	 * 
	 * @param path
	 *            保存路径
	 * @param content
	 *            保存文件内容
	 **/
	public static Boolean writeToFile(String path, String content) {
		File fout = new File(path); // 创建文件输出对象
		File fileParent = fout.getParentFile();
		if (!fileParent.exists()) {
			fileParent.mkdirs();
		}
		FileWriter out;
		try {
			out = new FileWriter(fout);
			// 创建文件字符流 写 对象，传递文件对象
			out.write(content);
			out.flush();
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/** 保存压缩文件 */
	public static boolean ZipFile(String filePath, String fileName, String content) {
		try {
			// 定义压缩文件的名称
			File zipFile = new File(filePath + fileName + ".zip");
			File fileParent = zipFile.getParentFile();
			if (!fileParent.exists()) {
				fileParent.mkdirs();
			}
			zipFile.createNewFile();
			// 定义压缩输出流
			ZipOutputStream zipOut = null;

			// 实例化压缩输出流,并制定压缩文件的输出路径 就是D盘下,名字叫 demo.zip
			zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
			zipOut.putNextEntry(new ZipEntry(fileName + ".txt"));
			zipOut.write(content.getBytes());
			zipOut.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/** 读取zip内容 */
	public static String readZipFile(String filename) throws Exception {
		StringBuffer sb = new StringBuffer();
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(filename));
			// 输入源zip路径
			BufferedInputStream bin = new BufferedInputStream(zin);

			java.util.zip.ZipEntry entry;
			try {
				while ((entry = zin.getNextEntry()) != null && !entry.isDirectory()) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(bin, "UTF-8"));
					try {
						String s = reader.readLine();
						while (s != null) {
							s = StringUtils.trimToEmpty(s);
							if (s.length() > 0) {
								s = System.getProperty("line.separator") + "    " + s
										+ System.getProperty("line.separator");
								// s = s.replaceAll("<\\s*/?[p|P][^>]*>",
								// System.getProperty("line.separator"));
								sb.append(s);
							}
							s = reader.readLine();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				bin.close();
				zin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "    " + sb.toString().trim();
	}

	/** 读取zip内容 */
	public static String readZipFileForCheck(String filename) throws Exception {
		StringBuffer sb = new StringBuffer();
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(filename));
			// 输入源zip路径
			BufferedInputStream bin = new BufferedInputStream(zin);

			try {
				List<String> readLines = new ArrayList<String>();
				while ((zin.getNextEntry()) != null) {
					readLines = IOUtils.readLines(zin);
				}
				int sizeList = readLines.size();
				int sizeB = sizeList > 5 ? 5 : sizeList;
				for (int i = 0; i < sizeB; i++) {
					String s = StringUtils.trimToEmpty(readLines.get(i));
					if (s.length() > 0) {
						sb.append(System.getProperty("line.separator")).append(s)
								.append(System.getProperty("line.separator"));
					}
				}
				sb.append(System.getProperty("line.separator")).append("~~~~~~~分割线~~~~~~~")
						.append(System.getProperty("line.separator"));

				for (int i = sizeList - sizeB; i < sizeList; i++) {
					String s = StringUtils.trimToEmpty(readLines.get(i));
					if (s.length() > 0) {
						sb.append(System.getProperty("line.separator")).append(s)
								.append(System.getProperty("line.separator"));
					}
				}
				bin.close();
				zin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "    " + sb.toString().trim();
	}

	public static String getUTF8StringFromGBKString(String gbkStr) {
		try {
			return new String(getUTF8BytesFromGBKString(gbkStr), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new InternalError();
		}
	}

	public static byte[] getUTF8BytesFromGBKString(String gbkStr) {
		int n = gbkStr.length();
		byte[] utfBytes = new byte[3 * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int m = gbkStr.charAt(i);
			if (m < 128 && m >= 0) {
				utfBytes[k++] = (byte) m;
				continue;
			}
			utfBytes[k++] = (byte) (0xe0 | (m >> 12));
			utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
			utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
		}
		if (k < utfBytes.length) {
			byte[] tmp = new byte[k];
			System.arraycopy(utfBytes, 0, tmp, 0, k);
			return tmp;
		}
		return utfBytes;
	}

	/**
	 * 正则表达式校验邮箱
	 * 
	 * @param emaile
	 *            待匹配的邮箱
	 * @return 匹配成功返回true 否则返回false;
	 */
	public static boolean checkEmaile(String emaile) {
		String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		// 正则表达式的模式
		Pattern p = Pattern.compile(RULE_EMAIL);
		// 正则表达式的匹配器
		Matcher m = p.matcher(emaile);
		// 进行正则匹配
		return m.matches();
	}

	public static String getClientIP(HttpServletRequest request) {
		String ipAddress = null;
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	public static String getParamsFromUrl(String url, String key) {
		Map<String, String> map = URLRequest(url);
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return null;
		}
	}

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}

	/**
	 * file转bytes
	 * 
	 * @param filePath
	 *            文件路径
	 **/
	public static byte[] fileToBytes(String filePath) {
		FileInputStream fileInputStream = null;
		File file = new File(filePath);
		if (!file.exists()) {
			return null;
		}
		byte[] bFile = null;
		try {
			bFile = new byte[(int) file.length()];
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			// for (int i = 0; i < bFile.length; i++) {
			// System.out.print((char) bFile[i]);
			// }
			// System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
				bFile.clone();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bFile;
	}

	public static void main(String[] args) {
		System.out.println(md5("CP666"));
	}

	public static String getLocalHostIp() {

		try {
			InetAddress addr = InetAddress.getLocalHost();
			String ip = addr.getHostAddress().toString(); // 获取本机ip
			return ip;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	/***
	 * map key:group key:path
	 **/
	public static Map<String, String> getGroupIdAndPath(String path) {
		Map<String, String> map = null;
		String regex = "group\\d+";
		Pattern p = Pattern.compile(regex);
		Matcher matcher = p.matcher(path);
		if (matcher.find()) {
			map = new HashMap<String, String>();
			String group = matcher.group();
			String retpathString = path.split("\\?")[0].substring(path.lastIndexOf(group) + group.length() + 1);
			map.put("group", group);
			map.put("path", retpathString);
		}
		;
		return map;
	}

	/** 获取小说章节内容 **/
	public static String getChapterContent(ChapterList chapterList) throws Exception {
		String retContent = "";
		if (chapterList.getContent_upload_flag() == 1) {// 上传到文件服务器了
			// 从文件服务器下载zip
			String url = chapterList.getChapter_filepath_fdfs().split("\\?")[0];
			String filePath = Config.TEM_PATH + getNameFromUrl(url);
			File tmpFile = new File(filePath);
			if (!tmpFile.exists()) {
				if (Utils.downloadFile(url, Config.TEM_PATH, null)) {// 下载成功，保存在/tmp/novels/下,linux定时任务（crontab）清除
					retContent = readZipFile(filePath);
				}
			} else {
				retContent = readZipFile(filePath);
			}
		} else if (chapterList.getContent_exist_flag() == 1) {// 下载在本地，但未上传到服务器
			retContent = readZipFile(chapterList.getChapter_filepath());
		}
		return retContent;
	}

	/** 获取小说章节内容2 **/
	public static String getChapterContent2(ChapterList chapterList) throws Exception {
		String retContent = "";
		if (chapterList.getContent_upload_flag() == 1) {// 上传到文件服务器了
			retContent = readZipUrl(chapterList.getChapter_filepath_fdfs());
		} else if (chapterList.getContent_exist_flag() == 1) {// 下载在本地，但未上传到服务器
			retContent = readZipFile(chapterList.getChapter_filepath());
		}
		return retContent;
	}

	/** 获取小说章节内容2 **/
	public static String getChapterContent3(ChapterList chapterList) throws Exception {
		String retContent = "";
		if (chapterList.getContent_upload_flag() == 1) {// 上传到文件服务器了
			retContent = readZipUrlForCheck(chapterList.getChapter_filepath_fdfs());
		} else if (chapterList.getContent_exist_flag() == 1) {// 下载在本地，但未上传到服务器
			retContent = readZipFileForCheck(chapterList.getChapter_filepath());
		}
		return retContent;
	}

	/** 从url 获取文件名 **/
	public static String getNameFromUrl(String url) {
		try {
			String name = url.substring(url.lastIndexOf('/') + 1);
			if (name.contains("?")) {
				name = name.substring(0, name.indexOf("?"));
			}
			if (name != null) {
				return name;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 下载文件
	 * 
	 * @return true:下载成功 false 下载失败
	 */
	public static boolean downloadFile(String urlStr, String filePath, String fileName) {
		if (fileName == null) {
			fileName = getNameFromUrl(urlStr);
		}
		try {
			URL url = new URL(urlStr);
			if (url.getProtocol().toLowerCase().equals("https")) {
				SslUtils.ignoreSsl();
				System.setProperty("https.protocols", "TLSv1,TLSv1.2,TLSv1.1,SSLv3");
			}
			URLConnection con = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) con;
			int status = httpUrlConnection.getResponseCode();
			if (status != 200) {
				return true;
			}
			InputStream inStream = httpUrlConnection.getInputStream();
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = inStream.read(buf)) != -1) {
				outStream.write(buf, 0, len);
			}
			inStream.close();
			outStream.close();
			File file = new File(filePath + fileName);// 下载地址
			File fileParent = file.getParentFile();
			if (!fileParent.exists()) {
				fileParent.mkdirs();
			}
			file.createNewFile();
			FileOutputStream op = new FileOutputStream(file);
			op.write(outStream.toByteArray());
			op.close();
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			Log4jUtil.getSimpleErrorLogger().error(e);
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log4jUtil.getSimpleErrorLogger().error(e);
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log4jUtil.getSimpleErrorLogger().error(e);
			return false;
		}
	}

	public static Map<String, String> getCookies() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Connection conn = Jsoup.connect("https://inovel.818tu.com/login/dologin");
			conn.method(Method.POST);
			conn.followRedirects(false);
			conn.header("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
			// 将键值对数组添加到map中
			Map<String, String> params = new HashMap<String, String>();
			// key必须是：nameValuePair
			params.put("name", "hmtily");
			params.put("password", "Zl15889681365");
			conn.data(params);
			Response response;
			response = conn.execute();
			Map<String, String> getCookies = response.cookies();
			String Cookie = getCookies.toString();
			Cookie = Cookie.substring(Cookie.indexOf("{") + 1, Cookie.lastIndexOf("}"));
			Cookie = Cookie.replaceAll(",", ";");
			String[] cookies = Cookie.split(";");
			for (int i = 0; i < cookies.length; i++) {
				map.put(cookies[i].split("=")[0], cookies[i].split("=")[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void threadSleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String filterFileName(String fileName) {
		Pattern pattern = Pattern.compile("[\\s\\\\/:：\\*\\?\\\"<>\\|]");
		Matcher matcher = pattern.matcher(fileName);
		fileName = matcher.replaceAll(""); // 将匹配到的非法字符以空替换
		return fileName;
	}

	// 如有异常，返回null
	public static String getHtmlcodeWithoutHeader(String pageUrl, String charsert) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(pageUrl);
			if (url.getProtocol().toLowerCase().equals("https")) {
				SslUtils.ignoreSsl();
				System.setProperty("https.protocols", "TLSv1,TLSv1.2,TLSv1.1,SSLv3");
			}
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent", Config.USER_AGENT);
			// conn.setRequestProperty("Charsert", charsert); //设置请求编码
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in, charsert));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\r\n");
			}
			br.close();
			in.close();
			conn.disconnect();
		} catch (MalformedURLException e) {
			Log4jUtil.getSimpleErrorLogger().error("url格式不规范:" , e);
			return null;
		} catch (IOException e) {
			Log4jUtil.getSimpleErrorLogger().error("IO操作错误：" , e);
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			
		}
		return sb.toString();
	}

	public static String getNextPageContent(List<String> next_page_url, List<String> next_page_name,
			SpiderConfig spiderConfig, List<ReplaceConfig> replaces, String chapter_name, String pre_url) {
		String currentChapterContent = "";// 本页内容
		Set<String> set = new HashSet<String>();

		for (int i = 0; i < next_page_name.size(); i++) {
			if (!next_page_name.get(i).trim().contains(spiderConfig.getContent_next_page_name().trim())) {// 找到下一页位置
				continue;
			} else {
				if (set.add(next_page_url.get(i))) {// 链接去重
					String page_url = next_page_url.get(i).trim();
					if (!page_url.contains("http")) {
						page_url = pre_url + page_url;
					}
					page_url = page_url.replaceAll(Config.CHAPTER_FILTER_REGEX, "");
					String pageText = Utils.getHtmlcodeWithoutHeader(page_url, spiderConfig.getCharset());
					if (pageText == null) {// 下一页加载失败，返回null
						return null;
					}
					// pageText = Utils.getUTF8StringFromGBKString(pageText);
					Html html = new Html(pageText);
					List<String> chapter_name1 = html.xpath(spiderConfig.getChapter_name()).all();
					if (chapter_name1.size() <= 0 || !chapter_name1.get(0).replaceAll(Config.CHAPTER_FILTER_REGEX, "")
							.contains(chapter_name.replaceAll(Config.CHAPTER_FILTER_REGEX, ""))) {
						continue;// 没有下一页了
					}
					// 下一页规则配置
					if (null != spiderConfig.getContent_next_page_name_reg()
							&& null != spiderConfig.getContent_next_page_reg() && null != spiderConfig.getChapter_name()
							&& !spiderConfig.getContent_next_page_name_reg().equals("")
							&& !spiderConfig.getContent_next_page_reg().equals("")
							&& !spiderConfig.getChapter_name().equals("")) {
						List<String> next_page_name1 = html.xpath(spiderConfig.getContent_next_page_name_reg()).all();
						List<String> next_page_url1 = html.xpath(spiderConfig.getContent_next_page_reg()).links().all();
						List<String> chapterContents = html.xpath(spiderConfig.getContent_reg()).all();
						if (chapterContents.size() > 0) {
							// 获取到本页内容
							currentChapterContent = Utils.replace(chapterContents.get(0), replaces).trim();
						}
						// Utils.threadSleep(200);
						String nextChapterCon = Utils.getNextPageContent(next_page_url1, next_page_name1, spiderConfig,
								replaces, chapter_name, pre_url);

						if (nextChapterCon == null) {// 下一页加载失败返回null
							return null;
						} else {
							return currentChapterContent + nextChapterCon;
						}
					}
					return null;// 没配置返回null
				}
			}

		}
		// 循环结束没有下一页
		return currentChapterContent;
	}
	

	/**
	 * Unicode转 汉字字符串
	 *
	 * @param str
	 *            \u6728
	 * @return '木' 26408
	 * @author Victor
	 */
	public static String unicodeToString(String str) {

		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		Matcher matcher = pattern.matcher(str);
		char ch;
		while (matcher.find()) {
			// group 6728
			String group = matcher.group(2);
			// ch:'木' 26408
			ch = (char) Integer.parseInt(group, 16);
			// group1 \u6728
			String group1 = matcher.group(1);
			str = str.replace(group1, ch + "");
		}
		return str;
	}

	public static String readZipUrl(String chapterUrl) throws IOException {
		StringBuffer sb = new StringBuffer();
		URL url = new URL(chapterUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() == 200) {
			InputStream openStream = conn.getInputStream();
			ZipInputStream zis = new ZipInputStream(openStream);
			List<String> readLines = new ArrayList<String>();
			while ((zis.getNextEntry()) != null) {
				readLines = IOUtils.readLines(zis);
			}
			for (String s : readLines) {
				s = StringUtils.trimToEmpty(s);
				if (s.length() > 0) {
					s = System.getProperty("line.separator") + "    " + s + System.getProperty("line.separator");
					// s = s.replaceAll("<\\s*/?[p|P][^>]*>",
					// System.getProperty("line.separator"));
					sb.append(s);
				}
			}
		}
		return sb.toString();
	}
	public static String getContentByUrl(String fileUrl) throws Exception {
		URL url = new URL(fileUrl);
		InputStream inputStream = url.openStream();
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		ZipEntry zipEntry = null;
		StringBuffer sb = new StringBuffer();
		while ((zipEntry = zipInputStream.getNextEntry()) != null) {
			InputStreamReader inputStreamReader = new InputStreamReader(zipInputStream, Charsets.toCharset("UTF-8"));
			BufferedReader reader = toBufferedReader(inputStreamReader);
			String line = reader.readLine();
			while (line != null && !line.equalsIgnoreCase("null")) {
				if (line.trim().length() > 1) {
					sb.append("<p>" + line.trim() + "</p>");
				}
				line = reader.readLine();
			}
		}
		return sb.toString();
	}

	public static BufferedReader toBufferedReader(Reader reader) {
		return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
	}

	public static String readZipUrlForCheck(String chapterUrl) throws IOException {
		StringBuffer sb = new StringBuffer();
		URL url = new URL(chapterUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		if (conn.getResponseCode() == 200) {
			InputStream openStream = conn.getInputStream();
			ZipInputStream zis = new ZipInputStream(openStream);
			List<String> readLines = new ArrayList<String>();
			while ((zis.getNextEntry()) != null) {
				readLines = IOUtils.readLines(zis);
			}
			int sizeList = readLines.size();
			int sizeB = sizeList > 5 ? 5 : sizeList;
			for (int i = 0; i < sizeB; i++) {
				String s = StringUtils.trimToEmpty(readLines.get(i));
				if (s.length() > 0) {
					sb.append(System.getProperty("line.separator")).append(s)
							.append(System.getProperty("line.separator"));
				}
			}
			sb.append(System.getProperty("line.separator")).append("~~~~~~~分割线~~~~~~~")
					.append(System.getProperty("line.separator"));

			for (int i = sizeList - sizeB; i < sizeList; i++) {
				String s = StringUtils.trimToEmpty(readLines.get(i));
				if (s.length() > 0) {
					sb.append(System.getProperty("line.separator")).append(s)
							.append(System.getProperty("line.separator"));
				}
			}
		}
		return sb.toString();
	}

	public static String getReplaceChapterName(String chapterNameOld, String split) {
		// TODO Auto-generated method stub
		if (chapterNameOld.indexOf(split + "，") > 0) {
			return chapterNameOld.replaceFirst(split + "，", split + " ");
		}
		if (chapterNameOld.indexOf(split + "：") > 0) {
			return chapterNameOld.replaceFirst(split + "：", split + " ");
		}
		if (chapterNameOld.indexOf(split + " ") > 0) {
			return chapterNameOld;
		}
		if (chapterNameOld.indexOf(split) > 0) {
			return chapterNameOld.replaceFirst(split, split + " ");
		}
		return chapterNameOld;
	}

	public static Request createRequest(Map<String, Object> extras, String url, String method) {
		// TODO Auto-generated method stub
		String[] datas = url.split("\\?");
		Request request = new Request(datas[0]);
		if (method.equalsIgnoreCase("0") || ((String) extras.get("type")).equalsIgnoreCase("1")) {// get
			request.setMethod(HttpConstant.Method.GET);
		} else if (method.equalsIgnoreCase("1")) {// post
			request.setMethod(HttpConstant.Method.POST);
		}
		request.setExtras(extras);
		return request;
	}
	/**
	 * 获取下一天的00:00:00
	 * */
	public static Date getNextDate() {
		Date currentEndDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentEndDate);
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.AM_PM, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date nextDate = cal.getTime();
		return nextDate;
	}
	/**
	 * 获取date 日期 时分秒
	 * */
	public static Date getDetailDate(int days,int hour, int minute,int second ) {
		Date currentEndDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentEndDate);
		cal.add(Calendar.DATE, days);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.HOUR, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		Date nextDate = cal.getTime();
		return nextDate;
	}
	
	public static String getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		return date;
	}
	
	/**
	 * 获取某一天日期
	 * */
	public static Date getDateByDays(int days) {
		Date currentEndDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentEndDate);
		
		cal.add(Calendar.DATE, days);
		cal.set(Calendar.AM_PM, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date nextDate = cal.getTime();
		return nextDate;
	}
	
	public static PartnerInfo getPartnerFromSession(HttpSession session) {
		// TODO Auto-generated method stub
		Object object = session.getAttribute("partner_user");
		PartnerInfo partnerInfo = null;
		if (object!=null) {
			partnerInfo = (PartnerInfo) object;
		}
		return partnerInfo;
	}
	
	public static Sys_user getSysUserFromSession(HttpSession session) {
		// TODO Auto-generated method stub
		Object object = session.getAttribute("user");
		Sys_user sys_user = null;
		if (object!=null) {
			sys_user = (Sys_user) object;
		}
		return sys_user;
	}

	 public static List<String> findDates(String begin, String end){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (begin==null|| begin.equalsIgnoreCase("")) {
			begin = sdf.format(Utils.getDateByDays(-10));
		}
		if (end==null|| end.equalsIgnoreCase("")) {
			end = sdf.format(Utils.getDateByDays(0));
		}
		List<String> lDate = new ArrayList<String>();
		try {
			Date dBegin = sdf.parse(begin);
			Date dEnd = sdf.parse(end);
			Calendar calBegin = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			calBegin.setTime(dBegin);
			Calendar calEnd = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			calEnd.setTime(dEnd);
			//日期往后加1天
			calEnd.add(Calendar.DAY_OF_MONTH, 1);
			// 测试此日期是否在指定日期之后
			while (calEnd.getTime().after(calBegin.getTime())) {
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				lDate.add(sdf.format(calBegin.getTime()));
				calBegin.add(Calendar.DAY_OF_MONTH, 1);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lDate;
	}

	public static ChapterNamesAndUrls getChapterNamesAndUrlsFromUrl(String url, SpiderConfig sConfig,
			List<ReplaceConfig> replaces) {
		// TODO Auto-generated method stub
		String pageText = Utils.getHtmlcodeWithoutHeader(url, sConfig.getCharset());
		if (pageText == null) {// 下一页加载失败，返回null
			return null;
		}
		// pageText = Utils.getUTF8StringFromGBKString(pageText);
		Html html = new Html(pageText);
		List<String> names = html.xpath(sConfig.getChapter_reg()).all();
		List<String> urls = html.xpath(sConfig.getChapter_url_reg()).links().all();
		if (names.size()==urls.size()&&names.size()>0) {
			ChapterNamesAndUrls chapterNamesAndUrls = new DownChapterSpider.ChapterNamesAndUrls();
			chapterNamesAndUrls.setNames(names);
			chapterNamesAndUrls.setUrls(urls);
			return chapterNamesAndUrls;
		}
		return null;
	} 
}
