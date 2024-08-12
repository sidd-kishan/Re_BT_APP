/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.os.Build$VERSION
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$string
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.widget.ActivityChooserModel
 *  androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener
 *  androidx.appcompat.widget.ActivityChooserView
 *  androidx.appcompat.widget.ShareActionProvider$OnShareTargetSelectedListener
 *  androidx.appcompat.widget.ShareActionProvider$ShareActivityChooserModelPolicy
 *  androidx.appcompat.widget.ShareActionProvider$ShareMenuItemOnMenuItemClickListener
 *  androidx.core.view.ActionProvider
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.ActionProvider;

public class ShareActionProvider
extends ActionProvider {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount = 4;
    private ActivityChooserModel.OnChooseActivityListener mOnChooseActivityListener;
    private final ShareMenuItemOnMenuItemClickListener mOnMenuItemClickListener = new ShareMenuItemOnMenuItemClickListener(this);
    OnShareTargetSelectedListener mOnShareTargetSelectedListener;
    String mShareHistoryFileName = "share_history.xml";

    public ShareActionProvider(Context context) {
        super(context);
        this.mContext = context;
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener == null) {
            return;
        }
        if (this.mOnChooseActivityListener == null) {
            this.mOnChooseActivityListener = new ShareActivityChooserModelPolicy(this);
        }
        ActivityChooserModel.get((Context)this.mContext, (String)this.mShareHistoryFileName).setOnChooseActivityListener(this.mOnChooseActivityListener);
    }

    public boolean hasSubMenu() {
        return true;
    }

    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.get((Context)this.mContext, (String)this.mShareHistoryFileName));
        }
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable((Context)this.mContext, (int)typedValue.resourceId));
        activityChooserView.setProvider((ActionProvider)this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        ResolveInfo resolveInfo;
        int n;
        subMenu.clear();
        ActivityChooserModel activityChooserModel = ActivityChooserModel.get((Context)this.mContext, (String)this.mShareHistoryFileName);
        PackageManager packageManager = this.mContext.getPackageManager();
        int n2 = activityChooserModel.getActivityCount();
        int n3 = Math.min(n2, this.mMaxShownActivityCount);
        for (n = 0; n < n3; ++n) {
            resolveInfo = activityChooserModel.getActivity(n);
            subMenu.add(0, n, n, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)this.mOnMenuItemClickListener);
        }
        if (n3 >= n2) return;
        subMenu = subMenu.addSubMenu(0, n3, n3, (CharSequence)this.mContext.getString(R.string.abc_activity_chooser_view_see_all));
        n = 0;
        while (n < n2) {
            resolveInfo = activityChooserModel.getActivity(n);
            subMenu.add(0, n, n, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)this.mOnMenuItemClickListener);
            ++n;
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.mOnShareTargetSelectedListener = onShareTargetSelectedListener;
        this.setActivityChooserPolicyIfNeeded();
    }

    public void setShareHistoryFileName(String string2) {
        this.mShareHistoryFileName = string2;
        this.setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent) {
        String string2;
        if (intent != null && ("android.intent.action.SEND".equals(string2 = intent.getAction()) || "android.intent.action.SEND_MULTIPLE".equals(string2))) {
            this.updateIntent(intent);
        }
        ActivityChooserModel.get((Context)this.mContext, (String)this.mShareHistoryFileName).setIntent(intent);
    }

    void updateIntent(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(0x8080000);
        } else {
            intent.addFlags(524288);
        }
    }
}
