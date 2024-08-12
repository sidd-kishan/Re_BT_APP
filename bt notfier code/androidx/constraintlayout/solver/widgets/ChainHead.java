/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ChainHead {
    private boolean mDefined;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    private boolean mIsRtl = false;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight = 0.0f;
    int mVisibleWidgets;
    protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget constraintWidget, int n, boolean bl) {
        this.mFirst = constraintWidget;
        this.mOrientation = n;
        this.mIsRtl = bl;
    }

    private void defineChainProperties() {
        int n = this.mOrientation * 2;
        ConstraintWidget constraintWidget = this.mFirst;
        boolean bl = true;
        this.mOptimizable = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean bl2 = false;
        while (!bl2) {
            ++this.mWidgetsCount;
            ConstraintWidget constraintWidget3 = constraintWidget.mNextChainWidget;
            int n2 = this.mOrientation;
            ConstraintWidget constraintWidget4 = null;
            constraintWidget3[n2] = null;
            constraintWidget.mListNextMatchConstraintsWidget[this.mOrientation] = null;
            if (constraintWidget.getVisibility() != 8) {
                int n3;
                ++this.mVisibleWidgets;
                if (constraintWidget.getDimensionBehaviour(this.mOrientation) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mTotalSize += constraintWidget.getLength(this.mOrientation);
                }
                this.mTotalSize = n3 = this.mTotalSize + constraintWidget.mListAnchors[n].getMargin();
                constraintWidget3 = constraintWidget.mListAnchors;
                n2 = n + 1;
                this.mTotalSize = n3 + constraintWidget3[n2].getMargin();
                this.mTotalMargins = n3 = this.mTotalMargins + constraintWidget.mListAnchors[n].getMargin();
                this.mTotalMargins = n3 + constraintWidget.mListAnchors[n2].getMargin();
                if (this.mFirstVisibleWidget == null) {
                    this.mFirstVisibleWidget = constraintWidget;
                }
                this.mLastVisibleWidget = constraintWidget;
                if (constraintWidget.mListDimensionBehaviors[this.mOrientation] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget.mResolvedMatchConstraintDefault[this.mOrientation] == 0 || constraintWidget.mResolvedMatchConstraintDefault[this.mOrientation] == 3 || constraintWidget.mResolvedMatchConstraintDefault[this.mOrientation] == 2) {
                        ++this.mWidgetsMatchCount;
                        float f = constraintWidget.mWeight[this.mOrientation];
                        if (f > 0.0f) {
                            this.mTotalWeight += constraintWidget.mWeight[this.mOrientation];
                        }
                        if (ChainHead.isMatchConstraintEqualityCandidate(constraintWidget, this.mOrientation)) {
                            if (f < 0.0f) {
                                this.mHasUndefinedWeights = true;
                            } else {
                                this.mHasDefinedWeights = true;
                            }
                            if (this.mWeightedMatchConstraintsWidgets == null) {
                                this.mWeightedMatchConstraintsWidgets = new ArrayList();
                            }
                            this.mWeightedMatchConstraintsWidgets.add(constraintWidget);
                        }
                        if (this.mFirstMatchConstraintWidget == null) {
                            this.mFirstMatchConstraintWidget = constraintWidget;
                        }
                        if ((constraintWidget3 = this.mLastMatchConstraintWidget) != null) {
                            constraintWidget3.mListNextMatchConstraintsWidget[this.mOrientation] = constraintWidget;
                        }
                        this.mLastMatchConstraintWidget = constraintWidget;
                    }
                    if (this.mOrientation == 0) {
                        if (constraintWidget.mMatchConstraintDefaultWidth != 0) {
                            this.mOptimizable = false;
                        } else if (constraintWidget.mMatchConstraintMinWidth != 0 || constraintWidget.mMatchConstraintMaxWidth != 0) {
                            this.mOptimizable = false;
                        }
                    } else if (constraintWidget.mMatchConstraintDefaultHeight != 0) {
                        this.mOptimizable = false;
                    } else if (constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
                        this.mOptimizable = false;
                    }
                    if (constraintWidget.mDimensionRatio != 0.0f) {
                        this.mOptimizable = false;
                        this.mHasRatio = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.mNextChainWidget[this.mOrientation] = constraintWidget;
            }
            constraintWidget3 = constraintWidget.mListAnchors[n + 1].mTarget;
            constraintWidget2 = constraintWidget4;
            if (constraintWidget3 != null) {
                constraintWidget3 = constraintWidget3.mOwner;
                constraintWidget2 = constraintWidget4;
                if (constraintWidget3.mListAnchors[n].mTarget != null) {
                    constraintWidget2 = constraintWidget3.mListAnchors[n].mTarget.mOwner != constraintWidget ? constraintWidget4 : constraintWidget3;
                }
            }
            if (constraintWidget2 == null) {
                constraintWidget2 = constraintWidget;
                bl2 = true;
            }
            constraintWidget4 = constraintWidget;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget4;
        }
        constraintWidget2 = this.mFirstVisibleWidget;
        if (constraintWidget2 != null) {
            this.mTotalSize -= constraintWidget2.mListAnchors[n].getMargin();
        }
        if ((constraintWidget2 = this.mLastVisibleWidget) != null) {
            this.mTotalSize -= constraintWidget2.mListAnchors[n + 1].getMargin();
        }
        this.mLast = constraintWidget;
        this.mHead = this.mOrientation == 0 && this.mIsRtl ? constraintWidget : this.mFirst;
        if (!this.mHasDefinedWeights || !this.mHasUndefinedWeights) {
            bl = false;
        }
        this.mHasComplexMatchWeights = bl;
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget constraintWidget, int n) {
        boolean bl = constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[n] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && (constraintWidget.mResolvedMatchConstraintDefault[n] == 0 || constraintWidget.mResolvedMatchConstraintDefault[n] == 3);
        return bl;
    }

    public void define() {
        if (!this.mDefined) {
            this.defineChainProperties();
        }
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}
