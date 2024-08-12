/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.view.LayoutInflater
 *  androidx.appcompat.view.ContextThemeWrapper
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.view.ContextThemeWrapper;

public static final class ThemedSpinnerAdapter.Helper {
    private final Context mContext;
    private LayoutInflater mDropDownInflater;
    private final LayoutInflater mInflater;

    public ThemedSpinnerAdapter.Helper(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from((Context)context);
    }

    public LayoutInflater getDropDownViewInflater() {
        LayoutInflater layoutInflater = this.mDropDownInflater;
        if (layoutInflater != null) return layoutInflater;
        layoutInflater = this.mInflater;
        return layoutInflater;
    }

    public Resources.Theme getDropDownViewTheme() {
        Object object = this.mDropDownInflater;
        object = object == null ? null : object.getContext().getTheme();
        return object;
    }

    public void setDropDownViewTheme(Resources.Theme theme) {
        this.mDropDownInflater = theme == null ? null : (theme == this.mContext.getTheme() ? this.mInflater : LayoutInflater.from((Context)new ContextThemeWrapper(this.mContext, theme)));
    }
}
