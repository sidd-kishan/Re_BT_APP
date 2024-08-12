/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

public final class IntentSenderRequest
implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    IntentSenderRequest(IntentSender intentSender, Intent intent, int n, int n2) {
        this.mIntentSender = intentSender;
        this.mFillInIntent = intent;
        this.mFlagsMask = n;
        this.mFlagsValues = n2;
    }

    IntentSenderRequest(Parcel parcel) {
        this.mIntentSender = (IntentSender)parcel.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent)parcel.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = parcel.readInt();
        this.mFlagsValues = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeParcelable((Parcelable)this.mIntentSender, n);
        parcel.writeParcelable((Parcelable)this.mFillInIntent, n);
        parcel.writeInt(this.mFlagsMask);
        parcel.writeInt(this.mFlagsValues);
    }
}
