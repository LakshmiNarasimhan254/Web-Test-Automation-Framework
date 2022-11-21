package org.mln.utils;


import org.mln.constants.FrameworkConstants;
import org.mln.customexceptions.CustomException;
import org.mln.customexceptions.FileIOException;
import org.mln.customexceptions.InvalidPathForFileException;
import org.mln.customexceptions.PropertyFileUsageException;
import org.mln.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtil {

    private  static final Properties properties = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();
    private PropertyUtil() {
    }

    static {
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigPath())){
            properties.load(fileInputStream);
            properties.entrySet().forEach(entry->CONFIGMAP.put(String.valueOf(entry.getKey()).toLowerCase(),String.valueOf(entry.getValue()).trim()));

        } catch (IOException e) {
           e.printStackTrace();
           System.exit(0);
        }
    }
        public static String getValue(ConfigProperties key)  {
        if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) ||(Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())))) {
            throw new PropertyFileUsageException("Property Named " + key + " is not found.Please check in :"+ FrameworkConstants.getConfigPath() +".");

        }
        return CONFIGMAP.get(key.toString().toLowerCase());
    }
}
