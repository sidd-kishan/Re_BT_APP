/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.Keyframe
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Xml
 *  android.view.InflateException
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.graphics.PathParser
 *  androidx.core.graphics.PathParser$PathDataNode
 *  androidx.vectordrawable.graphics.drawable.AndroidResources
 *  androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat
 *  androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator
 *  androidx.vectordrawable.graphics.drawable.ArgbEvaluator
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    private AnimatorInflaterCompat() {
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) throws XmlPullParserException, IOException {
        return AnimatorInflaterCompat.createAnimatorFromXml(context, resources, theme, xmlPullParser, Xml.asAttributeSet((XmlPullParser)xmlPullParser), null, 0, f);
    }

    private static Animator createAnimatorFromXml(Context object, Resources object2, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int n, float f) throws XmlPullParserException, IOException {
        int n2;
        int n3;
        int n4 = xmlPullParser.getDepth();
        PropertyValuesHolder[] propertyValuesHolderArray = null;
        ArrayList<PropertyValuesHolder[]> arrayList = null;
        while (true) {
            int n5 = xmlPullParser.next();
            n3 = 0;
            n2 = 0;
            if (n5 == 3 && xmlPullParser.getDepth() <= n4 || n5 == 1) break;
            if (n5 != 2) continue;
            PropertyValuesHolder[] propertyValuesHolderArray2 = xmlPullParser.getName();
            if (propertyValuesHolderArray2.equals("objectAnimator")) {
                propertyValuesHolderArray2 = AnimatorInflaterCompat.loadObjectAnimator((Context)object, (Resources)object2, theme, attributeSet, f, xmlPullParser);
            } else if (propertyValuesHolderArray2.equals("animator")) {
                propertyValuesHolderArray2 = AnimatorInflaterCompat.loadAnimator((Context)object, (Resources)object2, theme, attributeSet, null, f, xmlPullParser);
            } else if (propertyValuesHolderArray2.equals("set")) {
                propertyValuesHolderArray2 = new AnimatorSet();
                propertyValuesHolderArray = TypedArrayUtils.obtainAttributes((Resources)object2, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_ANIMATOR_SET);
                n3 = TypedArrayUtils.getNamedInt((TypedArray)propertyValuesHolderArray, (XmlPullParser)xmlPullParser, (String)"ordering", (int)0, (int)0);
                AnimatorInflaterCompat.createAnimatorFromXml((Context)object, (Resources)object2, theme, xmlPullParser, attributeSet, (AnimatorSet)propertyValuesHolderArray2, n3, f);
                propertyValuesHolderArray.recycle();
            } else {
                if (!propertyValuesHolderArray2.equals("propertyValuesHolder")) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unknown animator name: ");
                    ((StringBuilder)object).append(xmlPullParser.getName());
                    throw new RuntimeException(((StringBuilder)object).toString());
                }
                propertyValuesHolderArray2 = AnimatorInflaterCompat.loadValues((Context)object, (Resources)object2, theme, xmlPullParser, Xml.asAttributeSet((XmlPullParser)xmlPullParser));
                if (propertyValuesHolderArray2 != null && propertyValuesHolderArray instanceof ValueAnimator) {
                    ((ValueAnimator)propertyValuesHolderArray).setValues(propertyValuesHolderArray2);
                }
                n2 = 1;
                propertyValuesHolderArray2 = propertyValuesHolderArray;
            }
            propertyValuesHolderArray = propertyValuesHolderArray2;
            if (animatorSet == null) continue;
            propertyValuesHolderArray = propertyValuesHolderArray2;
            if (n2 != 0) continue;
            ArrayList<PropertyValuesHolder[]> arrayList2 = arrayList;
            if (arrayList == null) {
                arrayList2 = new ArrayList<PropertyValuesHolder[]>();
            }
            arrayList2.add(propertyValuesHolderArray2);
            propertyValuesHolderArray = propertyValuesHolderArray2;
            arrayList = arrayList2;
        }
        if (animatorSet == null) return propertyValuesHolderArray;
        if (arrayList == null) return propertyValuesHolderArray;
        object = new Animator[arrayList.size()];
        object2 = arrayList.iterator();
        n2 = n3;
        while (object2.hasNext()) {
            object[n2] = (Animator)object2.next();
            ++n2;
        }
        if (n == 0) {
            animatorSet.playTogether((Animator[])object);
        } else {
            animatorSet.playSequentially((Animator[])object);
        }
        return propertyValuesHolderArray;
    }

    private static Keyframe createNewKeyframe(Keyframe keyframe, float f) {
        keyframe = keyframe.getType() == Float.TYPE ? Keyframe.ofFloat((float)f) : (keyframe.getType() == Integer.TYPE ? Keyframe.ofInt((float)f) : Keyframe.ofObject((float)f));
        return keyframe;
    }

    private static void distributeKeyframes(Keyframe[] keyframeArray, float f, int n, int n2) {
        f /= (float)(n2 - n + 2);
        while (n <= n2) {
            keyframeArray[n].setFraction(keyframeArray[n - 1].getFraction() + f);
            ++n;
        }
    }

    private static void dumpKeyframes(Object[] objectArray, String object) {
        if (objectArray == null) return;
        if (objectArray.length == 0) {
            return;
        }
        Log.d((String)TAG, (String)object);
        int n = objectArray.length;
        int n2 = 0;
        while (n2 < n) {
            Keyframe keyframe = (Keyframe)objectArray[n2];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Keyframe ");
            stringBuilder.append(n2);
            stringBuilder.append(": fraction ");
            float f = keyframe.getFraction();
            String string = "null";
            object = f < 0.0f ? "null" : Float.valueOf(keyframe.getFraction());
            stringBuilder.append(object);
            stringBuilder.append(", , value : ");
            object = string;
            if (keyframe.hasValue()) {
                object = keyframe.getValue();
            }
            stringBuilder.append(object);
            Log.d((String)TAG, (String)stringBuilder.toString());
            ++n2;
        }
    }

    private static PropertyValuesHolder getPVH(TypedArray object, int n, int n2, int n3, String string) {
        Object object2 = object.peekValue(n2);
        boolean bl = object2 != null;
        int n4 = bl ? ((TypedValue)object2).type : 0;
        object2 = object.peekValue(n3);
        boolean bl2 = object2 != null;
        int n5 = bl2 ? ((TypedValue)object2).type : 0;
        int n6 = n;
        if (n == 4) {
            n6 = bl && AnimatorInflaterCompat.isColorType(n4) || bl2 && AnimatorInflaterCompat.isColorType(n5) ? 3 : 0;
        }
        n = n6 == 0 ? 1 : 0;
        object2 = null;
        String string2 = null;
        if (n6 == 2) {
            String string3 = object.getString(n2);
            string2 = object.getString(n3);
            PathParser.PathDataNode[] pathDataNodeArray = PathParser.createNodesFromPathData((String)string3);
            PathParser.PathDataNode[] pathDataNodeArray2 = PathParser.createNodesFromPathData((String)string2);
            if (pathDataNodeArray == null) {
                object = object2;
                if (pathDataNodeArray2 == null) return object;
            }
            if (pathDataNodeArray != null) {
                object = new PathDataEvaluator();
                if (pathDataNodeArray2 != null) {
                    if (!PathParser.canMorph((PathParser.PathDataNode[])pathDataNodeArray, (PathParser.PathDataNode[])pathDataNodeArray2)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(" Can't morph from ");
                        ((StringBuilder)object).append(string3);
                        ((StringBuilder)object).append(" to ");
                        ((StringBuilder)object).append(string2);
                        throw new InflateException(((StringBuilder)object).toString());
                    }
                    object = PropertyValuesHolder.ofObject((String)string, (TypeEvaluator)object, (Object[])new Object[]{pathDataNodeArray, pathDataNodeArray2});
                } else {
                    object = PropertyValuesHolder.ofObject((String)string, (TypeEvaluator)object, (Object[])new Object[]{pathDataNodeArray});
                }
            } else {
                object = object2;
                if (pathDataNodeArray2 == null) return object;
                object = PropertyValuesHolder.ofObject((String)string, (TypeEvaluator)new PathDataEvaluator(), (Object[])new Object[]{pathDataNodeArray2});
            }
        } else {
            Object object3 = n6 == 3 ? ArgbEvaluator.getInstance() : null;
            if (n != 0) {
                if (bl) {
                    float f = n4 == 5 ? object.getDimension(n2, 0.0f) : object.getFloat(n2, 0.0f);
                    if (bl2) {
                        float f2 = n5 == 5 ? object.getDimension(n3, 0.0f) : object.getFloat(n3, 0.0f);
                        object = PropertyValuesHolder.ofFloat((String)string, (float[])new float[]{f, f2});
                    } else {
                        object = PropertyValuesHolder.ofFloat((String)string, (float[])new float[]{f});
                    }
                } else {
                    float f = n5 == 5 ? object.getDimension(n3, 0.0f) : object.getFloat(n3, 0.0f);
                    object = PropertyValuesHolder.ofFloat((String)string, (float[])new float[]{f});
                }
                object2 = object;
            } else if (bl) {
                n = n4 == 5 ? (int)object.getDimension(n2, 0.0f) : (AnimatorInflaterCompat.isColorType(n4) ? object.getColor(n2, 0) : object.getInt(n2, 0));
                if (bl2) {
                    n2 = n5 == 5 ? (int)object.getDimension(n3, 0.0f) : (AnimatorInflaterCompat.isColorType(n5) ? object.getColor(n3, 0) : object.getInt(n3, 0));
                    object2 = PropertyValuesHolder.ofInt((String)string, (int[])new int[]{n, n2});
                } else {
                    object2 = PropertyValuesHolder.ofInt((String)string, (int[])new int[]{n});
                }
            } else {
                object2 = string2;
                if (bl2) {
                    n = n5 == 5 ? (int)object.getDimension(n3, 0.0f) : (AnimatorInflaterCompat.isColorType(n5) ? object.getColor(n3, 0) : object.getInt(n3, 0));
                    object2 = PropertyValuesHolder.ofInt((String)string, (int[])new int[]{n});
                }
            }
            object = object2;
            if (object2 == null) return object;
            object = object2;
            if (object3 == null) return object;
            object2.setEvaluator((TypeEvaluator)object3);
            object = object2;
        }
        return object;
    }

    private static int inferValueTypeFromValues(TypedArray object, int n, int n2) {
        TypedValue typedValue = object.peekValue(n);
        int n3 = 1;
        int n4 = 0;
        n = typedValue != null ? 1 : 0;
        int n5 = n != 0 ? typedValue.type : 0;
        object = object.peekValue(n2);
        n2 = object != null ? n3 : 0;
        n3 = n2 != 0 ? object.type : 0;
        if (n == 0 || !AnimatorInflaterCompat.isColorType(n5)) {
            n = n4;
            if (n2 == 0) return n;
            n = n4;
            if (!AnimatorInflaterCompat.isColorType(n3)) return n;
        }
        n = 3;
        return n;
    }

    private static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme object, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        resources = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)object, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_KEYFRAME);
        int n = 0;
        object = TypedArrayUtils.peekNamedValue((TypedArray)resources, (XmlPullParser)xmlPullParser, (String)"value", (int)0);
        boolean bl = object != null;
        int n2 = n;
        if (bl) {
            n2 = n;
            if (AnimatorInflaterCompat.isColorType(object.type)) {
                n2 = 3;
            }
        }
        resources.recycle();
        return n2;
    }

    private static boolean isColorType(int n) {
        boolean bl = n >= 28 && n <= 31;
        return bl;
    }

    public static Animator loadAnimator(Context context, int n) throws Resources.NotFoundException {
        context = Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator((Context)context, (int)n) : AnimatorInflaterCompat.loadAnimator(context, context.getResources(), context.getTheme(), n);
        return context;
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int n) throws Resources.NotFoundException {
        return AnimatorInflaterCompat.loadAnimator(context, resources, theme, n, 1.0f);
    }

    /*
     * Exception decompiling
     */
    public static Animator loadAnimator(Context var0, Resources var1_3, Resources.Theme var2_4, int var3_6, float var4_7) throws Resources.NotFoundException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [6 : 62->213)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
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

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray typedArray = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_ANIMATOR);
        theme = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_PROPERTY_ANIMATOR);
        resources = valueAnimator;
        if (valueAnimator == null) {
            resources = new ValueAnimator();
        }
        AnimatorInflaterCompat.parseAnimatorFromTypeArray((ValueAnimator)resources, typedArray, (TypedArray)theme, f, xmlPullParser);
        int n = TypedArrayUtils.getNamedResourceId((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"interpolator", (int)0, (int)0);
        if (n > 0) {
            resources.setInterpolator((TimeInterpolator)AnimationUtilsCompat.loadInterpolator((Context)context, (int)n));
        }
        typedArray.recycle();
        if (theme == null) return resources;
        theme.recycle();
        return resources;
    }

    private static Keyframe loadKeyframe(Context context, Resources object, Resources.Theme theme, AttributeSet attributeSet, int n, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        theme = TypedArrayUtils.obtainAttributes((Resources)object, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_KEYFRAME);
        float f = TypedArrayUtils.getNamedFloat((TypedArray)theme, (XmlPullParser)xmlPullParser, (String)"fraction", (int)3, (float)-1.0f);
        object = TypedArrayUtils.peekNamedValue((TypedArray)theme, (XmlPullParser)xmlPullParser, (String)"value", (int)0);
        boolean bl = object != null;
        int n2 = n;
        if (n == 4) {
            n2 = bl && AnimatorInflaterCompat.isColorType(object.type) ? 3 : 0;
        }
        object = bl ? (n2 != 0 ? (n2 != 1 && n2 != 3 ? null : Keyframe.ofInt((float)f, (int)TypedArrayUtils.getNamedInt((TypedArray)theme, (XmlPullParser)xmlPullParser, (String)"value", (int)0, (int)0))) : Keyframe.ofFloat((float)f, (float)TypedArrayUtils.getNamedFloat((TypedArray)theme, (XmlPullParser)xmlPullParser, (String)"value", (int)0, (float)0.0f))) : (n2 == 0 ? Keyframe.ofFloat((float)f) : Keyframe.ofInt((float)f));
        n = TypedArrayUtils.getNamedResourceId((TypedArray)theme, (XmlPullParser)xmlPullParser, (String)"interpolator", (int)1, (int)0);
        if (n > 0) {
            object.setInterpolator((TimeInterpolator)AnimationUtilsCompat.loadInterpolator((Context)context, (int)n));
        }
        theme.recycle();
        return object;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        AnimatorInflaterCompat.loadAnimator(context, resources, theme, attributeSet, (ValueAnimator)objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder loadPvh(Context resources, Resources resources2, Resources.Theme theme, XmlPullParser xmlPullParser, String string, int n) throws XmlPullParserException, IOException {
        Object var14_6 = null;
        ArrayList<Keyframe> arrayList = null;
        int n2 = n;
        while ((n = xmlPullParser.next()) != 3 && n != 1) {
            if (!xmlPullParser.getName().equals("keyframe")) continue;
            n = n2;
            if (n2 == 4) {
                n = AnimatorInflaterCompat.inferValueTypeOfKeyframe(resources2, theme, Xml.asAttributeSet((XmlPullParser)xmlPullParser), xmlPullParser);
            }
            Keyframe keyframe = AnimatorInflaterCompat.loadKeyframe((Context)resources, resources2, theme, Xml.asAttributeSet((XmlPullParser)xmlPullParser), n, xmlPullParser);
            ArrayList<Keyframe> arrayList2 = arrayList;
            if (keyframe != null) {
                arrayList2 = arrayList;
                if (arrayList == null) {
                    arrayList2 = new ArrayList<Keyframe>();
                }
                arrayList2.add(keyframe);
            }
            xmlPullParser.next();
            arrayList = arrayList2;
            n2 = n;
        }
        resources = var14_6;
        if (arrayList == null) return resources;
        int n3 = arrayList.size();
        resources = var14_6;
        if (n3 <= 0) return resources;
        int n4 = 0;
        resources = (Keyframe)arrayList.get(0);
        resources2 = (Keyframe)arrayList.get(n3 - 1);
        float f = resources2.getFraction();
        n = n3;
        if (f < 1.0f) {
            if (f < 0.0f) {
                resources2.setFraction(1.0f);
                n = n3;
            } else {
                arrayList.add(arrayList.size(), AnimatorInflaterCompat.createNewKeyframe((Keyframe)resources2, 1.0f));
                n = n3 + 1;
            }
        }
        f = resources.getFraction();
        n3 = n;
        if (f != 0.0f) {
            if (f < 0.0f) {
                resources.setFraction(0.0f);
                n3 = n;
            } else {
                arrayList.add(0, AnimatorInflaterCompat.createNewKeyframe((Keyframe)resources, 0.0f));
                n3 = n + 1;
            }
        }
        resources = new Keyframe[n3];
        arrayList.toArray((T[])resources);
        n = n4;
        while (true) {
            if (n >= n3) {
                resources = resources2 = PropertyValuesHolder.ofKeyframe((String)string, (Keyframe[])resources);
                if (n2 != 3) return resources;
                resources2.setEvaluator((TypeEvaluator)ArgbEvaluator.getInstance());
                resources = resources2;
                return resources;
            }
            resources2 = resources[n];
            if (resources2.getFraction() < 0.0f) {
                if (n == 0) {
                    resources2.setFraction(0.0f);
                } else {
                    int n5 = n3 - 1;
                    if (n == n5) {
                        resources2.setFraction(1.0f);
                    } else {
                        n4 = n + 1;
                        int n6 = n;
                        while (n4 < n5 && !(resources[n4].getFraction() >= 0.0f)) {
                            n6 = n4++;
                        }
                        AnimatorInflaterCompat.distributeKeyframes((Keyframe[])resources, resources[n6 + 1].getFraction() - resources[n - 1].getFraction(), n, n6);
                    }
                }
            }
            ++n;
        }
    }

    private static PropertyValuesHolder[] loadValues(Context propertyValuesHolderArray, Resources propertyValuesHolderArray2, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int n;
        int n2;
        Object var10_5 = null;
        ArrayList arrayList = null;
        while (true) {
            n2 = xmlPullParser.getEventType();
            n = 0;
            if (n2 == 3 || n2 == 1) break;
            if (n2 != 2) {
                xmlPullParser.next();
                continue;
            }
            if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                TypedArray typedArray = TypedArrayUtils.obtainAttributes((Resources)propertyValuesHolderArray2, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER);
                String string = TypedArrayUtils.getNamedString((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"propertyName", (int)3);
                n = TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"valueType", (int)2, (int)4);
                Object object = AnimatorInflaterCompat.loadPvh((Context)propertyValuesHolderArray, (Resources)propertyValuesHolderArray2, theme, xmlPullParser, string, n);
                PropertyValuesHolder propertyValuesHolder = object;
                if (object == null) {
                    propertyValuesHolder = AnimatorInflaterCompat.getPVH(typedArray, n, 0, 1, string);
                }
                object = arrayList;
                if (propertyValuesHolder != null) {
                    object = arrayList;
                    if (arrayList == null) {
                        object = new ArrayList();
                    }
                    ((ArrayList)object).add(propertyValuesHolder);
                }
                typedArray.recycle();
                arrayList = object;
            }
            xmlPullParser.next();
        }
        propertyValuesHolderArray = var10_5;
        if (arrayList == null) return propertyValuesHolderArray;
        n2 = arrayList.size();
        propertyValuesHolderArray2 = new PropertyValuesHolder[n2];
        while (true) {
            propertyValuesHolderArray = propertyValuesHolderArray2;
            if (n >= n2) return propertyValuesHolderArray;
            propertyValuesHolderArray2[n] = (PropertyValuesHolder)arrayList.get(n);
            ++n;
        }
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        int n;
        long l = TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"duration", (int)1, (int)300);
        long l2 = TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"startOffset", (int)2, (int)0);
        int n2 = n = TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"valueType", (int)7, (int)4);
        if (TypedArrayUtils.hasAttribute((XmlPullParser)xmlPullParser, (String)"valueFrom")) {
            n2 = n;
            if (TypedArrayUtils.hasAttribute((XmlPullParser)xmlPullParser, (String)"valueTo")) {
                int n3 = n;
                if (n == 4) {
                    n3 = AnimatorInflaterCompat.inferValueTypeFromValues(typedArray, 5, 6);
                }
                PropertyValuesHolder propertyValuesHolder = AnimatorInflaterCompat.getPVH(typedArray, n3, 5, 6, "");
                n2 = n3;
                if (propertyValuesHolder != null) {
                    valueAnimator.setValues(new PropertyValuesHolder[]{propertyValuesHolder});
                    n2 = n3;
                }
            }
        }
        valueAnimator.setDuration(l);
        valueAnimator.setStartDelay(l2);
        valueAnimator.setRepeatCount(TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"repeatCount", (int)3, (int)0));
        valueAnimator.setRepeatMode(TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"repeatMode", (int)4, (int)1));
        if (typedArray2 == null) return;
        AnimatorInflaterCompat.setupObjectAnimator(valueAnimator, typedArray2, n2, f, xmlPullParser);
    }

    private static void setupObjectAnimator(ValueAnimator object, TypedArray typedArray, int n, float f, XmlPullParser object2) {
        ObjectAnimator objectAnimator = (ObjectAnimator)object;
        String string = TypedArrayUtils.getNamedString((TypedArray)typedArray, (XmlPullParser)object2, (String)"pathData", (int)1);
        if (string != null) {
            object = TypedArrayUtils.getNamedString((TypedArray)typedArray, (XmlPullParser)object2, (String)"propertyXName", (int)2);
            object2 = TypedArrayUtils.getNamedString((TypedArray)typedArray, (XmlPullParser)object2, (String)"propertyYName", (int)3);
            if (n != 2) {
                // empty if block
            }
            if (object == null && object2 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append(typedArray.getPositionDescription());
                ((StringBuilder)object).append(" propertyXName or propertyYName is needed for PathData");
                throw new InflateException(((StringBuilder)object).toString());
            }
            AnimatorInflaterCompat.setupPathMotion(PathParser.createPathFromPathData((String)string), objectAnimator, f * 0.5f, (String)object, (String)object2);
        } else {
            objectAnimator.setPropertyName(TypedArrayUtils.getNamedString((TypedArray)typedArray, (XmlPullParser)object2, (String)"propertyName", (int)0));
        }
    }

    private static void setupPathMotion(Path object, ObjectAnimator objectAnimator, float f, String string, String string2) {
        float f2;
        PathMeasure pathMeasure = new PathMeasure(object, false);
        ArrayList<Float> arrayList = new ArrayList<Float>();
        float f3 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float f4 = 0.0f;
        do {
            f2 = f4 + pathMeasure.getLength();
            arrayList.add(Float.valueOf(f2));
            f4 = f2;
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(object, false);
        int n = Math.min(100, (int)(f2 / f) + 1);
        float[] fArray = new float[n];
        float[] fArray2 = new float[n];
        object = new float[2];
        f4 = f2 / (float)(n - 1);
        int n2 = 0;
        int n3 = 0;
        f = f3;
        while (true) {
            pathMeasure = null;
            if (n2 >= n) break;
            pathMeasure2.getPosTan(f - ((Float)arrayList.get(n3)).floatValue(), (float[])object, null);
            fArray[n2] = (float)object[0];
            fArray2[n2] = (float)object[1];
            f += f4;
            int n4 = n3 + 1;
            int n5 = n3;
            if (n4 < arrayList.size()) {
                n5 = n3;
                if (f > ((Float)arrayList.get(n4)).floatValue()) {
                    pathMeasure2.nextContour();
                    n5 = n4;
                }
            }
            ++n2;
            n3 = n5;
        }
        object = string != null ? PropertyValuesHolder.ofFloat((String)string, (float[])fArray) : null;
        string = pathMeasure;
        if (string2 != null) {
            string = PropertyValuesHolder.ofFloat((String)string2, (float[])fArray2);
        }
        if (object == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{string});
        } else if (string == null) {
            objectAnimator.setValues(new PropertyValuesHolder[]{object});
        } else {
            objectAnimator.setValues(new PropertyValuesHolder[]{object, string});
        }
    }
}
