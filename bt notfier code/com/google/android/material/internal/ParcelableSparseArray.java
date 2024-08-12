/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 */
package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

public class ParcelableSparseArray
extends SparseArray<Parcelable>
implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = new /* Unavailable Anonymous Inner Class!! */;

    public ParcelableSparseArray() {
    }

    public ParcelableSparseArray(Parcel parcelableArray, ClassLoader classLoader) {
        int n = parcelableArray.readInt();
        int[] nArray = new int[n];
        parcelableArray.readIntArray(nArray);
        parcelableArray = parcelableArray.readParcelableArray(classLoader);
        int n2 = 0;
        while (n2 < n) {
            this.put(nArray[n2], parcelableArray[n2]);
            ++n2;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        int n2 = this.size();
        int[] nArray = new int[n2];
        Parcelable[] parcelableArray = new Parcelable[n2];
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                parcel.writeInt(n2);
                parcel.writeIntArray(nArray);
                parcel.writeParcelableArray(parcelableArray, n);
                return;
            }
            nArray[n3] = this.keyAt(n3);
            parcelableArray[n3] = (Parcelable)this.valueAt(n3);
            ++n3;
        }
    }
}
