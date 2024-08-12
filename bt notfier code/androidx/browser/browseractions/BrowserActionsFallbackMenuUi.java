/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent$CanceledException
 *  android.content.Context
 *  android.content.DialogInterface$OnShowListener
 *  android.net.Uri
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 *  androidx.browser.R$id
 *  androidx.browser.R$layout
 *  androidx.browser.browseractions.BrowserActionItem
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuDialog
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuUi$BrowserActionsFallMenuUiListener
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuView
 */
package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.browser.browseractions.BrowserActionItem;
import androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter;
import androidx.browser.browseractions.BrowserActionsFallbackMenuDialog;
import androidx.browser.browseractions.BrowserActionsFallbackMenuUi;
import androidx.browser.browseractions.BrowserActionsFallbackMenuView;
import java.util.List;

class BrowserActionsFallbackMenuUi
implements AdapterView.OnItemClickListener {
    private static final String TAG = "BrowserActionskMenuUi";
    private BrowserActionsFallbackMenuDialog mBrowserActionsDialog;
    private final Context mContext;
    private final List<BrowserActionItem> mMenuItems;
    BrowserActionsFallMenuUiListener mMenuUiListener;
    private final Uri mUri;

    BrowserActionsFallbackMenuUi(Context context, Uri uri, List<BrowserActionItem> list) {
        this.mContext = context;
        this.mUri = uri;
        this.mMenuItems = list;
    }

    private BrowserActionsFallbackMenuView initMenuView(View view) {
        BrowserActionsFallbackMenuView browserActionsFallbackMenuView = (BrowserActionsFallbackMenuView)view.findViewById(R.id.browser_actions_menu_view);
        TextView textView = (TextView)view.findViewById(R.id.browser_actions_header_text);
        textView.setText((CharSequence)this.mUri.toString());
        textView.setOnClickListener((View.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
        view = (ListView)view.findViewById(R.id.browser_actions_menu_items);
        view.setAdapter((ListAdapter)new BrowserActionsFallbackMenuAdapter(this.mMenuItems, this.mContext));
        view.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        return browserActionsFallbackMenuView;
    }

    public void displayMenu() {
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog;
        View view = LayoutInflater.from((Context)this.mContext).inflate(R.layout.browser_actions_context_menu_page, null);
        this.mBrowserActionsDialog = browserActionsFallbackMenuDialog = new BrowserActionsFallbackMenuDialog(this.mContext, (View)this.initMenuView(view));
        browserActionsFallbackMenuDialog.setContentView(view);
        if (this.mMenuUiListener != null) {
            this.mBrowserActionsDialog.setOnShowListener((DialogInterface.OnShowListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        this.mBrowserActionsDialog.show();
    }

    public void onItemClick(AdapterView<?> pendingIntent, View view, int n, long l) {
        pendingIntent = this.mMenuItems.get(n).getAction();
        try {
            pendingIntent.send();
            this.mBrowserActionsDialog.dismiss();
        }
        catch (PendingIntent.CanceledException canceledException) {
            Log.e((String)TAG, (String)"Failed to send custom item action", (Throwable)canceledException);
        }
    }

    void setMenuUiListener(BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener) {
        this.mMenuUiListener = browserActionsFallMenuUiListener;
    }
}
