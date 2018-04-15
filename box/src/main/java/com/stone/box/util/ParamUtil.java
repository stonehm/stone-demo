package com.stone.box.util;

import java.util.HashMap;
import java.util.Map;

public class ParamUtil {

    public static Map<String, String> getParametersMap(String appId) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("appId", appId);
        return parameters;
    }
}
