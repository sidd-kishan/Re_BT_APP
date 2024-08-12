/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.MediaBrowserCompatApi21$MediaItem
 *  android.support.v4.media.MediaDescriptionCompat
 *  android.text.TextUtils
 */
package android.support.v4.media;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaDescriptionCompat;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public static class MediaBrowserCompat.MediaItem
implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat.MediaItem> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;

    MediaBrowserCompat.MediaItem(Parcel parcel) {
        this.mFlags = parcel.readInt();
        this.mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public MediaBrowserCompat.MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int n) {
        if (mediaDescriptionCompat == null) throw new IllegalArgumentException("description cannot be null");
        if (TextUtils.isEmpty((CharSequence)mediaDescriptionCompat.getMediaId())) throw new IllegalArgumentException("description must have a non-empty media id");
        this.mFlags = n;
        this.mDescription = mediaDescriptionCompat;
    }

    public static MediaBrowserCompat.MediaItem fromMediaItem(Object object) {
        if (object == null) return null;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        int n = MediaBrowserCompatApi21.MediaItem.getFlags((Object)object);
        return new MediaBrowserCompat.MediaItem(MediaDescriptionCompat.fromMediaDescription((Object)MediaBrowserCompatApi21.MediaItem.getDescription((Object)object)), n);
    }

    public static List<MediaBrowserCompat.MediaItem> fromMediaItemList(List<?> object) {
        if (object == null) return null;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        ArrayList<MediaBrowserCompat.MediaItem> arrayList = new ArrayList<MediaBrowserCompat.MediaItem>(object.size());
        object = object.iterator();
        while (object.hasNext()) {
            arrayList.add(MediaBrowserCompat.MediaItem.fromMediaItem(object.next()));
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public MediaDescriptionCompat getDescription() {
        return this.mDescription;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public String getMediaId() {
        return this.mDescription.getMediaId();
    }

    public boolean isBrowsable() {
        int n = this.mFlags;
        boolean bl = true;
        if ((n & 1) != 0) return bl;
        bl = false;
        return bl;
    }

    public boolean isPlayable() {
        boolean bl = (this.mFlags & 2) != 0;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MediaItem{");
        stringBuilder.append("mFlags=");
        stringBuilder.append(this.mFlags);
        stringBuilder.append(", mDescription=");
        stringBuilder.append(this.mDescription);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.mFlags);
        this.mDescription.writeToParcel(parcel, n);
    }
}
