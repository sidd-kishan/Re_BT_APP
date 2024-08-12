/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.section.QMUISection$Model
 */
package com.qmuiteam.qmui.widget.section;

import com.qmuiteam.qmui.widget.section.QMUISection;
import java.util.ArrayList;
import java.util.List;

public class QMUISection<H extends Model<H>, T extends Model<T>> {
    public static final int ITEM_INDEX_CUSTOM_OFFSET = -1000;
    public static final int ITEM_INDEX_INTERNAL_END = -4;
    public static final int ITEM_INDEX_LOAD_AFTER = -4;
    public static final int ITEM_INDEX_LOAD_BEFORE = -3;
    public static final int ITEM_INDEX_SECTION_HEADER = -2;
    public static final int ITEM_INDEX_UNKNOWN = -1;
    public static final int SECTION_INDEX_UNKNOWN = -1;
    private boolean mExistAfterDataToLoad;
    private boolean mExistBeforeDataToLoad;
    private H mHeader;
    private boolean mIsErrorToLoadAfter = false;
    private boolean mIsErrorToLoadBefore = false;
    private boolean mIsFold;
    private boolean mIsLocked;
    private ArrayList<T> mItemList;

    public QMUISection(H h, List<T> list) {
        this(h, list, false);
    }

    public QMUISection(H h, List<T> list, boolean bl) {
        this(h, list, bl, false, false, false);
    }

    public QMUISection(H object, List<T> list, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.mHeader = object;
        object = new ArrayList();
        this.mItemList = object;
        if (list != null) {
            ((ArrayList)object).addAll(list);
        }
        this.mIsFold = bl;
        this.mIsLocked = bl2;
        this.mExistBeforeDataToLoad = bl3;
        this.mExistAfterDataToLoad = bl4;
    }

    public static final boolean isCustomItemIndex(int n) {
        boolean bl = n < -4;
        return bl;
    }

    public QMUISection<H, T> cloneForDiff() {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.mItemList.iterator();
        while (true) {
            if (!object.hasNext()) {
                object = new QMUISection((Model)this.mHeader.cloneForDiff(), arrayList, this.mIsFold, this.mIsLocked, this.mExistBeforeDataToLoad, this.mExistAfterDataToLoad);
                ((QMUISection)object).mIsErrorToLoadBefore = this.mIsErrorToLoadBefore;
                ((QMUISection)object).mIsErrorToLoadAfter = this.mIsErrorToLoadAfter;
                return object;
            }
            arrayList.add(((Model)object.next()).cloneForDiff());
        }
    }

    public void cloneStatusTo(QMUISection<H, T> qMUISection) {
        qMUISection.mExistBeforeDataToLoad = this.mExistBeforeDataToLoad;
        qMUISection.mExistAfterDataToLoad = this.mExistAfterDataToLoad;
        qMUISection.mIsFold = this.mIsFold;
        qMUISection.mIsLocked = this.mIsLocked;
        qMUISection.mIsErrorToLoadBefore = this.mIsErrorToLoadBefore;
        qMUISection.mIsErrorToLoadAfter = this.mIsErrorToLoadAfter;
    }

    public boolean existItem(T t) {
        return this.mItemList.contains(t);
    }

    public void finishLoadMore(List<T> list, boolean bl, boolean bl2) {
        if (bl) {
            if (list != null) {
                this.mItemList.addAll(0, list);
            }
            this.mExistBeforeDataToLoad = bl2;
        } else {
            if (list != null) {
                this.mItemList.addAll(list);
            }
            this.mExistAfterDataToLoad = bl2;
        }
    }

    public H getHeader() {
        return this.mHeader;
    }

    public T getItemAt(int n) {
        if (n < 0) return null;
        if (n < this.mItemList.size()) return (T)((Model)this.mItemList.get(n));
        return null;
    }

    public int getItemCount() {
        return this.mItemList.size();
    }

    public boolean isErrorToLoadAfter() {
        return this.mIsErrorToLoadAfter;
    }

    public boolean isErrorToLoadBefore() {
        return this.mIsErrorToLoadBefore;
    }

    public boolean isExistAfterDataToLoad() {
        return this.mExistAfterDataToLoad;
    }

    public boolean isExistBeforeDataToLoad() {
        return this.mExistBeforeDataToLoad;
    }

    public boolean isFold() {
        return this.mIsFold;
    }

    public boolean isLocked() {
        return this.mIsLocked;
    }

    public QMUISection<H, T> mutate() {
        QMUISection<H, T> qMUISection = new QMUISection<H, T>(this.mHeader, this.mItemList, this.mIsFold, this.mIsLocked, this.mExistBeforeDataToLoad, this.mExistAfterDataToLoad);
        qMUISection.mIsErrorToLoadBefore = this.mIsErrorToLoadBefore;
        qMUISection.mIsErrorToLoadAfter = this.mIsErrorToLoadAfter;
        return qMUISection;
    }

    public void setErrorToLoadAfter(boolean bl) {
        this.mIsErrorToLoadAfter = bl;
    }

    public void setErrorToLoadBefore(boolean bl) {
        this.mIsErrorToLoadBefore = bl;
    }

    public void setExistAfterDataToLoad(boolean bl) {
        this.mExistAfterDataToLoad = bl;
    }

    public void setExistBeforeDataToLoad(boolean bl) {
        this.mExistBeforeDataToLoad = bl;
    }

    public void setFold(boolean bl) {
        this.mIsFold = bl;
    }

    public void setLocked(boolean bl) {
        this.mIsLocked = bl;
    }
}
