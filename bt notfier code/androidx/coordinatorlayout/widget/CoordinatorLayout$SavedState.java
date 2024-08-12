/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 *  androidx.customview.view.AbsSavedState
 */
package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.customview.view.AbsSavedState;

protected static class CoordinatorLayout.SavedState
extends AbsSavedState {
    public static final Parcelable.Creator<CoordinatorLayout.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    SparseArray<Parcelable> behaviorStates;

    public CoordinatorLayout.SavedState(Parcel parcelableArray, ClassLoader classLoader) {
        super((Parcel)parcelableArray, classLoader);
        int n = parcelableArray.readInt();
        int[] nArray = new int[n];
        parcelableArray.readIntArray(nArray);
        parcelableArray = parcelableArray.readParcelableArray(classLoader);
        this.behaviorStates = new SparseArray(n);
        int n2 = 0;
        while (n2 < n) {
            this.behaviorStates.append(nArray[n2], (Object)parcelableArray[n2]);
            ++n2;
        }
    }

    public CoordinatorLayout.SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        Parcelable[] parcelableArray = this.behaviorStates;
        int n2 = 0;
        int n3 = parcelableArray != null ? parcelableArray.size() : 0;
        parcel.writeInt(n3);
        int[] nArray = new int[n3];
        parcelableArray = new Parcelable[n3];
        while (true) {
            if (n2 >= n3) {
                parcel.writeIntArray(nArray);
                parcel.writeParcelableArray(parcelableArray, n);
                return;
            }
            nArray[n2] = this.behaviorStates.keyAt(n2);
            parcelableArray[n2] = (Parcelable)this.behaviorStates.valueAt(n2);
            ++n2;
        }
    }
}
