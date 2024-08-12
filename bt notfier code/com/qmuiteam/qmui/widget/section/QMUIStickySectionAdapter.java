/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewGroup
 *  androidx.recyclerview.widget.DiffUtil
 *  androidx.recyclerview.widget.DiffUtil$DiffResult
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  com.qmuiteam.qmui.widget.section.QMUISection
 *  com.qmuiteam.qmui.widget.section.QMUISection$Model
 *  com.qmuiteam.qmui.widget.section.QMUISectionDiffCallback
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$Callback
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$PositionFinder
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewCallback
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 */
package com.qmuiteam.qmui.widget.section;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUISectionDiffCallback;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class QMUIStickySectionAdapter<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>, VH extends ViewHolder>
extends RecyclerView.Adapter<VH> {
    public static final int ITEM_TYPE_CUSTOM_OFFSET = 1000;
    public static final int ITEM_TYPE_SECTION_HEADER = 0;
    public static final int ITEM_TYPE_SECTION_ITEM = 1;
    public static final int ITEM_TYPE_SECTION_LOADING = 2;
    public static final int ITEM_TYPE_UNKNOWN = -1;
    private static final String TAG = "StickySectionAdapter";
    private List<QMUISection<H, T>> mBackupData = new ArrayList<QMUISection<H, T>>();
    private Callback<H, T> mCallback;
    private List<QMUISection<H, T>> mCurrentData = new ArrayList<QMUISection<H, T>>();
    private SparseIntArray mItemIndex;
    private ArrayList<QMUISection<H, T>> mLoadingAfterSections;
    private ArrayList<QMUISection<H, T>> mLoadingBeforeSections;
    private SparseIntArray mSectionIndex = new SparseIntArray();
    private ViewCallback mViewCallback;

    public QMUIStickySectionAdapter() {
        this.mItemIndex = new SparseIntArray();
        this.mLoadingBeforeSections = new ArrayList(2);
        this.mLoadingAfterSections = new ArrayList(2);
    }

    static /* synthetic */ Callback access$000(QMUIStickySectionAdapter qMUIStickySectionAdapter) {
        return qMUIStickySectionAdapter.mCallback;
    }

    private void diff(boolean bl, boolean bl2) {
        Object object = this.createDiffCallback(this.mBackupData, this.mCurrentData);
        int n = 0;
        QMUISection qMUISection = DiffUtil.calculateDiff(object, (boolean)false);
        object.cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        qMUISection.dispatchUpdatesTo((RecyclerView.Adapter)this);
        if (!bl && this.mBackupData.size() == this.mCurrentData.size()) {
            while (n < this.mCurrentData.size()) {
                this.mCurrentData.get(n).cloneStatusTo(this.mBackupData.get(n));
                ++n;
            }
            return;
        }
        this.mBackupData.clear();
        Iterator<QMUISection<H, T>> iterator = this.mCurrentData.iterator();
        while (iterator.hasNext()) {
            qMUISection = iterator.next();
            object = this.mBackupData;
            qMUISection = bl2 ? qMUISection.mutate() : qMUISection.cloneForDiff();
            object.add(qMUISection);
        }
    }

    private void lock(QMUISection<H, T> qMUISection) {
        boolean bl = !qMUISection.isFold() && qMUISection.isExistBeforeDataToLoad() && !qMUISection.isErrorToLoadBefore();
        boolean bl2 = !qMUISection.isFold() && qMUISection.isExistAfterDataToLoad() && !qMUISection.isErrorToLoadAfter();
        int n = this.mCurrentData.indexOf(qMUISection);
        if (n < 0) return;
        if (n >= this.mCurrentData.size()) return;
        qMUISection.setLocked(false);
        this.lockBefore(n - 1, bl);
        this.lockAfter(n + 1, bl2);
    }

    private void lockAfter(int n, boolean bl) {
        while (n < this.mCurrentData.size()) {
            QMUISection<H, T> qMUISection = this.mCurrentData.get(n);
            boolean bl2 = true;
            if (bl) {
                qMUISection.setLocked(true);
            } else {
                qMUISection.setLocked(false);
                bl = !qMUISection.isFold() && qMUISection.isExistAfterDataToLoad() && !qMUISection.isErrorToLoadAfter() ? bl2 : false;
            }
            ++n;
        }
    }

    private void lockBefore(int n, boolean bl) {
        while (n >= 0) {
            QMUISection<H, T> qMUISection = this.mCurrentData.get(n);
            boolean bl2 = true;
            if (bl) {
                qMUISection.setLocked(true);
            } else {
                qMUISection.setLocked(false);
                bl = !qMUISection.isFold() && qMUISection.isExistBeforeDataToLoad() && !qMUISection.isErrorToLoadBefore() ? bl2 : false;
            }
            --n;
        }
    }

    private void safeScrollToSection(QMUISection<H, T> qMUISection, boolean bl) {
        int n = 0;
        while (n < this.mSectionIndex.size()) {
            int n2 = this.mSectionIndex.keyAt(n);
            int n3 = this.mSectionIndex.valueAt(n);
            if (n3 >= 0 && n3 < this.mCurrentData.size() && this.mItemIndex.get(n2) == -2 && this.mCurrentData.get(n3).getHeader().isSameItem((Object)qMUISection.getHeader())) {
                this.mViewCallback.scrollToPosition(n2, true, bl);
                return;
            }
            ++n;
        }
    }

    private void safeScrollToSectionItem(QMUISection<H, T> qMUISection, T t, boolean bl) {
        int n = 0;
        while (n < this.mItemIndex.size()) {
            QMUISection<H, T> qMUISection2;
            int n2 = this.mItemIndex.keyAt(n);
            int n3 = this.mItemIndex.valueAt(n);
            if (n3 >= 0 && (qMUISection2 = this.getSection(n2)) == qMUISection && qMUISection2.getItemAt(n3).isSameItem(t)) {
                this.mViewCallback.scrollToPosition(n2, false, bl);
                return;
            }
            ++n;
        }
    }

    protected void beforeDiffInSet(List<QMUISection<H, T>> list, List<QMUISection<H, T>> list2) {
    }

    protected QMUISectionDiffCallback<H, T> createDiffCallback(List<QMUISection<H, T>> list, List<QMUISection<H, T>> list2) {
        return new QMUISectionDiffCallback(list, list2);
    }

    public int findCustomPosition(int n, int n2, boolean bl) {
        return this.findPosition(n, n2 - 1000, bl);
    }

    public int findPosition(int n, int n2, boolean bl) {
        int n3;
        int n4 = n3 = 0;
        if (bl) {
            n4 = n3;
            if (n >= 0) {
                QMUISection<H, T> qMUISection = this.mCurrentData.get(n);
                n4 = n3;
                if (qMUISection != null) {
                    n4 = n3;
                    if (qMUISection.isFold()) {
                        qMUISection.setFold(false);
                        this.lock(qMUISection);
                        this.diff(false, true);
                        n4 = n3;
                    }
                }
            }
        }
        while (n4 < this.getItemCount()) {
            if (this.mSectionIndex.get(n4) == n && this.mItemIndex.get(n4) == n2) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     */
    public int findPosition(PositionFinder<H, T> var1_1, boolean var2_2) {
        var8_3 = null;
        var6_4 = null;
        var5_5 = 0;
        var3_6 = 0;
        if (!var2_2) {
            while (var3_6 < this.getItemCount()) {
                var6_4 = this.getSection(var3_6);
                if (var6_4 != null && ((var4_7 = this.getItemIndex(var3_6)) == -2 ? var1_1.find(var6_4, null) != false : var4_7 >= 0 && var1_1.find(var6_4, var6_4.getItemAt(var4_7)) != false)) {
                    return var3_6;
                }
                ++var3_6;
            }
            return -1;
        }
        var3_6 = 0;
        block1: while (true) {
            block11: {
                block12: {
                    block10: {
                        if (var3_6 >= this.mCurrentData.size()) break block10;
                        var7_9 = this.mCurrentData.get(var3_6);
                        if (!var1_1.find(var7_9, null)) break block11;
                        var1_1 = var6_4;
                        break block12;
                    }
                    var6_4 = null;
                    var3_6 = var5_5;
                    var1_1 = var8_3;
                    break;
                }
lbl26:
                // 3 sources

                while (true) {
                    var6_4 = var1_1;
                    var1_1 = var7_9;
                    var3_6 = var5_5;
                    break block1;
                    break;
                }
            }
            for (var4_8 = 0; var4_8 < var7_9.getItemCount(); ++var4_8) {
                if (!var1_1.find(var7_9, var7_9.getItemAt(var4_8))) continue;
                var1_1 = var6_4 = var7_9.getItemAt(var4_8);
                if (!var7_9.isFold()) ** GOTO lbl26
                var7_9.setFold(false);
                this.lock(var7_9);
                this.diff(false, true);
                var1_1 = var6_4;
                ** continue;
            }
            ++var3_6;
        }
        while (var3_6 < this.getItemCount()) {
            var7_9 = this.getSection(var3_6);
            if (var7_9 == var1_1) {
                var4_8 = this.getItemIndex(var3_6);
                if (var4_8 == -2 && var6_4 == null) {
                    return var3_6;
                }
                if (var4_8 >= 0 && var7_9.getItemAt(var4_8).isSameItem((Object)var6_4)) {
                    return var3_6;
                }
            }
            ++var3_6;
        }
        return -1;
    }

    public void finishLoadMore(QMUISection<H, T> qMUISection, List<T> list, boolean bl, boolean bl2) {
        if (bl) {
            this.mLoadingBeforeSections.remove(qMUISection);
        } else {
            this.mLoadingAfterSections.remove(qMUISection);
        }
        if (this.mCurrentData.indexOf(qMUISection) < 0) {
            return;
        }
        if (bl && !qMUISection.isFold()) {
            for (int i = 0; i < this.mItemIndex.size(); ++i) {
                int n = this.mItemIndex.keyAt(i);
                if (this.mItemIndex.valueAt(i) != 0 || qMUISection != this.getSection(n)) continue;
                Object object = this.mViewCallback;
                object = object == null ? null : object.findViewHolderForAdapterPosition(n);
                if (object == null) break;
                this.mViewCallback.requestChildFocus(object.itemView);
                break;
            }
        }
        qMUISection.finishLoadMore(list, bl, bl2);
        this.lock(qMUISection);
        this.diff(true, true);
    }

    protected int getCustomItemViewType(int n, int n2) {
        return -1;
    }

    public final int getItemCount() {
        return this.mItemIndex.size();
    }

    public int getItemIndex(int n) {
        if (n < 0) return -1;
        if (n < this.mItemIndex.size()) return this.mItemIndex.get(n);
        return -1;
    }

    public final int getItemViewType(int n) {
        int n2 = this.getItemIndex(n);
        if (n2 == -1) {
            Log.e((String)TAG, (String)"the item index is undefined, you may need to check your data if not called by QMUIStickySectionItemDecoration.");
            return -1;
        }
        if (n2 == -2) {
            return 0;
        }
        if (n2 == -3) return 2;
        if (n2 == -4) {
            return 2;
        }
        if (n2 < 0) return this.getCustomItemViewType(n2 + 1000, n) + 1000;
        return 1;
    }

    public int getRelativeStickyPosition(int n) {
        int n2;
        do {
            n2 = n;
            if (this.getItemViewType(n) == 0) return n2;
            n = n2 = n - 1;
        } while (n2 >= 0);
        n2 = -1;
        return n2;
    }

    public QMUISection<H, T> getSection(int n) {
        if (n < 0) return null;
        if (n >= this.mSectionIndex.size()) return null;
        if ((n = this.mSectionIndex.get(n)) < 0) return null;
        if (n < this.mCurrentData.size()) return this.mCurrentData.get(n);
        return null;
    }

    public QMUISection<H, T> getSectionDirectly(int n) {
        if (n < 0) return null;
        if (n < this.mCurrentData.size()) return this.mCurrentData.get(n);
        return null;
    }

    public int getSectionIndex(int n) {
        if (n < 0) return -1;
        if (n < this.mSectionIndex.size()) return this.mSectionIndex.get(n);
        return -1;
    }

    public T getSectionItem(int n) {
        int n2 = this.getItemIndex(n);
        if (n2 < 0) {
            return null;
        }
        QMUISection<H, T> qMUISection = this.getSection(n);
        if (qMUISection != null) return (T)qMUISection.getItemAt(n2);
        return null;
    }

    public boolean isSectionFold(int n) {
        QMUISection<H, T> qMUISection = this.getSection(n);
        if (qMUISection != null) return qMUISection.isFold();
        return false;
    }

    protected void onBindCustomItem(VH VH, int n, QMUISection<H, T> qMUISection, int n2) {
    }

    protected void onBindSectionHeader(VH VH, int n, QMUISection<H, T> qMUISection) {
    }

    protected void onBindSectionItem(VH VH, int n, QMUISection<H, T> qMUISection, int n2) {
    }

    protected void onBindSectionLoadingItem(VH VH, int n, QMUISection<H, T> qMUISection, boolean bl) {
    }

    public final void onBindViewHolder(VH VH, int n) {
        QMUISection<H, T> qMUISection = this.getSection(n);
        int n2 = this.getItemIndex(n);
        if (n2 == -2) {
            this.onBindSectionHeader(VH, n, qMUISection);
        } else if (n2 >= 0) {
            this.onBindSectionItem(VH, n, qMUISection, n2);
        } else if (n2 != -3 && n2 != -4) {
            this.onBindCustomItem(VH, n, qMUISection, n2 + 1000);
        } else {
            boolean bl = n2 == -3;
            this.onBindSectionLoadingItem(VH, n, qMUISection, bl);
        }
        if (n2 == -4) {
            ((ViewHolder)VH).isLoadBefore = false;
        } else if (n2 == -3) {
            ((ViewHolder)VH).isLoadBefore = true;
        }
        ((ViewHolder)VH).itemView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        ((ViewHolder)VH).itemView.setOnLongClickListener((View.OnLongClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    protected abstract VH onCreateCustomItemViewHolder(ViewGroup var1, int var2);

    protected abstract VH onCreateSectionHeaderViewHolder(ViewGroup var1);

    protected abstract VH onCreateSectionItemViewHolder(ViewGroup var1);

    protected abstract VH onCreateSectionLoadingViewHolder(ViewGroup var1);

    public final VH onCreateViewHolder(ViewGroup viewGroup, int n) {
        if (n == 0) {
            return this.onCreateSectionHeaderViewHolder(viewGroup);
        }
        if (n == 1) {
            return this.onCreateSectionItemViewHolder(viewGroup);
        }
        if (n != 2) return this.onCreateCustomItemViewHolder(viewGroup, n - 1000);
        return this.onCreateSectionLoadingViewHolder(viewGroup);
    }

    public void onViewAttachedToWindow(VH VH) {
        if (VH.getItemViewType() != 2) return;
        if (this.mCallback == null) return;
        if (((ViewHolder)VH).isLoadError) return;
        QMUISection<H, T> qMUISection = this.getSection(VH.getAdapterPosition());
        if (qMUISection == null) return;
        if (((ViewHolder)VH).isLoadBefore) {
            if (this.mLoadingBeforeSections.contains(qMUISection)) {
                return;
            }
            this.mLoadingBeforeSections.add(qMUISection);
            this.mCallback.loadMore(qMUISection, true);
        } else {
            if (this.mLoadingAfterSections.contains(qMUISection)) {
                return;
            }
            this.mLoadingAfterSections.add(qMUISection);
            this.mCallback.loadMore(qMUISection, false);
        }
    }

    public void refreshCustomData() {
        QMUISectionDiffCallback<H, T> qMUISectionDiffCallback = this.createDiffCallback(this.mBackupData, this.mCurrentData);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(qMUISectionDiffCallback, (boolean)false);
        qMUISectionDiffCallback.cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        diffResult.dispatchUpdatesTo((RecyclerView.Adapter)this);
    }

    /*
     * Enabled force condition propagation
     */
    public void scrollToSectionHeader(QMUISection<H, T> qMUISection, boolean bl) {
        QMUISection<H, T> qMUISection2;
        block4: {
            if (this.mViewCallback == null) {
                return;
            }
            int n = 0;
            while (n < this.mCurrentData.size()) {
                qMUISection2 = this.mCurrentData.get(n);
                if (qMUISection.getHeader().isSameItem((Object)qMUISection2.getHeader())) {
                    if (qMUISection2.isLocked()) {
                        this.lock(qMUISection2);
                        this.diff(false, true);
                        this.safeScrollToSection(qMUISection2, bl);
                        return;
                    }
                    break block4;
                }
                ++n;
            }
            return;
        }
        this.safeScrollToSection(qMUISection2, bl);
    }

    public void scrollToSectionItem(QMUISection<H, T> qMUISection, T t, boolean bl) {
        if (this.mViewCallback == null) {
            return;
        }
        int n = 0;
        while (n < this.mCurrentData.size()) {
            QMUISection<H, T> qMUISection2 = this.mCurrentData.get(n);
            if (qMUISection == null && qMUISection2.existItem(t) || qMUISection == qMUISection2) {
                if (!qMUISection2.isFold() && !qMUISection2.isLocked()) {
                    this.safeScrollToSectionItem(qMUISection2, t, bl);
                } else {
                    qMUISection2.setFold(false);
                    this.lock(qMUISection2);
                    this.diff(false, true);
                    this.safeScrollToSectionItem(qMUISection2, t, bl);
                }
                return;
            }
            ++n;
        }
    }

    public void setCallback(Callback<H, T> callback) {
        this.mCallback = callback;
    }

    public final void setData(List<QMUISection<H, T>> list) {
        this.setData(list, true);
    }

    public final void setData(List<QMUISection<H, T>> list, boolean bl) {
        this.setData(list, bl, true);
    }

    public final void setData(List<QMUISection<H, T>> list, boolean bl, boolean bl2) {
        this.mLoadingBeforeSections.clear();
        this.mLoadingAfterSections.clear();
        this.mCurrentData.clear();
        if (list != null) {
            this.mCurrentData.addAll(list);
        }
        this.beforeDiffInSet(this.mBackupData, this.mCurrentData);
        if (!this.mCurrentData.isEmpty() && bl2) {
            this.lock(this.mCurrentData.get(0));
        }
        this.diff(true, bl);
    }

    public final void setDataWithoutDiff(List<QMUISection<H, T>> list, boolean bl) {
        this.setDataWithoutDiff(list, bl, true);
    }

    public final void setDataWithoutDiff(List<QMUISection<H, T>> qMUISection, boolean bl, boolean bl2) {
        this.mLoadingBeforeSections.clear();
        this.mLoadingAfterSections.clear();
        this.mCurrentData.clear();
        if (qMUISection != null) {
            this.mCurrentData.addAll((Collection<QMUISection<H, T>>)qMUISection);
        }
        if (bl2 && !this.mCurrentData.isEmpty()) {
            this.lock(this.mCurrentData.get(0));
        }
        this.createDiffCallback(this.mBackupData, this.mCurrentData).cloneNewIndexTo(this.mSectionIndex, this.mItemIndex);
        this.notifyDataSetChanged();
        this.mBackupData.clear();
        Iterator<QMUISection<H, T>> iterator = this.mCurrentData.iterator();
        while (iterator.hasNext()) {
            qMUISection = iterator.next();
            List<QMUISection<H, T>> list = this.mBackupData;
            qMUISection = bl ? qMUISection.mutate() : qMUISection.cloneForDiff();
            list.add(qMUISection);
        }
    }

    void setViewCallback(ViewCallback viewCallback) {
        this.mViewCallback = viewCallback;
    }

    public void toggleFold(int n, boolean bl) {
        QMUISection<H, T> qMUISection = this.getSection(n);
        if (qMUISection == null) {
            return;
        }
        qMUISection.setFold(qMUISection.isFold() ^ true);
        this.lock(qMUISection);
        n = 0;
        this.diff(false, true);
        if (!bl) return;
        if (qMUISection.isFold()) return;
        if (this.mViewCallback == null) return;
        while (n < this.mSectionIndex.size()) {
            int n2 = this.mSectionIndex.keyAt(n);
            if (this.getItemIndex(n2) == -2 && this.getSection(n2) == qMUISection) {
                this.mViewCallback.scrollToPosition(n2, true, true);
                return;
            }
            ++n;
        }
    }
}
