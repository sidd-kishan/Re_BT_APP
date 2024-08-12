/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzbfo
 *  com.google.android.gms.internal.ads.zzcgv
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbfo;
import com.google.android.gms.internal.ads.zzcgv;

final class zzbde
implements zzcgv {
    static final zzcgv zza = new zzbde();

    private zzbde() {
    }

    public final Object zza(Object object) {
        IInterface iInterface;
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator")) instanceof zzbfo ? (zzbfo)iInterface : new zzbfo((IBinder)object));
        return object;
    }
}
