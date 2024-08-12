/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ListView
 *  androidx.appcompat.R$styleable
 */
package androidx.appcompat.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.appcompat.R;

public static class AlertController.RecycleListView
extends ListView {
    private final int mPaddingBottomNoButtons;
    private final int mPaddingTopNoTitle;

    public AlertController.RecycleListView(Context context) {
        this(context, null);
    }

    public AlertController.RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
        this.mPaddingBottomNoButtons = context.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
        this.mPaddingTopNoTitle = context.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }

    public void setHasDecor(boolean bl, boolean bl2) {
        if (bl2) {
            if (bl) return;
        }
        int n = this.getPaddingLeft();
        int n2 = bl ? this.getPaddingTop() : this.mPaddingTopNoTitle;
        int n3 = this.getPaddingRight();
        int n4 = bl2 ? this.getPaddingBottom() : this.mPaddingBottomNoButtons;
        this.setPadding(n, n2, n3, n4);
    }
}
