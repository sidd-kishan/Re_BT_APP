/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.contract.ActivityResultContract
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;

public interface ActivityResultCaller {
    public <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> var1, ActivityResultCallback<O> var2);

    public <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> var1, ActivityResultRegistry var2, ActivityResultCallback<O> var3);
}
