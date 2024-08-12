/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View$OnTouchListener
 *  android.widget.PopupMenu
 */
package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.PopupMenu;

public final class PopupMenuCompat {
    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object object) {
        if (Build.VERSION.SDK_INT < 19) return null;
        return ((PopupMenu)object).getDragToOpenListener();
    }
}
