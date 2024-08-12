/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.widget.ResourceManagerInternal
 *  androidx.appcompat.widget.ResourcesWrapper
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ResourcesWrapper;
import java.lang.ref.WeakReference;

class TintResources
extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<Context>(context);
    }

    public Drawable getDrawable(int n) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(n);
        Context context = (Context)this.mContextRef.get();
        if (drawable == null) return drawable;
        if (context == null) return drawable;
        ResourceManagerInternal.get().tintDrawableUsingColorFilter(context, n, drawable);
        return drawable;
    }
}
