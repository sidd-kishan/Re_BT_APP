/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.Cache
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.SolverVariable
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$1
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.Optimizer
 *  androidx.constraintlayout.solver.widgets.VirtualLayout
 *  androidx.constraintlayout.solver.widgets.analyzer.ChainRun
 *  androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean OPTIMIZE_WRAP = false;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED = true;
    private boolean hasBaseline = false;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun = null;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle = 0.0f;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution = -1;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout = false;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec = 0;
    private int mLastVerticalMeasureSpec = 0;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight = 0;
    public int mMatchConstraintDefaultWidth = 0;
    public int mMatchConstraintMaxHeight = 0;
    public int mMatchConstraintMaxWidth = 0;
    public int mMatchConstraintMinHeight = 0;
    public int mMatchConstraintMinWidth = 0;
    public float mMatchConstraintPercentHeight = 1.0f;
    public float mMatchConstraintPercentWidth = 1.0f;
    private int[] mMaxDimension;
    private boolean mMeasureRequested = true;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio = 1.0f;
    int mResolvedDimensionRatioSide = -1;
    boolean mResolvedHasRatio = false;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution = -1;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured = false;
    private boolean resolvedHorizontal = false;
    private boolean resolvedVertical = false;
    public WidgetRun[] run = new WidgetRun[2];
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun = null;
    public int[] wrapMeasure;

    public ConstraintWidget() {
        float f;
        ConstraintAnchor constraintAnchor;
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = f = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.addAnchors();
    }

    public ConstraintWidget(int n, int n2) {
        this(0, 0, n, n2);
    }

    public ConstraintWidget(int n, int n2, int n3, int n4) {
        float f;
        ConstraintAnchor constraintAnchor;
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = f = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = n;
        this.mY = n2;
        this.mWidth = n3;
        this.mHeight = n4;
        this.addAnchors();
    }

    public ConstraintWidget(String string) {
        float f;
        ConstraintAnchor constraintAnchor;
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList();
        this.mIsInBarrier = new boolean[2];
        this.mListDimensionBehaviors = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = f = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.addAnchors();
        this.setDebugName(string);
    }

    public ConstraintWidget(String string, int n, int n2) {
        this(n, n2);
        this.setDebugName(string);
    }

    public ConstraintWidget(String string, int n, int n2, int n3, int n4) {
        this(n, n2, n3, n4);
        this.setDebugName(string);
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void applyConstraints(LinearSystem var1_1, boolean var2_2, boolean var3_3, boolean var4_4, boolean var5_5, SolverVariable var6_6, SolverVariable var7_7, DimensionBehaviour var8_8, boolean var9_9, ConstraintAnchor var10_10, ConstraintAnchor var11_11, int var12_12, int var13_13, int var14_14, int var15_15, float var16_16, boolean var17_17, boolean var18_18, boolean var19_19, boolean var20_20, boolean var21_21, int var22_22, int var23_23, int var24_24, int var25_25, float var26_26, boolean var27_27) {
        block77: {
            block94: {
                block78: {
                    block82: {
                        block84: {
                            block92: {
                                block93: {
                                    block80: {
                                        block85: {
                                            block90: {
                                                block91: {
                                                    block89: {
                                                        block87: {
                                                            block88: {
                                                                block86: {
                                                                    block83: {
                                                                        block81: {
                                                                            block79: {
                                                                                block76: {
                                                                                    var39_28 = var1_1.createObjectVariable((Object)var10_10);
                                                                                    var37_29 = var1_1.createObjectVariable((Object)var11_11);
                                                                                    var40_30 = var1_1.createObjectVariable((Object)var10_10.getTarget());
                                                                                    var38_31 = var1_1.createObjectVariable((Object)var11_11.getTarget());
                                                                                    if (LinearSystem.getMetrics() != null) {
                                                                                        var36_32 /* !! */  = LinearSystem.getMetrics();
                                                                                        ++var36_32 /* !! */ .nonresolvedWidgets;
                                                                                    }
                                                                                    var35_33 = var10_10.isConnected();
                                                                                    var33_34 = var11_11.isConnected();
                                                                                    var34_35 = this.mCenter.isConnected();
                                                                                    var29_36 = var35_33 != false ? 1 : 0;
                                                                                    var28_37 = var29_36;
                                                                                    if (var33_34) {
                                                                                        var28_37 = var29_36 + 1;
                                                                                    }
                                                                                    var29_36 = var28_37;
                                                                                    if (var34_35) {
                                                                                        var29_36 = var28_37 + 1;
                                                                                    }
                                                                                    var30_38 = var17_17 != false ? 3 : var22_22;
                                                                                    var22_22 = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[var8_8 /* !! */ .ordinal()];
                                                                                    var28_37 = var22_22 != 1 && var22_22 != 2 && var22_22 != 3 && var22_22 == 4 && var30_38 != 4 ? 1 : 0;
                                                                                    if (this.mVisibility == 8) {
                                                                                        var22_22 = 0;
                                                                                        var28_37 = 0;
                                                                                    } else {
                                                                                        var22_22 = var13_13;
                                                                                    }
                                                                                    if (var27_27) {
                                                                                        if (!(var35_33 || var33_34 || var34_35)) {
                                                                                            var1_1.addEquality(var39_28, var12_12);
                                                                                        } else if (var35_33 && !var33_34) {
                                                                                            var1_1.addEquality(var39_28, var40_30, var10_10.getMargin(), 8);
                                                                                        }
                                                                                    }
                                                                                    if (var28_37 != 0) break block76;
                                                                                    if (var9_9) {
                                                                                        var1_1.addEquality(var37_29, var39_28, 0, 3);
                                                                                        if (var14_14 > 0) {
                                                                                            var1_1.addGreaterThan(var37_29, var39_28, var14_14, 8);
                                                                                        }
                                                                                        if (var15_15 < 0x7FFFFFFF) {
                                                                                            var1_1.addLowerThan(var37_29, var39_28, var15_15, 8);
                                                                                        }
                                                                                    } else {
                                                                                        var1_1.addEquality(var37_29, var39_28, var22_22, 8);
                                                                                    }
                                                                                    var12_12 = var25_25;
                                                                                    ** GOTO lbl90
                                                                                }
                                                                                if (!(var29_36 == 2 || var17_17 || var30_38 != 1 && var30_38 != 0)) {
                                                                                    var12_12 = var13_13 = Math.max(var24_24, var22_22);
                                                                                    if (var25_25 > 0) {
                                                                                        var12_12 = Math.min(var25_25, var13_13);
                                                                                    }
                                                                                    var1_1.addEquality(var37_29, var39_28, var12_12, 8);
                                                                                    var28_37 = 0;
                                                                                    var12_12 = var25_25;
                                                                                    var25_25 = var24_24;
                                                                                } else {
                                                                                    var12_12 = var24_24;
                                                                                    if (var24_24 == -2) {
                                                                                        var12_12 = var22_22;
                                                                                    }
                                                                                    var13_13 = var25_25 == -2 ? var22_22 : var25_25;
                                                                                    var24_24 = var22_22;
                                                                                    if (var22_22 > 0) {
                                                                                        var24_24 = var22_22;
                                                                                        if (var30_38 != 1) {
                                                                                            var24_24 = 0;
                                                                                        }
                                                                                    }
                                                                                    var15_15 = var24_24;
                                                                                    if (var12_12 > 0) {
                                                                                        var1_1.addGreaterThan(var37_29, var39_28, var12_12, 8);
                                                                                        var15_15 = Math.max(var24_24, var12_12);
                                                                                    }
                                                                                    if (var13_13 > 0) {
                                                                                        var22_22 = var3_3 != false && var30_38 == 1 ? 0 : 1;
                                                                                        if (var22_22 != 0) {
                                                                                            var1_1.addLowerThan(var37_29, var39_28, var13_13, 8);
                                                                                        }
                                                                                        var15_15 = Math.min(var15_15, var13_13);
                                                                                    }
                                                                                    if (var30_38 == 1) {
                                                                                        if (var3_3) {
                                                                                            var1_1.addEquality(var37_29, var39_28, var15_15, 8);
                                                                                        } else if (var19_19) {
                                                                                            var1_1.addEquality(var37_29, var39_28, var15_15, 5);
                                                                                            var1_1.addLowerThan(var37_29, var39_28, var15_15, 8);
                                                                                        } else {
                                                                                            var1_1.addEquality(var37_29, var39_28, var15_15, 5);
                                                                                            var1_1.addLowerThan(var37_29, var39_28, var15_15, 8);
                                                                                        }
                                                                                        var24_24 = var12_12;
                                                                                        var12_12 = var13_13;
lbl90:
                                                                                        // 2 sources

                                                                                        var25_25 = var24_24;
                                                                                    } else if (var30_38 == 2) {
                                                                                        if (var10_10.getType() != ConstraintAnchor.Type.TOP && var10_10.getType() != ConstraintAnchor.Type.BOTTOM) {
                                                                                            var8_8 /* !! */  = var1_1.createObjectVariable((Object)this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                                                                                            var36_32 /* !! */  = var1_1.createObjectVariable((Object)this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                                                                                        } else {
                                                                                            var8_8 /* !! */  = var1_1.createObjectVariable((Object)this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                                                                                            var36_32 /* !! */  = var1_1.createObjectVariable((Object)this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                                                                                        }
                                                                                        var1_1.addConstraint(var1_1.createRow().createRowDimensionRatio(var37_29, var39_28, (SolverVariable)var36_32 /* !! */ , (SolverVariable)var8_8 /* !! */ , var26_26));
                                                                                        var25_25 = var12_12;
                                                                                        var28_37 = 0;
                                                                                        var12_12 = var13_13;
                                                                                    } else {
                                                                                        var5_5 = true;
                                                                                        var25_25 = var12_12;
                                                                                        var12_12 = var13_13;
                                                                                    }
                                                                                }
                                                                                if (!var27_27 || var19_19) break block77;
                                                                                if (!var35_33 && !var33_34 && !var34_35 || var35_33 && !var33_34) break block78;
                                                                                if (var35_33 || !var33_34) break block79;
                                                                                var1_1.addEquality(var37_29, var38_31, -var11_11.getMargin(), 8);
                                                                                if (var3_3) {
                                                                                    if (this.OPTIMIZE_WRAP && var39_28.isFinalValue && (var8_8 /* !! */  = this.mParent) != null) {
                                                                                        var6_6 /* !! */  = (ConstraintWidgetContainer)var8_8 /* !! */ ;
                                                                                        if (var2_2) {
                                                                                            var6_6 /* !! */ .addHorizontalWrapMinVariable(var10_10);
                                                                                        } else {
                                                                                            var6_6 /* !! */ .addVerticalWrapMinVariable(var10_10);
                                                                                        }
                                                                                    } else {
                                                                                        var1_1.addGreaterThan(var39_28, var6_6 /* !! */ , 0, 5);
                                                                                    }
                                                                                }
                                                                                break block78;
                                                                            }
                                                                            if (!var35_33 || !var33_34) break block78;
                                                                            var41_39 = var10_10.mTarget.mOwner;
                                                                            var8_8 /* !! */  = var11_11.mTarget.mOwner;
                                                                            var36_32 /* !! */  = this.getParent();
                                                                            var31_40 = 6;
                                                                            if (var28_37 == 0) break block80;
                                                                            if (var30_38 != 0) break block81;
                                                                            if (var12_12 == 0 && var25_25 == 0) {
                                                                                if (var40_30.isFinalValue && var38_31.isFinalValue) {
                                                                                    var1_1.addEquality(var39_28, var40_30, var10_10.getMargin(), 8);
                                                                                    var1_1.addEquality(var37_29, var38_31, -var11_11.getMargin(), 8);
                                                                                    return;
                                                                                }
                                                                                var15_15 = 0;
                                                                                var22_22 = 1;
                                                                                var12_12 = 0;
                                                                                var23_23 = 8;
                                                                                var13_13 = 8;
                                                                            } else {
                                                                                var15_15 = 1;
                                                                                var22_22 = 0;
                                                                                var12_12 = 1;
                                                                                var23_23 = 5;
                                                                                var13_13 = 5;
                                                                            }
                                                                            if (var41_39 instanceof Barrier || var8_8 /* !! */  instanceof Barrier) {
                                                                                var13_13 = 4;
                                                                            }
                                                                            var32_41 = 6;
                                                                            var29_36 = var23_23;
                                                                            var24_24 = var15_15;
                                                                            var15_15 = var12_12;
                                                                            var23_23 = var22_22;
                                                                            var12_12 = var29_36;
                                                                            var22_22 = var32_41;
                                                                            break block82;
                                                                        }
                                                                        if (var30_38 != 1) break block83;
                                                                        var15_15 = 1;
                                                                        var24_24 = 1;
                                                                        var23_23 = 0;
                                                                        var12_12 = 8;
                                                                        break block84;
                                                                    }
                                                                    if (var30_38 != 3) break block85;
                                                                    if (this.mResolvedDimensionRatioSide != -1) break block86;
                                                                    if (var20_20) {
                                                                        var12_12 = 8;
                                                                        var22_22 = var3_3 ? 5 : 4;
                                                                    } else {
                                                                        var12_12 = 8;
                                                                        var22_22 = 8;
                                                                    }
                                                                    break block87;
                                                                }
                                                                if (!var17_17) break block88;
                                                                var12_12 = var23_23 != 2 && var23_23 != 1 ? 0 : 1;
                                                                if (var12_12 == 0) {
                                                                    var13_13 = 8;
                                                                    var12_12 = 5;
                                                                } else {
                                                                    var13_13 = 5;
                                                                    var12_12 = 4;
                                                                }
                                                                var22_22 = var13_13;
                                                                var13_13 = var12_12;
                                                                var15_15 = 1;
                                                                var24_24 = 1;
                                                                var23_23 = 1;
                                                                var29_36 = 6;
                                                                var12_12 = var22_22;
                                                                var22_22 = var29_36;
                                                                break block82;
                                                            }
                                                            if (var12_12 <= 0) break block89;
                                                            var12_12 = 5;
                                                            var22_22 = 6;
                                                        }
                                                        var23_23 = 1;
                                                        var24_24 = 1;
                                                        var15_15 = 1;
                                                        var13_13 = 5;
                                                        break block82;
                                                    }
                                                    if (var12_12 != 0 || var25_25 != 0) break block90;
                                                    if (var20_20) break block91;
                                                    var15_15 = 1;
                                                    var24_24 = 1;
                                                    var23_23 = 1;
                                                    var12_12 = 5;
                                                    var22_22 = 6;
                                                    var13_13 = 8;
                                                    break block82;
                                                }
                                                var12_12 = var41_39 != var36_32 /* !! */  && var8_8 /* !! */  != var36_32 /* !! */  ? 4 : 5;
                                                var15_15 = 1;
                                                var24_24 = 1;
                                                var23_23 = 1;
                                                break block84;
                                            }
                                            var15_15 = 1;
                                            var24_24 = 1;
                                            var23_23 = 1;
                                            break block92;
                                        }
                                        var15_15 = 0;
                                        var24_24 = 0;
                                        break block93;
                                    }
                                    if (var40_30.isFinalValue && var38_31.isFinalValue) {
                                        var1_1.addCentering(var39_28, var40_30, var10_10.getMargin(), var16_16, var38_31, var37_29, var11_11.getMargin(), 8);
                                        if (var3_3 == false) return;
                                        if (var5_5 == false) return;
                                        var12_12 = var11_11.mTarget != null ? var11_11.getMargin() : 0;
                                        if (var38_31 == var7_7) return;
                                        var1_1.addGreaterThan(var7_7, var37_29, var12_12, 5);
                                        return;
                                    }
                                    var15_15 = 1;
                                    var24_24 = 1;
                                }
                                var23_23 = 0;
                            }
                            var12_12 = 5;
                        }
                        var22_22 = 6;
                        var13_13 = 4;
                    }
                    if (var15_15 != 0 && var40_30 == var38_31 && var41_39 != var36_32 /* !! */ ) {
                        var15_15 = 0;
                        var29_36 = 0;
                    } else {
                        var29_36 = 1;
                    }
                    if (var24_24 != 0) {
                        if (var28_37 == 0 && !var18_18 && !var20_20 && var40_30 == var6_6 /* !! */  && var38_31 == var7_7) {
                            var3_3 = false;
                            var12_12 = 8;
                            var22_22 = 8;
                            var29_36 = 0;
                        }
                        var1_1.addCentering(var39_28, var40_30, var10_10.getMargin(), var16_16, var38_31, var37_29, var11_11.getMargin(), var22_22);
                    }
                    if (this.mVisibility == 8 && !var11_11.hasDependents()) {
                        return;
                    }
                    if (var15_15 != 0) {
                        if (var3_3 && var40_30 != var38_31 && var28_37 == 0 && (var41_39 instanceof Barrier || var8_8 /* !! */  instanceof Barrier)) {
                            var12_12 = 6;
                        }
                        var1_1.addGreaterThan(var39_28, var40_30, var10_10.getMargin(), var12_12);
                        var1_1.addLowerThan(var37_29, var38_31, -var11_11.getMargin(), var12_12);
                    }
                    if (var3_3 && var21_21 && !(var41_39 instanceof Barrier) && !(var8_8 /* !! */  instanceof Barrier)) {
                        var15_15 = 6;
                        var12_12 = 6;
                        var29_36 = 1;
                    } else {
                        var15_15 = var12_12;
                        var12_12 = var13_13;
                    }
                    if (var29_36 != 0) {
                        if (var23_23 != 0 && (!var20_20 || var4_4)) {
                            var13_13 = var31_40;
                            if (var41_39 != var36_32 /* !! */ ) {
                                var13_13 = var8_8 /* !! */  == var36_32 /* !! */  ? var31_40 : var12_12;
                            }
                            if (var41_39 instanceof Guideline || var8_8 /* !! */  instanceof Guideline) {
                                var13_13 = 5;
                            }
                            if (var41_39 instanceof Barrier || var8_8 /* !! */  instanceof Barrier) {
                                var13_13 = 5;
                            }
                            if (var20_20) {
                                var13_13 = 5;
                            }
                            var13_13 = Math.max(var13_13, var12_12);
                        } else {
                            var13_13 = var12_12;
                        }
                        var12_12 = var13_13;
                        if (var3_3) {
                            var12_12 = Math.min(var15_15, var13_13);
                            if (var17_17 && !var20_20 && (var41_39 == var36_32 /* !! */  || var8_8 /* !! */  == var36_32 /* !! */ )) {
                                var12_12 = 4;
                            }
                        }
                        var1_1.addEquality(var39_28, var40_30, var10_10.getMargin(), var12_12);
                        var1_1.addEquality(var37_29, var38_31, -var11_11.getMargin(), var12_12);
                    }
                    if (var3_3) {
                        var12_12 = var6_6 /* !! */  == var40_30 ? var10_10.getMargin() : 0;
                        if (var40_30 != var6_6 /* !! */ ) {
                            var1_1.addGreaterThan(var39_28, var6_6 /* !! */ , var12_12, 5);
                        }
                    }
                    var4_4 = var3_3;
                    if (var3_3) {
                        var4_4 = var3_3;
                        if (var28_37 != 0) {
                            var4_4 = var3_3;
                            if (var14_14 == 0) {
                                var4_4 = var3_3;
                                if (var25_25 == 0) {
                                    if (var28_37 != 0 && var30_38 == 3) {
                                        var1_1.addGreaterThan(var37_29, var39_28, 0, 8);
                                        var4_4 = var3_3;
                                    } else {
                                        var1_1.addGreaterThan(var37_29, var39_28, 0, 5);
                                        var4_4 = var3_3;
                                    }
                                }
                            }
                        }
                    }
                    break block94;
                }
                var4_4 = var3_3;
            }
            if (var4_4 == false) return;
            if (var5_5 == false) return;
            var12_12 = var11_11.mTarget != null ? var11_11.getMargin() : 0;
            if (var38_31 == var7_7) return;
            if (this.OPTIMIZE_WRAP && var37_29.isFinalValue && (var6_6 /* !! */  = this.mParent) != null) {
                var1_1 = (ConstraintWidgetContainer)var6_6 /* !! */ ;
                if (var2_2) {
                    var1_1.addHorizontalWrapMaxVariable(var11_11);
                } else {
                    var1_1.addVerticalWrapMaxVariable(var11_11);
                }
                return;
            }
            var1_1.addGreaterThan(var7_7, var37_29, var12_12, 5);
            return;
        }
        var13_13 = 1;
        if (var29_36 >= 2) return;
        if (var3_3 == false) return;
        if (var5_5 == false) return;
        var1_1.addGreaterThan(var39_28, var6_6 /* !! */ , 0, 8);
        var12_12 = !var2_2 && this.mBaseline.mTarget != null ? 0 : 1;
        if (!var2_2 && this.mBaseline.mTarget != null) {
            var6_6 /* !! */  = this.mBaseline.mTarget.mOwner;
            var12_12 = var6_6 /* !! */ .mDimensionRatio != 0.0f && var6_6 /* !! */ .mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && var6_6 /* !! */ .mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT ? var13_13 : 0;
        }
        if (var12_12 == 0) return;
        var1_1.addGreaterThan(var7_7, var37_29, 0, 8);
    }

    private boolean isChainHead(int n) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor[] constraintAnchorArray = this.mListAnchors[n *= 2].mTarget;
        boolean bl = true;
        if (constraintAnchorArray != null && (constraintAnchor = this.mListAnchors[n].mTarget.mTarget) != (constraintAnchorArray = this.mListAnchors)[n] && constraintAnchorArray[++n].mTarget != null && this.mListAnchors[n].mTarget.mTarget == this.mListAnchors[n]) return bl;
        bl = false;
        return bl;
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int n, boolean bl) {
        if (bl) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent((ConstraintWidgetContainer)constraintWidgetContainer, (LinearSystem)linearSystem, (ConstraintWidget)this);
            hashSet.remove(this);
            this.addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (n == 0) {
            Object object = this.mLeft.getDependents();
            if (object != null) {
                object = ((HashSet)object).iterator();
                while (object.hasNext()) {
                    ((ConstraintAnchor)object.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n, true);
                }
            }
            if ((object = this.mRight.getDependents()) == null) return;
            object = ((HashSet)object).iterator();
            while (object.hasNext()) {
                ((ConstraintAnchor)object.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n, true);
            }
            return;
        }
        Object object = this.mTop.getDependents();
        if (object != null) {
            object = ((HashSet)object).iterator();
            while (object.hasNext()) {
                ((ConstraintAnchor)object.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n, true);
            }
        }
        if ((object = this.mBottom.getDependents()) != null) {
            object = ((HashSet)object).iterator();
            while (object.hasNext()) {
                ((ConstraintAnchor)object.next()).mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n, true);
            }
        }
        if ((object = this.mBaseline.getDependents()) == null) return;
        Iterator iterator = ((HashSet)object).iterator();
        while (iterator.hasNext()) {
            object = ((ConstraintAnchor)iterator.next()).mOwner;
            ((ConstraintWidget)object).addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n, true);
        }
    }

    boolean addFirst() {
        boolean bl = this instanceof VirtualLayout || this instanceof Guideline;
        return bl;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void addToSolver(LinearSystem var1_1, boolean var2_2) {
        block65: {
            block61: {
                block56: {
                    block64: {
                        block62: {
                            block58: {
                                block63: {
                                    block59: {
                                        block60: {
                                            block57: {
                                                var28_3 = var1_1.createObjectVariable((Object)this.mLeft);
                                                var29_4 = var1_1.createObjectVariable((Object)this.mRight);
                                                var27_5 = var1_1.createObjectVariable((Object)this.mTop);
                                                var26_6 = var1_1.createObjectVariable((Object)this.mBottom);
                                                var30_7 = var1_1.createObjectVariable((Object)this.mBaseline);
                                                var24_8 = this.mParent;
                                                if (var24_8 != null) {
                                                    var11_9 = var24_8 != null && var24_8.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
                                                    var24_8 = this.mParent;
                                                    var12_10 = var24_8 != null && var24_8.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
                                                    var14_11 = var11_9;
                                                    var13_12 = var12_10;
                                                } else {
                                                    var14_11 = false;
                                                    var13_12 = false;
                                                }
                                                if (this.mVisibility == 8 && !this.hasDependencies() && (var24_8 = (Object)this.mIsInBarrier)[0] == false && var24_8[1] == false) {
                                                    return;
                                                }
                                                if (this.resolvedHorizontal || this.resolvedVertical) {
                                                    if (this.resolvedHorizontal) {
                                                        var1_1.addEquality(var28_3, this.mX);
                                                        var1_1.addEquality(var29_4, this.mX + this.mWidth);
                                                        if (var14_11 && (var24_8 = this.mParent) != null) {
                                                            if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                                                                var24_8 = (ConstraintWidgetContainer)var24_8;
                                                                var24_8.addVerticalWrapMinVariable(this.mLeft);
                                                                var24_8.addHorizontalWrapMaxVariable(this.mRight);
                                                            } else {
                                                                var1_1.addGreaterThan(var1_1.createObjectVariable((Object)var24_8.mRight), var29_4, 0, 5);
                                                            }
                                                        }
                                                    }
                                                    if (this.resolvedVertical) {
                                                        var1_1.addEquality(var27_5, this.mY);
                                                        var1_1.addEquality(var26_6, this.mY + this.mHeight);
                                                        if (this.mBaseline.hasDependents()) {
                                                            var1_1.addEquality(var30_7, this.mY + this.mBaselineDistance);
                                                        }
                                                        if (var13_12 && (var24_8 = this.mParent) != null) {
                                                            if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                                                                var24_8 = (ConstraintWidgetContainer)var24_8;
                                                                var24_8.addVerticalWrapMinVariable(this.mTop);
                                                                var24_8.addVerticalWrapMaxVariable(this.mBottom);
                                                            } else {
                                                                var1_1.addGreaterThan(var1_1.createObjectVariable((Object)var24_8.mBottom), var26_6, 0, 5);
                                                            }
                                                        }
                                                    }
                                                    if (this.resolvedHorizontal && this.resolvedVertical) {
                                                        this.resolvedHorizontal = false;
                                                        this.resolvedVertical = false;
                                                        return;
                                                    }
                                                }
                                                if (LinearSystem.sMetrics != null) {
                                                    var24_8 = LinearSystem.sMetrics;
                                                    ++var24_8.widgets;
                                                }
                                                if (var2_2 && (var24_8 = this.horizontalRun) != null && this.verticalRun != null && var24_8.start.resolved && this.horizontalRun.end.resolved && this.verticalRun.start.resolved && this.verticalRun.end.resolved) {
                                                    if (LinearSystem.sMetrics != null) {
                                                        var24_8 = LinearSystem.sMetrics;
                                                        ++var24_8.graphSolved;
                                                    }
                                                    var1_1.addEquality(var28_3, this.horizontalRun.start.value);
                                                    var1_1.addEquality(var29_4, this.horizontalRun.end.value);
                                                    var1_1.addEquality(var27_5, this.verticalRun.start.value);
                                                    var1_1.addEquality(var26_6, this.verticalRun.end.value);
                                                    var1_1.addEquality(var30_7, this.verticalRun.baseline.value);
                                                    if (this.mParent != null) {
                                                        if (var14_11 && this.isTerminalWidget[0] && !this.isInHorizontalChain()) {
                                                            var1_1.addGreaterThan(var1_1.createObjectVariable((Object)this.mParent.mRight), var29_4, 0, 8);
                                                        }
                                                        if (var13_12 && this.isTerminalWidget[1] && !this.isInVerticalChain()) {
                                                            var1_1.addGreaterThan(var1_1.createObjectVariable((Object)this.mParent.mBottom), var26_6, 0, 8);
                                                        }
                                                    }
                                                    this.resolvedHorizontal = false;
                                                    this.resolvedVertical = false;
                                                    return;
                                                }
                                                if (LinearSystem.sMetrics != null) {
                                                    var24_8 = LinearSystem.sMetrics;
                                                    ++var24_8.linearSolved;
                                                }
                                                if (this.mParent != null) {
                                                    if (this.isChainHead(0)) {
                                                        ((ConstraintWidgetContainer)this.mParent).addChain(this, 0);
                                                        var11_9 = true;
                                                    } else {
                                                        var11_9 = this.isInHorizontalChain();
                                                    }
                                                    if (this.isChainHead(1)) {
                                                        ((ConstraintWidgetContainer)this.mParent).addChain(this, 1);
                                                        var12_10 = true;
                                                    } else {
                                                        var12_10 = this.isInVerticalChain();
                                                    }
                                                    if (!var11_9 && var14_11 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                                                        var1_1.addGreaterThan(var1_1.createObjectVariable((Object)this.mParent.mRight), var29_4, 0, 1);
                                                    }
                                                    if (!var12_10 && var13_12 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                                                        var1_1.addGreaterThan(var1_1.createObjectVariable((Object)this.mParent.mBottom), var26_6, 0, 1);
                                                    }
                                                    var15_13 = var12_10;
                                                    var12_10 = var11_9;
                                                } else {
                                                    var15_13 = false;
                                                    var12_10 = false;
                                                }
                                                var5_14 = this.mWidth;
                                                var6_15 = this.mMinWidth;
                                                var4_16 = var5_14;
                                                if (var5_14 < var6_15) {
                                                    var4_16 = var6_15;
                                                }
                                                var7_17 = this.mHeight;
                                                var6_15 = this.mMinHeight;
                                                var5_14 = var7_17;
                                                if (var7_17 < var6_15) {
                                                    var5_14 = var6_15;
                                                }
                                                var11_9 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
                                                var16_18 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
                                                this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
                                                this.mResolvedDimensionRatio = var3_19 = this.mDimensionRatio;
                                                var7_17 = this.mMatchConstraintDefaultWidth;
                                                var8_20 = this.mMatchConstraintDefaultHeight;
                                                if (!(var3_19 > 0.0f) || this.mVisibility == 8) break block56;
                                                var6_15 = var7_17;
                                                if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                                    var6_15 = var7_17;
                                                    if (var7_17 == 0) {
                                                        var6_15 = 3;
                                                    }
                                                }
                                                var7_17 = var8_20;
                                                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
                                                    var7_17 = var8_20;
                                                    if (var8_20 == 0) {
                                                        var7_17 = 3;
                                                    }
                                                }
                                                if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT || this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT || var6_15 != 3 || var7_17 != 3) break block57;
                                                this.setupDimensionRatio(var14_11, var13_12, var11_9, var16_18);
                                                break block58;
                                            }
                                            if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT || var6_15 != 3) break block59;
                                            this.mResolvedDimensionRatioSide = 0;
                                            var4_16 = (int)(this.mResolvedDimensionRatio * (float)this.mHeight);
                                            var25_21 /* !! */  = this.mListDimensionBehaviors[1];
                                            var24_8 = DimensionBehaviour.MATCH_CONSTRAINT;
                                            var8_20 = var7_17;
                                            if (var25_21 /* !! */  == var24_8) break block60;
                                            var6_15 = var5_14;
                                            var11_9 = false;
                                            var7_17 = 4;
                                            var5_14 = var4_16;
                                            var4_16 = var6_15;
                                            var6_15 = var8_20;
                                            break block61;
                                        }
                                        var8_20 = var4_16;
                                        break block62;
                                    }
                                    if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT || var7_17 != 3) break block58;
                                    this.mResolvedDimensionRatioSide = 1;
                                    if (this.mDimensionRatioSide == -1) {
                                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                                    }
                                    var8_20 = (int)(this.mResolvedDimensionRatio * (float)this.mWidth);
                                    var25_21 /* !! */  = this.mListDimensionBehaviors[0];
                                    var24_8 = DimensionBehaviour.MATCH_CONSTRAINT;
                                    if (var25_21 /* !! */  == var24_8) break block63;
                                    var7_17 = var6_15;
                                    var11_9 = false;
                                    var6_15 = 4;
                                    var5_14 = var4_16;
                                    var4_16 = var8_20;
                                    break block61;
                                }
                                var5_14 = var4_16;
                                var4_16 = var8_20;
                                break block64;
                            }
                            var8_20 = var4_16;
                        }
                        var4_16 = var5_14;
                        var5_14 = var8_20;
                    }
                    var8_20 = var6_15;
                    var6_15 = var7_17;
                    var11_9 = true;
                    var7_17 = var8_20;
                    break block61;
                }
                var6_15 = var8_20;
                var8_20 = var4_16;
                var4_16 = var5_14;
                var11_9 = false;
                var5_14 = var8_20;
            }
            var24_8 = this.mResolvedMatchConstraintDefault;
            var24_8[0] = var7_17;
            var24_8[1] = var6_15;
            this.mResolvedHasRatio = var11_9;
            var17_22 = var11_9 != false && ((var8_20 = this.mResolvedDimensionRatioSide) == 0 || var8_20 == -1);
            var16_18 = var11_9 != false && ((var8_20 = this.mResolvedDimensionRatioSide) == 1 || var8_20 == -1);
            var18_23 = this.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT && this instanceof ConstraintWidgetContainer != false;
            if (var18_23) {
                var5_14 = 0;
            }
            var20_24 = this.mCenter.isConnected() ^ true;
            var24_8 = this.mIsInBarrier;
            var22_25 = var24_8[0];
            var21_26 = var24_8[1];
            if (this.mHorizontalResolution != 2 && !this.resolvedHorizontal) {
                if (var2_2 && (var24_8 = this.horizontalRun) != null && var24_8.start.resolved && this.horizontalRun.end.resolved) {
                    if (var2_2) {
                        var1_1.addEquality(var28_3, this.horizontalRun.start.value);
                        var1_1.addEquality(var29_4, this.horizontalRun.end.value);
                        if (this.mParent != null && var14_11 && this.isTerminalWidget[0] && !this.isInHorizontalChain()) {
                            var1_1.addGreaterThan(var1_1.createObjectVariable((Object)this.mParent.mRight), var29_4, 0, 8);
                        }
                    }
                } else {
                    var24_8 = this.mParent;
                    var24_8 = var24_8 != null ? var1_1.createObjectVariable((Object)var24_8.mRight) : null;
                    var25_21 /* !! */  = this.mParent;
                    var25_21 /* !! */  = var25_21 /* !! */  != null ? var1_1.createObjectVariable((Object)var25_21 /* !! */ .mLeft) : null;
                    var23_27 = this.isTerminalWidget[0];
                    var33_28 = this.mListDimensionBehaviors;
                    var34_29 = var33_28[0];
                    var32_30 = this.mLeft;
                    var31_31 = this.mRight;
                    var8_20 = this.mX;
                    var9_32 = this.mMinWidth;
                    var10_33 = this.mMaxDimension[0];
                    var3_19 = this.mHorizontalBiasPercent;
                    var19_34 = var33_28[1] == DimensionBehaviour.MATCH_CONSTRAINT;
                    this.applyConstraints(var1_1, true, var14_11, var13_12, var23_27, (SolverVariable)var25_21 /* !! */ , (SolverVariable)var24_8, var34_29, var18_23, var32_30, (ConstraintAnchor)var31_31, var8_20, var5_14, var9_32, var10_33, var3_19, var17_22, var19_34, var12_10, var15_13, (boolean)var22_25, var7_17, var6_15, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, var20_24);
                }
            }
            if (var2_2 && (var24_8 = this.verticalRun) != null && var24_8.start.resolved && this.verticalRun.end.resolved) {
                var5_14 = this.verticalRun.start.value;
                var1_1.addEquality(var27_5, var5_14);
                var5_14 = this.verticalRun.end.value;
                var1_1.addEquality(var26_6, var5_14);
                var1_1.addEquality(var30_7, this.verticalRun.baseline.value);
                var24_8 = this.mParent;
                if (var24_8 != null && !var15_13 && var13_12 && this.isTerminalWidget[1]) {
                    var1_1.addGreaterThan(var1_1.createObjectVariable((Object)var24_8.mBottom), var26_6, 0, 8);
                }
                var5_14 = 0;
            } else {
                var5_14 = 1;
            }
            if (this.mVerticalResolution == 2) {
                var5_14 = 0;
            }
            if (var5_14 == 0 || this.resolvedVertical) break block65;
            var2_2 = this.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT && this instanceof ConstraintWidgetContainer != false;
            if (var2_2) {
                var4_16 = 0;
            }
            var24_8 = (var24_8 = this.mParent) != null ? var1_1.createObjectVariable((Object)var24_8.mBottom) : null;
            var25_21 /* !! */  = this.mParent;
            var25_21 /* !! */  = var25_21 /* !! */  != null ? var1_1.createObjectVariable((Object)var25_21 /* !! */ .mTop) : null;
            if (this.mBaselineDistance <= 0 && this.mVisibility != 8) ** GOTO lbl246
            if (this.mBaseline.mTarget != null) {
                var1_1.addEquality(var30_7, var27_5, this.getBaselineDistance(), 8);
                var1_1.addEquality(var30_7, var1_1.createObjectVariable((Object)this.mBaseline.mTarget), 0, 8);
                if (var13_12) {
                    var1_1.addGreaterThan((SolverVariable)var24_8, var1_1.createObjectVariable((Object)this.mBottom), 0, 5);
                }
                var17_22 = false;
            } else {
                if (this.mVisibility == 8) {
                    var1_1.addEquality(var30_7, var27_5, 0, 8);
                } else {
                    var1_1.addEquality(var30_7, var27_5, this.getBaselineDistance(), 8);
                }
lbl246:
                // 3 sources

                var17_22 = var20_24;
            }
            var19_34 = this.isTerminalWidget[1];
            var31_31 = this.mListDimensionBehaviors;
            var32_30 = var31_31[1];
            var33_28 = this.mTop;
            var30_7 = this.mBottom;
            var5_14 = this.mY;
            var8_20 = this.mMinHeight;
            var9_32 = this.mMaxDimension[1];
            var3_19 = this.mVerticalBiasPercent;
            var18_23 = var31_31[0] == DimensionBehaviour.MATCH_CONSTRAINT;
            this.applyConstraints(var1_1, false, var13_12, var14_11, var19_34, (SolverVariable)var25_21 /* !! */ , (SolverVariable)var24_8, (DimensionBehaviour)var32_30, var2_2, var33_28, (ConstraintAnchor)var30_7, var5_14, var4_16, var8_20, var9_32, var3_19, var16_18, var18_23, var15_13, var12_10, (boolean)var21_26, var6_15, var7_17, this.mMatchConstraintMinHeight, this.mMatchConstraintMaxHeight, this.mMatchConstraintPercentHeight, var17_22);
        }
        if (var11_9) {
            if (this.mResolvedDimensionRatioSide == 1) {
                var1_1.addRatio(var26_6, var27_5, var29_4, var28_3, this.mResolvedDimensionRatio, 8);
            } else {
                var1_1.addRatio(var29_4, var28_3, var26_6, var27_5, this.mResolvedDimensionRatio, 8);
            }
        }
        if (this.mCenter.isConnected()) {
            var1_1.addCenterPoint(this, this.mCenter.getTarget().getOwner(), (float)Math.toRadians(this.mCircleConstraintAngle + 90.0f), this.mCenter.getMargin());
        }
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        boolean bl = this.mVisibility != 8;
        return bl;
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        this.connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int n) {
        block25: {
            int n2;
            ConstraintAnchor constraintAnchor;
            block31: {
                block32: {
                    block33: {
                        block30: {
                            block29: {
                                block28: {
                                    block27: {
                                        block26: {
                                            block24: {
                                                if (type != ConstraintAnchor.Type.CENTER) break block24;
                                                if (type2 == ConstraintAnchor.Type.CENTER) {
                                                    ConstraintAnchor constraintAnchor2 = this.getAnchor(ConstraintAnchor.Type.LEFT);
                                                    ConstraintAnchor constraintAnchor3 = this.getAnchor(ConstraintAnchor.Type.RIGHT);
                                                    type2 = this.getAnchor(ConstraintAnchor.Type.TOP);
                                                    type = this.getAnchor(ConstraintAnchor.Type.BOTTOM);
                                                    boolean bl = true;
                                                    if (constraintAnchor2 != null && constraintAnchor2.isConnected() || constraintAnchor3 != null && constraintAnchor3.isConnected()) {
                                                        n = 0;
                                                    } else {
                                                        this.connect(ConstraintAnchor.Type.LEFT, constraintWidget, ConstraintAnchor.Type.LEFT, 0);
                                                        this.connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.RIGHT, 0);
                                                        n = 1;
                                                    }
                                                    if (type2 != null && type2.isConnected() || type != null && type.isConnected()) {
                                                        bl = false;
                                                    } else {
                                                        this.connect(ConstraintAnchor.Type.TOP, constraintWidget, ConstraintAnchor.Type.TOP, 0);
                                                        this.connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, ConstraintAnchor.Type.BOTTOM, 0);
                                                    }
                                                    if (n != 0 && bl) {
                                                        this.getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                                                    } else if (n != 0) {
                                                        this.getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                                                    } else {
                                                        if (!bl) return;
                                                        this.getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                                                    }
                                                } else if (type2 != ConstraintAnchor.Type.LEFT && type2 != ConstraintAnchor.Type.RIGHT) {
                                                    if (type2 != ConstraintAnchor.Type.TOP) {
                                                        if (type2 != ConstraintAnchor.Type.BOTTOM) return;
                                                    }
                                                    this.connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                                                    this.connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                                                    this.getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
                                                } else {
                                                    this.connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
                                                    type = ConstraintAnchor.Type.RIGHT;
                                                    this.connect(type, constraintWidget, type2, 0);
                                                    this.getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
                                                }
                                                break block25;
                                            }
                                            if (type != ConstraintAnchor.Type.CENTER_X || type2 != ConstraintAnchor.Type.LEFT && type2 != ConstraintAnchor.Type.RIGHT) break block26;
                                            type = this.getAnchor(ConstraintAnchor.Type.LEFT);
                                            type2 = constraintWidget.getAnchor(type2);
                                            constraintWidget = this.getAnchor(ConstraintAnchor.Type.RIGHT);
                                            type.connect((ConstraintAnchor)type2, 0);
                                            constraintWidget.connect((ConstraintAnchor)type2, 0);
                                            this.getAnchor(ConstraintAnchor.Type.CENTER_X).connect((ConstraintAnchor)type2, 0);
                                            break block25;
                                        }
                                        if (type != ConstraintAnchor.Type.CENTER_Y || type2 != ConstraintAnchor.Type.TOP && type2 != ConstraintAnchor.Type.BOTTOM) break block27;
                                        type = constraintWidget.getAnchor(type2);
                                        this.getAnchor(ConstraintAnchor.Type.TOP).connect((ConstraintAnchor)type, 0);
                                        this.getAnchor(ConstraintAnchor.Type.BOTTOM).connect((ConstraintAnchor)type, 0);
                                        this.getAnchor(ConstraintAnchor.Type.CENTER_Y).connect((ConstraintAnchor)type, 0);
                                        break block25;
                                    }
                                    if (type != ConstraintAnchor.Type.CENTER_X || type2 != ConstraintAnchor.Type.CENTER_X) break block28;
                                    this.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
                                    this.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
                                    this.getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
                                    break block25;
                                }
                                if (type != ConstraintAnchor.Type.CENTER_Y || type2 != ConstraintAnchor.Type.CENTER_Y) break block29;
                                this.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
                                this.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
                                this.getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
                                break block25;
                            }
                            constraintAnchor = this.getAnchor(type);
                            if (!constraintAnchor.isValidConnection((ConstraintAnchor)(constraintWidget = constraintWidget.getAnchor(type2)))) return;
                            if (type != ConstraintAnchor.Type.BASELINE) break block30;
                            type = this.getAnchor(ConstraintAnchor.Type.TOP);
                            type2 = this.getAnchor(ConstraintAnchor.Type.BOTTOM);
                            if (type != null) {
                                type.reset();
                            }
                            if (type2 != null) {
                                type2.reset();
                            }
                            n2 = 0;
                            break block31;
                        }
                        if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) break block32;
                        if (type == ConstraintAnchor.Type.LEFT) break block33;
                        n2 = n;
                        if (type != ConstraintAnchor.Type.RIGHT) break block31;
                    }
                    if ((type2 = this.getAnchor(ConstraintAnchor.Type.CENTER)).getTarget() != constraintWidget) {
                        type2.reset();
                    }
                    type = this.getAnchor(type).getOpposite();
                    type2 = this.getAnchor(ConstraintAnchor.Type.CENTER_X);
                    n2 = n;
                    if (type2.isConnected()) {
                        type.reset();
                        type2.reset();
                        n2 = n;
                    }
                    break block31;
                }
                type2 = this.getAnchor(ConstraintAnchor.Type.BASELINE);
                if (type2 != null) {
                    type2.reset();
                }
                if ((type2 = this.getAnchor(ConstraintAnchor.Type.CENTER)).getTarget() != constraintWidget) {
                    type2.reset();
                }
                type = this.getAnchor(type).getOpposite();
                type2 = this.getAnchor(ConstraintAnchor.Type.CENTER_Y);
                n2 = n;
                if (type2.isConnected()) {
                    type.reset();
                    type2.reset();
                    n2 = n;
                }
            }
            constraintAnchor.connect((ConstraintAnchor)constraintWidget, n2);
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int n) {
        if (constraintAnchor.getOwner() != this) return;
        this.connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), n);
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f, int n) {
        this.immediateConnect(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, n, 0);
        this.mCircleConstraintAngle = f;
    }

    public void copy(ConstraintWidget object, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.mHorizontalResolution = ((ConstraintWidget)object).mHorizontalResolution;
        this.mVerticalResolution = ((ConstraintWidget)object).mVerticalResolution;
        this.mMatchConstraintDefaultWidth = ((ConstraintWidget)object).mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = ((ConstraintWidget)object).mMatchConstraintDefaultHeight;
        int[] nArray = this.mResolvedMatchConstraintDefault;
        Object object2 = ((ConstraintWidget)object).mResolvedMatchConstraintDefault;
        nArray[0] = object2[0];
        nArray[1] = object2[1];
        this.mMatchConstraintMinWidth = ((ConstraintWidget)object).mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = ((ConstraintWidget)object).mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = ((ConstraintWidget)object).mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = ((ConstraintWidget)object).mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = ((ConstraintWidget)object).mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = ((ConstraintWidget)object).mIsWidthWrapContent;
        this.mIsHeightWrapContent = ((ConstraintWidget)object).mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = ((ConstraintWidget)object).mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = ((ConstraintWidget)object).mResolvedDimensionRatio;
        object2 = ((ConstraintWidget)object).mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(object2, ((int[])object2).length);
        this.mCircleConstraintAngle = ((ConstraintWidget)object).mCircleConstraintAngle;
        this.hasBaseline = ((ConstraintWidget)object).hasBaseline;
        this.inPlaceholder = ((ConstraintWidget)object).inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = Arrays.copyOf(this.mListDimensionBehaviors, 2);
        object2 = this.mParent;
        nArray = null;
        object2 = object2 == null ? null : (Object)hashMap.get(((ConstraintWidget)object).mParent);
        this.mParent = object2;
        this.mWidth = ((ConstraintWidget)object).mWidth;
        this.mHeight = ((ConstraintWidget)object).mHeight;
        this.mDimensionRatio = ((ConstraintWidget)object).mDimensionRatio;
        this.mDimensionRatioSide = ((ConstraintWidget)object).mDimensionRatioSide;
        this.mX = ((ConstraintWidget)object).mX;
        this.mY = ((ConstraintWidget)object).mY;
        this.mRelX = ((ConstraintWidget)object).mRelX;
        this.mRelY = ((ConstraintWidget)object).mRelY;
        this.mOffsetX = ((ConstraintWidget)object).mOffsetX;
        this.mOffsetY = ((ConstraintWidget)object).mOffsetY;
        this.mBaselineDistance = ((ConstraintWidget)object).mBaselineDistance;
        this.mMinWidth = ((ConstraintWidget)object).mMinWidth;
        this.mMinHeight = ((ConstraintWidget)object).mMinHeight;
        this.mHorizontalBiasPercent = ((ConstraintWidget)object).mHorizontalBiasPercent;
        this.mVerticalBiasPercent = ((ConstraintWidget)object).mVerticalBiasPercent;
        this.mCompanionWidget = ((ConstraintWidget)object).mCompanionWidget;
        this.mContainerItemSkip = ((ConstraintWidget)object).mContainerItemSkip;
        this.mVisibility = ((ConstraintWidget)object).mVisibility;
        this.mDebugName = ((ConstraintWidget)object).mDebugName;
        this.mType = ((ConstraintWidget)object).mType;
        this.mDistToTop = ((ConstraintWidget)object).mDistToTop;
        this.mDistToLeft = ((ConstraintWidget)object).mDistToLeft;
        this.mDistToRight = ((ConstraintWidget)object).mDistToRight;
        this.mDistToBottom = ((ConstraintWidget)object).mDistToBottom;
        this.mLeftHasCentered = ((ConstraintWidget)object).mLeftHasCentered;
        this.mRightHasCentered = ((ConstraintWidget)object).mRightHasCentered;
        this.mTopHasCentered = ((ConstraintWidget)object).mTopHasCentered;
        this.mBottomHasCentered = ((ConstraintWidget)object).mBottomHasCentered;
        this.mHorizontalWrapVisited = ((ConstraintWidget)object).mHorizontalWrapVisited;
        this.mVerticalWrapVisited = ((ConstraintWidget)object).mVerticalWrapVisited;
        this.mHorizontalChainStyle = ((ConstraintWidget)object).mHorizontalChainStyle;
        this.mVerticalChainStyle = ((ConstraintWidget)object).mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = ((ConstraintWidget)object).mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = ((ConstraintWidget)object).mVerticalChainFixedPosition;
        object2 = this.mWeight;
        Object[] objectArray = ((ConstraintWidget)object).mWeight;
        object2[0] = (int)objectArray[0];
        object2[1] = (int)objectArray[1];
        object2 = this.mListNextMatchConstraintsWidget;
        objectArray = ((ConstraintWidget)object).mListNextMatchConstraintsWidget;
        object2[0] = (int)objectArray[0];
        object2[1] = (int)objectArray[1];
        object2 = this.mNextChainWidget;
        objectArray = ((ConstraintWidget)object).mNextChainWidget;
        object2[0] = (int)objectArray[0];
        object2[1] = (int)objectArray[1];
        object2 = ((ConstraintWidget)object).mHorizontalNextWidget;
        object2 = object2 == null ? null : (Object)hashMap.get(object2);
        this.mHorizontalNextWidget = object2;
        object = ((ConstraintWidget)object).mVerticalNextWidget;
        object = object == null ? (Object)nArray : hashMap.get(object);
        this.mVerticalNextWidget = object;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable((Object)this.mLeft);
        linearSystem.createObjectVariable((Object)this.mTop);
        linearSystem.createObjectVariable((Object)this.mRight);
        linearSystem.createObjectVariable((Object)this.mBottom);
        if (this.mBaselineDistance <= 0) return;
        linearSystem.createObjectVariable((Object)this.mBaseline);
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun != null) return;
        this.verticalRun = new VerticalWidgetRun(this);
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            default: {
                throw new AssertionError((Object)type.name());
            }
            case 9: {
                return null;
            }
            case 8: {
                return this.mCenterY;
            }
            case 7: {
                return this.mCenterX;
            }
            case 6: {
                return this.mCenter;
            }
            case 5: {
                return this.mBaseline;
            }
            case 4: {
                return this.mBottom;
            }
            case 3: {
                return this.mRight;
            }
            case 2: {
                return this.mTop;
            }
            case 1: 
        }
        return this.mLeft;
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int n) {
        if (n == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (n != 1) return -1.0f;
        return this.mVerticalBiasPercent;
    }

    public int getBottom() {
        return this.getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int n) {
        if (n == 0) {
            return this.getHorizontalDimensionBehaviour();
        }
        if (n != 1) return null;
        return this.getVerticalDimensionBehaviour();
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility != 8) return this.mHeight;
        return 0;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        boolean bl = this.isInHorizontalChain();
        Object object = null;
        if (!bl) return object;
        object = this;
        Object object2 = null;
        while (object2 == null && object != null) {
            Object object3 = ((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.LEFT);
            object3 = object3 == null ? null : object3.getTarget();
            if ((object3 = object3 == null ? null : object3.getOwner()) == this.getParent()) return object;
            ConstraintAnchor constraintAnchor = object3 == null ? null : ((ConstraintWidget)object3).getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (constraintAnchor != null && constraintAnchor.getOwner() != object) {
                object2 = object;
                continue;
            }
            object = object3;
        }
        object = object2;
        return object;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int n = 0;
        if (constraintAnchor != null) {
            n = 0 + constraintAnchor.mMargin;
        }
        constraintAnchor = this.mRight;
        int n2 = n;
        if (constraintAnchor == null) return n2;
        n2 = n + constraintAnchor.mMargin;
        return n2;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return this.getX();
    }

    public int getLength(int n) {
        if (n == 0) {
            return this.getWidth();
        }
        if (n != 1) return 0;
        return this.getHeight();
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int n) {
        if (n == 0) {
            if (this.mRight.mTarget == null) return null;
            ConstraintAnchor constraintAnchor = this.mRight.mTarget.mTarget;
            ConstraintAnchor constraintAnchor2 = this.mRight;
            if (constraintAnchor != constraintAnchor2) return null;
            return constraintAnchor2.mTarget.mOwner;
        }
        if (n != 1) return null;
        if (this.mBottom.mTarget == null) return null;
        ConstraintAnchor constraintAnchor = this.mBottom.mTarget.mTarget;
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        if (constraintAnchor != constraintAnchor3) return null;
        return constraintAnchor3.mTarget.mOwner;
    }

    public int getOptimizerWrapHeight() {
        int n;
        int n2 = n = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) return n2;
        if (this.mMatchConstraintDefaultHeight == 1) {
            n = Math.max(this.mMatchConstraintMinHeight, n);
        } else {
            n = this.mMatchConstraintMinHeight;
            if (n > 0) {
                this.mHeight = n;
            } else {
                n = 0;
            }
        }
        int n3 = this.mMatchConstraintMaxHeight;
        n2 = n;
        if (n3 <= 0) return n2;
        n2 = n;
        if (n3 >= n) return n2;
        n2 = n3;
        return n2;
    }

    public int getOptimizerWrapWidth() {
        int n;
        int n2 = n = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) return n2;
        if (this.mMatchConstraintDefaultWidth == 1) {
            n = Math.max(this.mMatchConstraintMinWidth, n);
        } else {
            n = this.mMatchConstraintMinWidth;
            if (n > 0) {
                this.mWidth = n;
            } else {
                n = 0;
            }
        }
        int n3 = this.mMatchConstraintMaxWidth;
        n2 = n;
        if (n3 <= 0) return n2;
        n2 = n;
        if (n3 >= n) return n2;
        n2 = n3;
        return n2;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int n) {
        if (n == 0) {
            if (this.mLeft.mTarget == null) return null;
            ConstraintAnchor constraintAnchor = this.mLeft.mTarget.mTarget;
            ConstraintAnchor constraintAnchor2 = this.mLeft;
            if (constraintAnchor != constraintAnchor2) return null;
            return constraintAnchor2.mTarget.mOwner;
        }
        if (n != 1) return null;
        if (this.mTop.mTarget == null) return null;
        ConstraintAnchor constraintAnchor = this.mTop.mTarget.mTarget;
        ConstraintAnchor constraintAnchor3 = this.mTop;
        if (constraintAnchor != constraintAnchor3) return null;
        return constraintAnchor3.mTarget.mOwner;
    }

    int getRelativePositioning(int n) {
        if (n == 0) {
            return this.mRelX;
        }
        if (n != 1) return 0;
        return this.mRelY;
    }

    public int getRight() {
        return this.getX() + this.mWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int n) {
        if (n == 0) {
            return this.horizontalRun;
        }
        if (n != 1) return null;
        return this.verticalRun;
    }

    public int getTop() {
        return this.getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        boolean bl = this.isInVerticalChain();
        Object object = null;
        if (!bl) return object;
        object = this;
        Object object2 = null;
        while (object2 == null && object != null) {
            Object object3 = ((ConstraintWidget)object).getAnchor(ConstraintAnchor.Type.TOP);
            object3 = object3 == null ? null : object3.getTarget();
            if ((object3 = object3 == null ? null : object3.getOwner()) == this.getParent()) return object;
            ConstraintAnchor constraintAnchor = object3 == null ? null : ((ConstraintWidget)object3).getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (constraintAnchor != null && constraintAnchor.getOwner() != object) {
                object2 = object;
                continue;
            }
            object = object3;
        }
        object = object2;
        return object;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int n = 0;
        if (constraintAnchor != null) {
            n = 0 + this.mTop.mMargin;
        }
        int n2 = n;
        if (this.mRight == null) return n2;
        n2 = n + this.mBottom.mMargin;
        return n2;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility != 8) return this.mWidth;
        return 0;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null) return this.mX;
        if (!(constraintWidget instanceof ConstraintWidgetContainer)) return this.mX;
        return ((ConstraintWidgetContainer)constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null) return this.mY;
        if (!(constraintWidget instanceof ConstraintWidgetContainer)) return this.mY;
        return ((ConstraintWidgetContainer)constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int n) {
        int n2;
        int n3;
        boolean bl = true;
        boolean bl2 = true;
        if (n == 0) {
            n = this.mLeft.mTarget != null ? 1 : 0;
            int n4 = this.mRight.mTarget != null ? 1 : 0;
            bl = n + n4 < 2 ? bl2 : false;
            return bl;
        }
        n = this.mTop.mTarget != null ? 1 : 0;
        if (n + (n3 = this.mBottom.mTarget != null ? 1 : 0) + (n2 = this.mBaseline.mTarget != null ? 1 : 0) < 2) return bl;
        bl = false;
        return bl;
    }

    public boolean hasDependencies() {
        int n = this.mAnchors.size();
        int n2 = 0;
        while (n2 < n) {
            if (this.mAnchors.get(n2).hasDependents()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int n, int n2) {
        this.getAnchor(type).connect(constraintWidget.getAnchor(type2), n, n2, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        if (this.mLeft.mTarget != null) {
            if (this.mLeft.mTarget.mTarget == this.mLeft) return true;
        }
        if (this.mRight.mTarget == null) return false;
        if (this.mRight.mTarget.mTarget != this.mRight) return false;
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        if (this.mTop.mTarget != null) {
            if (this.mTop.mTarget.mTarget == this.mTop) return true;
        }
        if (this.mBottom.mTarget == null) return false;
        if (this.mBottom.mTarget.mTarget != this.mBottom) return false;
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isMeasureRequested() {
        boolean bl = this.mMeasureRequested && this.mVisibility != 8;
        return bl;
    }

    public boolean isResolvedHorizontally() {
        boolean bl = this.resolvedHorizontal || this.mLeft.hasFinalValue() && this.mRight.hasFinalValue();
        return bl;
    }

    public boolean isResolvedVertically() {
        boolean bl = this.resolvedVertical || this.mTop.hasFinalValue() && this.mBottom.hasFinalValue();
        return bl;
    }

    public boolean isRoot() {
        boolean bl = this.mParent == null;
        return bl;
    }

    public boolean isSpreadHeight() {
        int n = this.mMatchConstraintDefaultHeight;
        boolean bl = true;
        if (n == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) return bl;
        bl = false;
        return bl;
    }

    public boolean isSpreadWidth() {
        boolean bl;
        int n = this.mMatchConstraintDefaultWidth;
        boolean bl2 = bl = false;
        if (n != 0) return bl2;
        bl2 = bl;
        if (this.mDimensionRatio != 0.0f) return bl2;
        bl2 = bl;
        if (this.mMatchConstraintMinWidth != 0) return bl2;
        bl2 = bl;
        if (this.mMatchConstraintMaxWidth != 0) return bl2;
        bl2 = bl;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) return bl2;
        bl2 = true;
        return bl2;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public boolean oppositeDimensionDependsOn(int n) {
        boolean bl = true;
        int n2 = n == 0 ? 1 : 0;
        DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviour[n];
        dimensionBehaviour = dimensionBehaviour[n2];
        if (dimensionBehaviour2 == DimensionBehaviour.MATCH_CONSTRAINT && dimensionBehaviour == DimensionBehaviour.MATCH_CONSTRAINT) return bl;
        bl = false;
        return bl;
    }

    public boolean oppositeDimensionsTied() {
        boolean bl;
        DimensionBehaviour[] dimensionBehaviourArray = this.mListDimensionBehaviors;
        boolean bl2 = bl = false;
        if (dimensionBehaviourArray[0] != DimensionBehaviour.MATCH_CONSTRAINT) return bl2;
        bl2 = bl;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) return bl2;
        bl2 = true;
        return bl2;
    }

    public void reset() {
        float f;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = f = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f;
        this.mListDimensionBehaviors[0] = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors[1] = DimensionBehaviour.FIXED;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        Object[] objectArray = this.mWeight;
        objectArray[0] = -1.0f;
        objectArray[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        objectArray = this.mMaxDimension;
        objectArray[0] = Integer.MAX_VALUE;
        objectArray[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        objectArray = this.isTerminalWidget;
        objectArray[0] = 1.0f;
        objectArray[1] = 1.0f;
        this.mInVirtuaLayout = false;
        objectArray = this.mIsInBarrier;
        objectArray[0] = 0.0f;
        objectArray[1] = 0.0f;
        this.mMeasureRequested = true;
    }

    public void resetAllConstraints() {
        this.resetAnchors();
        this.setVerticalBiasPercent(DEFAULT_BIAS);
        this.setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (this.getParent() != null && this.getParent() instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)this.getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = this.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchor3 = this.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor constraintAnchor4 = this.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor constraintAnchor5 = this.getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor constraintAnchor6 = this.getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor constraintAnchor7 = this.getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor constraintAnchor8 = this.getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == constraintAnchor6) {
            if (constraintAnchor2.isConnected() && constraintAnchor3.isConnected() && constraintAnchor2.getTarget() == constraintAnchor3.getTarget()) {
                constraintAnchor2.reset();
                constraintAnchor3.reset();
            }
            if (constraintAnchor4.isConnected() && constraintAnchor5.isConnected() && constraintAnchor4.getTarget() == constraintAnchor5.getTarget()) {
                constraintAnchor4.reset();
                constraintAnchor5.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == constraintAnchor7) {
            if (constraintAnchor2.isConnected() && constraintAnchor3.isConnected() && constraintAnchor2.getTarget().getOwner() == constraintAnchor3.getTarget().getOwner()) {
                constraintAnchor2.reset();
                constraintAnchor3.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == constraintAnchor8) {
            if (constraintAnchor4.isConnected() && constraintAnchor5.isConnected() && constraintAnchor4.getTarget().getOwner() == constraintAnchor5.getTarget().getOwner()) {
                constraintAnchor4.reset();
                constraintAnchor5.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor != constraintAnchor2 && constraintAnchor != constraintAnchor3) {
            if ((constraintAnchor == constraintAnchor4 || constraintAnchor == constraintAnchor5) && constraintAnchor4.isConnected() && constraintAnchor4.getTarget() == constraintAnchor5.getTarget()) {
                constraintAnchor6.reset();
            }
        } else if (constraintAnchor2.isConnected() && constraintAnchor2.getTarget() == constraintAnchor3.getTarget()) {
            constraintAnchor6.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget constraintWidget = this.getParent();
        if (constraintWidget != null && constraintWidget instanceof ConstraintWidgetContainer && ((ConstraintWidgetContainer)this.getParent()).handlesInternalConstraints()) {
            return;
        }
        int n = 0;
        int n2 = this.mAnchors.size();
        while (n < n2) {
            this.mAnchors.get(n).reset();
            ++n;
        }
    }

    public void resetFinalResolution() {
        int n = 0;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int n2 = this.mAnchors.size();
        while (n < n2) {
            this.mAnchors.get(n).resetFinalResolution();
            ++n;
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int n) {
        this.mBaselineDistance = n;
        boolean bl = n > 0;
        this.hasBaseline = bl;
    }

    public void setCompanionWidget(Object object) {
        this.mCompanionWidget = object;
    }

    public void setContainerItemSkip(int n) {
        this.mContainerItemSkip = n >= 0 ? n : 0;
    }

    public void setDebugName(String string) {
        this.mDebugName = string;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String string) {
        this.mDebugName = string;
        SolverVariable solverVariable = linearSystem.createObjectVariable((Object)this.mLeft);
        Object object = linearSystem.createObjectVariable((Object)this.mTop);
        Object object2 = linearSystem.createObjectVariable((Object)this.mRight);
        Object object3 = linearSystem.createObjectVariable((Object)this.mBottom);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(".left");
        solverVariable.setName(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(".top");
        object.setName(stringBuilder.toString());
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(".right");
        object2.setName(((StringBuilder)object).toString());
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string);
        ((StringBuilder)object2).append(".bottom");
        object3.setName(((StringBuilder)object2).toString());
        linearSystem = linearSystem.createObjectVariable((Object)this.mBaseline);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append(string);
        ((StringBuilder)object3).append(".baseline");
        linearSystem.setName(((StringBuilder)object3).toString());
    }

    public void setDimension(int n, int n2) {
        this.mWidth = n;
        int n3 = this.mMinWidth;
        if (n < n3) {
            this.mWidth = n3;
        }
        this.mHeight = n2;
        n = this.mMinHeight;
        if (n2 >= n) return;
        this.mHeight = n;
    }

    public void setDimensionRatio(float f, int n) {
        this.mDimensionRatio = f;
        this.mDimensionRatioSide = n;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public void setDimensionRatio(String var1_1) {
        block14: {
            block15: {
                block13: {
                    if (var1_1 == null || var1_1.length() == 0) break block14;
                    var6_3 = -1;
                    var8_4 = var1_1.length();
                    var9_5 = var1_1.indexOf(44);
                    var7_6 = 0;
                    var4_7 = var6_3;
                    var5_8 = var7_6;
                    if (var9_5 > 0) {
                        var4_7 = var6_3;
                        var5_8 = var7_6;
                        if (var9_5 < var8_4 - 1) {
                            var10_9 = var1_1.substring(0, var9_5);
                            if (var10_9.equalsIgnoreCase("W")) {
                                var4_7 = 0;
                            } else {
                                var4_7 = var6_3;
                                if (var10_9.equalsIgnoreCase("H")) {
                                    var4_7 = 1;
                                }
                            }
                            var5_8 = var9_5 + 1;
                        }
                    }
                    if ((var6_3 = var1_1.indexOf(58)) < 0 || var6_3 >= var8_4 - 1) break block15;
                    var10_9 = var1_1.substring(var5_8, var6_3);
                    var1_1 = var1_1.substring(var6_3 + 1);
                    if (var10_9.length() > 0 && var1_1.length() > 0) {
                        var3_10 = Float.parseFloat(var10_9);
                        var2_11 = Float.parseFloat(var1_1);
                        if (var3_10 > 0.0f && var2_11 > 0.0f) break block13;
                    }
lbl28:
                    // 5 sources

                    while (true) {
                        var2_11 = 0.0f;
lbl30:
                        // 4 sources

                        while (true) {
                            if (!(var2_11 > 0.0f)) return;
                            this.mDimensionRatio = var2_11;
                            this.mDimensionRatioSide = var4_7;
                            return;
                        }
                        break;
                    }
                    catch (NumberFormatException var1_2) {
                        ** GOTO lbl28
                    }
                }
                if (var4_7 != 1) ** GOTO lbl41
                {
                    var2_11 = Math.abs(var2_11 / var3_10);
                    ** GOTO lbl30
lbl41:
                    // 1 sources

                    var2_11 = Math.abs(var3_10 / var2_11);
                    ** GOTO lbl30
                }
            }
            if ((var1_1 = var1_1.substring(var5_8)).length() > 0) ** break;
            ** while (true)
            {
                var2_11 = Float.parseFloat(var1_1);
                ** continue;
            }
        }
        this.mDimensionRatio = 0.0f;
    }

    public void setFinalBaseline(int n) {
        if (!this.hasBaseline) {
            return;
        }
        int n2 = n - this.mBaselineDistance;
        int n3 = this.mHeight;
        this.mY = n2;
        this.mTop.setFinalValue(n2);
        this.mBottom.setFinalValue(n3 + n2);
        this.mBaseline.setFinalValue(n);
        this.resolvedVertical = true;
    }

    public void setFinalFrame(int n, int n2, int n3, int n4, int n5, int n6) {
        this.setFrame(n, n2, n3, n4);
        this.setBaselineDistance(n5);
        if (n6 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (n6 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (n6 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int n, int n2) {
        this.mLeft.setFinalValue(n);
        this.mRight.setFinalValue(n2);
        this.mX = n;
        this.mWidth = n2 - n;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int n) {
        this.mLeft.setFinalValue(n);
        this.mX = n;
    }

    public void setFinalTop(int n) {
        this.mTop.setFinalValue(n);
        this.mY = n;
    }

    public void setFinalVertical(int n, int n2) {
        this.mTop.setFinalValue(n);
        this.mBottom.setFinalValue(n2);
        this.mY = n;
        this.mHeight = n2 - n;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(n + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setFrame(int n, int n2, int n3) {
        if (n3 == 0) {
            this.setHorizontalDimension(n, n2);
        } else {
            if (n3 != 1) return;
            this.setVerticalDimension(n, n2);
        }
    }

    public void setFrame(int n, int n2, int n3, int n4) {
        int n5 = n3 - n;
        n3 = n4 - n2;
        this.mX = n;
        this.mY = n2;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        n = n5;
        if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
            n2 = this.mWidth;
            n = n5;
            if (n5 < n2) {
                n = n2;
            }
        }
        n2 = n3;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
            n4 = this.mHeight;
            n2 = n3;
            if (n3 < n4) {
                n2 = n4;
            }
        }
        this.mWidth = n;
        this.mHeight = n2;
        n = this.mMinHeight;
        if (n2 < n) {
            this.mHeight = n;
        }
        if ((n = this.mWidth) >= (n2 = this.mMinWidth)) return;
        this.mWidth = n2;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int n) {
        int n2 = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) return;
                    this.mBottom.mGoneMargin = n;
                } else {
                    this.mRight.mGoneMargin = n;
                }
            } else {
                this.mTop.mGoneMargin = n;
            }
        } else {
            this.mLeft.mGoneMargin = n;
        }
    }

    public void setHasBaseline(boolean bl) {
        this.hasBaseline = bl;
    }

    public void setHeight(int n) {
        this.mHeight = n;
        int n2 = this.mMinHeight;
        if (n >= n2) return;
        this.mHeight = n2;
    }

    public void setHeightWrapContent(boolean bl) {
        this.mIsHeightWrapContent = bl;
    }

    public void setHorizontalBiasPercent(float f) {
        this.mHorizontalBiasPercent = f;
    }

    public void setHorizontalChainStyle(int n) {
        this.mHorizontalChainStyle = n;
    }

    public void setHorizontalDimension(int n, int n2) {
        this.mX = n;
        this.mWidth = n2 -= n;
        n = this.mMinWidth;
        if (n2 >= n) return;
        this.mWidth = n;
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int n, int n2, int n3, float f) {
        this.mMatchConstraintDefaultWidth = n;
        this.mMatchConstraintMinWidth = n2;
        n = n3;
        if (n3 == Integer.MAX_VALUE) {
            n = 0;
        }
        this.mMatchConstraintMaxWidth = n;
        this.mMatchConstraintPercentWidth = f;
        if (!(f > 0.0f)) return;
        if (!(f < 1.0f)) return;
        if (this.mMatchConstraintDefaultWidth != 0) return;
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f) {
        this.mWeight[0] = f;
    }

    protected void setInBarrier(int n, boolean bl) {
        this.mIsInBarrier[n] = bl;
    }

    public void setInPlaceholder(boolean bl) {
        this.inPlaceholder = bl;
    }

    public void setInVirtualLayout(boolean bl) {
        this.mInVirtuaLayout = bl;
    }

    public void setLastMeasureSpec(int n, int n2) {
        this.mLastHorizontalMeasureSpec = n;
        this.mLastVerticalMeasureSpec = n2;
        this.setMeasureRequested(false);
    }

    public void setLength(int n, int n2) {
        if (n2 == 0) {
            this.setWidth(n);
        } else {
            if (n2 != 1) return;
            this.setHeight(n);
        }
    }

    public void setMaxHeight(int n) {
        this.mMaxDimension[1] = n;
    }

    public void setMaxWidth(int n) {
        this.mMaxDimension[0] = n;
    }

    public void setMeasureRequested(boolean bl) {
        this.mMeasureRequested = bl;
    }

    public void setMinHeight(int n) {
        this.mMinHeight = n < 0 ? 0 : n;
    }

    public void setMinWidth(int n) {
        this.mMinWidth = n < 0 ? 0 : n;
    }

    public void setOffset(int n, int n2) {
        this.mOffsetX = n;
        this.mOffsetY = n2;
    }

    public void setOrigin(int n, int n2) {
        this.mX = n;
        this.mY = n2;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    void setRelativePositioning(int n, int n2) {
        if (n2 == 0) {
            this.mRelX = n;
        } else {
            if (n2 != 1) return;
            this.mRelY = n;
        }
    }

    public void setType(String string) {
        this.mType = string;
    }

    public void setVerticalBiasPercent(float f) {
        this.mVerticalBiasPercent = f;
    }

    public void setVerticalChainStyle(int n) {
        this.mVerticalChainStyle = n;
    }

    public void setVerticalDimension(int n, int n2) {
        this.mY = n;
        this.mHeight = n2 -= n;
        n = this.mMinHeight;
        if (n2 >= n) return;
        this.mHeight = n;
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int n, int n2, int n3, float f) {
        this.mMatchConstraintDefaultHeight = n;
        this.mMatchConstraintMinHeight = n2;
        n = n3;
        if (n3 == Integer.MAX_VALUE) {
            n = 0;
        }
        this.mMatchConstraintMaxHeight = n;
        this.mMatchConstraintPercentHeight = f;
        if (!(f > 0.0f)) return;
        if (!(f < 1.0f)) return;
        if (this.mMatchConstraintDefaultHeight != 0) return;
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f) {
        this.mWeight[1] = f;
    }

    public void setVisibility(int n) {
        this.mVisibility = n;
    }

    public void setWidth(int n) {
        this.mWidth = n;
        int n2 = this.mMinWidth;
        if (n >= n2) return;
        this.mWidth = n2;
    }

    public void setWidthWrapContent(boolean bl) {
        this.mIsWidthWrapContent = bl;
    }

    public void setX(int n) {
        this.mX = n;
    }

    public void setY(int n) {
        this.mY = n;
    }

    public void setupDimensionRatio(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (bl3 && !bl4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!bl3 && bl4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (!(this.mResolvedDimensionRatioSide != 0 || this.mTop.isConnected() && this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (!(this.mResolvedDimensionRatioSide != 1 || this.mLeft.isConnected() && this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (!(this.mResolvedDimensionRatioSide != -1 || this.mTop.isConnected() && this.mBottom.isConnected() && this.mLeft.isConnected() && this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide != -1) return;
        if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
            this.mResolvedDimensionRatioSide = 0;
        } else {
            if (this.mMatchConstraintMinWidth != 0) return;
            if (this.mMatchConstraintMinHeight <= 0) return;
            this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
            this.mResolvedDimensionRatioSide = 1;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = this.mType;
        String string = "";
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("type: ");
            ((StringBuilder)charSequence).append(this.mType);
            ((StringBuilder)charSequence).append(" ");
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        stringBuilder.append((String)charSequence);
        charSequence = string;
        if (this.mDebugName != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("id: ");
            ((StringBuilder)charSequence).append(this.mDebugName);
            ((StringBuilder)charSequence).append(" ");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append((String)charSequence);
        stringBuilder.append("(");
        stringBuilder.append(this.mX);
        stringBuilder.append(", ");
        stringBuilder.append(this.mY);
        stringBuilder.append(") - (");
        stringBuilder.append(this.mWidth);
        stringBuilder.append(" x ");
        stringBuilder.append(this.mHeight);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void updateFromRuns(boolean bl, boolean bl2) {
        int n;
        int n2;
        int n3;
        int n4;
        boolean bl3;
        boolean bl4;
        block13: {
            block12: {
                bl4 = bl & this.horizontalRun.isResolved();
                bl3 = bl2 & this.verticalRun.isResolved();
                n4 = this.horizontalRun.start.value;
                n3 = this.verticalRun.start.value;
                n2 = this.horizontalRun.end.value;
                int n5 = this.verticalRun.end.value;
                if (n2 - n4 < 0 || n5 - n3 < 0 || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE) break block12;
                n = n5;
                if (n5 != Integer.MAX_VALUE) break block13;
            }
            n4 = 0;
            n3 = 0;
            n2 = 0;
            n = 0;
        }
        n2 -= n4;
        n -= n3;
        if (bl4) {
            this.mX = n4;
        }
        if (bl3) {
            this.mY = n3;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (bl4) {
            n3 = n2;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED) {
                n4 = this.mWidth;
                n3 = n2;
                if (n2 < n4) {
                    n3 = n4;
                }
            }
            this.mWidth = n3;
            n4 = this.mMinWidth;
            if (n3 < n4) {
                this.mWidth = n4;
            }
        }
        if (!bl3) return;
        n3 = n;
        if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED) {
            n4 = this.mHeight;
            n3 = n;
            if (n < n4) {
                n3 = n4;
            }
        }
        this.mHeight = n3;
        n4 = this.mMinHeight;
        if (n3 >= n4) return;
        this.mHeight = n4;
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean bl) {
        int n;
        int n2;
        int n3;
        int n4;
        block12: {
            block11: {
                n4 = linearSystem.getObjectVariableValue((Object)this.mLeft);
                n3 = linearSystem.getObjectVariableValue((Object)this.mTop);
                int n5 = linearSystem.getObjectVariableValue((Object)this.mRight);
                int n6 = linearSystem.getObjectVariableValue((Object)this.mBottom);
                n2 = n4;
                n = n5;
                if (bl) {
                    linearSystem = this.horizontalRun;
                    n2 = n4;
                    n = n5;
                    if (linearSystem != null) {
                        n2 = n4;
                        n = n5;
                        if (linearSystem.start.resolved) {
                            n2 = n4;
                            n = n5;
                            if (this.horizontalRun.end.resolved) {
                                n2 = this.horizontalRun.start.value;
                                n = this.horizontalRun.end.value;
                            }
                        }
                    }
                }
                n4 = n3;
                n5 = n6;
                if (bl) {
                    linearSystem = this.verticalRun;
                    n4 = n3;
                    n5 = n6;
                    if (linearSystem != null) {
                        n4 = n3;
                        n5 = n6;
                        if (linearSystem.start.resolved) {
                            n4 = n3;
                            n5 = n6;
                            if (this.verticalRun.end.resolved) {
                                n4 = this.verticalRun.start.value;
                                n5 = this.verticalRun.end.value;
                            }
                        }
                    }
                }
                if (n - n2 < 0 || n5 - n4 < 0 || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n == Integer.MIN_VALUE || n == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE) break block11;
                n3 = n2;
                n2 = n;
                n = n5;
                if (n5 != Integer.MAX_VALUE) break block12;
            }
            n = 0;
            n3 = 0;
            n4 = 0;
            n2 = 0;
        }
        this.setFrame(n3, n4, n2, n);
    }
}
