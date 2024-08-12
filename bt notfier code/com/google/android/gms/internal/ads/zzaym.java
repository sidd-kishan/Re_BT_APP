/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.DeadObjectException
 *  android.os.Looper
 *  com.google.android.gms.ads.internal.zzc
 *  com.google.android.gms.ads.zzb
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.common.util.ArrayUtils
 *  com.google.android.gms.internal.ads.zzayp
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbx;

public final class zzaym
extends zzc<zzayp> {
    zzaym(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzcbx.zza((Context)context), looper, 123, baseConnectionCallbacks, baseOnConnectionFailedListener, null);
    }

    public final Feature[] getApiFeatures() {
        return zzb.zzb;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    public final boolean zzp() {
        Object[] objectArray = this.getAvailableFeatures();
        zzbjd zzbjd2 = zzbjl.zzbl;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return false;
        if (!ArrayUtils.contains((Object[])objectArray, (Object)zzb.zza)) return false;
        return true;
    }

    public final zzayp zzq() throws DeadObjectException {
        return (zzayp)super.getService();
    }
}
