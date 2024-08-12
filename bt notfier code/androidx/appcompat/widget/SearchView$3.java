/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnFocusChangeListener
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.SearchView;

class SearchView.3
implements View.OnFocusChangeListener {
    final SearchView this$0;

    SearchView.3(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onFocusChange(View view, boolean bl) {
        if (this.this$0.mOnQueryTextFocusChangeListener == null) return;
        this.this$0.mOnQueryTextFocusChangeListener.onFocusChange((View)this.this$0, bl);
    }
}
