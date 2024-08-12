/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.os.RemoteException
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection
 *  android.support.v4.media.MediaBrowserCompat$ServiceBinderWrapper
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

class MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
implements Runnable {
    final MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection this$1;
    final IBinder val$binder;
    final ComponentName val$name;

    MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1(MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mediaServiceConnection, ComponentName componentName, IBinder iBinder) {
        this.this$1 = mediaServiceConnection;
        this.val$name = componentName;
        this.val$binder = iBinder;
    }

    @Override
    public void run() {
        if (MediaBrowserCompat.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MediaServiceConnection.onServiceConnected name=");
            stringBuilder.append(this.val$name);
            stringBuilder.append(" binder=");
            stringBuilder.append(this.val$binder);
            Log.d((String)"MediaBrowserCompat", (String)stringBuilder.toString());
            this.this$1.this$0.dump();
        }
        if (!this.this$1.isCurrent("onServiceConnected")) {
            return;
        }
        this.this$1.this$0.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(this.val$binder, this.this$1.this$0.mRootHints);
        this.this$1.this$0.mCallbacksMessenger = new Messenger((Handler)this.this$1.this$0.mHandler);
        this.this$1.this$0.mHandler.setCallbacksMessenger(this.this$1.this$0.mCallbacksMessenger);
        this.this$1.this$0.mState = 2;
        try {
            if (MediaBrowserCompat.DEBUG) {
                Log.d((String)"MediaBrowserCompat", (String)"ServiceCallbacks.onConnect...");
                this.this$1.this$0.dump();
            }
            this.this$1.this$0.mServiceBinderWrapper.connect(this.this$1.this$0.mContext, this.this$1.this$0.mCallbacksMessenger);
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RemoteException during connect for ");
            stringBuilder.append(this.this$1.this$0.mServiceComponent);
            Log.w((String)"MediaBrowserCompat", (String)stringBuilder.toString());
            if (!MediaBrowserCompat.DEBUG) return;
            Log.d((String)"MediaBrowserCompat", (String)"ServiceCallbacks.onConnect...");
            this.this$1.this$0.dump();
        }
    }
}
