/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout$LayoutParams
 *  android.widget.TextView
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.widget.QMUIItemViewsAdapter
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabItemView
 */
package com.qmuiteam.qmui.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.widget.QMUIItemViewsAdapter;
import com.qmuiteam.qmui.widget.QMUITabSegment;

/*
 * Exception performing whole class analysis ignored.
 */
public class QMUITabSegment.TabAdapter
extends QMUIItemViewsAdapter<QMUITabSegment.Tab, QMUITabSegment.TabItemView> {
    final QMUITabSegment this$0;

    public QMUITabSegment.TabAdapter(QMUITabSegment qMUITabSegment, ViewGroup viewGroup) {
        this.this$0 = qMUITabSegment;
        super(viewGroup);
    }

    protected void bind(QMUITabSegment.Tab tab, QMUITabSegment.TabItemView tabItemView, int n) {
        TextView textView = tabItemView.getTextView();
        Object object = this.this$0;
        int n2 = QMUITabSegment.access$1100((QMUITabSegment)object);
        boolean bl = true;
        boolean bl2 = n2 == n;
        QMUITabSegment.access$1000((QMUITabSegment)object, (TextView)textView, (boolean)bl2);
        object = tab.getCustomViews();
        if (object != null && object.size() > 0) {
            tabItemView.setTag(R.id.qmui_view_can_not_cache_tag, (Object)true);
            object = object.iterator();
            while (object.hasNext()) {
                View view = (View)object.next();
                if (view.getParent() != null) continue;
                tabItemView.addView(view);
            }
        }
        if (QMUITabSegment.access$1900((QMUITabSegment)this.this$0) == 1) {
            int n3 = tab.getGravity();
            object = (RelativeLayout.LayoutParams)textView.getLayoutParams();
            int n4 = -1;
            n2 = (n3 & 3) == 3 ? -1 : 0;
            object.addRule(9, n2);
            n2 = (n3 & 0x11) == 17 ? -1 : 0;
            object.addRule(14, n2);
            n2 = (n3 & 5) == 5 ? n4 : 0;
            object.addRule(11, n2);
            textView.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        textView.setText(tab.getText());
        textView.setTextSize(0, (float)QMUITabSegment.access$2000((QMUITabSegment)this.this$0, (QMUITabSegment.Tab)tab));
        bl2 = QMUITabSegment.access$1100((QMUITabSegment)this.this$0) == n ? bl : false;
        tabItemView.updateDecoration(tab, bl2);
        tabItemView.setTag((Object)n);
        tabItemView.setOnClickListener(this.this$0.mTabOnClickListener);
    }

    protected QMUITabSegment.TabItemView createView(ViewGroup viewGroup) {
        viewGroup = this.this$0;
        return new QMUITabSegment.TabItemView((QMUITabSegment)viewGroup, viewGroup.getContext());
    }
}
