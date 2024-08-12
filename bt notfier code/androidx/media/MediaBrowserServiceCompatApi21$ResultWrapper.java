/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$MediaItem
 *  android.os.Parcel
 *  android.service.media.MediaBrowserService$Result
 */
package androidx.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import java.util.ArrayList;
import java.util.List;

static class MediaBrowserServiceCompatApi21.ResultWrapper<T> {
    MediaBrowserService.Result mResultObj;

    MediaBrowserServiceCompatApi21.ResultWrapper(MediaBrowserService.Result result) {
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

    public void sendResult(T object) {
        if (object instanceof List) {
            this.mResultObj.sendResult(this.parcelListToItemList((List)object));
        } else if (object instanceof Parcel) {
            object = (Parcel)object;
            object.setDataPosition(0);
            this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(object));
            object.recycle();
        } else {
            this.mResultObj.sendResult(null);
        }
    }
}
