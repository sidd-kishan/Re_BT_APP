/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable$Creator
 *  androidx.core.os.ParcelableCompat$ParcelableCompatCreatorHoneycombMR2
 *  androidx.core.os.ParcelableCompatCreatorCallbacks
 */
package androidx.core.os;

import android.os.Parcelable;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;

@Deprecated
public final class ParcelableCompat {
    private ParcelableCompat() {
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> parcelableCompatCreatorCallbacks) {
        return new ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
    }
}
