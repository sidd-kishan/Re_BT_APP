/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.signature.ObjectKey
 */
package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.signature.ObjectKey;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> PACKAGE_NAME_TO_KEY = new ConcurrentHashMap<String, Key>();
    private static final String TAG = "AppVersionSignature";

    private ApplicationVersionSignature() {
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot resolve info for");
            stringBuilder.append(context.getPackageName());
            Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)nameNotFoundException);
            return null;
        }
    }

    private static String getVersionCode(PackageInfo object) {
        object = object != null ? String.valueOf(object.versionCode) : UUID.randomUUID().toString();
        return object;
    }

    public static Key obtain(Context context) {
        Key key;
        String string = context.getPackageName();
        Key key2 = key = (Key)PACKAGE_NAME_TO_KEY.get(string);
        if (key != null) return key2;
        key2 = ApplicationVersionSignature.obtainVersionSignature(context);
        if ((context = PACKAGE_NAME_TO_KEY.putIfAbsent(string, key2)) == null) return key2;
        key2 = context;
        return key2;
    }

    private static Key obtainVersionSignature(Context context) {
        return new ObjectKey((Object)ApplicationVersionSignature.getVersionCode(ApplicationVersionSignature.getPackageInfo(context)));
    }

    static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }
}
