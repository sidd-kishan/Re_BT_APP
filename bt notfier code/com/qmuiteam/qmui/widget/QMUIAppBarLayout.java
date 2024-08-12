/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.appbar.AppBarLayout
 *  com.qmuiteam.qmui.util.QMUIWindowInsetHelper
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 *  com.qmuiteam.qmui.widget.QMUIAppBarLayout$1
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.qmuiteam.qmui.util.QMUIWindowInsetHelper;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;
import com.qmuiteam.qmui.widget.QMUIAppBarLayout;
import java.lang.reflect.Field;

public class QMUIAppBarLayout
extends AppBarLayout
implements IWindowInsetLayout {
    public QMUIAppBarLayout(Context context) {
        super(context);
    }

    public QMUIAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean applySystemWindowInsets19(Rect rect) {
        Field field;
        boolean bl = ViewCompat.getFitsSystemWindows((View)this);
        int n = 0;
        if (!bl) return false;
        try {
            field = AppBarLayout.class.getDeclaredField("lastInsets");
        }
        catch (NoSuchFieldException noSuchFieldException) {
            try {
                field = AppBarLayout.class.getDeclaredField("mLastInsets");
            }
            catch (NoSuchFieldException noSuchFieldException2) {
                field = null;
            }
        }
        int n2 = n;
        if (field != null) {
            field.setAccessible(true);
            try {
                1 var6_9 = new /* Unavailable Anonymous Inner Class!! */;
                field.set((Object)this, var6_9);
                n2 = n;
            }
            catch (IllegalAccessException illegalAccessException) {
                n2 = n;
            }
        }
        while (n2 < this.getChildCount()) {
            field = this.getChildAt(n2);
            if (!QMUIWindowInsetHelper.jumpDispatch((View)field)) {
                if (!QMUIWindowInsetHelper.isHandleContainer((View)field)) {
                    field.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                } else if (field instanceof IWindowInsetLayout) {
                    ((IWindowInsetLayout)field).applySystemWindowInsets19(rect);
                }
            }
            ++n2;
        }
        return true;
    }

    public boolean applySystemWindowInsets21(Object object) {
        return true;
    }
}
