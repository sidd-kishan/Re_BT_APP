/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.support.v4.media.MediaBrowserCompat$ItemCallback$StubApi23
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.MediaBrowserCompatApi23
 *  android.support.v4.media.MediaBrowserCompatApi23$ItemCallback
 */
package android.support.v4.media;

import android.os.Build;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompatApi23;

public static abstract class MediaBrowserCompat.ItemCallback {
    final Object mItemCallbackObj = Build.VERSION.SDK_INT >= 23 ? MediaBrowserCompatApi23.createItemCallback((MediaBrowserCompatApi23.ItemCallback)new StubApi23(this)) : null;

    public void onError(String string) {
    }

    public void onItemLoaded(MediaBrowserCompat.MediaItem mediaItem) {
    }
}
