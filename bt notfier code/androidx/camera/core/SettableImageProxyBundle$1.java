/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageProxy
 *  androidx.camera.core.SettableImageProxyBundle
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 */
package androidx.camera.core;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.SettableImageProxyBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter;

class SettableImageProxyBundle.1
implements CallbackToFutureAdapter.Resolver<ImageProxy> {
    final SettableImageProxyBundle this$0;
    final int val$captureId;

    SettableImageProxyBundle.1(SettableImageProxyBundle settableImageProxyBundle, int n) {
        this.this$0 = settableImageProxyBundle;
        this.val$captureId = n;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public Object attachCompleter(CallbackToFutureAdapter.Completer<ImageProxy> object) {
        Object object2 = this.this$0.mLock;
        synchronized (object2) {
            this.this$0.mCompleters.put(this.val$captureId, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getImageProxy(id: ");
        ((StringBuilder)object).append(this.val$captureId);
        ((StringBuilder)object).append(")");
        return ((StringBuilder)object).toString();
    }
}
