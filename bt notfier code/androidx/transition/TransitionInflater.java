/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.TypedArray
 *  android.view.InflateException
 *  android.view.ViewGroup
 *  androidx.collection.ArrayMap
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.transition.ArcMotion
 *  androidx.transition.AutoTransition
 *  androidx.transition.ChangeBounds
 *  androidx.transition.ChangeClipBounds
 *  androidx.transition.ChangeImageTransform
 *  androidx.transition.ChangeScroll
 *  androidx.transition.ChangeTransform
 *  androidx.transition.Explode
 *  androidx.transition.Fade
 *  androidx.transition.PathMotion
 *  androidx.transition.PatternPathMotion
 *  androidx.transition.Scene
 *  androidx.transition.Slide
 *  androidx.transition.Styleable
 *  androidx.transition.Transition
 *  androidx.transition.TransitionManager
 *  androidx.transition.TransitionSet
 */
package androidx.transition;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.ArcMotion;
import androidx.transition.AutoTransition;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeClipBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeScroll;
import androidx.transition.ChangeTransform;
import androidx.transition.Explode;
import androidx.transition.Fade;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Scene;
import androidx.transition.Slide;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater {
    private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE;
    private final Context mContext;

    static {
        CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class};
        CONSTRUCTORS = new ArrayMap();
    }

    private TransitionInflater(Context context) {
        this.mContext = context;
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private Object createCustom(AttributeSet object, Class<?> clazz, String constructor) {
        void var2_3;
        Constructor constructor2;
        String string = object.getAttributeValue(null, "class");
        if (string == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)((Object)constructor2));
            ((StringBuilder)object).append(" tag must have a 'class' attribute");
            throw new InflateException(((StringBuilder)object).toString());
        }
        try {
            ArrayMap<String, Constructor<?>> arrayMap = CONSTRUCTORS;
            synchronized (arrayMap) {
            }
        }
        catch (Exception throwable) {
            constructor2 = new StringBuilder();
            ((StringBuilder)((Object)constructor2)).append("Could not instantiate ");
            ((StringBuilder)((Object)constructor2)).append(var2_3);
            ((StringBuilder)((Object)constructor2)).append(" class ");
            ((StringBuilder)((Object)constructor2)).append(string);
            throw new InflateException(((StringBuilder)((Object)constructor2)).toString(), (Throwable)throwable);
        }
        {
            Constructor constructor3 = (Constructor)CONSTRUCTORS.get((Object)string);
            constructor2 = constructor3;
            if (constructor3 != null) return constructor2.newInstance(this.mContext, object);
            Class clazz2 = Class.forName(string, false, this.mContext.getClassLoader()).asSubclass(var2_3);
            constructor2 = constructor3;
            if (clazz2 == null) return constructor2.newInstance(this.mContext, object);
            constructor2 = clazz2.getConstructor(CONSTRUCTOR_SIGNATURE);
            constructor2.setAccessible(true);
            CONSTRUCTORS.put((Object)string, constructor2);
            return constructor2.newInstance(this.mContext, object);
        }
    }

    private Transition createTransitionFromXml(XmlPullParser xmlPullParser, AttributeSet object, Transition transition) throws XmlPullParserException, IOException {
        int n = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet)transition : null;
        block0: while (true) {
            String string = null;
            while (true) {
                int n2;
                if ((n2 = xmlPullParser.next()) == 3) {
                    if (xmlPullParser.getDepth() <= n) return string;
                }
                if (n2 == 1) return string;
                if (n2 != 2) continue;
                String string2 = xmlPullParser.getName();
                if ("fade".equals(string2)) {
                    string2 = new Fade(this.mContext, (AttributeSet)object);
                } else if ("changeBounds".equals(string2)) {
                    string2 = new ChangeBounds(this.mContext, (AttributeSet)object);
                } else if ("slide".equals(string2)) {
                    string2 = new Slide(this.mContext, (AttributeSet)object);
                } else if ("explode".equals(string2)) {
                    string2 = new Explode(this.mContext, (AttributeSet)object);
                } else if ("changeImageTransform".equals(string2)) {
                    string2 = new ChangeImageTransform(this.mContext, (AttributeSet)object);
                } else if ("changeTransform".equals(string2)) {
                    string2 = new ChangeTransform(this.mContext, (AttributeSet)object);
                } else if ("changeClipBounds".equals(string2)) {
                    string2 = new ChangeClipBounds(this.mContext, (AttributeSet)object);
                } else if ("autoTransition".equals(string2)) {
                    string2 = new AutoTransition(this.mContext, (AttributeSet)object);
                } else if ("changeScroll".equals(string2)) {
                    string2 = new ChangeScroll(this.mContext, (AttributeSet)object);
                } else if ("transitionSet".equals(string2)) {
                    string2 = new TransitionSet(this.mContext, (AttributeSet)object);
                } else if ("transition".equals(string2)) {
                    string2 = (Transition)this.createCustom((AttributeSet)object, Transition.class, "transition");
                } else if ("targets".equals(string2)) {
                    this.getTargetIds(xmlPullParser, (AttributeSet)object, transition);
                    string2 = string;
                } else if ("arcMotion".equals(string2)) {
                    if (transition == null) throw new RuntimeException("Invalid use of arcMotion element");
                    transition.setPathMotion((PathMotion)new ArcMotion(this.mContext, (AttributeSet)object));
                    string2 = string;
                } else if ("pathMotion".equals(string2)) {
                    if (transition == null) throw new RuntimeException("Invalid use of pathMotion element");
                    transition.setPathMotion((PathMotion)this.createCustom((AttributeSet)object, PathMotion.class, "pathMotion"));
                    string2 = string;
                } else {
                    if (!"patternPathMotion".equals(string2)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Unknown scene name: ");
                        ((StringBuilder)object).append(xmlPullParser.getName());
                        throw new RuntimeException(((StringBuilder)object).toString());
                    }
                    if (transition == null) throw new RuntimeException("Invalid use of patternPathMotion element");
                    transition.setPathMotion((PathMotion)new PatternPathMotion(this.mContext, (AttributeSet)object));
                    string2 = string;
                }
                string = string2;
                if (string2 == null) continue;
                if (!xmlPullParser.isEmptyElementTag()) {
                    this.createTransitionFromXml(xmlPullParser, (AttributeSet)object, (Transition)string2);
                }
                if (transitionSet != null) {
                    transitionSet.addTransition((Transition)string2);
                    continue block0;
                }
                if (transition != null) throw new InflateException("Could not add transition to another transition.");
                string = string2;
            }
            break;
        }
    }

    private TransitionManager createTransitionManagerFromXml(XmlPullParser xmlPullParser, AttributeSet object, ViewGroup viewGroup) throws XmlPullParserException, IOException {
        int n = xmlPullParser.getDepth();
        TransitionManager transitionManager = null;
        while (true) {
            int n2;
            if ((n2 = xmlPullParser.next()) == 3) {
                if (xmlPullParser.getDepth() <= n) return transitionManager;
            }
            if (n2 == 1) return transitionManager;
            if (n2 != 2) continue;
            String string = xmlPullParser.getName();
            if (string.equals("transitionManager")) {
                transitionManager = new TransitionManager();
                continue;
            }
            if (!string.equals("transition") || transitionManager == null) break;
            this.loadTransition((AttributeSet)object, xmlPullParser, viewGroup, transitionManager);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unknown scene name: ");
        ((StringBuilder)object).append(xmlPullParser.getName());
        throw new RuntimeException(((StringBuilder)object).toString());
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    /*
     * Unable to fully structure code
     */
    private void getTargetIds(XmlPullParser var1_1, AttributeSet var2_3, Transition var3_4) throws XmlPullParserException, IOException {
        var4_5 = var1_1.getDepth();
        while (true) {
            block6: {
                block10: {
                    block9: {
                        block8: {
                            block7: {
                                if ((var5_6 = var1_1.next()) == 3) {
                                    if (var1_1.getDepth() <= var4_5) return;
                                }
                                if (var5_6 == 1) return;
                                if (var5_6 != 2) continue;
                                if (!var1_1.getName().equals("target")) {
                                    var2_3 = new StringBuilder();
                                    var2_3.append("Unknown scene name: ");
                                    var2_3.append(var1_1.getName());
                                    throw new RuntimeException(var2_3.toString());
                                }
                                var8_9 = this.mContext.obtainStyledAttributes((AttributeSet)var2_3, Styleable.TRANSITION_TARGET);
                                var5_6 = TypedArrayUtils.getNamedResourceId((TypedArray)var8_9, (XmlPullParser)var1_1, (String)"targetId", (int)1, (int)0);
                                if (var5_6 == 0) break block7;
                                var3_4.addTarget(var5_6);
                                break block6;
                            }
                            var5_6 = TypedArrayUtils.getNamedResourceId((TypedArray)var8_9, (XmlPullParser)var1_1, (String)"excludeId", (int)2, (int)0);
                            if (var5_6 == 0) break block8;
                            var3_4.excludeTarget(var5_6, true);
                            break block6;
                        }
                        var6_7 = TypedArrayUtils.getNamedString((TypedArray)var8_9, (XmlPullParser)var1_1, (String)"targetName", (int)4);
                        if (var6_7 == null) break block9;
                        var3_4.addTarget(var6_7);
                        break block6;
                    }
                    var6_7 = TypedArrayUtils.getNamedString((TypedArray)var8_9, (XmlPullParser)var1_1, (String)"excludeName", (int)5);
                    if (var6_7 == null) break block10;
                    var3_4.excludeTarget(var6_7, true);
                    break block6;
                }
                var7_8 = TypedArrayUtils.getNamedString((TypedArray)var8_9, (XmlPullParser)var1_1, (String)"excludeClass", (int)3);
                if (var7_8 == null) ** GOTO lbl46
                var6_7 = var7_8;
                try {
                    var3_4.excludeTarget(Class.forName(var7_8), true);
                    break block6;
lbl46:
                    // 1 sources

                    var6_7 = var7_8;
                    var7_8 = TypedArrayUtils.getNamedString((TypedArray)var8_9, (XmlPullParser)var1_1, (String)"targetClass", (int)0);
                    if (var7_8 != null) {
                        var6_7 = var7_8;
                        var3_4.addTarget(Class.forName(var7_8));
                    }
                }
                catch (ClassNotFoundException var1_2) {
                    var8_9.recycle();
                    var2_3 = new StringBuilder();
                    var2_3.append("Could not create ");
                    var2_3.append(var6_7);
                    throw new RuntimeException(var2_3.toString(), var1_2);
                }
            }
            var8_9.recycle();
        }
    }

    private void loadTransition(AttributeSet object, XmlPullParser xmlPullParser, ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        TypedArray typedArray = this.mContext.obtainStyledAttributes((AttributeSet)object, Styleable.TRANSITION_MANAGER);
        int n = TypedArrayUtils.getNamedResourceId((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"transition", (int)2, (int)-1);
        int n2 = TypedArrayUtils.getNamedResourceId((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"fromScene", (int)0, (int)-1);
        Object var7_8 = null;
        object = n2 < 0 ? null : Scene.getSceneForLayout((ViewGroup)viewGroup, (int)n2, (Context)this.mContext);
        n2 = TypedArrayUtils.getNamedResourceId((TypedArray)typedArray, (XmlPullParser)xmlPullParser, (String)"toScene", (int)1, (int)-1);
        xmlPullParser = n2 < 0 ? var7_8 : Scene.getSceneForLayout((ViewGroup)viewGroup, (int)n2, (Context)this.mContext);
        if (n >= 0 && (viewGroup = this.inflateTransition(n)) != null) {
            if (xmlPullParser == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("No toScene for transition ID ");
                ((StringBuilder)object).append(n);
                throw new RuntimeException(((StringBuilder)object).toString());
            }
            if (object == null) {
                transitionManager.setTransition((Scene)xmlPullParser, (Transition)viewGroup);
            } else {
                transitionManager.setTransition((Scene)object, (Scene)xmlPullParser, (Transition)viewGroup);
            }
        }
        typedArray.recycle();
    }

    /*
     * Exception decompiling
     */
    public Transition inflateTransition(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 37->112)] java.lang.Throwable
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

    /*
     * Exception decompiling
     */
    public TransitionManager inflateTransitionManager(int var1_1, ViewGroup var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 37->123)] java.lang.Throwable
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
}
