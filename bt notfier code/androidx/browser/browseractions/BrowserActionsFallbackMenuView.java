/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 *  androidx.browser.R$dimen
 */
package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.browser.R;

public class BrowserActionsFallbackMenuView
extends LinearLayout {
    private final int mBrowserActionsMenuMaxWidthPx;
    private final int mBrowserActionsMenuMinPaddingPx = this.getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_min_padding);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBrowserActionsMenuMaxWidthPx = this.getResources().getDimensionPixelOffset(R.dimen.browser_actions_context_menu_max_width);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)Math.min(this.getResources().getDisplayMetrics().widthPixels - this.mBrowserActionsMenuMinPaddingPx * 2, this.mBrowserActionsMenuMaxWidthPx), (int)0x40000000), n2);
    }
}
