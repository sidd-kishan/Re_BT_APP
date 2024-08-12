/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  com.lianhezhuli.btnotification.MApplication
 */
package com.lianhezhuli.btnotification.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.lianhezhuli.btnotification.MApplication;
import java.lang.reflect.Type;
import java.util.Set;

public class SpUtils {
    private static Gson gson = new Gson();
    private static SharedPreferences preferences = MApplication.getInstance().getSharedPreferences("lianhezhuli_device_info", 0);

    public static void clearShareData(String string) {
        preferences.edit().remove(string);
    }

    public static Object getData(String string, Object object) {
        if (object instanceof Integer) {
            return preferences.getInt(string, ((Integer)object).intValue());
        }
        if (object instanceof String) {
            return preferences.getString(string, (String)object);
        }
        if (object instanceof Float) {
            return Float.valueOf(preferences.getFloat(string, ((Float)object).floatValue()));
        }
        if (object instanceof Long) {
            return preferences.getLong(string, ((Long)object).longValue());
        }
        if (object instanceof Boolean) {
            return preferences.getBoolean(string, ((Boolean)object).booleanValue());
        }
        if (!(object instanceof Set)) return object;
        return preferences.getStringSet(string, (Set)object);
    }

    public static <T> T getShareData(String string, Class<T> clazz) {
        if (!TextUtils.isEmpty((CharSequence)(string = preferences.getString(string, "")))) return gson.fromJson(string, clazz);
        return null;
    }

    public static <T> T getShareData(String string, Type type) {
        if (!TextUtils.isEmpty((CharSequence)(string = preferences.getString(string, "")))) return gson.fromJson(string, type);
        return null;
    }

    public static boolean saveData(String string, Object object) {
        SharedPreferences.Editor editor = preferences.edit();
        if (object instanceof Integer) {
            editor.putInt(string, ((Integer)object).intValue());
        } else if (object instanceof String) {
            editor.putString(string, (String)object);
        } else if (object instanceof Float) {
            editor.putFloat(string, ((Float)object).floatValue());
        } else if (object instanceof Long) {
            editor.putLong(string, ((Long)object).longValue());
        } else if (object instanceof Boolean) {
            editor.putBoolean(string, ((Boolean)object).booleanValue());
        } else {
            if (!(object instanceof Set)) return editor.commit();
            editor.putStringSet(string, (Set)object);
        }
        return editor.commit();
    }

    public static boolean saveJsonData(String string, Object object) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(string, gson.toJson(object));
        return editor.commit();
    }
}
