/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v4.os.ResultReceiver
 *  android.text.TextUtils
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import androidx.media.MediaBrowserServiceCompat;

private class MediaBrowserServiceCompat.ServiceBinderImpl {
    final MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat.ServiceBinderImpl(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    public void addSubscription(String string, IBinder iBinder, Bundle bundle, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void connect(String string, int n, int n2, Bundle object, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        if (this.this$0.isValidPackage(string, n2)) {
            this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Package/uid mismatch: uid=");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" package=");
        ((StringBuilder)object).append(string);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void disconnect(MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void getMediaItem(String string, ResultReceiver resultReceiver, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        if (TextUtils.isEmpty((CharSequence)string)) return;
        if (resultReceiver == null) return;
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void registerCallbacks(MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, String string, int n, int n2, Bundle bundle) {
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void removeSubscription(String string, IBinder iBinder, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void search(String string, Bundle bundle, ResultReceiver resultReceiver, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        if (TextUtils.isEmpty((CharSequence)string)) return;
        if (resultReceiver == null) return;
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void sendCustomAction(String string, Bundle bundle, ResultReceiver resultReceiver, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        if (TextUtils.isEmpty((CharSequence)string)) return;
        if (resultReceiver == null) return;
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void unregisterCallbacks(MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        this.this$0.mHandler.postOrRun((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
