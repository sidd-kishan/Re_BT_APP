/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  com.qmuiteam.qmui.widget.section.QMUISection
 */
package com.qmuiteam.qmui.widget.section;

import android.util.SparseIntArray;
import com.qmuiteam.qmui.widget.section.QMUISection;

public static class QMUISectionDiffCallback.IndexGenerationInfo {
    private int currentPosition;
    private SparseIntArray itemIndexArray;
    private SparseIntArray sectionIndexArray;

    private QMUISectionDiffCallback.IndexGenerationInfo(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        this.sectionIndexArray = sparseIntArray;
        this.itemIndexArray = sparseIntArray2;
        this.currentPosition = 0;
    }

    static /* synthetic */ void access$100(QMUISectionDiffCallback.IndexGenerationInfo indexGenerationInfo, int n, int n2) {
        indexGenerationInfo.appendIndex(n, n2);
    }

    private final void appendIndex(int n, int n2) {
        if (n < 0) throw new IllegalArgumentException("use appendWholeListCustomIndex for whole list");
        this.sectionIndexArray.append(this.currentPosition, n);
        this.itemIndexArray.append(this.currentPosition, n2);
        ++this.currentPosition;
    }

    private final void appendWholeListIndex(int n) {
        this.sectionIndexArray.append(this.currentPosition, -1);
        this.itemIndexArray.append(this.currentPosition, n);
        ++this.currentPosition;
    }

    public final void appendCustomIndex(int n, int n2) {
        if (!QMUISection.isCustomItemIndex((int)(n2 -= 1000))) throw new IllegalArgumentException("Index conflicts with index used internally, please use negative number for custom item");
        this.appendIndex(n, n2);
    }

    public final void appendWholeListCustomIndex(int n) {
        if (!QMUISection.isCustomItemIndex((int)(n -= 1000))) throw new IllegalArgumentException("Index conflicts with index used internally, please use negative number for custom item");
        this.appendWholeListIndex(n);
    }
}
