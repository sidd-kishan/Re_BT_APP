/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.SpinnerAdapter
 *  androidx.appcompat.widget.AppCompatSpinner
 *  androidx.appcompat.widget.AppCompatSpinner$DropdownPopup$2
 *  androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup
 *  androidx.appcompat.widget.ListPopupWindow
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.ViewCompat;

class AppCompatSpinner.DropdownPopup
extends ListPopupWindow
implements AppCompatSpinner.SpinnerPopup {
    ListAdapter mAdapter;
    private CharSequence mHintText;
    private int mOriginalHorizontalOffset;
    private final Rect mVisibleRect;
    final AppCompatSpinner this$0;

    public AppCompatSpinner.DropdownPopup(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int n) {
        this.this$0 = appCompatSpinner;
        super(context, attributeSet, n);
        this.mVisibleRect = new Rect();
        this.setAnchorView((View)appCompatSpinner);
        this.setModal(true);
        this.setPromptPosition(0);
        this.setOnItemClickListener((AdapterView.OnItemClickListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ void access$001(AppCompatSpinner.DropdownPopup dropdownPopup) {
        super.show();
    }

    void computeContentWidth() {
        Drawable drawable = this.getBackground();
        int n = 0;
        if (drawable != null) {
            drawable.getPadding(this.this$0.mTempRect);
            n = ViewUtils.isLayoutRtl((View)this.this$0) ? this.this$0.mTempRect.right : -this.this$0.mTempRect.left;
        } else {
            drawable = this.this$0.mTempRect;
            this.this$0.mTempRect.right = 0;
            drawable.left = 0;
        }
        int n2 = this.this$0.getPaddingLeft();
        int n3 = this.this$0.getPaddingRight();
        int n4 = this.this$0.getWidth();
        if (this.this$0.mDropDownWidth == -2) {
            int n5 = this.this$0.compatMeasureContentWidth((SpinnerAdapter)this.mAdapter, this.getBackground());
            int n6 = this.this$0.getContext().getResources().getDisplayMetrics().widthPixels - this.this$0.mTempRect.left - this.this$0.mTempRect.right;
            int n7 = n5;
            if (n5 > n6) {
                n7 = n6;
            }
            this.setContentWidth(Math.max(n7, n4 - n2 - n3));
        } else if (this.this$0.mDropDownWidth == -1) {
            this.setContentWidth(n4 - n2 - n3);
        } else {
            this.setContentWidth(this.this$0.mDropDownWidth);
        }
        n = ViewUtils.isLayoutRtl((View)this.this$0) ? (n += n4 - n3 - this.getWidth() - this.getHorizontalOriginalOffset()) : (n += n2 + this.getHorizontalOriginalOffset());
        this.setHorizontalOffset(n);
    }

    public CharSequence getHintText() {
        return this.mHintText;
    }

    public int getHorizontalOriginalOffset() {
        return this.mOriginalHorizontalOffset;
    }

    boolean isVisibleToUser(View view) {
        boolean bl = ViewCompat.isAttachedToWindow((View)view) && view.getGlobalVisibleRect(this.mVisibleRect);
        return bl;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.mAdapter = listAdapter;
    }

    public void setHorizontalOriginalOffset(int n) {
        this.mOriginalHorizontalOffset = n;
    }

    public void setPromptText(CharSequence charSequence) {
        this.mHintText = charSequence;
    }

    public void show(int n, int n2) {
        boolean bl = this.isShowing();
        this.computeContentWidth();
        this.setInputMethodMode(2);
        super.show();
        ListView listView = this.getListView();
        listView.setChoiceMode(1);
        if (Build.VERSION.SDK_INT >= 17) {
            listView.setTextDirection(n);
            listView.setTextAlignment(n2);
        }
        this.setSelection(this.this$0.getSelectedItemPosition());
        if (bl) {
            return;
        }
        listView = this.this$0.getViewTreeObserver();
        if (listView == null) return;
        2 var5_5 = new /* Unavailable Anonymous Inner Class!! */;
        listView.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)var5_5);
        this.setOnDismissListener((PopupWindow.OnDismissListener)new /* Unavailable Anonymous Inner Class!! */);
    }
}
