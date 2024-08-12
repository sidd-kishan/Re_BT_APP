/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

static final class MediaSessionCompat.ResultReceiverWrapper.1
implements Parcelable.Creator<MediaSessionCompat.ResultReceiverWrapper> {
    MediaSessionCompat.ResultReceiverWrapper.1() {
    }

    public MediaSessionCompat.ResultReceiverWrapper createFromParcel(Parcel parcel) {
        return new MediaSessionCompat.ResultReceiverWrapper(parcel);
    }

    public MediaSessionCompat.ResultReceiverWrapper[] newArray(int n) {
        return new MediaSessionCompat.ResultReceiverWrapper[n];
    }
}
