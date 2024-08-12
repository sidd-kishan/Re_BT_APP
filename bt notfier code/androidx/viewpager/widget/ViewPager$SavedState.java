/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.customview.view.AbsSavedState
 */
package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

public static class ViewPager.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<ViewPager.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    Parcelable adapterState;
    ClassLoader loader;
    int position;

    ViewPager.SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        ClassLoader classLoader2 = classLoader;
        if (classLoader == null) {
            classLoader2 = ((Object)((Object)this)).getClass().getClassLoader();
        }
        this.position = parcel.readInt();
        this.adapterState = parcel.readParcelable(classLoader2);
        this.loader = classLoader2;
    }

    public ViewPager.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FragmentPager.SavedState{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append(" position=");
        stringBuilder.append(this.position);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        parcel.writeInt(this.position);
        parcel.writeParcelable(this.adapterState, n);
    }
}
