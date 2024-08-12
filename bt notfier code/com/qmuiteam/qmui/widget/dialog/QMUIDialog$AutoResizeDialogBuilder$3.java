/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.LinearLayout$LayoutParams
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.widget.dialog.QMUIDialog$AutoResizeDialogBuilder
 */
package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;

/*
 * Exception performing whole class analysis ignored.
 */
class QMUIDialog.AutoResizeDialogBuilder.3
implements ViewTreeObserver.OnGlobalLayoutListener {
    final QMUIDialog.AutoResizeDialogBuilder this$0;
    final Context val$context;

    QMUIDialog.AutoResizeDialogBuilder.3(QMUIDialog.AutoResizeDialogBuilder autoResizeDialogBuilder, Context context) {
        this.this$0 = autoResizeDialogBuilder;
        this.val$context = context;
    }

    public void onGlobalLayout() {
        View view = this.this$0.mDialog.getWindow().getDecorView();
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        QMUIDialog.AutoResizeDialogBuilder.access$102((QMUIDialog.AutoResizeDialogBuilder)this.this$0, (int)QMUIDisplayHelper.getScreenHeight((Context)this.val$context));
        int n = QMUIDialog.AutoResizeDialogBuilder.access$100((QMUIDialog.AutoResizeDialogBuilder)this.this$0) - rect.bottom;
        if (n != QMUIDialog.AutoResizeDialogBuilder.access$200((QMUIDialog.AutoResizeDialogBuilder)this.this$0)) {
            QMUIDialog.AutoResizeDialogBuilder.access$202((QMUIDialog.AutoResizeDialogBuilder)this.this$0, (int)n);
            rect = (LinearLayout.LayoutParams)this.this$0.mAnchorBottomView.getLayoutParams();
            rect.height = QMUIDialog.AutoResizeDialogBuilder.access$200((QMUIDialog.AutoResizeDialogBuilder)this.this$0);
            this.this$0.mAnchorBottomView.setLayoutParams((ViewGroup.LayoutParams)rect);
            rect = (LinearLayout.LayoutParams)QMUIDialog.AutoResizeDialogBuilder.access$300((QMUIDialog.AutoResizeDialogBuilder)this.this$0).getLayoutParams();
            if (this.this$0.onGetScrollHeight() == -2) {
                view = this.this$0;
                QMUIDialog.AutoResizeDialogBuilder.access$402((QMUIDialog.AutoResizeDialogBuilder)view, (int)Math.max(QMUIDialog.AutoResizeDialogBuilder.access$400((QMUIDialog.AutoResizeDialogBuilder)view), QMUIDialog.AutoResizeDialogBuilder.access$300((QMUIDialog.AutoResizeDialogBuilder)this.this$0).getMeasuredHeight()));
            } else {
                view = this.this$0;
                QMUIDialog.AutoResizeDialogBuilder.access$402((QMUIDialog.AutoResizeDialogBuilder)view, (int)view.onGetScrollHeight());
            }
            if (QMUIDialog.AutoResizeDialogBuilder.access$200((QMUIDialog.AutoResizeDialogBuilder)this.this$0) == 0) {
                rect.height = QMUIDialog.AutoResizeDialogBuilder.access$400((QMUIDialog.AutoResizeDialogBuilder)this.this$0);
            } else {
                QMUIDialog.AutoResizeDialogBuilder.access$300((QMUIDialog.AutoResizeDialogBuilder)this.this$0).getChildAt(0).requestFocus();
                rect.height = QMUIDialog.AutoResizeDialogBuilder.access$400((QMUIDialog.AutoResizeDialogBuilder)this.this$0) - QMUIDialog.AutoResizeDialogBuilder.access$200((QMUIDialog.AutoResizeDialogBuilder)this.this$0);
            }
            QMUIDialog.AutoResizeDialogBuilder.access$300((QMUIDialog.AutoResizeDialogBuilder)this.this$0).setLayoutParams((ViewGroup.LayoutParams)rect);
        } else {
            view = (LinearLayout.LayoutParams)this.this$0.mDialogView.getLayoutParams();
            n = QMUIDialog.AutoResizeDialogBuilder.access$100((QMUIDialog.AutoResizeDialogBuilder)this.this$0);
            int n2 = view.bottomMargin;
            int n3 = view.topMargin;
            int n4 = rect.top;
            double d = QMUIDialog.AutoResizeDialogBuilder.access$300((QMUIDialog.AutoResizeDialogBuilder)this.this$0).getMeasuredHeight();
            double d2 = n - n2 - n3 - n4;
            Double.isNaN(d2);
            if (!(d > d2)) return;
            QMUIDialog.AutoResizeDialogBuilder.access$402((QMUIDialog.AutoResizeDialogBuilder)this.this$0, (int)((int)(d2 *= 0.8)));
            rect = (LinearLayout.LayoutParams)QMUIDialog.AutoResizeDialogBuilder.access$300((QMUIDialog.AutoResizeDialogBuilder)this.this$0).getLayoutParams();
            rect.height = QMUIDialog.AutoResizeDialogBuilder.access$400((QMUIDialog.AutoResizeDialogBuilder)this.this$0);
            QMUIDialog.AutoResizeDialogBuilder.access$300((QMUIDialog.AutoResizeDialogBuilder)this.this$0).setLayoutParams((ViewGroup.LayoutParams)rect);
        }
    }
}
