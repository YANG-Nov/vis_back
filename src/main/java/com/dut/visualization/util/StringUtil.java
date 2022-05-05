package com.dut.visualization.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author Yang
 * @version 1.0.0
 * @create 2021-10-23 14:18
 */
public class StringUtil {
        /**
         * 生成随机字符串
         */
        public static String generateUUID(){
            return UUID.randomUUID().toString().replaceAll("-","");
        }

        /**
         * MD5加密
         */
        public static String md5(String key){
            if (StringUtils.isBlank(key)){
                return null;
            }
            return DigestUtils.md5DigestAsHex(key.getBytes());
        }

        public static Integer changeString(String string){
            if (string != null && !StringUtils.isBlank(string)) {
                return Integer.valueOf(string);
            }else {
                return null;
            }
        }

}
