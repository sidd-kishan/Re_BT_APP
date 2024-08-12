/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.DeadObjectException
 *  android.os.Looper
 *  com.google.android.gms.ads.internal.zzc
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzbre
 *  com.google.android.gms.internal.ads.zzcbx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzbre;
import com.google.android.gms.internal.ads.zzcbx;

public final class zzbqx
extends zzc<zzbre> {
    zzbqx(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzcbx.zza((Context)context), looper, 166, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    public final zzbre zzp() throws DeadObjectException {
        return (zzbre)super.getService();
    }
}
