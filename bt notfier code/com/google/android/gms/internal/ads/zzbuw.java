/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzcoc
 *  com.google.android.gms.measurement.api.AppMeasurementSdk
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzcoc;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

public final class zzbuw
extends zzcoc {
    private final AppMeasurementSdk zza;

    zzbuw(AppMeasurementSdk appMeasurementSdk) {
        this.zza = appMeasurementSdk;
    }

    public final void zzb(Bundle bundle) throws RemoteException {
        this.zza.performAction(bundle);
    }

    public final Bundle zzc(Bundle bundle) throws RemoteException {
        return this.zza.performActionWithResponse(bundle);
    }

    public final void zzd(String string, String string2, Bundle bundle) throws RemoteException {
        this.zza.logEvent(string, string2, bundle);
    }

    public final void zze(String string, String string2, IObjectWrapper object) throws RemoteException {
        AppMeasurementSdk appMeasurementSdk = this.zza;
        object = object != null ? ObjectWrapper.unwrap((IObjectWrapper)object) : null;
        appMeasurementSdk.setUserProperty(string, string2, object);
    }

    public final Map zzf(String string, String string2, boolean bl) throws RemoteException {
        return this.zza.getUserProperties(string, string2, bl);
    }

    public final int zzg(String string) throws RemoteException {
        return this.zza.getMaxUserProperties(string);
    }

    public final void zzh(Bundle bundle) throws RemoteException {
        this.zza.setConditionalUserProperty(bundle);
    }

    public final void zzi(String string, String string2, Bundle bundle) throws RemoteException {
        this.zza.clearConditionalUserProperty(string, string2, bundle);
    }

    public final List zzj(String string, String string2) throws RemoteException {
        return this.zza.getConditionalUserProperties(string, string2);
    }

    public final String zzk() throws RemoteException {
        return this.zza.getAppInstanceId();
    }

    public final String zzl() throws RemoteException {
        return this.zza.getGmpAppId();
    }

    public final long zzm() throws RemoteException {
        return this.zza.generateEventId();
    }

    public final void zzn(String string) throws RemoteException {
        this.zza.beginAdUnitExposure(string);
    }

    public final void zzo(String string) throws RemoteException {
        this.zza.endAdUnitExposure(string);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zza.setConsent(bundle);
    }

    public final void zzq(IObjectWrapper object, String string, String string2) throws RemoteException {
        AppMeasurementSdk appMeasurementSdk = this.zza;
        object = object != null ? (Activity)ObjectWrapper.unwrap((IObjectWrapper)object) : null;
        appMeasurementSdk.setCurrentScreen((Activity)object, string, string2);
    }

    public final String zzr() throws RemoteException {
        return this.zza.getCurrentScreenName();
    }

    public final String zzs() throws RemoteException {
        return this.zza.getCurrentScreenClass();
    }

    public final String zzt() throws RemoteException {
        return this.zza.getAppIdOrigin();
    }
}
