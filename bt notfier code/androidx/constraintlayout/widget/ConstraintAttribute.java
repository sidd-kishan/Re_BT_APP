/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.Xml
 *  android.view.View
 *  androidx.constraintlayout.widget.ConstraintAttribute$1
 *  androidx.constraintlayout.widget.ConstraintAttribute$AttributeType
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute {
    private static final String TAG = "TransitionLayout";
    boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    String mName;
    private String mStringValue;
    private AttributeType mType;

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object object) {
        this.mName = constraintAttribute.mName;
        this.mType = constraintAttribute.mType;
        this.setValue(object);
    }

    public ConstraintAttribute(String string, AttributeType attributeType) {
        this.mName = string;
        this.mType = attributeType;
    }

    public ConstraintAttribute(String string, AttributeType attributeType, Object object) {
        this.mName = string;
        this.mType = attributeType;
        this.setValue(object);
    }

    private static int clamp(int n) {
        n = (n & ~(n >> 31)) - 255;
        return (n & n >> 31) + 255;
    }

    public static HashMap<String, ConstraintAttribute> extractAttributes(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<String, ConstraintAttribute>();
        Class<?> clazz = view.getClass();
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            ConstraintAttribute constraintAttribute = hashMap.get(string);
            try {
                Object object;
                if (string.equals("BackgroundColor")) {
                    int n = ((ColorDrawable)view.getBackground()).getColor();
                    object = new ConstraintAttribute(constraintAttribute, n);
                    hashMap2.put(string, (ConstraintAttribute)object);
                    continue;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("getMap");
                ((StringBuilder)object).append(string);
                Object object2 = clazz.getMethod(((StringBuilder)object).toString(), new Class[0]).invoke(view, new Object[0]);
                object = new ConstraintAttribute(constraintAttribute, object2);
                hashMap2.put(string, (ConstraintAttribute)object);
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void parse(Context context, XmlPullParser object, HashMap<String, ConstraintAttribute> hashMap) {
        TypedArray typedArray = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)object), R.styleable.CustomAttribute);
        int n = typedArray.getIndexCount();
        Object object2 = null;
        Boolean bl = null;
        AttributeType attributeType = null;
        for (int i = 0; i < n; ++i) {
            Object object3;
            Object object4;
            block9: {
                block12: {
                    int n2;
                    block17: {
                        block16: {
                            block15: {
                                block14: {
                                    block13: {
                                        block11: {
                                            block10: {
                                                block8: {
                                                    n2 = typedArray.getIndex(i);
                                                    if (n2 != R.styleable.CustomAttribute_attributeName) break block8;
                                                    object = object2 = typedArray.getString(n2);
                                                    object4 = bl;
                                                    object3 = attributeType;
                                                    if (object2 != null) {
                                                        object = object2;
                                                        object4 = bl;
                                                        object3 = attributeType;
                                                        if (((String)object2).length() > 0) {
                                                            object = new StringBuilder();
                                                            ((StringBuilder)object).append(Character.toUpperCase(((String)object2).charAt(0)));
                                                            ((StringBuilder)object).append(((String)object2).substring(1));
                                                            object = ((StringBuilder)object).toString();
                                                            object4 = bl;
                                                            object3 = attributeType;
                                                        }
                                                    }
                                                    break block9;
                                                }
                                                if (n2 != R.styleable.CustomAttribute_customBoolean) break block10;
                                                object4 = typedArray.getBoolean(n2, false);
                                                object3 = AttributeType.BOOLEAN_TYPE;
                                                object = object2;
                                                break block9;
                                            }
                                            if (n2 != R.styleable.CustomAttribute_customColorValue) break block11;
                                            object = AttributeType.COLOR_TYPE;
                                            object4 = typedArray.getColor(n2, 0);
                                            break block12;
                                        }
                                        if (n2 != R.styleable.CustomAttribute_customColorDrawableValue) break block13;
                                        object = AttributeType.COLOR_DRAWABLE_TYPE;
                                        object4 = typedArray.getColor(n2, 0);
                                        break block12;
                                    }
                                    if (n2 != R.styleable.CustomAttribute_customPixelDimension) break block14;
                                    object = AttributeType.DIMENSION_TYPE;
                                    object4 = Float.valueOf(TypedValue.applyDimension((int)1, (float)typedArray.getDimension(n2, 0.0f), (DisplayMetrics)context.getResources().getDisplayMetrics()));
                                    break block12;
                                }
                                if (n2 != R.styleable.CustomAttribute_customDimension) break block15;
                                object = AttributeType.DIMENSION_TYPE;
                                object4 = Float.valueOf(typedArray.getDimension(n2, 0.0f));
                                break block12;
                            }
                            if (n2 != R.styleable.CustomAttribute_customFloatValue) break block16;
                            object = AttributeType.FLOAT_TYPE;
                            object4 = Float.valueOf(typedArray.getFloat(n2, Float.NaN));
                            break block12;
                        }
                        if (n2 != R.styleable.CustomAttribute_customIntegerValue) break block17;
                        object = AttributeType.INT_TYPE;
                        object4 = typedArray.getInteger(n2, -1);
                        break block12;
                    }
                    object = object2;
                    object4 = bl;
                    object3 = attributeType;
                    if (n2 != R.styleable.CustomAttribute_customStringValue) break block9;
                    object = AttributeType.STRING_TYPE;
                    object4 = typedArray.getString(n2);
                }
                object3 = object;
                object = object2;
            }
            object2 = object;
            bl = object4;
            attributeType = object3;
        }
        if (object2 != null && bl != null) {
            hashMap.put((String)object2, new ConstraintAttribute((String)object2, attributeType, bl));
        }
        typedArray.recycle();
    }

    public static void setAttributes(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> clazz = view.getClass();
        Iterator<String> iterator = hashMap.keySet().iterator();
        block13: while (iterator.hasNext()) {
            CharSequence charSequence = iterator.next();
            Object object = hashMap.get(charSequence);
            CharSequence charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("set");
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            try {
                switch (1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[((ConstraintAttribute)object).mType.ordinal()]) {
                    default: {
                        continue block13;
                    }
                    case 7: {
                        clazz.getMethod((String)charSequence2, Float.TYPE).invoke(view, Float.valueOf(((ConstraintAttribute)object).mFloatValue));
                        continue block13;
                    }
                    case 6: {
                        clazz.getMethod((String)charSequence2, Boolean.TYPE).invoke(view, ((ConstraintAttribute)object).mBooleanValue);
                        continue block13;
                    }
                    case 5: {
                        clazz.getMethod((String)charSequence2, CharSequence.class).invoke(view, ((ConstraintAttribute)object).mStringValue);
                        continue block13;
                    }
                    case 4: {
                        clazz.getMethod((String)charSequence2, Float.TYPE).invoke(view, Float.valueOf(((ConstraintAttribute)object).mFloatValue));
                        continue block13;
                    }
                    case 3: {
                        clazz.getMethod((String)charSequence2, Integer.TYPE).invoke(view, ((ConstraintAttribute)object).mIntegerValue);
                        continue block13;
                    }
                    case 2: {
                        Method method = clazz.getMethod((String)charSequence2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(((ConstraintAttribute)object).mColorValue);
                        method.invoke(view, colorDrawable);
                        continue block13;
                    }
                    case 1: 
                }
                clazz.getMethod((String)charSequence2, Integer.TYPE).invoke(view, ((ConstraintAttribute)object).mColorValue);
            }
            catch (InvocationTargetException invocationTargetException) {
                object = new StringBuilder();
                ((StringBuilder)object).append(" Custom Attribute \"");
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append("\" not found on ");
                ((StringBuilder)object).append(clazz.getName());
                Log.e((String)TAG, (String)((StringBuilder)object).toString());
                invocationTargetException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append(" Custom Attribute \"");
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append("\" not found on ");
                ((StringBuilder)charSequence2).append(clazz.getName());
                Log.e((String)TAG, (String)((StringBuilder)charSequence2).toString());
                illegalAccessException.printStackTrace();
            }
            catch (NoSuchMethodException noSuchMethodException) {
                Log.e((String)TAG, (String)noSuchMethodException.getMessage());
                object = new StringBuilder();
                ((StringBuilder)object).append(" Custom Attribute \"");
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append("\" not found on ");
                ((StringBuilder)object).append(clazz.getName());
                Log.e((String)TAG, (String)((StringBuilder)object).toString());
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(clazz.getName());
                ((StringBuilder)charSequence).append(" must have a method ");
                ((StringBuilder)charSequence).append((String)charSequence2);
                Log.e((String)TAG, (String)((StringBuilder)charSequence).toString());
            }
        }
    }

    public boolean diff(ConstraintAttribute constraintAttribute) {
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = bl5;
        if (constraintAttribute == null) return bl7;
        if (this.mType != constraintAttribute.mType) {
            bl7 = bl5;
        } else {
            switch (1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
                default: {
                    return false;
                }
                case 7: {
                    bl7 = bl6;
                    if (this.mFloatValue != constraintAttribute.mFloatValue) return bl7;
                    bl7 = true;
                    return bl7;
                }
                case 6: {
                    bl7 = bl;
                    if (this.mBooleanValue != constraintAttribute.mBooleanValue) return bl7;
                    bl7 = true;
                    return bl7;
                }
                case 5: {
                    bl7 = bl2;
                    if (this.mIntegerValue != constraintAttribute.mIntegerValue) return bl7;
                    bl7 = true;
                    return bl7;
                }
                case 4: {
                    bl7 = bl3;
                    if (this.mFloatValue != constraintAttribute.mFloatValue) return bl7;
                    bl7 = true;
                    return bl7;
                }
                case 3: {
                    bl7 = bl4;
                    if (this.mIntegerValue != constraintAttribute.mIntegerValue) return bl7;
                    bl7 = true;
                    return bl7;
                }
                case 1: 
                case 2: 
            }
            bl7 = bl5;
            if (this.mColorValue != constraintAttribute.mColorValue) return bl7;
            bl7 = true;
        }
        return bl7;
    }

    public AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        switch (1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            default: {
                return Float.NaN;
            }
            case 7: {
                return this.mFloatValue;
            }
            case 6: {
                float f = this.mBooleanValue ? 1.0f : 0.0f;
                return f;
            }
            case 5: {
                throw new RuntimeException("Cannot interpolate String");
            }
            case 4: {
                return this.mFloatValue;
            }
            case 3: {
                return this.mIntegerValue;
            }
            case 1: 
            case 2: 
        }
        throw new RuntimeException("Color does not have a single color to interpolate");
    }

    public void getValuesToInterpolate(float[] fArray) {
        switch (1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            default: {
                break;
            }
            case 7: {
                fArray[0] = this.mFloatValue;
                break;
            }
            case 6: {
                float f = this.mBooleanValue ? 1.0f : 0.0f;
                fArray[0] = f;
                break;
            }
            case 5: {
                throw new RuntimeException("Color does not have a single color to interpolate");
            }
            case 4: {
                fArray[0] = this.mFloatValue;
                break;
            }
            case 3: {
                fArray[0] = this.mIntegerValue;
                break;
            }
            case 1: 
            case 2: {
                int n = this.mColorValue;
                float f = (float)Math.pow((float)(n >> 16 & 0xFF) / 255.0f, 2.2);
                float f2 = (float)Math.pow((float)(n >> 8 & 0xFF) / 255.0f, 2.2);
                float f3 = (float)Math.pow((float)(n & 0xFF) / 255.0f, 2.2);
                fArray[0] = f;
                fArray[1] = f2;
                fArray[2] = f3;
                fArray[3] = (float)(n >> 24 & 0xFF) / 255.0f;
            }
        }
    }

    public int noOfInterpValues() {
        int n = 1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        if (n == 1) return 4;
        if (n == 2) return 4;
        return 1;
    }

    public void setColorValue(int n) {
        this.mColorValue = n;
    }

    public void setFloatValue(float f) {
        this.mFloatValue = f;
    }

    public void setIntValue(int n) {
        this.mIntegerValue = n;
    }

    /*
     * Exception decompiling
     */
    public void setInterpolatedValue(View var1_1, float[] var2_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    public void setStringValue(String string) {
        this.mStringValue = string;
    }

    public void setValue(Object object) {
        switch (1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()]) {
            default: {
                break;
            }
            case 7: {
                this.mFloatValue = ((Float)object).floatValue();
                break;
            }
            case 6: {
                this.mBooleanValue = (Boolean)object;
                break;
            }
            case 5: {
                this.mStringValue = (String)object;
                break;
            }
            case 4: {
                this.mFloatValue = ((Float)object).floatValue();
                break;
            }
            case 3: {
                this.mIntegerValue = (Integer)object;
                break;
            }
            case 1: 
            case 2: {
                this.mColorValue = (Integer)object;
            }
        }
    }

    public void setValue(float[] fArray) {
        int n = 1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType[this.mType.ordinal()];
        boolean bl = false;
        switch (n) {
            default: {
                break;
            }
            case 7: {
                this.mFloatValue = fArray[0];
                break;
            }
            case 6: {
                if ((double)fArray[0] > 0.5) {
                    bl = true;
                }
                this.mBooleanValue = bl;
                break;
            }
            case 5: {
                throw new RuntimeException("Color does not have a single color to interpolate");
            }
            case 4: {
                this.mFloatValue = fArray[0];
                break;
            }
            case 3: {
                this.mIntegerValue = (int)fArray[0];
                break;
            }
            case 1: 
            case 2: {
                this.mColorValue = n = Color.HSVToColor((float[])fArray);
                this.mColorValue = ConstraintAttribute.clamp((int)(fArray[3] * 255.0f)) << 24 | n & 0xFFFFFF;
            }
        }
    }
}
