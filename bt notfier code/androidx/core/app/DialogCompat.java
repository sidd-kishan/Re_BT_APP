/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;

public class DialogCompat {
    private DialogCompat() {
    }

    public static View requireViewById(Dialog dialog, int n) {
        if (Build.VERSION.SDK_INT >= 28) {
            return dialog.requireViewById(n);
        }
        if ((dialog = dialog.findViewById(n)) == null) throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
        return dialog;
    }
}
