/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 */
package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Configuration;

private static class ResourcesCompat.ColorStateListCacheEntry {
    final Configuration mConfiguration;
    final ColorStateList mValue;

    ResourcesCompat.ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
        this.mValue = colorStateList;
        this.mConfiguration = configuration;
    }
}
