/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.support.v4.os.ResultReceiver
 */
package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;

class ResultReceiver.1
implements Parcelable.Creator<ResultReceiver> {
    ResultReceiver.1() {
    }

    public ResultReceiver createFromParcel(Parcel parcel) {
        return new ResultReceiver(parcel);
    }

    public ResultReceiver[] newArray(int n) {
        return new ResultReceiver[n];
    }
}
