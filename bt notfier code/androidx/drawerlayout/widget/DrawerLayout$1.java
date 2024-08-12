/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.WindowInsets
 *  androidx.drawerlayout.widget.DrawerLayout
 */
package androidx.drawerlayout.widget;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

class DrawerLayout.1
implements View.OnApplyWindowInsetsListener {
    final DrawerLayout this$0;

    DrawerLayout.1(DrawerLayout drawerLayout) {
        this.this$0 = drawerLayout;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        view = (DrawerLayout)view;
        boolean bl = windowInsets.getSystemWindowInsetTop() > 0;
        view.setChildInsets((Object)windowInsets, bl);
        return windowInsets.consumeSystemWindowInsets();
    }
}
