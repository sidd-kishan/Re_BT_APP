/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.media.MediaBrowserServiceCompatApi23$MediaBrowserServiceAdaptor
 *  androidx.media.MediaBrowserServiceCompatApi23$ServiceCompatProxy
 */
package androidx.media;

import android.content.Context;
import androidx.media.MediaBrowserServiceCompatApi23;

class MediaBrowserServiceCompatApi23 {
    private MediaBrowserServiceCompatApi23() {
    }

    public static Object createService(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }
}
