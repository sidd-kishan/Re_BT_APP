/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser
 *  android.media.browse.MediaBrowser$ItemCallback
 *  android.support.v4.media.MediaBrowserCompatApi23$ItemCallback
 *  android.support.v4.media.MediaBrowserCompatApi23$ItemCallbackProxy
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.support.v4.media.MediaBrowserCompatApi23;

class MediaBrowserCompatApi23 {
    private MediaBrowserCompatApi23() {
    }

    public static Object createItemCallback(ItemCallback itemCallback) {
        return new ItemCallbackProxy(itemCallback);
    }

    public static void getItem(Object object, String string, Object object2) {
        ((MediaBrowser)object).getItem(string, (MediaBrowser.ItemCallback)object2);
    }
}
