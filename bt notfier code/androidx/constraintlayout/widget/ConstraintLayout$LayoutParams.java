/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams$Table
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public static class ConstraintLayout.LayoutParams
extends ViewGroup.MarginLayoutParams {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int END = 7;
    public static final int HORIZONTAL = 0;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public int baselineToBaseline = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public float circleAngle = 0.0f;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public boolean constrainedHeight = false;
    public boolean constrainedWidth = false;
    public String constraintTag = null;
    public String dimensionRatio = null;
    int dimensionRatioSide = 1;
    float dimensionRatioValue = 0.0f;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endToEnd = -1;
    public int endToStart = -1;
    public int goneBottomMargin = -1;
    public int goneEndMargin = -1;
    public int goneLeftMargin = -1;
    public int goneRightMargin = -1;
    public int goneStartMargin = -1;
    public int goneTopMargin = -1;
    public int guideBegin = -1;
    public int guideEnd = -1;
    public float guidePercent = -1.0f;
    public boolean helped = false;
    public float horizontalBias = 0.5f;
    public int horizontalChainStyle = 0;
    boolean horizontalDimensionFixed = true;
    public float horizontalWeight = -1.0f;
    boolean isGuideline = false;
    boolean isHelper = false;
    boolean isInPlaceholder = false;
    boolean isVirtualGroup = false;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public int matchConstraintDefaultHeight = 0;
    public int matchConstraintDefaultWidth = 0;
    public int matchConstraintMaxHeight = 0;
    public int matchConstraintMaxWidth = 0;
    public int matchConstraintMinHeight = 0;
    public int matchConstraintMinWidth = 0;
    public float matchConstraintPercentHeight = 1.0f;
    public float matchConstraintPercentWidth = 1.0f;
    boolean needsBaseline = false;
    public int orientation = -1;
    int resolveGoneLeftMargin = -1;
    int resolveGoneRightMargin = -1;
    int resolvedGuideBegin;
    int resolvedGuideEnd;
    float resolvedGuidePercent;
    float resolvedHorizontalBias = 0.5f;
    int resolvedLeftToLeft = -1;
    int resolvedLeftToRight = -1;
    int resolvedRightToLeft = -1;
    int resolvedRightToRight = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5f;
    public int verticalChainStyle = 0;
    boolean verticalDimensionFixed = true;
    public float verticalWeight = -1.0f;
    ConstraintWidget widget = new ConstraintWidget();

    public ConstraintLayout.LayoutParams(int n, int n2) {
        super(n, n2);
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public ConstraintLayout.LayoutParams(Context context, AttributeSet object) {
        super(context, (AttributeSet)object);
        context = context.obtainStyledAttributes((AttributeSet)object, R.styleable.ConstraintLayout_Layout);
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            block71: {
                if (n2 >= n) {
                    context.recycle();
                    this.validate();
                    return;
                }
                int n3 = context.getIndex(n2);
                int n4 = Table.map.get(n3);
                block7 : switch (n4) {
                    default: {
                        float f;
                        switch (n4) {
                            default: {
                                break block7;
                            }
                            case 51: {
                                this.constraintTag = context.getString(n3);
                                break block7;
                            }
                            case 50: {
                                this.editorAbsoluteY = context.getDimensionPixelOffset(n3, this.editorAbsoluteY);
                                break block7;
                            }
                            case 49: {
                                this.editorAbsoluteX = context.getDimensionPixelOffset(n3, this.editorAbsoluteX);
                                break block7;
                            }
                            case 48: {
                                this.verticalChainStyle = context.getInt(n3, 0);
                                break block7;
                            }
                            case 47: {
                                this.horizontalChainStyle = context.getInt(n3, 0);
                                break block7;
                            }
                            case 46: {
                                this.verticalWeight = context.getFloat(n3, this.verticalWeight);
                                break block7;
                            }
                            case 45: {
                                this.horizontalWeight = context.getFloat(n3, this.horizontalWeight);
                                break block7;
                            }
                            case 44: 
                        }
                        this.dimensionRatio = object = context.getString(n3);
                        this.dimensionRatioValue = Float.NaN;
                        this.dimensionRatioSide = -1;
                        if (object == null) break;
                        n4 = ((String)object).length();
                        n3 = this.dimensionRatio.indexOf(44);
                        if (n3 > 0 && n3 < n4 - 1) {
                            object = this.dimensionRatio.substring(0, n3);
                            if (((String)object).equalsIgnoreCase("W")) {
                                this.dimensionRatioSide = 0;
                            } else if (((String)object).equalsIgnoreCase("H")) {
                                this.dimensionRatioSide = 1;
                            }
                            ++n3;
                        } else {
                            n3 = 0;
                        }
                        int n5 = this.dimensionRatio.indexOf(58);
                        if (n5 >= 0 && n5 < n4 - 1) {
                            String string = this.dimensionRatio.substring(n3, n5);
                            object = this.dimensionRatio.substring(n5 + 1);
                            if (string.length() <= 0 || ((String)object).length() <= 0) break;
                            float f2 = Float.parseFloat(string);
                            f = Float.parseFloat((String)object);
                            if (!(f2 > 0.0f) || !(f > 0.0f)) break;
                            if (this.dimensionRatioSide == 1) {
                                this.dimensionRatioValue = Math.abs(f / f2);
                                break;
                            }
                            this.dimensionRatioValue = Math.abs(f2 / f);
                        }
                        object = this.dimensionRatio.substring(n3);
                        if (((String)object).length() <= 0) break;
                        this.dimensionRatioValue = Float.parseFloat((String)object);
                        break;
                    }
                    case 38: {
                        this.matchConstraintPercentHeight = Math.max(0.0f, context.getFloat(n3, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    }
                    case 37: {
                        try {
                            this.matchConstraintMaxHeight = context.getDimensionPixelSize(n3, this.matchConstraintMaxHeight);
                        }
                        catch (Exception exception) {
                            if (context.getInt(n3, this.matchConstraintMaxHeight) != -2) break;
                            this.matchConstraintMaxHeight = -2;
                        }
                        break;
                    }
                    case 36: {
                        try {
                            this.matchConstraintMinHeight = context.getDimensionPixelSize(n3, this.matchConstraintMinHeight);
                        }
                        catch (Exception exception) {
                            if (context.getInt(n3, this.matchConstraintMinHeight) != -2) break;
                            this.matchConstraintMinHeight = -2;
                        }
                        break;
                    }
                    case 35: {
                        this.matchConstraintPercentWidth = Math.max(0.0f, context.getFloat(n3, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    }
                    case 34: {
                        try {
                            this.matchConstraintMaxWidth = context.getDimensionPixelSize(n3, this.matchConstraintMaxWidth);
                        }
                        catch (Exception exception) {
                            if (context.getInt(n3, this.matchConstraintMaxWidth) != -2) break;
                            this.matchConstraintMaxWidth = -2;
                        }
                        break;
                    }
                    case 33: {
                        try {
                            this.matchConstraintMinWidth = context.getDimensionPixelSize(n3, this.matchConstraintMinWidth);
                        }
                        catch (Exception exception) {
                            if (context.getInt(n3, this.matchConstraintMinWidth) != -2) break;
                            this.matchConstraintMinWidth = -2;
                        }
                        break;
                    }
                    case 32: {
                        this.matchConstraintDefaultHeight = n3 = context.getInt(n3, 0);
                        if (n3 != 1) break;
                        Log.e((String)"ConstraintLayout", (String)"layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    }
                    case 31: {
                        this.matchConstraintDefaultWidth = n3 = context.getInt(n3, 0);
                        if (n3 != 1) break;
                        Log.e((String)"ConstraintLayout", (String)"layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    }
                    case 30: {
                        this.verticalBias = context.getFloat(n3, this.verticalBias);
                        break;
                    }
                    case 29: {
                        this.horizontalBias = context.getFloat(n3, this.horizontalBias);
                        break;
                    }
                    case 28: {
                        this.constrainedHeight = context.getBoolean(n3, this.constrainedHeight);
                        break;
                    }
                    case 27: {
                        this.constrainedWidth = context.getBoolean(n3, this.constrainedWidth);
                        break;
                    }
                    case 26: {
                        this.goneEndMargin = context.getDimensionPixelSize(n3, this.goneEndMargin);
                        break;
                    }
                    case 25: {
                        this.goneStartMargin = context.getDimensionPixelSize(n3, this.goneStartMargin);
                        break;
                    }
                    case 24: {
                        this.goneBottomMargin = context.getDimensionPixelSize(n3, this.goneBottomMargin);
                        break;
                    }
                    case 23: {
                        this.goneRightMargin = context.getDimensionPixelSize(n3, this.goneRightMargin);
                        break;
                    }
                    case 22: {
                        this.goneTopMargin = context.getDimensionPixelSize(n3, this.goneTopMargin);
                        break;
                    }
                    case 21: {
                        this.goneLeftMargin = context.getDimensionPixelSize(n3, this.goneLeftMargin);
                        break;
                    }
                    case 20: {
                        this.endToEnd = n4 = context.getResourceId(n3, this.endToEnd);
                        if (n4 != -1) break;
                        this.endToEnd = context.getInt(n3, -1);
                        break;
                    }
                    case 19: {
                        this.endToStart = n4 = context.getResourceId(n3, this.endToStart);
                        if (n4 != -1) break;
                        this.endToStart = context.getInt(n3, -1);
                        break;
                    }
                    case 18: {
                        this.startToStart = n4 = context.getResourceId(n3, this.startToStart);
                        if (n4 != -1) break;
                        this.startToStart = context.getInt(n3, -1);
                        break;
                    }
                    case 17: {
                        this.startToEnd = n4 = context.getResourceId(n3, this.startToEnd);
                        if (n4 != -1) break;
                        this.startToEnd = context.getInt(n3, -1);
                        break;
                    }
                    case 16: {
                        this.baselineToBaseline = n4 = context.getResourceId(n3, this.baselineToBaseline);
                        if (n4 != -1) break;
                        this.baselineToBaseline = context.getInt(n3, -1);
                        break;
                    }
                    case 15: {
                        this.bottomToBottom = n4 = context.getResourceId(n3, this.bottomToBottom);
                        if (n4 != -1) break;
                        this.bottomToBottom = context.getInt(n3, -1);
                        break;
                    }
                    case 14: {
                        this.bottomToTop = n4 = context.getResourceId(n3, this.bottomToTop);
                        if (n4 != -1) break;
                        this.bottomToTop = context.getInt(n3, -1);
                        break;
                    }
                    case 13: {
                        this.topToBottom = n4 = context.getResourceId(n3, this.topToBottom);
                        if (n4 != -1) break;
                        this.topToBottom = context.getInt(n3, -1);
                        break;
                    }
                    case 12: {
                        this.topToTop = n4 = context.getResourceId(n3, this.topToTop);
                        if (n4 != -1) break;
                        this.topToTop = context.getInt(n3, -1);
                        break;
                    }
                    case 11: {
                        this.rightToRight = n4 = context.getResourceId(n3, this.rightToRight);
                        if (n4 != -1) break;
                        this.rightToRight = context.getInt(n3, -1);
                        break;
                    }
                    case 10: {
                        this.rightToLeft = n4 = context.getResourceId(n3, this.rightToLeft);
                        if (n4 != -1) break;
                        this.rightToLeft = context.getInt(n3, -1);
                        break;
                    }
                    case 9: {
                        this.leftToRight = n4 = context.getResourceId(n3, this.leftToRight);
                        if (n4 != -1) break;
                        this.leftToRight = context.getInt(n3, -1);
                        break;
                    }
                    case 8: {
                        this.leftToLeft = n4 = context.getResourceId(n3, this.leftToLeft);
                        if (n4 != -1) break;
                        this.leftToLeft = context.getInt(n3, -1);
                        break;
                    }
                    case 7: {
                        this.guidePercent = context.getFloat(n3, this.guidePercent);
                        break;
                    }
                    case 6: {
                        this.guideEnd = context.getDimensionPixelOffset(n3, this.guideEnd);
                        break;
                    }
                    case 5: {
                        this.guideBegin = context.getDimensionPixelOffset(n3, this.guideBegin);
                        break;
                    }
                    case 4: {
                        float f;
                        this.circleAngle = f = context.getFloat(n3, this.circleAngle) % 360.0f;
                        if (!(f < 0.0f)) break;
                        this.circleAngle = (360.0f - f) % 360.0f;
                        break;
                    }
                    case 3: {
                        this.circleRadius = context.getDimensionPixelSize(n3, this.circleRadius);
                        break;
                    }
                    case 2: {
                        this.circleConstraint = n4 = context.getResourceId(n3, this.circleConstraint);
                        if (n4 != -1) break;
                        this.circleConstraint = context.getInt(n3, -1);
                        break;
                    }
                    case 1: {
                        this.orientation = context.getInt(n3, this.orientation);
                        break;
                    }
                }
                break block71;
                catch (NumberFormatException numberFormatException) {}
            }
            ++n2;
        }
    }

    public ConstraintLayout.LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams layoutParams) {
        super((ViewGroup.MarginLayoutParams)layoutParams);
        this.guideBegin = layoutParams.guideBegin;
        this.guideEnd = layoutParams.guideEnd;
        this.guidePercent = layoutParams.guidePercent;
        this.leftToLeft = layoutParams.leftToLeft;
        this.leftToRight = layoutParams.leftToRight;
        this.rightToLeft = layoutParams.rightToLeft;
        this.rightToRight = layoutParams.rightToRight;
        this.topToTop = layoutParams.topToTop;
        this.topToBottom = layoutParams.topToBottom;
        this.bottomToTop = layoutParams.bottomToTop;
        this.bottomToBottom = layoutParams.bottomToBottom;
        this.baselineToBaseline = layoutParams.baselineToBaseline;
        this.circleConstraint = layoutParams.circleConstraint;
        this.circleRadius = layoutParams.circleRadius;
        this.circleAngle = layoutParams.circleAngle;
        this.startToEnd = layoutParams.startToEnd;
        this.startToStart = layoutParams.startToStart;
        this.endToStart = layoutParams.endToStart;
        this.endToEnd = layoutParams.endToEnd;
        this.goneLeftMargin = layoutParams.goneLeftMargin;
        this.goneTopMargin = layoutParams.goneTopMargin;
        this.goneRightMargin = layoutParams.goneRightMargin;
        this.goneBottomMargin = layoutParams.goneBottomMargin;
        this.goneStartMargin = layoutParams.goneStartMargin;
        this.goneEndMargin = layoutParams.goneEndMargin;
        this.horizontalBias = layoutParams.horizontalBias;
        this.verticalBias = layoutParams.verticalBias;
        this.dimensionRatio = layoutParams.dimensionRatio;
        this.dimensionRatioValue = layoutParams.dimensionRatioValue;
        this.dimensionRatioSide = layoutParams.dimensionRatioSide;
        this.horizontalWeight = layoutParams.horizontalWeight;
        this.verticalWeight = layoutParams.verticalWeight;
        this.horizontalChainStyle = layoutParams.horizontalChainStyle;
        this.verticalChainStyle = layoutParams.verticalChainStyle;
        this.constrainedWidth = layoutParams.constrainedWidth;
        this.constrainedHeight = layoutParams.constrainedHeight;
        this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
        this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
        this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
        this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
        this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
        this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
        this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
        this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
        this.editorAbsoluteX = layoutParams.editorAbsoluteX;
        this.editorAbsoluteY = layoutParams.editorAbsoluteY;
        this.orientation = layoutParams.orientation;
        this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
        this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
        this.needsBaseline = layoutParams.needsBaseline;
        this.isGuideline = layoutParams.isGuideline;
        this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
        this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
        this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
        this.resolvedRightToRight = layoutParams.resolvedRightToRight;
        this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
        this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
        this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
        this.constraintTag = layoutParams.constraintTag;
        this.widget = layoutParams.widget;
    }

    public String getConstraintTag() {
        return this.constraintTag;
    }

    public ConstraintWidget getConstraintWidget() {
        return this.widget;
    }

    public void reset() {
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget == null) return;
        constraintWidget.reset();
    }

    /*
     * Unable to fully structure code
     */
    public void resolveLayoutDirection(int var1_1) {
        block35: {
            block31: {
                block34: {
                    block33: {
                        block32: {
                            var4_2 = this.leftMargin;
                            var5_3 = this.rightMargin;
                            var6_4 = Build.VERSION.SDK_INT;
                            var3_5 = 0;
                            if (var6_4 < 17) ** GOTO lbl-1000
                            super.resolveLayoutDirection(var1_1);
                            if (1 == this.getLayoutDirection()) {
                                var1_1 = 1;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var1_1 = 0;
                            }
                            this.resolvedRightToLeft = -1;
                            this.resolvedRightToRight = -1;
                            this.resolvedLeftToLeft = -1;
                            this.resolvedLeftToRight = -1;
                            this.resolveGoneLeftMargin = -1;
                            this.resolveGoneRightMargin = -1;
                            this.resolveGoneLeftMargin = this.goneLeftMargin;
                            this.resolveGoneRightMargin = this.goneRightMargin;
                            this.resolvedHorizontalBias = this.horizontalBias;
                            this.resolvedGuideBegin = this.guideBegin;
                            this.resolvedGuideEnd = this.guideEnd;
                            this.resolvedGuidePercent = this.guidePercent;
                            if (var1_1 == 0) break block31;
                            var1_1 = this.startToEnd;
                            if (var1_1 == -1) break block32;
                            this.resolvedRightToLeft = var1_1;
                            break block33;
                        }
                        var6_4 = this.startToStart;
                        var1_1 = var3_5;
                        if (var6_4 == -1) break block34;
                        this.resolvedRightToRight = var6_4;
                    }
                    var1_1 = 1;
                }
                if ((var3_5 = this.endToStart) != -1) {
                    this.resolvedLeftToRight = var3_5;
                    var1_1 = 1;
                }
                if ((var3_5 = this.endToEnd) != -1) {
                    this.resolvedLeftToLeft = var3_5;
                    var1_1 = 1;
                }
                if ((var3_5 = this.goneStartMargin) != -1) {
                    this.resolveGoneRightMargin = var3_5;
                }
                if ((var3_5 = this.goneEndMargin) != -1) {
                    this.resolveGoneLeftMargin = var3_5;
                }
                if (var1_1 != 0) {
                    this.resolvedHorizontalBias = 1.0f - this.horizontalBias;
                }
                if (this.isGuideline && this.orientation == 1) {
                    var2_6 = this.guidePercent;
                    if (var2_6 != -1.0f) {
                        this.resolvedGuidePercent = 1.0f - var2_6;
                        this.resolvedGuideBegin = -1;
                        this.resolvedGuideEnd = -1;
                    } else {
                        var1_1 = this.guideBegin;
                        if (var1_1 != -1) {
                            this.resolvedGuideEnd = var1_1;
                            this.resolvedGuideBegin = -1;
                            this.resolvedGuidePercent = -1.0f;
                        } else {
                            var1_1 = this.guideEnd;
                            if (var1_1 != -1) {
                                this.resolvedGuideBegin = var1_1;
                                this.resolvedGuideEnd = -1;
                                this.resolvedGuidePercent = -1.0f;
                            }
                        }
                    }
                }
                break block35;
            }
            var1_1 = this.startToEnd;
            if (var1_1 != -1) {
                this.resolvedLeftToRight = var1_1;
            }
            if ((var1_1 = this.startToStart) != -1) {
                this.resolvedLeftToLeft = var1_1;
            }
            if ((var1_1 = this.endToStart) != -1) {
                this.resolvedRightToLeft = var1_1;
            }
            if ((var1_1 = this.endToEnd) != -1) {
                this.resolvedRightToRight = var1_1;
            }
            if ((var1_1 = this.goneStartMargin) != -1) {
                this.resolveGoneLeftMargin = var1_1;
            }
            if ((var1_1 = this.goneEndMargin) != -1) {
                this.resolveGoneRightMargin = var1_1;
            }
        }
        if (this.endToStart != -1) return;
        if (this.endToEnd != -1) return;
        if (this.startToStart != -1) return;
        if (this.startToEnd != -1) return;
        var1_1 = this.rightToLeft;
        if (var1_1 != -1) {
            this.resolvedRightToLeft = var1_1;
            if (this.rightMargin <= 0 && var5_3 > 0) {
                this.rightMargin = var5_3;
            }
        } else {
            var1_1 = this.rightToRight;
            if (var1_1 != -1) {
                this.resolvedRightToRight = var1_1;
                if (this.rightMargin <= 0 && var5_3 > 0) {
                    this.rightMargin = var5_3;
                }
            }
        }
        if ((var1_1 = this.leftToLeft) != -1) {
            this.resolvedLeftToLeft = var1_1;
            if (this.leftMargin > 0) return;
            if (var4_2 <= 0) return;
            this.leftMargin = var4_2;
        } else {
            var1_1 = this.leftToRight;
            if (var1_1 == -1) return;
            this.resolvedLeftToRight = var1_1;
            if (this.leftMargin > 0) return;
            if (var4_2 <= 0) return;
            this.leftMargin = var4_2;
        }
    }

    public void setWidgetDebugName(String string) {
        this.widget.setDebugName(string);
    }

    public void validate() {
        this.isGuideline = false;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (this.width == -2 && this.constrainedWidth) {
            this.horizontalDimensionFixed = false;
            if (this.matchConstraintDefaultWidth == 0) {
                this.matchConstraintDefaultWidth = 1;
            }
        }
        if (this.height == -2 && this.constrainedHeight) {
            this.verticalDimensionFixed = false;
            if (this.matchConstraintDefaultHeight == 0) {
                this.matchConstraintDefaultHeight = 1;
            }
        }
        if (this.width == 0 || this.width == -1) {
            this.horizontalDimensionFixed = false;
            if (this.width == 0 && this.matchConstraintDefaultWidth == 1) {
                this.width = -2;
                this.constrainedWidth = true;
            }
        }
        if (this.height == 0 || this.height == -1) {
            this.verticalDimensionFixed = false;
            if (this.height == 0 && this.matchConstraintDefaultHeight == 1) {
                this.height = -2;
                this.constrainedHeight = true;
            }
        }
        if (this.guidePercent == -1.0f && this.guideBegin == -1) {
            if (this.guideEnd == -1) return;
        }
        this.isGuideline = true;
        this.horizontalDimensionFixed = true;
        this.verticalDimensionFixed = true;
        if (!(this.widget instanceof Guideline)) {
            this.widget = new Guideline();
        }
        ((Guideline)this.widget).setOrientation(this.orientation);
    }
}
