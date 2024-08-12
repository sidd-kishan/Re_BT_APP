/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamic.RemoteCreator
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 *  com.google.android.gms.internal.ads.zzbzo
 *  com.google.android.gms.internal.ads.zzbzq
 *  com.google.android.gms.internal.ads.zzbzt
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbzn
extends RemoteCreator<zzbzt> {
    public zzbzn() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final zzbzq zza(Activity object) {
        IInterface iInterface = null;
        try {
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)object);
            object = ((zzbzt)this.getRemoteCreatorInstance((Context)object)).zze(iObjectWrapper);
            object = object == null ? iInterface : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay")) instanceof zzbzq ? (zzbzq)iInterface : new zzbzo((IBinder)object));
            return object;
        }
        catch (RemoteCreator.RemoteCreatorException remoteCreatorException) {
            zzcgt.zzj((String)"Could not create remote AdOverlay.", (Throwable)remoteCreatorException);
            return null;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzj((String)"Could not create remote AdOverlay.", (Throwable)remoteException);
            return null;
        }
    }
}
