/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.content.pm.ShortcutInfoCompat
 */
package androidx.core.content.pm;

import androidx.core.content.pm.ShortcutInfoCompat;
import java.util.List;

public abstract class ShortcutInfoChangeListener {
    public void onAllShortcutsRemoved() {
    }

    public void onShortcutAdded(List<ShortcutInfoCompat> list) {
    }

    public void onShortcutRemoved(List<String> list) {
    }

    public void onShortcutUpdated(List<ShortcutInfoCompat> list) {
    }

    public void onShortcutUsageReported(List<String> list) {
    }
}
