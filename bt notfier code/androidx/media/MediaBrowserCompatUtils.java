/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils {
    private MediaBrowserCompatUtils() {
    }

    public static boolean areSameOptions(Bundle bundle, Bundle bundle2) {
        boolean bl = true;
        boolean bl2 = true;
        boolean bl3 = true;
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null) {
            bl = bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 ? bl3 : false;
            return bl;
        }
        if (bundle2 == null) {
            if (bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1) return bl;
            bl = false;
            return bl;
        }
        bl = bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) ? bl2 : false;
        return bl;
    }

    public static boolean hasDuplicatedItems(Bundle bundle, Bundle bundle2) {
        int n = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE", -1);
        int n2 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE", -1);
        int n3 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int n4 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int n5 = Integer.MAX_VALUE;
        boolean bl = true;
        if (n != -1 && n3 != -1) {
            int n6 = n * n3;
            n = n3 + n6 - 1;
            n3 = n6;
        } else {
            n = Integer.MAX_VALUE;
            n3 = 0;
        }
        if (n2 != -1 && n4 != -1) {
            n5 = n4 + (n2 *= n4) - 1;
            n4 = n2;
            n2 = n5;
        } else {
            n4 = 0;
            n2 = n5;
        }
        if (n >= n4 && n2 >= n3) return bl;
        bl = false;
        return bl;
    }
}
