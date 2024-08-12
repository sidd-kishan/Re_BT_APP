/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.app.ActionBar$Tab
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.appcompat.widget.AppCompatTextView
 *  androidx.appcompat.widget.ScrollingTabContainerView
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.appcompat.widget.TooltipCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.TooltipCompat;

private class ScrollingTabContainerView.TabView
extends LinearLayout {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.app.ActionBar$Tab";
    private final int[] BG_ATTRS;
    private View mCustomView;
    private ImageView mIconView;
    private ActionBar.Tab mTab;
    private TextView mTextView;
    final ScrollingTabContainerView this$0;

    public ScrollingTabContainerView.TabView(ScrollingTabContainerView object, Context context, ActionBar.Tab tab, boolean bl) {
        this.this$0 = object;
        super(context, null, R.attr.actionBarTabStyle);
        object = new int[1];
        object[0] = (ScrollingTabContainerView)16842964;
        this.BG_ATTRS = (int[])object;
        this.mTab = tab;
        object = TintTypedArray.obtainStyledAttributes((Context)context, null, (int[])object, (int)R.attr.actionBarTabStyle, (int)0);
        if (object.hasValue(0)) {
            this.setBackgroundDrawable(object.getDrawable(0));
        }
        object.recycle();
        if (bl) {
            this.setGravity(8388627);
        }
        this.update();
    }

    public void bindTab(ActionBar.Tab tab) {
        this.mTab = tab;
        this.update();
    }

    public ActionBar.Tab getTab() {
        return this.mTab;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        if (this.this$0.mMaxTabWidth <= 0) return;
        if (this.getMeasuredWidth() <= this.this$0.mMaxTabWidth) return;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)this.this$0.mMaxTabWidth, (int)0x40000000), n2);
    }

    public void setSelected(boolean bl) {
        boolean bl2 = this.isSelected() != bl;
        super.setSelected(bl);
        if (!bl2) return;
        if (!bl) return;
        this.sendAccessibilityEvent(4);
    }

    public void update() {
        ActionBar.Tab tab = this.mTab;
        Object object = tab.getCustomView();
        Object object2 = null;
        if (object != null) {
            object2 = object.getParent();
            if (object2 != this) {
                if (object2 != null) {
                    ((ViewGroup)object2).removeView(object);
                }
                this.addView((View)object);
            }
            this.mCustomView = object;
            object2 = this.mTextView;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            if ((object2 = this.mIconView) == null) return;
            object2.setVisibility(8);
            this.mIconView.setImageDrawable(null);
        } else {
            ImageView imageView;
            object = this.mCustomView;
            if (object != null) {
                this.removeView((View)object);
                this.mCustomView = null;
            }
            Drawable drawable = tab.getIcon();
            object = tab.getText();
            if (drawable != null) {
                if (this.mIconView == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(this.getContext());
                    imageView = new LinearLayout.LayoutParams(-2, -2);
                    imageView.gravity = 16;
                    appCompatImageView.setLayoutParams((ViewGroup.LayoutParams)imageView);
                    this.addView((View)appCompatImageView, 0);
                    this.mIconView = appCompatImageView;
                }
                this.mIconView.setImageDrawable(drawable);
                this.mIconView.setVisibility(0);
            } else {
                imageView = this.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
            }
            boolean bl = TextUtils.isEmpty((CharSequence)object) ^ true;
            if (bl) {
                if (this.mTextView == null) {
                    drawable = new AppCompatTextView(this.getContext(), null, R.attr.actionBarTabTextStyle);
                    drawable.setEllipsize(TextUtils.TruncateAt.END);
                    imageView = new LinearLayout.LayoutParams(-2, -2);
                    imageView.gravity = 16;
                    drawable.setLayoutParams((ViewGroup.LayoutParams)imageView);
                    this.addView((View)drawable);
                    this.mTextView = drawable;
                }
                this.mTextView.setText((CharSequence)object);
                this.mTextView.setVisibility(0);
            } else {
                object = this.mTextView;
                if (object != null) {
                    object.setVisibility(8);
                    this.mTextView.setText(null);
                }
            }
            object = this.mIconView;
            if (object != null) {
                object.setContentDescription(tab.getContentDescription());
            }
            if (!bl) {
                object2 = tab.getContentDescription();
            }
            TooltipCompat.setTooltipText((View)this, (CharSequence)object2);
        }
    }
}
