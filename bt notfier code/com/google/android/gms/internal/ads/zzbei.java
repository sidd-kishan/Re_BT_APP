/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  com.google.android.gms.internal.ads.zzbgf
 *  com.google.android.gms.internal.ads.zzcgv
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzcgv;

final class zzbei
implements zzcgv {
    static final zzcgv zza = new zzbei();

    private zzbei() {
    }

    public final Object zza(Object object) {
        IInterface iInterface;
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator")) instanceof zzbgf ? (zzbgf)iInterface : new zzbgf((IBinder)object));
        return object;
    }
}
