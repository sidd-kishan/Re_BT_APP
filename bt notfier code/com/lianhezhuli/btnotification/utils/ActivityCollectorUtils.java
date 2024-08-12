/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.lianhezhuli.btnotification.utils;

import android.app.Activity;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ActivityCollectorUtils {
    private static final HashMap<Class<?>, Activity> ACTIVITIES = new LinkedHashMap();

    public static void addActivity(Activity activity, Class<?> clazz) {
        ACTIVITIES.put(clazz, activity);
    }

    public static void finishAll() {
        HashMap<Class<?>, Activity> hashMap = ACTIVITIES;
        if (hashMap == null) return;
        if (hashMap.size() == 0) return;
        for (Class clazz : ACTIVITIES.keySet()) {
            Activity clazz2 = ACTIVITIES.get(clazz);
            if (clazz2 == null || clazz2.isFinishing()) continue;
            clazz2.finish();
        }
        System.exit(0);
    }

    public static void finishOther(Class<?> clazz) {
        HashMap<Class<?>, Activity> hashMap = ACTIVITIES;
        if (hashMap == null) return;
        if (hashMap.size() == 0) {
            return;
        }
        hashMap = ACTIVITIES.keySet().iterator();
        while (hashMap.hasNext()) {
            Class clazz2 = (Class)hashMap.next();
            if (clazz2 == clazz || (clazz2 = ACTIVITIES.get(clazz2)) == null || clazz2.isFinishing()) continue;
            clazz2.finish();
        }
    }

    public static <T extends Activity> T getActivity(Class<T> clazz) {
        return (T)ACTIVITIES.get(clazz);
    }

    public static <T extends Activity> boolean isActivityExist(Class<T> clazz) {
        boolean bl;
        clazz = ActivityCollectorUtils.getActivity(clazz);
        boolean bl2 = false;
        if (clazz == null) {
            bl = bl2;
        } else {
            bl = bl2;
            if (clazz.isFinishing()) return bl;
            bl = bl2;
            if (clazz.isDestroyed()) return bl;
            bl = true;
        }
        return bl;
    }

    public static void removeActivity(Activity activity) {
        if (!ACTIVITIES.containsValue(activity)) return;
        ACTIVITIES.remove(activity.getClass());
    }
}
