/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  androidx.collection.ArraySet
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.GoogleApiAvailability
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.GoogleApi
 *  com.google.android.gms.common.api.HasApiKey
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.common.api.internal.BackgroundDetector
 *  com.google.android.gms.common.api.internal.BackgroundDetector$BackgroundStateChangeListener
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey
 *  com.google.android.gms.common.api.internal.RegisterListenerMethod
 *  com.google.android.gms.common.api.internal.StatusExceptionMapper
 *  com.google.android.gms.common.api.internal.TaskApiCall
 *  com.google.android.gms.common.api.internal.UnregisterListenerMethod
 *  com.google.android.gms.common.api.internal.zaab
 *  com.google.android.gms.common.api.internal.zaac
 *  com.google.android.gms.common.api.internal.zabf
 *  com.google.android.gms.common.api.internal.zabg
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zabm
 *  com.google.android.gms.common.api.internal.zabx
 *  com.google.android.gms.common.api.internal.zaby
 *  com.google.android.gms.common.api.internal.zacb
 *  com.google.android.gms.common.api.internal.zacc
 *  com.google.android.gms.common.api.internal.zae
 *  com.google.android.gms.common.api.internal.zaf
 *  com.google.android.gms.common.api.internal.zag
 *  com.google.android.gms.common.api.internal.zah
 *  com.google.android.gms.common.api.internal.zai
 *  com.google.android.gms.common.api.internal.zal
 *  com.google.android.gms.common.internal.MethodInvocation
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.RootTelemetryConfigManager
 *  com.google.android.gms.common.internal.RootTelemetryConfiguration
 *  com.google.android.gms.common.internal.TelemetryData
 *  com.google.android.gms.common.internal.TelemetryLogging
 *  com.google.android.gms.common.internal.TelemetryLoggingClient
 *  com.google.android.gms.common.internal.zal
 *  com.google.android.gms.common.util.DeviceProperties
 *  com.google.android.gms.internal.base.zap
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaab;
import com.google.android.gms.common.api.internal.zaac;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.api.internal.zabg;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zabm;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.api.internal.zaby;
import com.google.android.gms.common.api.internal.zacb;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.api.internal.zae;
import com.google.android.gms.common.api.internal.zaf;
import com.google.android.gms.common.api.internal.zag;
import com.google.android.gms.common.api.internal.zah;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class GoogleApiManager
implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zag = new Object();
    private static GoogleApiManager zaj;
    private long zac = 5000L;
    private long zad = 120000L;
    private long zae = 10000L;
    private boolean zaf = false;
    private TelemetryData zah;
    private TelemetryLoggingClient zai;
    private final Context zak;
    private final GoogleApiAvailability zal;
    private final com.google.android.gms.common.internal.zal zam;
    private final AtomicInteger zan = new AtomicInteger(1);
    private final AtomicInteger zao = new AtomicInteger(0);
    private final Map<ApiKey<?>, zabl<?>> zap = new ConcurrentHashMap(5, 0.75f, 1);
    private zaab zaq = null;
    private final Set<ApiKey<?>> zar = new ArraySet();
    private final Set<ApiKey<?>> zas = new ArraySet();
    @NotOnlyInitialized
    private final Handler zat;
    private volatile boolean zau = true;

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zak = context;
        this.zat = new zap(looper, (Handler.Callback)this);
        this.zal = googleApiAvailability;
        this.zam = new com.google.android.gms.common.internal.zal((GoogleApiAvailabilityLight)googleApiAvailability);
        if (DeviceProperties.isAuto((Context)context)) {
            this.zau = false;
        }
        context = this.zat;
        context.sendMessage(context.obtainMessage(6));
    }

    public static void reportSignOut() {
        Object object = zag;
        synchronized (object) {
            if (zaj == null) return;
            GoogleApiManager googleApiManager = zaj;
            googleApiManager.zao.incrementAndGet();
            googleApiManager = googleApiManager.zat;
            googleApiManager.sendMessageAtFrontOfQueue(googleApiManager.obtainMessage(10));
            return;
        }
    }

    static /* synthetic */ boolean zaA(GoogleApiManager googleApiManager, boolean bl) {
        googleApiManager.zaf = true;
        return true;
    }

    static /* synthetic */ Status zaB() {
        return zab;
    }

    static /* synthetic */ boolean zaC(GoogleApiManager googleApiManager) {
        return googleApiManager.zau;
    }

    static /* synthetic */ GoogleApiAvailability zaD(GoogleApiManager googleApiManager) {
        return googleApiManager.zal;
    }

    static /* synthetic */ long zaE(GoogleApiManager googleApiManager) {
        return googleApiManager.zae;
    }

    static /* synthetic */ Status zaF(ApiKey apiKey, ConnectionResult connectionResult) {
        return GoogleApiManager.zaJ(apiKey, connectionResult);
    }

    static /* synthetic */ Map zaG(GoogleApiManager googleApiManager) {
        return googleApiManager.zap;
    }

    private final zabl<?> zaH(GoogleApi<?> googleApi) {
        zabl zabl2;
        ApiKey apiKey = googleApi.getApiKey();
        zabl zabl3 = zabl2 = this.zap.get(apiKey);
        if (zabl2 == null) {
            zabl3 = new zabl(this, googleApi);
            this.zap.put(apiKey, zabl3);
        }
        if (zabl3.zap()) {
            this.zas.add(apiKey);
        }
        zabl3.zam();
        return zabl3;
    }

    private final <T> void zaI(TaskCompletionSource<T> handler, int n, GoogleApi googleApi) {
        if (n == 0) return;
        if ((googleApi = zabx.zaa((GoogleApiManager)this, (int)n, (ApiKey)googleApi.getApiKey())) == null) return;
        Task task = handler.getTask();
        handler = this.zat;
        handler.getClass();
        task.addOnCompleteListener(zabf.zaa((Handler)handler), (OnCompleteListener)googleApi);
    }

    private static Status zaJ(ApiKey<?> object, ConnectionResult connectionResult) {
        String string = object.zab();
        object = String.valueOf(connectionResult);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 63 + String.valueOf(object).length());
        stringBuilder.append("API: ");
        stringBuilder.append(string);
        stringBuilder.append(" is not available on this device. Connection failed with: ");
        stringBuilder.append((String)object);
        return new Status(connectionResult, stringBuilder.toString());
    }

    private final void zaK() {
        TelemetryData telemetryData = this.zah;
        if (telemetryData == null) return;
        if (telemetryData.zaa() > 0 || this.zam()) {
            this.zaL().log(telemetryData);
        }
        this.zah = null;
    }

    private final TelemetryLoggingClient zaL() {
        if (this.zai != null) return this.zai;
        this.zai = TelemetryLogging.getClient((Context)this.zak);
        return this.zai;
    }

    public static GoogleApiManager zaa(Context object) {
        Object object2 = zag;
        synchronized (object2) {
            if (zaj == null) {
                Object object3 = new HandlerThread("GoogleApiHandler", 9);
                object3.start();
                Looper looper = object3.getLooper();
                object3 = new GoogleApiManager(object.getApplicationContext(), looper, GoogleApiAvailability.getInstance());
                zaj = object3;
            }
            object = zaj;
            return object;
        }
    }

    public static GoogleApiManager zab() {
        Object object = zag;
        synchronized (object) {
            Preconditions.checkNotNull((Object)zaj, (Object)"Must guarantee manager is non-null before using getInstance");
            GoogleApiManager googleApiManager = zaj;
            return googleApiManager;
        }
    }

    static /* synthetic */ Handler zas(GoogleApiManager googleApiManager) {
        return googleApiManager.zat;
    }

    static /* synthetic */ Context zat(GoogleApiManager googleApiManager) {
        return googleApiManager.zak;
    }

    static /* synthetic */ long zau(GoogleApiManager googleApiManager) {
        return googleApiManager.zac;
    }

    static /* synthetic */ long zav(GoogleApiManager googleApiManager) {
        return googleApiManager.zad;
    }

    static /* synthetic */ com.google.android.gms.common.internal.zal zaw(GoogleApiManager googleApiManager) {
        return googleApiManager.zam;
    }

    static /* synthetic */ Object zax() {
        return zag;
    }

    static /* synthetic */ zaab zay(GoogleApiManager googleApiManager) {
        return googleApiManager.zaq;
    }

    static /* synthetic */ Set zaz(GoogleApiManager googleApiManager) {
        return googleApiManager.zar;
    }

    /*
     * Enabled force condition propagation
     */
    public final boolean handleMessage(Message object) {
        int n = ((Message)object).what;
        long l = 300000L;
        Object var6_4 = null;
        switch (n) {
            default: {
                n = ((Message)object).what;
                object = new StringBuilder(31);
                ((StringBuilder)object).append("Unknown message id: ");
                ((StringBuilder)object).append(n);
                Log.w((String)"GoogleApiManager", (String)((StringBuilder)object).toString());
                return false;
            }
            case 19: {
                this.zaf = false;
                return true;
            }
            case 18: {
                object = (zaby)((Message)object).obj;
                if (((zaby)object).zac == 0L) {
                    object = new TelemetryData(((zaby)object).zab, Arrays.asList(((zaby)object).zaa));
                    this.zaL().log((TelemetryData)object);
                    return true;
                }
                TelemetryData telemetryData = this.zah;
                if (telemetryData != null) {
                    List list = telemetryData.zab();
                    if (this.zah.zaa() == ((zaby)object).zab && (list == null || list.size() < ((zaby)object).zad)) {
                        this.zah.zac(((zaby)object).zaa);
                    } else {
                        this.zat.removeMessages(17);
                        this.zaK();
                    }
                }
                if (this.zah != null) return true;
                ArrayList<MethodInvocation> arrayList = new ArrayList<MethodInvocation>();
                arrayList.add(((zaby)object).zaa);
                this.zah = new TelemetryData(((zaby)object).zab, arrayList);
                Handler handler = this.zat;
                handler.sendMessageDelayed(handler.obtainMessage(17), ((zaby)object).zac);
                return true;
            }
            case 17: {
                this.zaK();
                return true;
            }
            case 16: {
                object = (zabm)((Message)object).obj;
                if (!this.zap.containsKey(zabm.zaa((zabm)object))) return true;
                zabl.zav(this.zap.get(zabm.zaa((zabm)object)), (zabm)object);
                return true;
            }
            case 15: {
                object = (zabm)((Message)object).obj;
                if (!this.zap.containsKey(zabm.zaa((zabm)object))) return true;
                zabl.zau(this.zap.get(zabm.zaa((zabm)object)), (zabm)object);
                return true;
            }
            case 14: {
                zaac zaac2 = (zaac)((Message)object).obj;
                object = zaac2.zaa();
                if (!this.zap.containsKey(object)) {
                    zaac2.zab().setResult((Object)false);
                    return true;
                }
                boolean bl = zabl.zat(this.zap.get(object), (boolean)false);
                zaac2.zab().setResult((Object)bl);
                return true;
            }
            case 12: {
                if (!this.zap.containsKey(((Message)object).obj)) return true;
                this.zap.get(((Message)object).obj).zal();
                return true;
            }
            case 11: {
                if (!this.zap.containsKey(((Message)object).obj)) return true;
                this.zap.get(((Message)object).obj).zak();
                return true;
            }
            case 10: {
                object = this.zas.iterator();
                while (true) {
                    if (!object.hasNext()) {
                        this.zas.clear();
                        return true;
                    }
                    ApiKey apiKey = (ApiKey)object.next();
                    zabl<?> zabl2 = this.zap.remove(apiKey);
                    if (zabl2 == null) continue;
                    zabl2.zae();
                }
            }
            case 9: {
                if (!this.zap.containsKey(((Message)object).obj)) return true;
                this.zap.get(((Message)object).obj).zaj();
                return true;
            }
            case 7: {
                this.zaH((GoogleApi)((Message)object).obj);
                return true;
            }
            case 6: {
                if (!(this.zak.getApplicationContext() instanceof Application)) return true;
                BackgroundDetector.initialize((Application)((Application)this.zak.getApplicationContext()));
                BackgroundDetector.getInstance().addListener((BackgroundDetector.BackgroundStateChangeListener)new zabg(this));
                if (BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) return true;
                this.zae = 300000L;
                return true;
            }
            case 5: {
                n = ((Message)object).arg1;
                ConnectionResult connectionResult = (ConnectionResult)((Message)object).obj;
                Object object2 = this.zap.values().iterator();
                do {
                    object = var6_4;
                } while (object2.hasNext() && (object = object2.next()).zaq() != n);
                if (object == null) {
                    object = new StringBuilder(76);
                    ((StringBuilder)object).append("Could not find API instance ");
                    ((StringBuilder)object).append(n);
                    ((StringBuilder)object).append(" while trying to fail enqueued calls.");
                    Log.wtf((String)"GoogleApiManager", (String)((StringBuilder)object).toString(), (Throwable)new Exception());
                    return true;
                }
                if (connectionResult.getErrorCode() == 13) {
                    String string = this.zal.getErrorString(connectionResult.getErrorCode());
                    String string2 = connectionResult.getErrorMessage();
                    object2 = new StringBuilder(String.valueOf(string).length() + 69 + String.valueOf(string2).length());
                    ((StringBuilder)object2).append("Error resolution was canceled by the user, original error message: ");
                    ((StringBuilder)object2).append(string);
                    ((StringBuilder)object2).append(": ");
                    ((StringBuilder)object2).append(string2);
                    zabl.zaw((zabl)object, (Status)new Status(17, ((StringBuilder)object2).toString()));
                    return true;
                }
                zabl.zaw((zabl)object, (Status)GoogleApiManager.zaJ(zabl.zax((zabl)object), connectionResult));
                return true;
            }
            case 4: 
            case 8: 
            case 13: {
                zacb zacb2 = (zacb)((Message)object).obj;
                zabl<?> zabl3 = this.zap.get(zacb2.zac.getApiKey());
                object = zabl3;
                if (zabl3 == null) {
                    object = this.zaH(zacb2.zac);
                }
                if (object.zap() && this.zao.get() != zacb2.zab) {
                    zacb2.zaa.zac(zaa);
                    object.zae();
                    return true;
                }
                object.zad(zacb2.zaa);
                return true;
            }
            case 3: {
                object = this.zap.values().iterator();
                while (object.hasNext()) {
                    zabl zabl4 = (zabl)object.next();
                    zabl4.zah();
                    zabl4.zam();
                }
                return true;
            }
            case 2: {
                zal zal2 = (zal)((Message)object).obj;
                Iterator iterator = zal2.zaa().iterator();
                while (iterator.hasNext()) {
                    ApiKey apiKey = (ApiKey)iterator.next();
                    object = this.zap.get(apiKey);
                    if (object == null) {
                        zal2.zac(apiKey, new ConnectionResult(13), null);
                        return true;
                    }
                    if (object.zao()) {
                        zal2.zac(apiKey, ConnectionResult.RESULT_SUCCESS, object.zaf().getEndpointPackageName());
                        continue;
                    }
                    ConnectionResult connectionResult = object.zai();
                    if (connectionResult != null) {
                        zal2.zac(apiKey, connectionResult, null);
                        continue;
                    }
                    object.zan(zal2);
                    object.zam();
                }
                return true;
            }
            case 1: 
        }
        if (((Boolean)((Message)object).obj).booleanValue()) {
            l = 10000L;
        }
        this.zae = l;
        this.zat.removeMessages(12);
        object = this.zap.keySet().iterator();
        while (object.hasNext()) {
            ApiKey apiKey = (ApiKey)object.next();
            Handler handler = this.zat;
            handler.sendMessageDelayed(handler.obtainMessage(12, (Object)apiKey), this.zae);
        }
        return true;
    }

    public final int zac() {
        return this.zan.getAndIncrement();
    }

    public final void zad(GoogleApi<?> googleApi) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void zae(zaab zaab2) {
        Object object = zag;
        synchronized (object) {
            if (this.zaq != zaab2) {
                this.zaq = zaab2;
                this.zar.clear();
            }
            this.zar.addAll((Collection<ApiKey<?>>)zaab2.zab());
            return;
        }
    }

    final void zaf(zaab zaab2) {
        Object object = zag;
        synchronized (object) {
            if (this.zaq != zaab2) return;
            this.zaq = null;
            this.zar.clear();
            return;
        }
    }

    final zabl zag(ApiKey<?> apiKey) {
        return this.zap.get(apiKey);
    }

    public final Task<Map<ApiKey<?>, String>> zah(Iterable<? extends HasApiKey<?>> handler) {
        zal zal2 = new zal(handler);
        handler = this.zat;
        handler.sendMessage(handler.obtainMessage(2, (Object)zal2));
        return zal2.zab();
    }

    public final void zai() {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final Task<Boolean> zaj(GoogleApi<?> handler) {
        zaac zaac2 = new zaac(handler.getApiKey());
        handler = this.zat;
        handler.sendMessage(handler.obtainMessage(14, (Object)zaac2));
        return zaac2.zab().getTask();
    }

    public final <O extends Api.ApiOptions> void zak(GoogleApi<O> googleApi, int n, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> zae2) {
        zae2 = new zae(n, zae2);
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, (Object)new zacb((zai)zae2, this.zao.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zal(GoogleApi<O> googleApi, int n, TaskApiCall<Api.AnyClient, ResultT> handler, TaskCompletionSource<ResultT> zag2, StatusExceptionMapper statusExceptionMapper) {
        this.zaI((TaskCompletionSource)zag2, handler.zab(), (GoogleApi)googleApi);
        zag2 = new zag(n, handler, zag2, statusExceptionMapper);
        handler = this.zat;
        handler.sendMessage(handler.obtainMessage(4, (Object)new zacb((zai)zag2, this.zao.get(), googleApi)));
    }

    final boolean zam() {
        int n;
        if (this.zaf) {
            return false;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration = RootTelemetryConfigManager.getInstance().getConfig();
        if (rootTelemetryConfiguration != null) {
            if (!rootTelemetryConfiguration.getMethodInvocationTelemetryEnabled()) return false;
        }
        if ((n = this.zam.zab(this.zak, 203390000)) == -1) return true;
        if (n != 0) return false;
        return true;
    }

    public final <O extends Api.ApiOptions> Task<Void> zan(GoogleApi<O> googleApi, RegisterListenerMethod<Api.AnyClient, ?> handler, UnregisterListenerMethod<Api.AnyClient, ?> zaf2, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaI(taskCompletionSource, handler.zab(), googleApi);
        zaf2 = new zaf(new zacc(handler, zaf2, runnable), taskCompletionSource);
        handler = this.zat;
        handler.sendMessage(handler.obtainMessage(8, (Object)new zacb((zai)zaf2, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final <O extends Api.ApiOptions> Task<Boolean> zao(GoogleApi<O> googleApi, ListenerHolder.ListenerKey listenerKey, int n) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaI(taskCompletionSource, n, googleApi);
        zah zah2 = new zah(listenerKey, taskCompletionSource);
        listenerKey = this.zat;
        listenerKey.sendMessage(listenerKey.obtainMessage(13, (Object)new zacb((zai)zah2, this.zao.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    final boolean zap(ConnectionResult connectionResult, int n) {
        return this.zal.zac(this.zak, connectionResult, n);
    }

    public final void zaq(ConnectionResult connectionResult, int n) {
        if (this.zap(connectionResult, n)) return;
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(5, n, 0, (Object)connectionResult));
    }

    final void zar(MethodInvocation methodInvocation, int n, long l, int n2) {
        Handler handler = this.zat;
        handler.sendMessage(handler.obtainMessage(18, (Object)new zaby(methodInvocation, n, l, n2)));
    }
}
