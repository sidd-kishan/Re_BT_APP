/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.ActionMenuView$ActionMenuChildView
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.appcompat.widget.TooltipCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;

private class ActionMenuPresenter.OverflowMenuButton
extends AppCompatImageView
implements ActionMenuView.ActionMenuChildView {
    final ActionMenuPresenter this$0;

    public ActionMenuPresenter.OverflowMenuButton(ActionMenuPresenter actionMenuPresenter, Context context) {
        this.this$0 = actionMenuPresenter;
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.setClickable(true);
        this.setFocusable(true);
        this.setVisibility(0);
        this.setEnabled(true);
        TooltipCompat.setTooltipText((View)this, (CharSequence)this.getContentDescription());
        this.setOnTouchListener((View.OnTouchListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean needsDividerAfter() {
        return false;
    }

    public boolean needsDividerBefore() {
        return false;
    }

    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        this.playSoundEffect(0);
        this.this$0.showOverflowMenu();
        return true;
    }

    protected boolean setFrame(int n, int n2, int n3, int n4) {
        boolean bl = super.setFrame(n, n2, n3, n4);
        Drawable drawable = this.getDrawable();
        Drawable drawable2 = this.getBackground();
        if (drawable == null) return bl;
        if (drawable2 == null) return bl;
        int n5 = this.getWidth();
        n2 = this.getHeight();
        n = Math.max(n5, n2) / 2;
        int n6 = this.getPaddingLeft();
        int n7 = this.getPaddingRight();
        n4 = this.getPaddingTop();
        n3 = this.getPaddingBottom();
        n7 = (n5 + (n6 - n7)) / 2;
        n2 = (n2 + (n4 - n3)) / 2;
        DrawableCompat.setHotspotBounds((Drawable)drawable2, (int)(n7 - n), (int)(n2 - n), (int)(n7 + n), (int)(n2 + n));
        return bl;
    }
}
