/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzgdt {
    public static boolean zza() {
        return "The Android Project".equals(System.getProperty("java.vendor"));
    }

    public static int zzb() {
        try {
            int n = Class.forName("android.os.Build$VERSION").getDeclaredField("SDK_INT").getInt(null);
            return n;
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException reflectiveOperationException) {
            return -1;
        }
    }
}
