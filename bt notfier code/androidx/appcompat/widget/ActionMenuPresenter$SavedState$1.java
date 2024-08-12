/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.appcompat.widget.ActionMenuPresenter$SavedState
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.ActionMenuPresenter;

class ActionMenuPresenter.SavedState.1
implements Parcelable.Creator<ActionMenuPresenter.SavedState> {
    ActionMenuPresenter.SavedState.1() {
    }

    public ActionMenuPresenter.SavedState createFromParcel(Parcel parcel) {
        return new ActionMenuPresenter.SavedState(parcel);
    }

    public ActionMenuPresenter.SavedState[] newArray(int n) {
        return new ActionMenuPresenter.SavedState[n];
    }
}
