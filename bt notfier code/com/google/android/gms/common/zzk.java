/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.zzi
 */
package com.google.android.gms.common;

import com.google.android.gms.common.zzi;
import java.lang.ref.WeakReference;

abstract class zzk
extends zzi {
    private static final WeakReference<byte[]> zzb = new WeakReference<Object>(null);
    private WeakReference<byte[]> zza = zzb;

    zzk(byte[] byArray) {
        super(byArray);
    }

    protected abstract byte[] zzb();

    final byte[] zzc() {
        synchronized (this) {
            Object object;
            byte[] byArray = object = (byte[])this.zza.get();
            if (object != null) return byArray;
            byArray = this.zzb();
            object = new WeakReference;
            object(byArray);
            this.zza = object;
            return byArray;
        }
    }
}
