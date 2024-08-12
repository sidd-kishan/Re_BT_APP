/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.view.menu.ShowableListMenu
 *  androidx.appcompat.widget.AppCompatSpinner
 *  androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
 *  androidx.appcompat.widget.ForwardingListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ForwardingListener;

class AppCompatSpinner.1
extends ForwardingListener {
    final AppCompatSpinner this$0;
    final AppCompatSpinner.DropdownPopup val$popup;

    AppCompatSpinner.1(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner.DropdownPopup dropdownPopup) {
        this.this$0 = appCompatSpinner;
        this.val$popup = dropdownPopup;
        super(view);
    }

    public ShowableListMenu getPopup() {
        return this.val$popup;
    }

    public boolean onForwardingStarted() {
        if (this.this$0.getInternalPopup().isShowing()) return true;
        this.this$0.showPopup();
        return true;
    }
}
