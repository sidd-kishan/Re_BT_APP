/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;

private class MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection
implements ServiceConnection {
    final MediaBrowserCompat.MediaBrowserImplBase this$0;

    MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection(MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase) {
        this.this$0 = mediaBrowserImplBase;
    }

    private void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == this.this$0.mHandler.getLooper().getThread()) {
            runnable.run();
        } else {
            this.this$0.mHandler.post(runnable);
        }
    }

    boolean isCurrent(String string) {
        if (this.this$0.mServiceConnection == this && this.this$0.mState != 0) {
            if (this.this$0.mState != 1) return true;
        }
        if (this.this$0.mState == 0) return false;
        if (this.this$0.mState == 1) return false;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" for ");
        stringBuilder.append(this.this$0.mServiceComponent);
        stringBuilder.append(" with mServiceConnection=");
        stringBuilder.append(this.this$0.mServiceConnection);
        stringBuilder.append(" this=");
        stringBuilder.append(this);
        Log.i((String)"MediaBrowserCompat", (String)stringBuilder.toString());
        return false;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
