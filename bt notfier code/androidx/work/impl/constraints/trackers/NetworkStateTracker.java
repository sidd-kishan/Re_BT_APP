/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkInfo
 *  android.os.Build$VERSION
 *  androidx.core.net.ConnectivityManagerCompat
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.NetworkState
 *  androidx.work.impl.constraints.trackers.ConstraintTracker
 *  androidx.work.impl.constraints.trackers.NetworkStateTracker$NetworkStateBroadcastReceiver
 *  androidx.work.impl.constraints.trackers.NetworkStateTracker$NetworkStateCallback
 *  androidx.work.impl.utils.taskexecutor.TaskExecutor
 */
package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkStateTracker
extends ConstraintTracker<NetworkState> {
    static final String TAG = Logger.tagWithPrefix((String)"NetworkStateTracker");
    private NetworkStateBroadcastReceiver mBroadcastReceiver;
    private final ConnectivityManager mConnectivityManager;
    private NetworkStateCallback mNetworkCallback;

    public NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        this.mConnectivityManager = (ConnectivityManager)this.mAppContext.getSystemService("connectivity");
        if (NetworkStateTracker.isNetworkCallbackSupported()) {
            this.mNetworkCallback = new NetworkStateCallback(this);
        } else {
            this.mBroadcastReceiver = new NetworkStateBroadcastReceiver(this);
        }
    }

    private static boolean isNetworkCallbackSupported() {
        boolean bl = Build.VERSION.SDK_INT >= 24;
        return bl;
    }

    NetworkState getActiveNetworkState() {
        NetworkInfo networkInfo = this.mConnectivityManager.getActiveNetworkInfo();
        boolean bl = true;
        boolean bl2 = networkInfo != null && networkInfo.isConnected();
        boolean bl3 = this.isActiveNetworkValidated();
        boolean bl4 = ConnectivityManagerCompat.isActiveNetworkMetered((ConnectivityManager)this.mConnectivityManager);
        if (networkInfo != null && !networkInfo.isRoaming()) return new NetworkState(bl2, bl3, bl4, bl);
        bl = false;
        return new NetworkState(bl2, bl3, bl4, bl);
    }

    public NetworkState getInitialState() {
        return this.getActiveNetworkState();
    }

    boolean isActiveNetworkValidated() {
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        if (n < 23) {
            return false;
        }
        try {
            Network network = this.mConnectivityManager.getActiveNetwork();
            network = this.mConnectivityManager.getNetworkCapabilities(network);
            boolean bl2 = bl;
            if (network == null) return bl2;
            boolean bl3 = network.hasCapability(16);
            bl2 = bl;
            if (!bl3) return bl2;
            bl2 = true;
            return bl2;
        }
        catch (SecurityException securityException) {
            Logger.get().error(TAG, "Unable to validate active network", new Throwable[]{securityException});
            return false;
        }
    }

    /*
     * WARNING - void declaration
     */
    public void startTracking() {
        block5: {
            if (NetworkStateTracker.isNetworkCallbackSupported()) {
                void var1_3;
                try {
                    Logger.get().debug(TAG, "Registering network callback", new Throwable[0]);
                    this.mConnectivityManager.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)this.mNetworkCallback);
                    break block5;
                }
                catch (SecurityException securityException) {
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    // empty catch block
                }
                Logger.get().error(TAG, "Received exception while registering network callback", new Throwable[]{var1_3});
            } else {
                Logger.get().debug(TAG, "Registering broadcast receiver", new Throwable[0]);
                this.mAppContext.registerReceiver((BroadcastReceiver)this.mBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void stopTracking() {
        block5: {
            if (NetworkStateTracker.isNetworkCallbackSupported()) {
                void var1_3;
                try {
                    Logger.get().debug(TAG, "Unregistering network callback", new Throwable[0]);
                    this.mConnectivityManager.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)this.mNetworkCallback);
                    break block5;
                }
                catch (SecurityException securityException) {
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    // empty catch block
                }
                Logger.get().error(TAG, "Received exception while unregistering network callback", new Throwable[]{var1_3});
            } else {
                Logger.get().debug(TAG, "Unregistering broadcast receiver", new Throwable[0]);
                this.mAppContext.unregisterReceiver((BroadcastReceiver)this.mBroadcastReceiver);
            }
        }
    }
}
