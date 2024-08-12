/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout$LayoutParams
 *  com.qmuiteam.qmui.layout.QMUILinearLayout
 *  com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout$LayoutParams
 */
package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout;
import java.util.ArrayList;
import java.util.Iterator;

public class QMUIPriorityLinearLayout
extends QMUILinearLayout {
    private ArrayList<View> mTempDisposableChildList;
    private ArrayList<View> mTempMiniWidthChildList = new ArrayList();

    public QMUIPriorityLinearLayout(Context context) {
        super(context);
        this.mTempDisposableChildList = new ArrayList();
    }

    public QMUIPriorityLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempDisposableChildList = new ArrayList();
    }

    private int getVisibleChildCount() {
        int n = this.getChildCount();
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            int n4 = n3;
            if (this.getChildAt(n2).getVisibility() == 0) {
                n4 = n3 + 1;
            }
            ++n2;
            n3 = n4;
        }
        return n3;
    }

    private void handleHorizontal(int n, int n2) {
        int n3 = View.MeasureSpec.getSize((int)n) - this.getPaddingLeft() - this.getPaddingRight();
        int n4 = View.MeasureSpec.getMode((int)n);
        int n5 = this.getVisibleChildCount();
        if (n4 == 0) return;
        if (n5 == 0) return;
        if (n3 <= 0) return;
        if ((n = this.handlePriorityIncompressible(n, n2)) >= n3) {
            for (View view : this.mTempMiniWidthChildList) {
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                view.measure(View.MeasureSpec.makeMeasureSpec((int)layoutParams.miniContentProtectionSize, (int)Integer.MIN_VALUE), n2);
                layoutParams.width = view.getMeasuredWidth();
            }
            Iterator<View> object2 = this.mTempDisposableChildList.iterator();
            while (object2.hasNext()) {
                ((LayoutParams)object2.next().getLayoutParams()).width = 0;
            }
            return;
        }
        n5 = n3 - n;
        LayoutParams layoutParams = this.mTempMiniWidthChildList.iterator();
        n4 = 0;
        n = 0;
        while (layoutParams.hasNext()) {
            View view = layoutParams.next();
            LayoutParams layoutParams2 = (LayoutParams)view.getLayoutParams();
            view.measure(View.MeasureSpec.makeMeasureSpec((int)n3, (int)Integer.MIN_VALUE), n2);
            int n6 = layoutParams2.leftMargin + layoutParams2.rightMargin;
            n += view.getMeasuredWidth() + n6;
            n4 += Math.min(view.getMeasuredWidth(), layoutParams2.miniContentProtectionSize) + n6;
        }
        if (n4 >= n5) {
            for (View view : this.mTempMiniWidthChildList) {
                layoutParams = (LayoutParams)view.getLayoutParams();
                layoutParams.width = Math.min(view.getMeasuredWidth(), layoutParams.miniContentProtectionSize);
            }
            Iterator<View> iterator = this.mTempDisposableChildList.iterator();
            while (iterator.hasNext()) {
                ((LayoutParams)iterator.next().getLayoutParams()).width = 0;
            }
            return;
        }
        if (n < n5) {
            if (this.mTempDisposableChildList.isEmpty()) return;
            this.dispatchSpaceToDisposableChildList(this.mTempDisposableChildList, n5 - n);
        } else {
            Iterator<View> iterator = this.mTempDisposableChildList.iterator();
            while (iterator.hasNext()) {
                ((LayoutParams)iterator.next().getLayoutParams()).width = 0;
            }
            if (n5 >= n) return;
            if (this.mTempMiniWidthChildList.isEmpty()) return;
            this.dispatchSpaceToMiniWidthChildList(this.mTempMiniWidthChildList, n5, n);
        }
    }

    private int handlePriorityIncompressible(int n, int n2) {
        int n3 = View.MeasureSpec.getSize((int)n);
        int n4 = this.getPaddingLeft();
        int n5 = this.getPaddingRight();
        int n6 = View.MeasureSpec.getSize((int)n2);
        int n7 = this.getPaddingTop();
        int n8 = this.getPaddingBottom();
        this.mTempMiniWidthChildList.clear();
        this.mTempDisposableChildList.clear();
        int n9 = this.getOrientation();
        int n10 = 0;
        int n11 = 0;
        while (n10 < this.getChildCount()) {
            int n12;
            View view = this.getChildAt(n10);
            if (view.getVisibility() == 8) {
                n12 = n11;
            } else {
                int n13;
                int n14;
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                layoutParams.backupOrRestore();
                n12 = layoutParams.getPriority(n9);
                if (n9 == 0) {
                    n14 = layoutParams.leftMargin;
                    n13 = layoutParams.rightMargin;
                } else {
                    n14 = layoutParams.topMargin;
                    n13 = layoutParams.bottomMargin;
                }
                if (n12 == 3) {
                    if (n9 == 0) {
                        if (layoutParams.width >= 0) {
                            n12 = layoutParams.width;
                        } else {
                            view.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 - n4 - n5), (int)Integer.MIN_VALUE), n2);
                            n12 = view.getMeasuredWidth();
                        }
                    } else if (layoutParams.height >= 0) {
                        n12 = layoutParams.height;
                    } else {
                        view.measure(n, View.MeasureSpec.makeMeasureSpec((int)(n6 - n7 - n8), (int)Integer.MIN_VALUE));
                        n12 = view.getMeasuredHeight();
                    }
                    n12 = n11 + (n12 + (n14 + n13));
                } else if (n12 == 2) {
                    this.mTempMiniWidthChildList.add(view);
                    n12 = n11;
                } else {
                    n12 = n11;
                    if (layoutParams.weight == 0.0f) {
                        this.mTempDisposableChildList.add(view);
                        n12 = n11;
                    }
                }
            }
            ++n10;
            n11 = n12;
        }
        return n11;
    }

    private void handleVertical(int n, int n2) {
        View view;
        int n3 = View.MeasureSpec.getSize((int)n2) - this.getPaddingTop() - this.getPaddingBottom();
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = this.getVisibleChildCount();
        if (n4 == 0) return;
        if (n5 == 0) return;
        if (n3 <= 0) return;
        if ((n2 = this.handlePriorityIncompressible(n, n2)) >= n3) {
            for (View object22 : this.mTempMiniWidthChildList) {
                LayoutParams layoutParams = (LayoutParams)object22.getLayoutParams();
                object22.measure(n, View.MeasureSpec.makeMeasureSpec((int)layoutParams.miniContentProtectionSize, (int)Integer.MIN_VALUE));
                layoutParams.height = object22.getMeasuredHeight();
            }
            Iterator<View> object = this.mTempDisposableChildList.iterator();
            while (object.hasNext()) {
                ((LayoutParams)object.next().getLayoutParams()).height = 0;
            }
            return;
        }
        n5 = n3 - n2;
        View view222 = this.mTempMiniWidthChildList.iterator();
        n4 = 0;
        n2 = 0;
        while (view222.hasNext()) {
            view = view222.next();
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            view.measure(n, View.MeasureSpec.makeMeasureSpec((int)n3, (int)Integer.MIN_VALUE));
            int n6 = layoutParams.topMargin + layoutParams.bottomMargin;
            n2 += view.getMeasuredHeight() + n6;
            n4 += Math.min(view.getMeasuredHeight(), layoutParams.miniContentProtectionSize) + n6;
        }
        if (n4 >= n5) {
            for (View view222 : this.mTempMiniWidthChildList) {
                view = (LayoutParams)view222.getLayoutParams();
                view.height = Math.min(view222.getMeasuredHeight(), view.miniContentProtectionSize);
            }
            Iterator<View> iterator = this.mTempDisposableChildList.iterator();
            while (iterator.hasNext()) {
                ((LayoutParams)iterator.next().getLayoutParams()).height = 0;
            }
            return;
        }
        if (n2 < n5) {
            if (this.mTempDisposableChildList.isEmpty()) return;
            this.dispatchSpaceToDisposableChildList(this.mTempDisposableChildList, n5 - n2);
        } else {
            Iterator<View> iterator = this.mTempDisposableChildList.iterator();
            while (iterator.hasNext()) {
                ((LayoutParams)iterator.next().getLayoutParams()).width = 0;
            }
            if (n5 >= n2) return;
            if (this.mTempMiniWidthChildList.isEmpty()) return;
            this.dispatchSpaceToMiniWidthChildList(this.mTempMiniWidthChildList, n5, n2);
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl = layoutParams instanceof LayoutParams && super.checkLayoutParams(layoutParams);
        return bl;
    }

    protected void dispatchSpaceToDisposableChildList(ArrayList<View> layoutParams, int n) {
        Iterator<View> iterator = layoutParams.iterator();
        while (iterator.hasNext()) {
            int n2;
            int n3;
            LayoutParams layoutParams2 = (LayoutParams)iterator.next().getLayoutParams();
            if (this.getOrientation() == 0) {
                n3 = layoutParams2.leftMargin;
                n2 = layoutParams2.rightMargin;
            } else {
                n3 = layoutParams2.topMargin;
                n2 = layoutParams2.bottomMargin;
            }
            n -= n3 - n2;
        }
        n = Math.max(0, n / layoutParams.size());
        iterator = layoutParams.iterator();
        while (iterator.hasNext()) {
            layoutParams = (LayoutParams)iterator.next().getLayoutParams();
            if (this.getOrientation() == 0) {
                layoutParams.width = n;
                continue;
            }
            layoutParams.height = n;
        }
    }

    protected void dispatchSpaceToMiniWidthChildList(ArrayList<View> object, int n, int n2) {
        if ((n = n2 - n) <= 0) return;
        object = ((ArrayList)object).iterator();
        while (object.hasNext()) {
            float f;
            View view = (View)object.next();
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            if (this.getOrientation() == 0) {
                f = (float)(view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin) * 1.0f / (float)n2;
                layoutParams.width = Math.max(0, (int)((float)view.getMeasuredWidth() - (float)n * f));
                continue;
            }
            f = (float)(view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin) * 1.0f / (float)n2;
            layoutParams.height = Math.max(0, (int)((float)view.getMeasuredHeight() - (float)n * f));
        }
    }

    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected void onMeasure(int n, int n2) {
        if (this.getOrientation() == 0) {
            this.handleHorizontal(n, n2);
        } else {
            this.handleVertical(n, n2);
        }
        super.onMeasure(n, n2);
    }
}
