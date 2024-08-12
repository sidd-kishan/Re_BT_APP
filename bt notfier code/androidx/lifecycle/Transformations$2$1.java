/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Observer
 *  androidx.lifecycle.Transformations$2
 */
package androidx.lifecycle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;

class Transformations.1
implements Observer<Y> {
    final Transformations.2 this$0;

    Transformations.1(Transformations.2 var1_1) {
        this.this$0 = var1_1;
    }

    public void onChanged(Y y) {
        this.this$0.val$result.setValue(y);
    }
}
