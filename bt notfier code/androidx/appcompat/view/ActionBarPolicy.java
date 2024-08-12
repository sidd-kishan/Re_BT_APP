/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.view.ViewConfiguration
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$bool
 *  androidx.appcompat.R$dimen
 *  androidx.appcompat.R$styleable
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.R;

public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public boolean enableHomeButtonByDefault() {
        boolean bl = this.mContext.getApplicationInfo().targetSdkVersion < 14;
        return bl;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int n = configuration.screenWidthDp;
        int n2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600) return 5;
        if (n > 600) return 5;
        if (n > 960) {
            if (n2 > 720) return 5;
        }
        if (n > 720 && n2 > 960) {
            return 5;
        }
        if (n >= 500) return 4;
        if (n > 640) {
            if (n2 > 480) return 4;
        }
        if (n > 480 && n2 > 640) {
            return 4;
        }
        if (n < 360) return 2;
        return 3;
    }

    public int getStackedTabMaxWidth() {
        return this.mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
    }

    public int getTabContainerHeight() {
        TypedArray typedArray = this.mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        int n = typedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
        Resources resources = this.mContext.getResources();
        int n2 = n;
        if (!this.hasEmbeddedTabs()) {
            n2 = Math.min(n, resources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
        }
        typedArray.recycle();
        return n2;
    }

    public boolean hasEmbeddedTabs() {
        return this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }

    public boolean showsOverflowMenuButton() {
        if (Build.VERSION.SDK_INT < 19) return ViewConfiguration.get((Context)this.mContext).hasPermanentMenuKey() ^ true;
        return true;
    }
}
