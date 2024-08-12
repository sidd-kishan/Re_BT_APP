/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.TabHost$TabContentFactory
 */
package androidx.fragment.app;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

static class FragmentTabHost.DummyTabFactory
implements TabHost.TabContentFactory {
    private final Context mContext;

    public FragmentTabHost.DummyTabFactory(Context context) {
        this.mContext = context;
    }

    public View createTabContent(String string) {
        string = new View(this.mContext);
        string.setMinimumWidth(0);
        string.setMinimumHeight(0);
        return string;
    }
}
