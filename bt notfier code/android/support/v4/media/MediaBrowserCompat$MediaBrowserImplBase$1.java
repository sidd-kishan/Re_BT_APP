/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.Intent;
import android.content.ServiceConnection;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

class MediaBrowserCompat.MediaBrowserImplBase.1
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplBase this$0;

    MediaBrowserCompat.MediaBrowserImplBase.1(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase) {
        this.this$0 = mediaBrowserImplBase;
    }

    @Override
    public void run() {
        if (this.this$0.mState == 0) {
            return;
        }
        this.this$0.mState = 2;
        if (MediaBrowserCompat.DEBUG && this.this$0.mServiceConnection != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mServiceConnection should be null. Instead it is ");
            stringBuilder.append(this.this$0.mServiceConnection);
            throw new RuntimeException(stringBuilder.toString());
        }
        if (this.this$0.mServiceBinderWrapper != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mServiceBinderWrapper should be null. Instead it is ");
            stringBuilder.append(this.this$0.mServiceBinderWrapper);
            throw new RuntimeException(stringBuilder.toString());
        }
        if (this.this$0.mCallbacksMessenger != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mCallbacksMessenger should be null. Instead it is ");
            stringBuilder.append(this.this$0.mCallbacksMessenger);
            throw new RuntimeException(stringBuilder.toString());
        }
        Intent intent = new Intent("android.media.browse.MediaBrowserService");
        intent.setComponent(this.this$0.mServiceComponent);
        MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = this.this$0;
        mediaBrowserImplBase.mServiceConnection = new MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection(mediaBrowserImplBase);
        boolean bl = false;
        try {
            boolean bl2;
            bl = bl2 = this.this$0.mContext.bindService(intent, (ServiceConnection)this.this$0.mServiceConnection, 1);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed binding to service ");
            stringBuilder.append(this.this$0.mServiceComponent);
            Log.e((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        }
        if (!bl) {
            this.this$0.forceCloseConnection();
            this.this$0.mCallback.onConnectionFailed();
        }
        if (!MediaBrowserCompat.DEBUG) return;
        Log.d((String)"MediaBrowserCompat", (String)"connect...");
        this.this$0.dump();
    }
}
