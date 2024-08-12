/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.drawerlayout.widget.DrawerLayout$SavedState
 */
package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout;

static final class DrawerLayout.SavedState.1
implements Parcelable.ClassLoaderCreator<DrawerLayout.SavedState> {
    DrawerLayout.SavedState.1() {
    }

    public DrawerLayout.SavedState createFromParcel(Parcel parcel) {
        return new DrawerLayout.SavedState(parcel, null);
    }

    public DrawerLayout.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new DrawerLayout.SavedState(parcel, classLoader);
    }

    public DrawerLayout.SavedState[] newArray(int n) {
        return new DrawerLayout.SavedState[n];
    }
}
