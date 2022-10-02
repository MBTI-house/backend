package com.house.mbit.core.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie generator(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");

        return cookie;
    }

    public static Cookie expire(String key) {
        Cookie cookie = new Cookie(key, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        return cookie;
    }
}
