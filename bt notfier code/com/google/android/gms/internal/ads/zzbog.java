/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.widget.FrameLayout
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.dynamic.RemoteCreator
 *  com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException
 *  com.google.android.gms.internal.ads.zzbmj
 *  com.google.android.gms.internal.ads.zzbml
 *  com.google.android.gms.internal.ads.zzbmo
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbmj;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbog
extends RemoteCreator<zzbmo> {
    public zzbog() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /*
     * WARNING - void declaration
     */
    public final zzbml zza(Context object, FrameLayout frameLayout, FrameLayout frameLayout2) {
        void var1_4;
        Object var4_7 = null;
        try {
            IObjectWrapper iObjectWrapper = ObjectWrapper.wrap((Object)object);
            frameLayout = ObjectWrapper.wrap((Object)frameLayout);
            frameLayout2 = ObjectWrapper.wrap((Object)frameLayout2);
            object = ((zzbmo)this.getRemoteCreatorInstance((Context)object)).zze(iObjectWrapper, (IObjectWrapper)frameLayout, (IObjectWrapper)frameLayout2, 213806000);
            object = object == null ? var4_7 : ((frameLayout = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate")) instanceof zzbml ? (zzbml)frameLayout : new zzbmj((IBinder)object));
            return object;
        }
        catch (RemoteCreator.RemoteCreatorException remoteCreatorException) {
        }
        catch (RemoteException remoteException) {
            // empty catch block
        }
        zzcgt.zzj((String)"Could not create remote NativeAdViewDelegate.", (Throwable)var1_4);
        return null;
    }
}
