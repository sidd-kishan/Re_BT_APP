/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompat$ConnectionRecord
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase
 */
package androidx.media;

import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat;
import java.util.Iterator;

class MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1
implements Runnable {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplBase this$1;
    final MediaSessionCompat.Token val$token;

    MediaBrowserServiceCompat.MediaBrowserServiceImplBase.1(MediaBrowserServiceCompat.MediaBrowserServiceImplBase mediaBrowserServiceImplBase, MediaSessionCompat.Token token) {
        this.this$1 = mediaBrowserServiceImplBase;
        this.val$token = token;
    }

    @Override
    public void run() {
        Iterator iterator = this.this$1.this$0.mConnections.values().iterator();
        while (iterator.hasNext()) {
            MediaBrowserServiceCompat.ConnectionRecord connectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)iterator.next();
            try {
                connectionRecord.callbacks.onConnect(connectionRecord.root.getRootId(), this.val$token, connectionRecord.root.getExtras());
            }
            catch (RemoteException remoteException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Connection for ");
                stringBuilder.append(connectionRecord.pkg);
                stringBuilder.append(" is no longer valid.");
                Log.w((String)"MBServiceCompat", (String)stringBuilder.toString());
                iterator.remove();
            }
        }
    }
}
