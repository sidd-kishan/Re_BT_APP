/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.view.menu.ShowableListMenu
 *  androidx.appcompat.widget.ActivityChooserView
 *  androidx.appcompat.widget.ForwardingListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ForwardingListener;

class ActivityChooserView.4
extends ForwardingListener {
    final ActivityChooserView this$0;

    ActivityChooserView.4(ActivityChooserView activityChooserView, View view) {
        this.this$0 = activityChooserView;
        super(view);
    }

    public ShowableListMenu getPopup() {
        return this.this$0.getListPopupWindow();
    }

    protected boolean onForwardingStarted() {
        this.this$0.showPopup();
        return true;
    }

    protected boolean onForwardingStopped() {
        this.this$0.dismissPopup();
        return true;
    }
}
