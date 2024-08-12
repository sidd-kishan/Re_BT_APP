/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.ResultReceiver
 */
package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

public static final class MediaSessionCompat.ResultReceiverWrapper
implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat.ResultReceiverWrapper> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    ResultReceiver mResultReceiver;

    MediaSessionCompat.ResultReceiverWrapper(Parcel parcel) {
        this.mResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(parcel);
    }

    public MediaSessionCompat.ResultReceiverWrapper(ResultReceiver resultReceiver) {
        this.mResultReceiver = resultReceiver;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        this.mResultReceiver.writeToParcel(parcel, n);
    }
}
