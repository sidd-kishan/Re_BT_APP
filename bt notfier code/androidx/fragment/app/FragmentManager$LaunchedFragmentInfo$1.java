/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.fragment.app.FragmentManager$LaunchedFragmentInfo
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;

class FragmentManager.LaunchedFragmentInfo.1
implements Parcelable.Creator<FragmentManager.LaunchedFragmentInfo> {
    FragmentManager.LaunchedFragmentInfo.1() {
    }

    public FragmentManager.LaunchedFragmentInfo createFromParcel(Parcel parcel) {
        return new FragmentManager.LaunchedFragmentInfo(parcel);
    }

    public FragmentManager.LaunchedFragmentInfo[] newArray(int n) {
        return new FragmentManager.LaunchedFragmentInfo[n];
    }
}
