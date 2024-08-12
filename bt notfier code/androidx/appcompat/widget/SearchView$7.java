/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

class SearchView.7
implements TextView.OnEditorActionListener {
    final SearchView this$0;

    SearchView.7(SearchView searchView) {
        this.this$0 = searchView;
    }

    public boolean onEditorAction(TextView textView, int n, KeyEvent keyEvent) {
        this.this$0.onSubmitQuery();
        return true;
    }
}
