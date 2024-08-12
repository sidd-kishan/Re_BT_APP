/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

class SearchView.9
implements AdapterView.OnItemSelectedListener {
    final SearchView this$0;

    SearchView.9(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int n, long l) {
        this.this$0.onItemSelected(n);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
