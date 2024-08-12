/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Bundle
 *  android.service.media.MediaBrowserService$Result
 *  android.support.v4.media.session.MediaSessionCompat
 *  androidx.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor
 *  androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy
 *  androidx.media.MediaBrowserServiceCompatApi26$ResultWrapper
 *  androidx.media.MediaBrowserServiceCompatApi26$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import java.util.List;

static class MediaBrowserServiceCompatApi26.MediaBrowserServiceAdaptor
extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
    MediaBrowserServiceCompatApi26.MediaBrowserServiceAdaptor(Context context, MediaBrowserServiceCompatApi26.ServiceCompatProxy serviceCompatProxy) {
        super(context, (MediaBrowserServiceCompatApi23.ServiceCompatProxy)serviceCompatProxy);
    }

    public void onLoadChildren(String string, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
        MediaSessionCompat.ensureClassLoader((Bundle)bundle);
        ((MediaBrowserServiceCompatApi26.ServiceCompatProxy)this.mServiceProxy).onLoadChildren(string, new MediaBrowserServiceCompatApi26.ResultWrapper(result), bundle);
    }
}
