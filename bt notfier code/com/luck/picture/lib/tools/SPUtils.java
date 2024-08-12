/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.SharedPreferences
 */
package com.luck.picture.lib.tools;

import android.app.Application;
import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SPUtils {
    private static final Map<String, SPUtils> SP_UTILS_MAP = new HashMap<String, SPUtils>();
    private SharedPreferences sp;

    private SPUtils(String string) {
        this.sp = SPUtils.getApplicationByReflect().getSharedPreferences(string, 0);
    }

    private SPUtils(String string, int n) {
        this.sp = SPUtils.getApplicationByReflect().getSharedPreferences(string, n);
    }

    private static Application getApplicationByReflect() {
        try {
            Object object = Class.forName("android.app.ActivityThread");
            Object object2 = ((Class)object).getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            object = ((Class)object).getMethod("getApplication", new Class[0]).invoke(object2, new Object[0]);
            if (object != null) {
                return (Application)object;
            }
            object = new NullPointerException("u should init first");
            throw object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        catch (InvocationTargetException invocationTargetException) {
            invocationTargetException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
        throw new NullPointerException("u should init first");
    }

    public static SPUtils getInstance() {
        return SPUtils.getInstance("", 0);
    }

    public static SPUtils getInstance(int n) {
        return SPUtils.getInstance("", n);
    }

    public static SPUtils getInstance(String string) {
        return SPUtils.getInstance(string, 0);
    }

    public static SPUtils getInstance(String object, int n) {
        String string = object;
        if (SPUtils.isSpace((String)object)) {
            string = "spUtils";
        }
        SPUtils sPUtils = SP_UTILS_MAP.get(string);
        object = sPUtils;
        if (sPUtils != null) return object;
        synchronized (SPUtils.class) {
            sPUtils = SP_UTILS_MAP.get(string);
            object = sPUtils;
            if (sPUtils != null) return object;
            object = new SPUtils(string, n);
            SP_UTILS_MAP.put(string, (SPUtils)object);
        }
        return object;
    }

    public static SPUtils getPictureSpUtils() {
        return SPUtils.getInstance("PictureSpUtils");
    }

    private static boolean isSpace(String string) {
        if (string == null) {
            return true;
        }
        int n = string.length();
        int n2 = 0;
        while (n2 < n) {
            if (!Character.isWhitespace(string.charAt(n2))) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public void clear() {
        this.clear(false);
    }

    public void clear(boolean bl) {
        if (bl) {
            this.sp.edit().clear().commit();
        } else {
            this.sp.edit().clear().apply();
        }
    }

    public boolean contains(String string) {
        return this.sp.contains(string);
    }

    public Map<String, ?> getAll() {
        return this.sp.getAll();
    }

    public boolean getBoolean(String string) {
        return this.getBoolean(string, false);
    }

    public boolean getBoolean(String string, boolean bl) {
        return this.sp.getBoolean(string, bl);
    }

    public float getFloat(String string) {
        return this.getFloat(string, -1.0f);
    }

    public float getFloat(String string, float f) {
        return this.sp.getFloat(string, f);
    }

    public int getInt(String string) {
        return this.getInt(string, -1);
    }

    public int getInt(String string, int n) {
        return this.sp.getInt(string, n);
    }

    public long getLong(String string) {
        return this.getLong(string, -1L);
    }

    public long getLong(String string, long l) {
        return this.sp.getLong(string, l);
    }

    public String getString(String string) {
        return this.getString(string, "");
    }

    public String getString(String string, String string2) {
        return this.sp.getString(string, string2);
    }

    public Set<String> getStringSet(String string) {
        return this.getStringSet(string, Collections.<String>emptySet());
    }

    public Set<String> getStringSet(String string, Set<String> set) {
        return this.sp.getStringSet(string, set);
    }

    public void put(String string, float f) {
        this.put(string, f, false);
    }

    public void put(String string, float f, boolean bl) {
        if (bl) {
            this.sp.edit().putFloat(string, f).commit();
        } else {
            this.sp.edit().putFloat(string, f).apply();
        }
    }

    public void put(String string, int n) {
        this.put(string, n, false);
    }

    public void put(String string, int n, boolean bl) {
        if (bl) {
            this.sp.edit().putInt(string, n).commit();
        } else {
            this.sp.edit().putInt(string, n).apply();
        }
    }

    public void put(String string, long l) {
        this.put(string, l, false);
    }

    public void put(String string, long l, boolean bl) {
        if (bl) {
            this.sp.edit().putLong(string, l).commit();
        } else {
            this.sp.edit().putLong(string, l).apply();
        }
    }

    public void put(String string, String string2) {
        this.put(string, string2, false);
    }

    public void put(String string, String string2, boolean bl) {
        if (bl) {
            this.sp.edit().putString(string, string2).commit();
        } else {
            this.sp.edit().putString(string, string2).apply();
        }
    }

    public void put(String string, Set<String> set) {
        this.put(string, set, false);
    }

    public void put(String string, Set<String> set, boolean bl) {
        if (bl) {
            this.sp.edit().putStringSet(string, set).commit();
        } else {
            this.sp.edit().putStringSet(string, set).apply();
        }
    }

    public void put(String string, boolean bl) {
        this.put(string, bl, false);
    }

    public void put(String string, boolean bl, boolean bl2) {
        if (bl2) {
            this.sp.edit().putBoolean(string, bl).commit();
        } else {
            this.sp.edit().putBoolean(string, bl).apply();
        }
    }

    public void remove(String string) {
        this.remove(string, false);
    }

    public void remove(String string, boolean bl) {
        if (bl) {
            this.sp.edit().remove(string).commit();
        } else {
            this.sp.edit().remove(string).apply();
        }
    }
}
