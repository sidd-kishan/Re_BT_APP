/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  androidx.media.MediaBrowserServiceCompat
 *  androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21
 *  androidx.media.MediaBrowserServiceCompat$Result
 *  androidx.media.MediaBrowserServiceCompatApi21
 *  androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper
 *  androidx.media.MediaBrowserServiceCompatApi23
 *  androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import android.os.Parcel;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;

class MediaBrowserServiceCompat.MediaBrowserServiceImplApi23
extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
    final MediaBrowserServiceCompat this$0;

    MediaBrowserServiceCompat.MediaBrowserServiceImplApi23(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
        super(mediaBrowserServiceCompat);
    }

    public void onCreate() {
        this.mServiceObj = MediaBrowserServiceCompatApi23.createService((Context)this.this$0, (MediaBrowserServiceCompatApi23.ServiceCompatProxy)this);
        MediaBrowserServiceCompatApi21.onCreate((Object)this.mServiceObj);
    }

    public void onLoadItem(String string, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> var2_2) {
        var2_2 = new /* Unavailable Anonymous Inner Class!! */;
        this.this$0.onLoadItem(string, (MediaBrowserServiceCompat.Result)var2_2);
    }
}
