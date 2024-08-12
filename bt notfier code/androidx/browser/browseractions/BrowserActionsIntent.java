/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  androidx.browser.browseractions.BrowserActionItem
 *  androidx.browser.browseractions.BrowserActionsFallbackMenuUi
 *  androidx.browser.browseractions.BrowserActionsIntent$BrowserActionsFallDialogListener
 *  androidx.browser.browseractions.BrowserActionsIntent$Builder
 *  androidx.core.content.ContextCompat
 */
package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.browseractions.BrowserActionItem;
import androidx.browser.browseractions.BrowserActionsFallbackMenuUi;
import androidx.browser.browseractions.BrowserActionsIntent;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;

public class BrowserActionsIntent {
    public static final String ACTION_BROWSER_ACTIONS_OPEN = "androidx.browser.browseractions.browser_action_open";
    public static final String EXTRA_APP_ID = "androidx.browser.browseractions.APP_ID";
    public static final String EXTRA_MENU_ITEMS = "androidx.browser.browseractions.extra.MENU_ITEMS";
    public static final String EXTRA_SELECTED_ACTION_PENDING_INTENT = "androidx.browser.browseractions.extra.SELECTED_ACTION_PENDING_INTENT";
    public static final String EXTRA_TYPE = "androidx.browser.browseractions.extra.TYPE";
    public static final int ITEM_COPY = 3;
    public static final int ITEM_DOWNLOAD = 2;
    public static final int ITEM_INVALID_ITEM = -1;
    public static final int ITEM_OPEN_IN_INCOGNITO = 1;
    public static final int ITEM_OPEN_IN_NEW_TAB = 0;
    public static final int ITEM_SHARE = 4;
    public static final String KEY_ACTION = "androidx.browser.browseractions.ACTION";
    public static final String KEY_ICON_ID = "androidx.browser.browseractions.ICON_ID";
    public static final String KEY_TITLE = "androidx.browser.browseractions.TITLE";
    public static final int MAX_CUSTOM_ITEMS = 5;
    private static final String TAG = "BrowserActions";
    private static final String TEST_URL = "https://www.example.com";
    public static final int URL_TYPE_AUDIO = 3;
    public static final int URL_TYPE_FILE = 4;
    public static final int URL_TYPE_IMAGE = 1;
    public static final int URL_TYPE_NONE = 0;
    public static final int URL_TYPE_PLUGIN = 5;
    public static final int URL_TYPE_VIDEO = 2;
    private static BrowserActionsFallDialogListener sDialogListenter;
    private final Intent mIntent;

    BrowserActionsIntent(Intent intent) {
        this.mIntent = intent;
    }

    private static List<ResolveInfo> getBrowserActionsIntentHandlers(Context context) {
        Intent intent = new Intent(ACTION_BROWSER_ACTIONS_OPEN, Uri.parse((String)TEST_URL));
        return context.getPackageManager().queryIntentActivities(intent, 131072);
    }

    public static String getCreatorPackageName(Intent intent) {
        if ((intent = (PendingIntent)intent.getParcelableExtra(EXTRA_APP_ID)) == null) return null;
        if (Build.VERSION.SDK_INT < 17) return intent.getTargetPackage();
        return intent.getCreatorPackage();
    }

    public static void launchIntent(Context context, Intent intent) {
        BrowserActionsIntent.launchIntent(context, intent, BrowserActionsIntent.getBrowserActionsIntentHandlers(context));
    }

    static void launchIntent(Context context, Intent intent, List<ResolveInfo> list) {
        block3: {
            Object object;
            block4: {
                block1: {
                    block2: {
                        if (list == null || list.size() == 0) break block1;
                        int n = list.size();
                        if (n != 1) break block2;
                        intent.setPackage(list.get((int)0).activityInfo.packageName);
                        break block3;
                    }
                    object = new Intent("android.intent.action.VIEW", Uri.parse((String)TEST_URL));
                    object = context.getPackageManager().resolveActivity((Intent)object, 65536);
                    if (object == null) break block3;
                    object = ((ResolveInfo)object).activityInfo.packageName;
                    break block4;
                }
                BrowserActionsIntent.openFallbackBrowserActionsMenu(context, intent);
                return;
            }
            for (int i = 0; i < list.size(); ++i) {
                if (!((String)object).equals(list.get((int)i).activityInfo.packageName)) continue;
                intent.setPackage((String)object);
                break;
            }
        }
        ContextCompat.startActivity((Context)context, (Intent)intent, null);
    }

    public static void openBrowserAction(Context context, Uri uri) {
        BrowserActionsIntent.launchIntent(context, new Builder(context, uri).build().getIntent());
    }

    public static void openBrowserAction(Context context, Uri uri, int n, ArrayList<BrowserActionItem> arrayList, PendingIntent pendingIntent) {
        BrowserActionsIntent.launchIntent(context, new Builder(context, uri).setUrlType(n).setCustomItems(arrayList).setOnItemSelectedAction(pendingIntent).build().getIntent());
    }

    private static void openFallbackBrowserActionsMenu(Context context, Intent object) {
        Uri uri = object.getData();
        int n = object.getIntExtra(EXTRA_TYPE, 0);
        object = (object = object.getParcelableArrayListExtra(EXTRA_MENU_ITEMS)) != null ? BrowserActionsIntent.parseBrowserActionItems((ArrayList<Bundle>)object) : null;
        BrowserActionsIntent.openFallbackBrowserActionsMenu(context, uri, n, (List<BrowserActionItem>)object);
    }

    private static void openFallbackBrowserActionsMenu(Context context, Uri uri, int n, List<BrowserActionItem> list) {
        new BrowserActionsFallbackMenuUi(context, uri, list).displayMenu();
        context = sDialogListenter;
        if (context == null) return;
        context.onDialogShown();
    }

    public static List<BrowserActionItem> parseBrowserActionItems(ArrayList<Bundle> arrayList) {
        ArrayList<BrowserActionItem> arrayList2 = new ArrayList<BrowserActionItem>();
        int n = 0;
        while (n < arrayList.size()) {
            Bundle bundle = arrayList.get(n);
            String string = bundle.getString(KEY_TITLE);
            PendingIntent pendingIntent = (PendingIntent)bundle.getParcelable(KEY_ACTION);
            int n2 = bundle.getInt(KEY_ICON_ID);
            if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            if (pendingIntent == null) throw new IllegalArgumentException("Custom item should contain a non-empty title and non-null intent.");
            arrayList2.add(new BrowserActionItem(string, pendingIntent, n2));
            ++n;
        }
        return arrayList2;
    }

    static void setDialogShownListenter(BrowserActionsFallDialogListener browserActionsFallDialogListener) {
        sDialogListenter = browserActionsFallDialogListener;
    }

    public Intent getIntent() {
        return this.mIntent;
    }
}
