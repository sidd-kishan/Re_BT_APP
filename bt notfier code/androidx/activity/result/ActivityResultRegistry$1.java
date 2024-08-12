/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.ActivityResult
 *  androidx.activity.result.ActivityResultCallback
 *  androidx.activity.result.ActivityResultRegistry
 *  androidx.activity.result.ActivityResultRegistry$CallbackAndContract
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleEventObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class ActivityResultRegistry.1
implements LifecycleEventObserver {
    final ActivityResultRegistry this$0;
    final ActivityResultCallback val$callback;
    final ActivityResultContract val$contract;
    final String val$key;

    ActivityResultRegistry.1(ActivityResultRegistry activityResultRegistry, String string, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.this$0 = activityResultRegistry;
        this.val$key = string;
        this.val$callback = activityResultCallback;
        this.val$contract = activityResultContract;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle.Event event) {
        if (Lifecycle.Event.ON_START.equals((Object)event)) {
            this.this$0.mKeyToCallback.put(this.val$key, new ActivityResultRegistry.CallbackAndContract(this.val$callback, this.val$contract));
            if (this.this$0.mParsedPendingResults.containsKey(this.val$key)) {
                object = this.this$0.mParsedPendingResults.get(this.val$key);
                this.this$0.mParsedPendingResults.remove(this.val$key);
                this.val$callback.onActivityResult(object);
            }
            if ((object = (ActivityResult)this.this$0.mPendingResults.getParcelable(this.val$key)) == null) return;
            this.this$0.mPendingResults.remove(this.val$key);
            this.val$callback.onActivityResult(this.val$contract.parseResult(object.getResultCode(), object.getData()));
        } else if (Lifecycle.Event.ON_STOP.equals((Object)event)) {
            this.this$0.mKeyToCallback.remove(this.val$key);
        } else {
            if (!Lifecycle.Event.ON_DESTROY.equals((Object)event)) return;
            this.this$0.unregister(this.val$key);
        }
    }
}
