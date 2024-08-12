/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingServiceConnection
implements ServiceConnection {
    boolean zza = false;
    private final BlockingQueue<IBinder> zzb = new LinkedBlockingQueue<IBinder>();

    public IBinder getService() throws InterruptedException {
        Preconditions.checkNotMainThread((String)"BlockingServiceConnection.getService() called on main thread");
        if (this.zza) throw new IllegalStateException("Cannot call get on this connection more than once");
        this.zza = true;
        return this.zzb.take();
    }

    public IBinder getServiceWithTimeout(long l, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread((String)"BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.zza) throw new IllegalStateException("Cannot call get on this connection more than once");
        this.zza = true;
        if ((timeUnit = this.zzb.poll(l, timeUnit)) == null) throw new TimeoutException("Timed out waiting for the service connection");
        return timeUnit;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.zzb.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
