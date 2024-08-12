/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.view.View
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamic.RemoteCreator
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 *  com.google.android.gms.internal.ads.zzbmp
 *  com.google.android.gms.internal.ads.zzbmr
 *  com.google.android.gms.internal.ads.zzbmu
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.internal.ads.zzbmu;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.HashMap;

public final class zzboh
extends RemoteCreator<zzbmu> {
    public zzboh() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    /*
     * WARNING - void declaration
     */
    public final zzbmr zza(View object, HashMap<String, View> iObjectWrapper, HashMap<String, View> iObjectWrapper2) {
        void var1_4;
        Object var4_7 = null;
        try {
            IObjectWrapper iObjectWrapper3 = ObjectWrapper.wrap((Object)object);
            iObjectWrapper = ObjectWrapper.wrap(iObjectWrapper);
            iObjectWrapper2 = ObjectWrapper.wrap(iObjectWrapper2);
            object = ((zzbmu)this.getRemoteCreatorInstance(object.getContext())).zze(iObjectWrapper3, iObjectWrapper, iObjectWrapper2);
            object = object == null ? var4_7 : ((iObjectWrapper = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate")) instanceof zzbmr ? (zzbmr)iObjectWrapper : new zzbmp((IBinder)object));
            return object;
        }
        catch (RemoteCreator.RemoteCreatorException remoteCreatorException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzj((String)"Could not create remote NativeAdViewHolderDelegate.", (Throwable)var1_4);
        return null;
    }
}
