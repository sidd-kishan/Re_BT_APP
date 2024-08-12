/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.OperationCanceledException
 *  androidx.core.os.CancellationSignal
 *  androidx.core.os.OperationCanceledException
 */
package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;

public final class ContentResolverCompat {
    private ContentResolverCompat() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static Cursor query(ContentResolver var0, Uri var1_2, String[] var2_3, String var3_4, String[] var4_5, String var5_6, CancellationSignal var6_7) {
        if (Build.VERSION.SDK_INT < 16) {
            if (var6_7 /* !! */  == null) return var0.query(var1_2, var2_3, var3_4, var4_5, var5_6);
            var6_7 /* !! */ .throwIfCanceled();
            return var0.query(var1_2, var2_3, var3_4, var4_5, var5_6);
        }
        if (var6_7 /* !! */  == null) ** GOTO lbl9
        try {
            block3: {
                var6_7 /* !! */  = var6_7 /* !! */ .getCancellationSignalObject();
                break block3;
lbl9:
                // 1 sources

                var6_7 /* !! */  = null;
            }
            var0 = var0.query(var1_2, var2_3, var3_4, var4_5, var5_6, (android.os.CancellationSignal)var6_7 /* !! */ );
            return var0;
        }
        catch (Exception var0_1) {}
        if (var0_1 instanceof OperationCanceledException == false) throw var0_1;
        throw new androidx.core.os.OperationCanceledException();
    }
}
