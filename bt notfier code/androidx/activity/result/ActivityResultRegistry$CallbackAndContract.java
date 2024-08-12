/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.contract.ActivityResultContract
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContract;

private static class ActivityResultRegistry.CallbackAndContract<O> {
    final ActivityResultCallback<O> mCallback;
    final ActivityResultContract<?, O> mContract;

    ActivityResultRegistry.CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
        this.mCallback = activityResultCallback;
        this.mContract = activityResultContract;
    }
}
