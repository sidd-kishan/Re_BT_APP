/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState
 */
package androidx.appcompat.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl;

/*
 * Exception performing whole class analysis ignored.
 */
class AppCompatDelegateImpl.PanelFeatureState.SavedState.1
implements Parcelable.ClassLoaderCreator<AppCompatDelegateImpl.PanelFeatureState.SavedState> {
    AppCompatDelegateImpl.PanelFeatureState.SavedState.1() {
    }

    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel parcel) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel((Parcel)parcel, null);
    }

    public AppCompatDelegateImpl.PanelFeatureState.SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return AppCompatDelegateImpl.PanelFeatureState.SavedState.readFromParcel((Parcel)parcel, (ClassLoader)classLoader);
    }

    public AppCompatDelegateImpl.PanelFeatureState.SavedState[] newArray(int n) {
        return new AppCompatDelegateImpl.PanelFeatureState.SavedState[n];
    }
}
