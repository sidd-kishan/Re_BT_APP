/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.widget.LinearLayoutCompat$LayoutParams
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.core.view.GravityCompat
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class LinearLayoutCompat
extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned = true;
    private int mBaselineAlignedChildIndex = -1;
    private int mBaselineChildTop = 0;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity = 0x800033;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        boolean bl;
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.LinearLayoutCompat, (int)n, (int)0);
        ViewCompat.saveAttributeDataForStyleable((View)this, (Context)context, (int[])R.styleable.LinearLayoutCompat, (AttributeSet)attributeSet, (TypedArray)tintTypedArray.getWrappedTypeArray(), (int)n, (int)0);
        n = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (n >= 0) {
            this.setOrientation(n);
        }
        if ((n = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1)) >= 0) {
            this.setGravity(n);
        }
        if (!(bl = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true))) {
            this.setBaselineAligned(bl);
        }
        this.mWeightSum = tintTypedArray.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArray.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        this.setDividerDrawable(tintTypedArray.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArray.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArray.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArray.recycle();
    }

    private void forceUniformHeight(int n, int n2) {
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0x40000000);
        int n4 = 0;
        while (n4 < n) {
            View view = this.getVirtualChildAt(n4);
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                if (layoutParams.height == -1) {
                    int n5 = layoutParams.width;
                    layoutParams.width = view.getMeasuredWidth();
                    this.measureChildWithMargins(view, n2, 0, n3, 0);
                    layoutParams.width = n5;
                }
            }
            ++n4;
        }
    }

    private void forceUniformWidth(int n, int n2) {
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0x40000000);
        int n4 = 0;
        while (n4 < n) {
            View view = this.getVirtualChildAt(n4);
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
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

    private void setChildFrame(View view, int n, int n2, int n3, int n4) {
        view.layout(n, n2, n3 + n, n4 + n2);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /*
     * Unable to fully structure code
     */
    void drawDividersHorizontal(Canvas var1_1) {
        block5: {
            block3: {
                block4: {
                    var4_2 = this.getVirtualChildCount();
                    var5_3 = ViewUtils.isLayoutRtl((View)this);
                    for (var2_4 = 0; var2_4 < var4_2; ++var2_4) {
                        var6_6 = this.getVirtualChildAt(var2_4);
                        if (var6_6 == null || var6_6.getVisibility() == 8 || !this.hasDividerBeforeChildAt(var2_4)) continue;
                        var7_7 = (LayoutParams)var6_6.getLayoutParams();
                        var3_5 = var5_3 != false ? var6_6.getRight() + var7_7.rightMargin : var6_6.getLeft() - var7_7.leftMargin - this.mDividerWidth;
                        this.drawVerticalDivider(var1_1, var3_5);
                    }
                    if (this.hasDividerBeforeChildAt(var4_2) == false) return;
                    var6_6 = this.getVirtualChildAt(var4_2 - 1);
                    if (var6_6 != null) break block3;
                    if (!var5_3) break block4;
                    var2_4 = this.getPaddingLeft();
                    break block5;
                }
                var2_4 = this.getWidth() - this.getPaddingRight();
                var3_5 = this.mDividerWidth;
                ** GOTO lbl25
            }
            var7_7 = (LayoutParams)var6_6.getLayoutParams();
            if (var5_3) {
                var2_4 = var6_6.getLeft() - var7_7.leftMargin;
                var3_5 = this.mDividerWidth;
lbl25:
                // 2 sources

                var2_4 -= var3_5;
            } else {
                var2_4 = var6_6.getRight() + var7_7.rightMargin;
            }
        }
        this.drawVerticalDivider(var1_1, var2_4);
    }

    void drawDividersVertical(Canvas canvas) {
        View view;
        View view2;
        int n;
        int n2 = this.getVirtualChildCount();
        for (n = 0; n < n2; ++n) {
            view2 = this.getVirtualChildAt(n);
            if (view2 == null || view2.getVisibility() == 8 || !this.hasDividerBeforeChildAt(n)) continue;
            view = (LayoutParams)view2.getLayoutParams();
            this.drawHorizontalDivider(canvas, view2.getTop() - view.topMargin - this.mDividerHeight);
        }
        if (!this.hasDividerBeforeChildAt(n2)) return;
        view = this.getVirtualChildAt(n2 - 1);
        if (view == null) {
            n = this.getHeight() - this.getPaddingBottom() - this.mDividerHeight;
        } else {
            view2 = (LayoutParams)view.getLayoutParams();
            n = view.getBottom() + view2.bottomMargin;
        }
        this.drawHorizontalDivider(canvas, n);
    }

    void drawHorizontalDivider(Canvas canvas, int n) {
        this.mDivider.setBounds(this.getPaddingLeft() + this.mDividerPadding, n, this.getWidth() - this.getPaddingRight() - this.mDividerPadding, this.mDividerHeight + n);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int n) {
        this.mDivider.setBounds(n, this.getPaddingTop() + this.mDividerPadding, this.mDividerWidth + n, this.getHeight() - this.getPaddingBottom() - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        int n = this.mOrientation;
        if (n == 0) {
            return new LayoutParams(-2, -2);
        }
        if (n != 1) return null;
        return new LayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getBaseline() {
        int n;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int n2 = this.getChildCount();
        if (n2 <= (n = this.mBaselineAlignedChildIndex)) throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        View view = this.getChildAt(n);
        int n3 = view.getBaseline();
        if (n3 == -1) {
            if (this.mBaselineAlignedChildIndex != 0) throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            return -1;
        }
        n2 = n = this.mBaselineChildTop;
        if (this.mOrientation != 1) return n2 + ((LayoutParams)view.getLayoutParams()).topMargin + n3;
        int n4 = this.mGravity & 0x70;
        n2 = n;
        if (n4 == 48) return n2 + ((LayoutParams)view.getLayoutParams()).topMargin + n3;
        n2 = n4 != 16 ? (n4 != 80 ? n : this.getBottom() - this.getTop() - this.getPaddingBottom() - this.mTotalLength) : n + (this.getBottom() - this.getTop() - this.getPaddingTop() - this.getPaddingBottom() - this.mTotalLength) / 2;
        return n2 + ((LayoutParams)view.getLayoutParams()).topMargin + n3;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int n) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int n) {
        return this.getChildAt(n);
    }

    int getVirtualChildCount() {
        return this.getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int n) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (n == 0) {
            if ((this.mShowDividers & 1) == 0) return bl3;
            bl3 = true;
            return bl3;
        }
        if (n == this.getChildCount()) {
            bl3 = bl;
            if ((this.mShowDividers & 4) == 0) return bl3;
            bl3 = true;
            return bl3;
        }
        bl3 = bl2;
        if ((this.mShowDividers & 2) == 0) return bl3;
        --n;
        while (true) {
            bl3 = bl2;
            if (n < 0) return bl3;
            if (this.getChildAt(n).getVisibility() != 8) {
                bl3 = true;
                return bl3;
            }
            --n;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    void layoutHorizontal(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        boolean bl = ViewUtils.isLayoutRtl((View)this);
        int n7 = this.getPaddingTop();
        int n8 = n4 - n2;
        int n9 = this.getPaddingBottom();
        int n10 = this.getPaddingBottom();
        int n11 = this.getVirtualChildCount();
        n2 = this.mGravity;
        n4 = n2 & 0x70;
        boolean bl2 = this.mBaselineAligned;
        int[] nArray = this.mMaxAscent;
        int[] nArray2 = this.mMaxDescent;
        n2 = (n2 = GravityCompat.getAbsoluteGravity((int)(0x800007 & n2), (int)ViewCompat.getLayoutDirection((View)this))) != 1 ? (n2 != 5 ? this.getPaddingLeft() : this.getPaddingLeft() + n3 - n - this.mTotalLength) : this.getPaddingLeft() + (n3 - n - this.mTotalLength) / 2;
        if (bl) {
            n6 = n11 - 1;
            n5 = -1;
        } else {
            n6 = 0;
            n5 = 1;
        }
        int n12 = 0;
        n3 = n4;
        n4 = n7;
        while (n12 < n11) {
            int n13 = n6 + n5 * n12;
            View view = this.getVirtualChildAt(n13);
            if (view == null) {
                n2 += this.measureNullChild(n13);
            } else if (view.getVisibility() != 8) {
                int n14;
                int n15 = view.getMeasuredWidth();
                int n16 = view.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                int n17 = bl2 && layoutParams.height != -1 ? view.getBaseline() : -1;
                n = n14 = layoutParams.gravity;
                if (n14 < 0) {
                    n = n3;
                }
                if ((n &= 0x70) != 16) {
                    if (n != 48) {
                        if (n != 80) {
                            n = n4;
                        } else {
                            n = n14 = n8 - n9 - n16 - layoutParams.bottomMargin;
                            if (n17 != -1) {
                                n = view.getMeasuredHeight();
                                n = n14 - (nArray2[2] - (n - n17));
                            }
                        }
                    } else {
                        n = n14 = layoutParams.topMargin + n4;
                        if (n17 != -1) {
                            n = n14 + (nArray[1] - n17);
                        }
                    }
                } else {
                    n = (n8 - n7 - n10 - n16) / 2 + n4 + layoutParams.topMargin - layoutParams.bottomMargin;
                }
                n17 = n2;
                if (this.hasDividerBeforeChildAt(n13)) {
                    n17 = n2 + this.mDividerWidth;
                }
                n2 = layoutParams.leftMargin + n17;
                this.setChildFrame(view, n2 + this.getLocationOffset(view), n, n15, n16);
                n = layoutParams.rightMargin;
                n17 = this.getNextLocationOffset(view);
                n12 += this.getChildrenSkipCount(view, n13);
                n2 += n15 + n + n17;
            }
            ++n12;
        }
    }

    void layoutVertical(int n, int n2, int n3, int n4) {
        int n5 = this.getPaddingLeft();
        int n6 = n3 - n;
        int n7 = this.getPaddingRight();
        int n8 = this.getPaddingRight();
        int n9 = this.getVirtualChildCount();
        int n10 = this.mGravity;
        n = n10 & 0x70;
        n = n != 16 ? (n != 80 ? this.getPaddingTop() : this.getPaddingTop() + n4 - n2 - this.mTotalLength) : this.getPaddingTop() + (n4 - n2 - this.mTotalLength) / 2;
        n2 = 0;
        while (n2 < n9) {
            block4: {
                LayoutParams layoutParams;
                int n11;
                int n12;
                View view;
                block7: {
                    block8: {
                        block5: {
                            block6: {
                                block3: {
                                    view = this.getVirtualChildAt(n2);
                                    if (view != null) break block3;
                                    n3 = n + this.measureNullChild(n2);
                                    n4 = n2;
                                    break block4;
                                }
                                n3 = n;
                                n4 = n2;
                                if (view.getVisibility() == 8) break block4;
                                n12 = view.getMeasuredWidth();
                                n11 = view.getMeasuredHeight();
                                layoutParams = (LayoutParams)view.getLayoutParams();
                                n3 = n4 = layoutParams.gravity;
                                if (n4 < 0) {
                                    n3 = n10 & 0x800007;
                                }
                                if ((n3 = GravityCompat.getAbsoluteGravity((int)n3, (int)ViewCompat.getLayoutDirection((View)this)) & 7) == 1) break block5;
                                if (n3 == 5) break block6;
                                n3 = layoutParams.leftMargin + n5;
                                break block7;
                            }
                            n3 = n6 - n7 - n12;
                            n4 = layoutParams.rightMargin;
                            break block8;
                        }
                        n3 = (n6 - n5 - n8 - n12) / 2 + n5 + layoutParams.leftMargin;
                        n4 = layoutParams.rightMargin;
                    }
                    n3 -= n4;
                }
                n4 = n;
                if (this.hasDividerBeforeChildAt(n2)) {
                    n4 = n + this.mDividerHeight;
                }
                n = n4 + layoutParams.topMargin;
                this.setChildFrame(view, n3, n + this.getLocationOffset(view), n12, n11);
                n12 = layoutParams.bottomMargin;
                n3 = this.getNextLocationOffset(view);
                n4 = n2 + this.getChildrenSkipCount(view, n2);
                n3 = n + (n11 + n12 + n3);
            }
            n2 = n4 + 1;
            n = n3;
        }
    }

    void measureChildBeforeLayout(View view, int n, int n2, int n3, int n4, int n5) {
        this.measureChildWithMargins(view, n2, n3, n4, n5);
    }

    void measureHorizontal(int n, int n2) {
        int n3;
        int n4;
        boolean bl;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        block55: {
            float f;
            int n10;
            LayoutParams layoutParams;
            int n11;
            View view;
            int n12;
            int n13;
            int n14;
            float f2;
            boolean bl2;
            boolean bl3;
            Object object;
            int[] nArray;
            int n15;
            int n16;
            block54: {
                block52: {
                    block53: {
                        block51: {
                            boolean bl4;
                            block49: {
                                block50: {
                                    this.mTotalLength = 0;
                                    n16 = this.getVirtualChildCount();
                                    n15 = View.MeasureSpec.getMode((int)n);
                                    n9 = View.MeasureSpec.getMode((int)n2);
                                    if (this.mMaxAscent == null || this.mMaxDescent == null) {
                                        this.mMaxAscent = new int[4];
                                        this.mMaxDescent = new int[4];
                                    }
                                    nArray = this.mMaxAscent;
                                    object = this.mMaxDescent;
                                    nArray[3] = -1;
                                    nArray[2] = -1;
                                    nArray[1] = -1;
                                    nArray[0] = -1;
                                    object[3] = -1;
                                    object[2] = -1;
                                    object[1] = -1;
                                    object[0] = -1;
                                    bl3 = this.mBaselineAligned;
                                    bl4 = this.mUseLargestChild;
                                    bl2 = n15 == 0x40000000;
                                    f2 = 0.0f;
                                    n8 = 0;
                                    n7 = 0;
                                    n6 = 0;
                                    n14 = 0;
                                    n13 = 0;
                                    n12 = 0;
                                    n5 = 1;
                                    bl = false;
                                    for (n4 = 0; n4 < n16; ++n4) {
                                        block44: {
                                            int n17;
                                            block48: {
                                                block47: {
                                                    block45: {
                                                        block46: {
                                                            block43: {
                                                                block42: {
                                                                    block41: {
                                                                        view = this.getVirtualChildAt(n4);
                                                                        if (view != null) break block41;
                                                                        this.mTotalLength += this.measureNullChild(n4);
                                                                        break block42;
                                                                    }
                                                                    if (view.getVisibility() != 8) break block43;
                                                                    n4 += this.getChildrenSkipCount(view, n4);
                                                                }
                                                                n11 = n12;
                                                                break block44;
                                                            }
                                                            if (this.hasDividerBeforeChildAt(n4)) {
                                                                this.mTotalLength += this.mDividerWidth;
                                                            }
                                                            layoutParams = (LayoutParams)view.getLayoutParams();
                                                            f2 += layoutParams.weight;
                                                            if (n15 != 0x40000000 || layoutParams.width != 0 || !(layoutParams.weight > 0.0f)) break block45;
                                                            if (bl2) {
                                                                this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                                                            } else {
                                                                n11 = this.mTotalLength;
                                                                this.mTotalLength = Math.max(n11, layoutParams.leftMargin + n11 + layoutParams.rightMargin);
                                                            }
                                                            if (!bl3) break block46;
                                                            n11 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                                                            view.measure(n11, n11);
                                                            n11 = n8;
                                                            break block47;
                                                        }
                                                        n13 = 1;
                                                        break block48;
                                                    }
                                                    if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                                                        layoutParams.width = -2;
                                                        n11 = 0;
                                                    } else {
                                                        n11 = Integer.MIN_VALUE;
                                                    }
                                                    n10 = f2 == 0.0f ? this.mTotalLength : 0;
                                                    this.measureChildBeforeLayout(view, n4, n, n10, n2, 0);
                                                    if (n11 != Integer.MIN_VALUE) {
                                                        layoutParams.width = n11;
                                                    }
                                                    n10 = view.getMeasuredWidth();
                                                    if (bl2) {
                                                        this.mTotalLength += layoutParams.leftMargin + n10 + layoutParams.rightMargin + this.getNextLocationOffset(view);
                                                    } else {
                                                        n11 = this.mTotalLength;
                                                        this.mTotalLength = Math.max(n11, n11 + n10 + layoutParams.leftMargin + layoutParams.rightMargin + this.getNextLocationOffset(view));
                                                    }
                                                    n11 = n8;
                                                    if (bl4) {
                                                        n11 = Math.max(n10, n8);
                                                    }
                                                }
                                                n8 = n11;
                                            }
                                            if (n9 != 0x40000000 && layoutParams.height == -1) {
                                                n11 = 1;
                                                bl = true;
                                            } else {
                                                n11 = 0;
                                            }
                                            n10 = layoutParams.topMargin + layoutParams.bottomMargin;
                                            n3 = view.getMeasuredHeight() + n10;
                                            int n18 = View.combineMeasuredStates((int)n12, (int)view.getMeasuredState());
                                            if (bl3 && (n17 = view.getBaseline()) != -1) {
                                                n12 = layoutParams.gravity < 0 ? this.mGravity : layoutParams.gravity;
                                                n12 = ((n12 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                                                nArray[n12] = Math.max(nArray[n12], n17);
                                                object[n12] = Math.max(object[n12], n3 - n17);
                                            }
                                            n7 = Math.max(n7, n3);
                                            n5 = n5 != 0 && layoutParams.height == -1 ? 1 : 0;
                                            if (layoutParams.weight > 0.0f) {
                                                if (n11 == 0) {
                                                    n10 = n3;
                                                }
                                                n12 = Math.max(n14, n10);
                                            } else {
                                                if (n11 == 0) {
                                                    n10 = n3;
                                                }
                                                n6 = Math.max(n6, n10);
                                                n12 = n14;
                                            }
                                            n4 = this.getChildrenSkipCount(view, n4) + n4;
                                            n11 = n18;
                                            n14 = n12;
                                        }
                                        n12 = n11;
                                    }
                                    if (this.mTotalLength > 0 && this.hasDividerBeforeChildAt(n16)) {
                                        this.mTotalLength += this.mDividerWidth;
                                    }
                                    n4 = nArray[1] == -1 && nArray[0] == -1 && nArray[2] == -1 && nArray[3] == -1 ? n7 : Math.max(n7, Math.max(nArray[3], Math.max(nArray[0], Math.max(nArray[1], nArray[2]))) + Math.max(object[3], Math.max(object[0], Math.max(object[1], object[2]))));
                                    n7 = n12;
                                    n11 = n4;
                                    if (!bl4) break block49;
                                    if (n15 == Integer.MIN_VALUE) break block50;
                                    n11 = n4;
                                    if (n15 != 0) break block49;
                                }
                                this.mTotalLength = 0;
                                n12 = 0;
                                while (true) {
                                    n11 = n4;
                                    if (n12 >= n16) break;
                                    layoutParams = this.getVirtualChildAt(n12);
                                    if (layoutParams == null) {
                                        this.mTotalLength += this.measureNullChild(n12);
                                    } else if (layoutParams.getVisibility() == 8) {
                                        n12 += this.getChildrenSkipCount((View)layoutParams, n12);
                                    } else {
                                        view = (LayoutParams)layoutParams.getLayoutParams();
                                        if (bl2) {
                                            this.mTotalLength += view.leftMargin + n8 + view.rightMargin + this.getNextLocationOffset((View)layoutParams);
                                        } else {
                                            n11 = this.mTotalLength;
                                            this.mTotalLength = Math.max(n11, n11 + n8 + view.leftMargin + view.rightMargin + this.getNextLocationOffset((View)layoutParams));
                                        }
                                    }
                                    ++n12;
                                }
                            }
                            this.mTotalLength = n4 = this.mTotalLength + (this.getPaddingLeft() + this.getPaddingRight());
                            n3 = View.resolveSizeAndState((int)Math.max(n4, this.getSuggestedMinimumWidth()), (int)n, (int)0);
                            n10 = (0xFFFFFF & n3) - this.mTotalLength;
                            if (n13 != 0 || n10 != 0 && f2 > 0.0f) break block51;
                            n12 = Math.max(n6, n14);
                            if (!bl4 || n15 == 0x40000000) break block52;
                            break block53;
                        }
                        f = this.mWeightSum;
                        if (f > 0.0f) {
                            f2 = f;
                        }
                        nArray[3] = -1;
                        nArray[2] = -1;
                        nArray[1] = -1;
                        nArray[0] = -1;
                        object[3] = -1;
                        object[2] = -1;
                        object[1] = -1;
                        object[0] = -1;
                        this.mTotalLength = 0;
                        n12 = n7;
                        n14 = -1;
                        n4 = n5;
                        n8 = n16;
                        n5 = n12;
                        n12 = n6;
                        n6 = n10;
                        break block54;
                    }
                    for (n6 = 0; n6 < n16; ++n6) {
                        object = this.getVirtualChildAt(n6);
                        if (object == null || object.getVisibility() == 8 || !(((LayoutParams)object.getLayoutParams()).weight > 0.0f)) continue;
                        object.measure(View.MeasureSpec.makeMeasureSpec((int)n8, (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)object.getMeasuredHeight(), (int)0x40000000));
                    }
                }
                n4 = n16;
                n6 = n11;
                n8 = n12;
                break block55;
            }
            for (n7 = 0; n7 < n8; ++n7) {
                layoutParams = this.getVirtualChildAt(n7);
                if (layoutParams == null || layoutParams.getVisibility() == 8) continue;
                view = (LayoutParams)layoutParams.getLayoutParams();
                f = view.weight;
                if (f > 0.0f) {
                    n11 = (int)((float)n6 * f / f2);
                    n10 = LinearLayoutCompat.getChildMeasureSpec((int)n2, (int)(this.getPaddingTop() + this.getPaddingBottom() + view.topMargin + view.bottomMargin), (int)view.height);
                    if (view.width == 0 && n15 == 0x40000000) {
                        n13 = n11 > 0 ? n11 : 0;
                        layoutParams.measure(View.MeasureSpec.makeMeasureSpec((int)n13, (int)0x40000000), n10);
                    } else {
                        n13 = n16 = layoutParams.getMeasuredWidth() + n11;
                        if (n16 < 0) {
                            n13 = 0;
                        }
                        layoutParams.measure(View.MeasureSpec.makeMeasureSpec((int)n13, (int)0x40000000), n10);
                    }
                    n5 = View.combineMeasuredStates((int)n5, (int)(layoutParams.getMeasuredState() & 0xFF000000));
                    f2 -= f;
                    n6 -= n11;
                }
                if (bl2) {
                    this.mTotalLength += layoutParams.getMeasuredWidth() + view.leftMargin + view.rightMargin + this.getNextLocationOffset((View)layoutParams);
                } else {
                    n13 = this.mTotalLength;
                    this.mTotalLength = Math.max(n13, layoutParams.getMeasuredWidth() + n13 + view.leftMargin + view.rightMargin + this.getNextLocationOffset((View)layoutParams));
                }
                n13 = n9 != 0x40000000 && view.height == -1 ? 1 : 0;
                n10 = view.topMargin + view.bottomMargin;
                n16 = layoutParams.getMeasuredHeight() + n10;
                n11 = Math.max(n14, n16);
                n14 = n13 != 0 ? n10 : n16;
                n14 = Math.max(n12, n14);
                n4 = n4 != 0 && view.height == -1 ? 1 : 0;
                if (bl3 && (n13 = layoutParams.getBaseline()) != -1) {
                    n12 = view.gravity < 0 ? this.mGravity : view.gravity;
                    n12 = ((n12 & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                    nArray[n12] = Math.max(nArray[n12], n13);
                    object[n12] = Math.max(object[n12], n16 - n13);
                }
                n12 = n14;
                n14 = n11;
            }
            this.mTotalLength += this.getPaddingLeft() + this.getPaddingRight();
            n6 = nArray[1] == -1 && nArray[0] == -1 && nArray[2] == -1 && nArray[3] == -1 ? n14 : Math.max(n14, Math.max(nArray[3], Math.max(nArray[0], Math.max(nArray[1], nArray[2]))) + Math.max(object[3], Math.max(object[0], Math.max(object[1], object[2]))));
            n7 = n5;
            n5 = n4;
            n4 = n8;
            n8 = n12;
        }
        if (n5 != 0 || n9 == 0x40000000) {
            n8 = n6;
        }
        this.setMeasuredDimension(n3 | n7 & 0xFF000000, View.resolveSizeAndState((int)Math.max(n8 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight()), (int)n2, (int)(n7 << 16)));
        if (!bl) return;
        this.forceUniformHeight(n4, n);
    }

    int measureNullChild(int n) {
        return 0;
    }

    void measureVertical(int n, int n2) {
        int n3;
        boolean bl;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        block35: {
            float f;
            int n10;
            int n11;
            int n12;
            LayoutParams layoutParams;
            View view;
            int n13;
            int n14;
            int n15;
            int n16;
            float f2;
            int n17;
            int n18;
            block34: {
                block32: {
                    block33: {
                        block31: {
                            this.mTotalLength = 0;
                            n9 = this.getVirtualChildCount();
                            n8 = View.MeasureSpec.getMode((int)n);
                            n18 = View.MeasureSpec.getMode((int)n2);
                            n17 = this.mBaselineAlignedChildIndex;
                            boolean bl2 = this.mUseLargestChild;
                            f2 = 0.0f;
                            n7 = 0;
                            n16 = 0;
                            n6 = 0;
                            n5 = 0;
                            n15 = 0;
                            n14 = 0;
                            n4 = 1;
                            bl = false;
                            for (n13 = 0; n13 < n9; ++n13) {
                                view = this.getVirtualChildAt(n13);
                                if (view == null) {
                                    this.mTotalLength += this.measureNullChild(n13);
                                    continue;
                                }
                                if (view.getVisibility() == 8) {
                                    n13 += this.getChildrenSkipCount(view, n13);
                                    continue;
                                }
                                if (this.hasDividerBeforeChildAt(n13)) {
                                    this.mTotalLength += this.mDividerHeight;
                                }
                                layoutParams = (LayoutParams)view.getLayoutParams();
                                f2 += layoutParams.weight;
                                if (n18 == 0x40000000 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                                    n14 = this.mTotalLength;
                                    this.mTotalLength = Math.max(n14, layoutParams.topMargin + n14 + layoutParams.bottomMargin);
                                    n14 = 1;
                                } else {
                                    if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                                        layoutParams.height = -2;
                                        n12 = 0;
                                    } else {
                                        n12 = Integer.MIN_VALUE;
                                    }
                                    n3 = f2 == 0.0f ? this.mTotalLength : 0;
                                    this.measureChildBeforeLayout(view, n13, n, 0, n2, n3);
                                    if (n12 != Integer.MIN_VALUE) {
                                        layoutParams.height = n12;
                                    }
                                    n12 = view.getMeasuredHeight();
                                    n3 = this.mTotalLength;
                                    this.mTotalLength = Math.max(n3, n3 + n12 + layoutParams.topMargin + layoutParams.bottomMargin + this.getNextLocationOffset(view));
                                    if (bl2) {
                                        n6 = Math.max(n12, n6);
                                    }
                                }
                                if (n17 >= 0 && n17 == n13 + 1) {
                                    this.mBaselineChildTop = this.mTotalLength;
                                }
                                if (n13 < n17) {
                                    if (layoutParams.weight > 0.0f) throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                                }
                                if (n8 != 0x40000000 && layoutParams.width == -1) {
                                    n12 = 1;
                                    bl = true;
                                } else {
                                    n12 = 0;
                                }
                                n3 = layoutParams.leftMargin + layoutParams.rightMargin;
                                n11 = view.getMeasuredWidth() + n3;
                                n16 = Math.max(n16, n11);
                                n10 = View.combineMeasuredStates((int)n7, (int)view.getMeasuredState());
                                n7 = n4 != 0 && layoutParams.width == -1 ? 1 : 0;
                                if (layoutParams.weight > 0.0f) {
                                    if (n12 == 0) {
                                        n3 = n11;
                                    }
                                    n5 = Math.max(n5, n3);
                                    n4 = n15;
                                } else {
                                    if (n12 == 0) {
                                        n3 = n11;
                                    }
                                    n4 = Math.max(n15, n3);
                                }
                                n3 = this.getChildrenSkipCount(view, n13);
                                n15 = n4;
                                n12 = n10;
                                n13 = n3 + n13;
                                n4 = n7;
                                n7 = n12;
                            }
                            if (this.mTotalLength > 0 && this.hasDividerBeforeChildAt(n9)) {
                                this.mTotalLength += this.mDividerHeight;
                            }
                            if (bl2 && (n18 == Integer.MIN_VALUE || n18 == 0)) {
                                this.mTotalLength = 0;
                                for (n13 = 0; n13 < n9; ++n13) {
                                    view = this.getVirtualChildAt(n13);
                                    if (view == null) {
                                        this.mTotalLength += this.measureNullChild(n13);
                                        continue;
                                    }
                                    if (view.getVisibility() == 8) {
                                        n13 += this.getChildrenSkipCount(view, n13);
                                        continue;
                                    }
                                    layoutParams = (LayoutParams)view.getLayoutParams();
                                    n12 = this.mTotalLength;
                                    this.mTotalLength = Math.max(n12, n12 + n6 + layoutParams.topMargin + layoutParams.bottomMargin + this.getNextLocationOffset(view));
                                }
                            }
                            this.mTotalLength = n13 = this.mTotalLength + (this.getPaddingTop() + this.getPaddingBottom());
                            n3 = View.resolveSizeAndState((int)Math.max(n13, this.getSuggestedMinimumHeight()), (int)n2, (int)0);
                            n13 = (0xFFFFFF & n3) - this.mTotalLength;
                            if (n14 != 0 || n13 != 0 && f2 > 0.0f) break block31;
                            n15 = Math.max(n15, n5);
                            if (!bl2 || n18 == 0x40000000) break block32;
                            break block33;
                        }
                        f = this.mWeightSum;
                        if (f > 0.0f) {
                            f2 = f;
                        }
                        this.mTotalLength = 0;
                        n6 = n13;
                        n5 = n7;
                        n7 = n6;
                        n6 = n16;
                        break block34;
                    }
                    for (n5 = 0; n5 < n9; ++n5) {
                        layoutParams = this.getVirtualChildAt(n5);
                        if (layoutParams == null || layoutParams.getVisibility() == 8 || !(((LayoutParams)layoutParams.getLayoutParams()).weight > 0.0f)) continue;
                        layoutParams.measure(View.MeasureSpec.makeMeasureSpec((int)layoutParams.getMeasuredWidth(), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)n6, (int)0x40000000));
                    }
                }
                n5 = n15;
                n6 = n16;
                break block35;
            }
            for (n13 = 0; n13 < n9; ++n13) {
                layoutParams = this.getVirtualChildAt(n13);
                if (layoutParams.getVisibility() == 8) continue;
                view = (LayoutParams)layoutParams.getLayoutParams();
                f = view.weight;
                if (f > 0.0f) {
                    n16 = (int)((float)n7 * f / f2);
                    n11 = this.getPaddingLeft();
                    n10 = this.getPaddingRight();
                    int n19 = view.leftMargin;
                    n12 = view.rightMargin;
                    n17 = view.width;
                    n14 = n7 - n16;
                    n12 = LinearLayoutCompat.getChildMeasureSpec((int)n, (int)(n11 + n10 + n19 + n12), (int)n17);
                    if (view.height == 0 && n18 == 0x40000000) {
                        n7 = n16 > 0 ? n16 : 0;
                        layoutParams.measure(n12, View.MeasureSpec.makeMeasureSpec((int)n7, (int)0x40000000));
                    } else {
                        n7 = n16 = layoutParams.getMeasuredHeight() + n16;
                        if (n16 < 0) {
                            n7 = 0;
                        }
                        layoutParams.measure(n12, View.MeasureSpec.makeMeasureSpec((int)n7, (int)0x40000000));
                    }
                    n5 = View.combineMeasuredStates((int)n5, (int)(layoutParams.getMeasuredState() & 0xFFFFFF00));
                    f2 -= f;
                    n7 = n14;
                }
                n12 = view.leftMargin + view.rightMargin;
                n16 = layoutParams.getMeasuredWidth() + n12;
                n14 = Math.max(n6, n16);
                n6 = n8 != 0x40000000 && view.width == -1 ? 1 : 0;
                n6 = n6 != 0 ? n12 : n16;
                n15 = Math.max(n15, n6);
                n4 = n4 != 0 && view.width == -1 ? 1 : 0;
                n6 = this.mTotalLength;
                this.mTotalLength = Math.max(n6, layoutParams.getMeasuredHeight() + n6 + view.topMargin + view.bottomMargin + this.getNextLocationOffset((View)layoutParams));
                n6 = n14;
            }
            this.mTotalLength += this.getPaddingTop() + this.getPaddingBottom();
            n7 = n5;
            n5 = n15;
        }
        if (n4 != 0 || n8 == 0x40000000) {
            n5 = n6;
        }
        this.setMeasuredDimension(View.resolveSizeAndState((int)Math.max(n5 + (this.getPaddingLeft() + this.getPaddingRight()), this.getSuggestedMinimumWidth()), (int)n, (int)n7), n3);
        if (!bl) return;
        this.forceUniformWidth(n9, n2);
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            this.drawDividersVertical(canvas);
        } else {
            this.drawDividersHorizontal(canvas);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (this.mOrientation == 1) {
            this.layoutVertical(n, n2, n3, n4);
        } else {
            this.layoutHorizontal(n, n2, n3, n4);
        }
    }

    protected void onMeasure(int n, int n2) {
        if (this.mOrientation == 1) {
            this.measureVertical(n, n2);
        } else {
            this.measureHorizontal(n, n2);
        }
    }

    public void setBaselineAligned(boolean bl) {
        this.mBaselineAligned = bl;
    }

    public void setBaselineAlignedChildIndex(int n) {
        if (n >= 0 && n < this.getChildCount()) {
            this.mBaselineAlignedChildIndex = n;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("base aligned child index out of range (0, ");
        stringBuilder.append(this.getChildCount());
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        boolean bl = false;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable == null) {
            bl = true;
        }
        this.setWillNotDraw(bl);
        this.requestLayout();
    }

    public void setDividerPadding(int n) {
        this.mDividerPadding = n;
    }

    public void setGravity(int n) {
        if (this.mGravity == n) return;
        int n2 = n;
        if ((0x800007 & n) == 0) {
            n2 = n | 0x800003;
        }
        n = n2;
        if ((n2 & 0x70) == 0) {
            n = n2 | 0x30;
        }
        this.mGravity = n;
        this.requestLayout();
    }

    public void setHorizontalGravity(int n) {
        int n2 = this.mGravity;
        if ((0x800007 & n2) == (n &= 0x800007)) return;
        this.mGravity = n | 0xFF7FFFF8 & n2;
        this.requestLayout();
    }

    public void setMeasureWithLargestChildEnabled(boolean bl) {
        this.mUseLargestChild = bl;
    }

    public void setOrientation(int n) {
        if (this.mOrientation == n) return;
        this.mOrientation = n;
        this.requestLayout();
    }

    public void setShowDividers(int n) {
        if (n != this.mShowDividers) {
            this.requestLayout();
        }
        this.mShowDividers = n;
    }

    public void setVerticalGravity(int n) {
        n = this.mGravity;
        int n2 = n & 0x70;
        if ((n & 0x70) == n2) return;
        this.mGravity = n2 | n & 0xFFFFFF8F;
        this.requestLayout();
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
