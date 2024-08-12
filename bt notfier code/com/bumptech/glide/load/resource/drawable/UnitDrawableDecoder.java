/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  com.bumptech.glide.load.Options
 *  com.bumptech.glide.load.ResourceDecoder
 *  com.bumptech.glide.load.engine.Resource
 *  com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource
 */
package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.NonOwnedDrawableResource;

public class UnitDrawableDecoder
implements ResourceDecoder<Drawable, Drawable> {
    public Resource<Drawable> decode(Drawable drawable, int n, int n2, Options options) {
        return NonOwnedDrawableResource.newInstance((Drawable)drawable);
    }

    public boolean handles(Drawable drawable, Options options) {
        return true;
    }
}
