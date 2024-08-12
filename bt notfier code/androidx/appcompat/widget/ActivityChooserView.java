/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ResolveInfo
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.R$dimen
 *  androidx.appcompat.R$id
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.R$string
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.ActivityChooserModel
 *  androidx.appcompat.widget.ActivityChooserModel$ActivityChooserModelClient
 *  androidx.appcompat.widget.ActivityChooserView$ActivityChooserViewAdapter
 *  androidx.appcompat.widget.ActivityChooserView$Callbacks
 *  androidx.appcompat.widget.ListPopupWindow
 *  androidx.core.view.ActionProvider
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;

public class ActivityChooserView
extends ViewGroup
implements ActivityChooserModel.ActivityChooserModelClient {
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final ActivityChooserViewAdapter mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount = 4;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver = new /* Unavailable Anonymous Inner Class!! */;
    PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener = new /* Unavailable Anonymous Inner Class!! */;
    ActionProvider mProvider;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.ActivityChooserView, n, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this, (Context)context, (int[])R.styleable.ActivityChooserView, (AttributeSet)attributeSet, (TypedArray)typedArray, (int)n, (int)0);
        this.mInitialActivityCount = typedArray.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
        attributeSet = typedArray.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArray.recycle();
        LayoutInflater.from((Context)this.getContext()).inflate(R.layout.abc_activity_chooser_view, (ViewGroup)this, true);
        this.mCallbacks = new Callbacks(this);
        typedArray = this.findViewById(R.id.activity_chooser_view_content);
        this.mActivityChooserContent = typedArray;
        this.mActivityChooserContentBackground = typedArray.getBackground();
        typedArray = (FrameLayout)this.findViewById(R.id.default_activity_button);
        this.mDefaultActivityButton = typedArray;
        typedArray.setOnClickListener((View.OnClickListener)this.mCallbacks);
        this.mDefaultActivityButton.setOnLongClickListener((View.OnLongClickListener)this.mCallbacks);
        this.mDefaultActivityButtonImage = (ImageView)this.mDefaultActivityButton.findViewById(R.id.image);
        typedArray = (FrameLayout)this.findViewById(R.id.expand_activities_button);
        typedArray.setOnClickListener((View.OnClickListener)this.mCallbacks);
        typedArray.setAccessibilityDelegate((View.AccessibilityDelegate)new /* Unavailable Anonymous Inner Class!! */);
        typedArray.setOnTouchListener((View.OnTouchListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mExpandActivityOverflowButton = typedArray;
        typedArray = (ImageView)typedArray.findViewById(R.id.image);
        this.mExpandActivityOverflowButtonImage = typedArray;
        typedArray.setImageDrawable((Drawable)attributeSet);
        attributeSet = new ActivityChooserViewAdapter(this);
        this.mAdapter = attributeSet;
        attributeSet.registerDataSetObserver((DataSetObserver)new /* Unavailable Anonymous Inner Class!! */);
        context = context.getResources();
        this.mListPopupMaxWidth = Math.max(context.getDisplayMetrics().widthPixels / 2, context.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
    }

    public boolean dismissPopup() {
        if (!this.isShowingPopup()) return true;
        this.getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) return true;
        viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    ListPopupWindow getListPopupWindow() {
        ListPopupWindow listPopupWindow;
        if (this.mListPopupWindow != null) return this.mListPopupWindow;
        this.mListPopupWindow = listPopupWindow = new ListPopupWindow(this.getContext());
        listPopupWindow.setAdapter((ListAdapter)this.mAdapter);
        this.mListPopupWindow.setAnchorView((View)this);
        this.mListPopupWindow.setModal(true);
        this.mListPopupWindow.setOnItemClickListener((AdapterView.OnItemClickListener)this.mCallbacks);
        this.mListPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)this.mCallbacks);
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return this.getListPopupWindow().isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModel = this.mAdapter.getDataModel();
        if (activityChooserModel != null) {
            activityChooserModel.registerObserver((Object)this.mModelDataSetObserver);
        }
        this.mIsAttachedToWindow = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModel = this.mAdapter.getDataModel();
        if (activityChooserModel != null) {
            activityChooserModel.unregisterObserver((Object)this.mModelDataSetObserver);
        }
        if ((activityChooserModel = this.getViewTreeObserver()).isAlive()) {
            activityChooserModel.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (this.isShowingPopup()) {
            this.dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        this.mActivityChooserContent.layout(0, 0, n3 - n, n4 - n2);
        if (this.isShowingPopup()) return;
        this.dismissPopup();
    }

    protected void onMeasure(int n, int n2) {
        View view = this.mActivityChooserContent;
        int n3 = n2;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            n3 = View.MeasureSpec.makeMeasureSpec((int)View.MeasureSpec.getSize((int)n2), (int)0x40000000);
        }
        this.measureChild(view, n, n3);
        this.setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.mAdapter.setDataModel(activityChooserModel);
        if (!this.isShowingPopup()) return;
        this.dismissPopup();
        this.showPopup();
    }

    public void setDefaultActionButtonContentDescription(int n) {
        this.mDefaultActionButtonContentDescription = n;
    }

    public void setExpandActivityOverflowButtonContentDescription(int n) {
        String string = this.getContext().getString(n);
        this.mExpandActivityOverflowButtonImage.setContentDescription((CharSequence)string);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int n) {
        this.mInitialActivityCount = n;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.mProvider = actionProvider;
    }

    public boolean showPopup() {
        if (this.isShowingPopup()) return false;
        if (!this.mIsAttachedToWindow) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        this.showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    void showPopupUnchecked(int n) {
        if (this.mAdapter.getDataModel() == null) throw new IllegalStateException("No data model. Did you call #setDataModel?");
        this.getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        int n2 = this.mDefaultActivityButton.getVisibility() == 0 ? 1 : 0;
        int n3 = this.mAdapter.getActivityCount();
        if (n != Integer.MAX_VALUE && n3 > n + n2) {
            this.mAdapter.setShowFooterView(true);
            this.mAdapter.setMaxActivityCount(n - 1);
        } else {
            this.mAdapter.setShowFooterView(false);
            this.mAdapter.setMaxActivityCount(n);
        }
        ListPopupWindow listPopupWindow = this.getListPopupWindow();
        if (listPopupWindow.isShowing()) return;
        if (!this.mIsSelectingDefaultActivity && n2 != 0) {
            this.mAdapter.setShowDefaultActivity(false, false);
        } else {
            this.mAdapter.setShowDefaultActivity(true, n2 != 0);
        }
        listPopupWindow.setContentWidth(Math.min(this.mAdapter.measureContentWidth(), this.mListPopupMaxWidth));
        listPopupWindow.show();
        ActionProvider actionProvider = this.mProvider;
        if (actionProvider != null) {
            actionProvider.subUiVisibilityChanged(true);
        }
        listPopupWindow.getListView().setContentDescription((CharSequence)this.getContext().getString(R.string.abc_activitychooserview_choose_application));
        listPopupWindow.getListView().setSelector((Drawable)new ColorDrawable(0));
    }

    void updateAppearance() {
        if (this.mAdapter.getCount() > 0) {
            this.mExpandActivityOverflowButton.setEnabled(true);
        } else {
            this.mExpandActivityOverflowButton.setEnabled(false);
        }
        int n = this.mAdapter.getActivityCount();
        int n2 = this.mAdapter.getHistorySize();
        if (n != 1 && (n <= 1 || n2 <= 0)) {
            this.mDefaultActivityButton.setVisibility(8);
        } else {
            this.mDefaultActivityButton.setVisibility(0);
            ResolveInfo resolveInfo = this.mAdapter.getDefaultActivity();
            Object object = this.getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(resolveInfo.loadIcon(object));
            if (this.mDefaultActionButtonContentDescription != 0) {
                object = resolveInfo.loadLabel(object);
                object = this.getContext().getString(this.mDefaultActionButtonContentDescription, new Object[]{object});
                this.mDefaultActivityButton.setContentDescription((CharSequence)object);
            }
        }
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        } else {
            this.mActivityChooserContent.setBackgroundDrawable(null);
        }
    }
}
