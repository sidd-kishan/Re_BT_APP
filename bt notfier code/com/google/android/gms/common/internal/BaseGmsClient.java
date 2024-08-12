/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.util.Log
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.CommonStatusCodes
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$LegacyClientCallbackAdapter
 *  com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks
 *  com.google.android.gms.common.internal.ConnectionTelemetryConfiguration
 *  com.google.android.gms.common.internal.GetServiceRequest
 *  com.google.android.gms.common.internal.GmsClientSupervisor
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.common.internal.IGmsCallbacks
 *  com.google.android.gms.common.internal.IGmsServiceBroker
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.RootTelemetryConfigManager
 *  com.google.android.gms.common.internal.RootTelemetryConfiguration
 *  com.google.android.gms.common.internal.zzb
 *  com.google.android.gms.common.internal.zzc
 *  com.google.android.gms.common.internal.zzd
 *  com.google.android.gms.common.internal.zze
 *  com.google.android.gms.common.internal.zzf
 *  com.google.android.gms.common.internal.zzg
 *  com.google.android.gms.common.internal.zzi
 *  com.google.android.gms.common.internal.zzm
 *  com.google.android.gms.common.internal.zzt
 */
package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseGmsClient<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES;
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zze;
    private volatile String zzA;
    private ConnectionResult zzB;
    private boolean zzC;
    private volatile zzi zzD;
    zzt zza;
    final Handler zzb;
    protected ConnectionProgressReportCallbacks zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private T zzs;
    private final ArrayList<zzc<?>> zzt;
    private zze zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;

    static {
        zze = new Feature[0];
        GOOGLE_PLUS_REQUIRED_FEATURES = new String[]{"service_esmobile", "service_googleme"};
    }

    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int n, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull((Object)context, (Object)"Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull((Object)handler, (Object)"Handler must not be null");
        this.zzb = handler;
        this.zzm = handler.getLooper();
        Preconditions.checkNotNull((Object)gmsClientSupervisor, (Object)"Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull((Object)googleApiAvailabilityLight, (Object)"API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzy = n;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    protected BaseGmsClient(Context context, Looper looper, int n, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String string) {
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.getInstance((Context)context);
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        Preconditions.checkNotNull((Object)baseConnectionCallbacks);
        Preconditions.checkNotNull((Object)baseOnConnectionFailedListener);
        this(context, looper, gmsClientSupervisor, googleApiAvailabilityLight, n, baseConnectionCallbacks, baseOnConnectionFailedListener, string);
    }

    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int n, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String string) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzB = null;
        this.zzC = false;
        this.zzD = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull((Object)context, (Object)"Context must not be null");
        this.zzl = context;
        Preconditions.checkNotNull((Object)looper, (Object)"Looper must not be null");
        this.zzm = looper;
        Preconditions.checkNotNull((Object)gmsClientSupervisor, (Object)"Supervisor must not be null");
        this.zzn = gmsClientSupervisor;
        Preconditions.checkNotNull((Object)googleApiAvailabilityLight, (Object)"API availability must not be null");
        this.zzo = googleApiAvailabilityLight;
        this.zzb = new zzb(this, looper);
        this.zzy = n;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = string;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    static /* synthetic */ void zzc(BaseGmsClient baseGmsClient, int n) {
        Object object = baseGmsClient.zzp;
        // MONITORENTER : object
        n = baseGmsClient.zzv;
        // MONITOREXIT : object
        if (n == 3) {
            baseGmsClient.zzC = true;
            n = 5;
        } else {
            n = 4;
        }
        object = baseGmsClient.zzb;
        object.sendMessage(object.obtainMessage(n, baseGmsClient.zzd.get(), 16));
    }

    static /* synthetic */ Object zzd(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzq;
    }

    static /* synthetic */ IGmsServiceBroker zze(BaseGmsClient baseGmsClient, IGmsServiceBroker iGmsServiceBroker) {
        baseGmsClient.zzr = iGmsServiceBroker;
        return iGmsServiceBroker;
    }

    static /* synthetic */ ConnectionResult zzf(BaseGmsClient baseGmsClient, ConnectionResult connectionResult) {
        baseGmsClient.zzB = connectionResult;
        return connectionResult;
    }

    static /* synthetic */ boolean zzg(BaseGmsClient baseGmsClient) {
        boolean bl = baseGmsClient.zzC;
        boolean bl2 = false;
        if (bl || TextUtils.isEmpty((CharSequence)baseGmsClient.getServiceDescriptor()) || TextUtils.isEmpty((CharSequence)baseGmsClient.getLocalStartServiceAction())) return bl2;
        try {
            Class.forName(baseGmsClient.getServiceDescriptor());
            bl2 = true;
        }
        catch (ClassNotFoundException classNotFoundException) {}
        return bl2;
    }

    static /* synthetic */ boolean zzh(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzC;
    }

    static /* synthetic */ void zzi(BaseGmsClient baseGmsClient, int n, IInterface iInterface) {
        baseGmsClient.zzp(n, null);
    }

    static /* synthetic */ ConnectionResult zzj(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzB;
    }

    static /* synthetic */ BaseConnectionCallbacks zzk(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzw;
    }

    static /* synthetic */ boolean zzl(BaseGmsClient baseGmsClient, int n, int n2, IInterface iInterface) {
        Object object = baseGmsClient.zzp;
        synchronized (object) {
            boolean bl;
            if (baseGmsClient.zzv != n) {
                // MONITOREXIT @DISABLED, blocks:[0, 1, 4] lbl5 : MonitorExitStatement: MONITOREXIT : var5_5
                bl = false;
            } else {
                baseGmsClient.zzp(n2, iInterface);
                // MONITOREXIT @DISABLED, blocks:[0, 1, 3] lbl9 : MonitorExitStatement: MONITOREXIT : var5_5
                bl = true;
            }
            return bl;
        }
    }

    static /* synthetic */ ArrayList zzm(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzt;
    }

    static /* synthetic */ BaseOnConnectionFailedListener zzn(BaseGmsClient baseGmsClient) {
        return baseGmsClient.zzx;
    }

    static /* synthetic */ void zzo(BaseGmsClient baseGmsClient, zzi zzi2) {
        baseGmsClient.zzD = zzi2;
        if (!baseGmsClient.usesClientTelemetry()) return;
        baseGmsClient = zzi2.zzd;
        zzi2 = RootTelemetryConfigManager.getInstance();
        baseGmsClient = baseGmsClient == null ? null : baseGmsClient.getRootTelemetryConfiguration();
        zzi2.zza((RootTelemetryConfiguration)baseGmsClient);
    }

    private final void zzp(int n, T object) {
        int n2;
        boolean bl = false;
        int n3 = n != 4 ? 0 : 1;
        if (n3 == (n2 = object != null)) {
            bl = true;
        }
        Preconditions.checkArgument((boolean)bl);
        Object object2 = this.zzp;
        synchronized (object2) {
            this.zzv = n;
            this.zzs = object;
            if (n != 1) {
                if (n != 2 && n != 3) {
                    if (n == 4) {
                        Preconditions.checkNotNull(object);
                        this.onConnectedLocked(object);
                    }
                } else {
                    CharSequence charSequence;
                    String string;
                    Object object3;
                    object = this.zzu;
                    if (object != null && (object3 = this.zza) != null) {
                        object3 = object3.zza();
                        string = this.zza.zzb();
                        n3 = String.valueOf(object3).length();
                        n = String.valueOf(string).length();
                        charSequence = new StringBuilder(n3 + 70 + n);
                        charSequence.append("Calling connect() while still connected, missing disconnect() for ");
                        charSequence.append((String)object3);
                        charSequence.append(" on ");
                        charSequence.append(string);
                        Log.e((String)"GmsClient", (String)charSequence.toString());
                        object3 = this.zzn;
                        charSequence = this.zza.zza();
                        Preconditions.checkNotNull((Object)charSequence);
                        object3.zza((String)charSequence, this.zza.zzb(), this.zza.zzc(), (ServiceConnection)object, this.zza(), this.zza.zzd());
                        this.zzd.incrementAndGet();
                    }
                    this.zzu = object3 = new zze(this, this.zzd.get());
                    object = this.zzv == 3 && this.getLocalStartServiceAction() != null ? new zzt(this.getContext().getPackageName(), this.getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false) : new zzt(this.getStartServicePackage(), this.getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), this.getUseDynamicLookup());
                    this.zza = object;
                    if (object.zzd() && this.getMinApkVersion() < 17895000) {
                        object = String.valueOf(this.zza.zza());
                        object = ((String)object).length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat((String)object) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ");
                        object3 = new IllegalStateException((String)object);
                        throw object3;
                    }
                    charSequence = this.zzn;
                    string = this.zza.zza();
                    Preconditions.checkNotNull((Object)string);
                    String string2 = this.zza.zzb();
                    n = this.zza.zzc();
                    object = this.zza();
                    bl = this.zza.zzd();
                    zzm zzm2 = new zzm(string, string2, n, bl);
                    if (charSequence.zzb(zzm2, (ServiceConnection)object3, (String)object)) return;
                    object3 = this.zza.zza();
                    charSequence = this.zza.zzb();
                    n = String.valueOf(object3).length();
                    n3 = String.valueOf(charSequence).length();
                    object = new StringBuilder(n + 34 + n3);
                    ((StringBuilder)object).append("unable to connect to service: ");
                    ((StringBuilder)object).append((String)object3);
                    ((StringBuilder)object).append(" on ");
                    ((StringBuilder)object).append((String)charSequence);
                    Log.e((String)"GmsClient", (String)((StringBuilder)object).toString());
                    this.zzb(16, null, this.zzd.get());
                }
            } else {
                object = this.zzu;
                if (object == null) return;
                GmsClientSupervisor gmsClientSupervisor = this.zzn;
                String string = this.zza.zza();
                Preconditions.checkNotNull((Object)string);
                gmsClientSupervisor.zza(string, this.zza.zzb(), this.zza.zzc(), object, this.zza(), this.zza.zzd());
                this.zzu = null;
            }
            return;
        }
    }

    public void checkAvailabilityAndConnect() {
        int n = this.zzo.isGooglePlayServicesAvailable(this.zzl, this.getMinApkVersion());
        if (n != 0) {
            this.zzp(1, null);
            this.triggerNotAvailable((ConnectionProgressReportCallbacks)new LegacyClientCallbackAdapter(this), n, null);
            return;
        }
        this.connect((ConnectionProgressReportCallbacks)new LegacyClientCallbackAdapter(this));
    }

    protected final void checkConnected() {
        if (!this.isConnected()) throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.checkNotNull((Object)connectionProgressReportCallbacks, (Object)"Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        this.zzp(2, null);
    }

    protected abstract T createServiceInterface(IBinder var1);

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void disconnect() {
        this.zzd.incrementAndGet();
        Object object = this.zzt;
        // MONITORENTER : object
        int n = this.zzt.size();
        for (int i = 0; i < n; ++i) {
            this.zzt.get(i).zzg();
        }
        this.zzt.clear();
        // MONITOREXIT : object
        object = this.zzq;
        this.zzr = null;
        this.zzp(1, null);
        return;
        finally {
            // MONITORENTER : object
        }
    }

    public void disconnect(String string) {
        this.zzk = string;
        this.disconnect();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void dump(String object, FileDescriptor object2, PrintWriter appendable, String[] object3) {
        long l;
        block24: {
            Object object4;
            Object object5;
            block20: {
                block25: {
                    int n;
                    block19: {
                        block21: {
                            block22: {
                                block23: {
                                    object2 = this.zzp;
                                    synchronized (object2) {
                                        n = this.zzv;
                                        object3 = this.zzs;
                                    }
                                    object2 = this.zzq;
                                    synchronized (object2) {
                                        object5 = this.zzr;
                                    }
                                    ((PrintWriter)appendable).append((CharSequence)object).append("mConnectState=");
                                    if (n == 1) break block21;
                                    if (n == 2) break block22;
                                    if (n == 3) break block23;
                                    if (n != 4) {
                                        if (n != 5) {
                                            ((PrintWriter)appendable).print("UNKNOWN");
                                            break block19;
                                        } else {
                                            ((PrintWriter)appendable).print("DISCONNECTING");
                                        }
                                        break block19;
                                    } else {
                                        ((PrintWriter)appendable).print("CONNECTED");
                                    }
                                    break block19;
                                }
                                ((PrintWriter)appendable).print("LOCAL_CONNECTING");
                                break block19;
                            }
                            ((PrintWriter)appendable).print("REMOTE_CONNECTING");
                            break block19;
                        }
                        ((PrintWriter)appendable).print("DISCONNECTED");
                    }
                    ((PrintWriter)appendable).append(" mService=");
                    if (object3 == null) {
                        ((PrintWriter)appendable).append("null");
                    } else {
                        ((PrintWriter)appendable).append(this.getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(object3.asBinder())));
                    }
                    ((PrintWriter)appendable).append(" mServiceBroker=");
                    if (object5 == null) {
                        ((PrintWriter)appendable).println("null");
                    } else {
                        ((PrintWriter)appendable).append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(object5.asBinder())));
                    }
                    object2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
                    if (this.zzh > 0L) {
                        object5 = ((PrintWriter)appendable).append((CharSequence)object).append("lastConnectedTime=");
                        l = this.zzh;
                        object4 = ((DateFormat)object2).format(new Date(l));
                        object3 = new StringBuilder(String.valueOf(object4).length() + 21);
                        ((StringBuilder)object3).append(l);
                        ((StringBuilder)object3).append(" ");
                        ((StringBuilder)object3).append((String)object4);
                        ((PrintWriter)object5).println(((StringBuilder)object3).toString());
                    }
                    if (this.zzg <= 0L) break block24;
                    ((PrintWriter)appendable).append((CharSequence)object).append("lastSuspendedCause=");
                    n = this.zzf;
                    if (n == 1) break block25;
                    if (n != 2) {
                        if (n != 3) {
                            ((PrintWriter)appendable).append(String.valueOf(n));
                            break block20;
                        } else {
                            ((PrintWriter)appendable).append("CAUSE_DEAD_OBJECT_EXCEPTION");
                        }
                        break block20;
                    } else {
                        ((PrintWriter)appendable).append("CAUSE_NETWORK_LOST");
                    }
                    break block20;
                }
                ((PrintWriter)appendable).append("CAUSE_SERVICE_DISCONNECTED");
            }
            object4 = ((PrintWriter)appendable).append(" lastSuspendedTime=");
            l = this.zzg;
            object5 = ((DateFormat)object2).format(new Date(l));
            object3 = new StringBuilder(String.valueOf(object5).length() + 21);
            ((StringBuilder)object3).append(l);
            ((StringBuilder)object3).append(" ");
            ((StringBuilder)object3).append((String)object5);
            ((PrintWriter)object4).println(((StringBuilder)object3).toString());
        }
        if (this.zzj <= 0L) return;
        ((PrintWriter)appendable).append((CharSequence)object).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString((int)this.zzi));
        object = ((PrintWriter)appendable).append(" lastFailedTime=");
        l = this.zzj;
        object2 = ((DateFormat)object2).format(new Date(l));
        appendable = new StringBuilder(String.valueOf(object2).length() + 21);
        ((StringBuilder)appendable).append(l);
        ((StringBuilder)appendable).append(" ");
        ((StringBuilder)appendable).append((String)object2);
        ((PrintWriter)object).println(((StringBuilder)appendable).toString());
    }

    protected boolean enableLocalFallback() {
        return false;
    }

    public Account getAccount() {
        return null;
    }

    public Feature[] getApiFeatures() {
        return zze;
    }

    public final Feature[] getAvailableFeatures() {
        zzi zzi2 = this.zzD;
        if (zzi2 != null) return zzi2.zzb;
        return null;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        if (!this.isConnected()) throw new RuntimeException("Failed to connect when checking package");
        zzt zzt2 = this.zza;
        if (zzt2 == null) throw new RuntimeException("Failed to connect when checking package");
        return zzt2.zzb();
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    protected Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    protected String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public void getRemoteService(IAccountAccessor object, Set<Scope> bundle) {
        void var1_4;
        block16: {
            Bundle bundle2 = this.getGetServiceRequestExtraArgs();
            GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzy, this.zzA);
            getServiceRequest.zzd = this.zzl.getPackageName();
            getServiceRequest.zzg = bundle2;
            if (bundle != null) {
                getServiceRequest.zzf = bundle.toArray(new Scope[bundle.size()]);
            }
            if (this.requiresSignIn()) {
                bundle = bundle2 = this.getAccount();
                if (bundle2 == null) {
                    bundle = new Account(DEFAULT_ACCOUNT, "com.google");
                }
                getServiceRequest.zzh = bundle;
                if (object != null) {
                    getServiceRequest.zze = object.asBinder();
                }
            } else if (this.requiresAccount()) {
                getServiceRequest.zzh = this.getAccount();
            }
            getServiceRequest.zzi = zze;
            getServiceRequest.zzj = this.getApiFeatures();
            if (this.usesClientTelemetry()) {
                getServiceRequest.zzm = true;
            }
            try {
                object = this.zzq;
                synchronized (object) {
                    bundle = this.zzr;
                    if (bundle == null) break block15;
                }
            }
            catch (RuntimeException runtimeException) {
                break block16;
            }
            catch (RemoteException remoteException) {
                // empty catch block
                break block16;
            }
            catch (SecurityException securityException) {
                throw securityException;
            }
            catch (DeadObjectException deadObjectException) {
                Log.w((String)"GmsClient", (String)"IGmsServiceBroker.getService failed", (Throwable)deadObjectException);
                this.triggerConnectionSuspended(3);
                return;
            }
            {
                block17: {
                    block15: {
                        bundle2 = new zzd(this, this.zzd.get());
                        bundle.getService((IGmsCallbacks)bundle2, getServiceRequest);
                        break block17;
                    }
                    Log.w((String)"GmsClient", (String)"mServiceBroker is null, client disconnected");
                }
                return;
            }
        }
        Log.w((String)"GmsClient", (String)"IGmsServiceBroker.getService failed", (Throwable)var1_4);
        this.onPostInitHandler(8, null, null, this.zzd.get());
    }

    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final T getService() throws DeadObjectException {
        Object object = this.zzp;
        synchronized (object) {
            if (this.zzv != 5) {
                this.checkConnected();
                T t = this.zzs;
                Preconditions.checkNotNull(t, (Object)"Client is connected but service is null");
                return t;
            }
            DeadObjectException deadObjectException = new DeadObjectException();
            throw deadObjectException;
        }
    }

    public IBinder getServiceBrokerBinder() {
        Object object = this.zzq;
        synchronized (object) {
            IGmsServiceBroker iGmsServiceBroker = this.zzr;
            if (iGmsServiceBroker == null) {
                return null;
            }
            iGmsServiceBroker = iGmsServiceBroker.asBinder();
            return iGmsServiceBroker;
        }
    }

    protected abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    protected abstract String getStartServiceAction();

    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        zzi zzi2 = this.zzD;
        if (zzi2 != null) return zzi2.zzd;
        return null;
    }

    protected boolean getUseDynamicLookup() {
        return false;
    }

    public boolean hasConnectionInfo() {
        if (this.zzD == null) return false;
        return true;
    }

    public boolean isConnected() {
        Object object = this.zzp;
        synchronized (object) {
            boolean bl = this.zzv == 4;
            return bl;
        }
    }

    public boolean isConnecting() {
        Object object = this.zzp;
        synchronized (object) {
            boolean bl;
            int n = this.zzv;
            boolean bl2 = bl = true;
            if (n == 2) return bl2;
            bl2 = n == 3 ? bl : false;
            return bl2;
        }
    }

    protected void onConnectedLocked(T t) {
        this.zzh = System.currentTimeMillis();
    }

    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzi = connectionResult.getErrorCode();
        this.zzj = System.currentTimeMillis();
    }

    protected void onConnectionSuspended(int n) {
        this.zzf = n;
        this.zzg = System.currentTimeMillis();
    }

    protected void onPostInitHandler(int n, IBinder iBinder, Bundle bundle, int n2) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(1, n2, -1, (Object)new zzf(this, n, iBinder, bundle)));
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    public void setAttributionTag(String string) {
        this.zzA = string;
    }

    public void triggerConnectionSuspended(int n) {
        Handler handler = this.zzb;
        handler.sendMessage(handler.obtainMessage(6, this.zzd.get(), n));
    }

    protected void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int n, PendingIntent pendingIntent) {
        Preconditions.checkNotNull((Object)connectionProgressReportCallbacks, (Object)"Connection progress callbacks cannot be null.");
        this.zzc = connectionProgressReportCallbacks;
        connectionProgressReportCallbacks = this.zzb;
        connectionProgressReportCallbacks.sendMessage(connectionProgressReportCallbacks.obtainMessage(3, this.zzd.get(), n, (Object)pendingIntent));
    }

    public boolean usesClientTelemetry() {
        return false;
    }

    protected final String zza() {
        String string;
        String string2 = string = this.zzz;
        if (string != null) return string2;
        string2 = this.zzl.getClass().getName();
        return string2;
    }

    protected final void zzb(int n, Bundle bundle, int n2) {
        bundle = this.zzb;
        bundle.sendMessage(bundle.obtainMessage(7, n2, -1, (Object)new zzg(this, n, null)));
    }
}
