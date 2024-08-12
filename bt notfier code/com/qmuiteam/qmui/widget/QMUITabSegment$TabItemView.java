/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils$TruncateAt
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatTextView
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIDrawableHelper
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIDrawableHelper;
import com.qmuiteam.qmui.widget.QMUITabSegment;

/*
 * Exception performing whole class analysis ignored.
 */
public class QMUITabSegment.TabItemView
extends RelativeLayout {
    private GestureDetector mGestureDetector;
    private AppCompatTextView mTextView;
    final QMUITabSegment this$0;

    public QMUITabSegment.TabItemView(QMUITabSegment qMUITabSegment, Context context) {
        this.this$0 = qMUITabSegment;
        super(context);
        context = new AppCompatTextView(this.getContext());
        this.mTextView = context;
        context.setSingleLine(true);
        this.mTextView.setGravity(17);
        this.mTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        this.mTextView.setId(R.id.qmui_tab_segment_item_id);
        context = new RelativeLayout.LayoutParams(-2, -2);
        context.addRule(15, -1);
        this.addView((View)this.mTextView, (ViewGroup.LayoutParams)context);
        this.mGestureDetector = new GestureDetector(this.getContext(), (GestureDetector.OnGestureListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.mGestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
        return bl;
    }

    public void setColorInTransition(QMUITabSegment.Tab tab, int n) {
        this.mTextView.setTextColor(n);
        if (!tab.isDynamicChangeIconColor()) return;
        Drawable drawable = this.mTextView.getCompoundDrawables()[QMUITabSegment.access$2400((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)tab)];
        if (drawable == null) return;
        QMUIDrawableHelper.setDrawableTintColor((Drawable)drawable, (int)n);
        QMUITabSegment qMUITabSegment = this.this$0;
        QMUITabSegment.access$2500((QMUITabSegment)qMUITabSegment, (TextView)this.mTextView, (Drawable)drawable, (int)QMUITabSegment.access$2400((QMUITabSegment)qMUITabSegment, (QMUITabSegment.Tab)tab));
    }

    public void updateDecoration(QMUITabSegment.Tab tab, boolean bl) {
        QMUITabSegment qMUITabSegment = this.this$0;
        int n = bl ? QMUITabSegment.access$500((QMUITabSegment)qMUITabSegment, (QMUITabSegment.Tab)tab) : QMUITabSegment.access$600((QMUITabSegment)qMUITabSegment, (QMUITabSegment.Tab)tab);
        this.mTextView.setTextColor(n);
        Drawable drawable = tab.getNormalIcon();
        qMUITabSegment = drawable;
        if (bl) {
            if (!tab.isDynamicChangeIconColor()) {
                qMUITabSegment = drawable;
                if (tab.getSelectedIcon() != null) {
                    qMUITabSegment = tab.getSelectedIcon();
                }
            } else {
                qMUITabSegment = drawable;
                if (drawable != null) {
                    qMUITabSegment = drawable.mutate();
                    QMUIDrawableHelper.setDrawableTintColor((Drawable)qMUITabSegment, (int)n);
                }
            }
        }
        if (qMUITabSegment == null) {
            this.mTextView.setCompoundDrawablePadding(0);
            this.mTextView.setCompoundDrawables(null, null, null, null);
        } else {
            this.mTextView.setCompoundDrawablePadding(QMUIDisplayHelper.dp2px((Context)this.getContext(), (int)4));
            drawable = this.this$0;
            QMUITabSegment.access$2500((QMUITabSegment)drawable, (TextView)this.mTextView, (Drawable)qMUITabSegment, (int)QMUITabSegment.access$2400((QMUITabSegment)drawable, (QMUITabSegment.Tab)tab));
        }
    }
}
