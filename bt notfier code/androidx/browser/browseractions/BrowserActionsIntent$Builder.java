/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  androidx.browser.browseractions.BrowserActionItem
 *  androidx.browser.browseractions.BrowserActionsIntent
 */
package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.browser.browseractions.BrowserActionItem;
import androidx.browser.browseractions.BrowserActionsIntent;
import java.util.ArrayList;
import java.util.Arrays;

public static final class BrowserActionsIntent.Builder {
    private Context mContext;
    private final Intent mIntent = new Intent("androidx.browser.browseractions.browser_action_open");
    private ArrayList<Bundle> mMenuItems = null;
    private PendingIntent mOnItemSelectedPendingIntent = null;
    private int mType;
    private Uri mUri;

    public BrowserActionsIntent.Builder(Context context, Uri uri) {
        this.mContext = context;
        this.mUri = uri;
        this.mType = 0;
        this.mMenuItems = new ArrayList();
    }

    private Bundle getBundleFromItem(BrowserActionItem browserActionItem) {
        Bundle bundle = new Bundle();
        bundle.putString("androidx.browser.browseractions.TITLE", browserActionItem.getTitle());
        bundle.putParcelable("androidx.browser.browseractions.ACTION", (Parcelable)browserActionItem.getAction());
        if (browserActionItem.getIconId() == 0) return bundle;
        bundle.putInt("androidx.browser.browseractions.ICON_ID", browserActionItem.getIconId());
        return bundle;
    }

    public BrowserActionsIntent build() {
        this.mIntent.setData(this.mUri);
        this.mIntent.putExtra("androidx.browser.browseractions.extra.TYPE", this.mType);
        this.mIntent.putParcelableArrayListExtra("androidx.browser.browseractions.extra.MENU_ITEMS", this.mMenuItems);
        PendingIntent pendingIntent = PendingIntent.getActivity((Context)this.mContext, (int)0, (Intent)new Intent(), (int)0);
        this.mIntent.putExtra("androidx.browser.browseractions.APP_ID", (Parcelable)pendingIntent);
        pendingIntent = this.mOnItemSelectedPendingIntent;
        if (pendingIntent == null) return new BrowserActionsIntent(this.mIntent);
        this.mIntent.putExtra("androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT", (Parcelable)pendingIntent);
        return new BrowserActionsIntent(this.mIntent);
    }

    public BrowserActionsIntent.Builder setCustomItems(ArrayList<BrowserActionItem> serializable) {
        if (((ArrayList)serializable).size() > 5) {
            serializable = new IllegalStateException("Exceeded maximum toolbar item count of 5");
            throw serializable;
        }
        int n = 0;
        while (n < ((ArrayList)serializable).size()) {
            if (TextUtils.isEmpty((CharSequence)((BrowserActionItem)((ArrayList)serializable).get(n)).getTitle())) throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            if (((BrowserActionItem)((ArrayList)serializable).get(n)).getAction() == null) throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            this.mMenuItems.add(this.getBundleFromItem((BrowserActionItem)((ArrayList)serializable).get(n)));
            ++n;
        }
        return this;
    }

    public BrowserActionsIntent.Builder setCustomItems(BrowserActionItem ... browserActionItemArray) {
        return this.setCustomItems(new ArrayList<BrowserActionItem>(Arrays.asList(browserActionItemArray)));
    }

    public BrowserActionsIntent.Builder setOnItemSelectedAction(PendingIntent pendingIntent) {
        this.mOnItemSelectedPendingIntent = pendingIntent;
        return this;
    }

    public BrowserActionsIntent.Builder setUrlType(int n) {
        this.mType = n;
        return this;
    }
}
