/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.ComponentActivity$2
 *  androidx.activity.result.contract.ActivityResultContract$SynchronousResult
 */
package androidx.activity;

import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContract;

class ComponentActivity.1
implements Runnable {
    final ComponentActivity.2 this$1;
    final int val$requestCode;
    final ActivityResultContract.SynchronousResult val$synchronousResult;

    ComponentActivity.1(ComponentActivity.2 var1_1, int n, ActivityResultContract.SynchronousResult synchronousResult) {
        this.this$1 = var1_1;
        this.val$requestCode = n;
        this.val$synchronousResult = synchronousResult;
    }

    @Override
    public void run() {
        this.this$1.dispatchResult(this.val$requestCode, this.val$synchronousResult.getValue());
    }
}
