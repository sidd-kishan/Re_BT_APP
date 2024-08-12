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
 *  com.google.android.gms.internal.ads.zzcbb
 *  com.google.android.gms.internal.ads.zzcbx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzcbb;
import com.google.android.gms.internal.ads.zzcbx;

public final class zzcau
extends zzc<zzcbb> {
    public zzcau(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzcbx.zza((Context)context), looper, 8, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    public final zzcbb zzp() throws DeadObjectException {
        return (zzcbb)super.getService();
    }
}
