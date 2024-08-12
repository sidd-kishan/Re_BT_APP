/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.support.v4.media.MediaBrowserCompat$MediaItem
 *  android.support.v4.media.MediaBrowserCompat$SearchCallback
 *  android.support.v4.media.session.MediaSessionCompat
 *  android.support.v4.os.ResultReceiver
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;
import java.util.List;

private static class MediaBrowserCompat.SearchResultReceiver
extends ResultReceiver {
    private final MediaBrowserCompat.SearchCallback mCallback;
    private final Bundle mExtras;
    private final String mQuery;

    MediaBrowserCompat.SearchResultReceiver(String string, Bundle bundle, MediaBrowserCompat.SearchCallback searchCallback, Handler handler) {
        super(handler);
        this.mQuery = string;
        this.mExtras = bundle;
        this.mCallback = searchCallback;
    }

    protected void onReceiveResult(int n, Bundle object) {
        MediaSessionCompat.ensureClassLoader((Bundle)object);
        if (n == 0 && object != null && object.containsKey("search_results")) {
            Parcelable[] parcelableArray = object.getParcelableArray("search_results");
            object = null;
            if (parcelableArray != null) {
                ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList<MediaBrowserCompat.MediaItem>();
                int n2 = parcelableArray.length;
                n = 0;
                while (true) {
                    object = arrayList;
                    if (n >= n2) break;
                    arrayList.add((MediaBrowserCompat.MediaItem)parcelableArray[n]);
                    ++n;
                }
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, (List)object);
            return;
        }
        this.mCallback.onError(this.mQuery, this.mExtras);
    }
}
