/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.os.Build$VERSION
 *  androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi23
 *  androidx.core.content.res.ResourcesCompat$ThemeCompat$ImplApi29
 */
package androidx.core.content.res;

import android.content.res.Resources;
import android.os.Build;
import androidx.core.content.res.ResourcesCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class ResourcesCompat.ThemeCompat {
    private ResourcesCompat.ThemeCompat() {
    }

    public static void rebase(Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 29) {
            ImplApi29.rebase((Resources.Theme)theme);
        } else {
            if (Build.VERSION.SDK_INT < 23) return;
            ImplApi23.rebase((Resources.Theme)theme);
        }
    }
}
