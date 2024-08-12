/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  androidx.appcompat.widget.ActivityChooserModel
 *  androidx.appcompat.widget.ShareActionProvider
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ShareActionProvider;

private class ShareActionProvider.ShareMenuItemOnMenuItemClickListener
implements MenuItem.OnMenuItemClickListener {
    final ShareActionProvider this$0;

    ShareActionProvider.ShareMenuItemOnMenuItemClickListener(ShareActionProvider shareActionProvider) {
        this.this$0 = shareActionProvider;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        menuItem = ActivityChooserModel.get((Context)this.this$0.mContext, (String)this.this$0.mShareHistoryFileName).chooseActivity(menuItem.getItemId());
        if (menuItem == null) return true;
        String string = menuItem.getAction();
        if ("android.intent.action.SEND".equals(string) || "android.intent.action.SEND_MULTIPLE".equals(string)) {
            this.this$0.updateIntent((Intent)menuItem);
        }
        this.this$0.mContext.startActivity((Intent)menuItem);
        return true;
    }
}
