/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzccq
 *  com.google.android.gms.internal.ads.zzccs
 *  com.google.android.gms.internal.ads.zzccw
 *  com.google.android.gms.internal.ads.zzcdd
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgv
 *  com.google.android.gms.internal.ads.zzcgw
 *  com.google.android.gms.internal.ads.zzcgx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzccq;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzccw;
import com.google.android.gms.internal.ads.zzcdd;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgv;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzcgx;

public final class zzcde {
    /*
     * WARNING - void declaration
     */
    public static final zzccs zza(Context object, String string, zzbvg zzbvg2) {
        void var0_3;
        IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)object);
        Object var3_7 = null;
        try {
            object = ((zzccw)zzcgx.zza((Context)object, (String)"com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", (zzcgv)zzcdd.zza)).zze(iObjectWrapper, string, zzbvg2, 213806000);
            object = object == null ? var3_7 : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd")) instanceof zzccs ? (zzccs)string : new zzccq((IBinder)object));
            return object;
        }
        catch (RemoteException remoteException) {
        }
        catch (zzcgw zzcgw2) {
            // empty catch block
        }
        zzcgt.zzl((String)"#007 Could not call remote method.", (Throwable)var0_3);
        return null;
    }
}
