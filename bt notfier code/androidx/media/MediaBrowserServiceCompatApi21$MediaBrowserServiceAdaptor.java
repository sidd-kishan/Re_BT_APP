/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Bundle
 *  android.service.media.MediaBrowserService
 *  android.service.media.MediaBrowserService$BrowserRoot
 *  android.service.media.MediaBrowserService$Result
 *  android.support.v4.media.session.MediaSessionCompat
 *  androidx.media.MediaBrowserServiceCompatApi21$BrowserRoot
 *  androidx.media.MediaBrowserServiceCompatApi21$ResultWrapper
 *  androidx.media.MediaBrowserServiceCompatApi21$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaBrowserServiceCompatApi21;
import java.util.List;

static class MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor
extends MediaBrowserService {
    final MediaBrowserServiceCompatApi21.ServiceCompatProxy mServiceProxy;

    MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor(Context context, MediaBrowserServiceCompatApi21.ServiceCompatProxy serviceCompatProxy) {
        this.attachBaseContext(context);
        this.mServiceProxy = serviceCompatProxy;
    }

    public MediaBrowserService.BrowserRoot onGetRoot(String string, int n, Bundle object) {
        MediaSessionCompat.ensureClassLoader((Bundle)object);
        MediaBrowserServiceCompatApi21.ServiceCompatProxy serviceCompatProxy = this.mServiceProxy;
        Object var4_5 = null;
        object = object == null ? null : new Bundle(object);
        string = serviceCompatProxy.onGetRoot(string, n, object);
        string = string == null ? var4_5 : new MediaBrowserService.BrowserRoot(((MediaBrowserServiceCompatApi21.BrowserRoot)string).mRootId, ((MediaBrowserServiceCompatApi21.BrowserRoot)string).mExtras);
        return string;
    }

    public void onLoadChildren(String string, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
        this.mServiceProxy.onLoadChildren(string, new MediaBrowserServiceCompatApi21.ResultWrapper(result));
    }
}
