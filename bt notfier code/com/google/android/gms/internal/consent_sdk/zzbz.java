/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build
 *  android.provider.Settings$Secure
 */
package com.google.android.gms.internal.consent_sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzbz {
    private static String zza;

    public static String zza(Context object) {
        synchronized (zzbz.class) {
            if (zza == null) {
                if ((object = (object = object.getContentResolver()) == null ? null : Settings.Secure.getString((ContentResolver)object, (String)"android_id")) == null || zzbz.zza()) {
                    object = "emulator";
                }
                zza = zzbz.zza((String)object);
            }
            object = zza;
            return object;
        }
    }

    private static String zza(String string) {
        int n = 0;
        while (n < 3) {
            try {
                Object object = MessageDigest.getInstance("MD5");
                ((MessageDigest)object).update(string.getBytes());
                BigInteger bigInteger = new BigInteger(1, ((MessageDigest)object).digest());
                object = String.format("%032X", bigInteger);
                return object;
            }
            catch (ArithmeticException arithmeticException) {
                return "";
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                ++n;
            }
        }
        return "";
    }

    public static boolean zza() {
        if (Build.FINGERPRINT.startsWith("generic")) return true;
        if (Build.FINGERPRINT.startsWith("unknown")) return true;
        if (Build.MODEL.contains("google_sdk")) return true;
        if (Build.MODEL.contains("Emulator")) return true;
        if (Build.MODEL.contains("Android SDK built for x86")) return true;
        if (Build.MANUFACTURER.contains("Genymotion")) return true;
        if (Build.BRAND.startsWith("generic")) {
            if (Build.DEVICE.startsWith("generic")) return true;
        }
        if (!"google_sdk".equals(Build.PRODUCT)) return false;
        return true;
    }
}
