/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.Context
 *  android.content.Intent
 *  android.os.RemoteException
 *  android.support.v4.media.MediaBrowserCompat
 *  android.support.v4.media.MediaBrowserCompat$ConnectionCallback
 *  android.support.v4.media.session.MediaControllerCompat
 *  android.util.Log
 *  android.view.KeyEvent
 */
package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;

private static class MediaButtonReceiver.MediaButtonConnectionCallback
extends MediaBrowserCompat.ConnectionCallback {
    private final Context mContext;
    private final Intent mIntent;
    private MediaBrowserCompat mMediaBrowser;
    private final BroadcastReceiver.PendingResult mPendingResult;

    MediaButtonReceiver.MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        this.mContext = context;
        this.mIntent = intent;
        this.mPendingResult = pendingResult;
    }

    private void finish() {
        this.mMediaBrowser.disconnect();
        this.mPendingResult.finish();
    }

    public void onConnected() {
        try {
            MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(this.mContext, this.mMediaBrowser.getSessionToken());
            mediaControllerCompat.dispatchMediaButtonEvent((KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
        }
        catch (RemoteException remoteException) {
            Log.e((String)"MediaButtonReceiver", (String)"Failed to create a media controller", (Throwable)remoteException);
        }
        this.finish();
    }

    public void onConnectionFailed() {
        this.finish();
    }

    public void onConnectionSuspended() {
        this.finish();
    }

    void setMediaBrowser(MediaBrowserCompat mediaBrowserCompat) {
        this.mMediaBrowser = mediaBrowserCompat;
    }
}
