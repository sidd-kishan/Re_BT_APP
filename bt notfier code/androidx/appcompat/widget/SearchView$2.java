/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView
 *  androidx.appcompat.widget.SuggestionsAdapter
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SuggestionsAdapter;

class SearchView.2
implements Runnable {
    final SearchView this$0;

    SearchView.2(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override
    public void run() {
        if (!(this.this$0.mSuggestionsAdapter instanceof SuggestionsAdapter)) return;
        this.this$0.mSuggestionsAdapter.changeCursor(null);
    }
}
