/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.SearchView;

class SearchView.4
implements View.OnLayoutChangeListener {
    final SearchView this$0;

    SearchView.4(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.this$0.adjustDropDownSizeAndPosition();
    }
}
