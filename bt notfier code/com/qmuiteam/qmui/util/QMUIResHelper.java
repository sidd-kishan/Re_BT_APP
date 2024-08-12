/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils$TruncateAt
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.widget.TextView
 *  androidx.core.content.ContextCompat
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUIDisplayHelper
 *  com.qmuiteam.qmui.util.QMUIDrawableHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 */
package com.qmuiteam.qmui.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIDrawableHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;

public class QMUIResHelper {
    public static void assignTextViewWithAttr(TextView textView, int n) {
        TypedArray typedArray = textView.getContext().obtainStyledAttributes(null, R.styleable.QMUITextCommonStyleDef, n, 0);
        int n2 = typedArray.getIndexCount();
        int n3 = textView.getPaddingLeft();
        int n4 = textView.getPaddingRight();
        int n5 = textView.getPaddingTop();
        int n6 = textView.getPaddingBottom();
        n = 0;
        while (true) {
            int n7;
            int n8;
            int n9;
            int n10;
            if (n >= n2) {
                textView.setPadding(n3, n5, n4, n6);
                typedArray.recycle();
                return;
            }
            int n11 = typedArray.getIndex(n);
            if (n11 == R.styleable.QMUITextCommonStyleDef_android_gravity) {
                textView.setGravity(typedArray.getInt(n11, -1));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_textColor) {
                textView.setTextColor(typedArray.getColorStateList(n11));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_textSize) {
                textView.setTextSize(0, (float)typedArray.getDimensionPixelSize(n11, 0));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_paddingLeft) {
                n10 = typedArray.getDimensionPixelSize(n11, 0);
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_paddingRight) {
                n9 = typedArray.getDimensionPixelSize(n11, 0);
                n10 = n3;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_paddingTop) {
                n8 = typedArray.getDimensionPixelSize(n11, 0);
                n10 = n3;
                n9 = n4;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_paddingBottom) {
                n7 = typedArray.getDimensionPixelSize(n11, 0);
                n10 = n3;
                n9 = n4;
                n8 = n5;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_singleLine) {
                textView.setSingleLine(typedArray.getBoolean(n11, false));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_ellipsize) {
                n10 = typedArray.getInt(n11, 3);
                if (n10 != 1) {
                    if (n10 != 2) {
                        if (n10 != 3) {
                            if (n10 != 4) {
                                n10 = n3;
                                n9 = n4;
                                n8 = n5;
                                n7 = n6;
                            } else {
                                textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                n10 = n3;
                                n9 = n4;
                                n8 = n5;
                                n7 = n6;
                            }
                        } else {
                            textView.setEllipsize(TextUtils.TruncateAt.END);
                            n10 = n3;
                            n9 = n4;
                            n8 = n5;
                            n7 = n6;
                        }
                    } else {
                        textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                        n10 = n3;
                        n9 = n4;
                        n8 = n5;
                        n7 = n6;
                    }
                } else {
                    textView.setEllipsize(TextUtils.TruncateAt.START);
                    n10 = n3;
                    n9 = n4;
                    n8 = n5;
                    n7 = n6;
                }
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_maxLines) {
                textView.setMaxLines(typedArray.getInt(n11, -1));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_background) {
                QMUIViewHelper.setBackgroundKeepingPadding((View)textView, (Drawable)typedArray.getDrawable(n11));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_lineSpacingExtra) {
                textView.setLineSpacing((float)typedArray.getDimensionPixelSize(n11, 0), 1.0f);
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_drawablePadding) {
                textView.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(n11, 0));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else if (n11 == R.styleable.QMUITextCommonStyleDef_android_textColorHint) {
                textView.setHintTextColor(typedArray.getColor(n11, 0));
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
            } else {
                n10 = n3;
                n9 = n4;
                n8 = n5;
                n7 = n6;
                if (n11 == R.styleable.QMUITextCommonStyleDef_android_textStyle) {
                    textView.setTypeface(null, typedArray.getInt(n11, -1));
                    n7 = n6;
                    n8 = n5;
                    n9 = n4;
                    n10 = n3;
                }
            }
            ++n;
            n3 = n10;
            n4 = n9;
            n5 = n8;
            n6 = n7;
        }
    }

    public static int getAttrColor(Context context, int n) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.data;
    }

    public static ColorStateList getAttrColorStateList(Context context, int n) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n, typedValue, true);
        return ContextCompat.getColorStateList((Context)context, (int)typedValue.resourceId);
    }

    public static int getAttrDimen(Context context, int n) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n, typedValue, true);
        return TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)QMUIDisplayHelper.getDisplayMetrics((Context)context));
    }

    public static Drawable getAttrDrawable(Context context, int n) {
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{n});
        context = QMUIResHelper.getAttrDrawable(context, typedArray, 0);
        typedArray.recycle();
        return context;
    }

    public static Drawable getAttrDrawable(Context context, TypedArray object, int n) {
        if ((object = object.peekValue(n)) == null) return null;
        if (object.type == 2) return null;
        if (object.resourceId == 0) return null;
        return QMUIDrawableHelper.getVectorDrawable((Context)context, (int)object.resourceId);
    }

    public static float getAttrFloatValue(Context context, int n) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(n, typedValue, true);
        return typedValue.getFloat();
    }
}
