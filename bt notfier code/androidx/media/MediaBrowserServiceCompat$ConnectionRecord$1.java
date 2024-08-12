/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 */
package androidx.media;

import androidx.media.MediaBrowserServiceCompat;

class MediaBrowserServiceCompat.ConnectionRecord.1
implements Runnable {
    final MediaBrowserServiceCompat.ConnectionRecord this$1;

    MediaBrowserServiceCompat.ConnectionRecord.1(MediaBrowserServiceCompat.ConnectionRecord connectionRecord) {
        this.this$1 = connectionRecord;
    }

    @Override
    public void run() {
        this.this$1.this$0.mConnections.remove((Object)this.this$1.callbacks.asBinder());
    }
}
