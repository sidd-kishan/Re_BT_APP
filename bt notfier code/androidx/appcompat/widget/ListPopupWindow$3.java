/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  androidx.appcompat.widget.ListPopupWindow
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

class ListPopupWindow.3
implements AdapterView.OnItemSelectedListener {
    final ListPopupWindow this$0;

    ListPopupWindow.3(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void onItemSelected(AdapterView<?> dropDownListView, View view, int n, long l) {
        if (n == -1) return;
        dropDownListView = this.this$0.mDropDownList;
        if (dropDownListView == null) return;
        dropDownListView.setListSelectionHidden(false);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
