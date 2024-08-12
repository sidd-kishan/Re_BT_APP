/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.appcompat.app.AppCompatDelegateImpl
 */
package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegateImpl;

class AppCompatDelegateImpl.2
implements Runnable {
    final AppCompatDelegateImpl this$0;

    AppCompatDelegateImpl.2(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override
    public void run() {
        if ((this.this$0.mInvalidatePanelMenuFeatures & 1) != 0) {
            this.this$0.doInvalidatePanelMenu(0);
        }
        if ((this.this$0.mInvalidatePanelMenuFeatures & 0x1000) != 0) {
            this.this$0.doInvalidatePanelMenu(108);
        }
        this.this$0.mInvalidatePanelMenuPosted = false;
        this.this$0.mInvalidatePanelMenuFeatures = 0;
    }
}
