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

static class SearchView.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<SearchView.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    boolean isIconified;

    public SearchView.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.isIconified = (Boolean)parcel.readValue(null);
    }

    SearchView.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SearchView.SavedState{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append(" isIconified=");
        stringBuilder.append(this.isIconified);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeValue((Object)this.isIconified);
    }
}
