/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.widget.QMUIWrapContentScrollView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$MenuBaseDialogBuilder$ItemViewFactory
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView$MenuItemViewListener
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.QMUIWrapContentScrollView;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView;
import java.util.ArrayList;
import java.util.Iterator;

public static class QMUIDialog.MenuBaseDialogBuilder<T extends QMUIDialogBuilder>
extends QMUIDialogBuilder<T> {
    protected QMUIWrapContentScrollView mContentScrollView;
    protected LinearLayout mMenuItemContainer;
    protected LinearLayout.LayoutParams mMenuItemLp;
    protected ArrayList<QMUIDialogMenuItemView> mMenuItemViews = new ArrayList();
    protected ArrayList<ItemViewFactory> mMenuItemViewsFactoryList = new ArrayList();

    public QMUIDialog.MenuBaseDialogBuilder(Context context) {
        super(context);
    }

    public T addItem(ItemViewFactory itemViewFactory, DialogInterface.OnClickListener onClickListener) {
        this.mMenuItemViewsFactoryList.add((ItemViewFactory)new /* Unavailable Anonymous Inner Class!! */);
        return (T)((Object)this);
    }

    @Deprecated
    public T addItem(QMUIDialogMenuItemView qMUIDialogMenuItemView, DialogInterface.OnClickListener onClickListener) {
        qMUIDialogMenuItemView.setMenuIndex(this.mMenuItemViewsFactoryList.size());
        qMUIDialogMenuItemView.setListener((QMUIDialogMenuItemView.MenuItemViewListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mMenuItemViewsFactoryList.add((ItemViewFactory)new /* Unavailable Anonymous Inner Class!! */);
        return (T)((Object)this);
    }

    public void clear() {
        this.mMenuItemViewsFactoryList.clear();
    }

    protected void onCreateContent(QMUIDialog qMUIDialog, ViewGroup viewGroup, Context context) {
        qMUIDialog = new LinearLayout(context);
        this.mMenuItemContainer = qMUIDialog;
        qMUIDialog.setOrientation(1);
        qMUIDialog = new LinearLayout.LayoutParams(-1, -2);
        this.mMenuItemContainer.setLayoutParams((ViewGroup.LayoutParams)qMUIDialog);
        qMUIDialog = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuContainerStyleDef, R.attr.qmui_dialog_menu_container_style, 0);
        int n = qMUIDialog.getIndexCount();
        int n2 = -1;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        for (int i = 0; i < n; ++i) {
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            int n13;
            int n14 = qMUIDialog.getIndex(i);
            if (n14 == R.styleable.QMUIDialogMenuContainerStyleDef_android_paddingTop) {
                n13 = qMUIDialog.getDimensionPixelSize(n14, n4);
                n12 = n2;
                n11 = n3;
                n10 = n5;
                n9 = n6;
                n8 = n7;
            } else if (n14 == R.styleable.QMUIDialogMenuContainerStyleDef_android_paddingBottom) {
                n9 = qMUIDialog.getDimensionPixelSize(n14, n6);
                n12 = n2;
                n11 = n3;
                n13 = n4;
                n10 = n5;
                n8 = n7;
            } else if (n14 == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_single_padding_vertical) {
                n11 = qMUIDialog.getDimensionPixelSize(n14, n3);
                n12 = n2;
                n13 = n4;
                n10 = n5;
                n9 = n6;
                n8 = n7;
            } else if (n14 == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_padding_top_when_title_exist) {
                n10 = qMUIDialog.getDimensionPixelSize(n14, n5);
                n12 = n2;
                n11 = n3;
                n13 = n4;
                n9 = n6;
                n8 = n7;
            } else if (n14 == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_container_padding_bottom_when_action_exist) {
                n8 = qMUIDialog.getDimensionPixelSize(n14, n7);
                n12 = n2;
                n11 = n3;
                n13 = n4;
                n10 = n5;
                n9 = n6;
            } else {
                n12 = n2;
                n11 = n3;
                n13 = n4;
                n10 = n5;
                n9 = n6;
                n8 = n7;
                if (n14 == R.styleable.QMUIDialogMenuContainerStyleDef_qmui_dialog_menu_item_height) {
                    n12 = qMUIDialog.getDimensionPixelSize(n14, n2);
                    n8 = n7;
                    n9 = n6;
                    n10 = n5;
                    n13 = n4;
                    n11 = n3;
                }
            }
            n2 = n12;
            n3 = n11;
            n4 = n13;
            n5 = n10;
            n6 = n9;
            n7 = n8;
        }
        qMUIDialog.recycle();
        qMUIDialog = new LinearLayout.LayoutParams(-1, n2);
        this.mMenuItemLp = qMUIDialog;
        qMUIDialog.gravity = 16;
        if (this.mMenuItemViewsFactoryList.size() == 1) {
            n6 = n3;
        } else {
            n3 = n4;
        }
        if (!this.hasTitle()) {
            n5 = n3;
        }
        if (this.mActions.size() <= 0) {
            n7 = n6;
        }
        this.mMenuItemContainer.setPadding(0, n5, 0, n7);
        this.mMenuItemViews.clear();
        Iterator<ItemViewFactory> iterator = this.mMenuItemViewsFactoryList.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                qMUIDialog = new QMUIWrapContentScrollView(context);
                this.mContentScrollView = qMUIDialog;
                qMUIDialog.setMaxHeight(this.getContentAreaMaxHeight());
                this.mContentScrollView.addView((View)this.mMenuItemContainer);
                this.mContentScrollView.setVerticalScrollBarEnabled(false);
                viewGroup.addView((View)this.mContentScrollView);
                return;
            }
            qMUIDialog = iterator.next().createItemView(context);
            this.mMenuItemContainer.addView((View)qMUIDialog, (ViewGroup.LayoutParams)this.mMenuItemLp);
            this.mMenuItemViews.add((QMUIDialogMenuItemView)qMUIDialog);
        }
    }

    protected void onItemClick(int n) {
    }
}
