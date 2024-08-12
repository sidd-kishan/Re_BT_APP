/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamic.RemoteCreator
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 *  com.google.android.gms.internal.ads.zzbfh
 *  com.google.android.gms.internal.ads.zzbfj
 *  com.google.android.gms.internal.ads.zzbfk
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfk;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbdd
extends RemoteCreator<zzbfk> {
    public zzbdd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /*
     * WARNING - void declaration
     */
    public final zzbfj zza(Context object, String string, zzbvg zzbvg2) {
        void var1_4;
        Object var4_7 = null;
        try {
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)object);
            object = ((zzbfk)this.getRemoteCreatorInstance((Context)object)).zze(iObjectWrapper, string, zzbvg2, 213806000);
            object = object == null ? var4_7 : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder")) instanceof zzbfj ? (zzbfj)string : new zzbfh((IBinder)object));
            return object;
        }
        catch (RemoteCreator.RemoteCreatorException remoteCreatorException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzj((String)"Could not create remote builder for AdLoader.", (Throwable)var1_4);
        return null;
    }
}
