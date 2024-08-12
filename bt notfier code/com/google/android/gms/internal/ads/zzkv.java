/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.system.ErrnoException
 *  android.system.OsConstants
 */
package com.google.android.gms.internal.ads;

import android.system.ErrnoException;
import android.system.OsConstants;

final class zzkv {
    static /* synthetic */ boolean zza(Throwable throwable) {
        return zzkv.zzb(throwable);
    }

    private static boolean zzb(Throwable throwable) {
        if (!(throwable instanceof ErrnoException)) return false;
        if (((ErrnoException)throwable).errno != OsConstants.EACCES) return false;
        return true;
    }
}
