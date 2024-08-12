/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.Flow
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Flow;

/*
 * Exception performing whole class analysis ignored.
 */
private class Flow.WidgetsList {
    private ConstraintWidget biggest;
    int biggestDimension;
    private ConstraintAnchor mBottom;
    private int mCount;
    private int mHeight;
    private ConstraintAnchor mLeft;
    private int mMax;
    private int mNbMatchConstraintsWidgets;
    private int mOrientation;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ConstraintAnchor mRight;
    private int mStartIndex;
    private ConstraintAnchor mTop;
    private int mWidth;
    final Flow this$0;

    public Flow.WidgetsList(Flow flow, int n, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int n2) {
        this.this$0 = flow;
        this.mOrientation = 0;
        this.biggest = null;
        this.biggestDimension = 0;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mStartIndex = 0;
        this.mCount = 0;
        this.mNbMatchConstraintsWidgets = 0;
        this.mMax = 0;
        this.mOrientation = n;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = flow.getPaddingLeft();
        this.mPaddingTop = flow.getPaddingTop();
        this.mPaddingRight = flow.getPaddingRight();
        this.mPaddingBottom = flow.getPaddingBottom();
        this.mMax = n2;
    }

    static /* synthetic */ ConstraintWidget access$2000(Flow.WidgetsList widgetsList) {
        return widgetsList.biggest;
    }

