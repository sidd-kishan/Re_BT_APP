/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.math.MathUtils
 *  androidx.core.view.ViewCompat
 *  androidx.customview.widget.ViewDragHelper$Callback
 *  com.google.android.material.bottomsheet.BottomSheetBehavior
 *  com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable
 */
package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/*
 * Exception performing whole class analysis ignored.
 */
class BottomSheetBehavior.2
extends ViewDragHelper.Callback {
    final BottomSheetBehavior this$0;

    BottomSheetBehavior.2(BottomSheetBehavior bottomSheetBehavior) {
        this.this$0 = bottomSheetBehavior;
    }

    public int clampViewPositionHorizontal(View view, int n, int n2) {
        return view.getLeft();
    }

    public int clampViewPositionVertical(View view, int n, int n2) {
        int n3 = BottomSheetBehavior.access$100((BottomSheetBehavior)this.this$0);
        n2 = this.this$0.hideable ? this.this$0.parentHeight : this.this$0.collapsedOffset;
        return MathUtils.clamp((int)n, (int)n3, (int)n2);
    }

    public int getViewVerticalDragRange(View view) {
        if (!this.this$0.hideable) return this.this$0.collapsedOffset;
        return this.this$0.parentHeight;
    }

    public void onViewDragStateChanged(int n) {
        if (n != 1) return;
        this.this$0.setStateInternal(1);
    }

    public void onViewPositionChanged(View view, int n, int n2, int n3, int n4) {
        this.this$0.dispatchOnSlide(n2);
    }

    /*
     * Unable to fully structure code
     */
    public void onViewReleased(View var1_1, float var2_2, float var3_3) {
        block6: {
            block12: {
                block13: {
                    block14: {
                        block7: {
                            block10: {
                                block11: {
                                    block9: {
                                        block8: {
                                            block4: {
                                                block5: {
                                                    var4_4 = 0;
                                                    var5_5 = 4;
                                                    if (!(var3_3 < 0.0f)) break block4;
                                                    if (!BottomSheetBehavior.access$000((BottomSheetBehavior)this.this$0)) break block5;
                                                    var5_5 = this.this$0.fitToContentsOffset;
                                                    var4_4 = 3;
                                                    break block6;
                                                }
                                                if (var1_1.getTop() <= this.this$0.halfExpandedOffset) break block7;
                                                var4_4 = this.this$0.halfExpandedOffset;
                                                ** GOTO lbl44
                                            }
                                            if (!this.this$0.hideable || !this.this$0.shouldHide(var1_1, var3_3) || var1_1.getTop() <= this.this$0.collapsedOffset && !(Math.abs(var2_2) < Math.abs(var3_3))) break block8;
                                            var5_5 = this.this$0.parentHeight;
                                            var4_4 = 5;
                                            break block6;
                                        }
                                        if (var3_3 == 0.0f || Math.abs(var2_2) > Math.abs(var3_3)) break block9;
                                        var6_7 = this.this$0.collapsedOffset;
                                        var4_4 = var5_5;
                                        var5_5 = var6_7;
                                        break block6;
                                    }
                                    var6_6 = var1_1.getTop();
                                    if (!BottomSheetBehavior.access$000((BottomSheetBehavior)this.this$0)) break block10;
                                    if (Math.abs(var6_6 - this.this$0.fitToContentsOffset) >= Math.abs(var6_6 - this.this$0.collapsedOffset)) break block11;
                                    var4_4 = this.this$0.fitToContentsOffset;
                                    break block7;
                                }
                                var4_4 = this.this$0.collapsedOffset;
                                break block12;
                            }
                            if (var6_6 >= this.this$0.halfExpandedOffset) break block13;
                            if (var6_6 >= Math.abs(var6_6 - this.this$0.collapsedOffset)) break block14;
                        }
                        var5_5 = 3;
                        break block12;
                    }
                    var4_4 = this.this$0.halfExpandedOffset;
                    ** GOTO lbl44
                }
                if (Math.abs(var6_6 - this.this$0.halfExpandedOffset) < Math.abs(var6_6 - this.this$0.collapsedOffset)) {
                    var4_4 = this.this$0.halfExpandedOffset;
lbl44:
                    // 3 sources

                    var5_5 = 6;
                } else {
                    var4_4 = this.this$0.collapsedOffset;
                }
            }
            var6_6 = var4_4;
            var4_4 = var5_5;
            var5_5 = var6_6;
        }
        if (this.this$0.viewDragHelper.settleCapturedViewAt(var1_1.getLeft(), var5_5)) {
            this.this$0.setStateInternal(2);
            ViewCompat.postOnAnimation((View)var1_1, (Runnable)new BottomSheetBehavior.SettleRunnable(this.this$0, var1_1, var4_4));
        } else {
            this.this$0.setStateInternal(var4_4);
        }
    }

    public boolean tryCaptureView(View view, int n) {
        View view2;
        int n2 = this.this$0.state;
        boolean bl = true;
        if (n2 == 1) {
            return false;
        }
        if (this.this$0.touchingScrollingChild) {
            return false;
        }
        if (this.this$0.state == 3 && this.this$0.activePointerId == n && (view2 = (View)this.this$0.nestedScrollingChildRef.get()) != null && view2.canScrollVertically(-1)) {
            return false;
        }
        if (this.this$0.viewRef != null && this.this$0.viewRef.get() == view) return bl;
        bl = false;
        return bl;
    }
}
