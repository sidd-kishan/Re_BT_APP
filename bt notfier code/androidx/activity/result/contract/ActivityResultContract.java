/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;

public abstract class ActivityResultContract<I, O> {
    public abstract Intent createIntent(Context var1, I var2);

    public SynchronousResult<O> getSynchronousResult(Context context, I i) {
        return null;
    }

    public abstract O parseResult(int var1, Intent var2);
}
