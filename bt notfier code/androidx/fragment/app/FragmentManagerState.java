/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.fragment.app.BackStackState
 *  androidx.fragment.app.FragmentManager$LaunchedFragmentInfo
 *  androidx.fragment.app.FragmentState
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentState;
import java.util.ArrayList;

final class FragmentManagerState
implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    ArrayList<FragmentState> mActive;
    ArrayList<String> mAdded;
    BackStackState[] mBackStack;
    int mBackStackIndex;
    ArrayList<FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    String mPrimaryNavActiveWho = null;
    ArrayList<String> mResultKeys = new ArrayList();
    ArrayList<Bundle> mResults = new ArrayList();

    public FragmentManagerState() {
    }

    public FragmentManagerState(Parcel parcel) {
        this.mActive = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.mAdded = parcel.createStringArrayList();
        this.mBackStack = (BackStackState[])parcel.createTypedArray(BackStackState.CREATOR);
        this.mBackStackIndex = parcel.readInt();
        this.mPrimaryNavActiveWho = parcel.readString();
        this.mResultKeys = parcel.createStringArrayList();
        this.mResults = parcel.createTypedArrayList(Bundle.CREATOR);
        this.mLaunchedFragments = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeTypedList(this.mActive);
        parcel.writeStringList(this.mAdded);
        parcel.writeTypedArray((Parcelable[])this.mBackStack, n);
        parcel.writeInt(this.mBackStackIndex);
        parcel.writeString(this.mPrimaryNavActiveWho);
        parcel.writeStringList(this.mResultKeys);
        parcel.writeTypedList(this.mResults);
        parcel.writeTypedList(this.mLaunchedFragments);
    }
}
