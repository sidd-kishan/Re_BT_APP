/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.util.Xml
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  androidx.constraintlayout.motion.utils.Easing
 *  androidx.constraintlayout.motion.widget.Debug
 *  androidx.constraintlayout.motion.widget.MotionScene
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 *  androidx.constraintlayout.widget.Barrier
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.ConstraintAttribute$AttributeType
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintSet$Constraint
 *  androidx.constraintlayout.widget.Constraints
 *  androidx.constraintlayout.widget.Constraints$LayoutParams
 *  androidx.constraintlayout.widget.Guideline
 *  androidx.constraintlayout.widget.R$id
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.R;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/*
 * Exception performing whole class analysis ignored.
 */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS;
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private HashMap<Integer, Constraint> mConstraints;
    private boolean mForceId = true;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap();
    private boolean mValidate;

    static {
        SparseIntArray sparseIntArray;
        VISIBILITY_FLAGS = new int[]{0, 4, 8};
        mapToConstant = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R.styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        mapToConstant.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R.styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R.styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R.styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R.styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R.styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R.styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R.styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R.styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R.styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R.styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R.styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R.styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R.styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R.styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R.styleable.Constraint_animate_relativeTo, 64);
        mapToConstant.append(R.styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R.styleable.Constraint_drawPath, 66);
        mapToConstant.append(R.styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R.styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R.styleable.Constraint_android_id, 38);
        mapToConstant.append(R.styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R.styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R.styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R.styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R.styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R.styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R.styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    public ConstraintSet() {
        this.mConstraints = new HashMap();
    }

    static /* synthetic */ int access$100(TypedArray typedArray, int n, int n2) {
        return ConstraintSet.lookupID(typedArray, n, n2);
    }

    static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    private void addAttributes(ConstraintAttribute.AttributeType object, String ... stringArray) {
        int n = 0;
        while (n < stringArray.length) {
            ConstraintAttribute constraintAttribute;
            if (this.mSavedAttributes.containsKey(stringArray[n])) {
                constraintAttribute = this.mSavedAttributes.get(stringArray[n]);
                if (constraintAttribute.getType() != object) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("ConstraintAttribute is already a ");
                    ((StringBuilder)object).append(constraintAttribute.getType().name());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
            } else {
                constraintAttribute = new ConstraintAttribute(stringArray[n], (ConstraintAttribute.AttributeType)object);
                this.mSavedAttributes.put(stringArray[n], constraintAttribute);
            }
            ++n;
        }
    }

    private int[] convertReferenceString(View object, String object2) {
        String[] stringArray = ((String)object2).split(",");
        Context context = object.getContext();
        object2 = new int[stringArray.length];
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3;
            if (n >= stringArray.length) {
                object = object2;
                if (n2 == stringArray.length) return object;
                object = Arrays.copyOf((int[])object2, n2);
                return object;
            }
            Object object3 = stringArray[n].trim();
            try {
                n3 = R.id.class.getField((String)object3).getInt(null);
            }
            catch (Exception exception) {
                n3 = 0;
            }
            int n4 = n3;
            if (n3 == 0) {
                n4 = context.getResources().getIdentifier((String)object3, "id", context.getPackageName());
            }
            n3 = n4;
            if (n4 == 0) {
                n3 = n4;
                if (object.isInEditMode()) {
                    n3 = n4;
                    if (object.getParent() instanceof ConstraintLayout) {
                        object3 = ((ConstraintLayout)object.getParent()).getDesignInformation(0, object3);
                        n3 = n4;
                        if (object3 != null) {
                            n3 = n4;
                            if (object3 instanceof Integer) {
                                n3 = (Integer)object3;
                            }
                        }
                    }
                }
            }
            object2[n2] = n3;
            ++n;
            ++n2;
        }
    }

    private void createHorizontalChain(int n, int n2, int n3, int n4, int[] object, float[] fArray, int n5, int n6, int n7) {
        if (((int[])object).length < 2) {
            object = new IllegalArgumentException("must have 2 or more widgets in a chain");
            throw object;
        }
        if (fArray != null) {
            if (fArray.length != ((int[])object).length) throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArray != null) {
            this.get((int)object[0]).layout.horizontalWeight = fArray[0];
        }
        this.get((int)object[0]).layout.horizontalChainStyle = n5;
        this.connect(object[0], n6, n, n2, -1);
        n = 1;
        while (true) {
            if (n >= ((int[])object).length) {
                this.connect(object[((int[])object).length - 1], n7, n3, n4, -1);
                return;
            }
            n2 = object[n];
            n2 = object[n];
            n5 = n - 1;
            this.connect(n2, n6, object[n5], n7, -1);
            this.connect(object[n5], n7, object[n], n6, -1);
            if (fArray != null) {
                this.get((int)object[n]).layout.horizontalWeight = fArray[n];
            }
            ++n;
        }
    }

    private Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        Constraint constraint = new Constraint();
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.Constraint);
        this.populateConstraint(context, constraint, (TypedArray)attributeSet);
        attributeSet.recycle();
        return constraint;
    }

    private Constraint get(int n) {
        if (this.mConstraints.containsKey(n)) return this.mConstraints.get(n);
        this.mConstraints.put(n, new Constraint());
        return this.mConstraints.get(n);
    }

    private static int lookupID(TypedArray typedArray, int n, int n2) {
        int n3;
        n2 = n3 = typedArray.getResourceId(n, n2);
        if (n3 != -1) return n2;
        n2 = typedArray.getInt(n, -1);
        return n2;
    }

    private void populateConstraint(Context object, Constraint constraint, TypedArray typedArray) {
        int n = typedArray.getIndexCount();
        int n2 = 0;
        while (n2 < n) {
            int n3 = typedArray.getIndex(n2);
            if (n3 != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != n3 && R.styleable.Constraint_android_layout_marginEnd != n3) {
                constraint.motion.mApply = true;
                constraint.layout.mApply = true;
                constraint.propertySet.mApply = true;
                constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(n3)) {
                default: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unknown attribute 0x");
                    ((StringBuilder)object).append(Integer.toHexString(n3));
                    ((StringBuilder)object).append("   ");
                    ((StringBuilder)object).append(mapToConstant.get(n3));
                    Log.w((String)"ConstraintSet", (String)((StringBuilder)object).toString());
                    break;
                }
                case 82: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("unused attribute 0x");
                    ((StringBuilder)object).append(Integer.toHexString(n3));
                    ((StringBuilder)object).append("   ");
                    ((StringBuilder)object).append(mapToConstant.get(n3));
                    Log.w((String)"ConstraintSet", (String)((StringBuilder)object).toString());
                    break;
                }
                case 81: {
                    constraint.layout.constrainedHeight = typedArray.getBoolean(n3, constraint.layout.constrainedHeight);
                    break;
                }
                case 80: {
                    constraint.layout.constrainedWidth = typedArray.getBoolean(n3, constraint.layout.constrainedWidth);
                    break;
                }
                case 79: {
                    constraint.motion.mMotionStagger = typedArray.getFloat(n3, constraint.motion.mMotionStagger);
                    break;
                }
                case 78: {
                    constraint.propertySet.mVisibilityMode = typedArray.getInt(n3, constraint.propertySet.mVisibilityMode);
                    break;
                }
                case 77: {
                    constraint.layout.mConstraintTag = typedArray.getString(n3);
                    break;
                }
                case 76: {
                    constraint.motion.mPathMotionArc = typedArray.getInt(n3, constraint.motion.mPathMotionArc);
                    break;
                }
                case 75: {
                    constraint.layout.mBarrierAllowsGoneWidgets = typedArray.getBoolean(n3, constraint.layout.mBarrierAllowsGoneWidgets);
                    break;
                }
                case 74: {
                    constraint.layout.mReferenceIdString = typedArray.getString(n3);
                    break;
                }
                case 73: {
                    constraint.layout.mBarrierMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.mBarrierMargin);
                    break;
                }
                case 72: {
                    constraint.layout.mBarrierDirection = typedArray.getInt(n3, constraint.layout.mBarrierDirection);
                    break;
                }
                case 71: {
                    Log.e((String)"ConstraintSet", (String)"CURRENTLY UNSUPPORTED");
                    break;
                }
                case 70: {
                    constraint.layout.heightPercent = typedArray.getFloat(n3, 1.0f);
                    break;
                }
                case 69: {
                    constraint.layout.widthPercent = typedArray.getFloat(n3, 1.0f);
                    break;
                }
                case 68: {
                    constraint.propertySet.mProgress = typedArray.getFloat(n3, constraint.propertySet.mProgress);
                    break;
                }
                case 67: {
                    constraint.motion.mPathRotate = typedArray.getFloat(n3, constraint.motion.mPathRotate);
                    break;
                }
                case 66: {
                    constraint.motion.mDrawPath = typedArray.getInt(n3, 0);
                    break;
                }
                case 65: {
                    if (typedArray.peekValue((int)n3).type == 3) {
                        constraint.motion.mTransitionEasing = typedArray.getString(n3);
                        break;
                    }
                    constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(n3, 0)];
                    break;
                }
                case 64: {
                    constraint.motion.mAnimateRelativeTo = ConstraintSet.lookupID(typedArray, n3, constraint.motion.mAnimateRelativeTo);
                    break;
                }
                case 63: {
                    constraint.layout.circleAngle = typedArray.getFloat(n3, constraint.layout.circleAngle);
                    break;
                }
                case 62: {
                    constraint.layout.circleRadius = typedArray.getDimensionPixelSize(n3, constraint.layout.circleRadius);
                    break;
                }
                case 61: {
                    constraint.layout.circleConstraint = ConstraintSet.lookupID(typedArray, n3, constraint.layout.circleConstraint);
                    break;
                }
                case 60: {
                    constraint.transform.rotation = typedArray.getFloat(n3, constraint.transform.rotation);
                    break;
                }
                case 59: {
                    constraint.layout.heightMin = typedArray.getDimensionPixelSize(n3, constraint.layout.heightMin);
                    break;
                }
                case 58: {
                    constraint.layout.widthMin = typedArray.getDimensionPixelSize(n3, constraint.layout.widthMin);
                    break;
                }
                case 57: {
                    constraint.layout.heightMax = typedArray.getDimensionPixelSize(n3, constraint.layout.heightMax);
                    break;
                }
                case 56: {
                    constraint.layout.widthMax = typedArray.getDimensionPixelSize(n3, constraint.layout.widthMax);
                    break;
                }
                case 55: {
                    constraint.layout.heightDefault = typedArray.getInt(n3, constraint.layout.heightDefault);
                    break;
                }
                case 54: {
                    constraint.layout.widthDefault = typedArray.getInt(n3, constraint.layout.widthDefault);
                    break;
                }
                case 53: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    constraint.transform.translationZ = typedArray.getDimension(n3, constraint.transform.translationZ);
                    break;
                }
                case 52: {
                    constraint.transform.translationY = typedArray.getDimension(n3, constraint.transform.translationY);
                    break;
                }
                case 51: {
                    constraint.transform.translationX = typedArray.getDimension(n3, constraint.transform.translationX);
                    break;
                }
                case 50: {
                    constraint.transform.transformPivotY = typedArray.getDimension(n3, constraint.transform.transformPivotY);
                    break;
                }
                case 49: {
                    constraint.transform.transformPivotX = typedArray.getDimension(n3, constraint.transform.transformPivotX);
                    break;
                }
                case 48: {
                    constraint.transform.scaleY = typedArray.getFloat(n3, constraint.transform.scaleY);
                    break;
                }
                case 47: {
                    constraint.transform.scaleX = typedArray.getFloat(n3, constraint.transform.scaleX);
                    break;
                }
                case 46: {
                    constraint.transform.rotationY = typedArray.getFloat(n3, constraint.transform.rotationY);
                    break;
                }
                case 45: {
                    constraint.transform.rotationX = typedArray.getFloat(n3, constraint.transform.rotationX);
                    break;
                }
                case 44: {
                    if (Build.VERSION.SDK_INT < 21) break;
                    constraint.transform.applyElevation = true;
                    constraint.transform.elevation = typedArray.getDimension(n3, constraint.transform.elevation);
                    break;
                }
                case 43: {
                    constraint.propertySet.alpha = typedArray.getFloat(n3, constraint.propertySet.alpha);
                    break;
                }
                case 42: {
                    constraint.layout.verticalChainStyle = typedArray.getInt(n3, constraint.layout.verticalChainStyle);
                    break;
                }
                case 41: {
                    constraint.layout.horizontalChainStyle = typedArray.getInt(n3, constraint.layout.horizontalChainStyle);
                    break;
                }
                case 40: {
                    constraint.layout.verticalWeight = typedArray.getFloat(n3, constraint.layout.verticalWeight);
                    break;
                }
                case 39: {
                    constraint.layout.horizontalWeight = typedArray.getFloat(n3, constraint.layout.horizontalWeight);
                    break;
                }
                case 38: {
                    constraint.mViewId = typedArray.getResourceId(n3, constraint.mViewId);
                    break;
                }
                case 37: {
                    constraint.layout.verticalBias = typedArray.getFloat(n3, constraint.layout.verticalBias);
                    break;
                }
                case 36: {
                    constraint.layout.topToTop = ConstraintSet.lookupID(typedArray, n3, constraint.layout.topToTop);
                    break;
                }
                case 35: {
                    constraint.layout.topToBottom = ConstraintSet.lookupID(typedArray, n3, constraint.layout.topToBottom);
                    break;
                }
                case 34: {
                    constraint.layout.topMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.topMargin);
                    break;
                }
                case 33: {
                    constraint.layout.startToStart = ConstraintSet.lookupID(typedArray, n3, constraint.layout.startToStart);
                    break;
                }
                case 32: {
                    constraint.layout.startToEnd = ConstraintSet.lookupID(typedArray, n3, constraint.layout.startToEnd);
                    break;
                }
                case 31: {
                    if (Build.VERSION.SDK_INT < 17) break;
                    constraint.layout.startMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.startMargin);
                    break;
                }
                case 30: {
                    constraint.layout.rightToRight = ConstraintSet.lookupID(typedArray, n3, constraint.layout.rightToRight);
                    break;
                }
                case 29: {
                    constraint.layout.rightToLeft = ConstraintSet.lookupID(typedArray, n3, constraint.layout.rightToLeft);
                    break;
                }
                case 28: {
                    constraint.layout.rightMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.rightMargin);
                    break;
                }
                case 27: {
                    constraint.layout.orientation = typedArray.getInt(n3, constraint.layout.orientation);
                    break;
                }
                case 26: {
                    constraint.layout.leftToRight = ConstraintSet.lookupID(typedArray, n3, constraint.layout.leftToRight);
                    break;
                }
                case 25: {
                    constraint.layout.leftToLeft = ConstraintSet.lookupID(typedArray, n3, constraint.layout.leftToLeft);
                    break;
                }
                case 24: {
                    constraint.layout.leftMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.leftMargin);
                    break;
                }
                case 23: {
                    constraint.layout.mWidth = typedArray.getLayoutDimension(n3, constraint.layout.mWidth);
                    break;
                }
                case 22: {
                    constraint.propertySet.visibility = typedArray.getInt(n3, constraint.propertySet.visibility);
                    constraint.propertySet.visibility = VISIBILITY_FLAGS[constraint.propertySet.visibility];
                    break;
                }
                case 21: {
                    constraint.layout.mHeight = typedArray.getLayoutDimension(n3, constraint.layout.mHeight);
                    break;
                }
                case 20: {
                    constraint.layout.horizontalBias = typedArray.getFloat(n3, constraint.layout.horizontalBias);
                    break;
                }
                case 19: {
                    constraint.layout.guidePercent = typedArray.getFloat(n3, constraint.layout.guidePercent);
                    break;
                }
                case 18: {
                    constraint.layout.guideEnd = typedArray.getDimensionPixelOffset(n3, constraint.layout.guideEnd);
                    break;
                }
                case 17: {
                    constraint.layout.guideBegin = typedArray.getDimensionPixelOffset(n3, constraint.layout.guideBegin);
                    break;
                }
                case 16: {
                    constraint.layout.goneTopMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.goneTopMargin);
                    break;
                }
                case 15: {
                    constraint.layout.goneStartMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.goneStartMargin);
                    break;
                }
                case 14: {
                    constraint.layout.goneRightMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.goneRightMargin);
                    break;
                }
                case 13: {
                    constraint.layout.goneLeftMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.goneLeftMargin);
                    break;
                }
                case 12: {
                    constraint.layout.goneEndMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.goneEndMargin);
                    break;
                }
                case 11: {
                    constraint.layout.goneBottomMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.goneBottomMargin);
                    break;
                }
                case 10: {
                    constraint.layout.endToStart = ConstraintSet.lookupID(typedArray, n3, constraint.layout.endToStart);
                    break;
                }
                case 9: {
                    constraint.layout.endToEnd = ConstraintSet.lookupID(typedArray, n3, constraint.layout.endToEnd);
                    break;
                }
                case 8: {
                    if (Build.VERSION.SDK_INT < 17) break;
                    constraint.layout.endMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.endMargin);
                    break;
                }
                case 7: {
                    constraint.layout.editorAbsoluteY = typedArray.getDimensionPixelOffset(n3, constraint.layout.editorAbsoluteY);
                    break;
                }
                case 6: {
                    constraint.layout.editorAbsoluteX = typedArray.getDimensionPixelOffset(n3, constraint.layout.editorAbsoluteX);
                    break;
                }
                case 5: {
                    constraint.layout.dimensionRatio = typedArray.getString(n3);
                    break;
                }
                case 4: {
                    constraint.layout.bottomToTop = ConstraintSet.lookupID(typedArray, n3, constraint.layout.bottomToTop);
                    break;
                }
                case 3: {
                    constraint.layout.bottomToBottom = ConstraintSet.lookupID(typedArray, n3, constraint.layout.bottomToBottom);
                    break;
                }
                case 2: {
                    constraint.layout.bottomMargin = typedArray.getDimensionPixelSize(n3, constraint.layout.bottomMargin);
                    break;
                }
                case 1: {
                    constraint.layout.baselineToBaseline = ConstraintSet.lookupID(typedArray, n3, constraint.layout.baselineToBaseline);
                }
            }
            ++n2;
        }
    }

    private String sideToString(int n) {
        switch (n) {
            default: {
                return "undefined";
            }
            case 7: {
                return "end";
            }
            case 6: {
                return "start";
            }
            case 5: {
                return "baseline";
            }
            case 4: {
                return "bottom";
            }
            case 3: {
                return "top";
            }
            case 2: {
                return "right";
            }
            case 1: 
        }
        return "left";
    }

    private static String[] splitString(String object) {
        char[] cArray = ((String)object).toCharArray();
        object = new ArrayList();
        int n = 0;
        int n2 = 0;
        boolean bl = false;
        while (true) {
            boolean bl2;
            int n3;
            if (n >= cArray.length) {
                ((ArrayList)object).add(new String(cArray, n2, cArray.length - n2));
                return ((ArrayList)object).toArray(new String[((ArrayList)object).size()]);
            }
            if (cArray[n] == ',' && !bl) {
                ((ArrayList)object).add(new String(cArray, n2, n - n2));
                n3 = n + 1;
                bl2 = bl;
            } else {
                n3 = n2;
                bl2 = bl;
                if (cArray[n] == '\"') {
                    bl2 = bl ^ true;
                    n3 = n2;
                }
            }
            ++n;
            n2 = n3;
            bl = bl2;
        }
    }

    public void addColorAttributes(String ... stringArray) {
        this.addAttributes(ConstraintAttribute.AttributeType.COLOR_TYPE, stringArray);
    }

    public void addFloatAttributes(String ... stringArray) {
        this.addAttributes(ConstraintAttribute.AttributeType.FLOAT_TYPE, stringArray);
    }

    public void addIntAttributes(String ... stringArray) {
        this.addAttributes(ConstraintAttribute.AttributeType.INT_TYPE, stringArray);
    }

    public void addStringAttributes(String ... stringArray) {
        this.addAttributes(ConstraintAttribute.AttributeType.STRING_TYPE, stringArray);
    }

    public void addToHorizontalChain(int n, int n2, int n3) {
        int n4 = n2 == 0 ? 1 : 2;
        this.connect(n, 1, n2, n4, 0);
        n4 = n3 == 0 ? 2 : 1;
        this.connect(n, 2, n3, n4, 0);
        if (n2 != 0) {
            this.connect(n2, 2, n, 1, 0);
        }
        if (n3 == 0) return;
        this.connect(n3, 1, n, 2, 0);
    }

    public void addToHorizontalChainRTL(int n, int n2, int n3) {
        int n4 = n2 == 0 ? 6 : 7;
        this.connect(n, 6, n2, n4, 0);
        n4 = n3 == 0 ? 7 : 6;
        this.connect(n, 7, n3, n4, 0);
        if (n2 != 0) {
            this.connect(n2, 7, n, 6, 0);
        }
        if (n3 == 0) return;
        this.connect(n3, 6, n, 7, 0);
    }

    public void addToVerticalChain(int n, int n2, int n3) {
        int n4 = n2 == 0 ? 3 : 4;
        this.connect(n, 3, n2, n4, 0);
        n4 = n3 == 0 ? 4 : 3;
        this.connect(n, 4, n3, n4, 0);
        if (n2 != 0) {
            this.connect(n2, 4, n, 3, 0);
        }
        if (n3 == 0) return;
        this.connect(n3, 3, n, 4, 0);
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int n = constraintLayout.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = constraintLayout.getChildAt(n2);
            int n3 = view.getId();
            if (!this.mConstraints.containsKey(n3)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("id unknown ");
                stringBuilder.append(Debug.getName((View)view));
                Log.v((String)"ConstraintSet", (String)stringBuilder.toString());
            } else {
                if (this.mForceId) {
                    if (n3 == -1) throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.mConstraints.containsKey(n3)) {
                    ConstraintAttribute.setAttributes((View)view, (HashMap)this.mConstraints.get((Object)Integer.valueOf((int)n3)).mCustomConstraints);
                }
            }
            ++n2;
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        this.applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int n = constraintHelper.getId();
        if (!this.mConstraints.containsKey(n)) return;
        Constraint constraint = this.mConstraints.get(n);
        if (!(constraintWidget instanceof HelperWidget)) return;
        constraintHelper.loadParameters(constraint, (HelperWidget)constraintWidget, layoutParams, sparseArray);
    }

    void applyToInternal(ConstraintLayout constraintLayout, boolean bl) {
        Guideline guideline;
        Serializable serializable;
        Object object;
        int n = constraintLayout.getChildCount();
        Object object2 = new HashSet<Integer>(this.mConstraints.keySet());
        for (int i = 0; i < n; ++i) {
            object = constraintLayout.getChildAt(i);
            int n2 = object.getId();
            if (!this.mConstraints.containsKey(n2)) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("id unknown ");
                ((StringBuilder)serializable).append(Debug.getName((View)object));
                Log.w((String)"ConstraintSet", (String)((StringBuilder)serializable).toString());
                continue;
            }
            if (this.mForceId) {
                if (n2 == -1) throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (n2 == -1) continue;
            if (this.mConstraints.containsKey(n2)) {
                ((HashSet)object2).remove(n2);
                serializable = this.mConstraints.get(n2);
                if (object instanceof Barrier) {
                    ((Constraint)serializable).layout.mHelperType = 1;
                }
                if (((Constraint)serializable).layout.mHelperType != -1 && ((Constraint)serializable).layout.mHelperType == 1) {
                    guideline = (Barrier)object;
                    guideline.setId(n2);
                    guideline.setType(((Constraint)serializable).layout.mBarrierDirection);
                    guideline.setMargin(((Constraint)serializable).layout.mBarrierMargin);
                    guideline.setAllowsGoneWidget(((Constraint)serializable).layout.mBarrierAllowsGoneWidgets);
                    if (((Constraint)serializable).layout.mReferenceIds != null) {
                        guideline.setReferencedIds(((Constraint)serializable).layout.mReferenceIds);
                    } else if (((Constraint)serializable).layout.mReferenceIdString != null) {
                        ((Constraint)serializable).layout.mReferenceIds = this.convertReferenceString((View)guideline, ((Constraint)serializable).layout.mReferenceIdString);
                        guideline.setReferencedIds(((Constraint)serializable).layout.mReferenceIds);
                    }
                }
                guideline = (ConstraintLayout.LayoutParams)object.getLayoutParams();
                guideline.validate();
                serializable.applyTo((ConstraintLayout.LayoutParams)guideline);
                if (bl) {
                    ConstraintAttribute.setAttributes((View)object, (HashMap)((Constraint)serializable).mCustomConstraints);
                }
                object.setLayoutParams((ViewGroup.LayoutParams)guideline);
                if (((Constraint)serializable).propertySet.mVisibilityMode == 0) {
                    object.setVisibility(((Constraint)serializable).propertySet.visibility);
                }
                if (Build.VERSION.SDK_INT < 17) continue;
                object.setAlpha(((Constraint)serializable).propertySet.alpha);
                object.setRotation(((Constraint)serializable).transform.rotation);
                object.setRotationX(((Constraint)serializable).transform.rotationX);
                object.setRotationY(((Constraint)serializable).transform.rotationY);
                object.setScaleX(((Constraint)serializable).transform.scaleX);
                object.setScaleY(((Constraint)serializable).transform.scaleY);
                if (!Float.isNaN(((Constraint)serializable).transform.transformPivotX)) {
                    object.setPivotX(((Constraint)serializable).transform.transformPivotX);
                }
                if (!Float.isNaN(((Constraint)serializable).transform.transformPivotY)) {
                    object.setPivotY(((Constraint)serializable).transform.transformPivotY);
                }
                object.setTranslationX(((Constraint)serializable).transform.translationX);
                object.setTranslationY(((Constraint)serializable).transform.translationY);
                if (Build.VERSION.SDK_INT < 21) continue;
                object.setTranslationZ(((Constraint)serializable).transform.translationZ);
                if (!((Constraint)serializable).transform.applyElevation) continue;
                object.setElevation(((Constraint)serializable).transform.elevation);
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("WARNING NO CONSTRAINTS for view ");
            ((StringBuilder)object).append(n2);
            Log.v((String)"ConstraintSet", (String)((StringBuilder)object).toString());
        }
        object2 = ((HashSet)object2).iterator();
        while (object2.hasNext()) {
            serializable = (Integer)object2.next();
            object = this.mConstraints.get(serializable);
            if (((Constraint)object).layout.mHelperType != -1 && ((Constraint)object).layout.mHelperType == 1) {
                Barrier barrier = new Barrier(constraintLayout.getContext());
                barrier.setId(((Integer)serializable).intValue());
                if (((Constraint)object).layout.mReferenceIds != null) {
                    barrier.setReferencedIds(((Constraint)object).layout.mReferenceIds);
                } else if (((Constraint)object).layout.mReferenceIdString != null) {
                    ((Constraint)object).layout.mReferenceIds = this.convertReferenceString((View)barrier, ((Constraint)object).layout.mReferenceIdString);
                    barrier.setReferencedIds(((Constraint)object).layout.mReferenceIds);
                }
                barrier.setType(((Constraint)object).layout.mBarrierDirection);
                barrier.setMargin(((Constraint)object).layout.mBarrierMargin);
                guideline = constraintLayout.generateDefaultLayoutParams();
                barrier.validateParams();
                object.applyTo((ConstraintLayout.LayoutParams)guideline);
                constraintLayout.addView((View)barrier, (ViewGroup.LayoutParams)guideline);
            }
            if (!((Constraint)object).layout.mIsGuideline) continue;
            guideline = new Guideline(constraintLayout.getContext());
            guideline.setId(((Integer)serializable).intValue());
            serializable = constraintLayout.generateDefaultLayoutParams();
            object.applyTo((ConstraintLayout.LayoutParams)serializable);
            constraintLayout.addView((View)guideline, (ViewGroup.LayoutParams)serializable);
        }
    }

    public void applyToLayoutParams(int n, ConstraintLayout.LayoutParams layoutParams) {
        if (!this.mConstraints.containsKey(n)) return;
        this.mConstraints.get(n).applyTo(layoutParams);
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        this.applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int n, int n2, int n3, int n4, int n5, int n6, int n7, float f) {
        if (n4 < 0) throw new IllegalArgumentException("margin must be > 0");
        if (n7 < 0) throw new IllegalArgumentException("margin must be > 0");
        if (f <= 0.0f) throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        if (f > 1.0f) throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        if (n3 != 1 && n3 != 2) {
            if (n3 != 6 && n3 != 7) {
                this.connect(n, 3, n2, n3, n4);
                this.connect(n, 4, n5, n6, n7);
                this.mConstraints.get((Object)Integer.valueOf((int)n)).layout.verticalBias = f;
            } else {
                this.connect(n, 6, n2, n3, n4);
                this.connect(n, 7, n5, n6, n7);
                this.mConstraints.get((Object)Integer.valueOf((int)n)).layout.horizontalBias = f;
            }
        } else {
            this.connect(n, 1, n2, n3, n4);
            this.connect(n, 2, n5, n6, n7);
            this.mConstraints.get((Object)Integer.valueOf((int)n)).layout.horizontalBias = f;
        }
    }

    public void centerHorizontally(int n, int n2) {
        if (n2 == 0) {
            this.center(n, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            this.center(n, n2, 2, 0, n2, 1, 0, 0.5f);
        }
    }

    public void centerHorizontally(int n, int n2, int n3, int n4, int n5, int n6, int n7, float f) {
        this.connect(n, 1, n2, n3, n4);
        this.connect(n, 2, n5, n6, n7);
        this.mConstraints.get((Object)Integer.valueOf((int)n)).layout.horizontalBias = f;
    }

    public void centerHorizontallyRtl(int n, int n2) {
        if (n2 == 0) {
            this.center(n, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            this.center(n, n2, 7, 0, n2, 6, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int n, int n2, int n3, int n4, int n5, int n6, int n7, float f) {
        this.connect(n, 6, n2, n3, n4);
        this.connect(n, 7, n5, n6, n7);
        this.mConstraints.get((Object)Integer.valueOf((int)n)).layout.horizontalBias = f;
    }

    public void centerVertically(int n, int n2) {
        if (n2 == 0) {
            this.center(n, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            this.center(n, n2, 4, 0, n2, 3, 0, 0.5f);
        }
    }

    public void centerVertically(int n, int n2, int n3, int n4, int n5, int n6, int n7, float f) {
        this.connect(n, 3, n2, n3, n4);
        this.connect(n, 4, n5, n6, n7);
        this.mConstraints.get((Object)Integer.valueOf((int)n)).layout.verticalBias = f;
    }

    public void clear(int n) {
        this.mConstraints.remove(n);
    }

    public void clear(int n, int n2) {
        if (!this.mConstraints.containsKey(n)) return;
        Constraint constraint = this.mConstraints.get(n);
        switch (n2) {
            default: {
                throw new IllegalArgumentException("unknown constraint");
            }
            case 7: {
                constraint.layout.endToStart = -1;
                constraint.layout.endToEnd = -1;
                constraint.layout.endMargin = -1;
                constraint.layout.goneEndMargin = -1;
                break;
            }
            case 6: {
                constraint.layout.startToEnd = -1;
                constraint.layout.startToStart = -1;
                constraint.layout.startMargin = -1;
                constraint.layout.goneStartMargin = -1;
                break;
            }
            case 5: {
                constraint.layout.baselineToBaseline = -1;
                break;
            }
            case 4: {
                constraint.layout.bottomToTop = -1;
                constraint.layout.bottomToBottom = -1;
                constraint.layout.bottomMargin = -1;
                constraint.layout.goneBottomMargin = -1;
                break;
            }
            case 3: {
                constraint.layout.topToBottom = -1;
                constraint.layout.topToTop = -1;
                constraint.layout.topMargin = -1;
                constraint.layout.goneTopMargin = -1;
                break;
            }
            case 2: {
                constraint.layout.rightToRight = -1;
                constraint.layout.rightToLeft = -1;
                constraint.layout.rightMargin = -1;
                constraint.layout.goneRightMargin = -1;
                break;
            }
            case 1: {
                constraint.layout.leftToRight = -1;
                constraint.layout.leftToLeft = -1;
                constraint.layout.leftMargin = -1;
                constraint.layout.goneLeftMargin = -1;
            }
        }
    }

    public void clone(Context context, int n) {
        this.clone((ConstraintLayout)LayoutInflater.from((Context)context).inflate(n, null));
    }

    public void clone(ConstraintLayout constraintLayout) {
        int n = constraintLayout.getChildCount();
        this.mConstraints.clear();
        int n2 = 0;
        while (n2 < n) {
            View view = constraintLayout.getChildAt(n2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();
            int n3 = view.getId();
            if (this.mForceId) {
                if (n3 == -1) throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(n3)) {
                this.mConstraints.put(n3, new Constraint());
            }
            Constraint constraint = this.mConstraints.get(n3);
            constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, (View)view);
            Constraint.access$000((Constraint)constraint, (int)n3, (ConstraintLayout.LayoutParams)layoutParams);
            constraint.propertySet.visibility = view.getVisibility();
            if (Build.VERSION.SDK_INT >= 17) {
                constraint.propertySet.alpha = view.getAlpha();
                constraint.transform.rotation = view.getRotation();
                constraint.transform.rotationX = view.getRotationX();
                constraint.transform.rotationY = view.getRotationY();
                constraint.transform.scaleX = view.getScaleX();
                constraint.transform.scaleY = view.getScaleY();
                float f = view.getPivotX();
                float f2 = view.getPivotY();
                if ((double)f != 0.0 || (double)f2 != 0.0) {
                    constraint.transform.transformPivotX = f;
                    constraint.transform.transformPivotY = f2;
                }
                constraint.transform.translationX = view.getTranslationX();
                constraint.transform.translationY = view.getTranslationY();
                if (Build.VERSION.SDK_INT >= 21) {
                    constraint.transform.translationZ = view.getTranslationZ();
                    if (constraint.transform.applyElevation) {
                        constraint.transform.elevation = view.getElevation();
                    }
                }
            }
            if (view instanceof Barrier) {
                layoutParams = (Barrier)view;
                constraint.layout.mBarrierAllowsGoneWidgets = layoutParams.allowsGoneWidget();
                constraint.layout.mReferenceIds = layoutParams.getReferencedIds();
                constraint.layout.mBarrierDirection = layoutParams.getType();
                constraint.layout.mBarrierMargin = layoutParams.getMargin();
            }
            ++n2;
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        Iterator<Integer> iterator = constraintSet.mConstraints.keySet().iterator();
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            this.mConstraints.put(n, constraintSet.mConstraints.get(n).clone());
        }
    }

    public void clone(Constraints constraints) {
        int n = constraints.getChildCount();
        this.mConstraints.clear();
        int n2 = 0;
        while (n2 < n) {
            View view = constraints.getChildAt(n2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams)view.getLayoutParams();
            int n3 = view.getId();
            if (this.mForceId) {
                if (n3 == -1) throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(n3)) {
                this.mConstraints.put(n3, new Constraint());
            }
            Constraint constraint = this.mConstraints.get(n3);
            if (view instanceof ConstraintHelper) {
                Constraint.access$300((Constraint)constraint, (ConstraintHelper)((ConstraintHelper)view), (int)n3, (Constraints.LayoutParams)layoutParams);
            }
            Constraint.access$400((Constraint)constraint, (int)n3, (Constraints.LayoutParams)layoutParams);
            ++n2;
        }
    }

    public void connect(int n, int n2, int n3, int n4) {
        Object object;
        block22: {
            if (!this.mConstraints.containsKey(n)) {
                this.mConstraints.put(n, new Constraint());
            }
            object = this.mConstraints.get(n);
            switch (n2) {
                default: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(this.sideToString(n2));
                    ((StringBuilder)object).append(" to ");
                    ((StringBuilder)object).append(this.sideToString(n4));
                    ((StringBuilder)object).append(" unknown");
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                case 7: {
                    if (n4 == 7) {
                        ((Constraint)object).layout.endToEnd = n3;
                        ((Constraint)object).layout.endToStart = -1;
                        break;
                    }
                    if (n4 != 6) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.sideToString(n4));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((Constraint)object).layout.endToStart = n3;
                    ((Constraint)object).layout.endToEnd = -1;
                    break;
                }
                case 6: {
                    if (n4 == 6) {
                        ((Constraint)object).layout.startToStart = n3;
                        ((Constraint)object).layout.startToEnd = -1;
                        break;
                    }
                    if (n4 != 7) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.sideToString(n4));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((Constraint)object).layout.startToEnd = n3;
                    ((Constraint)object).layout.startToStart = -1;
                    break;
                }
                case 5: {
                    if (n4 != 5) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.sideToString(n4));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((Constraint)object).layout.baselineToBaseline = n3;
                    ((Constraint)object).layout.bottomToBottom = -1;
                    ((Constraint)object).layout.bottomToTop = -1;
                    ((Constraint)object).layout.topToTop = -1;
                    ((Constraint)object).layout.topToBottom = -1;
                    break;
                }
                case 4: {
                    if (n4 == 4) {
                        ((Constraint)object).layout.bottomToBottom = n3;
                        ((Constraint)object).layout.bottomToTop = -1;
                        ((Constraint)object).layout.baselineToBaseline = -1;
                        break;
                    }
                    if (n4 != 3) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.sideToString(n4));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((Constraint)object).layout.bottomToTop = n3;
                    ((Constraint)object).layout.bottomToBottom = -1;
                    ((Constraint)object).layout.baselineToBaseline = -1;
                    break;
                }
                case 3: {
                    if (n4 == 3) {
                        ((Constraint)object).layout.topToTop = n3;
                        ((Constraint)object).layout.topToBottom = -1;
                        ((Constraint)object).layout.baselineToBaseline = -1;
                        break;
                    }
                    if (n4 != 4) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.sideToString(n4));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((Constraint)object).layout.topToBottom = n3;
                    ((Constraint)object).layout.topToTop = -1;
                    ((Constraint)object).layout.baselineToBaseline = -1;
                    break;
                }
                case 2: {
                    if (n4 == 1) {
                        ((Constraint)object).layout.rightToLeft = n3;
                        ((Constraint)object).layout.rightToRight = -1;
                        break;
                    }
                    if (n4 != 2) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("right to ");
                        ((StringBuilder)object).append(this.sideToString(n4));
                        ((StringBuilder)object).append(" undefined");
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    ((Constraint)object).layout.rightToRight = n3;
                    ((Constraint)object).layout.rightToLeft = -1;
                    break;
                }
                case 1: {
                    if (n4 == 1) {
                        ((Constraint)object).layout.leftToLeft = n3;
                        ((Constraint)object).layout.leftToRight = -1;
                        break;
                    }
                    if (n4 != 2) break block22;
                    ((Constraint)object).layout.leftToRight = n3;
                    ((Constraint)object).layout.leftToLeft = -1;
                }
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("left to ");
        ((StringBuilder)object).append(this.sideToString(n4));
        ((StringBuilder)object).append(" undefined");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    /*
     * Enabled force condition propagation
     */
    public void connect(int n, int n2, int n3, int n4, int n5) {
        Object object;
        block31: {
            block30: {
                block29: {
                    if (!this.mConstraints.containsKey(n)) {
                        this.mConstraints.put(n, new Constraint());
                    }
                    object = this.mConstraints.get(n);
                    switch (n2) {
                        default: {
                            object = new StringBuilder();
                            ((StringBuilder)object).append(this.sideToString(n2));
                            ((StringBuilder)object).append(" to ");
                            ((StringBuilder)object).append(this.sideToString(n4));
                            ((StringBuilder)object).append(" unknown");
                            throw new IllegalArgumentException(((StringBuilder)object).toString());
                        }
                        case 7: {
                            if (n4 == 7) {
                                ((Constraint)object).layout.endToEnd = n3;
                                ((Constraint)object).layout.endToStart = -1;
                            } else {
                                if (n4 != 6) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("right to ");
                                    ((StringBuilder)object).append(this.sideToString(n4));
                                    ((StringBuilder)object).append(" undefined");
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                ((Constraint)object).layout.endToStart = n3;
                                ((Constraint)object).layout.endToEnd = -1;
                            }
                            ((Constraint)object).layout.endMargin = n5;
                            return;
                        }
                        case 6: {
                            if (n4 == 6) {
                                ((Constraint)object).layout.startToStart = n3;
                                ((Constraint)object).layout.startToEnd = -1;
                            } else {
                                if (n4 != 7) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("right to ");
                                    ((StringBuilder)object).append(this.sideToString(n4));
                                    ((StringBuilder)object).append(" undefined");
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                ((Constraint)object).layout.startToEnd = n3;
                                ((Constraint)object).layout.startToStart = -1;
                            }
                            ((Constraint)object).layout.startMargin = n5;
                            return;
                        }
                        case 5: {
                            if (n4 == 5) {
                                ((Constraint)object).layout.baselineToBaseline = n3;
                                ((Constraint)object).layout.bottomToBottom = -1;
                                ((Constraint)object).layout.bottomToTop = -1;
                                ((Constraint)object).layout.topToTop = -1;
                                ((Constraint)object).layout.topToBottom = -1;
                                return;
                            }
                            object = new StringBuilder();
                            ((StringBuilder)object).append("right to ");
                            ((StringBuilder)object).append(this.sideToString(n4));
                            ((StringBuilder)object).append(" undefined");
                            throw new IllegalArgumentException(((StringBuilder)object).toString());
                        }
                        case 4: {
                            if (n4 == 4) {
                                ((Constraint)object).layout.bottomToBottom = n3;
                                ((Constraint)object).layout.bottomToTop = -1;
                                ((Constraint)object).layout.baselineToBaseline = -1;
                            } else {
                                if (n4 != 3) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("right to ");
                                    ((StringBuilder)object).append(this.sideToString(n4));
                                    ((StringBuilder)object).append(" undefined");
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                ((Constraint)object).layout.bottomToTop = n3;
                                ((Constraint)object).layout.bottomToBottom = -1;
                                ((Constraint)object).layout.baselineToBaseline = -1;
                            }
                            ((Constraint)object).layout.bottomMargin = n5;
                            return;
                        }
                        case 3: {
                            if (n4 == 3) {
                                ((Constraint)object).layout.topToTop = n3;
                                ((Constraint)object).layout.topToBottom = -1;
                                ((Constraint)object).layout.baselineToBaseline = -1;
                            } else {
                                if (n4 != 4) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("right to ");
                                    ((StringBuilder)object).append(this.sideToString(n4));
                                    ((StringBuilder)object).append(" undefined");
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                ((Constraint)object).layout.topToBottom = n3;
                                ((Constraint)object).layout.topToTop = -1;
                                ((Constraint)object).layout.baselineToBaseline = -1;
                            }
                            ((Constraint)object).layout.topMargin = n5;
                            return;
                        }
                        case 2: {
                            if (n4 == 1) {
                                ((Constraint)object).layout.rightToLeft = n3;
                                ((Constraint)object).layout.rightToRight = -1;
                            } else {
                                if (n4 != 2) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("right to ");
                                    ((StringBuilder)object).append(this.sideToString(n4));
                                    ((StringBuilder)object).append(" undefined");
                                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                                }
                                ((Constraint)object).layout.rightToRight = n3;
                                ((Constraint)object).layout.rightToLeft = -1;
                            }
                            ((Constraint)object).layout.rightMargin = n5;
                            return;
                        }
                        case 1: 
                    }
                    if (n4 != 1) break block29;
                    ((Constraint)object).layout.leftToLeft = n3;
                    ((Constraint)object).layout.leftToRight = -1;
                    break block30;
                }
                if (n4 != 2) break block31;
                ((Constraint)object).layout.leftToRight = n3;
                ((Constraint)object).layout.leftToLeft = -1;
            }
            ((Constraint)object).layout.leftMargin = n5;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Left to ");
        ((StringBuilder)object).append(this.sideToString(n4));
        ((StringBuilder)object).append(" undefined");
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public void constrainCircle(int n, int n2, int n3, float f) {
        Constraint constraint = this.get(n);
        constraint.layout.circleConstraint = n2;
        constraint.layout.circleRadius = n3;
        constraint.layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int n, int n2) {
        this.get((int)n).layout.heightDefault = n2;
    }

    public void constrainDefaultWidth(int n, int n2) {
        this.get((int)n).layout.widthDefault = n2;
    }

    public void constrainHeight(int n, int n2) {
        this.get((int)n).layout.mHeight = n2;
    }

    public void constrainMaxHeight(int n, int n2) {
        this.get((int)n).layout.heightMax = n2;
    }

    public void constrainMaxWidth(int n, int n2) {
        this.get((int)n).layout.widthMax = n2;
    }

    public void constrainMinHeight(int n, int n2) {
        this.get((int)n).layout.heightMin = n2;
    }

    public void constrainMinWidth(int n, int n2) {
        this.get((int)n).layout.widthMin = n2;
    }

    public void constrainPercentHeight(int n, float f) {
        this.get((int)n).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int n, float f) {
        this.get((int)n).layout.widthPercent = f;
    }

    public void constrainWidth(int n, int n2) {
        this.get((int)n).layout.mWidth = n2;
    }

    public void constrainedHeight(int n, boolean bl) {
        this.get((int)n).layout.constrainedHeight = bl;
    }

    public void constrainedWidth(int n, boolean bl) {
        this.get((int)n).layout.constrainedWidth = bl;
    }

    public void create(int n, int n2) {
        Constraint constraint = this.get(n);
        constraint.layout.mIsGuideline = true;
        constraint.layout.orientation = n2;
    }

    public void createBarrier(int n, int n2, int n3, int ... nArray) {
        Constraint constraint = this.get(n);
        constraint.layout.mHelperType = 1;
        constraint.layout.mBarrierDirection = n2;
        constraint.layout.mBarrierMargin = n3;
        constraint.layout.mIsGuideline = false;
        constraint.layout.mReferenceIds = nArray;
    }

    public void createHorizontalChain(int n, int n2, int n3, int n4, int[] nArray, float[] fArray, int n5) {
        this.createHorizontalChain(n, n2, n3, n4, nArray, fArray, n5, 1, 2);
    }

    public void createHorizontalChainRtl(int n, int n2, int n3, int n4, int[] nArray, float[] fArray, int n5) {
        this.createHorizontalChain(n, n2, n3, n4, nArray, fArray, n5, 6, 7);
    }

    public void createVerticalChain(int n, int n2, int n3, int n4, int[] object, float[] fArray, int n5) {
        if (((int[])object).length < 2) {
            object = new IllegalArgumentException("must have 2 or more widgets in a chain");
            throw object;
        }
        if (fArray != null) {
            if (fArray.length != ((int[])object).length) throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArray != null) {
            this.get((int)object[0]).layout.verticalWeight = fArray[0];
        }
        this.get((int)object[0]).layout.verticalChainStyle = n5;
        this.connect(object[0], 3, n, n2, 0);
        n = 1;
        while (true) {
            if (n >= ((int[])object).length) {
                this.connect(object[((int[])object).length - 1], 4, n3, n4, 0);
                return;
            }
            n2 = object[n];
            n5 = object[n];
            n2 = n - 1;
            this.connect(n5, 3, object[n2], 4, 0);
            this.connect(object[n2], 4, object[n], 3, 0);
            if (fArray != null) {
                this.get((int)object[n]).layout.verticalWeight = fArray[n];
            }
            ++n;
        }
    }

    public void dump(MotionScene motionScene, int ... object) {
        int n;
        Object object2;
        Object object3 = this.mConstraints.keySet();
        int n2 = ((int[])object).length;
        int n3 = 0;
        if (n2 != 0) {
            object2 = new HashSet();
            n = ((int[])object).length;
            n2 = 0;
            while (true) {
                object3 = object2;
                if (n2 < n) {
                    ((HashSet)object2).add((int)object[n2]);
                    ++n2;
                    continue;
                }
                break;
            }
        } else {
            object3 = new HashSet<Integer>((Collection<Integer>)object3);
        }
        object2 = System.out;
        object = new StringBuilder();
        ((StringBuilder)object).append(((HashSet)object3).size());
        ((StringBuilder)object).append(" constraints");
        ((PrintStream)object2).println(((StringBuilder)object).toString());
        object = new StringBuilder();
        Integer[] integerArray = ((AbstractCollection)object3).toArray(new Integer[0]);
        n = integerArray.length;
        n2 = n3;
        while (true) {
            if (n2 >= n) {
                System.out.println(((StringBuilder)object).toString());
                return;
            }
            object2 = integerArray[n2];
            object3 = this.mConstraints.get(object2);
            ((StringBuilder)object).append("<Constraint id=");
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append(" \n");
            ((Constraint)object3).layout.dump(motionScene, (StringBuilder)object);
            ((StringBuilder)object).append("/>\n");
            ++n2;
        }
    }

    public boolean getApplyElevation(int n) {
        return this.get((int)n).transform.applyElevation;
    }

    public Constraint getConstraint(int n) {
        if (!this.mConstraints.containsKey(n)) return null;
        return this.mConstraints.get(n);
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int n) {
        return this.get((int)n).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] integerArray = this.mConstraints.keySet();
        int n = 0;
        integerArray = integerArray.toArray(new Integer[0]);
        int n2 = integerArray.length;
        int[] nArray = new int[n2];
        while (n < n2) {
            nArray[n] = integerArray[n];
            ++n;
        }
        return nArray;
    }

    public Constraint getParameters(int n) {
        return this.get(n);
    }

    public int[] getReferencedIds(int n) {
        Constraint constraint = this.get(n);
        if (constraint.layout.mReferenceIds != null) return Arrays.copyOf(constraint.layout.mReferenceIds, constraint.layout.mReferenceIds.length);
        return new int[0];
    }

    public int getVisibility(int n) {
        return this.get((int)n).propertySet.visibility;
    }

    public int getVisibilityMode(int n) {
        return this.get((int)n).propertySet.mVisibilityMode;
    }

    public int getWidth(int n) {
        return this.get((int)n).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int n) {
        XmlResourceParser xmlResourceParser = context.getResources().getXml(n);
        try {
            n = xmlResourceParser.getEventType();
            while (n != 1) {
                if (n != 0) {
                    if (n == 2) {
                        String string = xmlResourceParser.getName();
                        Constraint constraint = this.fillFromAttributeList(context, Xml.asAttributeSet((XmlPullParser)xmlResourceParser));
                        if (string.equalsIgnoreCase("Guideline")) {
                            constraint.layout.mIsGuideline = true;
                        }
                        this.mConstraints.put(constraint.mViewId, constraint);
                    }
                } else {
                    xmlResourceParser.getName();
                }
                n = xmlResourceParser.next();
            }
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (XmlPullParserException xmlPullParserException) {
            xmlPullParserException.printStackTrace();
        }
    }

    /*
     * Exception decompiling
     */
    public void load(Context var1_1, XmlPullParser var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [14[CASE]], but top level block is 1[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void parseColorAttributes(Constraint constraint, String stringArray) {
        stringArray = stringArray.split(",");
        int n = 0;
        while (n < stringArray.length) {
            Object object = stringArray[n].split("=");
            if (((String[])object).length != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" Unable to parse ");
                ((StringBuilder)object).append(stringArray[n]);
                Log.w((String)"ConstraintSet", (String)((StringBuilder)object).toString());
            } else {
                Constraint.access$600((Constraint)constraint, (String)object[0], (int)Color.parseColor((String)object[1]));
            }
            ++n;
        }
    }

    public void parseFloatAttributes(Constraint constraint, String stringArray) {
        stringArray = stringArray.split(",");
        int n = 0;
        while (n < stringArray.length) {
            Object object = stringArray[n].split("=");
            if (((String[])object).length != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" Unable to parse ");
                ((StringBuilder)object).append(stringArray[n]);
                Log.w((String)"ConstraintSet", (String)((StringBuilder)object).toString());
            } else {
                Constraint.access$700((Constraint)constraint, (String)object[0], (float)Float.parseFloat((String)object[1]));
            }
            ++n;
        }
    }

    public void parseIntAttributes(Constraint constraint, String stringArray) {
        stringArray = stringArray.split(",");
        int n = 0;
        while (n < stringArray.length) {
            Object object = stringArray[n].split("=");
            if (((String[])object).length != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" Unable to parse ");
                ((StringBuilder)object).append(stringArray[n]);
                Log.w((String)"ConstraintSet", (String)((StringBuilder)object).toString());
            } else {
                Constraint.access$700((Constraint)constraint, (String)object[0], (float)Integer.decode((String)object[1]).intValue());
            }
            ++n;
        }
    }

    public void parseStringAttributes(Constraint constraint, String stringArray) {
        String[] stringArray2 = ConstraintSet.splitString((String)stringArray);
        int n = 0;
        while (n < stringArray2.length) {
            stringArray = stringArray2[n].split("=");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" Unable to parse ");
            stringBuilder.append(stringArray2[n]);
            Log.w((String)"ConstraintSet", (String)stringBuilder.toString());
            Constraint.access$800((Constraint)constraint, (String)stringArray[0], (String)stringArray[1]);
            ++n;
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int n = constraintLayout.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = constraintLayout.getChildAt(n2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)view.getLayoutParams();
            int n3 = view.getId();
            if (this.mForceId) {
                if (n3 == -1) throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(n3)) {
                this.mConstraints.put(n3, new Constraint());
            }
            Constraint constraint = this.mConstraints.get(n3);
            if (!constraint.layout.mApply) {
                Constraint.access$000((Constraint)constraint, (int)n3, (ConstraintLayout.LayoutParams)layoutParams);
                if (view instanceof ConstraintHelper) {
                    constraint.layout.mReferenceIds = ((ConstraintHelper)view).getReferencedIds();
                    if (view instanceof Barrier) {
                        layoutParams = (Barrier)view;
                        constraint.layout.mBarrierAllowsGoneWidgets = layoutParams.allowsGoneWidget();
                        constraint.layout.mBarrierDirection = layoutParams.getType();
                        constraint.layout.mBarrierMargin = layoutParams.getMargin();
                    }
                }
                constraint.layout.mApply = true;
            }
            if (!constraint.propertySet.mApply) {
                constraint.propertySet.visibility = view.getVisibility();
                constraint.propertySet.alpha = view.getAlpha();
                constraint.propertySet.mApply = true;
            }
            if (Build.VERSION.SDK_INT >= 17 && !constraint.transform.mApply) {
                constraint.transform.mApply = true;
                constraint.transform.rotation = view.getRotation();
                constraint.transform.rotationX = view.getRotationX();
                constraint.transform.rotationY = view.getRotationY();
                constraint.transform.scaleX = view.getScaleX();
                constraint.transform.scaleY = view.getScaleY();
                float f = view.getPivotX();
                float f2 = view.getPivotY();
                if ((double)f != 0.0 || (double)f2 != 0.0) {
                    constraint.transform.transformPivotX = f;
                    constraint.transform.transformPivotY = f2;
                }
                constraint.transform.translationX = view.getTranslationX();
                constraint.transform.translationY = view.getTranslationY();
                if (Build.VERSION.SDK_INT >= 21) {
                    constraint.transform.translationZ = view.getTranslationZ();
                    if (constraint.transform.applyElevation) {
                        constraint.transform.elevation = view.getElevation();
                    }
                }
            }
            ++n2;
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        Iterator<Integer> iterator = constraintSet.mConstraints.keySet().iterator();
        block0: while (iterator.hasNext()) {
            Integer n = iterator.next();
            int n2 = n;
            Constraint constraint = constraintSet.mConstraints.get(n);
            if (!this.mConstraints.containsKey(n2)) {
                this.mConstraints.put(n2, new Constraint());
            }
            n = this.mConstraints.get(n2);
            if (!((Constraint)n).layout.mApply) {
                ((Constraint)n).layout.copyFrom(constraint.layout);
            }
            if (!((Constraint)n).propertySet.mApply) {
                ((Constraint)n).propertySet.copyFrom(constraint.propertySet);
            }
            if (!((Constraint)n).transform.mApply) {
                ((Constraint)n).transform.copyFrom(constraint.transform);
            }
            if (!((Constraint)n).motion.mApply) {
                ((Constraint)n).motion.copyFrom(constraint.motion);
            }
            Iterator iterator2 = constraint.mCustomConstraints.keySet().iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block0;
                String string = (String)iterator2.next();
                if (((Constraint)n).mCustomConstraints.containsKey(string)) continue;
                ((Constraint)n).mCustomConstraints.put(string, constraint.mCustomConstraints.get(string));
            }
            break;
        }
        return;
    }

    public void removeAttribute(String string) {
        this.mSavedAttributes.remove(string);
    }

    public void removeFromHorizontalChain(int n) {
        if (!this.mConstraints.containsKey(n)) return;
        Constraint constraint = this.mConstraints.get(n);
        int n2 = constraint.layout.leftToRight;
        int n3 = constraint.layout.rightToLeft;
        if (n2 == -1 && n3 == -1) {
            int n4 = constraint.layout.startToEnd;
            n3 = constraint.layout.endToStart;
            if (n4 != -1 || n3 != -1) {
                if (n4 != -1 && n3 != -1) {
                    this.connect(n4, 7, n3, 6, 0);
                    this.connect(n3, 6, n2, 7, 0);
                } else if (n2 != -1 || n3 != -1) {
                    if (constraint.layout.rightToRight != -1) {
                        this.connect(n2, 7, constraint.layout.rightToRight, 7, 0);
                    } else if (constraint.layout.leftToLeft != -1) {
                        this.connect(n3, 6, constraint.layout.leftToLeft, 6, 0);
                    }
                }
            }
            this.clear(n, 6);
            this.clear(n, 7);
        } else {
            if (n2 != -1 && n3 != -1) {
                this.connect(n2, 2, n3, 1, 0);
                this.connect(n3, 1, n2, 2, 0);
            } else if (n2 != -1 || n3 != -1) {
                if (constraint.layout.rightToRight != -1) {
                    this.connect(n2, 2, constraint.layout.rightToRight, 2, 0);
                } else if (constraint.layout.leftToLeft != -1) {
                    this.connect(n3, 1, constraint.layout.leftToLeft, 1, 0);
                }
            }
            this.clear(n, 1);
            this.clear(n, 2);
        }
    }

    public void removeFromVerticalChain(int n) {
        if (this.mConstraints.containsKey(n)) {
            Constraint constraint = this.mConstraints.get(n);
            int n2 = constraint.layout.topToBottom;
            int n3 = constraint.layout.bottomToTop;
            if (n2 != -1 || n3 != -1) {
                if (n2 != -1 && n3 != -1) {
                    this.connect(n2, 4, n3, 3, 0);
                    this.connect(n3, 3, n2, 4, 0);
                } else if (n2 != -1 || n3 != -1) {
                    if (constraint.layout.bottomToBottom != -1) {
                        this.connect(n2, 4, constraint.layout.bottomToBottom, 4, 0);
                    } else if (constraint.layout.topToTop != -1) {
                        this.connect(n3, 3, constraint.layout.topToTop, 3, 0);
                    }
                }
            }
        }
        this.clear(n, 3);
        this.clear(n, 4);
    }

    public void setAlpha(int n, float f) {
        this.get((int)n).propertySet.alpha = f;
    }

    public void setApplyElevation(int n, boolean bl) {
        if (Build.VERSION.SDK_INT < 21) return;
        this.get((int)n).transform.applyElevation = bl;
    }

    public void setBarrierType(int n, int n2) {
        this.get((int)n).layout.mHelperType = n2;
    }

    public void setColorValue(int n, String string, int n2) {
        Constraint.access$600((Constraint)this.get(n), (String)string, (int)n2);
    }

    public void setDimensionRatio(int n, String string) {
        this.get((int)n).layout.dimensionRatio = string;
    }

    public void setEditorAbsoluteX(int n, int n2) {
        this.get((int)n).layout.editorAbsoluteX = n2;
    }

    public void setEditorAbsoluteY(int n, int n2) {
        this.get((int)n).layout.editorAbsoluteY = n2;
    }

    public void setElevation(int n, float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        this.get((int)n).transform.elevation = f;
        this.get((int)n).transform.applyElevation = true;
    }

    public void setFloatValue(int n, String string, float f) {
        Constraint.access$700((Constraint)this.get(n), (String)string, (float)f);
    }

    public void setForceId(boolean bl) {
        this.mForceId = bl;
    }

    public void setGoneMargin(int n, int n2, int n3) {
        Constraint constraint = this.get(n);
        switch (n2) {
            default: {
                throw new IllegalArgumentException("unknown constraint");
            }
            case 7: {
                constraint.layout.goneEndMargin = n3;
                break;
            }
            case 6: {
                constraint.layout.goneStartMargin = n3;
                break;
            }
            case 5: {
                throw new IllegalArgumentException("baseline does not support margins");
            }
            case 4: {
                constraint.layout.goneBottomMargin = n3;
                break;
            }
            case 3: {
                constraint.layout.goneTopMargin = n3;
                break;
            }
            case 2: {
                constraint.layout.goneRightMargin = n3;
                break;
            }
            case 1: {
                constraint.layout.goneLeftMargin = n3;
            }
        }
    }

    public void setGuidelineBegin(int n, int n2) {
        this.get((int)n).layout.guideBegin = n2;
        this.get((int)n).layout.guideEnd = -1;
        this.get((int)n).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int n, int n2) {
        this.get((int)n).layout.guideEnd = n2;
        this.get((int)n).layout.guideBegin = -1;
        this.get((int)n).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int n, float f) {
        this.get((int)n).layout.guidePercent = f;
        this.get((int)n).layout.guideEnd = -1;
        this.get((int)n).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int n, float f) {
        this.get((int)n).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int n, int n2) {
        this.get((int)n).layout.horizontalChainStyle = n2;
    }

    public void setHorizontalWeight(int n, float f) {
        this.get((int)n).layout.horizontalWeight = f;
    }

    public void setIntValue(int n, String string, int n2) {
        Constraint.access$500((Constraint)this.get(n), (String)string, (int)n2);
    }

    public void setMargin(int n, int n2, int n3) {
        Constraint constraint = this.get(n);
        switch (n2) {
            default: {
                throw new IllegalArgumentException("unknown constraint");
            }
            case 7: {
                constraint.layout.endMargin = n3;
                break;
            }
            case 6: {
                constraint.layout.startMargin = n3;
                break;
            }
            case 5: {
                throw new IllegalArgumentException("baseline does not support margins");
            }
            case 4: {
                constraint.layout.bottomMargin = n3;
                break;
            }
            case 3: {
                constraint.layout.topMargin = n3;
                break;
            }
            case 2: {
                constraint.layout.rightMargin = n3;
                break;
            }
            case 1: {
                constraint.layout.leftMargin = n3;
            }
        }
    }

    public void setReferencedIds(int n, int ... nArray) {
        this.get((int)n).layout.mReferenceIds = nArray;
    }

    public void setRotation(int n, float f) {
        this.get((int)n).transform.rotation = f;
    }

    public void setRotationX(int n, float f) {
        this.get((int)n).transform.rotationX = f;
    }

    public void setRotationY(int n, float f) {
        this.get((int)n).transform.rotationY = f;
    }

    public void setScaleX(int n, float f) {
        this.get((int)n).transform.scaleX = f;
    }

    public void setScaleY(int n, float f) {
        this.get((int)n).transform.scaleY = f;
    }

    public void setStringValue(int n, String string, String string2) {
        Constraint.access$800((Constraint)this.get(n), (String)string, (String)string2);
    }

    public void setTransformPivot(int n, float f, float f2) {
        Constraint constraint = this.get(n);
        constraint.transform.transformPivotY = f2;
        constraint.transform.transformPivotX = f;
    }

    public void setTransformPivotX(int n, float f) {
        this.get((int)n).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int n, float f) {
        this.get((int)n).transform.transformPivotY = f;
    }

    public void setTranslation(int n, float f, float f2) {
        Constraint constraint = this.get(n);
        constraint.transform.translationX = f;
        constraint.transform.translationY = f2;
    }

    public void setTranslationX(int n, float f) {
        this.get((int)n).transform.translationX = f;
    }

    public void setTranslationY(int n, float f) {
        this.get((int)n).transform.translationY = f;
    }

    public void setTranslationZ(int n, float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        this.get((int)n).transform.translationZ = f;
    }

    public void setValidateOnParse(boolean bl) {
        this.mValidate = bl;
    }

    public void setVerticalBias(int n, float f) {
        this.get((int)n).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int n, int n2) {
        this.get((int)n).layout.verticalChainStyle = n2;
    }

    public void setVerticalWeight(int n, float f) {
        this.get((int)n).layout.verticalWeight = f;
    }

    public void setVisibility(int n, int n2) {
        this.get((int)n).propertySet.visibility = n2;
    }

    public void setVisibilityMode(int n, int n2) {
        this.get((int)n).propertySet.mVisibilityMode = n2;
    }
}
