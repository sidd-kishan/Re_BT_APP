/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
 *  com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ShadowAnimatorImpl
 */
package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

private class FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation
extends FloatingActionButtonImpl.ShadowAnimatorImpl {
    final FloatingActionButtonImpl this$0;

    FloatingActionButtonImpl.ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.this$0 = floatingActionButtonImpl;
        super(floatingActionButtonImpl, null);
    }

    protected float getTargetShadowSize() {
        return this.this$0.elevation + this.this$0.hoveredFocusedTranslationZ;
    }
}
