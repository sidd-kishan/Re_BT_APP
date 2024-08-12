/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.internal.measurement.zzbs
 *  com.google.android.gms.measurement.api.AppMeasurementSdk$EventInterceptor
 *  com.google.android.gms.measurement.api.AppMeasurementSdk$OnEventListener
 *  com.google.android.gms.measurement.internal.zzgp
 *  com.google.android.gms.measurement.internal.zzgq
 */
package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzgp;
import com.google.android.gms.measurement.internal.zzgq;
import java.util.List;
import java.util.Map;

public class AppMeasurementSdk {
    private final zzbs zza;

    public AppMeasurementSdk(zzbs zzbs2) {
        this.zza = zzbs2;
    }

    public static AppMeasurementSdk getInstance(Context context) {
        return zzbs.zza((Context)context, null, null, null, null).zzb();
    }

    public static AppMeasurementSdk getInstance(Context context, String string, String string2, String string3, Bundle bundle) {
        return zzbs.zza((Context)context, (String)string, (String)string2, (String)string3, (Bundle)bundle).zzb();
    }

    public void beginAdUnitExposure(String string) {
        this.zza.zzu(string);
    }

    public void clearConditionalUserProperty(String string, String string2, Bundle bundle) {
        this.zza.zzl(string, string2, bundle);
    }

    public void endAdUnitExposure(String string) {
        this.zza.zzv(string);
    }

    public long generateEventId() {
        return this.zza.zzy();
    }

    public String getAppIdOrigin() {
        return this.zza.zzG();
    }

    public String getAppInstanceId() {
        return this.zza.zzx();
    }

    public List<Bundle> getConditionalUserProperties(String string, String string2) {
        return this.zza.zzm(string, string2);
    }

    public String getCurrentScreenClass() {
        return this.zza.zzA();
    }

    public String getCurrentScreenName() {
        return this.zza.zzz();
    }

    public String getGmpAppId() {
        return this.zza.zzw();
    }

    public int getMaxUserProperties(String string) {
        return this.zza.zzE(string);
    }

    public Map<String, Object> getUserProperties(String string, String string2, boolean bl) {
        return this.zza.zzB(string, string2, bl);
    }

    public void logEvent(String string, String string2, Bundle bundle) {
        this.zza.zzh(string, string2, bundle);
    }

    public void logEventNoInterceptor(String string, String string2, Bundle bundle, long l) {
        this.zza.zzi(string, string2, bundle, l);
    }

    public void performAction(Bundle bundle) {
        this.zza.zzD(bundle, false);
    }

    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zzD(bundle, true);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zze((zzgq)onEventListener);
    }

    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zzk(bundle);
    }

    public void setConsent(Bundle bundle) {
        this.zza.zzq(bundle);
    }

    public void setCurrentScreen(Activity activity, String string, String string2) {
        this.zza.zzo(activity, string, string2);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zzd((zzgp)eventInterceptor);
    }

    public void setMeasurementEnabled(Boolean bl) {
        this.zza.zzp(bl);
    }

    public void setMeasurementEnabled(boolean bl) {
        this.zza.zzp(Boolean.valueOf(bl));
    }

    public void setUserProperty(String string, String string2, Object object) {
        this.zza.zzj(string, string2, object, true);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzf((zzgq)onEventListener);
    }

    public final void zza(boolean bl) {
        this.zza.zzI(bl);
    }
}
