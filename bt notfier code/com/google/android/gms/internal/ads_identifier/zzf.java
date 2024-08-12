/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads_identifier.zzb
 *  com.google.android.gms.internal.ads_identifier.zze
 *  com.google.android.gms.internal.ads_identifier.zzg
 */
package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads_identifier.zzb;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzg;

public abstract class zzf
extends zzb
implements zze {
    public static zze zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (!(iInterface instanceof zze)) return new zzg(iBinder);
        return (zze)iInterface;
    }
}
