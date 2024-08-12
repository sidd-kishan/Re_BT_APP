/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;

class SearchView.6
implements View.OnKeyListener {
    final SearchView this$0;

    SearchView.6(SearchView searchView) {
        this.this$0 = searchView;
    }

    public boolean onKey(View view, int n, KeyEvent keyEvent) {
        if (this.this$0.mSearchable == null) {
            return false;
        }
        if (this.this$0.mSearchSrcTextView.isPopupShowing() && this.this$0.mSearchSrcTextView.getListSelection() != -1) {
            return this.this$0.onSuggestionsKey(view, n, keyEvent);
        }
        if (this.this$0.mSearchSrcTextView.isEmpty()) return false;
        if (!keyEvent.hasNoModifiers()) return false;
        if (keyEvent.getAction() != 1) return false;
        if (n != 66) return false;
        view.cancelLongPress();
        view = this.this$0;
        view.launchQuerySearch(0, null, view.mSearchSrcTextView.getText().toString());
        return true;
    }
}
