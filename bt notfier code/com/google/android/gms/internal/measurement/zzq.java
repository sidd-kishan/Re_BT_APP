/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.measurement.zzt
 *  com.google.android.gms.internal.measurement.zzw
 *  com.google.android.gms.internal.measurement.zzy
 *  com.google.android.gms.internal.measurement.zzz
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.measurement.zzw;
import com.google.android.gms.internal.measurement.zzy;
import com.google.android.gms.internal.measurement.zzz;
import java.util.Map;

public interface zzq
extends IInterface {
    public void beginAdUnitExposure(String var1, long var2) throws RemoteException;

    public void clearConditionalUserProperty(String var1, String var2, Bundle var3) throws RemoteException;

    public void clearMeasurementEnabled(long var1) throws RemoteException;

    public void endAdUnitExposure(String var1, long var2) throws RemoteException;

    public void generateEventId(zzt var1) throws RemoteException;

    public void getAppInstanceId(zzt var1) throws RemoteException;

    public void getCachedAppInstanceId(zzt var1) throws RemoteException;

    public void getConditionalUserProperties(String var1, String var2, zzt var3) throws RemoteException;

    public void getCurrentScreenClass(zzt var1) throws RemoteException;

    public void getCurrentScreenName(zzt var1) throws RemoteException;

    public void getGmpAppId(zzt var1) throws RemoteException;

    public void getMaxUserProperties(String var1, zzt var2) throws RemoteException;

    public void getTestFlag(zzt var1, int var2) throws RemoteException;

    public void getUserProperties(String var1, String var2, boolean var3, zzt var4) throws RemoteException;

    public void initForTests(Map var1) throws RemoteException;

    public void initialize(IObjectWrapper var1, zzz var2, long var3) throws RemoteException;

    public void isDataCollectionEnabled(zzt var1) throws RemoteException;

    public void logEvent(String var1, String var2, Bundle var3, boolean var4, boolean var5, long var6) throws RemoteException;

    public void logEventAndBundle(String var1, String var2, Bundle var3, zzt var4, long var5) throws RemoteException;

    public void logHealthData(int var1, String var2, IObjectWrapper var3, IObjectWrapper var4, IObjectWrapper var5) throws RemoteException;

    public void onActivityCreated(IObjectWrapper var1, Bundle var2, long var3) throws RemoteException;

    public void onActivityDestroyed(IObjectWrapper var1, long var2) throws RemoteException;

    public void onActivityPaused(IObjectWrapper var1, long var2) throws RemoteException;

    public void onActivityResumed(IObjectWrapper var1, long var2) throws RemoteException;

    public void onActivitySaveInstanceState(IObjectWrapper var1, zzt var2, long var3) throws RemoteException;

    public void onActivityStarted(IObjectWrapper var1, long var2) throws RemoteException;

    public void onActivityStopped(IObjectWrapper var1, long var2) throws RemoteException;

    public void performAction(Bundle var1, zzt var2, long var3) throws RemoteException;

    public void registerOnMeasurementEventListener(zzw var1) throws RemoteException;

    public void resetAnalyticsData(long var1) throws RemoteException;

    public void setConditionalUserProperty(Bundle var1, long var2) throws RemoteException;

    public void setConsent(Bundle var1, long var2) throws RemoteException;

    public void setConsentThirdParty(Bundle var1, long var2) throws RemoteException;

    public void setCurrentScreen(IObjectWrapper var1, String var2, String var3, long var4) throws RemoteException;

    public void setDataCollectionEnabled(boolean var1) throws RemoteException;

    public void setDefaultEventParameters(Bundle var1) throws RemoteException;

    public void setEventInterceptor(zzw var1) throws RemoteException;

    public void setInstanceIdProvider(zzy var1) throws RemoteException;

    public void setMeasurementEnabled(boolean var1, long var2) throws RemoteException;

    public void setMinimumSessionDuration(long var1) throws RemoteException;

    public void setSessionTimeoutDuration(long var1) throws RemoteException;

    public void setUserId(String var1, long var2) throws RemoteException;

    public void setUserProperty(String var1, String var2, IObjectWrapper var3, boolean var4, long var5) throws RemoteException;

    public void unregisterOnMeasurementEventListener(zzw var1) throws RemoteException;
}
