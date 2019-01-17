package com.kuaidu.nms.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.data.redis.core.RedisTemplate;

import com.kuaidu.nms.entity.PartnerInfo;
import com.kuaidu.nms.entity.PartnerPmConfig;
import com.kuaidu.nms.entity.WxCustomMsg;
import com.kuaidu.nms.entity.WxTemplateMsg;
import com.kuaidu.nms.partner.qrUrl.controller.QrUrl;
import com.kuaidu.nms.pushchannel.mapper.PartnerInfoMapper;

import net.sf.json.JSONObject;

/** 
 * @Title MyWxUtils.java 
 * @description TODO 
 * @time 2018年10月12日 下午2:23:36 
 * @author victor 
 * @version 1.0 
**/
public class MyWxUtils {
	public static String validateWeApp(PartnerPmConfig pmConfig) {
		// TODO Auto-generated method stub

		String url = "https://api.weixin.qq.com/cgi-bin/token?"
				+ "grant_type=client_credential&appid="+pmConfig.getWe_app_id()
				+"&secret="+pmConfig.getWe_app_secret();
		String result = Utils.getHtmlcodeWithoutHeader(url, "utf-8");
		if (result == null) {
			result = "";
		}
		JSONObject json = JSONObject.fromObject(result);
		if (json.containsKey("access_token")) {
			return json.optString("access_token");
		}else {
			return "";
		}
	}
	@SuppressWarnings("unchecked")
	public static synchronized String getAccessToken(Integer partnerId) {
		// TODO Auto-generated method stub
		String url = "http://mzshu.com/wx/access_token?"
				+"partnerId="+partnerId+"&token=looku";
		String result = Utils.getHtmlcodeWithoutHeader(url, "utf-8");
		if (result==null) {//请求接口失败，自己从缓存获取
			Log4jUtil.getSimpleErrorLogger().error("Get AccessToken From "+url+" Failed!");
			String key = "AccessToken:"+partnerId;
			RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringApplicationContextHolder.getBean("redisTemplate");
			result = (String) redisTemplate.opsForValue().get(key);
			if (result==null) {
				PartnerInfoMapper pMapper = (PartnerInfoMapper) SpringApplicationContextHolder.getBean("partnerInfoMapper");
				PartnerPmConfig partnerPmConfig = pMapper.getPartnerPmConfigByPartnerId(partnerId);
				result = validateWeApp(partnerPmConfig);
				if (!result.equalsIgnoreCase("")) {
					redisTemplate.opsForValue().set(key, result, 110, TimeUnit.MINUTES);
				}else {
					return "";
				}
			}
		}
		return result.trim();
	}
	/**发送客服消息*/
	public static String sendCustomMsg(WxCustomMsg customMsg) {
		String accessToken = getAccessToken(customMsg.getPartner_id());
		if (accessToken.equalsIgnoreCase("")) {
			return "{\"errcode\": 101, \"errmsg\": \"accessToken null\"}";
		}
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
		String jsonParams = getJsonParams(customMsg);
		Log4jUtil.getBusinessLogger().info(jsonParams);
		if (jsonParams!="") {
			String ret = HttpUtil.postWithJson(url, jsonParams, 2000, 2000);
			return ret;
		}else {
			return "{\"errcode\": 102, \"errmsg\": \"jsonParams null\"}";
		}
	}
	private static String getJsonParams(WxCustomMsg customMsg) {
		String ret = "";
		if (customMsg.getMsg_type().equals("news")) {
			ret = "{"
					+ "\"touser\":\""+customMsg.getTo_user()+"\","
					+"\"msgtype\":\""+customMsg.getMsg_type()+"\","
					+"\""+customMsg.getMsg_type()+"\":{"
						+"\"articles\":[{"
							+ "\"title\":\""+customMsg.getTitle()+"\","
							+ "\"description\":\""+customMsg.getDescription()+"\","
							+ "\"url\":\""+customMsg.getUrl()+"\","
							+ "\"picurl\":\""+customMsg.getPic_url()+"\"}]"
						+"}"
					+ "}";
		}else if (customMsg.getMsg_type().equals("text")) {
			ret = "{"
					+ "\"touser\":\""+customMsg.getTo_user()+"\","
					+"\"msgtype\":\""+customMsg.getMsg_type()+"\","
					+"\""+customMsg.getMsg_type()+"\":{"
							+ "\"content\":\""+customMsg.getTitle()+customMsg.getDescription()+"\","
						+"}"
					+ "}";
		}
		System.out.println(ret);
		return ret;
	}
	/**发送模版消息*/
	public static String sendTemplateMsg(WxTemplateMsg wxTemplateMsg) {
		String accessToken = getAccessToken(wxTemplateMsg.getParent_id());
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
		String jsonParams = getWxTemplateJsonParams(wxTemplateMsg);
		Log4jUtil.getBusinessLogger().info(jsonParams);
		if (jsonParams!="") {
			String ret = HttpUtil.postWithJson(url, jsonParams, 2000, 2000);
			return ret;
		}else {
			return "{}";
		}
	}
	/**
	 *     {
           "errcode":0,
           "errmsg":"ok",
           "msgid":200228332
           }
	 * */
	private static String getWxTemplateJsonParams(WxTemplateMsg wxTemplateMsg) {
		// TODO Auto-generated method stub
		String ret = "{"
				+ "\"touser\":\""+wxTemplateMsg.getTo_user()+"\","
				+"\"template_id\":\""+wxTemplateMsg.getTemplate_id()+"\","
				+"\"url\":\""+wxTemplateMsg.getUrl()+"\","
				+"\"data\":{"+wxTemplateMsg.getData()+"}"
				+ "}";
		return ret;
	}
	/**获取模版列表
	 * {    
		 "template_list": [{
		      "template_id": "iPk5sOIt5X_flOVKn5GrTFpncEYTojx6ddbt8WYoV5s",
		      "title": "领取奖金提醒",
		      "primary_industry": "IT科技",
		      "deputy_industry": "互联网|电子商务",
		      "content": "{ {result.DATA} }\n\n领奖金额:{ {withdrawMoney.DATA} }\n领奖  时间:{ {withdrawTime.DATA} }\n银行信息:{ {cardInfo.DATA} }\n到账时间:  { {arrivedTime.DATA} }\n{ {remark.DATA} }",
		      "example": "您已提交领奖申请\n\n领奖金额：xxxx元\n领奖时间：2013-10-10 12:22:22\n银行信息：xx银行(尾号xxxx)\n到账时间：预计xxxxxxx\n\n预计将于xxxx到达您的银行卡"
		   }]
		}
	 * */
	public static String getTemplateList(WxTemplateMsg wxTemplateMsg) {
		String accessToken = getAccessToken(wxTemplateMsg.getParent_id());
		String url = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="+accessToken;
		String ret = Utils.getHtmlcodeWithoutHeader(url, "utf-8");
		return ret;
	}
	//微信上传永久素材
	public static String addMaterialEverInter(File file,String type,String accessToken) throws Exception {  
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=####&type=image";
        //上传素材    
        String result =null;  
        URL realUrl = new URL(url.replace("####", accessToken));

        URLConnection con= realUrl.openConnection();
        con.setDoInput(true);  
        con.setDoOutput(true);  
        con.setUseCaches(false); // post方式不能使用缓存  
        // 设置请求头信息  
        con.setRequestProperty("Connection", "Keep-Alive");  
        con.setRequestProperty("Charset", "UTF-8");  
        // 设置边界  
        String BOUNDARY = "----------" + System.currentTimeMillis();  
        con.setRequestProperty("Content-Type",  
                "multipart/form-data; boundary="  
                + BOUNDARY);  
          
        // 请求正文信息  
        // 第一部分：  
        StringBuilder sb = new StringBuilder();  
        sb.append("--"); // 必须多两道线  
        sb.append(BOUNDARY);  
        sb.append("\r\n");  
        sb.append("Content-Disposition: form-data;name=\"media\";filelength=\""+file.length()+"\";filename=\""  
                + file.getName() + "\"\r\n");  
        sb.append("Content-Type:application/octet-stream\r\n\r\n");
        byte[] head = sb.toString().getBytes("utf-8");  
        // 获得输出流  
        OutputStream out = new DataOutputStream(con.getOutputStream());  
        // 输出表头  
        out.write(head);  
        // 文件正文部分  
        // 把文件已流文件的方式 推入到url中  
        DataInputStream in = new DataInputStream(new FileInputStream(file));  
        int bytes = 0;  
        byte[] bufferOut = new byte[1024];  
        while ((bytes = in.read(bufferOut)) != -1) {  
            out.write(bufferOut, 0, bytes);  
        }  
        in.close();  
        // 结尾部分  
        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
        out.write(foot);  
        out.flush();  
        out.close();  
        StringBuffer buffer = new StringBuffer();  
        BufferedReader reader = null;  
        try {  
            // 定义BufferedReader输入流来读取URL的响应  
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                buffer.append(line);  
            }  
            if (result == null) {  
                result = buffer.toString();  
            }  
        } catch (IOException e) {  
            Log4jUtil.getSimpleErrorLogger().error("发送POST请求出现异常！" + e);  
            e.printStackTrace();  
            throw new IOException("数据读取异常");  
        } finally {  
            if (reader != null) {  
                reader.close();  
            }  
        }  
        return result.toString();  
	}
	//微信上传永久图片素材
	public static JSONObject addMaterialEverInter(String  urlPicStr,String type,String accessToken) throws Exception {  
		String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=####&type=image";
        URL picUrl = new URL(urlPicStr);
        URLConnection urlConnection = picUrl.openConnection();
        int length = urlConnection.getContentLength();
        InputStream inputStream = urlConnection.getInputStream();
        
        //上传素材    
        String result =null;  
        URL realUrl = new URL(url.replace("####", accessToken));
        URLConnection con= realUrl.openConnection();
        con.setDoInput(true);  
        con.setDoOutput(true);  
        con.setUseCaches(false); // post方式不能使用缓存  
        // 设置请求头信息  
        con.setRequestProperty("Connection", "Keep-Alive");  
        con.setRequestProperty("Charset", "UTF-8");  
        // 设置边界  
        String BOUNDARY = "----------" + System.currentTimeMillis();  
        con.setRequestProperty("Content-Type",  
                "multipart/form-data; boundary="  
                + BOUNDARY);  
          
        // 请求正文信息  
        // 第一部分：  
        StringBuilder sb = new StringBuilder();  
        sb.append("--"); // 必须多两道线  
        sb.append(BOUNDARY);  
        sb.append("\r\n");  
        sb.append("Content-Disposition: form-data;name=\"media\";filelength=\""+length+"\";filename=\""  
                + "kf_qr.jpg" + "\"\r\n");  
        sb.append("Content-Type:application/octet-stream\r\n\r\n");
        byte[] head = sb.toString().getBytes("utf-8");  
        // 获得输出流  
        OutputStream out = new DataOutputStream(con.getOutputStream());  
        // 输出表头  
        out.write(head);  
        // 文件正文部分  
        // 把文件已流文件的方式 推入到url中  
        DataInputStream in = new DataInputStream(inputStream);  
        int bytes = 0;  
        byte[] bufferOut = new byte[1024];  
        while ((bytes = in.read(bufferOut)) != -1) {  
            out.write(bufferOut, 0, bytes);  
        }  
        in.close();  
        // 结尾部分  
        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线  
        out.write(foot);  
        out.flush();  
        out.close();  
        StringBuffer buffer = new StringBuffer();  
        BufferedReader reader = null;  
        try {  
            // 定义BufferedReader输入流来读取URL的响应  
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                buffer.append(line);  
            }  
            if (result == null) {  
                result = buffer.toString();  
            }  
        } catch (IOException e) {  
            Log4jUtil.getSimpleErrorLogger().error("发送POST请求出现异常！" + e);  
            e.printStackTrace();  
            throw new IOException("数据读取异常");  
        } finally {  
            if (reader != null) {  
                reader.close();  
            }  
        }  
		return JSONObject.fromObject(result);  
	}
	
	/**
	 * 获取临时带参二维码图片链接
	 * */
	public static String getTempQr(HttpSession session,int second,int pushId,int chapterId) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return null;
		}
		String accessToken = getAccessToken(partnerInfo.getPartner_id());
		Log4jUtil.getBusinessLogger().info("accessToken:"+accessToken);
		String url = "";
		if (accessToken != null) {
			//获取带参二维码
			String wxUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+accessToken;
			Log4jUtil.getBusinessLogger().info("wxUrl:"+wxUrl);
			String param = MyWxUtils.createChapterQR_STR_SCENE(259200, pushId, chapterId);
			Log4jUtil.getBusinessLogger().info("QrParam:"+param);
			url = HttpUtil.postWithJson(wxUrl, param, 10000, 10000);
			JSONObject parseObject = JSONObject.fromObject(url);
			String ticket = parseObject.getString("ticket");
			String paramQrCode = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket;
			return paramQrCode;
		}else {
			return "";
		}
	}
	
	/**
	 * 获取临时带参二维码内容链接
	 * */
	public static String getTempQrStr(HttpSession session,int second,int pushId,int chapterId) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return null;
		}
		String accessToken = getAccessToken(partnerInfo.getPartner_id());
		Log4jUtil.getBusinessLogger().info("accessToken:"+accessToken);
		String ret = "";
		if (accessToken != null) {
			//获取带参二维码
			String wxUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+accessToken;
			Log4jUtil.getBusinessLogger().info("wxUrl:"+wxUrl);
			String param = MyWxUtils.createChapterQR_STR_SCENE(QrUrl.MAX_SECOND, pushId, chapterId);
			Log4jUtil.getBusinessLogger().info("QrParam:"+param);
			ret = HttpUtil.postWithJson(wxUrl, param, 10000, 10000);
			Log4jUtil.getBusinessLogger().info(ret);
			
			//String url = parseObject.getString("url");
			return ret.replaceAll("\\\\", "");
		}else {
			return "";
		}
	}
	@SuppressWarnings("unchecked")
	private static String createChapterQR_STR_SCENE(int second, int pushId, int chapterId) {
		// TODO Auto-generated method stub

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("type", 1);
		jsonObject.put("userId", null);
		jsonObject.put("chapterId", chapterId);
		jsonObject.put("pushId", pushId);
		String jsonString = jsonObject.toString();
		RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringApplicationContextHolder.getBean("redisTemplate");
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		String key = "QrCode:"+uuid;
		redisTemplate.opsForValue().set(key, jsonString,30,TimeUnit.DAYS);
		return "{\"expire_seconds\":"+second+",\"action_name\":\"QR_STR_SCENE\",\"action_info\":{\"scene\":{\"scene_str\":\""+uuid+"\"}}}";
	
	}
	@SuppressWarnings("unchecked")
	private static String createLimitChapterQR_STR_SCENE(int second, int pushId, int chapterId) {
		// TODO Auto-generated method stub

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("type", 1);
		jsonObject.put("userId", null);
		jsonObject.put("chapterId", chapterId);
		jsonObject.put("pushId", pushId);
		String jsonString = jsonObject.toString();
		RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringApplicationContextHolder.getBean("redisTemplate");
		String uuid = UUID.randomUUID().toString().replaceAll("-","");
		String key = "QrCode:"+uuid;
		redisTemplate.opsForValue().set(key, jsonString);
		return "{\"expire_seconds\":"+second+",\"action_name\":\"QR_LIMIT_STR_SCENE\",\"action_info\":{\"scene\":{\"scene_str\":\""+uuid+"\"}}}";
	
	}
	/**
	 * 获取永久带参二维码
	 * */
	public static String getPermanentQr(HttpSession session,int second,int pushId,int chapterId) {
		PartnerInfo partnerInfo = Utils.getPartnerFromSession(session);
		if (partnerInfo==null) {
			return null;
		}
		String accessToken = getAccessToken(partnerInfo.getPartner_id());
		Log4jUtil.getBusinessLogger().info("accessToken:"+accessToken);
		String url = "";
		if (accessToken != null) {
			//获取带参二维码
			String wxUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+accessToken;
			Log4jUtil.getBusinessLogger().info("wxUrl:"+wxUrl);
			String param = MyWxUtils.createLimitChapterQR_STR_SCENE(259200, pushId, chapterId);
			Log4jUtil.getBusinessLogger().info("QrParam:"+param);
			url = HttpUtil.postWithJson(wxUrl, param, 10000, 10000);
			JSONObject parseObject = JSONObject.fromObject(url);
			String ticket = parseObject.getString("ticket");
			String paramQrCode = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ticket;
			return paramQrCode;
		}else {
			return "";
		}
	}
	
	/**
	 * 验证客服消息接口
	 * */
	public static int testCustomApi(int partnerId) {
		String accessToken = getAccessToken(partnerId);
		if (accessToken.equalsIgnoreCase("")) {
			return 101;//accessToken失败
		}
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="+accessToken;
		String jsonParams = "{\"test\":\"test\"}";
		String ret = HttpUtil.postWithJson(url, jsonParams, 2000, 2000);
		Log4jUtil.getBusinessLogger().info("validatePartnerApi=="+ret);
		if (ret.equalsIgnoreCase("")) {
			return 102;//http请求异常
		}
		JSONObject jsonRet = JSONObject.fromObject(ret);
		return jsonRet.optInt("errcode", 103);
	}
}
