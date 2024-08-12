/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListView
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$ItemInvoker
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.widget.TintTypedArray
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;

public final class ExpandedMenuView
extends ListView
implements MenuBuilder.ItemInvoker,
MenuView,
AdapterView.OnItemClickListener {
    private static final int[] TINT_ATTRS = new int[]{16842964, 16843049};
    private int mAnimations;
    private MenuBuilder mMenu;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet);
        this.setOnItemClickListener(this);
        context = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])TINT_ATTRS, (int)n, (int)0);
        if (context.hasValue(0)) {
            this.setBackgroundDrawable(context.getDrawable(0));
        }
        if (context.hasValue(1)) {
            this.setDivider(context.getDrawable(1));
        }
        context.recycle();
    }

    public int getWindowAnimations() {
        return this.mAnimations;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction((MenuItem)menuItemImpl, 0);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int n, long l) {
        this.invokeItem((MenuItemImpl)this.getAdapter().getItem(n));
    }
}
