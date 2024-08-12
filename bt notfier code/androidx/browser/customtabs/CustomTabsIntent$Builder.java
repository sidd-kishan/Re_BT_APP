/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcelable
 *  android.widget.RemoteViews
 *  androidx.browser.customtabs.CustomTabsIntent
 *  androidx.browser.customtabs.CustomTabsSession
 *  androidx.core.app.ActivityOptionsCompat
 *  androidx.core.app.BundleCompat
 */
package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.widget.RemoteViews;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.BundleCompat;
import java.util.ArrayList;

public static final class CustomTabsIntent.Builder {
    private ArrayList<Bundle> mActionButtons;
    private boolean mInstantAppsEnabled;
    private final Intent mIntent;
    private ArrayList<Bundle> mMenuItems;
    private Bundle mStartAnimationBundle;

    public CustomTabsIntent.Builder() {
        this(null);
    }

    public CustomTabsIntent.Builder(CustomTabsSession object) {
        Intent intent;
        this.mIntent = intent = new Intent("android.intent.action.VIEW");
        Object var2_3 = null;
        this.mMenuItems = null;
        this.mStartAnimationBundle = null;
        this.mActionButtons = null;
        this.mInstantAppsEnabled = true;
        if (object != null) {
            intent.setPackage(object.getComponentName().getPackageName());
        }
        intent = new Bundle();
        object = object == null ? var2_3 : object.getBinder();
        BundleCompat.putBinder((Bundle)intent, (String)"android.support.customtabs.extra.SESSION", (IBinder)object);
        this.mIntent.putExtras((Bundle)intent);
    }

    public CustomTabsIntent.Builder addDefaultShareMenuItem() {
        this.mIntent.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
        return this;
    }

    public CustomTabsIntent.Builder addMenuItem(String string, PendingIntent pendingIntent) {
        if (this.mMenuItems == null) {
            this.mMenuItems = new ArrayList();
        }
        Bundle bundle = new Bundle();
        bundle.putString("android.support.customtabs.customaction.MENU_ITEM_TITLE", string);
        bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", (Parcelable)pendingIntent);
        this.mMenuItems.add(bundle);
        return this;
    }

    @Deprecated
    public CustomTabsIntent.Builder addToolbarItem(int n, Bitmap bitmap, String string, PendingIntent pendingIntent) throws IllegalStateException {
        if (this.mActionButtons == null) {
            this.mActionButtons = new ArrayList();
        }
        if (this.mActionButtons.size() >= 5) throw new IllegalStateException("Exceeded maximum toolbar item count of 5");
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.customtabs.customaction.ID", n);
        bundle.putParcelable("android.support.customtabs.customaction.ICON", (Parcelable)bitmap);
        bundle.putString("android.support.customtabs.customaction.DESCRIPTION", string);
        bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", (Parcelable)pendingIntent);
        this.mActionButtons.add(bundle);
        return this;
    }

    public CustomTabsIntent build() {
        ArrayList<Bundle> arrayList = this.mMenuItems;
        if (arrayList != null) {
            this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
        }
        if ((arrayList = this.mActionButtons) != null) {
            this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList);
        }
        this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.mInstantAppsEnabled);
        return new CustomTabsIntent(this.mIntent, this.mStartAnimationBundle);
    }

    public CustomTabsIntent.Builder enableUrlBarHiding() {
        this.mIntent.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", true);
        return this;
    }

    public CustomTabsIntent.Builder setActionButton(Bitmap bitmap, String string, PendingIntent pendingIntent) {
        return this.setActionButton(bitmap, string, pendingIntent, false);
    }

    public CustomTabsIntent.Builder setActionButton(Bitmap bitmap, String string, PendingIntent pendingIntent, boolean bl) {
        Bundle bundle = new Bundle();
        bundle.putInt("android.support.customtabs.customaction.ID", 0);
        bundle.putParcelable("android.support.customtabs.customaction.ICON", (Parcelable)bitmap);
        bundle.putString("android.support.customtabs.customaction.DESCRIPTION", string);
        bundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", (Parcelable)pendingIntent);
        this.mIntent.putExtra("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", bundle);
        this.mIntent.putExtra("android.support.customtabs.extra.TINT_ACTION_BUTTON", bl);
        return this;
    }

    public CustomTabsIntent.Builder setCloseButtonIcon(Bitmap bitmap) {
        this.mIntent.putExtra("android.support.customtabs.extra.CLOSE_BUTTON_ICON", (Parcelable)bitmap);
        return this;
    }

    public CustomTabsIntent.Builder setExitAnimations(Context context, int n, int n2) {
        context = ActivityOptionsCompat.makeCustomAnimation((Context)context, (int)n, (int)n2).toBundle();
        this.mIntent.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", (Bundle)context);
        return this;
    }

    public CustomTabsIntent.Builder setInstantAppsEnabled(boolean bl) {
        this.mInstantAppsEnabled = bl;
        return this;
    }

    public CustomTabsIntent.Builder setSecondaryToolbarColor(int n) {
        this.mIntent.putExtra("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", n);
        return this;
    }

    public CustomTabsIntent.Builder setSecondaryToolbarViews(RemoteViews remoteViews, int[] nArray, PendingIntent pendingIntent) {
        this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS", (Parcelable)remoteViews);
        this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_VIEW_IDS", nArray);
        this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_REMOTEVIEWS_PENDINGINTENT", (Parcelable)pendingIntent);
        return this;
    }

    public CustomTabsIntent.Builder setShowTitle(boolean bl) {
        this.mIntent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", bl ? 1 : 0);
        return this;
    }

    public CustomTabsIntent.Builder setStartAnimations(Context context, int n, int n2) {
        this.mStartAnimationBundle = ActivityOptionsCompat.makeCustomAnimation((Context)context, (int)n, (int)n2).toBundle();
        return this;
    }

    public CustomTabsIntent.Builder setToolbarColor(int n) {
        this.mIntent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", n);
        return this;
    }
}
