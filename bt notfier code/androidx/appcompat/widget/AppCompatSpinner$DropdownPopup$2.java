/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
 */
package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;

/*
 * Exception performing whole class analysis ignored.
 */
class AppCompatSpinner.DropdownPopup.2
implements ViewTreeObserver.OnGlobalLayoutListener {
    final AppCompatSpinner.DropdownPopup this$1;

    AppCompatSpinner.DropdownPopup.2(AppCompatSpinner.DropdownPopup dropdownPopup) {
        this.this$1 = dropdownPopup;
    }

    public void onGlobalLayout() {
        AppCompatSpinner.DropdownPopup dropdownPopup = this.this$1;
        if (!dropdownPopup.isVisibleToUser((View)dropdownPopup.this$0)) {
            this.this$1.dismiss();
        } else {
            this.this$1.computeContentWidth();
            AppCompatSpinner.DropdownPopup.access$001((AppCompatSpinner.DropdownPopup)this.this$1);
        }
    }
}
