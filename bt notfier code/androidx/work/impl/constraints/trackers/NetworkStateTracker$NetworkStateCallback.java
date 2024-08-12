/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  androidx.work.Logger
 *  androidx.work.impl.constraints.trackers.NetworkStateTracker
 */
package androidx.work.impl.constraints.trackers;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Logger;
import androidx.work.impl.constraints.trackers.NetworkStateTracker;

private class NetworkStateTracker.NetworkStateCallback
extends ConnectivityManager.NetworkCallback {
    final NetworkStateTracker this$0;

    NetworkStateTracker.NetworkStateCallback(NetworkStateTracker networkStateTracker) {
        this.this$0 = networkStateTracker;
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Logger.get().debug(NetworkStateTracker.TAG, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
        network = this.this$0;
        network.setState((Object)network.getActiveNetworkState());
    }

    public void onLost(Network network) {
        Logger.get().debug(NetworkStateTracker.TAG, "Network connection lost", new Throwable[0]);
        network = this.this$0;
        network.setState((Object)network.getActiveNetworkState());
    }
}
