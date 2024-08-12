/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  com.qmuiteam.qmui.R$drawable
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView
 *  com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView$LayoutParamConfig
 *  com.qmuiteam.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView
 *  com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView
 *  com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView$Section$2
 */
package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListSectionHeaderFooterView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

/*
 * Exception performing whole class analysis ignored.
 */
public static class QMUIGroupListView.Section {
    private Context mContext;
    private QMUIGroupListSectionHeaderFooterView mDescriptionView;
    private SparseArray<QMUICommonListItemView> mItemViews;
    private int mLeftIconHeight = -2;
    private int mLeftIconWidth = -2;
    private int mSeparatorDrawableForBottom = 0;
    private int mSeparatorDrawableForMiddle = 0;
    private int mSeparatorDrawableForSingle = 0;
    private int mSeparatorDrawableForTop = 0;
    private QMUIGroupListSectionHeaderFooterView mTitleView;
    private boolean mUseDefaultTitleIfNone;
    private boolean mUseTitleViewForSectionSpace = true;

    public QMUIGroupListView.Section(Context context) {
        this.mContext = context;
        this.mItemViews = new SparseArray();
    }

    static /* synthetic */ int access$000(QMUIGroupListView.Section section) {
        return section.mLeftIconWidth;
    }

    static /* synthetic */ int access$100(QMUIGroupListView.Section section) {
        return section.mLeftIconHeight;
    }

    public QMUIGroupListView.Section addItemView(QMUICommonListItemView qMUICommonListItemView, View.OnClickListener onClickListener) {
        return this.addItemView(qMUICommonListItemView, onClickListener, null);
    }

    public QMUIGroupListView.Section addItemView(QMUICommonListItemView qMUICommonListItemView, View.OnClickListener sparseArray, View.OnLongClickListener onLongClickListener) {
        if (qMUICommonListItemView.getAccessoryType() == 2) {
            qMUICommonListItemView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        } else if (sparseArray != null) {
            qMUICommonListItemView.setOnClickListener((View.OnClickListener)sparseArray);
        }
        if (onLongClickListener != null) {
            qMUICommonListItemView.setOnLongClickListener(onLongClickListener);
        }
        sparseArray = this.mItemViews;
        sparseArray.append(sparseArray.size(), (Object)qMUICommonListItemView);
        return this;
    }

    public void addTo(QMUIGroupListView qMUIGroupListView) {
        Object object;
        if (this.mTitleView == null) {
            if (this.mUseDefaultTitleIfNone) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Section ");
                ((StringBuilder)object).append(qMUIGroupListView.getSectionCount());
                this.setTitle(((StringBuilder)object).toString());
            } else if (this.mUseTitleViewForSectionSpace) {
                this.setTitle("");
            }
        }
        if ((object = this.mTitleView) != null) {
            qMUIGroupListView.addView((View)object);
        }
        if (qMUIGroupListView.getSeparatorStyle() == 0) {
            if (this.mSeparatorDrawableForSingle == 0) {
                this.mSeparatorDrawableForSingle = R.drawable.qmui_s_list_item_bg_with_border_double;
            }
            if (this.mSeparatorDrawableForTop == 0) {
                this.mSeparatorDrawableForTop = R.drawable.qmui_s_list_item_bg_with_border_double;
            }
            if (this.mSeparatorDrawableForBottom == 0) {
                this.mSeparatorDrawableForBottom = R.drawable.qmui_s_list_item_bg_with_border_bottom;
            }
            if (this.mSeparatorDrawableForMiddle == 0) {
                this.mSeparatorDrawableForMiddle = R.drawable.qmui_s_list_item_bg_with_border_bottom;
            }
        }
        int n = this.mItemViews.size();
        2 var6_4 = new /* Unavailable Anonymous Inner Class!! */;
        for (int i = 0; i < n; ++i) {
            object = (QMUICommonListItemView)this.mItemViews.get(i);
            int n2 = qMUIGroupListView.getSeparatorStyle() == 0 ? (n == 1 ? this.mSeparatorDrawableForSingle : (i == 0 ? this.mSeparatorDrawableForTop : (i == n - 1 ? this.mSeparatorDrawableForBottom : this.mSeparatorDrawableForMiddle))) : R.drawable.qmui_s_list_item_bg_with_border_none;
            object.updateImageViewLp((QMUICommonListItemView.LayoutParamConfig)var6_4);
            QMUIViewHelper.setBackgroundKeepingPadding((View)object, (int)n2);
            qMUIGroupListView.addView((View)object);
        }
        object = this.mDescriptionView;
        if (object != null) {
            qMUIGroupListView.addView((View)object);
        }
        QMUIGroupListView.access$200((QMUIGroupListView)qMUIGroupListView, (QMUIGroupListView.Section)this);
    }

    public QMUIGroupListSectionHeaderFooterView createSectionFooter(CharSequence charSequence) {
        return new QMUIGroupListSectionHeaderFooterView(this.mContext, charSequence, true);
    }

    public QMUIGroupListSectionHeaderFooterView createSectionHeader(CharSequence charSequence) {
        return new QMUIGroupListSectionHeaderFooterView(this.mContext, charSequence);
    }

    public void removeFrom(QMUIGroupListView qMUIGroupListView) {
        QMUIGroupListSectionHeaderFooterView qMUIGroupListSectionHeaderFooterView = this.mTitleView;
        if (qMUIGroupListSectionHeaderFooterView != null && qMUIGroupListSectionHeaderFooterView.getParent() == qMUIGroupListView) {
            qMUIGroupListView.removeView((View)this.mTitleView);
        }
        for (int i = 0; i < this.mItemViews.size(); ++i) {
            qMUIGroupListView.removeView((View)((QMUICommonListItemView)this.mItemViews.get(i)));
        }
        qMUIGroupListSectionHeaderFooterView = this.mDescriptionView;
        if (qMUIGroupListSectionHeaderFooterView != null && qMUIGroupListSectionHeaderFooterView.getParent() == qMUIGroupListView) {
            qMUIGroupListView.removeView((View)this.mDescriptionView);
        }
        QMUIGroupListView.access$300((QMUIGroupListView)qMUIGroupListView, (QMUIGroupListView.Section)this);
    }

    public QMUIGroupListView.Section setDescription(CharSequence charSequence) {
        this.mDescriptionView = this.createSectionFooter(charSequence);
        return this;
    }

    public QMUIGroupListView.Section setLeftIconSize(int n, int n2) {
        this.mLeftIconHeight = n2;
        this.mLeftIconWidth = n;
        return this;
    }

    public QMUIGroupListView.Section setSeparatorDrawableRes(int n) {
        this.mSeparatorDrawableForMiddle = n;
        return this;
    }

    public QMUIGroupListView.Section setSeparatorDrawableRes(int n, int n2, int n3, int n4) {
        this.mSeparatorDrawableForSingle = n;
        this.mSeparatorDrawableForTop = n2;
        this.mSeparatorDrawableForBottom = n3;
        this.mSeparatorDrawableForMiddle = n4;
        return this;
    }

    public QMUIGroupListView.Section setTitle(CharSequence charSequence) {
        this.mTitleView = this.createSectionHeader(charSequence);
        return this;
    }

    public QMUIGroupListView.Section setUseDefaultTitleIfNone(boolean bl) {
        this.mUseDefaultTitleIfNone = bl;
        return this;
    }

    public QMUIGroupListView.Section setUseTitleViewForSectionSpace(boolean bl) {
        this.mUseTitleViewForSectionSpace = bl;
        return this;
    }
}
