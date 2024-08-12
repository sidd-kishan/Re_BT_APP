/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.ImageView
 *  android.widget.TextView
 *  androidx.appcompat.R$id
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.R$string
 *  androidx.appcompat.widget.ActivityChooserModel
 *  androidx.appcompat.widget.ActivityChooserView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;

private class ActivityChooserView.ActivityChooserViewAdapter
extends BaseAdapter {
    private static final int ITEM_VIEW_TYPE_ACTIVITY = 0;
    private static final int ITEM_VIEW_TYPE_COUNT = 3;
    private static final int ITEM_VIEW_TYPE_FOOTER = 1;
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = Integer.MAX_VALUE;
    private ActivityChooserModel mDataModel;
    private boolean mHighlightDefaultActivity;
    private int mMaxActivityCount;
    private boolean mShowDefaultActivity;
    private boolean mShowFooterView;
    final ActivityChooserView this$0;

    ActivityChooserView.ActivityChooserViewAdapter(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
        this.mMaxActivityCount = 4;
    }

    public int getActivityCount() {
        return this.mDataModel.getActivityCount();
    }

    public int getCount() {
        int n;
        int n2 = n = this.mDataModel.getActivityCount();
        if (!this.mShowDefaultActivity) {
            n2 = n;
            if (this.mDataModel.getDefaultActivity() != null) {
                n2 = n - 1;
            }
        }
        n2 = n = Math.min(n2, this.mMaxActivityCount);
        if (!this.mShowFooterView) return n2;
        n2 = n + 1;
        return n2;
    }

    public ActivityChooserModel getDataModel() {
        return this.mDataModel;
    }

    public ResolveInfo getDefaultActivity() {
        return this.mDataModel.getDefaultActivity();
    }

    public int getHistorySize() {
        return this.mDataModel.getHistorySize();
    }

    public Object getItem(int n) {
        int n2 = this.getItemViewType(n);
        if (n2 != 0) {
            if (n2 != 1) throw new IllegalArgumentException();
            return null;
        }
        n2 = n;
        if (this.mShowDefaultActivity) return this.mDataModel.getActivity(n2);
        n2 = n;
        if (this.mDataModel.getDefaultActivity() == null) return this.mDataModel.getActivity(n2);
        n2 = n + 1;
        return this.mDataModel.getActivity(n2);
    }

    public long getItemId(int n) {
        return n;
    }

    public int getItemViewType(int n) {
        if (!this.mShowFooterView) return 0;
        if (n != this.getCount() - 1) return 0;
        return 1;
    }

    public boolean getShowDefaultActivity() {
        return this.mShowDefaultActivity;
    }

    public View getView(int n, View view, ViewGroup viewGroup) {
        View view2;
        block8: {
            block7: {
                int n2 = this.getItemViewType(n);
                if (n2 != 0) {
                    View view3;
                    if (n2 != 1) throw new IllegalArgumentException();
                    if (view != null) {
                        view3 = view;
                        if (view.getId() == 1) return view3;
                    }
                    view3 = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    view3.setId(1);
                    ((TextView)view3.findViewById(R.id.title)).setText((CharSequence)this.this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
                    return view3;
                }
                if (view == null) break block7;
                view2 = view;
                if (view.getId() == R.id.list_item) break block8;
            }
            view2 = LayoutInflater.from((Context)this.this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
        }
        viewGroup = this.this$0.getContext().getPackageManager();
        ImageView imageView = (ImageView)view2.findViewById(R.id.icon);
        view = (ResolveInfo)this.getItem(n);
        imageView.setImageDrawable(view.loadIcon((PackageManager)viewGroup));
        ((TextView)view2.findViewById(R.id.title)).setText(view.loadLabel((PackageManager)viewGroup));
        if (this.mShowDefaultActivity && n == 0 && this.mHighlightDefaultActivity) {
            view2.setActivated(true);
        } else {
            view2.setActivated(false);
        }
        return view2;
    }

    public int getViewTypeCount() {
        return 3;
    }

    public int measureContentWidth() {
        int n = this.mMaxActivityCount;
        this.mMaxActivityCount = Integer.MAX_VALUE;
        int n2 = 0;
        int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n4 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n5 = this.getCount();
        View view = null;
        int n6 = 0;
        while (true) {
            if (n2 >= n5) {
                this.mMaxActivityCount = n;
                return n6;
            }
            view = this.getView(n2, view, null);
            view.measure(n3, n4);
            n6 = Math.max(n6, view.getMeasuredWidth());
            ++n2;
        }
    }

    public void setDataModel(ActivityChooserModel activityChooserModel) {
        ActivityChooserModel activityChooserModel2 = this.this$0.mAdapter.getDataModel();
        if (activityChooserModel2 != null && this.this$0.isShown()) {
            activityChooserModel2.unregisterObserver((Object)this.this$0.mModelDataSetObserver);
        }
        this.mDataModel = activityChooserModel;
        if (activityChooserModel != null && this.this$0.isShown()) {
            activityChooserModel.registerObserver((Object)this.this$0.mModelDataSetObserver);
        }
        this.notifyDataSetChanged();
    }

    public void setMaxActivityCount(int n) {
        if (this.mMaxActivityCount == n) return;
        this.mMaxActivityCount = n;
        this.notifyDataSetChanged();
    }

    public void setShowDefaultActivity(boolean bl, boolean bl2) {
        if (this.mShowDefaultActivity == bl) {
            if (this.mHighlightDefaultActivity == bl2) return;
        }
        this.mShowDefaultActivity = bl;
        this.mHighlightDefaultActivity = bl2;
        this.notifyDataSetChanged();
    }

    public void setShowFooterView(boolean bl) {
        if (this.mShowFooterView == bl) return;
        this.mShowFooterView = bl;
        this.notifyDataSetChanged();
    }
}
