/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.appcompat.widget.SearchView$SavedState
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.SearchView;

class SearchView.SavedState.1
implements Parcelable.ClassLoaderCreator<SearchView.SavedState> {
    SearchView.SavedState.1() {
    }

    public SearchView.SavedState createFromParcel(Parcel parcel) {
        return new SearchView.SavedState(parcel, null);
    }

    public SearchView.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SearchView.SavedState(parcel, classLoader);
    }

    public SearchView.SavedState[] newArray(int n) {
        return new SearchView.SavedState[n];
    }
}
