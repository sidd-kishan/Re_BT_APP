/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.activity.result.contract.ActivityResultContract
 *  androidx.core.app.ActivityOptionsCompat
 */
package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

public abstract class ActivityResultLauncher<I> {
    public abstract ActivityResultContract<I, ?> getContract();

    public void launch(I i) {
        this.launch(i, null);
    }

    public abstract void launch(I var1, ActivityOptionsCompat var2);

    public abstract void unregister();
}
