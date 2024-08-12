/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  androidx.core.util.Pair
 *  androidx.media.MediaBrowserCompatUtils
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import java.util.Iterator;
import java.util.List;

class MediaBrowserServiceCompat.MediaBrowserServiceImplBase
implements MediaBrowserServiceCompat.MediaBrowserServiceImpl {
    private Messenger mMessenger;
    final MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat.MediaBrowserServiceImplBase(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    public Bundle getBrowserRootHints() {
        if (this.this$0.mCurConnection == null) throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        Bundle bundle = this.this$0.mCurConnection.rootHints == null ? null : new Bundle(this.this$0.mCurConnection.rootHints);
        return bundle;
    }

    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        if (this.this$0.mCurConnection == null) throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        return this.this$0.mCurConnection.browserInfo;
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String string, Bundle bundle) {
        this.this$0.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void notifyChildrenChanged(String string, Bundle bundle) {
        this.this$0.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    void notifyChildrenChangedOnHandler(MediaBrowserServiceCompat.ConnectionRecord connectionRecord, String string, Bundle bundle) {
        List list = (List)connectionRecord.subscriptions.get(string);
        if (list == null) return;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list = (Pair)iterator.next();
            if (!MediaBrowserCompatUtils.hasDuplicatedItems((Bundle)bundle, (Bundle)((Bundle)((Pair)list).second))) continue;
            this.this$0.performLoadChildren(string, connectionRecord, (Bundle)((Pair)list).second, bundle);
        }
    }

    public IBinder onBind(Intent intent) {
        if (!"android.media.browse.MediaBrowserService".equals(intent.getAction())) return null;
        return this.mMessenger.getBinder();
    }

    public void onCreate() {
        this.mMessenger = new Messenger((Handler)this.this$0.mHandler);
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        this.this$0.mHandler.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
