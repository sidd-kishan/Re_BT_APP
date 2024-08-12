/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

class MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection this$1;
    final ComponentName val$name;

    MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2(MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mediaServiceConnection, ComponentName componentName) {
        this.this$1 = mediaServiceConnection;
        this.val$name = componentName;
    }

    @Override
    public void run() {
        if (MediaBrowserCompat.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MediaServiceConnection.onServiceDisconnected name=");
            stringBuilder.append(this.val$name);
            stringBuilder.append(" this=");
            stringBuilder.append(this);
            stringBuilder.append(" mServiceConnection=");
            stringBuilder.append(this.this$1.this$0.mServiceConnection);
            Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
            this.this$1.this$0.dump();
        }
        if (!this.this$1.isCurrent("onServiceDisconnected")) {
            return;
        }
        this.this$1.this$0.mServiceBinderWrapper = null;
        this.this$1.this$0.mCallbacksMessenger = null;
        this.this$1.this$0.mHandler.setCallbacksMessenger(null);
        this.this$1.this$0.mState = 4;
        this.this$1.this$0.mCallback.onConnectionSuspended();
    }
}
