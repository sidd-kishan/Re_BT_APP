/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

class StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
implements Parcelable.Creator<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1() {
    }

    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(Parcel parcel) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(parcel);
    }

    public StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int n) {
        return new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[n];
    }
}
