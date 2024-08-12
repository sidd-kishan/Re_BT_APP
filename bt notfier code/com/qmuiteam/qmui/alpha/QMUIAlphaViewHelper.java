/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  com.qmuiteam.qmui.R$attr
 *  com.qmuiteam.qmui.util.QMUIResHelper
 */
package com.qmuiteam.qmui.alpha;

import android.content.Context;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import java.lang.ref.WeakReference;

public class QMUIAlphaViewHelper {
    private boolean mChangeAlphaWhenDisable = true;
    private boolean mChangeAlphaWhenPress = true;
    private float mDisabledAlpha = 0.5f;
    private float mNormalAlpha = 1.0f;
    private float mPressedAlpha = 0.5f;
    private WeakReference<View> mTarget;

    public QMUIAlphaViewHelper(View view) {
        this.mTarget = new WeakReference<View>(view);
        this.mPressedAlpha = QMUIResHelper.getAttrFloatValue((Context)view.getContext(), (int)R.attr.qmui_alpha_pressed);
        this.mDisabledAlpha = QMUIResHelper.getAttrFloatValue((Context)view.getContext(), (int)R.attr.qmui_alpha_disabled);
    }

    public QMUIAlphaViewHelper(View view, float f, float f2) {
        this.mTarget = new WeakReference<View>(view);
        this.mPressedAlpha = f;
        this.mDisabledAlpha = f2;
    }

    public void onEnabledChanged(View view, boolean bl) {
        View view2 = (View)this.mTarget.get();
        if (view2 == null) {
            return;
        }
        float f = this.mChangeAlphaWhenDisable ? (bl ? this.mNormalAlpha : this.mDisabledAlpha) : this.mNormalAlpha;
        if (view != view2 && view2.isEnabled() != bl) {
            view2.setEnabled(bl);
        }
        view2.setAlpha(f);
    }

    public void onPressedChanged(View view, boolean bl) {
        View view2 = (View)this.mTarget.get();
        if (view2 == null) {
            return;
        }
        if (view.isEnabled()) {
            float f = this.mChangeAlphaWhenPress && bl && view.isClickable() ? this.mPressedAlpha : this.mNormalAlpha;
            view2.setAlpha(f);
        } else {
            if (!this.mChangeAlphaWhenDisable) return;
            view2.setAlpha(this.mDisabledAlpha);
        }
    }

    public void setChangeAlphaWhenDisable(boolean bl) {
        this.mChangeAlphaWhenDisable = bl;
        View view = (View)this.mTarget.get();
        if (view == null) return;
        this.onEnabledChanged(view, view.isEnabled());
    }

    public void setChangeAlphaWhenPress(boolean bl) {
        this.mChangeAlphaWhenPress = bl;
    }
}
