/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public interface LayoutInflaterFactory {
    public View onCreateView(View var1, String var2, Context var3, AttributeSet var4);
}