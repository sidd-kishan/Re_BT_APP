/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

class SearchView.8
implements AdapterView.OnItemClickListener {
    final SearchView this$0;

    SearchView.8(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n, long l) {
        this.this$0.onItemClicked(n, 0, null);
    }
}
