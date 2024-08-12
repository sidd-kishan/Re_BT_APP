/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23
 *  androidx.media.MediaBrowserServiceCompat$Result
 *  androidx.media.MediaBrowserServiceCompatApi21
 *  androidx.media.MediaBrowserServiceCompatApi26
 *  androidx.media.MediaBrowserServiceCompatApi26$ResultWrapper
 *  androidx.media.MediaBrowserServiceCompatApi26$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import android.os.Bundle;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi26;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi26
extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi23
implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
    final MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi26(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        super(mediaBrowserServiceCompat);
    }

    public Bundle getBrowserRootHints() {
        if (this.this$0.mCurConnection == null) return MediaBrowserServiceCompatApi26.getBrowserRootHints((Object)this.mServiceObj);
        Bundle bundle = this.this$0.mCurConnection.rootHints == null ? null : new Bundle(this.this$0.mCurConnection.rootHints);
        return bundle;
    }

    void notifyChildrenChangedForFramework(String string, Bundle bundle) {
        if (bundle != null) {
            MediaBrowserServiceCompatApi26.notifyChildrenChanged((Object)this.mServiceObj, (String)string, (Bundle)bundle);
        } else {
            super.notifyChildrenChangedForFramework(string, bundle);
        }
    }

    public void onCreate() {
        this.mServiceObj = MediaBrowserServiceCompatApi26.createService((Context)this.this$0, (MediaBrowserServiceCompatApi26.ServiceCompatProxy)this);
        MediaBrowserServiceCompatApi21.onCreate((Object)this.mServiceObj);
    }

    public void onLoadChildren(String string, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
        resultWrapper = new /* Unavailable Anonymous Inner Class!! */;
        this.this$0.onLoadChildren(string, (MediaBrowserServiceCompat.Result)resultWrapper, bundle);
    }
}
