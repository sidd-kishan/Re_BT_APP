/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ShortcutInfo
 */
package androidx.core.content.pm;

import android.content.pm.ShortcutInfo;
import java.util.Iterator;
import java.util.List;

private static class ShortcutManagerCompat.Api25Impl {
    private ShortcutManagerCompat.Api25Impl() {
    }

    static String getShortcutInfoWithLowestRank(List<ShortcutInfo> object) {
        Iterator<ShortcutInfo> iterator = object.iterator();
        int n = -1;
        object = null;
        while (iterator.hasNext()) {
            ShortcutInfo shortcutInfo = iterator.next();
            if (shortcutInfo.getRank() <= n) continue;
            object = shortcutInfo.getId();
            n = shortcutInfo.getRank();
        }
        return object;
    }
}
