/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.app.ActionBarDrawerToggle
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;

class ActionBarDrawerToggle.1
implements View.OnClickListener {
    final ActionBarDrawerToggle this$0;

    ActionBarDrawerToggle.1(ActionBarDrawerToggle actionBarDrawerToggle) {
        this.this$0 = actionBarDrawerToggle;
    }

    public void onClick(View view) {
        if (this.this$0.mDrawerIndicatorEnabled) {
            this.this$0.toggle();
        } else {
            if (this.this$0.mToolbarNavigationClickListener == null) return;
            this.this$0.mToolbarNavigationClickListener.onClick(view);
        }
    }
}
