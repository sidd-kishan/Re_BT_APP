/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.PlaybackStateCompat
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.PlaybackStateCompat;

static final class PlaybackStateCompat.1
implements Parcelable.Creator<PlaybackStateCompat> {
    PlaybackStateCompat.1() {
    }

    public PlaybackStateCompat createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat(parcel);
    }

    public PlaybackStateCompat[] newArray(int n) {
        return new PlaybackStateCompat[n];
    }
}
