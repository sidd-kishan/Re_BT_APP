/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.CollapsibleActionView
 *  android.view.View
 *  android.widget.FrameLayout
 *  androidx.appcompat.view.CollapsibleActionView
 */
package androidx.appcompat.view.menu;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;

static class MenuItemWrapperICS.CollapsibleActionViewWrapper
extends FrameLayout
implements CollapsibleActionView {
    final android.view.CollapsibleActionView mWrappedView;

    MenuItemWrapperICS.CollapsibleActionViewWrapper(View view) {
        super(view.getContext());
        this.mWrappedView = (android.view.CollapsibleActionView)view;
        this.addView(view);
    }

    View getWrappedView() {
        return (View)this.mWrappedView;
    }

    public void onActionViewCollapsed() {
        this.mWrappedView.onActionViewCollapsed();
    }

    public void onActionViewExpanded() {
        this.mWrappedView.onActionViewExpanded();
    }
}
