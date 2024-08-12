/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.widget.SearchView
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.SearchView;

class SearchView.5
implements View.OnClickListener {
    final SearchView this$0;

    SearchView.5(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onClick(View view) {
        if (view == this.this$0.mSearchButton) {
            this.this$0.onSearchClicked();
        } else if (view == this.this$0.mCloseButton) {
            this.this$0.onCloseClicked();
        } else if (view == this.this$0.mGoButton) {
            this.this$0.onSubmitQuery();
        } else if (view == this.this$0.mVoiceButton) {
            this.this$0.onVoiceClicked();
        } else {
            if (view != this.this$0.mSearchSrcTextView) return;
            this.this$0.forceSuggestionQuery();
        }
    }
}
