/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.UserManager
 */
package androidx.core.os;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class UserManagerCompat {
    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(Context context) {
        if (Build.VERSION.SDK_INT < 24) return true;
        return ((UserManager)context.getSystemService(UserManager.class)).isUserUnlocked();
    }
}
