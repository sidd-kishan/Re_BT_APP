/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  butterknife.internal._$$Lambda$DebouncingOnClickListener$EDavjG1Da3G8JTdFPVGk_7OErB8
 */
package butterknife.internal;

import android.view.View;
import butterknife.internal._$;

public abstract class DebouncingOnClickListener
implements View.OnClickListener {
    private static final Runnable ENABLE_AGAIN = _$.Lambda.DebouncingOnClickListener.EDavjG1Da3G8JTdFPVGk_7OErB8.INSTANCE;
    static boolean enabled = true;

    static /* synthetic */ void lambda$static$0() {
        enabled = true;
    }

    public abstract void doClick(View var1);

    public final void onClick(View view) {
        if (!enabled) return;
        enabled = false;
        view.post(ENABLE_AGAIN);
        this.doClick(view);
    }
}
