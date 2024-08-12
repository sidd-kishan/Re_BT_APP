/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  com.google.android.gms.appset.zze
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.internal.ConnectionCallbacks
 *  com.google.android.gms.common.api.internal.OnConnectionFailedListener
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.GmsClient
 *  com.google.android.gms.internal.appset.zzg
 */
package com.google.android.gms.internal.appset;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.appset.zze;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.internal.appset.zzg;

public final class zzd
extends GmsClient<zzg> {
    protected zzd(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 300, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    protected final /* synthetic */ IInterface createServiceInterface(IBinder object) {
        IInterface iInterface;
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.appset.internal.IAppSetService")) instanceof zzg ? (zzg)iInterface : new zzg(object));
        return object;
    }

    public final Feature[] getApiFeatures() {
        return zze.zzb;
    }

    public final int getMinApkVersion() {
        return 212800000;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.appset.internal.IAppSetService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.appset.service.START";
    }

    protected final boolean getUseDynamicLookup() {
        return true;
    }

    public final boolean usesClientTelemetry() {
        return true;
    }
}
