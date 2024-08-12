/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  com.bumptech.glide.request.target.FixedSizeDrawable
 */
package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.FixedSizeDrawable;

static final class FixedSizeDrawable.State
extends Drawable.ConstantState {
    final int height;
    final int width;
    private final Drawable.ConstantState wrapped;

    FixedSizeDrawable.State(Drawable.ConstantState constantState, int n, int n2) {
        this.wrapped = constantState;
        this.width = n;
        this.height = n2;
    }

    FixedSizeDrawable.State(FixedSizeDrawable.State state) {
        this(state.wrapped, state.width, state.height);
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        return new FixedSizeDrawable(this, this.wrapped.newDrawable());
    }

    public Drawable newDrawable(Resources resources) {
        return new FixedSizeDrawable(this, this.wrapped.newDrawable(resources));
    }
}
