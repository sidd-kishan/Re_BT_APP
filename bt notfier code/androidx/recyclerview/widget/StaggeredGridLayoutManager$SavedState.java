/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

public static class StaggeredGridLayoutManager.SavedState
implements Parcelable {
    public static final Parcelable.Creator<StaggeredGridLayoutManager.SavedState> CREATOR = new /* Unavailable Anonymous Inner Class!! */;
    boolean mAnchorLayoutFromEnd;
    int mAnchorPosition;
    List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
    boolean mLastLayoutRTL;
    boolean mReverseLayout;
    int[] mSpanLookup;
    int mSpanLookupSize;
    int[] mSpanOffsets;
    int mSpanOffsetsSize;
    int mVisibleAnchorPosition;

    public StaggeredGridLayoutManager.SavedState() {
    }

    StaggeredGridLayoutManager.SavedState(Parcel parcel) {
        int[] nArray;
        int n;
        this.mAnchorPosition = parcel.readInt();
        this.mVisibleAnchorPosition = parcel.readInt();
        this.mSpanOffsetsSize = n = parcel.readInt();
        if (n > 0) {
            nArray = new int[n];
            this.mSpanOffsets = nArray;
            parcel.readIntArray(nArray);
        }
        this.mSpanLookupSize = n = parcel.readInt();
        if (n > 0) {
            nArray = new int[n];
            this.mSpanLookup = nArray;
            parcel.readIntArray(nArray);
        }
        n = parcel.readInt();
        boolean bl = false;
        boolean bl2 = n == 1;
        this.mReverseLayout = bl2;
        bl2 = parcel.readInt() == 1;
        this.mAnchorLayoutFromEnd = bl2;
        bl2 = bl;
        if (parcel.readInt() == 1) {
            bl2 = true;
        }
        this.mLastLayoutRTL = bl2;
        this.mFullSpanItems = parcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
    }

    public StaggeredGridLayoutManager.SavedState(StaggeredGridLayoutManager.SavedState savedState) {
        this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
        this.mAnchorPosition = savedState.mAnchorPosition;
        this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
        this.mSpanOffsets = savedState.mSpanOffsets;
        this.mSpanLookupSize = savedState.mSpanLookupSize;
        this.mSpanLookup = savedState.mSpanLookup;
        this.mReverseLayout = savedState.mReverseLayout;
        this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        this.mLastLayoutRTL = savedState.mLastLayoutRTL;
        this.mFullSpanItems = savedState.mFullSpanItems;
    }

    public int describeContents() {
        return 0;
    }

    void invalidateAnchorPositionInfo() {
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mAnchorPosition = -1;
        this.mVisibleAnchorPosition = -1;
    }

    void invalidateSpanInfo() {
        this.mSpanOffsets = null;
        this.mSpanOffsetsSize = 0;
        this.mSpanLookupSize = 0;
        this.mSpanLookup = null;
        this.mFullSpanItems = null;
    }

    public void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.mAnchorPosition);
        parcel.writeInt(this.mVisibleAnchorPosition);
        parcel.writeInt(this.mSpanOffsetsSize);
        if (this.mSpanOffsetsSize > 0) {
            parcel.writeIntArray(this.mSpanOffsets);
        }
        parcel.writeInt(this.mSpanLookupSize);
        if (this.mSpanLookupSize > 0) {
            parcel.writeIntArray(this.mSpanLookup);
        }
        parcel.writeInt(this.mReverseLayout ? 1 : 0);
        parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
        parcel.writeList(this.mFullSpanItems);
    }
}
