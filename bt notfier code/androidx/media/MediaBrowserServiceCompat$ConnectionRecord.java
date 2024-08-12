/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  androidx.core.util.Pair
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$BrowserRoot
 *  androidx.media.MediaBrowserServiceCompat$ServiceCallbacks
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import java.util.HashMap;
import java.util.List;

private class MediaBrowserServiceCompat.ConnectionRecord
implements IBinder.DeathRecipient {
    public final MediaSessionManager.RemoteUserInfo browserInfo;
    public final MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    public final int pid;
    public final String pkg;
    public MediaBrowserServiceCompat.BrowserRoot root;
    public final Bundle rootHints;
    public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions;
    final MediaBrowserServiceCompat this$0;
    public final int uid;

    MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat mediaBrowserServiceCompat, String string, int n, int n2, Bundle bundle, MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
        this.this$0 = mediaBrowserServiceCompat;
        this.subscriptions = new HashMap();
        this.pkg = string;
        this.pid = n;
        this.uid = n2;
        this.browserInfo = new MediaSessionManager.RemoteUserInfo(string, n, n2);
        this.rootHints = bundle;
        this.callbacks = serviceCallbacks;
    }

    public void binderDied() {
        this.this$0.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
