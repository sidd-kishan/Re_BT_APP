/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.FragmentAnim$2
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentAnim;

class FragmentAnim.1
implements Runnable {
    final FragmentAnim.2 this$0;

    FragmentAnim.1(FragmentAnim.2 var1_1) {
        this.this$0 = var1_1;
    }

    @Override
    public void run() {
        if (this.this$0.val$fragment.getAnimatingAway() == null) return;
        this.this$0.val$fragment.setAnimatingAway(null);
        this.this$0.val$callback.onComplete(this.this$0.val$fragment, this.this$0.val$signal);
    }
}
