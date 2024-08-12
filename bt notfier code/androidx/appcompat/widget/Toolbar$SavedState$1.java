/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.appcompat.widget.Toolbar$SavedState
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;

class Toolbar.SavedState.1
implements Parcelable.ClassLoaderCreator<Toolbar.SavedState> {
    Toolbar.SavedState.1() {
    }

    public Toolbar.SavedState createFromParcel(Parcel parcel) {
        return new Toolbar.SavedState(parcel, null);
    }

    public Toolbar.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new Toolbar.SavedState(parcel, classLoader);
    }

    public Toolbar.SavedState[] newArray(int n) {
        return new Toolbar.SavedState[n];
    }
}
