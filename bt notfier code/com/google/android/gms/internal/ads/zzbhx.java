/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamic.RemoteCreator
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 *  com.google.android.gms.internal.ads.zzbgc
 *  com.google.android.gms.internal.ads.zzbge
 *  com.google.android.gms.internal.ads.zzbgf
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbhx
extends RemoteCreator<zzbgf> {
    public zzbhx() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /*
     * WARNING - void declaration
     */
    public final zzbge zza(Context object) {
        void var1_4;
        IInterface iInterface = null;
        try {
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)object);
            object = ((zzbgf)this.getRemoteCreatorInstance((Context)object)).zze(iObjectWrapper, 213806000);
            object = object == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager")) instanceof zzbge ? (zzbge)iInterface : new zzbgc((IBinder)object));
            return object;
        }
        catch (RemoteCreator.RemoteCreatorException remoteCreatorException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzj((String)"Could not get remote MobileAdsSettingManager.", (Throwable)var1_4);
        return null;
    }
}
