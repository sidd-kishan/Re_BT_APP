/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.core.view.NestedScrollingChild2
 *  androidx.core.view.NestedScrollingChildHelper
 *  androidx.core.view.NestedScrollingParent2
 *  androidx.core.view.NestedScrollingParentHelper
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon$OnScrollNotifier
 *  com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIViewOffsetHelper
 */
package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedTopView;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;

public class QMUIContinuousNestedTopDelegateLayout
extends FrameLayout
implements NestedScrollingChild2,
NestedScrollingParent2,
IQMUIContinuousNestedTopView {
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_top_dl_offset";
    private Runnable mCheckLayoutAction = new /* Unavailable Anonymous Inner Class!! */;
    private final NestedScrollingChildHelper mChildHelper;
    private IQMUIContinuousNestedTopView mDelegateView;
    private QMUIViewOffsetHelper mDelegateViewOffsetHelper;
    private View mFooterView;
    private QMUIViewOffsetHelper mFooterViewOffsetHelper;
    private View mHeaderView;
    private QMUIViewOffsetHelper mHeaderViewOffsetHelper;
    private int mOffsetCurrent = 0;
    private int mOffsetRange = 0;
    private final NestedScrollingParentHelper mParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mScrollNotifier;

    public QMUIContinuousNestedTopDelegateLayout(Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedTopDelegateLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIContinuousNestedTopDelegateLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mChildHelper = new NestedScrollingChildHelper((View)this);
        ViewCompat.setNestedScrollingEnabled((View)this, (boolean)true);
        this.setClipToPadding(false);
    }

    private void offsetTo(int n) {
        this.mOffsetCurrent = n;
        QMUIViewOffsetHelper qMUIViewOffsetHelper = this.mHeaderViewOffsetHelper;
        if (qMUIViewOffsetHelper != null) {
            qMUIViewOffsetHelper.setTopAndBottomOffset(-n);
        }
        if ((qMUIViewOffsetHelper = this.mDelegateViewOffsetHelper) != null) {
            qMUIViewOffsetHelper.setTopAndBottomOffset(-n);
        }
        if ((qMUIViewOffsetHelper = this.mFooterViewOffsetHelper) != null) {
            qMUIViewOffsetHelper.setTopAndBottomOffset(-n);
        }
        if ((qMUIViewOffsetHelper = this.mScrollNotifier) == null) return;
        qMUIViewOffsetHelper.notify(this.getCurrentScroll(), this.getScrollOffsetRange());
    }

    public void checkLayout() {
        int n;
        if (this.mHeaderView == null && this.mFooterView == null) {
            return;
        }
        if (this.mDelegateView == null) {
            return;
        }
        int n2 = this.getContainerHeaderOffsetRange();
        int n3 = this.mDelegateView.getCurrentScroll();
        int n4 = this.mDelegateView.getScrollOffsetRange();
        if (n3 > 0 && this.mHeaderView != null && (n = this.mOffsetCurrent) < n2) {
            if ((n = n2 - n) >= n3) {
                this.mDelegateView.consumeScroll(Integer.MIN_VALUE);
                this.offsetTo(this.mOffsetCurrent + n3);
            } else {
                this.mDelegateView.consumeScroll(-n);
                this.offsetTo(n2);
            }
        }
        if ((n = this.mOffsetCurrent) <= n2) return;
        if (n3 >= n4) return;
        if (this.mFooterView == null) return;
        if ((n -= n2) >= (n3 = n4 - n3)) {
            this.mDelegateView.consumeScroll(Integer.MAX_VALUE);
            this.offsetTo(n2 + n - n3);
        } else {
            this.mDelegateView.consumeScroll(n);
            this.offsetTo(n2);
        }
    }

    /*
     * Enabled force condition propagation
     */
    public int consumeScroll(int n) {
        int n2;
        int n3 = this.mOffsetRange;
        if (n3 <= 0) {
            IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
            int n4 = n;
            if (iQMUIContinuousNestedTopView == null) return n4;
            return iQMUIContinuousNestedTopView.consumeScroll(n);
        }
        if (n > 0) {
            if (this.mDelegateView == null) {
                if (n == Integer.MAX_VALUE) {
                    this.offsetTo(n3);
                    return n;
                }
                int n5 = this.mOffsetCurrent;
                if (n5 + n <= n3) {
                    this.offsetTo(n5 + n);
                    return 0;
                }
                int n6 = n;
                if (n5 >= n3) return n6;
                n6 = n - (n3 - n5);
                this.offsetTo(n3);
                return n6;
            }
            int n7 = this.getPaddingTop();
            View view = this.mHeaderView;
            n2 = view == null ? 0 : view.getHeight();
            n3 = Math.min(n3, n7 + n2);
            if (n == Integer.MAX_VALUE) {
                this.offsetTo(n3);
                n2 = n;
            } else {
                n7 = this.mOffsetCurrent;
                if (n7 + n <= n3) {
                    this.offsetTo(n7 + n);
                    return 0;
                }
                n2 = n;
                if (n7 < n3) {
                    n2 = n - (n3 - n7);
                    this.offsetTo(n3);
                }
            }
            n2 = this.mDelegateView.consumeScroll(n2);
            if (n2 <= 0) {
                return n2;
            }
            if (n2 == Integer.MAX_VALUE) {
                this.offsetTo(this.mOffsetRange);
                return n2;
            }
            n = this.mOffsetCurrent;
            n3 = this.mOffsetRange;
            if (n + n2 <= n3) {
                this.offsetTo(n + n2);
                return 0;
            }
            this.offsetTo(n3);
            return n2 - (n3 - n);
        }
        n2 = n;
        if (n >= 0) return n2;
        if (this.mDelegateView == null) {
            if (n == Integer.MIN_VALUE) {
                this.offsetTo(0);
                return n;
            }
            n3 = this.mOffsetCurrent;
            if (n3 + n >= 0) {
                this.offsetTo(n3 + n);
                return 0;
            }
            n2 = n;
            if (n3 <= 0) return n2;
            n2 = n + n3;
            this.offsetTo(0);
            return n2;
        }
        int n8 = this.getPaddingBottom();
        View view = this.mFooterView;
        n2 = view == null ? 0 : view.getHeight();
        n3 = Math.max(0, n3 - n8 - n2);
        if (n == Integer.MIN_VALUE) {
            this.offsetTo(n3);
            n2 = n;
        } else {
            n8 = this.mOffsetCurrent;
            if (n8 + n > n3) {
                this.offsetTo(n8 + n);
                return 0;
            }
            n2 = n;
            if (n8 > n3) {
                n2 = n + (n8 - n3);
                this.offsetTo(n3);
            }
        }
        n = this.mDelegateView.consumeScroll(n2);
        if (n >= 0) {
            return n;
        }
        if (n == Integer.MIN_VALUE) {
            this.offsetTo(0);
            return n;
        }
        n3 = this.mOffsetCurrent;
        if (n3 + n > 0) {
            this.offsetTo(n3 + n);
            return 0;
        }
        n2 = n;
        if (n3 <= 0) return n2;
        n2 = n + n3;
        this.offsetTo(0);
        return n2;
    }

    public boolean dispatchNestedFling(float f, float f2, boolean bl) {
        return this.mChildHelper.dispatchNestedFling(f, f2, bl);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2) {
        return this.dispatchNestedPreScroll(n, n2, nArray, nArray2, 0);
    }

    public boolean dispatchNestedPreScroll(int n, int n2, int[] nArray, int[] nArray2, int n3) {
        return this.mChildHelper.dispatchNestedPreScroll(n, n2, nArray, nArray2, n3);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray) {
        return this.dispatchNestedScroll(n, n2, n3, n4, nArray, 0);
    }

    public boolean dispatchNestedScroll(int n, int n2, int n3, int n4, int[] nArray, int n5) {
        return this.mChildHelper.dispatchNestedScroll(n, n2, n3, n4, nArray, n5);
    }

    public int getContainerHeaderOffsetRange() {
        if (this.mOffsetRange == 0) return 0;
        if (this.mHeaderView != null) return Math.min(this.getPaddingTop() + this.mHeaderView.getHeight(), this.mOffsetRange);
        return 0;
    }

    public int getContainerOffsetCurrent() {
        return this.mOffsetCurrent;
    }

    public int getContainerOffsetRange() {
        return this.mOffsetRange;
    }

    public int getCurrentScroll() {
        int n = this.mOffsetCurrent;
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        int n2 = n;
        if (iQMUIContinuousNestedTopView == null) return n2;
        n2 = n + iQMUIContinuousNestedTopView.getCurrentScroll();
        return n2;
    }

    public IQMUIContinuousNestedTopView getDelegateView() {
        return this.mDelegateView;
    }

    public View getFooterView() {
        return this.mFooterView;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public int getScrollOffsetRange() {
        int n = this.mOffsetRange;
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        int n2 = n;
        if (iQMUIContinuousNestedTopView == null) return n2;
        n2 = n + iQMUIContinuousNestedTopView.getScrollOffsetRange();
        return n2;
    }

    public boolean hasNestedScrollingParent() {
        return this.hasNestedScrollingParent(0);
    }

    public boolean hasNestedScrollingParent(int n) {
        return this.mChildHelper.hasNestedScrollingParent(n);
    }

    public void injectScrollNotifier(IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mScrollNotifier = onScrollNotifier;
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        if (iQMUIContinuousNestedTopView == null) return;
        iQMUIContinuousNestedTopView.injectScrollNotifier((IQMUIContinuousNestedScrollCommon.OnScrollNotifier)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        int n5 = n3 - n;
        n = this.getPaddingTop();
        View view = this.mHeaderView;
        n3 = n;
        if (view != null) {
            n3 = view.getMeasuredHeight();
            view = this.mHeaderView;
            view.layout(0, n, n5, n3 += n);
        }
        view = this.mDelegateView;
        n = n3;
        if (view != null) {
            n = view.getMeasuredHeight() + n3;
            view.layout(0, n3, n5, n);
        }
        view = this.mFooterView;
        n3 = n;
        if (view != null) {
            n3 = view.getMeasuredHeight();
            view = this.mFooterView;
            view.layout(0, n, n5, n3 += n);
        }
        this.mOffsetRange = Math.max(0, n3 + this.getPaddingBottom() - (n4 - n2));
        view = this.mHeaderViewOffsetHelper;
        if (view != null) {
            view.onViewLayout();
            this.mOffsetCurrent = -this.mHeaderViewOffsetHelper.getTopAndBottomOffset();
        }
        if ((view = this.mDelegateViewOffsetHelper) != null) {
            view.onViewLayout();
            this.mOffsetCurrent = -this.mDelegateViewOffsetHelper.getTopAndBottomOffset();
        }
        if ((view = this.mFooterViewOffsetHelper) != null) {
            view.onViewLayout();
            this.mOffsetCurrent = -this.mFooterViewOffsetHelper.getTopAndBottomOffset();
        }
        this.postCheckLayout();
    }

    protected void onMeasure(int n, int n2) {
        int n3 = View.MeasureSpec.getSize((int)n);
        int n4 = View.MeasureSpec.getSize((int)n2);
        int n5 = this.getPaddingTop();
        View view = this.mHeaderView;
        n2 = n5;
        if (view != null) {
            view.measure(n, View.MeasureSpec.makeMeasureSpec((int)n4, (int)0));
            n2 = n5 + this.mHeaderView.getMeasuredHeight();
        }
        view = this.mDelegateView;
        n5 = n2;
        if (view != null) {
            view.measure(n, View.MeasureSpec.makeMeasureSpec((int)n4, (int)Integer.MIN_VALUE));
            n5 = n2 + view.getMeasuredHeight();
        }
        view = this.mFooterView;
        n2 = n5;
        if (view != null) {
            view.measure(n, View.MeasureSpec.makeMeasureSpec((int)n4, (int)0));
            n2 = n5 + this.mFooterView.getMeasuredHeight();
        }
        if ((n = n2 + this.getPaddingBottom()) < n4) {
            this.setMeasuredDimension(n3, n);
        } else {
            this.setMeasuredDimension(n3, n4);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return this.dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray) {
        this.onNestedPreScroll(view, n, n2, nArray, 0);
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray, int n3) {
        this.dispatchNestedPreScroll(n, n2, nArray, null, n3);
        n3 = n2 - nArray[1];
        n = 0;
        n2 = 0;
        if (n3 > 0) {
            int n4 = this.getPaddingTop();
            view = this.mHeaderView;
            n = view == null ? n2 : view.getHeight();
            n = this.mOffsetCurrent;
            n2 = n4 + n;
            if (n + n3 <= n2) {
                this.offsetTo(n + n3);
                nArray[1] = nArray[1] + n3;
            } else {
                if (n >= n2) return;
                nArray[1] = nArray[1] + (n2 - n);
                this.offsetTo(n2);
            }
        } else {
            if (n3 >= 0) return;
            n2 = this.getPaddingBottom();
            view = this.mFooterView;
            if (view != null) {
                n = view.getHeight();
            }
            if ((n2 = this.mOffsetCurrent) + n3 >= (n = this.mOffsetRange - (n2 + n))) {
                this.offsetTo(n2 + n3);
                nArray[1] = nArray[1] + n3;
            } else {
                if (n2 <= n) return;
                nArray[1] = nArray[1] + (n - n2);
                this.offsetTo(n);
            }
        }
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4) {
        this.onNestedScroll(view, n, n2, n3, n4, 0);
    }

    /*
     * Unable to fully structure code
     */
    public void onNestedScroll(View var1_1, int var2_2, int var3_3, int var4_4, int var5_5, int var6_6) {
        block10: {
            block8: {
                block9: {
                    var4_4 = 0;
                    if (var5_5 <= 0) break block8;
                    var8_7 = this.mOffsetCurrent;
                    var7_8 = this.mOffsetRange;
                    if (var8_7 + var5_5 > var7_8) break block9;
                    this.offsetTo(var8_7 + var5_5);
                    ** GOTO lbl20
                }
                var2_2 = var4_4;
                if (var8_7 <= var7_8) {
                    var2_2 = var7_8 - var8_7;
                    this.offsetTo(var7_8);
                }
                break block10;
            }
            var2_2 = var4_4;
            if (var5_5 >= 0) break block10;
            var7_9 = this.mOffsetCurrent;
            if (var7_9 + var5_5 >= 0) {
                this.offsetTo(var7_9 + var5_5);
lbl20:
                // 2 sources

                var2_2 = var5_5;
            } else {
                var2_2 = var4_4;
                if (var7_9 >= 0) {
                    var2_2 = -var7_9;
                    this.offsetTo(0);
                }
            }
        }
        this.dispatchNestedScroll(0, var3_3 + var2_2, 0, var5_5 - var2_2, null, var6_6);
    }

    public void onNestedScrollAccepted(View view, View view2, int n) {
        this.onNestedScrollAccepted(view, view2, n, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n, n2);
        this.startNestedScroll(2, n2);
    }

    public boolean onStartNestedScroll(View view, View view2, int n) {
        return this.onStartNestedScroll(view, view2, n, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int n, int n2) {
        boolean bl = (n & 2) != 0;
        return bl;
    }

    public void onStopNestedScroll(View view) {
        this.onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int n) {
        this.mParentHelper.onStopNestedScroll(view, n);
        this.stopNestedScroll(n);
    }

    public void postCheckLayout() {
        this.removeCallbacks(this.mCheckLayoutAction);
        this.post(this.mCheckLayoutAction);
    }

    public void restoreScrollInfo(Bundle bundle) {
        this.offsetTo(QMUILangHelper.constrain((int)(-bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0)), (int)0, (int)this.getContainerOffsetRange()));
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        if (iQMUIContinuousNestedTopView == null) return;
        iQMUIContinuousNestedTopView.restoreScrollInfo(bundle);
    }

    public void saveScrollInfo(Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, -this.mOffsetCurrent);
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mDelegateView;
        if (iQMUIContinuousNestedTopView == null) return;
        iQMUIContinuousNestedTopView.saveScrollInfo(bundle);
    }

    public void setDelegateView(IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView) {
        if (!(iQMUIContinuousNestedTopView instanceof View)) throw new IllegalArgumentException("delegateView must be a instance of View");
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView2 = this.mDelegateView;
        if (iQMUIContinuousNestedTopView2 != null) {
            iQMUIContinuousNestedTopView2.injectScrollNotifier(null);
        }
        this.mDelegateView = iQMUIContinuousNestedTopView;
        iQMUIContinuousNestedTopView = (View)iQMUIContinuousNestedTopView;
        this.mDelegateViewOffsetHelper = new QMUIViewOffsetHelper((View)iQMUIContinuousNestedTopView);
        this.addView((View)iQMUIContinuousNestedTopView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }

    public void setFooterView(View view) {
        this.mFooterView = view;
        this.mFooterViewOffsetHelper = new QMUIViewOffsetHelper(view);
        this.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }

    public void setHeaderView(View view) {
        this.mHeaderView = view;
        this.mHeaderViewOffsetHelper = new QMUIViewOffsetHelper(view);
        this.addView(view, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    }

    public void setNestedScrollingEnabled(boolean bl) {
        this.mChildHelper.setNestedScrollingEnabled(bl);
    }

    public boolean startNestedScroll(int n) {
        return this.startNestedScroll(n, 0);
    }

    public boolean startNestedScroll(int n, int n2) {
        return this.mChildHelper.startNestedScroll(n, n2);
    }

    public void stopNestedScroll() {
        this.stopNestedScroll(0);
    }

    public void stopNestedScroll(int n) {
        this.mChildHelper.stopNestedScroll(n);
    }
}
