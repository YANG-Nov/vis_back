package com.dicadut.soms.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class is used to read value of the specified key from a property file
 *
 * @author Radium
 * @version 1.0
 * @date 2021-04-13 20:56:28
 */
public class ResourceUtil {

    public static String getSetting(String key) {
        return getMessage("commonsConfig", key);
    }

    private static String getMessage(String fileName, String key) {
        Locale locale = new Locale("zh", "CN");
        ResourceBundle bundle = ResourceBundle.getBundle(fileName, locale);

        return bundle.getString(key);
    }

    /**
     * 获取校验结果
     *
     * @param key
     * @return
     */
    public static String getValidationMessage(String key) {
        return getMessage("commonsValidationMessages", key);
    }
}