    private void recomputeDimensions() {
        this.mWidth = 0;
        this.mHeight = 0;
        this.biggest = null;
        this.biggestDimension = 0;
        int n = this.mCount;
        int n2 = 0;
        while (n2 < n) {
            int n3;
            int n4;
            if (this.mStartIndex + n2 >= Flow.access$400((Flow)this.this$0)) {
                return;
            }
            ConstraintWidget constraintWidget = Flow.access$500((Flow)this.this$0)[this.mStartIndex + n2];
            if (this.mOrientation == 0) {
                n4 = constraintWidget.getWidth();
                n3 = Flow.access$000((Flow)this.this$0);
                if (constraintWidget.getVisibility() == 8) {
                    n3 = 0;
                }
                this.mWidth += n4 + n3;
                n3 = Flow.access$300((Flow)this.this$0, (ConstraintWidget)constraintWidget, (int)this.mMax);
                if (this.biggest == null || this.biggestDimension < n3) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = n3;
                    this.mHeight = n3;
                }
            } else {
                int n5 = Flow.access$200((Flow)this.this$0, (ConstraintWidget)constraintWidget, (int)this.mMax);
                n4 = Flow.access$300((Flow)this.this$0, (ConstraintWidget)constraintWidget, (int)this.mMax);
                n3 = Flow.access$100((Flow)this.this$0);
                if (constraintWidget.getVisibility() == 8) {
                    n3 = 0;
                }
                this.mHeight += n4 + n3;
                if (this.biggest == null || this.biggestDimension < n5) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = n5;
                    this.mWidth = n5;
                }
            }
            ++n2;
        }
    }

    public void add(ConstraintWidget constraintWidget) {
        int n = this.mOrientation;
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            n = Flow.access$200((Flow)this.this$0, (ConstraintWidget)constraintWidget, (int)this.mMax);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ++this.mNbMatchConstraintsWidgets;
                n = 0;
            }
            n2 = Flow.access$000((Flow)this.this$0);
            if (constraintWidget.getVisibility() == 8) {
                n2 = n3;
            }
            this.mWidth += n + n2;
            n = Flow.access$300((Flow)this.this$0, (ConstraintWidget)constraintWidget, (int)this.mMax);
            if (this.biggest == null || this.biggestDimension < n) {
                this.biggest = constraintWidget;
                this.biggestDimension = n;
                this.mHeight = n;
            }
        } else {
            int n4 = Flow.access$200((Flow)this.this$0, (ConstraintWidget)constraintWidget, (int)this.mMax);
            n = Flow.access$300((Flow)this.this$0, (ConstraintWidget)constraintWidget, (int)this.mMax);
            if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ++this.mNbMatchConstraintsWidgets;
                n = 0;
            }
            n3 = Flow.access$100((Flow)this.this$0);
            if (constraintWidget.getVisibility() != 8) {
                n2 = n3;
            }
            this.mHeight += n + n2;
            if (this.biggest == null || this.biggestDimension < n4) {
                this.biggest = constraintWidget;
                this.biggestDimension = n4;
                this.mWidth = n4;
            }
        }
        ++this.mCount;
    }

    public void clear() {
        this.biggestDimension = 0;
        this.biggest = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mStartIndex = 0;
        this.mCount = 0;
        this.mNbMatchConstraintsWidgets = 0;
    }

    public void createConstraints(boolean bl, int n, boolean bl2) {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        int n2;
        int n3;
        int n4;
        boolean bl3;
        ConstraintWidget constraintWidget3;
        int n5;
        int n6;
        block65: {
            ConstraintWidget constraintWidget4;
            block61: {
                block63: {
                    block64: {
                        block62: {
                            int n7;
                            n6 = this.mCount;
                            for (n5 = 0; n5 < n6 && this.mStartIndex + n5 < Flow.access$400((Flow)this.this$0); ++n5) {
                                constraintWidget3 = Flow.access$500((Flow)this.this$0)[this.mStartIndex + n5];
                                if (constraintWidget3 == null) continue;
                                constraintWidget3.resetAnchors();
                            }
                            if (n6 == 0) return;
                            if (this.biggest == null) return;
                            bl3 = bl2 && n == 0;
                            n4 = -1;
                            n3 = -1;
                            for (n5 = 0; n5 < n6 && this.mStartIndex + (n7 = bl ? n6 - 1 - n5 : n5) < Flow.access$400((Flow)this.this$0); ++n5) {
                                int n8 = n4;
                                n2 = n3;
                                if (Flow.access$500((Flow)this.this$0)[this.mStartIndex + n7].getVisibility() == 0) {
                                    n3 = n4;
                                    if (n4 == -1) {
                                        n3 = n5;
                                    }
                                    n2 = n5;
                                    n8 = n3;
                                }
                                n4 = n8;
                                n3 = n2;
                            }
                            constraintWidget3 = null;
                            constraintWidget2 = null;
                            if (this.mOrientation != 0) break block62;
                            constraintWidget4 = this.biggest;
                            constraintWidget4.setVerticalChainStyle(Flow.access$600((Flow)this.this$0));
                            n5 = n2 = this.mPaddingTop;
                            if (n > 0) {
                                n5 = n2 + Flow.access$100((Flow)this.this$0);
                            }
                            constraintWidget4.mTop.connect(this.mTop, n5);
                            if (bl2) {
                                constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
                            }
                            if (n > 0) {
                                this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                            }
                            if (Flow.access$700((Flow)this.this$0) != 3 || constraintWidget4.hasBaseline()) break block63;
                            break block64;
                        }
                        constraintWidget = this.biggest;
                        constraintWidget.setHorizontalChainStyle(Flow.access$800((Flow)this.this$0));
                        n5 = n2 = this.mPaddingLeft;
                        if (n > 0) {
                            n5 = n2 + Flow.access$000((Flow)this.this$0);
                        }
                        if (bl) {
                            constraintWidget.mRight.connect(this.mRight, n5);
                            if (bl2) {
                                constraintWidget.mLeft.connect(this.mLeft, this.mPaddingRight);
                            }
                            if (n > 0) {
                                this.mRight.mOwner.mLeft.connect(constraintWidget.mRight, 0);
                            }
                        } else {
                            constraintWidget.mLeft.connect(this.mLeft, n5);
                            if (bl2) {
                                constraintWidget.mRight.connect(this.mRight, this.mPaddingRight);
                            }
                            if (n > 0) {
                                this.mLeft.mOwner.mRight.connect(constraintWidget.mLeft, 0);
                            }
                        }
                        break block65;
                    }
                    for (n = 0; n < n6 && this.mStartIndex + (n5 = bl ? n6 - 1 - n : n) < Flow.access$400((Flow)this.this$0); ++n) {
                        constraintWidget3 = Flow.access$500((Flow)this.this$0)[this.mStartIndex + n5];
                        if (!constraintWidget3.hasBaseline()) {
                            continue;
                        }
                        break block61;
                    }
                }
                constraintWidget3 = constraintWidget4;
            }
            n = 0;
            while (n < n6) {
                n5 = bl ? n6 - 1 - n : n;
                if (this.mStartIndex + n5 >= Flow.access$400((Flow)this.this$0)) return;
                ConstraintWidget constraintWidget5 = Flow.access$500((Flow)this.this$0)[this.mStartIndex + n5];
                if (n == 0) {
                    constraintWidget5.connect(constraintWidget5.mLeft, this.mLeft, this.mPaddingLeft);
                }
                if (n5 == 0) {
                    float f;
                    n2 = Flow.access$800((Flow)this.this$0);
                    float f2 = Flow.access$900((Flow)this.this$0);
                    if (this.mStartIndex == 0 && Flow.access$1000((Flow)this.this$0) != -1) {
                        n5 = Flow.access$1000((Flow)this.this$0);
                        f = Flow.access$1100((Flow)this.this$0);
                    } else {
                        n5 = n2;
                        f = f2;
                        if (bl2) {
                            n5 = n2;
                            f = f2;
                            if (Flow.access$1200((Flow)this.this$0) != -1) {
                                n5 = Flow.access$1200((Flow)this.this$0);
                                f = Flow.access$1300((Flow)this.this$0);
                            }
                        }
                    }
                    constraintWidget5.setHorizontalChainStyle(n5);
                    constraintWidget5.setHorizontalBiasPercent(f);
                }
                if (n == n6 - 1) {
                    constraintWidget5.connect(constraintWidget5.mRight, this.mRight, this.mPaddingRight);
                }
                if (constraintWidget2 != null) {
                    constraintWidget5.mLeft.connect(constraintWidget2.mRight, Flow.access$000((Flow)this.this$0));
                    if (n == n4) {
                        constraintWidget5.mLeft.setGoneMargin(this.mPaddingLeft);
                    }
                    constraintWidget2.mRight.connect(constraintWidget5.mLeft, 0);
                    if (n == n3 + 1) {
                        constraintWidget2.mRight.setGoneMargin(this.mPaddingRight);
                    }
                }
                if (constraintWidget5 != constraintWidget4) {
                    if (Flow.access$700((Flow)this.this$0) == 3 && constraintWidget3.hasBaseline() && constraintWidget5 != constraintWidget3 && constraintWidget5.hasBaseline()) {
                        constraintWidget5.mBaseline.connect(constraintWidget3.mBaseline, 0);
                    } else {
                        n5 = Flow.access$700((Flow)this.this$0);
                        if (n5 != 0) {
                            if (n5 != 1) {
                                if (bl3) {
                                    constraintWidget5.mTop.connect(this.mTop, this.mPaddingTop);
                                    constraintWidget5.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                } else {
                                    constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                    constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                }
                            } else {
                                constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                            }
                        } else {
                            constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                        }
                    }
                }
                ++n;
                constraintWidget2 = constraintWidget5;
            }
            return;
        }
        n5 = 0;
        while (n5 < n6) {
            if (this.mStartIndex + n5 >= Flow.access$400((Flow)this.this$0)) return;
            constraintWidget2 = Flow.access$500((Flow)this.this$0)[this.mStartIndex + n5];
            if (n5 == 0) {
                float f;
                constraintWidget2.connect(constraintWidget2.mTop, this.mTop, this.mPaddingTop);
                n2 = Flow.access$600((Flow)this.this$0);
                float f3 = Flow.access$1400((Flow)this.this$0);
                if (this.mStartIndex == 0 && Flow.access$1500((Flow)this.this$0) != -1) {
                    n = Flow.access$1500((Flow)this.this$0);
                    f = Flow.access$1600((Flow)this.this$0);
                } else {
                    n = n2;
                    f = f3;
                    if (bl2) {
                        n = n2;
                        f = f3;
                        if (Flow.access$1700((Flow)this.this$0) != -1) {
                            n = Flow.access$1700((Flow)this.this$0);
                            f = Flow.access$1800((Flow)this.this$0);
                        }
                    }
                }
                constraintWidget2.setVerticalChainStyle(n);
                constraintWidget2.setVerticalBiasPercent(f);
            }
            if (n5 == n6 - 1) {
                constraintWidget2.connect(constraintWidget2.mBottom, this.mBottom, this.mPaddingBottom);
            }
            if (constraintWidget3 != null) {
                constraintWidget2.mTop.connect(constraintWidget3.mBottom, Flow.access$100((Flow)this.this$0));
                if (n5 == n4) {
                    constraintWidget2.mTop.setGoneMargin(this.mPaddingTop);
                }
                constraintWidget3.mBottom.connect(constraintWidget2.mTop, 0);
                if (n5 == n3 + 1) {
                    constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                }
            }
            if (constraintWidget2 != constraintWidget) {
                if (bl) {
                    n = Flow.access$1900((Flow)this.this$0);
                    if (n != 0) {
                        if (n != 1) {
                            if (n == 2) {
                                constraintWidget2.mLeft.connect(constraintWidget.mLeft, 0);
                                constraintWidget2.mRight.connect(constraintWidget.mRight, 0);
                            }
                        } else {
                            constraintWidget2.mLeft.connect(constraintWidget.mLeft, 0);
                        }
                    } else {
                        constraintWidget2.mRight.connect(constraintWidget.mRight, 0);
                    }
                } else {
                    n = Flow.access$1900((Flow)this.this$0);
                    if (n != 0) {
                        if (n != 1) {
                            if (n == 2) {
                                if (bl3) {
                                    constraintWidget2.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget2.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget2.mLeft.connect(constraintWidget.mLeft, 0);
                                    constraintWidget2.mRight.connect(constraintWidget.mRight, 0);
                                }
                            }
                        } else {
                            constraintWidget2.mRight.connect(constraintWidget.mRight, 0);
                        }
                    } else {
                        constraintWidget2.mLeft.connect(constraintWidget.mLeft, 0);
                    }
                }
            }
            ++n5;
            constraintWidget3 = constraintWidget2;
        }
    }

    public int getHeight() {
        if (this.mOrientation != 1) return this.mHeight;
        return this.mHeight - Flow.access$100((Flow)this.this$0);
    }

    public int getWidth() {
        if (this.mOrientation != 0) return this.mWidth;
        return this.mWidth - Flow.access$000((Flow)this.this$0);
    }

    public void measureMatchConstraints(int n) {
        int n2 = this.mNbMatchConstraintsWidgets;
        if (n2 == 0) {
            return;
        }
        int n3 = this.mCount;
        n2 = n / n2;
        for (n = 0; n < n3 && this.mStartIndex + n < Flow.access$400((Flow)this.this$0); ++n) {
            ConstraintWidget constraintWidget = Flow.access$500((Flow)this.this$0)[this.mStartIndex + n];
            if (this.mOrientation == 0) {
                if (constraintWidget == null || constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth != 0) continue;
                this.this$0.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n2, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                continue;
            }
            if (constraintWidget == null || constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight != 0) continue;
            this.this$0.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, n2);
        }
        this.recomputeDimensions();
    }

    public void setStartIndex(int n) {
        this.mStartIndex = n;
    }

    public void setup(int n, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int n2, int n3, int n4, int n5, int n6) {
        this.mOrientation = n;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = n2;
        this.mPaddingTop = n3;
        this.mPaddingRight = n4;
        this.mPaddingBottom = n5;
        this.mMax = n6;
    }
}
