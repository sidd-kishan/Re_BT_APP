/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzbfk
 *  com.google.android.gms.internal.ads.zzcgv
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbfk;
import com.google.android.gms.internal.ads.zzcgv;

final class zzbeg
implements zzcgv {
    static final zzcgv zza = new zzbeg();

    private zzbeg() {
    }

    public final Object zza(Object object) {
        IInterface iInterface;
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator")) instanceof zzbfk ? (zzbfk)iInterface : new zzbfk((IBinder)object));
        return object;
    }
}
