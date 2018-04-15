package com.stone.box.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getTimestamp() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }
}
