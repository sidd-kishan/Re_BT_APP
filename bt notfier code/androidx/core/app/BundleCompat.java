/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  androidx.core.app.BundleCompat$BundleCompatBaseImpl
 */
package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.BundleCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String string) {
        if (Build.VERSION.SDK_INT < 18) return BundleCompatBaseImpl.getBinder((Bundle)bundle, (String)string);
        return bundle.getBinder(string);
    }

    public static void putBinder(Bundle bundle, String string, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(string, iBinder);
        } else {
            BundleCompatBaseImpl.putBinder((Bundle)bundle, (String)string, (IBinder)iBinder);
        }
    }
}
