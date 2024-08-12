/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContextWrapper
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzged
 *  com.google.android.gms.internal.ads.zzzo
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ContextWrapper;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzged;
import com.google.android.gms.internal.ads.zzzo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class zzabu {
    private static final char[] zza = "0123456789abcdef".toCharArray();

    public static String zza(String object) {
        Object object2 = object;
        if (object == null) return object2;
        object2 = object;
        if (!((String)object).matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) return object2;
        UUID uUID = UUID.fromString((String)object);
        object2 = new byte[16];
        object = ByteBuffer.wrap((byte[])object2);
        ((ByteBuffer)object).putLong(uUID.getMostSignificantBits());
        ((ByteBuffer)object).putLong(uUID.getLeastSignificantBits());
        object2 = zzzo.zza((byte[])object2, (boolean)true);
        return object2;
    }

    public static String zzb(byte[] byArray) {
        int n = byArray.length;
        char[] cArray = new char[n + n];
        n = 0;
        while (n < byArray.length) {
            int n2 = byArray[n] & 0xFF;
            int n3 = n + n;
            char[] cArray2 = zza;
            cArray[n3] = cArray2[n2 >>> 4];
            cArray[n3 + 1] = cArray2[n2 & 0xF];
            ++n;
        }
        return new String(cArray);
    }

    public static byte[] zzc(String object) {
        int n = ((String)object).length();
        if (n % 2 != 0) {
            object = new IllegalArgumentException("String must be of even-length");
            throw object;
        }
        byte[] byArray = new byte[n / 2];
        int n2 = 0;
        while (n2 < n) {
            byArray[n2 / 2] = (byte)((Character.digit(((String)object).charAt(n2), 16) << 4) + Character.digit(((String)object).charAt(n2 + 1), 16));
            n2 += 2;
        }
        return byArray;
    }

    public static String zzd(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        zzged.zzc((Throwable)throwable, (PrintWriter)new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static boolean zze(String string) {
        if (string == null) return true;
        if (!string.isEmpty()) return false;
        return true;
    }

    public static boolean zzf() {
        if (Looper.myLooper() != Looper.getMainLooper()) return false;
        return true;
    }

    public static boolean zzg(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) return false;
        if (displayMetrics.density == 0.0f) return false;
        return true;
    }

    public static long zzh(double d, int n, DisplayMetrics displayMetrics) {
        double d2 = displayMetrics.density;
        Double.isNaN(d2);
        return Math.round(d / d2);
    }

    public static Activity zzi(View view) {
        View view2 = view.getRootView();
        if (view2 != null) {
            view = view2;
        }
        view = view.getContext();
        int n = 0;
        while (view instanceof ContextWrapper) {
            if (n >= 10) return null;
            if (view instanceof Activity) {
                return (Activity)view;
            }
            view = ((ContextWrapper)view).getBaseContext();
            ++n;
        }
        return null;
    }
}
