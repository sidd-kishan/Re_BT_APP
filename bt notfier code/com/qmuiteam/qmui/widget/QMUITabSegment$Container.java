/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  com.qmuiteam.qmui.widget.QMUITabSegment
 *  com.qmuiteam.qmui.widget.QMUITabSegment$Tab
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabAdapter
 *  com.qmuiteam.qmui.widget.QMUITabSegment$TabItemView
 */
package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.qmuiteam.qmui.widget.QMUITabSegment;
import java.util.List;

/*
 * Exception performing whole class analysis ignored.
 */
private final class QMUITabSegment.Container
extends ViewGroup {
    private QMUITabSegment.TabAdapter mTabAdapter;
    final QMUITabSegment this$0;

    public QMUITabSegment.Container(QMUITabSegment qMUITabSegment, Context context) {
        this.this$0 = qMUITabSegment;
        super(context);
        this.mTabAdapter = new QMUITabSegment.TabAdapter(qMUITabSegment, (ViewGroup)this);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!QMUITabSegment.access$300((QMUITabSegment)this.this$0)) return;
        if (QMUITabSegment.access$3200((QMUITabSegment)this.this$0) == null) return;
        if (QMUITabSegment.access$3300((QMUITabSegment)this.this$0)) {
            QMUITabSegment.access$3200((QMUITabSegment)this.this$0).top = this.getPaddingTop();
            QMUITabSegment.access$3200((QMUITabSegment)this.this$0).bottom = QMUITabSegment.access$3200((QMUITabSegment)this.this$0).top + QMUITabSegment.access$3400((QMUITabSegment)this.this$0);
        } else {
            QMUITabSegment.access$3200((QMUITabSegment)this.this$0).bottom = this.getHeight() - this.getPaddingBottom();
            QMUITabSegment.access$3200((QMUITabSegment)this.this$0).top = QMUITabSegment.access$3200((QMUITabSegment)this.this$0).bottom - QMUITabSegment.access$3400((QMUITabSegment)this.this$0);
        }
        if (QMUITabSegment.access$3500((QMUITabSegment)this.this$0) != null) {
            QMUITabSegment.access$3500((QMUITabSegment)this.this$0).setBounds(QMUITabSegment.access$3200((QMUITabSegment)this.this$0));
            QMUITabSegment.access$3500((QMUITabSegment)this.this$0).draw(canvas);
        } else {
            canvas.drawRect(QMUITabSegment.access$3200((QMUITabSegment)this.this$0), QMUITabSegment.access$3600((QMUITabSegment)this.this$0));
        }
    }

    public QMUITabSegment.TabAdapter getTabAdapter() {
        return this.mTabAdapter;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        List list = this.mTabAdapter.getViews();
        int n5 = list.size();
        int n6 = 0;
        for (n3 = 0; n3 < n5; ++n3) {
            n = n6;
            if (((View)list.get(n3)).getVisibility() == 0) {
                n = n6 + 1;
            }
            n6 = n;
        }
        if (n5 == 0) return;
        if (n6 == 0) return;
        n3 = this.getPaddingLeft();
        for (n = 0; n < n5; ++n) {
            int n7;
            QMUITabSegment.TabItemView tabItemView = (QMUITabSegment.TabItemView)list.get(n);
            if (tabItemView.getVisibility() != 0) continue;
            QMUITabSegment.Tab tab = (QMUITabSegment.Tab)this.mTabAdapter.getItem(n);
            int n8 = tabItemView.getMeasuredWidth();
            tabItemView.layout(QMUITabSegment.Tab.access$2600((QMUITabSegment.Tab)tab) + n3, this.getPaddingTop(), QMUITabSegment.Tab.access$2600((QMUITabSegment.Tab)tab) + n3 + n8 + QMUITabSegment.Tab.access$2700((QMUITabSegment.Tab)tab), n4 - n2 - this.getPaddingBottom());
            int n9 = tab.getContentLeft();
            int n10 = tab.getContentWidth();
            if (QMUITabSegment.access$1900((QMUITabSegment)this.this$0) == 1 && QMUITabSegment.access$3100((QMUITabSegment)this.this$0)) {
                tabItemView = tabItemView.getTextView();
                n7 = tabItemView.getLeft() + n3;
                n6 = tabItemView.getWidth();
            } else {
                n7 = n3 + QMUITabSegment.Tab.access$2600((QMUITabSegment.Tab)tab);
                n6 = n8;
            }
            if (n9 != n7 || n10 != n6) {
                tab.setContentLeft(n7);
                tab.setContentWidth(n6);
            }
            n10 = QMUITabSegment.Tab.access$2600((QMUITabSegment.Tab)tab);
            n7 = QMUITabSegment.Tab.access$2700((QMUITabSegment.Tab)tab);
            n6 = QMUITabSegment.access$1900((QMUITabSegment)this.this$0) == 0 ? QMUITabSegment.access$2800((QMUITabSegment)this.this$0) : 0;
            n3 = n3 + n8 + n10 + n7 + n6;
        }
        if (QMUITabSegment.access$1100((QMUITabSegment)this.this$0) == -1) return;
        if (QMUITabSegment.access$000((QMUITabSegment)this.this$0) != null) return;
        if (QMUITabSegment.access$100((QMUITabSegment)this.this$0) != 0) return;
        list = this.this$0;
        QMUITabSegment.access$1400((QMUITabSegment)list, (QMUITabSegment.Tab)((QMUITabSegment.Tab)this.mTabAdapter.getItem(QMUITabSegment.access$1100((QMUITabSegment)list))), (boolean)false);
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        block10: {
            View view;
            float f;
            int n4;
            int n5;
            int n6;
            List list;
            int n7;
            block13: {
                block12: {
                    block11: {
                        n7 = View.MeasureSpec.getSize((int)n);
                        n3 = View.MeasureSpec.getSize((int)n2);
                        list = this.mTabAdapter.getViews();
                        n6 = list.size();
                        n5 = 0;
                        n = 0;
                        for (n2 = 0; n2 < n6; ++n2) {
                            n4 = n;
                            if (((View)list.get(n2)).getVisibility() == 0) {
                                n4 = n + 1;
                            }
                            n = n4;
                        }
                        if (n6 == 0 || n == 0) break block11;
                        n4 = n3 - this.getPaddingTop() - this.getPaddingBottom();
                        if (QMUITabSegment.access$1900((QMUITabSegment)this.this$0) == 1) break block12;
                        n2 = 0;
                        f = 0.0f;
                        break block13;
                    }
                    this.setMeasuredDimension(n7, n3);
                    return;
                }
                n5 = n7 / n;
                n2 = 0;
                while (true) {
                    n = n7;
                    if (n2 < n6) {
                        View view2 = (View)list.get(n2);
                        if (view2.getVisibility() == 0) {
                            view2.measure(View.MeasureSpec.makeMeasureSpec((int)n5, (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000));
                            view2 = (QMUITabSegment.Tab)this.mTabAdapter.getItem(n2);
                            QMUITabSegment.Tab.access$2602((QMUITabSegment.Tab)view2, (int)0);
                            QMUITabSegment.Tab.access$2702((QMUITabSegment.Tab)view2, (int)0);
                        }
                        ++n2;
                        continue;
                    }
                    break block10;
                    break;
                }
            }
            for (n = 0; n < n6; ++n) {
                view = (View)list.get(n);
                if (view.getVisibility() != 0) continue;
                view.measure(View.MeasureSpec.makeMeasureSpec((int)n7, (int)Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000));
                n2 += view.getMeasuredWidth() + QMUITabSegment.access$2800((QMUITabSegment)this.this$0);
                view = (QMUITabSegment.Tab)this.mTabAdapter.getItem(n);
                f += QMUITabSegment.Tab.access$2900((QMUITabSegment.Tab)view) + QMUITabSegment.Tab.access$3000((QMUITabSegment.Tab)view);
                QMUITabSegment.Tab.access$2602((QMUITabSegment.Tab)view, (int)0);
                QMUITabSegment.Tab.access$2702((QMUITabSegment.Tab)view, (int)0);
            }
            n4 = n2 - QMUITabSegment.access$2800((QMUITabSegment)this.this$0);
            if (!(f > 0.0f) || n4 >= n7) {
                n = n4;
            } else {
                n2 = n5;
                while (true) {
                    n = n7;
                    if (n2 >= n6) break;
                    if (((View)list.get(n2)).getVisibility() == 0) {
                        view = (QMUITabSegment.Tab)this.mTabAdapter.getItem(n2);
                        float f2 = n7 - n4;
                        QMUITabSegment.Tab.access$2602((QMUITabSegment.Tab)view, (int)((int)(QMUITabSegment.Tab.access$2900((QMUITabSegment.Tab)view) * f2 / f)));
                        QMUITabSegment.Tab.access$2702((QMUITabSegment.Tab)view, (int)((int)(f2 * QMUITabSegment.Tab.access$3000((QMUITabSegment.Tab)view) / f)));
                    }
                    ++n2;
                }
            }
        }
        this.setMeasuredDimension(n, n3);
    }
}
