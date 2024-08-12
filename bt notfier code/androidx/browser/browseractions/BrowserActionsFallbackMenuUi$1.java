/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.view.View
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuUi
 */
package androidx.browser.browseractions;

import android.content.DialogInterface;
import android.view.View;
import androidx.browser.browseractions.BrowserActionsFallbackMenuUi;

class BrowserActionsFallbackMenuUi.1
implements DialogInterface.OnShowListener {
    final BrowserActionsFallbackMenuUi this$0;
    final View val$view;

    BrowserActionsFallbackMenuUi.1(BrowserActionsFallbackMenuUi browserActionsFallbackMenuUi, View view) {
        this.this$0 = browserActionsFallbackMenuUi;
        this.val$view = view;
    }

    public void onShow(DialogInterface dialogInterface) {
        this.this$0.mMenuUiListener.onMenuShown(this.val$view);
    }
}
