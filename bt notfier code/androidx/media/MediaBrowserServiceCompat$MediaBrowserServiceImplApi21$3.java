/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3
implements Runnable {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 this$1;
    final Bundle val$options;
    final String val$parentId;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.3(MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21, String string, Bundle bundle) {
        this.this$1 = mediaBrowserServiceImplApi21;
        this.val$parentId = string;
        this.val$options = bundle;
    }

    @Override
    public void run() {
        Iterator iterator = this.this$1.this$0.mConnections.keySet().iterator();
        while (iterator.hasNext()) {
            IBinder iBinder = (IBinder)iterator.next();
            iBinder = (MediaBrowserServiceCompat.ConnectionRecord)this.this$1.this$0.mConnections.get((Object)iBinder);
            this.this$1.notifyChildrenChangedForCompatOnHandler((MediaBrowserServiceCompat.ConnectionRecord)iBinder, this.val$parentId, this.val$options);
        }
    }
}
