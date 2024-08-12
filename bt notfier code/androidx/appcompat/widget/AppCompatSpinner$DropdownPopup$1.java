/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  androidx.appcompat.widget.AppCompatSpinner
 *  androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;

class AppCompatSpinner.DropdownPopup.1
implements AdapterView.OnItemClickListener {
    final AppCompatSpinner.DropdownPopup this$1;
    final AppCompatSpinner val$this$0;

    AppCompatSpinner.DropdownPopup.1(AppCompatSpinner.DropdownPopup dropdownPopup, AppCompatSpinner appCompatSpinner) {
        this.this$1 = dropdownPopup;
        this.val$this$0 = appCompatSpinner;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
        this.this$1.this$0.setSelection(n);
        if (this.this$1.this$0.getOnItemClickListener() != null) {
            this.this$1.this$0.performItemClick(view, n, this.this$1.mAdapter.getItemId(n));
        }
        this.this$1.dismiss();
    }
}
