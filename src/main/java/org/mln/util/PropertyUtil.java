package org.mln.util;


import org.mln.constants.FrameworkConstants;
import org.mln.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtil {

    private static Properties properties = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap();
    private PropertyUtil() {
    }

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigPath());
            properties.load(fileInputStream);
            properties.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()).toLowerCase(),String.valueOf(entry.getValue()).trim()));

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static String getValue(ConfigProperties key) throws Exception {
        if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) ||(Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))) {
            throw new Exception("Property Named " + key + " is not found.Please check config.properties");
        }
        return CONFIGMAP.get(key.toString().toLowerCase());
    }
}
