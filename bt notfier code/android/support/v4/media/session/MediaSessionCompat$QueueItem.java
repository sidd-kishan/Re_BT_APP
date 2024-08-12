/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.support.v4.media.session.MediaSessionCompatApi21$QueueItem
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompatApi21;
import java.util.ArrayList;
import java.util.List;

public static final class MediaSessionCompat.QueueItem
implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat.QueueItem> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public static final int UNKNOWN_ID = -1;
    private final MediaDescriptionCompat mDescription;
    private final long mId;
    private Object mItem;

    MediaSessionCompat.QueueItem(Parcel parcel) {
        this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.mId = parcel.readLong();
    }

    public MediaSessionCompat.QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long l) {
        this(null, mediaDescriptionCompat, l);
    }

    private MediaSessionCompat.QueueItem(Object object, MediaDescriptionCompat mediaDescriptionCompat, long l) {
        if (mediaDescriptionCompat == null) throw new IllegalArgumentException("Description cannot be null.");
        if (l == -1L) throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        this.mDescription = mediaDescriptionCompat;
        this.mId = l;
        this.mItem = object;
    }

    public static MediaSessionCompat.QueueItem fromQueueItem(Object object) {
        if (object == null) return null;
        if (Build.VERSION.SDK_INT >= 21) return new MediaSessionCompat.QueueItem(object, MediaDescriptionCompat.fromMediaDescription((Object)MediaSessionCompatApi21.QueueItem.getDescription((Object)object)), MediaSessionCompatApi21.QueueItem.getQueueId((Object)object));
        return null;
    }

    public static List<MediaSessionCompat.QueueItem> fromQueueItemList(List<?> object) {
        if (object == null) return null;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        ArrayList<MediaSessionCompat.QueueItem> arrayList = new ArrayList<MediaSessionCompat.QueueItem>();
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(MediaSessionCompat.QueueItem.fromQueueItem(object.next()));
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public MediaDescriptionCompat getDescription() {
        return this.mDescription;
    }

    public long getQueueId() {
        return this.mId;
    }

    public Object getQueueItem() {
        Object object;
        if (this.mItem != null) return this.mItem;
        if (Build.VERSION.SDK_INT < 21) {
            return this.mItem;
        }
        this.mItem = object = MediaSessionCompatApi21.QueueItem.createItem((Object)this.mDescription.getMediaDescription(), (long)this.mId);
        return object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaSession.QueueItem {Description=");
        stringBuilder.append(this.mDescription);
        stringBuilder.append(", Id=");
        stringBuilder.append(this.mId);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        this.mDescription.writeToParcel(parcel, n);
        parcel.writeLong(this.mId);
    }
}
