/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 *  androidx.core.os.ParcelableCompatCreatorCallbacks
 */
package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.ParcelableCompatCreatorCallbacks;

static class ParcelableCompat.ParcelableCompatCreatorHoneycombMR2<T>
implements Parcelable.ClassLoaderCreator<T> {
    private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

    ParcelableCompat.ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        this.mCallbacks = parcelableCompatCreatorCallbacks;
    }

    public T createFromParcel(Parcel parcel) {
        return (T)this.mCallbacks.createFromParcel(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return (T)this.mCallbacks.createFromParcel(parcel, classLoader);
    }

    public T[] newArray(int n) {
        return this.mCallbacks.newArray(n);
    }
}
