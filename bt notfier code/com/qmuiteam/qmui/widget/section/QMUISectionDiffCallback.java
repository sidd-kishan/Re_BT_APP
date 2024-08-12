/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 *  androidx.recyclerview.widget.DiffUtil$Callback
 *  com.qmuiteam.qmui.widget.section.QMUISection
 *  com.qmuiteam.qmui.widget.section.QMUISection$Model
 *  com.qmuiteam.qmui.widget.section.QMUISectionDiffCallback$IndexGenerationInfo
 */
package com.qmuiteam.qmui.widget.section;

import android.util.SparseIntArray;
import androidx.recyclerview.widget.DiffUtil;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUISectionDiffCallback;
import java.util.ArrayList;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
public class QMUISectionDiffCallback<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>>
extends DiffUtil.Callback {
    private SparseIntArray mNewItemIndex;
    private ArrayList<QMUISection<H, T>> mNewList;
    private SparseIntArray mNewSectionIndex;
    private SparseIntArray mOldItemIndex;
    private ArrayList<QMUISection<H, T>> mOldList = new ArrayList();
    private SparseIntArray mOldSectionIndex;

    public QMUISectionDiffCallback(List<QMUISection<H, T>> list, List<QMUISection<H, T>> list2) {
        this.mNewList = new ArrayList();
        this.mOldSectionIndex = new SparseIntArray();
        this.mOldItemIndex = new SparseIntArray();
        this.mNewSectionIndex = new SparseIntArray();
        this.mNewItemIndex = new SparseIntArray();
        if (list != null) {
            this.mOldList.addAll(list);
        }
        if (list2 != null) {
            this.mNewList.addAll(list2);
        }
        this.generateIndex(this.mOldList, this.mOldSectionIndex, this.mOldItemIndex);
        this.generateIndex(this.mNewList, this.mNewSectionIndex, this.mNewItemIndex);
    }

    private void generateIndex(List<QMUISection<H, T>> list, SparseIntArray sparseIntArray, SparseIntArray qMUISection) {
        sparseIntArray.clear();
        qMUISection.clear();
        sparseIntArray = new IndexGenerationInfo(sparseIntArray, (SparseIntArray)qMUISection, null);
        if (list.isEmpty() || !list.get(0).isLocked()) {
            this.onGenerateCustomIndexBeforeSectionList((IndexGenerationInfo)sparseIntArray, list);
        }
        for (int i = 0; i < list.size(); ++i) {
            qMUISection = list.get(i);
            if (qMUISection.isLocked()) continue;
            IndexGenerationInfo.access$100((IndexGenerationInfo)sparseIntArray, (int)i, (int)-2);
            if (qMUISection.isFold() || qMUISection.getItemCount() == 0) continue;
            this.onGenerateCustomIndexBeforeItemList((IndexGenerationInfo)sparseIntArray, qMUISection, i);
            if (qMUISection.isExistBeforeDataToLoad()) {
                IndexGenerationInfo.access$100((IndexGenerationInfo)sparseIntArray, (int)i, (int)-3);
            }
            for (int j = 0; j < qMUISection.getItemCount(); ++j) {
                IndexGenerationInfo.access$100((IndexGenerationInfo)sparseIntArray, (int)i, (int)j);
            }
            if (qMUISection.isExistAfterDataToLoad()) {
                IndexGenerationInfo.access$100((IndexGenerationInfo)sparseIntArray, (int)i, (int)-4);
            }
            this.onGenerateCustomIndexAfterItemList((IndexGenerationInfo)sparseIntArray, qMUISection, i);
        }
        if (list.isEmpty()) {
            this.onGenerateCustomIndexAfterSectionList((IndexGenerationInfo)sparseIntArray, list);
        } else {
            qMUISection = list.get(list.size() - 1);
            if (qMUISection.isLocked()) return;
            if (!qMUISection.isFold()) {
                if (qMUISection.isExistAfterDataToLoad()) return;
            }
            this.onGenerateCustomIndexAfterSectionList((IndexGenerationInfo)sparseIntArray, list);
        }
    }

    public boolean areContentsTheSame(int n, int n2) {
        int n3 = this.mOldSectionIndex.get(n);
        int n4 = this.mOldItemIndex.get(n);
        n = this.mNewSectionIndex.get(n2);
        n2 = this.mNewItemIndex.get(n2);
        if (n < 0) {
            return this.areCustomContentsTheSame(null, n4, null, n2);
        }
        QMUISection.Model model = this.mOldList.get(n3);
        QMUISection.Model model2 = this.mNewList.get(n);
        boolean bl = true;
        boolean bl2 = true;
        if (n4 == -2) {
            if (model.isFold() == model2.isFold() && model.getHeader().isSameContent((Object)model2.getHeader())) return bl2;
            bl2 = false;
            return bl2;
        }
        if (n4 == -3) return false;
        if (n4 == -4) {
            return false;
        }
        if (QMUISection.isCustomItemIndex((int)n4)) {
            return this.areCustomContentsTheSame((QMUISection<H, T>)model, n4, (QMUISection<H, T>)model2, n2);
        }
        model = model.getItemAt(n4);
        model2 = model2.getItemAt(n2);
        if (model == null) {
            bl2 = bl;
            if (model2 == null) return bl2;
        }
        bl2 = model != null && model2 != null && model.isSameContent((Object)model2) ? bl : false;
        return bl2;
    }

    protected boolean areCustomContentsTheSame(QMUISection<H, T> qMUISection, int n, QMUISection<H, T> qMUISection2, int n2) {
        return false;
    }

    public boolean areItemsTheSame(int n, int n2) {
        int n3 = this.mOldSectionIndex.get(n);
        int n4 = this.mOldItemIndex.get(n);
        n = this.mNewSectionIndex.get(n2);
        n2 = this.mNewItemIndex.get(n2);
        boolean bl = true;
        boolean bl2 = true;
        if (n3 >= 0 && n >= 0) {
            QMUISection.Model model = this.mOldList.get(n3);
            QMUISection.Model model2 = this.mNewList.get(n);
            if (!model.getHeader().isSameItem((Object)model2.getHeader())) {
                return false;
            }
            if (n4 < 0 && n4 == n2) {
                return true;
            }
            if (n4 < 0) return false;
            if (n2 < 0) {
                return false;
            }
            model = model.getItemAt(n4);
            model2 = model2.getItemAt(n2);
            if (model == null) {
                bl = bl2;
                if (model2 == null) return bl;
            }
            bl = model != null && model2 != null && model.isSameItem((Object)model2) ? bl2 : false;
            return bl;
        }
        if (n3 == n && n4 == n2) return bl;
        bl = false;
        return bl;
    }

    public void cloneNewIndexTo(SparseIntArray sparseIntArray, SparseIntArray sparseIntArray2) {
        sparseIntArray.clear();
        sparseIntArray2.clear();
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3 = n;
            if (n2 >= this.mNewSectionIndex.size()) {
                while (n3 < this.mNewItemIndex.size()) {
                    sparseIntArray2.append(this.mNewItemIndex.keyAt(n3), this.mNewItemIndex.valueAt(n3));
                    ++n3;
                }
                return;
            }
            sparseIntArray.append(this.mNewSectionIndex.keyAt(n2), this.mNewSectionIndex.valueAt(n2));
            ++n2;
        }
    }

    public int getNewListSize() {
        return this.mNewSectionIndex.size();
    }

    public int getOldListSize() {
        return this.mOldSectionIndex.size();
    }

    protected void onGenerateCustomIndexAfterItemList(IndexGenerationInfo indexGenerationInfo, QMUISection<H, T> qMUISection, int n) {
    }

    protected void onGenerateCustomIndexAfterSectionList(IndexGenerationInfo indexGenerationInfo, List<QMUISection<H, T>> list) {
    }

    protected void onGenerateCustomIndexBeforeItemList(IndexGenerationInfo indexGenerationInfo, QMUISection<H, T> qMUISection, int n) {
    }

    protected void onGenerateCustomIndexBeforeSectionList(IndexGenerationInfo indexGenerationInfo, List<QMUISection<H, T>> list) {
    }
}
