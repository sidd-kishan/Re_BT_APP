/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean bl) {
        parcel.writeInt(1);
    }

    public static boolean zza(Parcel parcel) {
        if (parcel.readInt() == 0) return false;
        return true;
    }
}
