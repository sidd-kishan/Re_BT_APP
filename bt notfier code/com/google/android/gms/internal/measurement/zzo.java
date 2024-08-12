/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.measurement.zza
 *  com.google.android.gms.internal.measurement.zzc
 *  com.google.android.gms.internal.measurement.zzq
 *  com.google.android.gms.internal.measurement.zzt
 *  com.google.android.gms.internal.measurement.zzw
 *  com.google.android.gms.internal.measurement.zzy
 *  com.google.android.gms.internal.measurement.zzz
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzq;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.internal.measurement.zzz;
import java.util.Map;

public final class zzo
extends zza
implements zzq {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public final void beginAdUnitExposure(String string, long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeLong(l);
        this.zzc(23, parcel);
    }

    public final void clearConditionalUserProperty(String string, String string2, Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzc(9, parcel);
    }

    public final void clearMeasurementEnabled(long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeLong(l);
        this.zzc(43, parcel);
    }

    public final void endAdUnitExposure(String string, long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeLong(l);
        this.zzc(24, parcel);
    }

    public final void generateEventId(zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(22, parcel);
    }

    public final void getAppInstanceId(zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(20, parcel);
    }

    public final void getCachedAppInstanceId(zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(19, parcel);
    }

    public final void getConditionalUserProperties(String string, String string2, zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(10, parcel);
    }

    public final void getCurrentScreenClass(zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(17, parcel);
    }

    public final void getCurrentScreenName(zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(16, parcel);
    }

    public final void getGmpAppId(zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(21, parcel);
    }

    public final void getMaxUserProperties(String string, zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(6, parcel);
    }

    public final void getTestFlag(zzt zzt2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        parcel.writeInt(n);
        this.zzc(38, parcel);
    }

    public final void getUserProperties(String string, String string2, boolean bl, zzt zzt2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        zzc.zzb((Parcel)parcel, (boolean)bl);
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        this.zzc(5, parcel);
    }

    public final void initForTests(Map map) throws RemoteException {
        throw null;
    }

    public final void initialize(IObjectWrapper iObjectWrapper, zzz zzz2, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        zzc.zzd((Parcel)parcel, (Parcelable)zzz2);
        parcel.writeLong(l);
        this.zzc(1, parcel);
    }

    public final void isDataCollectionEnabled(zzt zzt2) throws RemoteException {
        throw null;
    }

    public final void logEvent(String string, String string2, Bundle bundle, boolean bl, boolean bl2, long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        zzc.zzb((Parcel)parcel, (boolean)bl);
        zzc.zzb((Parcel)parcel, (boolean)bl2);
        parcel.writeLong(l);
        this.zzc(2, parcel);
    }

    public final void logEventAndBundle(String string, String string2, Bundle bundle, zzt zzt2, long l) throws RemoteException {
        throw null;
    }

    public final void logHealthData(int n, String string, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(5);
        parcel.writeString(string);
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper2);
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper3);
        this.zzc(33, parcel);
    }

    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        parcel.writeLong(l);
        this.zzc(27, parcel);
    }

    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeLong(l);
        this.zzc(28, parcel);
    }

    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeLong(l);
        this.zzc(29, parcel);
    }

    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeLong(l);
        this.zzc(30, parcel);
    }

    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzt zzt2, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        parcel.writeLong(l);
        this.zzc(31, parcel);
    }

    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeLong(l);
        this.zzc(25, parcel);
    }

    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeLong(l);
        this.zzc(26, parcel);
    }

    public final void performAction(Bundle bundle, zzt zzt2, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        zzc.zze((Parcel)parcel, (IInterface)zzt2);
        parcel.writeLong(l);
        this.zzc(32, parcel);
    }

    public final void registerOnMeasurementEventListener(zzw zzw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzw2);
        this.zzc(35, parcel);
    }

    public final void resetAnalyticsData(long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeLong(l);
        this.zzc(12, parcel);
    }

    public final void setConditionalUserProperty(Bundle bundle, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        parcel.writeLong(l);
        this.zzc(8, parcel);
    }

    public final void setConsent(Bundle bundle, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        parcel.writeLong(l);
        this.zzc(44, parcel);
    }

    public final void setConsentThirdParty(Bundle bundle, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        parcel.writeLong(l);
        this.zzc(45, parcel);
    }

    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String string, String string2, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        parcel.writeString(string2);
        parcel.writeLong(l);
        this.zzc(15, parcel);
    }

    public final void setDataCollectionEnabled(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzb((Parcel)parcel, (boolean)bl);
        this.zzc(39, parcel);
    }

    public final void setDefaultEventParameters(Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzc(42, parcel);
    }

    public final void setEventInterceptor(zzw zzw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzw2);
        this.zzc(34, parcel);
    }

    public final void setInstanceIdProvider(zzy zzy2) throws RemoteException {
        throw null;
    }

    public final void setMeasurementEnabled(boolean bl, long l) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzb((Parcel)parcel, (boolean)bl);
        parcel.writeLong(l);
        this.zzc(11, parcel);
    }

    public final void setMinimumSessionDuration(long l) throws RemoteException {
        throw null;
    }

    public final void setSessionTimeoutDuration(long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeLong(l);
        this.zzc(14, parcel);
    }

    public final void setUserId(String string, long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeLong(l);
        this.zzc(7, parcel);
    }

    public final void setUserProperty(String string, String string2, IObjectWrapper iObjectWrapper, boolean bl, long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        zzc.zze((Parcel)parcel, (IInterface)iObjectWrapper);
        zzc.zzb((Parcel)parcel, (boolean)bl);
        parcel.writeLong(l);
        this.zzc(4, parcel);
    }

    public final void unregisterOnMeasurementEventListener(zzw zzw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zze((Parcel)parcel, (IInterface)zzw2);
        this.zzc(36, parcel);
    }
}
