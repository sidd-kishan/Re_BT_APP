/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  com.bumptech.glide.request.target.FixedSizeDrawable$State
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.request.target;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.FixedSizeDrawable;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable
extends Drawable {
    private final RectF bounds;
    private final Matrix matrix;
    private boolean mutated;
    private State state;
    private Drawable wrapped;
    private final RectF wrappedRect;

    public FixedSizeDrawable(Drawable drawable, int n, int n2) {
        this(new State(drawable.getConstantState(), n, n2), drawable);
    }

    FixedSizeDrawable(State state, Drawable drawable) {
        this.state = (State)Preconditions.checkNotNull((Object)state);
        this.wrapped = (Drawable)Preconditions.checkNotNull((Object)drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.matrix = new Matrix();
        this.wrappedRect = new RectF(0.0f, 0.0f, (float)drawable.getIntrinsicWidth(), (float)drawable.getIntrinsicHeight());
        this.bounds = new RectF();
    }

    private void updateMatrix() {
        this.matrix.setRectToRect(this.wrappedRect, this.bounds, Matrix.ScaleToFit.CENTER);
    }

    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.matrix);
        this.wrapped.draw(canvas);
        canvas.restore();
    }

    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.state.height;
    }

    public int getIntrinsicWidth() {
        return this.state.width;
    }

    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.wrapped.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    public Drawable mutate() {
        if (this.mutated) return this;
        if (super.mutate() != this) return this;
        this.wrapped = this.wrapped.mutate();
        this.state = new State(this.state);
        this.mutated = true;
        return this;
    }

    public void scheduleSelf(Runnable runnable, long l) {
        super.scheduleSelf(runnable, l);
        this.wrapped.scheduleSelf(runnable, l);
    }

    public void setAlpha(int n) {
        this.wrapped.setAlpha(n);
    }

    public void setBounds(int n, int n2, int n3, int n4) {
        super.setBounds(n, n2, n3, n4);
        this.bounds.set((float)n, (float)n2, (float)n3, (float)n4);
        this.updateMatrix();
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.bounds.set(rect);
        this.updateMatrix();
    }

    public void setChangingConfigurations(int n) {
        this.wrapped.setChangingConfigurations(n);
    }

    public void setColorFilter(int n, PorterDuff.Mode mode) {
        this.wrapped.setColorFilter(n, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    @Deprecated
    public void setDither(boolean bl) {
        this.wrapped.setDither(bl);
    }

    public void setFilterBitmap(boolean bl) {
        this.wrapped.setFilterBitmap(bl);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        return this.wrapped.setVisible(bl, bl2);
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }
}
