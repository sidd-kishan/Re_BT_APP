/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.view.View$BaseSavedState
 */
package androidx.core.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

static class NestedScrollView.SavedState
extends View.BaseSavedState {
    public static final Parcelable.Creator<NestedScrollView.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public int scrollPosition;

    NestedScrollView.SavedState(Parcel parcel) {
        super(parcel);
        this.scrollPosition = parcel.readInt();
    }

    NestedScrollView.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HorizontalScrollView.SavedState{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append(" scrollPosition=");
        stringBuilder.append(this.scrollPosition);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.scrollPosition);
    }
}
