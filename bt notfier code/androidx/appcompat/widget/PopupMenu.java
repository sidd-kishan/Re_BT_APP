/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPopupHelper
 *  androidx.appcompat.widget.PopupMenu$OnDismissListener
 *  androidx.appcompat.widget.PopupMenu$OnMenuItemClickListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.PopupMenu;

public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int n) {
        this(context, view, n, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int n, int n2, int n3) {
        MenuBuilder menuBuilder;
        this.mContext = context;
        this.mAnchor = view;
        this.mMenu = menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback((MenuBuilder.Callback)new /* Unavailable Anonymous Inner Class!! */);
        context = new MenuPopupHelper(context, this.mMenu, view, false, n2, n3);
        this.mPopup = context;
        context.setGravity(n);
        this.mPopup.setOnDismissListener((PopupWindow.OnDismissListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener != null) return this.mDragListener;
        this.mDragListener = new /* Unavailable Anonymous Inner Class!! */;
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    ListView getMenuListView() {
        if (this.mPopup.isShowing()) return this.mPopup.getListView();
        return null;
    }

    public void inflate(int n) {
        this.getMenuInflater().inflate(n, (Menu)this.mMenu);
    }

    public void setGravity(int n) {
        this.mPopup.setGravity(n);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }
}
