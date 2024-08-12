/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.viewpager.widget.ViewPager$SavedState
 */
package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.viewpager.widget.ViewPager;

static final class ViewPager.SavedState.1
implements Parcelable.ClassLoaderCreator<ViewPager.SavedState> {
    ViewPager.SavedState.1() {
    }

    public ViewPager.SavedState createFromParcel(Parcel parcel) {
        return new ViewPager.SavedState(parcel, null);
    }

    public ViewPager.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new ViewPager.SavedState(parcel, classLoader);
    }

    public ViewPager.SavedState[] newArray(int n) {
        return new ViewPager.SavedState[n];
    }
}
