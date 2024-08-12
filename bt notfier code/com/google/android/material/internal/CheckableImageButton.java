/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.Checkable
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;

public class CheckableImageButton
extends AppCompatImageButton
implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = new int[]{0x10100A0};
    private boolean checked;

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        ViewCompat.setAccessibilityDelegate((View)this, (AccessibilityDelegateCompat)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean isChecked() {
        return this.checked;
    }

    public int[] onCreateDrawableState(int n) {
        if (!this.checked) return super.onCreateDrawableState(n);
        return CheckableImageButton.mergeDrawableStates((int[])super.onCreateDrawableState(n + DRAWABLE_STATE_CHECKED.length), (int[])DRAWABLE_STATE_CHECKED);
    }

    public void setChecked(boolean bl) {
        if (this.checked == bl) return;
        this.checked = bl;
        this.refreshDrawableState();
        this.sendAccessibilityEvent(2048);
    }

    public void toggle() {
        this.setChecked(this.checked ^ true);
    }
}
