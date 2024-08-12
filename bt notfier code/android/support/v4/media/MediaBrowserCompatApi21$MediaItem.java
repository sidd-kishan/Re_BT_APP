/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;

static class MediaBrowserCompatApi21.MediaItem {
    private MediaBrowserCompatApi21.MediaItem() {
    }

    public static Object getDescription(Object object) {
        return ((MediaBrowser.MediaItem)object).getDescription();
    }

    public static int getFlags(Object object) {
        return ((MediaBrowser.MediaItem)object).getFlags();
    }
}
