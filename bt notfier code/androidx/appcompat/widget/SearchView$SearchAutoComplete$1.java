/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.widget.SearchView$SearchAutoComplete
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;

class SearchView.SearchAutoComplete.1
implements Runnable {
    final SearchView.SearchAutoComplete this$0;

    SearchView.SearchAutoComplete.1(SearchView.SearchAutoComplete searchAutoComplete) {
        this.this$0 = searchAutoComplete;
    }

    @Override
    public void run() {
        this.this$0.showSoftInputIfNecessary();
    }
}
