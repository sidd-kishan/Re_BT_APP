/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.os.Process
 *  androidx.core.app.AppOpsManagerCompat
 */
package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;

public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(Context context, String string) {
        String string2 = Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null;
        return PermissionChecker.checkPermission(context, string, Binder.getCallingPid(), Binder.getCallingUid(), string2);
    }

    public static int checkCallingPermission(Context context, String string, String string2) {
        if (Binder.getCallingPid() != Process.myPid()) return PermissionChecker.checkPermission(context, string, Binder.getCallingPid(), Binder.getCallingUid(), string2);
        return -1;
    }

    public static int checkPermission(Context context, String object, int n, int n2, String string) {
        if (context.checkPermission((String)object, n, n2) == -1) {
            return -1;
        }
        String string2 = AppOpsManagerCompat.permissionToOp((String)object);
        if (string2 == null) {
            return 0;
        }
        object = string;
        if (string == null) {
            object = context.getPackageManager().getPackagesForUid(n2);
            if (object == null) return -1;
            if (((String[])object).length <= 0) {
                return -1;
            }
            object = object[0];
        }
        if (AppOpsManagerCompat.noteProxyOpNoThrow((Context)context, (String)string2, (String)object) == 0) return 0;
        return -2;
    }

    public static int checkSelfPermission(Context context, String string) {
        return PermissionChecker.checkPermission(context, string, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
