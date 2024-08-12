/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzavd
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzavd;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

public final class zzave {
    public static final int zza;
    public static final String zzb;
    public static final String zzc;
    public static final String zzd;
    public static final String zze;
    private static final Pattern zzf;
    private static final Pattern zzg;
    private static final Pattern zzh;

    static {
        String string;
        int n = Build.VERSION.SDK_INT == 25 && Build.VERSION.CODENAME.charAt(0) == 'O' ? 26 : Build.VERSION.SDK_INT;
        zza = n;
        zzb = Build.DEVICE;
        zzc = Build.MANUFACTURER;
        zzd = string = Build.MODEL;
        String string2 = zzb;
        String string3 = zzc;
        n = zza;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 17 + String.valueOf(string).length() + String.valueOf(string3).length());
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(string3);
        stringBuilder.append(", ");
        stringBuilder.append(n);
        zze = stringBuilder.toString();
        zzf = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
        zzg = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
        zzh = Pattern.compile("%([A-Fa-f0-9]{2})");
    }

    public static boolean zza(Object object, Object object2) {
        boolean bl;
        if (object == null) {
            if (object2 == null) return true;
            bl = false;
        } else {
            bl = object.equals(object2);
        }
        return bl;
    }

    public static ExecutorService zzb(String string) {
        return Executors.newSingleThreadExecutor((ThreadFactory)new zzavd("Loader:ExtractorMediaPeriod"));
    }

    /*
     * Enabled force condition propagation
     */
    public static void zzc(zzatz zzatz2) {
        if (zzatz2 == null) return;
        try {
            zzatz2.zzd();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static byte[] zzd(String string) {
        return string.getBytes(Charset.defaultCharset());
    }

    public static int zze(int n, int n2) {
        return (n + n2 - 1) / n2;
    }

    public static int zzf(int n, int n2, int n3) {
        return Math.max(n2, Math.min(n, n3));
    }

    public static float zzg(float f, float f2, float f3) {
        return Math.max(0.1f, Math.min(f, 8.0f));
    }

    public static int zzh(long[] lArray, long l, boolean bl, boolean bl2) {
        int n;
        int n2 = n = Arrays.binarySearch(lArray, l);
        if (n < 0) {
            n2 = -(n + 2);
        } else {
            while ((n = n2 - 1) >= 0) {
                n2 = n;
                if (lArray[n] == l) continue;
            }
            n2 = n + 1;
        }
        n = n2;
        if (!bl2) return n;
        n = Math.max(0, n2);
        return n;
    }

    public static int zzi(long[] lArray, long l, boolean bl, boolean bl2) {
        int n;
        int n2 = n = Arrays.binarySearch(lArray, l);
        if (n < 0) {
            n2 = ~n;
        } else {
            while ((n = n2 + 1) < lArray.length) {
                n2 = n;
                if (lArray[n] == l) continue;
            }
            n2 = bl ? n - 1 : n;
        }
        if (!bl2) return n2;
        return Math.min(lArray.length - 1, n2);
    }

    public static long zzj(long l, long l2, long l3) {
        if (l3 >= l2) {
            if (l3 % l2 == 0L) return l / (l3 / l2);
        }
        if (l3 < l2 && l2 % l3 == 0L) {
            return l * (l2 / l3);
        }
        double d = l;
        double d2 = l2;
        double d3 = l3;
        Double.isNaN(d2);
        Double.isNaN(d3);
        d3 = d2 / d3;
        Double.isNaN(d);
        return (long)(d * d3);
    }

    public static void zzk(long[] lArray, long l, long l2) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (l2 >= 1000000L && l2 % 1000000L == 0L) {
            l = l2 / 1000000L;
            n = n3;
            while (n < lArray.length) {
                lArray[n] = lArray[n] / l;
                ++n;
            }
            return;
        }
        if (l2 < 1000000L && 1000000L % l2 == 0L) {
            l = 1000000L / l2;
            while (n < lArray.length) {
                lArray[n] = lArray[n] * l;
                ++n;
            }
            return;
        }
        double d = l2;
        Double.isNaN(d);
        d = 1000000.0 / d;
        n = n2;
        while (n < lArray.length) {
            double d2 = lArray[n];
            Double.isNaN(d2);
            lArray[n] = (long)(d2 * d);
            ++n;
        }
    }

    public static int zzl(String string) {
        int n = string.length();
        int n2 = 0;
        boolean bl = n <= 4;
        zzaup.zza((boolean)bl);
        int n3 = 0;
        while (n2 < n) {
            n3 = n3 << 8 | string.charAt(n2);
            ++n2;
        }
        return n3;
    }

    public static byte[] zzm(String object) {
        object = new byte[38];
        int n = 0;
        while (n < 38) {
            int n2 = n + n;
            object[n] = (byte)((Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(n2), 16) << 4) + Character.digit("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78".charAt(n2 + 1), 16));
            ++n;
        }
        return object;
    }

    public static String zzn(Object[] objectArray) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (n2 < (n = objectArray.length)) {
            stringBuilder.append(objectArray[n2].getClass().getSimpleName());
            if (n2 < n - 1) {
                stringBuilder.append(", ");
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    public static int zzo(int n) {
        if (n == 8) return 3;
        if (n == 16) return 2;
        if (n == 24) return Integer.MIN_VALUE;
        if (n == 32) return 0x40000000;
        return 0;
    }

    public static int zzp(int n, int n2) {
        if (n == Integer.MIN_VALUE) return n2 * 3;
        if (n == 0x40000000) return n2 * 4;
        if (n == 2) return n2 + n2;
        if (n != 3) throw new IllegalArgumentException();
        return n2;
    }

    public static int zzq(int n) {
        if (n == 1) return 0x360000;
        return 0xC80000;
    }
}
