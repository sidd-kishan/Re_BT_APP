/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  com.google.android.gms.common.wrappers.Wrappers
 *  com.google.android.gms.internal.common.zzi
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzi;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight {
    private static volatile int zza = -1;

    @Deprecated
    public static Context getDeviceProtectedStorageContext(Context context) {
        Context context2 = context;
        if (!zzi.zza()) return context2;
        context2 = context;
        if (context.isDeviceProtectedStorage()) return context2;
        context2 = context.createDeviceProtectedStorageContext();
        return context2;
    }

    @Deprecated
    public static byte[] getPackageCertificateHashBytes(Context context, String object) throws PackageManager.NameNotFoundException {
        context = Wrappers.packageManager((Context)context).getPackageInfo((String)object, 64);
        if (context.signatures == null) return null;
        if (context.signatures.length != 1) return null;
        object = AndroidUtilsLight.zza("SHA1");
        if (object != null) return ((MessageDigest)object).digest(context.signatures[0].toByteArray());
        return null;
    }

    public static MessageDigest zza(String string) {
        int n = 0;
        while (n < 2) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(string);
                if (messageDigest != null) return messageDigest;
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
            ++n;
        }
        return null;
    }
}
