/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.support.v4.media.session.IMediaSession
 *  android.support.v4.media.session.MediaSessionCompat$Token
 *  androidx.core.app.BundleCompat
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
 *  androidx.media.MediaBrowserServiceCompatApi21
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import java.util.Iterator;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1
implements Runnable {
    final MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 this$1;
    final MediaSessionCompat.Token val$token;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.1(MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21, MediaSessionCompat.Token token) {
        this.this$1 = mediaBrowserServiceImplApi21;
        this.val$token = token;
    }

    @Override
    public void run() {
        if (!this.this$1.mRootExtrasList.isEmpty()) {
            IMediaSession iMediaSession = this.val$token.getExtraBinder();
            if (iMediaSession != null) {
                Iterator iterator = this.this$1.mRootExtrasList.iterator();
                while (iterator.hasNext()) {
                    BundleCompat.putBinder((Bundle)((Bundle)iterator.next()), (String)"extra_session_binder", (IBinder)iMediaSession.asBinder());
                }
            }
            this.this$1.mRootExtrasList.clear();
        }
        MediaBrowserServiceCompatApi21.setSessionToken((Object)this.this$1.mServiceObj, (Object)this.val$token.getToken());
    }
}
