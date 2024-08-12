/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.collection.SimpleArrayMap
 *  androidx.customview.view.AbsSavedState
 */
package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState
extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    public final SimpleArrayMap<String, Bundle> extendableStates;

    private ExtendableSavedState(Parcel parcel, ClassLoader stringArray) {
        super(parcel, (ClassLoader)stringArray);
        int n = parcel.readInt();
        stringArray = new String[n];
        parcel.readStringArray(stringArray);
        Object[] objectArray = new Bundle[n];
        parcel.readTypedArray(objectArray, Bundle.CREATOR);
        this.extendableStates = new SimpleArrayMap(n);
        int n2 = 0;
        while (n2 < n) {
            this.extendableStates.put((Object)stringArray[n2], objectArray[n2]);
            ++n2;
        }
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.extendableStates = new SimpleArrayMap();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtendableSavedState{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode((Object)this)));
        stringBuilder.append(" states=");
        stringBuilder.append(this.extendableStates);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        super.writeToParcel(parcel, n);
        int n2 = this.extendableStates.size();
        parcel.writeInt(n2);
        String[] stringArray = new String[n2];
        Bundle[] bundleArray = new Bundle[n2];
        n = 0;
        while (true) {
            if (n >= n2) {
                parcel.writeStringArray(stringArray);
                parcel.writeTypedArray((Parcelable[])bundleArray, 0);
                return;
            }
            stringArray[n] = (String)this.extendableStates.keyAt(n);
            bundleArray[n] = (Bundle)this.extendableStates.valueAt(n);
            ++n;
        }
    }
}
