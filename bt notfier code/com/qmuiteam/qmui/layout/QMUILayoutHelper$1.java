/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  com.qmuiteam.qmui.layout.QMUILayoutHelper
 */
package com.qmuiteam.qmui.layout;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;

class QMUILayoutHelper.1
extends ViewOutlineProvider {
    final QMUILayoutHelper this$0;

    QMUILayoutHelper.1(QMUILayoutHelper qMUILayoutHelper) {
        this.this$0 = qMUILayoutHelper;
    }

    /*
     * Unable to fully structure code
     */
    public void getOutline(View var1_1, Outline var2_2) {
        block9: {
            block10: {
                var4_3 = var1_1.getWidth();
                var5_4 = var1_1.getHeight();
                if (var4_3 == 0) return;
                if (var5_4 == 0) return;
                if (!this.this$0.isRadiusWithSideHidden()) break block9;
                if (QMUILayoutHelper.access$000((QMUILayoutHelper)this.this$0) != 4) break block10;
                var7_5 = 0 - QMUILayoutHelper.access$100((QMUILayoutHelper)this.this$0);
                var6_7 = var4_3;
                var4_3 = var5_4;
                var5_4 = var6_7;
                var6_7 = var7_5;
                ** GOTO lbl32
            }
            if (QMUILayoutHelper.access$000((QMUILayoutHelper)this.this$0) == 1) {
                var7_5 = 0 - QMUILayoutHelper.access$100((QMUILayoutHelper)this.this$0);
                var6_7 = 0;
                var8_9 = var4_3;
                var4_3 = var5_4;
            } else {
                if (QMUILayoutHelper.access$000((QMUILayoutHelper)this.this$0) == 2) {
                    var7_5 = var4_3 + QMUILayoutHelper.access$100((QMUILayoutHelper)this.this$0);
                    var6_7 = var5_4;
                } else {
                    var7_5 = var4_3;
                    var6_7 = var5_4;
                    if (QMUILayoutHelper.access$000((QMUILayoutHelper)this.this$0) == 3) {
                        var6_7 = var5_4 + QMUILayoutHelper.access$100((QMUILayoutHelper)this.this$0);
                        var7_5 = var4_3;
                    }
                }
                var5_4 = var7_5;
                var4_3 = var6_7;
                var6_7 = 0;
lbl32:
                // 2 sources

                var7_5 = 0;
                var8_9 = var5_4;
            }
            var2_2.setRoundRect(var6_7, var7_5, var8_9, var4_3, (float)QMUILayoutHelper.access$100((QMUILayoutHelper)this.this$0));
            return;
        }
        var9_11 = QMUILayoutHelper.access$200((QMUILayoutHelper)this.this$0);
        var8_10 = Math.max(var9_11 + 1, var5_4 - QMUILayoutHelper.access$300((QMUILayoutHelper)this.this$0));
        var11_12 = QMUILayoutHelper.access$400((QMUILayoutHelper)this.this$0);
        var7_6 = var10_13 = var4_3 - QMUILayoutHelper.access$500((QMUILayoutHelper)this.this$0);
        var6_8 = var8_10;
        var5_4 = var9_11;
        var4_3 = var11_12;
        if (QMUILayoutHelper.access$600((QMUILayoutHelper)this.this$0)) {
            var4_3 = var11_12 + var1_1.getPaddingLeft();
            var5_4 = var9_11 + var1_1.getPaddingTop();
            var7_6 = Math.max(var4_3 + 1, var10_13 - var1_1.getPaddingRight());
            var6_8 = Math.max(var5_4 + 1, var8_10 - var1_1.getPaddingBottom());
        }
        var3_14 = QMUILayoutHelper.access$700((QMUILayoutHelper)this.this$0);
        if (QMUILayoutHelper.access$800((QMUILayoutHelper)this.this$0) == 0) {
            var3_14 = 1.0f;
        }
        var2_2.setAlpha(var3_14);
        if (QMUILayoutHelper.access$100((QMUILayoutHelper)this.this$0) <= 0) {
            var2_2.setRect(var4_3, var5_4, var7_6, var6_8);
        } else {
            var2_2.setRoundRect(var4_3, var5_4, var7_6, var6_8, (float)QMUILayoutHelper.access$100((QMUILayoutHelper)this.this$0));
        }
    }
}
