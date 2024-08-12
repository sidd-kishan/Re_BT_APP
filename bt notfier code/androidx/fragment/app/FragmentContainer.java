/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

public abstract class FragmentContainer {
    @Deprecated
    public Fragment instantiate(Context context, String string, Bundle bundle) {
        return Fragment.instantiate((Context)context, (String)string, (Bundle)bundle);
    }

    public abstract View onFindViewById(int var1);

    public abstract boolean onHasView();
}
