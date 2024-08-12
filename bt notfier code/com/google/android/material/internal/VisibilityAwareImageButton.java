/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.ImageButton
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class VisibilityAwareImageButton
extends ImageButton {
    private int userSetVisibility = this.getVisibility();

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int n, boolean bl) {
        super.setVisibility(n);
        if (!bl) return;
        this.userSetVisibility = n;
    }

    public void setVisibility(int n) {
        this.internalSetVisibility(n, true);
    }
}
