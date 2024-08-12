/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

static class StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    int mGapDir;
    int[] mGapPerSpan;
    boolean mHasUnwantedGapAfter;
    int mPosition;

    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem() {
    }

    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(Parcel parcel) {
        this.mPosition = parcel.readInt();
        this.mGapDir = parcel.readInt();
        int n = parcel.readInt();
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        this.mHasUnwantedGapAfter = bl;
        n = parcel.readInt();
        if (n <= 0) return;
        int[] nArray = new int[n];
        this.mGapPerSpan = nArray;
        parcel.readIntArray(nArray);
    }

    public int describeContents() {
        return 0;
    }

    int getGapForSpan(int n) {
        int[] nArray = this.mGapPerSpan;
        n = nArray == null ? 0 : nArray[n];
        return n;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FullSpanItem{mPosition=");
        stringBuilder.append(this.mPosition);
        stringBuilder.append(", mGapDir=");
        stringBuilder.append(this.mGapDir);
        stringBuilder.append(", mHasUnwantedGapAfter=");
        stringBuilder.append(this.mHasUnwantedGapAfter);
        stringBuilder.append(", mGapPerSpan=");
        stringBuilder.append(Arrays.toString(this.mGapPerSpan));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.mPosition);
        parcel.writeInt(this.mGapDir);
        parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
        int[] nArray = this.mGapPerSpan;
        if (nArray != null && nArray.length > 0) {
            parcel.writeInt(nArray.length);
            parcel.writeIntArray(this.mGapPerSpan);
        } else {
            parcel.writeInt(0);
        }
    }
}
