/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  androidx.collection.LruCache
 */
package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.collection.LruCache;

private static class ResourceManagerInternal.ColorFilterLruCache
extends LruCache<Integer, PorterDuffColorFilter> {
    public ResourceManagerInternal.ColorFilterLruCache(int n) {
        super(n);
    }

    private static int generateCacheKey(int n, PorterDuff.Mode mode) {
        return (n + 31) * 31 + mode.hashCode();
    }

    PorterDuffColorFilter get(int n, PorterDuff.Mode mode) {
        return (PorterDuffColorFilter)this.get(ResourceManagerInternal.ColorFilterLruCache.generateCacheKey(n, mode));
    }

    PorterDuffColorFilter put(int n, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter)this.put(ResourceManagerInternal.ColorFilterLruCache.generateCacheKey(n, mode), porterDuffColorFilter);
    }
}
