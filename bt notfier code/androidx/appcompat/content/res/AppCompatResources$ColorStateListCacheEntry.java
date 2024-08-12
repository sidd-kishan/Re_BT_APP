/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 */
package androidx.appcompat.content.res;

import android.content.res.ColorStateList;
import android.content.res.Configuration;

private static class AppCompatResources.ColorStateListCacheEntry {
    final Configuration configuration;
    final ColorStateList value;

    AppCompatResources.ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration) {
        this.value = colorStateList;
        this.configuration = configuration;
    }
}
