/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuUi
 *  androidx.core.widget.TextViewCompat
 */
package androidx.browser.browseractions;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.browser.browseractions.BrowserActionsFallbackMenuUi;
import androidx.core.widget.TextViewCompat;

class BrowserActionsFallbackMenuUi.2
implements View.OnClickListener {
    final BrowserActionsFallbackMenuUi this$0;
    final TextView val$urlTextView;

    BrowserActionsFallbackMenuUi.2(BrowserActionsFallbackMenuUi browserActionsFallbackMenuUi, TextView textView) {
        this.this$0 = browserActionsFallbackMenuUi;
        this.val$urlTextView = textView;
    }

    public void onClick(View view) {
        if (TextViewCompat.getMaxLines((TextView)this.val$urlTextView) == Integer.MAX_VALUE) {
            this.val$urlTextView.setMaxLines(1);
            this.val$urlTextView.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            this.val$urlTextView.setMaxLines(Integer.MAX_VALUE);
            this.val$urlTextView.setEllipsize(null);
        }
    }
}
