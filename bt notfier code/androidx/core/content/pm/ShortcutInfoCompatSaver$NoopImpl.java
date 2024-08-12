/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.content.pm.ShortcutInfoCompat
 *  androidx.core.content.pm.ShortcutInfoCompatSaver
 */
package androidx.core.content.pm;

import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import java.util.List;

public static class ShortcutInfoCompatSaver.NoopImpl
extends ShortcutInfoCompatSaver<Void> {
    public Void addShortcuts(List<ShortcutInfoCompat> list) {
        return null;
    }

    public Void removeAllShortcuts() {
        return null;
    }

    public Void removeShortcuts(List<String> list) {
        return null;
    }
}
