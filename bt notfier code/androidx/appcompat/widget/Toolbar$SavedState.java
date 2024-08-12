/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

public static class Toolbar.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<Toolbar.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    int expandedMenuItemId;
    boolean isOverflowOpen;

    public Toolbar.SavedState(Parcel parcel) {
        this(parcel, null);
    }

    public Toolbar.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.expandedMenuItemId = parcel.readInt();
        boolean bl = parcel.readInt() != 0;
        this.isOverflowOpen = bl;
    }

    public Toolbar.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.expandedMenuItemId);
        parcel.writeInt(this.isOverflowOpen ? 1 : 0);
    }
}
