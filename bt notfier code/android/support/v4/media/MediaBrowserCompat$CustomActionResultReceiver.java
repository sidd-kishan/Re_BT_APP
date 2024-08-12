/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.support.v4.media.MediaBrowserCompat$CustomActionCallback
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.os.ResultReceiver
 *  android.util.Log
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

private static class MediaBrowserCompat.CustomActionResultReceiver
extends ResultReceiver {
    private final String mAction;
    private final MediaBrowserCompat.CustomActionCallback mCallback;
    private final Bundle mExtras;

    MediaBrowserCompat.CustomActionResultReceiver(String string, Bundle bundle, MediaBrowserCompat.CustomActionCallback customActionCallback, Handler handler) {
        super(handler);
        this.mAction = string;
        this.mExtras = bundle;
        this.mCallback = customActionCallback;
    }

    protected void onReceiveResult(int n, Bundle bundle) {
        if (this.mCallback == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        if (n != -1) {
            if (n != 0) {
                if (n != 1) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown result code: ");
                    stringBuilder.append(n);
                    stringBuilder.append(" (extras=");
                    stringBuilder.append(this.mExtras);
                    stringBuilder.append(", resultData=");
                    stringBuilder.append(bundle);
                    stringBuilder.append(")");
                    Log.w((String)"MediaBrowserCompat", (String)stringBuilder.toString());
                } else {
                    this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                }
            } else {
                this.mCallback.onResult(this.mAction, this.mExtras, bundle);
            }
        } else {
            this.mCallback.onError(this.mAction, this.mExtras, bundle);
        }
    }
}
