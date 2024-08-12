/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewPropertyAnimator
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$id
 *  com.google.android.material.R$styleable
 *  com.google.android.material.snackbar.ContentViewCallback
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.snackbar.ContentViewCallback;

public class SnackbarContentLayout
extends LinearLayout
implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private int maxWidth;
    private TextView messageView;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.maxWidth = context.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.maxInlineActionWidth = context.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        context.recycle();
    }

    private static void updateTopBottomPadding(View view, int n, int n2) {
        if (ViewCompat.isPaddingRelative((View)view)) {
            ViewCompat.setPaddingRelative((View)view, (int)ViewCompat.getPaddingStart((View)view), (int)n, (int)ViewCompat.getPaddingEnd((View)view), (int)n2);
        } else {
            view.setPadding(view.getPaddingLeft(), n, view.getPaddingRight(), n2);
        }
    }

    private boolean updateViewsWithinLayout(int n, int n2, int n3) {
        boolean bl;
        int n4 = this.getOrientation();
        boolean bl2 = true;
        if (n != n4) {
            this.setOrientation(n);
            bl = true;
        } else {
            bl = false;
        }
        if (this.messageView.getPaddingTop() == n2) {
            if (this.messageView.getPaddingBottom() == n3) return bl;
        }
        SnackbarContentLayout.updateTopBottomPadding((View)this.messageView, n2, n3);
        bl = bl2;
        return bl;
    }

    public void animateContentIn(int n, int n2) {
        this.messageView.setAlpha(0.0f);
        ViewPropertyAnimator viewPropertyAnimator = this.messageView.animate().alpha(1.0f);
        long l = n2;
        viewPropertyAnimator = viewPropertyAnimator.setDuration(l);
        long l2 = n;
        viewPropertyAnimator.setStartDelay(l2).start();
        if (this.actionView.getVisibility() != 0) return;
        this.actionView.setAlpha(0.0f);
        this.actionView.animate().alpha(1.0f).setDuration(l).setStartDelay(l2).start();
    }

    public void animateContentOut(int n, int n2) {
        this.messageView.setAlpha(1.0f);
        ViewPropertyAnimator viewPropertyAnimator = this.messageView.animate().alpha(0.0f);
        long l = n2;
        viewPropertyAnimator = viewPropertyAnimator.setDuration(l);
        long l2 = n;
        viewPropertyAnimator.setStartDelay(l2).start();
        if (this.actionView.getVisibility() != 0) return;
        this.actionView.setAlpha(1.0f);
        this.actionView.animate().alpha(0.0f).setDuration(l).setStartDelay(l2).start();
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView)this.findViewById(R.id.snackbar_text);
        this.actionView = (Button)this.findViewById(R.id.snackbar_action);
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        block7: {
            block8: {
                int n4;
                int n5;
                int n6;
                block6: {
                    super.onMeasure(n, n2);
                    n3 = n;
                    if (this.maxWidth > 0) {
                        n6 = this.getMeasuredWidth();
                        n5 = this.maxWidth;
                        n3 = n;
                        if (n6 > n5) {
                            n3 = View.MeasureSpec.makeMeasureSpec((int)n5, (int)0x40000000);
                            super.onMeasure(n3, n2);
                        }
                    }
                    n4 = this.getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
                    n6 = this.getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
                    n = this.messageView.getLayout().getLineCount();
                    n5 = 0;
                    if ((n = n > 1 ? 1 : 0) == 0 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) break block6;
                    n = n5;
                    if (!this.updateViewsWithinLayout(1, n4, n4 - n6)) break block7;
                    break block8;
                }
                if (n != 0) {
                    n6 = n4;
                }
                n = n5;
                if (!this.updateViewsWithinLayout(0, n6, n6)) break block7;
            }
            n = 1;
        }
        if (n == 0) return;
        super.onMeasure(n3, n2);
    }
}
