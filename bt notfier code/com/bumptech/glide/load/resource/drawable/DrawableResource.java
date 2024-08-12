/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  com.bumptech.glide.load.engine.Initializable
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.gif.GifDrawable
 *  com.bumptech.glide.util.Preconditions
 */
package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable>
implements Resource<T>,
Initializable {
    protected final T drawable;

    public DrawableResource(T t) {
        this.drawable = (Drawable)Preconditions.checkNotNull(t);
    }

    public final T get() {
        Drawable.ConstantState constantState = this.drawable.getConstantState();
        if (constantState != null) return (T)constantState.newDrawable();
        return this.drawable;
    }

    public void initialize() {
        T t = this.drawable;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable)t).getBitmap().prepareToDraw();
        } else {
            if (!(t instanceof GifDrawable)) return;
            ((GifDrawable)t).getFirstFrame().prepareToDraw();
        }
    }
}
