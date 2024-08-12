/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.activity.result.IntentSenderRequest
 */
package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.IntentSenderRequest;

class IntentSenderRequest.1
implements Parcelable.Creator<IntentSenderRequest> {
    IntentSenderRequest.1() {
    }

    public IntentSenderRequest createFromParcel(Parcel parcel) {
        return new IntentSenderRequest(parcel);
    }

    public IntentSenderRequest[] newArray(int n) {
        return new IntentSenderRequest[n];
    }
}
