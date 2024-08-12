/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

class SearchView.10
implements TextWatcher {
    final SearchView this$0;

    SearchView.10(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int n, int n2, int n3) {
    }

    public void onTextChanged(CharSequence charSequence, int n, int n2, int n3) {
        this.this$0.onTextChanged(charSequence);
    }
}
