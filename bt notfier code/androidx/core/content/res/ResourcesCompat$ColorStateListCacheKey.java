/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  androidx.core.util.ObjectsCompat
 */
package androidx.core.content.res;

import android.content.res.Resources;
import androidx.core.util.ObjectsCompat;

private static final class ResourcesCompat.ColorStateListCacheKey {
    final Resources mResources;
    final Resources.Theme mTheme;

    ResourcesCompat.ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
        this.mResources = resources;
        this.mTheme = theme;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (ResourcesCompat.ColorStateListCacheKey)object;
        if (this.mResources.equals(((ResourcesCompat.ColorStateListCacheKey)object).mResources) && ObjectsCompat.equals((Object)this.mTheme, (Object)((ResourcesCompat.ColorStateListCacheKey)object).mTheme)) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        return ObjectsCompat.hash((Object[])new Object[]{this.mResources, this.mTheme});
    }
}
