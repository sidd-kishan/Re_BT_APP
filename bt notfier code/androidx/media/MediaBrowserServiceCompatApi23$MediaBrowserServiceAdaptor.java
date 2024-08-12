/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.service.media.MediaBrowserService$Result
 *  androidx.media.MediaBrowserServiceCompatApi21$MediaBrowserServiceAdaptor
 *  androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper
 *  androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
 *  androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.service.media.MediaBrowserService;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;

static class MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor
extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
    MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor(Context context, MediaBrowserServiceCompatApi23.ServiceCompatProxy serviceCompatProxy) {
        super(context, (MediaBrowserServiceCompatApi21.ServiceCompatProxy)serviceCompatProxy);
    }

    public void onLoadItem(String string, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
        ((MediaBrowserServiceCompatApi23.ServiceCompatProxy)this.mServiceProxy).onLoadItem(string, new MediaBrowserServiceCompatApi21.ResultWrapper(result));
    }
}
