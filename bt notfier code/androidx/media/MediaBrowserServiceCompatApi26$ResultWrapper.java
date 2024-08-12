/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Parcel
 *  android.service.media.MediaBrowserService$Result
 *  android.util.Log
 *  androidx.media.MediaBrowserServiceCompatApi26
 */
package androidx.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompatApi26;
import java.util.ArrayList;
import java.util.List;

static class MediaBrowserServiceCompatApi26.ResultWrapper {
    MediaBrowserService.Result mResultObj;

    MediaBrowserServiceCompatApi26.ResultWrapper(MediaBrowserService.Result result) {
        this.mResultObj = result;
    }

    public void detach() {
        this.mResultObj.detach();
    }

    List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> object) {
        if (object == null) {
            return null;
        }
        ArrayList<MediaBrowser.MediaItem> arrayList = new ArrayList<MediaBrowser.MediaItem>();
        object = object.iterator();
        while (object.hasNext()) {
            Parcel parcel = (Parcel)object.next();
            parcel.setDataPosition(0);
            arrayList.add((MediaBrowser.MediaItem)MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
        return arrayList;
    }

    public void sendResult(List<Parcel> list, int n) {
        try {
            MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, n);
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.w((String)"MBSCompatApi26", (Throwable)illegalAccessException);
        }
        this.mResultObj.sendResult(this.parcelListToItemList(list));
    }
}
