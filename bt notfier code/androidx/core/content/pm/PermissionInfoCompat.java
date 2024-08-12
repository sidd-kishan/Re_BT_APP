/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.PermissionInfo
 *  android.os.Build$VERSION
 */
package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import android.os.Build;

public final class PermissionInfoCompat {
    private PermissionInfoCompat() {
    }

    public static int getProtection(PermissionInfo permissionInfo) {
        if (Build.VERSION.SDK_INT < 28) return permissionInfo.protectionLevel & 0xF;
        return permissionInfo.getProtection();
    }

    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        if (Build.VERSION.SDK_INT < 28) return permissionInfo.protectionLevel & 0xFFFFFFF0;
        return permissionInfo.getProtectionFlags();
    }
}
