/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager$Span
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

class StaggeredGridLayoutManager.AnchorInfo {
    boolean mInvalidateOffsets;
    boolean mLayoutFromEnd;
    int mOffset;
    int mPosition;
    int[] mSpanReferenceLines;
    boolean mValid;
    final StaggeredGridLayoutManager this$0;

    StaggeredGridLayoutManager.AnchorInfo(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.this$0 = staggeredGridLayoutManager;
        this.reset();
    }

    void assignCoordinateFromPadding() {
        int n = this.mLayoutFromEnd ? this.this$0.mPrimaryOrientation.getEndAfterPadding() : this.this$0.mPrimaryOrientation.getStartAfterPadding();
        this.mOffset = n;
    }

    void assignCoordinateFromPadding(int n) {
        this.mOffset = this.mLayoutFromEnd ? this.this$0.mPrimaryOrientation.getEndAfterPadding() - n : this.this$0.mPrimaryOrientation.getStartAfterPadding() + n;
    }

    void reset() {
        this.mPosition = -1;
        this.mOffset = Integer.MIN_VALUE;
        this.mLayoutFromEnd = false;
        this.mInvalidateOffsets = false;
        this.mValid = false;
        int[] nArray = this.mSpanReferenceLines;
        if (nArray == null) return;
        Arrays.fill(nArray, -1);
    }

    void saveSpanReferenceLines(StaggeredGridLayoutManager.Span[] spanArray) {
        int n = spanArray.length;
        int[] nArray = this.mSpanReferenceLines;
        if (nArray == null || nArray.length < n) {
            this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
        }
        int n2 = 0;
        while (n2 < n) {
            this.mSpanReferenceLines[n2] = spanArray[n2].getStartLine(Integer.MIN_VALUE);
            ++n2;
        }
    }
}
