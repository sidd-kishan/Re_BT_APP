/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.motion.widget.MotionScene
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ConstraintSet.Layout {
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BASELINE_TO_BASELINE = 1;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int DIMENSION_RATIO = 5;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_PERCENT = 70;
    private static final int HORIZONTAL_BIAS = 20;
    private static final int HORIZONTAL_STYLE = 39;
    private static final int HORIZONTAL_WEIGHT = 37;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_WIDTH = 22;
    private static final int LEFT_MARGIN = 23;
    private static final int LEFT_TO_LEFT = 24;
    private static final int LEFT_TO_RIGHT = 25;
    private static final int ORIENTATION = 26;
    private static final int RIGHT_MARGIN = 27;
    private static final int RIGHT_TO_LEFT = 28;
    private static final int RIGHT_TO_RIGHT = 29;
    private static final int START_MARGIN = 30;
    private static final int START_TO_END = 31;
    private static final int START_TO_START = 32;
    private static final int TOP_MARGIN = 33;
    private static final int TOP_TO_BOTTOM = 34;
    private static final int TOP_TO_TOP = 35;
    public static final int UNSET = -1;
    private static final int UNUSED = 76;
    private static final int VERTICAL_BIAS = 36;
    private static final int VERTICAL_STYLE = 40;
    private static final int VERTICAL_WEIGHT = 38;
    private static final int WIDTH_PERCENT = 69;
    private static SparseIntArray mapToConstant;
    public int baselineToBaseline = -1;
    public int bottomMargin = -1;
    public int bottomToBottom = -1;
    public int bottomToTop = -1;
    public float circleAngle = 0.0f;
    public int circleConstraint = -1;
    public int circleRadius = 0;
    public boolean constrainedHeight = false;
    public boolean constrainedWidth = false;
    public String dimensionRatio = null;
    public int editorAbsoluteX = -1;
    public int editorAbsoluteY = -1;
    public int endMargin = -1;
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
    public int heightDefault = 0;
    public int heightMax = -1;
    public int heightMin = -1;
    public float heightPercent = 1.0f;
    public float horizontalBias = 0.5f;
    public int horizontalChainStyle = 0;
    public float horizontalWeight = -1.0f;
    public int leftMargin = -1;
    public int leftToLeft = -1;
    public int leftToRight = -1;
    public boolean mApply = false;
    public boolean mBarrierAllowsGoneWidgets = true;
    public int mBarrierDirection = -1;
    public int mBarrierMargin = 0;
    public String mConstraintTag;
    public int mHeight;
    public int mHelperType = -1;
    public boolean mIsGuideline = false;
    public String mReferenceIdString;
    public int[] mReferenceIds;
    public int mWidth;
    public int orientation = -1;
    public int rightMargin = -1;
    public int rightToLeft = -1;
    public int rightToRight = -1;
    public int startMargin = -1;
    public int startToEnd = -1;
    public int startToStart = -1;
    public int topMargin = -1;
    public int topToBottom = -1;
    public int topToTop = -1;
    public float verticalBias = 0.5f;
    public int verticalChainStyle = 0;
    public float verticalWeight = -1.0f;
    public int widthDefault = 0;
    public int widthMax = -1;
    public int widthMin = -1;
    public float widthPercent = 1.0f;

    static {
        SparseIntArray sparseIntArray;
        mapToConstant = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
        mapToConstant.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
        mapToConstant.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
        mapToConstant.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
        mapToConstant.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
        mapToConstant.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
        mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Layout_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Layout_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Layout_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Layout_android_orientation, 26);
        mapToConstant.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
        mapToConstant.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
        mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Layout_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Layout_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Layout_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Layout_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Layout_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Layout_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
        mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
        mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
        mapToConstant.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
        mapToConstant.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
        mapToConstant.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
        mapToConstant.append(R.styleable.Layout_layout_constraintTop_creator, 76);
        mapToConstant.append(R.styleable.Layout_layout_constraintRight_creator, 76);
        mapToConstant.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
        mapToConstant.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
        mapToConstant.append(R.styleable.Layout_android_layout_marginLeft, 23);
        mapToConstant.append(R.styleable.Layout_android_layout_marginRight, 27);
        mapToConstant.append(R.styleable.Layout_android_layout_marginStart, 30);
        mapToConstant.append(R.styleable.Layout_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Layout_android_layout_marginTop, 33);
        mapToConstant.append(R.styleable.Layout_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Layout_android_layout_width, 22);
        mapToConstant.append(R.styleable.Layout_android_layout_height, 21);
        mapToConstant.append(R.styleable.Layout_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Layout_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Layout_barrierDirection, 72);
        mapToConstant.append(R.styleable.Layout_barrierMargin, 73);
        mapToConstant.append(R.styleable.Layout_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
    }

    public void copyFrom(ConstraintSet.Layout layout) {
        this.mIsGuideline = layout.mIsGuideline;
        this.mWidth = layout.mWidth;
        this.mApply = layout.mApply;
        this.mHeight = layout.mHeight;
        this.guideBegin = layout.guideBegin;
        this.guideEnd = layout.guideEnd;
        this.guidePercent = layout.guidePercent;
        this.leftToLeft = layout.leftToLeft;
        this.leftToRight = layout.leftToRight;
        this.rightToLeft = layout.rightToLeft;
        this.rightToRight = layout.rightToRight;
        this.topToTop = layout.topToTop;
        this.topToBottom = layout.topToBottom;
        this.bottomToTop = layout.bottomToTop;
        this.bottomToBottom = layout.bottomToBottom;
        this.baselineToBaseline = layout.baselineToBaseline;
        this.startToEnd = layout.startToEnd;
        this.startToStart = layout.startToStart;
        this.endToStart = layout.endToStart;
        this.endToEnd = layout.endToEnd;
        this.horizontalBias = layout.horizontalBias;
        this.verticalBias = layout.verticalBias;
        this.dimensionRatio = layout.dimensionRatio;
        this.circleConstraint = layout.circleConstraint;
        this.circleRadius = layout.circleRadius;
        this.circleAngle = layout.circleAngle;
        this.editorAbsoluteX = layout.editorAbsoluteX;
        this.editorAbsoluteY = layout.editorAbsoluteY;
        this.orientation = layout.orientation;
        this.leftMargin = layout.leftMargin;
        this.rightMargin = layout.rightMargin;
        this.topMargin = layout.topMargin;
        this.bottomMargin = layout.bottomMargin;
        this.endMargin = layout.endMargin;
        this.startMargin = layout.startMargin;
        this.goneLeftMargin = layout.goneLeftMargin;
        this.goneTopMargin = layout.goneTopMargin;
        this.goneRightMargin = layout.goneRightMargin;
        this.goneBottomMargin = layout.goneBottomMargin;
        this.goneEndMargin = layout.goneEndMargin;
        this.goneStartMargin = layout.goneStartMargin;
        this.verticalWeight = layout.verticalWeight;
        this.horizontalWeight = layout.horizontalWeight;
        this.horizontalChainStyle = layout.horizontalChainStyle;
        this.verticalChainStyle = layout.verticalChainStyle;
        this.widthDefault = layout.widthDefault;
        this.heightDefault = layout.heightDefault;
        this.widthMax = layout.widthMax;
        this.heightMax = layout.heightMax;
        this.widthMin = layout.widthMin;
        this.heightMin = layout.heightMin;
        this.widthPercent = layout.widthPercent;
        this.heightPercent = layout.heightPercent;
        this.mBarrierDirection = layout.mBarrierDirection;
        this.mBarrierMargin = layout.mBarrierMargin;
        this.mHelperType = layout.mHelperType;
        this.mConstraintTag = layout.mConstraintTag;
        int[] nArray = layout.mReferenceIds;
        this.mReferenceIds = (int[])(nArray != null ? Arrays.copyOf(nArray, nArray.length) : null);
        this.mReferenceIdString = layout.mReferenceIdString;
        this.constrainedWidth = layout.constrainedWidth;
        this.constrainedHeight = layout.constrainedHeight;
        this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void dump(MotionScene motionScene, StringBuilder stringBuilder) {
        Field[] fieldArray = this.getClass().getDeclaredFields();
        stringBuilder.append("\n");
        int n = 0;
        while (n < fieldArray.length) {
            block9: {
                Object object = fieldArray[n];
                String string = ((Field)object).getName();
                if (!Modifier.isStatic(((Field)object).getModifiers())) {
                    try {
                        Object object2 = ((Field)object).get(this);
                        Class<?> clazz = ((Field)object).getType();
                        object = Integer.TYPE;
                        if (clazz == object) {
                            object = (Integer)object2;
                            if ((Integer)object != -1) {
                                object2 = motionScene.lookUpConstraintName(((Integer)object).intValue());
                                stringBuilder.append("    ");
                                stringBuilder.append(string);
                                stringBuilder.append(" = \"");
                                if (object2 == null) {
                                    object2 = object;
                                }
                                stringBuilder.append(object2);
                                stringBuilder.append("\"\n");
                            }
                            break block9;
                        }
                        if (clazz == Float.TYPE && ((Float)(object2 = (Float)object2)).floatValue() != -1.0f) {
                            stringBuilder.append("    ");
                            stringBuilder.append(string);
                            stringBuilder.append(" = \"");
                            stringBuilder.append(object2);
                            stringBuilder.append("\"\n");
                        }
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        illegalAccessException.printStackTrace();
                    }
                }
            }
            ++n;
        }
    }

    void fillFromAttributeList(Context context, AttributeSet object) {
        context = context.obtainStyledAttributes((AttributeSet)object, R.styleable.Layout);
        this.mApply = true;
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                context.recycle();
                return;
            }
            int n3 = context.getIndex(n2);
            int n4 = mapToConstant.get(n3);
            if (n4 != 80) {
                if (n4 != 81) {
                    block0 : switch (n4) {
                        default: {
                            switch (n4) {
                                default: {
                                    switch (n4) {
                                        default: {
                                            switch (n4) {
                                                default: {
                                                    object = new StringBuilder();
                                                    ((StringBuilder)object).append("Unknown attribute 0x");
                                                    ((StringBuilder)object).append(Integer.toHexString(n3));
                                                    ((StringBuilder)object).append("   ");
                                                    ((StringBuilder)object).append(mapToConstant.get(n3));
                                                    Log.w((String)"ConstraintSet", (String)((StringBuilder)object).toString());
                                                    break block0;
                                                }
                                                case 77: {
                                                    this.mConstraintTag = context.getString(n3);
                                                    break block0;
                                                }
                                                case 76: {
                                                    object = new StringBuilder();
                                                    ((StringBuilder)object).append("unused attribute 0x");
                                                    ((StringBuilder)object).append(Integer.toHexString(n3));
                                                    ((StringBuilder)object).append("   ");
                                                    ((StringBuilder)object).append(mapToConstant.get(n3));
                                                    Log.w((String)"ConstraintSet", (String)((StringBuilder)object).toString());
                                                    break block0;
                                                }
                                                case 75: {
                                                    this.mBarrierAllowsGoneWidgets = context.getBoolean(n3, this.mBarrierAllowsGoneWidgets);
                                                    break block0;
                                                }
                                                case 74: {
                                                    this.mReferenceIdString = context.getString(n3);
                                                    break block0;
                                                }
                                                case 73: {
                                                    this.mBarrierMargin = context.getDimensionPixelSize(n3, this.mBarrierMargin);
                                                    break block0;
                                                }
                                                case 72: {
                                                    this.mBarrierDirection = context.getInt(n3, this.mBarrierDirection);
                                                    break block0;
                                                }
                                                case 71: {
                                                    Log.e((String)"ConstraintSet", (String)"CURRENTLY UNSUPPORTED");
                                                    break block0;
                                                }
                                                case 70: {
                                                    this.heightPercent = context.getFloat(n3, 1.0f);
                                                    break block0;
                                                }
                                                case 69: 
                                            }
                                            this.widthPercent = context.getFloat(n3, 1.0f);
                                            break block0;
                                        }
                                        case 63: {
                                            this.circleAngle = context.getFloat(n3, this.circleAngle);
                                            break block0;
                                        }
                                        case 62: {
                                            this.circleRadius = context.getDimensionPixelSize(n3, this.circleRadius);
                                            break block0;
                                        }
                                        case 61: 
                                    }
                                    this.circleConstraint = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.circleConstraint);
                                    break block0;
                                }
                                case 59: {
                                    this.heightMin = context.getDimensionPixelSize(n3, this.heightMin);
                                    break block0;
                                }
                                case 58: {
                                    this.widthMin = context.getDimensionPixelSize(n3, this.widthMin);
                                    break block0;
                                }
                                case 57: {
                                    this.heightMax = context.getDimensionPixelSize(n3, this.heightMax);
                                    break block0;
                                }
                                case 56: {
                                    this.widthMax = context.getDimensionPixelSize(n3, this.widthMax);
                                    break block0;
                                }
                                case 55: {
                                    this.heightDefault = context.getInt(n3, this.heightDefault);
                                    break block0;
                                }
                                case 54: 
                            }
                            this.widthDefault = context.getInt(n3, this.widthDefault);
                            break;
                        }
                        case 40: {
                            this.verticalChainStyle = context.getInt(n3, this.verticalChainStyle);
                            break;
                        }
                        case 39: {
                            this.horizontalChainStyle = context.getInt(n3, this.horizontalChainStyle);
                            break;
                        }
                        case 38: {
                            this.verticalWeight = context.getFloat(n3, this.verticalWeight);
                            break;
                        }
                        case 37: {
                            this.horizontalWeight = context.getFloat(n3, this.horizontalWeight);
                            break;
                        }
                        case 36: {
                            this.verticalBias = context.getFloat(n3, this.verticalBias);
                            break;
                        }
                        case 35: {
                            this.topToTop = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.topToTop);
                            break;
                        }
                        case 34: {
                            this.topToBottom = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.topToBottom);
                            break;
                        }
                        case 33: {
                            this.topMargin = context.getDimensionPixelSize(n3, this.topMargin);
                            break;
                        }
                        case 32: {
                            this.startToStart = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.startToStart);
                            break;
                        }
                        case 31: {
                            this.startToEnd = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.startToEnd);
                            break;
                        }
                        case 30: {
                            if (Build.VERSION.SDK_INT < 17) break;
                            this.startMargin = context.getDimensionPixelSize(n3, this.startMargin);
                            break;
                        }
                        case 29: {
                            this.rightToRight = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.rightToRight);
                            break;
                        }
                        case 28: {
                            this.rightToLeft = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.rightToLeft);
                            break;
                        }
                        case 27: {
                            this.rightMargin = context.getDimensionPixelSize(n3, this.rightMargin);
                            break;
                        }
                        case 26: {
                            this.orientation = context.getInt(n3, this.orientation);
                            break;
                        }
                        case 25: {
                            this.leftToRight = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.leftToRight);
                            break;
                        }
                        case 24: {
                            this.leftToLeft = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.leftToLeft);
                            break;
                        }
                        case 23: {
                            this.leftMargin = context.getDimensionPixelSize(n3, this.leftMargin);
                            break;
                        }
                        case 22: {
                            this.mWidth = context.getLayoutDimension(n3, this.mWidth);
                            break;
                        }
                        case 21: {
                            this.mHeight = context.getLayoutDimension(n3, this.mHeight);
                            break;
                        }
                        case 20: {
                            this.horizontalBias = context.getFloat(n3, this.horizontalBias);
                            break;
                        }
                        case 19: {
                            this.guidePercent = context.getFloat(n3, this.guidePercent);
                            break;
                        }
                        case 18: {
                            this.guideEnd = context.getDimensionPixelOffset(n3, this.guideEnd);
                            break;
                        }
                        case 17: {
                            this.guideBegin = context.getDimensionPixelOffset(n3, this.guideBegin);
                            break;
                        }
                        case 16: {
                            this.goneTopMargin = context.getDimensionPixelSize(n3, this.goneTopMargin);
                            break;
                        }
                        case 15: {
                            this.goneStartMargin = context.getDimensionPixelSize(n3, this.goneStartMargin);
                            break;
                        }
                        case 14: {
                            this.goneRightMargin = context.getDimensionPixelSize(n3, this.goneRightMargin);
                            break;
                        }
                        case 13: {
                            this.goneLeftMargin = context.getDimensionPixelSize(n3, this.goneLeftMargin);
                            break;
                        }
                        case 12: {
                            this.goneEndMargin = context.getDimensionPixelSize(n3, this.goneEndMargin);
                            break;
                        }
                        case 11: {
                            this.goneBottomMargin = context.getDimensionPixelSize(n3, this.goneBottomMargin);
                            break;
                        }
                        case 10: {
                            this.endToStart = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.endToStart);
                            break;
                        }
                        case 9: {
                            this.endToEnd = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.endToEnd);
                            break;
                        }
                        case 8: {
                            if (Build.VERSION.SDK_INT < 17) break;
                            this.endMargin = context.getDimensionPixelSize(n3, this.endMargin);
                            break;
                        }
                        case 7: {
                            this.editorAbsoluteY = context.getDimensionPixelOffset(n3, this.editorAbsoluteY);
                            break;
                        }
                        case 6: {
                            this.editorAbsoluteX = context.getDimensionPixelOffset(n3, this.editorAbsoluteX);
                            break;
                        }
                        case 5: {
                            this.dimensionRatio = context.getString(n3);
                            break;
                        }
                        case 4: {
                            this.bottomToTop = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.bottomToTop);
                            break;
                        }
                        case 3: {
                            this.bottomToBottom = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.bottomToBottom);
                            break;
                        }
                        case 2: {
                            this.bottomMargin = context.getDimensionPixelSize(n3, this.bottomMargin);
                            break;
                        }
                        case 1: {
                            this.baselineToBaseline = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.baselineToBaseline);
                            break;
                        }
                    }
                } else {
                    this.constrainedHeight = context.getBoolean(n3, this.constrainedHeight);
                }
            } else {
                this.constrainedWidth = context.getBoolean(n3, this.constrainedWidth);
            }
            ++n2;
        }
    }
}
