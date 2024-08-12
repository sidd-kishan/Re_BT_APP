/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$Result
 */
package androidx.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

class MediaBrowserServiceCompat.1
extends MediaBrowserServiceCompat.Result<List<MediaBrowserCompat.MediaItem>> {
    final MediaBrowserServiceCompat this$0;
    final MediaBrowserServiceCompat.ConnectionRecord val$connection;
    final Bundle val$notifyChildrenChangedOptions;
    final String val$parentId;
    final Bundle val$subscribeOptions;

    MediaBrowserServiceCompat.1(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, MediaBrowserServiceCompat.ConnectionRecord connectionRecord, String string, Bundle bundle, Bundle bundle2) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$connection = connectionRecord;
        this.val$parentId = string;
        this.val$subscribeOptions = bundle;
        this.val$notifyChildrenChangedOptions = bundle2;
        super(object);
    }

    void onResultSent(List<MediaBrowserCompat.MediaItem> object) {
        if (this.this$0.mConnections.get((Object)this.val$connection.callbacks.asBinder()) != this.val$connection) {
            if (!MediaBrowserServiceCompat.DEBUG) return;
            object = new StringBuilder();
            ((StringBuilder)object).append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
            ((StringBuilder)object).append(this.val$connection.pkg);
            ((StringBuilder)object).append(" id=");
            ((StringBuilder)object).append(this.val$parentId);
            Log.d((String)"MBServiceCompat", (String)((StringBuilder)object).toString());
            return;
        }
        List list = object;
        if ((this.getFlags() & 1) != 0) {
            list = this.this$0.applyOptions((List)object, this.val$subscribeOptions);
        }
        try {
            this.val$connection.callbacks.onLoadChildren(this.val$parentId, list, this.val$subscribeOptions, this.val$notifyChildrenChangedOptions);
        }
        catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Calling onLoadChildren() failed for id=");
            stringBuilder.append(this.val$parentId);
            stringBuilder.append(" package=");
            stringBuilder.append(this.val$connection.pkg);
            Log.w((String)"MBServiceCompat", (String)stringBuilder.toString());
        }
    }
}
