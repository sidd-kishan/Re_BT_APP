/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  com.google.android.material.internal.CircularBorderDrawable
 */
package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import com.google.android.material.internal.CircularBorderDrawable;

private class CircularBorderDrawable.CircularBorderState
extends Drawable.ConstantState {
    final CircularBorderDrawable this$0;

    private CircularBorderDrawable.CircularBorderState(CircularBorderDrawable circularBorderDrawable) {
        this.this$0 = circularBorderDrawable;
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        return this.this$0;
    }
}
