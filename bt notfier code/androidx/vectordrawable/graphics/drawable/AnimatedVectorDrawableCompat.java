/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ArgbEvaluator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimatedVectorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Xml
 *  androidx.collection.ArrayMap
 *  androidx.core.content.res.ResourcesCompat
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.vectordrawable.graphics.drawable.AndroidResources
 *  androidx.vectordrawable.graphics.drawable.Animatable2Compat
 *  androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback
 *  androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableCompatState
 *  androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$AnimatedVectorDrawableDelegateState
 *  androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCommon
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCommon;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat
extends VectorDrawableCommon
implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompatState mAnimatedVectorState;
    ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks = null;
    private Animator.AnimatorListener mAnimatorListener = null;
    private ArgbEvaluator mArgbEvaluator = null;
    AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    final Drawable.Callback mCallback = new /* Unavailable Anonymous Inner Class!! */;
    private Context mContext;

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, AnimatedVectorDrawableCompatState animatedVectorDrawableCompatState, Resources resources) {
        this.mContext = context;
        this.mAnimatedVectorState = animatedVectorDrawableCompatState != null ? animatedVectorDrawableCompatState : new AnimatedVectorDrawableCompatState(context, animatedVectorDrawableCompatState, this.mCallback, resources);
    }

    public static void clearAnimationCallbacks(Drawable drawable) {
        if (!(drawable instanceof Animatable)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            ((AnimatedVectorDrawable)drawable).clearAnimationCallbacks();
        } else {
            ((AnimatedVectorDrawableCompat)drawable).clearAnimationCallbacks();
        }
    }

    public static AnimatedVectorDrawableCompat create(Context object, int n) {
        if (Build.VERSION.SDK_INT >= 24) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((Context)object);
            animatedVectorDrawableCompat.mDelegateDrawable = ResourcesCompat.getDrawable((Resources)object.getResources(), (int)n, (Resources.Theme)object.getTheme());
            animatedVectorDrawableCompat.mDelegateDrawable.setCallback(animatedVectorDrawableCompat.mCallback);
            animatedVectorDrawableCompat.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(animatedVectorDrawableCompat.mDelegateDrawable.getConstantState());
            return animatedVectorDrawableCompat;
        }
        Object object2 = object.getResources();
        try {
            XmlResourceParser xmlResourceParser = object2.getXml(n);
            object2 = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            while ((n = xmlResourceParser.next()) != 2 && n != 1) {
            }
            if (n == 2) {
                return AnimatedVectorDrawableCompat.createFromXmlInner(object, object.getResources(), xmlResourceParser, (AttributeSet)object2, object.getTheme());
            }
            object = new XmlPullParserException("No start tag found");
            throw object;
        }
        catch (IOException iOException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)iOException);
        }
        catch (XmlPullParserException xmlPullParserException) {
            Log.e((String)LOGTAG, (String)"parser error", (Throwable)xmlPullParserException);
        }
        return null;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        object = new AnimatedVectorDrawableCompat((Context)object);
        ((AnimatedVectorDrawableCompat)((Object)object)).inflate(resources, xmlPullParser, attributeSet, theme);
        return object;
    }

    public static void registerAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null) return;
        if (animationCallback == null) return;
        if (!(drawable instanceof Animatable)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            AnimatedVectorDrawableCompat.registerPlatformCallback((AnimatedVectorDrawable)drawable, animationCallback);
        } else {
            ((AnimatedVectorDrawableCompat)drawable).registerAnimationCallback(animationCallback);
        }
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        animatedVectorDrawable.registerAnimationCallback(animationCallback.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        if (this.mAnimatorListener == null) return;
        this.mAnimatedVectorState.mAnimatorSet.removeListener(this.mAnimatorListener);
        this.mAnimatorListener = null;
    }

    private void setupAnimatorsForTarget(String string, Animator animator) {
        animator.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(string));
        if (Build.VERSION.SDK_INT < 21) {
            this.setupColorAnimator(animator);
        }
        if (this.mAnimatedVectorState.mAnimators == null) {
            this.mAnimatedVectorState.mAnimators = new ArrayList();
            this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
        }
        this.mAnimatedVectorState.mAnimators.add(animator);
        this.mAnimatedVectorState.mTargetNameMap.put((Object)animator, (Object)string);
    }

    private void setupColorAnimator(Animator animator) {
        Object object;
        if (animator instanceof AnimatorSet && (object = ((AnimatorSet)animator).getChildAnimations()) != null) {
            for (int i = 0; i < object.size(); ++i) {
                this.setupColorAnimator((Animator)object.get(i));
            }
        }
        if (!(animator instanceof ObjectAnimator)) return;
        object = (animator = (ObjectAnimator)animator).getPropertyName();
        if (!"fillColor".equals(object)) {
            if (!"strokeColor".equals(object)) return;
        }
        if (this.mArgbEvaluator == null) {
            this.mArgbEvaluator = new ArgbEvaluator();
        }
        animator.setEvaluator((TypeEvaluator)this.mArgbEvaluator);
    }

    public static boolean unregisterAnimationCallback(Drawable drawable, Animatable2Compat.AnimationCallback animationCallback) {
        if (drawable == null) return false;
        if (animationCallback == null) {
            return false;
        }
        if (!(drawable instanceof Animatable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 24) return ((AnimatedVectorDrawableCompat)drawable).unregisterAnimationCallback(animationCallback);
        return AnimatedVectorDrawableCompat.unregisterPlatformCallback((AnimatedVectorDrawable)drawable, animationCallback);
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable animatedVectorDrawable, Animatable2Compat.AnimationCallback animationCallback) {
        return animatedVectorDrawable.unregisterAnimationCallback(animationCallback.getPlatformCallback());
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.mDelegateDrawable == null) return;
        DrawableCompat.applyTheme((Drawable)this.mDelegateDrawable, (Resources.Theme)theme);
    }

    public boolean canApplyTheme() {
        if (this.mDelegateDrawable == null) return false;
        return DrawableCompat.canApplyTheme((Drawable)this.mDelegateDrawable);
    }

    public void clearAnimationCallbacks() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).clearAnimationCallbacks();
            return;
        }
        this.removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> arrayList = this.mAnimationCallbacks;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }

    public void draw(Canvas canvas) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(canvas);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.draw(canvas);
        if (!this.mAnimatedVectorState.mAnimatorSet.isStarted()) return;
        this.invalidateSelf();
    }

    public int getAlpha() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
        return DrawableCompat.getAlpha((Drawable)this.mDelegateDrawable);
    }

    public int getChangingConfigurations() {
        if (this.mDelegateDrawable == null) return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
        return this.mDelegateDrawable.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
        return DrawableCompat.getColorFilter((Drawable)this.mDelegateDrawable);
    }

    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable == null) return null;
        if (Build.VERSION.SDK_INT < 24) return null;
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    public int getIntrinsicHeight() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
        return this.mDelegateDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
        return this.mDelegateDrawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
        return this.mDelegateDrawable.getOpacity();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.inflate((Drawable)this.mDelegateDrawable, (Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme);
            return;
        }
        int n = xmlPullParser.getEventType();
        int n2 = xmlPullParser.getDepth();
        while (n != 1 && (xmlPullParser.getDepth() >= n2 + 1 || n != 3)) {
            if (n == 2) {
                String string;
                String string2 = xmlPullParser.getName();
                if (ANIMATED_VECTOR.equals(string2)) {
                    string2 = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
                    n = string2.getResourceId(0, 0);
                    if (n != 0) {
                        string = VectorDrawableCompat.create((Resources)resources, (int)n, (Resources.Theme)theme);
                        string.setAllowCaching(false);
                        string.setCallback(this.mCallback);
                        if (this.mAnimatedVectorState.mVectorDrawable != null) {
                            this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
                        }
                        this.mAnimatedVectorState.mVectorDrawable = string;
                    }
                    string2.recycle();
                } else if (TARGET.equals(string2)) {
                    TypedArray typedArray = resources.obtainAttributes(attributeSet, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
                    string = typedArray.getString(0);
                    n = typedArray.getResourceId(1, 0);
                    if (n != 0) {
                        string2 = this.mContext;
                        if (string2 == null) {
                            typedArray.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        this.setupAnimatorsForTarget(string, AnimatorInflaterCompat.loadAnimator((Context)string2, (int)n));
                    }
                    typedArray.recycle();
                }
            }
            n = xmlPullParser.next();
        }
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    public boolean isAutoMirrored() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
        return DrawableCompat.isAutoMirrored((Drawable)this.mDelegateDrawable);
    }

    public boolean isRunning() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mAnimatorSet.isRunning();
        return ((AnimatedVectorDrawable)this.mDelegateDrawable).isRunning();
    }

    public boolean isStateful() {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.isStateful();
        return this.mDelegateDrawable.isStateful();
    }

    public Drawable mutate() {
        if (this.mDelegateDrawable == null) return this;
        this.mDelegateDrawable.mutate();
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(rect);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setBounds(rect);
    }

    protected boolean onLevelChange(int n) {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.setLevel(n);
        return this.mDelegateDrawable.setLevel(n);
    }

    protected boolean onStateChange(int[] nArray) {
        if (this.mDelegateDrawable == null) return this.mAnimatedVectorState.mVectorDrawable.setState(nArray);
        return this.mDelegateDrawable.setState(nArray);
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.mDelegateDrawable != null) {
            AnimatedVectorDrawableCompat.registerPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, animationCallback);
            return;
        }
        if (animationCallback == null) {
            return;
        }
        if (this.mAnimationCallbacks == null) {
            this.mAnimationCallbacks = new ArrayList();
        }
        if (this.mAnimationCallbacks.contains(animationCallback)) {
            return;
        }
        this.mAnimationCallbacks.add(animationCallback);
        if (this.mAnimatorListener == null) {
            this.mAnimatorListener = new /* Unavailable Anonymous Inner Class!! */;
        }
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    public void setAlpha(int n) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(n);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(n);
    }

    public void setAutoMirrored(boolean bl) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored((Drawable)this.mDelegateDrawable, (boolean)bl);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(bl);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(colorFilter);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(colorFilter);
    }

    public void setTint(int n) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTint((Drawable)this.mDelegateDrawable, (int)n);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTint(n);
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintList((Drawable)this.mDelegateDrawable, (ColorStateList)colorStateList);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode((Drawable)this.mDelegateDrawable, (PorterDuff.Mode)mode);
            return;
        }
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(mode);
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        if (this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(bl, bl2);
        }
        this.mAnimatedVectorState.mVectorDrawable.setVisible(bl, bl2);
        return super.setVisible(bl, bl2);
    }

    public void start() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).start();
            return;
        }
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.start();
        this.invalidateSelf();
    }

    public void stop() {
        if (this.mDelegateDrawable != null) {
            ((AnimatedVectorDrawable)this.mDelegateDrawable).stop();
            return;
        }
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        ArrayList<Animatable2Compat.AnimationCallback> arrayList;
        if (this.mDelegateDrawable != null) {
            AnimatedVectorDrawableCompat.unregisterPlatformCallback((AnimatedVectorDrawable)this.mDelegateDrawable, animationCallback);
        }
        if ((arrayList = this.mAnimationCallbacks) == null) return false;
        if (animationCallback == null) {
            return false;
        }
        boolean bl = arrayList.remove(animationCallback);
        if (this.mAnimationCallbacks.size() != 0) return bl;
        this.removeAnimatorSetListener();
        return bl;
    }
}
