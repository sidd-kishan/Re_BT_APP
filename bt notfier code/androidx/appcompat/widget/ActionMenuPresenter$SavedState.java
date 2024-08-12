/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;

private static class ActionMenuPresenter.SavedState
implements Parcelable {
    public static final Parcelable.Creator<ActionMenuPresenter.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public int openSubMenuId;

    ActionMenuPresenter.SavedState() {
    }

    ActionMenuPresenter.SavedState(Parcel parcel) {
        this.openSubMenuId = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.openSubMenuId);
    }
}
