/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzffw
 *  com.google.android.gms.internal.ads.zzffy
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzffw;
import com.google.android.gms.internal.ads.zzffy;

public abstract class zzffx
extends zzadk
implements zzffy {
    public static zzffy zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.omid.IOmid");
        if (!(iInterface instanceof zzffy)) return new zzffw(iBinder);
        return (zzffy)iInterface;
    }
}
