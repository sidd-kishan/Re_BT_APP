/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;

class SearchView.1
implements Runnable {
    final SearchView this$0;

    SearchView.1(SearchView searchView) {
        this.this$0 = searchView;
    }

    @Override
    public void run() {
        this.this$0.updateFocusedState();
    }
}
