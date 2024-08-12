/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.core.content.res.ResourcesCompat
 */
package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, int n) {
        return DrawableDecoderCompat.getDrawable(context, n, null);
    }

    public static Drawable getDrawable(Context context, int n, Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                Drawable drawable = DrawableDecoderCompat.loadDrawableV7(context, n);
                return drawable;
            }
        }
        catch (Resources.NotFoundException notFoundException) {
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            shouldCallAppCompatResources = false;
        }
        if (theme != null) return DrawableDecoderCompat.loadDrawableV4(context, n, theme);
        theme = context.getTheme();
        return DrawableDecoderCompat.loadDrawableV4(context, n, theme);
    }

    private static Drawable loadDrawableV4(Context context, int n, Resources.Theme theme) {
        return ResourcesCompat.getDrawable((Resources)context.getResources(), (int)n, (Resources.Theme)theme);
    }

    private static Drawable loadDrawableV7(Context context, int n) {
        return AppCompatResources.getDrawable((Context)context, (int)n);
    }
}
