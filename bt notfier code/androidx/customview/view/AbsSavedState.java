/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbsSavedState
implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR;
    public static final AbsSavedState EMPTY_STATE;
    private final Parcelable mSuperState;

    static {
        EMPTY_STATE = new /* Unavailable Anonymous Inner Class!! */;
        CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(Parcel parcel) {
        this(parcel, null);
    }

    protected AbsSavedState(Parcel object, ClassLoader classLoader) {
        object = object.readParcelable(classLoader);
        if (object == null) {
            object = EMPTY_STATE;
        }
        this.mSuperState = object;
    }

    protected AbsSavedState(Parcelable parcelable) {
        if (parcelable == null) throw new IllegalArgumentException("superState must not be null");
        if (parcelable == EMPTY_STATE) {
            parcelable = null;
        }
        this.mSuperState = parcelable;
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeParcelable(this.mSuperState, n);
    }
}
