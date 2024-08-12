/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.recyclerview.widget.RecyclerView$SavedState
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;

class RecyclerView.SavedState.1
implements Parcelable.ClassLoaderCreator<RecyclerView.SavedState> {
    RecyclerView.SavedState.1() {
    }

    public RecyclerView.SavedState createFromParcel(Parcel parcel) {
        return new RecyclerView.SavedState(parcel, null);
    }

    public RecyclerView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new RecyclerView.SavedState(parcel, classLoader);
    }

    public RecyclerView.SavedState[] newArray(int n) {
        return new RecyclerView.SavedState[n];
    }
}
