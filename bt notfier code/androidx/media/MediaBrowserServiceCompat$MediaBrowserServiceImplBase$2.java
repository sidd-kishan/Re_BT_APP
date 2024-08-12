/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

class MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2
implements Runnable {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplBase this$1;
    final Bundle val$options;
    final String val$parentId;

    MediaBrowserServiceCompat.MediaBrowserServiceImplBase.2(MediaBrowserServiceCompat.MediaBrowserServiceImplBase mediaBrowserServiceImplBase, String string, Bundle bundle) {
        this.this$1 = mediaBrowserServiceImplBase;
        this.val$parentId = string;
        this.val$options = bundle;
    }

    @Override
    public void run() {
        Iterator iterator = this.this$1.this$0.mConnections.keySet().iterator();
        while (iterator.hasNext()) {
            IBinder iBinder = (IBinder)iterator.next();
            iBinder = (MediaBrowserServiceCompat.ConnectionRecord)this.this$1.this$0.mConnections.get((Object)iBinder);
            this.this$1.notifyChildrenChangedOnHandler((MediaBrowserServiceCompat.ConnectionRecord)iBinder, this.val$parentId, this.val$options);
        }
    }
}
