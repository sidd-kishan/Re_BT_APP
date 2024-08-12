/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzr
 *  com.google.android.gms.common.wrappers.Wrappers
 */
package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;

public class ConnectionTracker {
    private static final Object zzb = new Object();
    @Nullable
    private static volatile ConnectionTracker zzc;
    public ConcurrentHashMap<ServiceConnection, ServiceConnection> zza = new ConcurrentHashMap();

    private ConnectionTracker() {
    }

    public static ConnectionTracker getInstance() {
        Object object;
        if (zzc == null) {
            object = zzb;
            synchronized (object) {
                if (zzc == null) {
                    ConnectionTracker connectionTracker;
                    zzc = connectionTracker = new ConnectionTracker();
                }
            }
        }
        object = zzc;
        Preconditions.checkNotNull((Object)object);
        return object;
    }

    private final boolean zzb(Context context, String string, Intent intent, ServiceConnection serviceConnection, int n, boolean bl) {
        Object object;
        block7: {
            object = intent.getComponent();
            if (object != null) {
                object = object.getPackageName();
                "com.google.android.gms".equals(object);
                try {
                    int n2 = Wrappers.packageManager((Context)context).getApplicationInfo((String)object, (int)0).flags;
                    if ((n2 & 0x200000) == 0) break block7;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    // empty catch block
                    break block7;
                }
                Log.w((String)"ConnectionTracker", (String)"Attempted to bind to a service in a STOPPED package.");
                return false;
            }
        }
        if (ConnectionTracker.zzc(serviceConnection)) {
            object = this.zza.putIfAbsent(serviceConnection, serviceConnection);
            if (object != null && serviceConnection != object) {
                Log.w((String)"ConnectionTracker", (String)String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, string, intent.getAction()));
            }
            try {
                bl = context.bindService(intent, serviceConnection, n);
                if (bl) return bl;
                this.zza.remove(serviceConnection, serviceConnection);
            }
            catch (Throwable throwable) {
                this.zza.remove(serviceConnection, serviceConnection);
                throw throwable;
            }
            return false;
        }
        bl = context.bindService(intent, serviceConnection, n);
        return bl;
    }

    private static boolean zzc(ServiceConnection serviceConnection) {
        if (serviceConnection instanceof zzr) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private static void zzd(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
            return;
        }
        catch (IllegalArgumentException | IllegalStateException | NoSuchElementException runtimeException) {
            return;
        }
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int n) {
        return this.zzb(context, context.getClass().getName(), intent, serviceConnection, n, true);
    }

    public void unbindService(Context context, ServiceConnection serviceConnection) {
        if (ConnectionTracker.zzc(serviceConnection) && this.zza.containsKey(serviceConnection)) {
            try {
                ConnectionTracker.zzd(context, this.zza.get(serviceConnection));
                return;
            }
            finally {
                this.zza.remove(serviceConnection);
            }
        }
        ConnectionTracker.zzd(context, serviceConnection);
    }

    /*
     * Enabled force condition propagation
     */
    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            this.unbindService(context, serviceConnection);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return;
        }
    }

    public final boolean zza(Context context, String string, Intent intent, ServiceConnection serviceConnection, int n) {
        return this.zzb(context, string, intent, serviceConnection, n, true);
    }
}
