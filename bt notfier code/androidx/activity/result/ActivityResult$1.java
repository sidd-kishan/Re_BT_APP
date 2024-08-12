/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.activity.result.ActivityResult
 */
package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;

class ActivityResult.1
implements Parcelable.Creator<ActivityResult> {
    ActivityResult.1() {
    }

    public ActivityResult createFromParcel(Parcel parcel) {
        return new ActivityResult(parcel);
    }

    public ActivityResult[] newArray(int n) {
        return new ActivityResult[n];
    }
}
