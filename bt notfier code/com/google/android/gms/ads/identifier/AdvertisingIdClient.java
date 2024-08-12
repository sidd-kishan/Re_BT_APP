/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.os.SystemClock
 *  android.util.Log
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$zza
 *  com.google.android.gms.ads.identifier.zza
 *  com.google.android.gms.ads.identifier.zzb
 *  com.google.android.gms.common.BlockingServiceConnection
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.GooglePlayServicesNotAvailableException
 *  com.google.android.gms.common.GooglePlayServicesRepairableException
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.stats.ConnectionTracker
 *  com.google.android.gms.internal.ads_identifier.zze
 *  com.google.android.gms.internal.ads_identifier.zzf
 */
package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.zzb;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    private final Context mContext;
    private BlockingServiceConnection zze;
    private zze zzf;
    private boolean zzg;
    private final Object zzh = new Object();
    private zza zzi;
    private final boolean zzj;
    private final long zzk;

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    private AdvertisingIdClient(Context context, long l, boolean bl, boolean bl2) {
        Preconditions.checkNotNull((Object)context);
        Context context2 = context;
        if (bl && (context2 = context.getApplicationContext()) == null) {
            context2 = context;
        }
        this.mContext = context2;
        this.zzg = false;
        this.zzk = l;
        this.zzj = bl2;
    }

    public static Info getAdvertisingIdInfo(Context object) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzb2 = new zzb((Context)object);
        boolean bl = zzb2.getBoolean("gads:ad_id_app_context:enabled", false);
        float f = zzb2.getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string = zzb2.getString("gads:ad_id_use_shared_preference:experiment_id", "");
        object = new AdvertisingIdClient((Context)object, -1L, bl, zzb2.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long l = SystemClock.elapsedRealtime();
            super.zza(false);
            zzb2 = ((AdvertisingIdClient)object).getInfo();
            super.zza((Info)zzb2, bl, f, SystemClock.elapsedRealtime() - l, string, null);
            ((AdvertisingIdClient)object).finish();
            return zzb2;
        }
        catch (Throwable throwable) {
            try {
                super.zza(null, bl, f, -1L, string, throwable);
                throw throwable;
            }
            catch (Throwable throwable2) {
                ((AdvertisingIdClient)object).finish();
                throw throwable2;
            }
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context object) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzb2 = new zzb((Context)object);
        object = new AdvertisingIdClient((Context)object, -1L, zzb2.getBoolean("gads:ad_id_app_context:enabled", false), zzb2.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            super.zza(false);
            boolean bl = super.zzb();
            return bl;
        }
        finally {
            ((AdvertisingIdClient)object).finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean bl) {
    }

    private static BlockingServiceConnection zza(Context context, boolean bl) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
        int n = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000);
        if (n != 0) {
            if (n != 2) throw new IOException("Google Play services not available");
        }
        String string = bl ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
        BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
        string = new Intent(string);
        string.setPackage("com.google.android.gms");
        try {
            bl = ConnectionTracker.getInstance().bindService(context, (Intent)string, (ServiceConnection)blockingServiceConnection, 1);
            if (!bl) throw new IOException("Connection failure");
            return blockingServiceConnection;
        }
        catch (Throwable throwable) {
            throw new IOException(throwable);
        }
    }

    private static zze zza(Context context, BlockingServiceConnection blockingServiceConnection) throws IOException {
        try {
            context = com.google.android.gms.internal.ads_identifier.zzf.zza((IBinder)blockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
            return context;
        }
        catch (Throwable throwable) {
            throw new IOException(throwable);
        }
        catch (InterruptedException interruptedException) {
            throw new IOException("Interrupted exception");
        }
    }

    private final void zza() {
        Object object = this.zzh;
        synchronized (object) {
            zza zza2;
            if (this.zzi != null) {
                this.zzi.zzo.countDown();
                try {
                    this.zzi.join();
                }
                catch (InterruptedException interruptedException) {}
            }
            if (this.zzk <= 0L) return;
            this.zzi = zza2 = new zza(this, this.zzk);
            return;
        }
    }

    private final void zza(boolean bl) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Preconditions.checkNotMainThread((String)"Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            BlockingServiceConnection blockingServiceConnection;
            if (this.zzg) {
                this.finish();
            }
            this.zze = blockingServiceConnection = AdvertisingIdClient.zza(this.mContext, this.zzj);
            this.zzf = AdvertisingIdClient.zza(this.mContext, blockingServiceConnection);
            this.zzg = true;
            if (!bl) return;
            this.zza();
            return;
        }
    }

    private final boolean zza(Info info, boolean bl, float f, long l, String string, Throwable throwable) {
        if (Math.random() > (double)f) {
            return false;
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string2 = "1";
        String string3 = bl ? "1" : "0";
        hashMap.put("app_context", string3);
        if (info != null) {
            string3 = info.isLimitAdTrackingEnabled() ? string2 : "0";
            hashMap.put("limit_ad_tracking", string3);
        }
        if (info != null && info.getId() != null) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (throwable != null) {
            hashMap.put("error", throwable.getClass().getName());
        }
        if (string != null && !string.isEmpty()) {
            hashMap.put("experiment_id", string);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(l));
        new com.google.android.gms.ads.identifier.zza(this, hashMap).start();
        return true;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final boolean zzb() throws IOException {
        Preconditions.checkNotMainThread((String)"Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            block14: {
                if (!this.zzg) {
                    Object object = this.zzh;
                    synchronized (object) {
                        if (this.zzi != null && this.zzi.zzp) {
                            // MONITOREXIT @DISABLED, blocks:[8, 9, 12, 13] lbl7 : MonitorExitStatement: MONITOREXIT : var2_1
                            try {
                                this.zza(false);
                                if (this.zzg) break block14;
                                object = new IOException("AdvertisingIdClient cannot reconnect.");
                                throw object;
                            }
                            catch (Exception exception) {
                                object = new IOException("AdvertisingIdClient cannot reconnect.", exception);
                                throw object;
                            }
                        }
                        IOException iOException = new IOException("AdvertisingIdClient is not connected.");
                        throw iOException;
                    }
                }
            }
            Preconditions.checkNotNull((Object)this.zze);
            Preconditions.checkNotNull((Object)this.zzf);
            try {
                boolean bl = this.zzf.zzc();
                // MONITOREXIT @DISABLED, blocks:[6, 8] lbl24 : MonitorExitStatement: MONITOREXIT : this
                this.zza();
                return bl;
            }
            catch (RemoteException remoteException) {
                Log.i((String)"AdvertisingIdClient", (String)"GMS remote exception ", (Throwable)remoteException);
                IOException iOException = new IOException("Remote exception");
                throw iOException;
            }
        }
    }

    protected void finalize() throws Throwable {
        this.finish();
        super.finalize();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void finish() {
        Preconditions.checkNotMainThread((String)"Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null) return;
            BlockingServiceConnection blockingServiceConnection = this.zze;
            if (blockingServiceConnection == null) {
                return;
            }
            try {
                if (this.zzg) {
                    ConnectionTracker.getInstance().unbindService(this.mContext, (ServiceConnection)this.zze);
                }
            }
            catch (Throwable throwable) {
                Log.i((String)"AdvertisingIdClient", (String)"AdvertisingIdClient unbindService failed.", (Throwable)throwable);
            }
            this.zzg = false;
            this.zzf = null;
            this.zze = null;
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public Info getInfo() throws IOException {
        Preconditions.checkNotMainThread((String)"Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            Object object;
            block14: {
                if (!this.zzg) {
                    object = this.zzh;
                    synchronized (object) {
                        if (this.zzi != null && this.zzi.zzp) {
                            // MONITOREXIT @DISABLED, blocks:[8, 9, 12, 13] lbl7 : MonitorExitStatement: MONITOREXIT : var1_1
                            try {
                                this.zza(false);
                                if (this.zzg) break block14;
                                object = new IOException("AdvertisingIdClient cannot reconnect.");
                                throw object;
                            }
                            catch (Exception exception) {
                                IOException iOException = new IOException("AdvertisingIdClient cannot reconnect.", exception);
                                throw iOException;
                            }
                        }
                        IOException iOException = new IOException("AdvertisingIdClient is not connected.");
                        throw iOException;
                    }
                }
            }
            Preconditions.checkNotNull((Object)this.zze);
            Preconditions.checkNotNull((Object)this.zzf);
            try {
                object = new Info(this.zzf.getId(), this.zzf.zzb(true));
                // MONITOREXIT @DISABLED, blocks:[6, 8] lbl24 : MonitorExitStatement: MONITOREXIT : this
                this.zza();
                return object;
            }
            catch (RemoteException remoteException) {
                Log.i((String)"AdvertisingIdClient", (String)"GMS remote exception ", (Throwable)remoteException);
                IOException iOException = new IOException("Remote exception");
                throw iOException;
            }
        }
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        this.zza(true);
    }
}
