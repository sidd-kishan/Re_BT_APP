/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase
 *  android.util.Log
 */
package android.support.v4.media;

import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

class MediaBrowserCompat.MediaBrowserImplBase.2
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplBase this$0;

    MediaBrowserCompat.MediaBrowserImplBase.2(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase) {
        this.this$0 = mediaBrowserImplBase;
    }

    @Override
    public void run() {
        if (this.this$0.mCallbacksMessenger != null) {
            try {
                this.this$0.mServiceBinderWrapper.disconnect(this.this$0.mCallbacksMessenger);
            }
            catch (RemoteException remoteException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("RemoteException during connect for ");
                stringBuilder.append(this.this$0.mServiceComponent);
                Log.w((String)"MediaBrowserCompat", (String)stringBuilder.toString());
            }
        }
        int n = this.this$0.mState;
        this.this$0.forceCloseConnection();
        if (n != 0) {
            this.this$0.mState = n;
        }
        if (!MediaBrowserCompat.DEBUG) return;
        Log.d((String)"MediaBrowserCompat", (String)"disconnect...");
        this.this$0.dump();
    }
}
