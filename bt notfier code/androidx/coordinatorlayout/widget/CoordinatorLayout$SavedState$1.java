/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState
 */
package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

static final class CoordinatorLayout.SavedState.1
implements Parcelable.ClassLoaderCreator<CoordinatorLayout.SavedState> {
    CoordinatorLayout.SavedState.1() {
    }

    public CoordinatorLayout.SavedState createFromParcel(Parcel parcel) {
        return new CoordinatorLayout.SavedState(parcel, null);
    }

    public CoordinatorLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new CoordinatorLayout.SavedState(parcel, classLoader);
    }

    public CoordinatorLayout.SavedState[] newArray(int n) {
        return new CoordinatorLayout.SavedState[n];
    }
}
