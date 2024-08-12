/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.CursorWindow
 *  android.os.Build$VERSION
 */
package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

public final class CursorWindowCompat {
    private CursorWindowCompat() {
    }

    public static CursorWindow create(String string, long l) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new CursorWindow(string, l);
        }
        if (Build.VERSION.SDK_INT < 15) return new CursorWindow(false);
        return new CursorWindow(string);
    }
}
