/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResultLauncher
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.core.app.ActivityOptionsCompat
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

class ActivityResultRegistry.3
extends ActivityResultLauncher<I> {
    final ActivityResultRegistry this$0;
    final ActivityResultContract val$contract;
    final String val$key;
    final int val$requestCode;

    ActivityResultRegistry.3(ActivityResultRegistry activityResultRegistry, String string, int n, ActivityResultContract activityResultContract) {
        this.this$0 = activityResultRegistry;
        this.val$key = string;
        this.val$requestCode = n;
        this.val$contract = activityResultContract;
    }

    public ActivityResultContract<I, ?> getContract() {
        return this.val$contract;
    }

    public void launch(I i, ActivityOptionsCompat activityOptionsCompat) {
        this.this$0.mLaunchedKeys.add(this.val$key);
        Integer n = (Integer)this.this$0.mKeyToRc.get(this.val$key);
        ActivityResultRegistry activityResultRegistry = this.this$0;
        int n2 = n != null ? n : this.val$requestCode;
        activityResultRegistry.onLaunch(n2, this.val$contract, i, activityOptionsCompat);
    }

    public void unregister() {
        this.this$0.unregister(this.val$key);
    }
}
