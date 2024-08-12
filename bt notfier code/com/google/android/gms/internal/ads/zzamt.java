/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzams
 *  com.google.android.gms.internal.ads.zzamu
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzams;
import com.google.android.gms.internal.ads.zzamu;

public abstract class zzamt
extends zzadk
implements zzamu {
    public static zzamu zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (!(iInterface instanceof zzamu)) return new zzams(iBinder);
        return (zzamu)iInterface;
    }
}
