/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.transition.Transition
 *  android.util.Log
 *  android.view.MenuItem
 *  android.widget.PopupWindow
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.widget.DropDownListView
 *  androidx.appcompat.widget.ListPopupWindow
 *  androidx.appcompat.widget.MenuItemHoverListener
 *  androidx.appcompat.widget.MenuPopupWindow$MenuDropDownListView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import java.lang.reflect.Method;

public class MenuPopupWindow
extends ListPopupWindow
implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    static {
        try {
            if (Build.VERSION.SDK_INT > 28) return;
            sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.i((String)TAG, (String)"Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
    }

    DropDownListView createDropDownListView(Context context, boolean bl) {
        context = new MenuDropDownListView(context, bl);
        context.setHoverListener((MenuItemHoverListener)this);
        return context;
    }

    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener == null) return;
        menuItemHoverListener.onItemHoverEnter(menuBuilder, menuItem);
    }

    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener == null) return;
        menuItemHoverListener.onItemHoverExit(menuBuilder, menuItem);
    }

    public void setEnterTransition(Object object) {
        if (Build.VERSION.SDK_INT < 23) return;
        this.mPopup.setEnterTransition((Transition)object);
    }

    public void setExitTransition(Object object) {
        if (Build.VERSION.SDK_INT < 23) return;
        this.mPopup.setExitTransition((Transition)object);
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }

    public void setTouchModal(boolean bl) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = sSetTouchModalMethod;
            if (method == null) return;
            try {
                method.invoke(this.mPopup, bl);
            }
            catch (Exception exception) {
                Log.i((String)TAG, (String)"Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        } else {
            this.mPopup.setTouchModal(bl);
        }
    }
}
