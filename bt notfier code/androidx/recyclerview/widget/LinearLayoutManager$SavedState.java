/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;

public static class LinearLayoutManager.SavedState
implements Parcelable {
    public static final Parcelable.Creator<LinearLayoutManager.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;

    public LinearLayoutManager.SavedState() {
    }

    LinearLayoutManager.SavedState(Parcel parcel) {
        this.mAnchorPosition = parcel.readInt();
        this.mAnchorOffset = parcel.readInt();
        int n = parcel.readInt();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        this.mAnchorLayoutFromEnd = bl;
    }

    public LinearLayoutManager.SavedState(LinearLayoutManager.SavedState savedState) {
        this.mAnchorPosition = savedState.mAnchorPosition;
        this.mAnchorOffset = savedState.mAnchorOffset;
        this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
    }

    public int describeContents() {
        return 0;
    }

    boolean hasValidAnchor() {
        boolean bl = this.mAnchorPosition >= 0;
        return bl;
    }

    void invalidateAnchor() {
        this.mAnchorPosition = -1;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.mAnchorPosition);
        parcel.writeInt(this.mAnchorOffset);
        parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
    }
}
