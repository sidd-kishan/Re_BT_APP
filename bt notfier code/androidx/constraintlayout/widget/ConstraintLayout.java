/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.constraintlayout.solver.Metrics
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintLayout$Measurer
 *  androidx.constraintlayout.widget.ConstraintLayoutStates
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.Constraints
 *  androidx.constraintlayout.widget.ConstraintsChangedListener
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.constraintlayout.widget.Placeholder
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.Placeholder;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.2";
    SparseArray<View> mChildrenByIds = new SparseArray();
    private ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList(4);
    protected ConstraintLayoutStates mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    protected ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight;
    private int mMaxWidth = Integer.MAX_VALUE;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    private int mOptimizationLevel = 257;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    public ConstraintLayout(Context context) {
        super(context);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(attributeSet, n, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDesignIds = new HashMap();
        this.mTempMapIdToWidget = new SparseArray();
        this.mMeasurer = new Measurer(this, this);
        this.init(attributeSet, n, n2);
    }

    static /* synthetic */ int access$000(ConstraintLayout constraintLayout) {
        return constraintLayout.mOptimizationLevel;
    }

    static /* synthetic */ ArrayList access$100(ConstraintLayout constraintLayout) {
        return constraintLayout.mConstraintHelpers;
    }

    private int getPaddingWidth() {
        int n = this.getPaddingLeft();
        int n2 = 0;
        n = Math.max(0, n) + Math.max(0, this.getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            n2 = Math.max(0, this.getPaddingStart());
            n2 = Math.max(0, this.getPaddingEnd()) + n2;
        }
        if (n2 <= 0) return n;
        n = n2;
        return n;
    }

    private final ConstraintWidget getTargetWidget(int n) {
        View view;
        if (n == 0) {
            return this.mLayoutWidget;
        }
        Object object = view = (View)this.mChildrenByIds.get(n);
        if (view == null) {
            object = view = this.findViewById(n);
            if (view != null) {
                object = view;
                if (view != this) {
                    object = view;
                    if (view.getParent() == this) {
                        this.onViewAdded(view);
                        object = view;
                    }
                }
            }
        }
        if (object == this) {
            return this.mLayoutWidget;
        }
        object = object == null ? null : ((LayoutParams)object.getLayoutParams()).widget;
        return object;
    }

    private void init(AttributeSet attributeSet, int n, int n2) {
        this.mLayoutWidget.setCompanionWidget((Object)this);
        this.mLayoutWidget.setMeasurer((BasicMeasure.Measurer)this.mMeasurer);
        this.mChildrenByIds.put(this.getId(), (Object)this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, n, n2);
            n2 = attributeSet.getIndexCount();
            for (n = 0; n < n2; ++n) {
                int n3 = attributeSet.getIndex(n);
                if (n3 == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = attributeSet.getDimensionPixelOffset(n3, this.mMinWidth);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = attributeSet.getDimensionPixelOffset(n3, this.mMinHeight);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = attributeSet.getDimensionPixelOffset(n3, this.mMaxWidth);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = attributeSet.getDimensionPixelOffset(n3, this.mMaxHeight);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = attributeSet.getInt(n3, this.mOptimizationLevel);
                    continue;
                }
                if (n3 == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    if ((n3 = attributeSet.getResourceId(n3, 0)) == 0) continue;
                    try {
                        this.parseLayoutDescription(n3);
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        this.mConstraintLayoutSpec = null;
                    }
                    continue;
                }
                if (n3 != R.styleable.ConstraintLayout_Layout_constraintSet) continue;
                n3 = attributeSet.getResourceId(n3, 0);
                try {
                    ConstraintSet constraintSet;
                    this.mConstraintSet = constraintSet = new ConstraintSet();
                    constraintSet.load(this.getContext(), n3);
                }
                catch (Resources.NotFoundException notFoundException) {
                    this.mConstraintSet = null;
                }
                this.mConstraintSetId = n3;
            }
            attributeSet.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void setChildrenConstraints() {
        var4_1 = this.isInEditMode();
        var2_2 = this.getChildCount();
        for (var1_3 = 0; var1_3 < var2_2; ++var1_3) {
            var5_4 /* !! */  = this.getViewWidget(this.getChildAt(var1_3));
            if (var5_4 /* !! */  == null) continue;
            var5_4 /* !! */ .reset();
        }
        if (var4_1) {
            block3: for (var1_3 = 0; var1_3 < var2_2; ++var1_3) {
                var7_8 = this.getChildAt(var1_3);
                try {
                    var6_7 = this.getResources().getResourceName(var7_8.getId());
                    this.setDesignInformation(0, var6_7, var7_8.getId());
                    var3_6 = var6_7.indexOf(47);
                    var5_4 /* !! */  = var6_7;
                    if (var3_6 != -1) {
                        var5_4 /* !! */  = var6_7.substring(var3_6 + 1);
                    }
                    this.getTargetWidget(var7_8.getId()).setDebugName((String)var5_4 /* !! */ );
lbl19:
                    // 2 sources

                    continue block3;
                }
                catch (Resources.NotFoundException var5_5) {
                    ** continue;
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (var1_3 = 0; var1_3 < var2_2; ++var1_3) {
                var5_4 /* !! */  = this.getChildAt(var1_3);
                if (var5_4 /* !! */ .getId() != this.mConstraintSetId || !(var5_4 /* !! */  instanceof Constraints)) continue;
                this.mConstraintSet = ((Constraints)var5_4 /* !! */ ).getConstraintSet();
            }
        }
        if ((var5_4 /* !! */  = this.mConstraintSet) != null) {
            var5_4 /* !! */ .applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        var3_6 = this.mConstraintHelpers.size();
        if (var3_6 > 0) {
            for (var1_3 = 0; var1_3 < var3_6; ++var1_3) {
                this.mConstraintHelpers.get(var1_3).updatePreLayout(this);
            }
        }
        for (var1_3 = 0; var1_3 < var2_2; ++var1_3) {
            var5_4 /* !! */  = this.getChildAt(var1_3);
            if (!(var5_4 /* !! */  instanceof Placeholder)) continue;
            ((Placeholder)var5_4 /* !! */ ).updatePreLayout(this);
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, (Object)this.mLayoutWidget);
        this.mTempMapIdToWidget.put(this.getId(), (Object)this.mLayoutWidget);
        for (var1_3 = 0; var1_3 < var2_2; ++var1_3) {
            var5_4 /* !! */  = this.getChildAt(var1_3);
            var6_7 = this.getViewWidget((View)var5_4 /* !! */ );
            this.mTempMapIdToWidget.put(var5_4 /* !! */ .getId(), (Object)var6_7);
        }
        var1_3 = 0;
        while (var1_3 < var2_2) {
            var7_8 = this.getChildAt(var1_3);
            var5_4 /* !! */  = this.getViewWidget(var7_8);
            if (var5_4 /* !! */  != null) {
                var6_7 = (LayoutParams)var7_8.getLayoutParams();
                this.mLayoutWidget.add(var5_4 /* !! */ );
                this.applyConstraintsFromLayoutParams(var4_1, var7_8, var5_4 /* !! */ , (LayoutParams)var6_7, this.mTempMapIdToWidget);
            }
            ++var1_3;
        }
    }

    private boolean updateHierarchy() {
        boolean bl;
        int n = this.getChildCount();
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            if (this.getChildAt(n2).isLayoutRequested()) {
                bl = true;
                break;
            }
            ++n2;
        }
        if (!bl) return bl;
        this.setChildrenConstraints();
        return bl;
    }

    public void addView(View view, int n, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n, layoutParams);
        if (Build.VERSION.SDK_INT >= 14) return;
        this.onViewAdded(view);
    }

    protected void applyConstraintsFromLayoutParams(boolean bl, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> layoutParams2) {
        layoutParams.validate();
        layoutParams.helped = false;
        constraintWidget.setVisibility(view.getVisibility());
        if (layoutParams.isInPlaceholder) {
            constraintWidget.setInPlaceholder(true);
            constraintWidget.setVisibility(8);
        }
        constraintWidget.setCompanionWidget((Object)view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper)view).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
        }
        if (layoutParams.isGuideline) {
            view = (androidx.constraintlayout.solver.widgets.Guideline)constraintWidget;
            int n = layoutParams.resolvedGuideBegin;
            int n2 = layoutParams.resolvedGuideEnd;
            float f = layoutParams.resolvedGuidePercent;
            if (Build.VERSION.SDK_INT < 17) {
                n = layoutParams.guideBegin;
                n2 = layoutParams.guideEnd;
                f = layoutParams.guidePercent;
            }
            if (f != -1.0f) {
                view.setGuidePercent(f);
            } else if (n != -1) {
                view.setGuideBegin(n);
            } else {
                if (n2 == -1) return;
                view.setGuideEnd(n2);
            }
        } else {
            int n = layoutParams.resolvedLeftToLeft;
            int n3 = layoutParams.resolvedLeftToRight;
            int n4 = layoutParams.resolvedRightToLeft;
            int n5 = layoutParams.resolvedRightToRight;
            int n6 = layoutParams.resolveGoneLeftMargin;
            int n7 = layoutParams.resolveGoneRightMargin;
            float f = layoutParams.resolvedHorizontalBias;
            if (Build.VERSION.SDK_INT < 17) {
                n5 = layoutParams.leftToLeft;
                n7 = layoutParams.leftToRight;
                int n8 = layoutParams.rightToLeft;
                n4 = layoutParams.rightToRight;
                int n9 = layoutParams.goneLeftMargin;
                n = layoutParams.goneRightMargin;
                f = layoutParams.horizontalBias;
                n6 = n5;
                n3 = n7;
                if (n5 == -1) {
                    n6 = n5;
                    n3 = n7;
                    if (n7 == -1) {
                        if (layoutParams.startToStart != -1) {
                            n6 = layoutParams.startToStart;
                            n3 = n7;
                        } else {
                            n6 = n5;
                            n3 = n7;
                            if (layoutParams.startToEnd != -1) {
                                n3 = layoutParams.startToEnd;
                                n6 = n5;
                            }
                        }
                    }
                }
                n7 = n8;
                n5 = n4;
                if (n8 == -1) {
                    n7 = n8;
                    n5 = n4;
                    if (n4 == -1) {
                        if (layoutParams.endToStart != -1) {
                            n7 = layoutParams.endToStart;
                            n5 = n4;
                        } else {
                            n7 = n8;
                            n5 = n4;
                            if (layoutParams.endToEnd != -1) {
                                n5 = layoutParams.endToEnd;
                                n7 = n8;
                            }
                        }
                    }
                }
                n4 = n7;
                n7 = n;
                n = n6;
                n6 = n9;
            }
            if (layoutParams.circleConstraint != -1) {
                view = (ConstraintWidget)layoutParams2.get(layoutParams.circleConstraint);
                if (view != null) {
                    constraintWidget.connectCircularConstraint((ConstraintWidget)view, layoutParams.circleAngle, layoutParams.circleRadius);
                }
            } else {
                if (n != -1) {
                    view = (ConstraintWidget)layoutParams2.get(n);
                    if (view != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)view, ConstraintAnchor.Type.LEFT, layoutParams.leftMargin, n6);
                    }
                } else if (n3 != -1 && (view = (ConstraintWidget)layoutParams2.get(n3)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, (ConstraintWidget)view, ConstraintAnchor.Type.RIGHT, layoutParams.leftMargin, n6);
                }
                if (n4 != -1) {
                    view = (ConstraintWidget)layoutParams2.get(n4);
                    if (view != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)view, ConstraintAnchor.Type.LEFT, layoutParams.rightMargin, n7);
                    }
                } else if (n5 != -1 && (view = (ConstraintWidget)layoutParams2.get(n5)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, (ConstraintWidget)view, ConstraintAnchor.Type.RIGHT, layoutParams.rightMargin, n7);
                }
                if (layoutParams.topToTop != -1) {
                    view = (ConstraintWidget)layoutParams2.get(layoutParams.topToTop);
                    if (view != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)view, ConstraintAnchor.Type.TOP, layoutParams.topMargin, layoutParams.goneTopMargin);
                    }
                } else if (layoutParams.topToBottom != -1 && (view = (ConstraintWidget)layoutParams2.get(layoutParams.topToBottom)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, (ConstraintWidget)view, ConstraintAnchor.Type.BOTTOM, layoutParams.topMargin, layoutParams.goneTopMargin);
                }
                if (layoutParams.bottomToTop != -1) {
                    view = (ConstraintWidget)layoutParams2.get(layoutParams.bottomToTop);
                    if (view != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)view, ConstraintAnchor.Type.TOP, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                    }
                } else if (layoutParams.bottomToBottom != -1 && (view = (ConstraintWidget)layoutParams2.get(layoutParams.bottomToBottom)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, (ConstraintWidget)view, ConstraintAnchor.Type.BOTTOM, layoutParams.bottomMargin, layoutParams.goneBottomMargin);
                }
                if (layoutParams.baselineToBaseline != -1) {
                    View view2 = (View)this.mChildrenByIds.get(layoutParams.baselineToBaseline);
                    view = (ConstraintWidget)layoutParams2.get(layoutParams.baselineToBaseline);
                    if (view != null && view2 != null && view2.getLayoutParams() instanceof LayoutParams) {
                        layoutParams2 = (LayoutParams)view2.getLayoutParams();
                        layoutParams.needsBaseline = true;
                        layoutParams2.needsBaseline = true;
                        constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE).connect(view.getAnchor(ConstraintAnchor.Type.BASELINE), 0, -1, true);
                        constraintWidget.setHasBaseline(true);
                        layoutParams2.widget.setHasBaseline(true);
                        constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
                        constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                    }
                }
                if (f >= 0.0f) {
                    constraintWidget.setHorizontalBiasPercent(f);
                }
                if (layoutParams.verticalBias >= 0.0f) {
                    constraintWidget.setVerticalBiasPercent(layoutParams.verticalBias);
                }
            }
            if (bl && (layoutParams.editorAbsoluteX != -1 || layoutParams.editorAbsoluteY != -1)) {
                constraintWidget.setOrigin(layoutParams.editorAbsoluteX, layoutParams.editorAbsoluteY);
            }
            if (!layoutParams.horizontalDimensionFixed) {
                if (layoutParams.width == -1) {
                    if (layoutParams.constrainedWidth) {
                        constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    } else {
                        constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                    }
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.LEFT).mMargin = layoutParams.leftMargin;
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.RIGHT).mMargin = layoutParams.rightMargin;
                } else {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    constraintWidget.setWidth(0);
                }
            } else {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setWidth(layoutParams.width);
                if (layoutParams.width == -2) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
            if (!layoutParams.verticalDimensionFixed) {
                if (layoutParams.height == -1) {
                    if (layoutParams.constrainedHeight) {
                        constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    } else {
                        constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                    }
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.TOP).mMargin = layoutParams.topMargin;
                    constraintWidget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.BOTTOM).mMargin = layoutParams.bottomMargin;
                } else {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                    constraintWidget.setHeight(0);
                }
            } else {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(layoutParams.height);
                if (layoutParams.height == -2) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
            constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
            constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
            constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
            constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
            constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
            constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
            constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected void dispatchDraw(Canvas canvas) {
        int n;
        int n2;
        Paint paint = this.mConstraintHelpers;
        if (paint != null && (n2 = paint.size()) > 0) {
            for (n = 0; n < n2; ++n) {
                this.mConstraintHelpers.get(n).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (!this.isInEditMode()) return;
        n2 = this.getChildCount();
        float f = this.getWidth();
        float f2 = this.getHeight();
        n = 0;
        while (n < n2) {
            paint = this.getChildAt(n);
            if (paint.getVisibility() != 8 && (paint = paint.getTag()) != null && paint instanceof String && ((String[])(paint = ((String)paint).split(","))).length == 4) {
                int n3 = Integer.parseInt(paint[0]);
                int n4 = Integer.parseInt(paint[1]);
                int n5 = Integer.parseInt(paint[2]);
                int n6 = Integer.parseInt(paint[3]);
                n3 = (int)((float)n3 / 1080.0f * f);
                n4 = (int)((float)n4 / 1920.0f * f2);
                n5 = (int)((float)n5 / 1080.0f * f);
                n6 = (int)((float)n6 / 1920.0f * f2);
                paint = new Paint();
                paint.setColor(-65536);
                float f3 = n3;
                float f4 = n4;
                float f5 = n3 + n5;
                canvas.drawLine(f3, f4, f5, f4, paint);
                float f6 = n4 + n6;
                canvas.drawLine(f5, f4, f5, f6, paint);
                canvas.drawLine(f5, f6, f3, f6, paint);
                canvas.drawLine(f3, f6, f3, f4, paint);
                paint.setColor(-16711936);
                canvas.drawLine(f3, f4, f5, f6, paint);
                canvas.drawLine(f3, f6, f5, f4, paint);
            }
            ++n;
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    public void forceLayout() {
        this.markHierarchyDirty();
        super.forceLayout();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    public Object getDesignInformation(int n, Object hashMap) {
        if (n != 0) return null;
        if (!(hashMap instanceof String)) return null;
        String string = (String)((Object)hashMap);
        hashMap = this.mDesignIds;
        if (hashMap == null) return null;
        if (!hashMap.containsKey(string)) return null;
        return this.mDesignIds.get(string);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int n) {
        return (View)this.mChildrenByIds.get(n);
    }

    public final ConstraintWidget getViewWidget(View object) {
        if (object == this) {
            return this.mLayoutWidget;
        }
        object = object == null ? null : ((LayoutParams)object.getLayoutParams()).widget;
        return object;
    }

    protected boolean isRtl() {
        boolean bl;
        int n = Build.VERSION.SDK_INT;
        boolean bl2 = bl = false;
        if (n < 17) return bl2;
        n = (this.getContext().getApplicationInfo().flags & 0x400000) != 0 ? 1 : 0;
        bl2 = bl;
        if (n == 0) return bl2;
        bl2 = bl;
        if (1 != this.getLayoutDirection()) return bl2;
        bl2 = true;
        return bl2;
    }

    public void loadLayoutDescription(int n) {
        if (n != 0) {
            try {
                ConstraintLayoutStates constraintLayoutStates;
                this.mConstraintLayoutSpec = constraintLayoutStates = new ConstraintLayoutStates(this.getContext(), this, n);
            }
            catch (Resources.NotFoundException notFoundException) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        n3 = this.getChildCount();
        bl = this.isInEditMode();
        n2 = 0;
        for (n = 0; n < n3; ++n) {
            View view = this.getChildAt(n);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if (view.getVisibility() == 8 && !layoutParams.isGuideline && !layoutParams.isHelper && !layoutParams.isVirtualGroup && !bl || layoutParams.isInPlaceholder) continue;
            int n5 = constraintWidget.getX();
            int n6 = constraintWidget.getY();
            n4 = constraintWidget.getWidth() + n5;
            int n7 = constraintWidget.getHeight() + n6;
            view.layout(n5, n6, n4, n7);
            if (!(view instanceof Placeholder) || (view = ((Placeholder)view).getContent()) == null) continue;
            view.setVisibility(0);
            view.layout(n5, n6, n4, n7);
        }
        n3 = this.mConstraintHelpers.size();
        if (n3 <= 0) return;
        n = n2;
        while (n < n3) {
            this.mConstraintHelpers.get(n).updatePostLayout(this);
            ++n;
        }
    }

    protected void onMeasure(int n, int n2) {
        if (!this.mDirtyHierarchy) {
            if (this.mOnMeasureWidthMeasureSpec == n && this.mOnMeasureHeightMeasureSpec == n2) {
                this.resolveMeasuredDimension(n, n2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                return;
            }
            if (this.mOnMeasureWidthMeasureSpec == n && View.MeasureSpec.getMode((int)n) == 0x40000000 && View.MeasureSpec.getMode((int)n2) == Integer.MIN_VALUE && View.MeasureSpec.getMode((int)this.mOnMeasureHeightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getSize((int)n2) >= this.mLayoutWidget.getHeight()) {
                this.mOnMeasureWidthMeasureSpec = n;
                this.mOnMeasureHeightMeasureSpec = n2;
                this.resolveMeasuredDimension(n, n2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
                return;
            }
        }
        this.mOnMeasureWidthMeasureSpec = n;
        this.mOnMeasureHeightMeasureSpec = n2;
        this.mLayoutWidget.setRtl(this.isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (this.updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        this.resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, n, n2);
        this.resolveMeasuredDimension(n, n2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget constraintWidget = this.getViewWidget(view);
        if (view instanceof Guideline && !(constraintWidget instanceof androidx.constraintlayout.solver.widgets.Guideline)) {
            constraintWidget = (LayoutParams)view.getLayoutParams();
            constraintWidget.widget = new androidx.constraintlayout.solver.widgets.Guideline();
            constraintWidget.isGuideline = true;
            ((androidx.constraintlayout.solver.widgets.Guideline)constraintWidget.widget).setOrientation(constraintWidget.orientation);
        }
        if (view instanceof ConstraintHelper) {
            constraintWidget = (ConstraintHelper)view;
            constraintWidget.validateParams();
            ((LayoutParams)view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintWidget)) {
                this.mConstraintHelpers.add((ConstraintHelper)constraintWidget);
            }
        }
        this.mChildrenByIds.put(view.getId(), (Object)view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget constraintWidget = this.getViewWidget(view);
        this.mLayoutWidget.remove(constraintWidget);
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int n) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(this.getContext(), this, n);
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT >= 14) return;
        this.onViewRemoved(view);
    }

    public void requestLayout() {
        this.markHierarchyDirty();
        super.requestLayout();
    }

    protected void resolveMeasuredDimension(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        int n5 = this.mMeasurer.paddingHeight;
        n3 += this.mMeasurer.paddingWidth;
        n4 += n5;
        if (Build.VERSION.SDK_INT >= 11) {
            n = ConstraintLayout.resolveSizeAndState((int)n3, (int)n, (int)0);
            n3 = ConstraintLayout.resolveSizeAndState((int)n4, (int)n2, (int)0);
            n2 = Math.min(this.mMaxWidth, n & 0xFFFFFF);
            n3 = Math.min(this.mMaxHeight, n3 & 0xFFFFFF);
            n = n2;
            if (bl) {
                n = n2 | 0x1000000;
            }
            n2 = n3;
            if (bl2) {
                n2 = n3 | 0x1000000;
            }
            this.setMeasuredDimension(n, n2);
            this.mLastMeasureWidth = n;
            this.mLastMeasureHeight = n2;
        } else {
            this.setMeasuredDimension(n3, n4);
            this.mLastMeasureWidth = n3;
            this.mLastMeasureHeight = n4;
        }
    }

    protected void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = View.MeasureSpec.getSize((int)n2);
        int n6 = View.MeasureSpec.getMode((int)n3);
        int n7 = View.MeasureSpec.getSize((int)n3);
        int n8 = Math.max(0, this.getPaddingTop());
        int n9 = Math.max(0, this.getPaddingBottom());
        int n10 = n8 + n9;
        int n11 = this.getPaddingWidth();
        this.mMeasurer.captureLayoutInfos(n2, n3, n8, n9, n11, n10);
        if (Build.VERSION.SDK_INT >= 17) {
            n2 = Math.max(0, this.getPaddingStart());
            n3 = Math.max(0, this.getPaddingEnd());
            if (n2 <= 0 && n3 <= 0) {
                n2 = Math.max(0, this.getPaddingLeft());
            } else if (this.isRtl()) {
                n2 = n3;
            }
        } else {
            n2 = Math.max(0, this.getPaddingLeft());
        }
        n3 = n5 - n11;
        this.setSelfDimensionBehaviour(constraintWidgetContainer, n4, n3, n6, n7 -= n10);
        constraintWidgetContainer.measure(n, n4, n3, n6, n7, this.mLastMeasureWidth, this.mLastMeasureHeight, n2, n8);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int n, Object object, Object object2) {
        if (n != 0) return;
        if (!(object instanceof String)) return;
        if (!(object2 instanceof Integer)) return;
        if (this.mDesignIds == null) {
            this.mDesignIds = new HashMap();
        }
        String string = (String)object;
        n = string.indexOf("/");
        object = string;
        if (n != -1) {
            object = string.substring(n + 1);
        }
        n = (Integer)object2;
        this.mDesignIds.put((String)object, n);
    }

    public void setId(int n) {
        this.mChildrenByIds.remove(this.getId());
        super.setId(n);
        this.mChildrenByIds.put(this.getId(), (Object)this);
    }

    public void setMaxHeight(int n) {
        if (n == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = n;
        this.requestLayout();
    }

    public void setMaxWidth(int n) {
        if (n == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = n;
        this.requestLayout();
    }

    public void setMinHeight(int n) {
        if (n == this.mMinHeight) {
            return;
        }
        this.mMinHeight = n;
        this.requestLayout();
    }

    public void setMinWidth(int n) {
        if (n == this.mMinWidth) {
            return;
        }
        this.mMinWidth = n;
        this.requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates == null) return;
        constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
    }

    public void setOptimizationLevel(int n) {
        this.mOptimizationLevel = n;
        this.mLayoutWidget.setOptimizationLevel(n);
    }

    /*
     * Unable to fully structure code
     */
    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block12: {
            block10: {
                block11: {
                    block9: {
                        block7: {
                            block8: {
                                var7_6 = this.mMeasurer.paddingHeight;
                                var6_7 = this.mMeasurer.paddingWidth;
                                var9_8 = ConstraintWidget.DimensionBehaviour.FIXED;
                                var10_9 = ConstraintWidget.DimensionBehaviour.FIXED;
                                var8_10 = this.getChildCount();
                                if (var2_2 == -2147483648) break block7;
                                if (var2_2 == 0) break block8;
                                if (var2_2 != 0x40000000) ** GOTO lbl-1000
                                var3_3 = Math.min(this.mMaxWidth - var6_7, var3_3);
                                break block9;
                            }
                            var9_8 = var11_11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            if (var8_10 == 0) {
                                var3_3 = Math.max(0, this.mMinWidth);
                                var9_8 = var11_11;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var3_3 = 0;
                            }
                            break block9;
                        }
                        var9_8 = var11_11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if (var8_10 == 0) {
                            var3_3 = Math.max(0, this.mMinWidth);
                            var9_8 = var11_11;
                        }
                    }
                    if (var4_4 == -2147483648) break block10;
                    if (var4_4 == 0) break block11;
                    if (var4_4 != 0x40000000) ** GOTO lbl-1000
                    var5_5 = Math.min(this.mMaxHeight - var7_6, var5_5);
                    break block12;
                }
                var10_9 = var11_11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (var8_10 == 0) {
                    var5_5 = Math.max(0, this.mMinHeight);
                    var10_9 = var11_11;
                } else lbl-1000:
                // 2 sources

                {
                    var5_5 = 0;
                }
                break block12;
            }
            var10_9 = var11_11 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (var8_10 == 0) {
                var5_5 = Math.max(0, this.mMinHeight);
                var10_9 = var11_11;
            }
        }
        if (var3_3 != var1_1.getWidth() || var5_5 != var1_1.getHeight()) {
            var1_1.invalidateMeasures();
        }
        var1_1.setX(0);
        var1_1.setY(0);
        var1_1.setMaxWidth(this.mMaxWidth - var6_7);
        var1_1.setMaxHeight(this.mMaxHeight - var7_6);
        var1_1.setMinWidth(0);
        var1_1.setMinHeight(0);
        var1_1.setHorizontalDimensionBehaviour(var9_8);
        var1_1.setWidth(var3_3);
        var1_1.setVerticalDimensionBehaviour(var10_9);
        var1_1.setHeight(var5_5);
        var1_1.setMinWidth(this.mMinWidth - var6_7);
        var1_1.setMinHeight(this.mMinHeight - var7_6);
    }

    public void setState(int n, int n2, int n3) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates == null) return;
        constraintLayoutStates.updateConstraints(n, (float)n2, (float)n3);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
