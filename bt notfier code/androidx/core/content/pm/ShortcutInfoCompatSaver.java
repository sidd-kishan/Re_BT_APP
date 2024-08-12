/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.content.pm.ShortcutInfoCompat
 */
package androidx.core.content.pm;

import androidx.core.content.pm.ShortcutInfoCompat;
import java.util.ArrayList;
import java.util.List;

public abstract class ShortcutInfoCompatSaver<T> {
    public abstract T addShortcuts(List<ShortcutInfoCompat> var1);

    public List<ShortcutInfoCompat> getShortcuts() throws Exception {
        return new ArrayList<ShortcutInfoCompat>();
    }

    public abstract T removeAllShortcuts();

    public abstract T removeShortcuts(List<String> var1);
}
