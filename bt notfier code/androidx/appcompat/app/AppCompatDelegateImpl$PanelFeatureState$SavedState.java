/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.appcompat.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

private static class AppCompatDelegateImpl.PanelFeatureState.SavedState
implements Parcelable {
    public static final Parcelable.Creator<AppCompatDelegateImpl.PanelFeatureState.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    int featureId;
    boolean isOpen;
    Bundle menuState;

    AppCompatDelegateImpl.PanelFeatureState.SavedState() {
    }

    static AppCompatDelegateImpl.PanelFeatureState.SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
        AppCompatDelegateImpl.PanelFeatureState.SavedState savedState = new AppCompatDelegateImpl.PanelFeatureState.SavedState();
        savedState.featureId = parcel.readInt();
        int n = parcel.readInt();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        savedState.isOpen = bl;
        if (!bl) return savedState;
        savedState.menuState = parcel.readBundle(classLoader);
        return savedState;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.featureId);
        parcel.writeInt(this.isOpen ? 1 : 0);
        if (!this.isOpen) return;
        parcel.writeBundle(this.menuState);
    }
}
