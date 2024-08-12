/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.slidingpanelayout.widget.SlidingPaneLayout$SavedState
 */
package androidx.slidingpanelayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

static final class SlidingPaneLayout.SavedState.1
implements Parcelable.ClassLoaderCreator<SlidingPaneLayout.SavedState> {
    SlidingPaneLayout.SavedState.1() {
    }

    public SlidingPaneLayout.SavedState createFromParcel(Parcel parcel) {
        return new SlidingPaneLayout.SavedState(parcel, null);
    }

    public SlidingPaneLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new SlidingPaneLayout.SavedState(parcel, null);
    }

    public SlidingPaneLayout.SavedState[] newArray(int n) {
        return new SlidingPaneLayout.SavedState[n];
    }
}
