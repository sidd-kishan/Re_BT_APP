/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 */
package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

class ResourcesCompat.FontCallback.2
implements Runnable {
    final ResourcesCompat.FontCallback this$0;
    final int val$reason;

    ResourcesCompat.FontCallback.2(ResourcesCompat.FontCallback fontCallback, int n) {
        this.this$0 = fontCallback;
        this.val$reason = n;
    }

    @Override
    public void run() {
        this.this$0.onFontRetrievalFailed(this.val$reason);
    }
}
