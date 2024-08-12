/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.MediaBrowserCompatApi21$ConnectionCallback
 */
package android.support.v4.media;

import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi21;

private class MediaBrowserCompat.ConnectionCallback.StubApi21
implements MediaBrowserCompatApi21.ConnectionCallback {
    final MediaBrowserCompat.ConnectionCallback this$0;

    MediaBrowserCompat.ConnectionCallback.StubApi21(MediaBrowserCompat.ConnectionCallback connectionCallback) {
        this.this$0 = connectionCallback;
    }

    public void onConnected() {
        if (this.this$0.mConnectionCallbackInternal != null) {
            this.this$0.mConnectionCallbackInternal.onConnected();
        }
        this.this$0.onConnected();
    }

    public void onConnectionFailed() {
        if (this.this$0.mConnectionCallbackInternal != null) {
            this.this$0.mConnectionCallbackInternal.onConnectionFailed();
        }
        this.this$0.onConnectionFailed();
    }

    public void onConnectionSuspended() {
        if (this.this$0.mConnectionCallbackInternal != null) {
            this.this$0.mConnectionCallbackInternal.onConnectionSuspended();
        }
        this.this$0.onConnectionSuspended();
    }
}
