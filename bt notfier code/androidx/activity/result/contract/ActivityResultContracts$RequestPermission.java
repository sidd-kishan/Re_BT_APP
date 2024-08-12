/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 *  androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions
 *  androidx.core.content.ContextCompat
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class ActivityResultContracts.RequestPermission
extends ActivityResultContract<String, Boolean> {
    public Intent createIntent(Context context, String string) {
        return ActivityResultContracts.RequestMultiplePermissions.createIntent((String[])new String[]{string});
    }

    public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String string) {
        if (string == null) {
            return new ActivityResultContract.SynchronousResult((Object)false);
        }
        if (ContextCompat.checkSelfPermission((Context)context, (String)string) != 0) return null;
        return new ActivityResultContract.SynchronousResult((Object)true);
    }

    public Boolean parseResult(int n, Intent object) {
        boolean bl = false;
        if (object == null) return false;
        if (n != -1) return false;
        if ((object = (Object)object.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS")) == null) return false;
        if (((Intent)object).length == 0) return false;
        if (object[0] != false) return bl;
        bl = true;
        return bl;
    }
}
