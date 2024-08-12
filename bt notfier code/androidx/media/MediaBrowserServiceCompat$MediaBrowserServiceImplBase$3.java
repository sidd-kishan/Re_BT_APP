/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase
 *  androidx.media.MediaSessionManager$RemoteUserInfo
 */
package androidx.media;

import android.os.Bundle;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;

class MediaBrowserServiceCompat.MediaBrowserServiceImplBase.3
implements Runnable {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplBase this$1;
    final Bundle val$options;
    final String val$parentId;
    final MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

    MediaBrowserServiceCompat.MediaBrowserServiceImplBase.3(MediaBrowserServiceCompat.MediaBrowserServiceImplBase mediaBrowserServiceImplBase, MediaSessionManager.RemoteUserInfo remoteUserInfo, String string, Bundle bundle) {
        this.this$1 = mediaBrowserServiceImplBase;
        this.val$remoteUserInfo = remoteUserInfo;
        this.val$parentId = string;
        this.val$options = bundle;
    }

    @Override
    public void run() {
        int n = 0;
        while (n < this.this$1.this$0.mConnections.size()) {
            MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)this.this$1.this$0.mConnections.valueAt(n);
            if (connectionRecord.browserInfo.equals((Object)this.val$remoteUserInfo)) {
                this.this$1.notifyChildrenChangedOnHandler(connectionRecord, this.val$parentId, this.val$options);
                return;
            }
            ++n;
        }
    }
}
