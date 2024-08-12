/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.browser.R$id
 *  androidx.browser.R$layout
 *  androidx.browser.browseractions.BrowserActionItem
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter$ViewHolderItem
 *  androidx.core.content.res.ResourcesCompat
 */
package androidx.browser.browseractions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.browser.browseractions.BrowserActionItem;
import androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter;
import androidx.core.content.res.ResourcesCompat;
import java.util.List;

class BrowserActionsFallbackMenuAdapter
extends BaseAdapter {
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;

    BrowserActionsFallbackMenuAdapter(List<BrowserActionItem> list, Context context) {
        this.mMenuItems = list;
        this.mContext = context;
    }

    public int getCount() {
        return this.mMenuItems.size();
    }

    public Object getItem(int n) {
        return this.mMenuItems.get(n);
    }

    public long getItemId(int n) {
        return n;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        BrowserActionItem browserActionItem = this.mMenuItems.get(n);
        if (view == null) {
            view = LayoutInflater.from((Context)this.mContext).inflate(R.layout.browser_actions_context_menu_row, null);
            viewGroup = new ViewHolderItem();
            viewGroup.mIcon = (ImageView)view.findViewById(R.id.browser_actions_menu_item_icon);
            viewGroup.mText = (TextView)view.findViewById(R.id.browser_actions_menu_item_text);
            view.setTag((Object)viewGroup);
        } else {
            viewGroup = (ViewHolderItem)view.getTag();
        }
        viewGroup.mText.setText((CharSequence)browserActionItem.getTitle());
        if (browserActionItem.getIconId() != 0) {
            browserActionItem = ResourcesCompat.getDrawable((Resources)this.mContext.getResources(), (int)browserActionItem.getIconId(), null);
            viewGroup.mIcon.setImageDrawable((Drawable)browserActionItem);
        } else {
            viewGroup.mIcon.setImageDrawable(null);
        }
        return view;
    }
}
