/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
 */
package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;

class AppCompatSpinner.DropdownPopup.3
implements PopupWindow.OnDismissListener {
    final AppCompatSpinner.DropdownPopup this$1;
    final ViewTreeObserver.OnGlobalLayoutListener val$layoutListener;

    AppCompatSpinner.DropdownPopup.3(AppCompatSpinner.DropdownPopup dropdownPopup, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.this$1 = dropdownPopup;
        this.val$layoutListener = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.this$1.this$0.getViewTreeObserver();
        if (viewTreeObserver == null) return;
        viewTreeObserver.removeGlobalOnLayoutListener(this.val$layoutListener);
    }
}
