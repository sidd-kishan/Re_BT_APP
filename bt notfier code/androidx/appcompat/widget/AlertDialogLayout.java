/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  androidx.appcompat.R$id
 *  androidx.appcompat.widget.LinearLayoutCompat
 *  androidx.appcompat.widget.LinearLayoutCompat$LayoutParams
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class AlertDialogLayout
extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void forceUniformWidth(int n, int n2) {
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0x40000000);
        int n4 = 0;
        while (n4 < n) {
            View view = this.getChildAt(n4);
            if (view.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams)view.getLayoutParams();
                if (layoutParams.width == -1) {
                    int n5 = layoutParams.height;
                    layoutParams.height = view.getMeasuredHeight();
                    this.measureChildWithMargins(view, n3, 0, n2, 0);
                    layoutParams.height = n5;
                }
            }
            ++n4;
        }
    }

    private static int resolveMinimumHeight(View view) {
        int n = ViewCompat.getMinimumHeight((View)view);
        if (n > 0) {
            return n;
        }
        if (!(view instanceof ViewGroup)) return 0;
        if ((view = (ViewGroup)view).getChildCount() != 1) return 0;
        return AlertDialogLayout.resolveMinimumHeight(view.getChildAt(0));
    }

    private void setChildFrame(View view, int n, int n2, int n3, int n4) {
        view.layout(n, n2, n3 + n, n4 + n2);
    }

    private boolean tryOnMeasure(int n, int n2) {
        int n3;
        int n4;
        int n5;
        int n6;
        View view;
        int n7;
        int n8 = this.getChildCount();
        View view2 = null;
        View view3 = null;
        View view4 = null;
        for (n7 = 0; n7 < n8; ++n7) {
            view = this.getChildAt(n7);
            if (view.getVisibility() == 8) continue;
            n6 = view.getId();
            if (n6 == R.id.topPanel) {
                view2 = view;
                continue;
            }
            if (n6 == R.id.buttonPanel) {
                view3 = view;
                continue;
            }
            if (n6 != R.id.contentPanel) {
                if (n6 != R.id.customPanel) return false;
            }
            if (view4 != null) {
                return false;
            }
            view4 = view;
        }
        int n9 = View.MeasureSpec.getMode((int)n2);
        int n10 = View.MeasureSpec.getSize((int)n2);
        int n11 = View.MeasureSpec.getMode((int)n);
        int n12 = this.getPaddingTop() + this.getPaddingBottom();
        if (view2 != null) {
            view2.measure(n, 0);
            n12 += view2.getMeasuredHeight();
            n6 = View.combineMeasuredStates((int)0, (int)view2.getMeasuredState());
        } else {
            n6 = 0;
        }
        if (view3 != null) {
            view3.measure(n, 0);
            n7 = AlertDialogLayout.resolveMinimumHeight(view3);
            n5 = view3.getMeasuredHeight() - n7;
            n12 += n7;
            n6 = View.combineMeasuredStates((int)n6, (int)view3.getMeasuredState());
        } else {
            n7 = 0;
            n5 = 0;
        }
        if (view4 != null) {
            n4 = n9 == 0 ? 0 : View.MeasureSpec.makeMeasureSpec((int)Math.max(0, n10 - n12), (int)n9);
            view4.measure(n, n4);
            n3 = view4.getMeasuredHeight();
            n12 += n3;
            n6 = View.combineMeasuredStates((int)n6, (int)view4.getMeasuredState());
        } else {
            n3 = 0;
        }
        int n13 = n10 - n12;
        n10 = n6;
        int n14 = n13;
        n4 = n12;
        if (view3 != null) {
            n5 = Math.min(n13, n5);
            n10 = n13;
            n4 = n7;
            if (n5 > 0) {
                n10 = n13 - n5;
                n4 = n7 + n5;
            }
            view3.measure(n, View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000));
            n4 = n12 - n7 + view3.getMeasuredHeight();
            n7 = View.combineMeasuredStates((int)n6, (int)view3.getMeasuredState());
            n14 = n10;
            n10 = n7;
        }
        n6 = n10;
        n7 = n4;
        if (view4 != null) {
            n6 = n10;
            n7 = n4;
            if (n14 > 0) {
                view4.measure(n, View.MeasureSpec.makeMeasureSpec((int)(n3 + n14), (int)n9));
                n7 = n4 - n3 + view4.getMeasuredHeight();
                n6 = View.combineMeasuredStates((int)n10, (int)view4.getMeasuredState());
            }
        }
        n4 = 0;
        n12 = 0;
        while (true) {
            if (n4 >= n8) {
                this.setMeasuredDimension(View.resolveSizeAndState((int)(n12 + (this.getPaddingLeft() + this.getPaddingRight())), (int)n, (int)n6), View.resolveSizeAndState((int)n7, (int)n2, (int)0));
                if (n11 == 0x40000000) return true;
                this.forceUniformWidth(n8, n2);
                return true;
            }
            view = this.getChildAt(n4);
            n10 = n12;
            if (view.getVisibility() != 8) {
                n10 = Math.max(n12, view.getMeasuredWidth());
            }
            ++n4;
            n12 = n10;
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        int n5 = this.getPaddingLeft();
        int n6 = n3 - n;
        int n7 = this.getPaddingRight();
        int n8 = this.getPaddingRight();
        n3 = this.getMeasuredHeight();
        int n9 = this.getChildCount();
        int n10 = this.getGravity();
        n = n10 & 0x70;
        n = n != 16 ? (n != 80 ? this.getPaddingTop() : this.getPaddingTop() + n4 - n2 - n3) : this.getPaddingTop() + (n4 - n2 - n3) / 2;
        Drawable drawable = this.getDividerDrawable();
        n2 = drawable == null ? 0 : drawable.getIntrinsicHeight();
        n3 = 0;
        while (n3 < n9) {
            block3: {
                int n11;
                LinearLayoutCompat.LayoutParams layoutParams;
                int n12;
                int n13;
                block6: {
                    block7: {
                        block4: {
                            block5: {
                                drawable = this.getChildAt(n3);
                                n4 = n;
                                if (drawable == null) break block3;
                                n4 = n;
                                if (drawable.getVisibility() == 8) break block3;
                                n13 = drawable.getMeasuredWidth();
                                n12 = drawable.getMeasuredHeight();
                                layoutParams = (LinearLayoutCompat.LayoutParams)drawable.getLayoutParams();
                                n4 = n11 = layoutParams.gravity;
                                if (n11 < 0) {
                                    n4 = n10 & 0x800007;
                                }
                                if ((n4 = GravityCompat.getAbsoluteGravity((int)n4, (int)ViewCompat.getLayoutDirection((View)this)) & 7) == 1) break block4;
                                if (n4 == 5) break block5;
                                n4 = layoutParams.leftMargin + n5;
                                break block6;
                            }
                            n4 = n6 - n7 - n13;
                            n11 = layoutParams.rightMargin;
                            break block7;
                        }
                        n4 = (n6 - n5 - n8 - n13) / 2 + n5 + layoutParams.leftMargin;
                        n11 = layoutParams.rightMargin;
                    }
                    n4 -= n11;
                }
                n11 = n;
                if (this.hasDividerBeforeChildAt(n3)) {
                    n11 = n + n2;
                }
                n = n11 + layoutParams.topMargin;
                this.setChildFrame((View)drawable, n4, n, n13, n12);
                n4 = n + (n12 + layoutParams.bottomMargin);
            }
            ++n3;
            n = n4;
        }
    }

    protected void onMeasure(int n, int n2) {
        if (this.tryOnMeasure(n, n2)) return;
        super.onMeasure(n, n2);
    }
}
