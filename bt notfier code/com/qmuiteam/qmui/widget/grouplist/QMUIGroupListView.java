/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.SparseArray
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIResHelper
 *  com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView
 *  com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView$Section
 */
package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;

public class QMUIGroupListView
extends LinearLayout {
    public static final int SEPARATOR_STYLE_NONE = 1;
    public static final int SEPARATOR_STYLE_NORMAL = 0;
    private SparseArray<Section> mSections;
    private int mSeparatorStyle;

    public QMUIGroupListView(Context context) {
        this(context, null, R.attr.QMUIGroupListViewStyle);
    }

    public QMUIGroupListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIGroupListViewStyle);
    }

    public QMUIGroupListView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIGroupListView, n, 0);
        this.mSeparatorStyle = context.getInt(R.styleable.QMUIGroupListView_separatorStyle, 0);
        context.recycle();
        this.mSections = new SparseArray();
        this.setOrientation(1);
    }

    static /* synthetic */ void access$200(QMUIGroupListView qMUIGroupListView, Section section) {
        qMUIGroupListView.addSection(section);
    }

    static /* synthetic */ void access$300(QMUIGroupListView qMUIGroupListView, Section section) {
        qMUIGroupListView.removeSection(section);
    }

    private void addSection(Section section) {
        SparseArray<Section> sparseArray = this.mSections;
        sparseArray.append(sparseArray.size(), (Object)section);
    }

    public static Section newSection(Context context) {
        return new Section(context);
    }

    private void removeSection(Section section) {
        int n = 0;
        while (n < this.mSections.size()) {
            if ((Section)this.mSections.valueAt(n) == section) {
                this.mSections.remove(n);
            }
            ++n;
        }
    }

    public QMUICommonListItemView createItemView(int n) {
        return this.createItemView(null, null, null, n, 0);
    }

    public QMUICommonListItemView createItemView(Drawable drawable, CharSequence charSequence, String string, int n, int n2) {
        if (n != 0) return this.createItemView(drawable, charSequence, string, n, n2, QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_list_item_height));
        return this.createItemView(drawable, charSequence, string, n, n2, QMUIResHelper.getAttrDimen((Context)this.getContext(), (int)R.attr.qmui_list_item_height_higher));
    }

    public QMUICommonListItemView createItemView(Drawable drawable, CharSequence charSequence, String string, int n, int n2, int n3) {
        QMUICommonListItemView qMUICommonListItemView = new QMUICommonListItemView(this.getContext());
        qMUICommonListItemView.setOrientation(n);
        qMUICommonListItemView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, n3));
        qMUICommonListItemView.setImageDrawable(drawable);
        qMUICommonListItemView.setText(charSequence);
        qMUICommonListItemView.setDetailText((CharSequence)string);
        qMUICommonListItemView.setAccessoryType(n2);
        return qMUICommonListItemView;
    }

    public QMUICommonListItemView createItemView(CharSequence charSequence) {
        return this.createItemView(null, charSequence, null, 1, 0);
    }

    public Section getSection(int n) {
        return (Section)this.mSections.get(n);
    }

    public int getSectionCount() {
        return this.mSections.size();
    }

    public int getSeparatorStyle() {
        return this.mSeparatorStyle;
    }

    public void setSeparatorStyle(int n) {
        this.mSeparatorStyle = n;
    }
}
