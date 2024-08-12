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
 *  com.google.android.gms.internal.ads.zzfju
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzfju;

public final class zzfjp
extends zzc<zzfju> {
    private final int zze;

    public zzfjp(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, int n) {
        super(context, looper, 116, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
        this.zze = n;
    }

    public final int getMinApkVersion() {
        return this.zze;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.gass.START";
    }

    public final zzfju zzp() throws DeadObjectException {
        return (zzfju)super.getService();
    }
}
