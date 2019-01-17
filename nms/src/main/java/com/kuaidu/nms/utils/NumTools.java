package com.kuaidu.nms.utils;

import java.util.HashMap;
import java.util.Random;

public class NumTools {  
    //数字位  
    public static String[] chnNumChar = {"零","一","二","三","四","五","六","七","八","九"};  
    public static char[] chnNumChinese = {'零','一','二','三','四','五','六','七','八','九'};  
    public static char[] chnNumChineseAndUnits = new char[]{'零','一','二','三','四','五','六','七','八','九','十','百','千','万','亿'};
    //节权位  
    public static String[] chnUnitSection = {"","万","亿","万亿"};    
    //权位  
    public static String[] chnUnitChar = {"","十","百","千"};  
    public static HashMap<Character, Integer> intList = new HashMap<Character, Integer>();  
    static{  
        for(int i=0;i<chnNumChar.length;i++){
            intList.put(chnNumChinese[i], i);  
        }  
          
        intList.put('十',10);  
        intList.put('百',100);  
        intList.put('千', 1000);  
    }  
      
    
    public static String getRandomStr(int num) {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
} 