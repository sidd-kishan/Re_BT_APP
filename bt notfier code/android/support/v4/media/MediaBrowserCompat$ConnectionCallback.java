/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback$ConnectionCallbackInternal
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback$StubApi21
 *  android.support.v4.media.MediaBrowserCompatApi21
 *  android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback
 */
package android.support.v4.media;

import android.os.Build;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi21;

public static class MediaBrowserCompat.ConnectionCallback {
    ConnectionCallbackInternal mConnectionCallbackInternal;
    final Object mConnectionCallbackObj = Build.VERSION.SDK_INT >= 21 ? MediaBrowserCompatApi21.createConnectionCallback((MediaBrowserCompatApi21.ConnectionCallback)new StubApi21(this)) : null;

    public void onConnected() {
    }

    public void onConnectionFailed() {
    }

    public void onConnectionSuspended() {
    }

    void setInternalConnectionCallback(ConnectionCallbackInternal connectionCallbackInternal) {
        this.mConnectionCallbackInternal = connectionCallbackInternal;
    }
}
