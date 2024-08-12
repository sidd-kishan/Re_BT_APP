/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Xml
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatableTransition
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedStateListState
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimatedVectorDrawableTransition
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$AnimationDrawableTransition
 *  androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition
 *  androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState
 *  androidx.appcompat.graphics.drawable.StateListDrawable
 *  androidx.appcompat.resources.R$styleable
 *  androidx.appcompat.widget.ResourceManagerInternal
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.graphics.drawable.TintAwareDrawable
 *  androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 */
package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat
extends StateListDrawable
implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = AnimatedStateListDrawableCompat.class.getSimpleName();
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex = -1;
    private int mTransitionToIndex = -1;

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState animatedStateListState, Resources resources) {
        super(null);
        this.setConstantState((DrawableContainer.DrawableContainerState)new AnimatedStateListState(animatedStateListState, this, resources));
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
    }

    public static AnimatedStateListDrawableCompat create(Context object, int n, Resources.Theme theme) {
        try {
            Resources resources = object.getResources();
            XmlResourceParser xmlResourceParser = resources.getXml(n);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
            while ((n = xmlResourceParser.next()) != 2 && n != 1) {
            }
            if (n == 2) {
                return AnimatedStateListDrawableCompat.createFromXmlInner(object, resources, xmlResourceParser, attributeSet, theme);
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

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        Object object2 = xmlPullParser.getName();
        if (((String)object2).equals("animated-selector")) {
            object2 = new AnimatedStateListDrawableCompat();
            ((AnimatedStateListDrawableCompat)((Object)object2)).inflate((Context)object, resources, xmlPullParser, attributeSet, theme);
            return object2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(": invalid animated-selector tag ");
        ((StringBuilder)object).append((String)object2);
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private void inflateChildElements(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n;
        int n2 = xmlPullParser.getDepth() + 1;
        while ((n = xmlPullParser.next()) != 1) {
            int n3 = xmlPullParser.getDepth();
            if (n3 < n2) {
                if (n == 3) return;
            }
            if (n != 2 || n3 > n2) continue;
            if (xmlPullParser.getName().equals(ELEMENT_ITEM)) {
                this.parseItem(context, resources, xmlPullParser, attributeSet, theme);
                continue;
            }
            if (!xmlPullParser.getName().equals(ELEMENT_TRANSITION)) continue;
            this.parseTransition(context, resources, xmlPullParser, attributeSet, theme);
        }
    }

    private void init() {
        this.onStateChange(this.getState());
    }

    private int parseItem(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Object object2 = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.AnimatedStateListDrawableItem);
        int n = object2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int n2 = object2.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawable = n2 > 0 ? ResourceManagerInternal.get().getDrawable((Context)object, n2) : null;
        object2.recycle();
        object2 = this.extractStateSet(attributeSet);
        object = drawable;
        if (drawable == null) {
            while ((n2 = xmlPullParser.next()) == 4) {
            }
            if (n2 != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
                ((StringBuilder)object).append(ITEM_MISSING_DRAWABLE_ERROR);
                throw new XmlPullParserException(((StringBuilder)object).toString());
            }
            object = xmlPullParser.getName().equals("vector") ? VectorDrawableCompat.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : (Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet));
        }
        if (object != null) {
            return this.mState.addStateSet((int[])object2, (Drawable)object, n);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(ITEM_MISSING_DRAWABLE_ERROR);
        object = new XmlPullParserException(((StringBuilder)object).toString());
        throw object;
    }

    private int parseTransition(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Object object2 = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.AnimatedStateListDrawableTransition);
        int n = object2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int n2 = object2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int n3 = object2.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawable = n3 > 0 ? ResourceManagerInternal.get().getDrawable((Context)object, n3) : null;
        boolean bl = object2.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        object2.recycle();
        object2 = drawable;
        if (drawable == null) {
            while ((n3 = xmlPullParser.next()) == 4) {
            }
            if (n3 != 2) {
                object = new StringBuilder();
                ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
                ((StringBuilder)object).append(TRANSITION_MISSING_DRAWABLE_ERROR);
                throw new XmlPullParserException(((StringBuilder)object).toString());
            }
            object2 = xmlPullParser.getName().equals("animated-vector") ? AnimatedVectorDrawableCompat.createFromXmlInner((Context)object, (Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : (Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet));
        }
        if (object2 == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
            ((StringBuilder)object).append(TRANSITION_MISSING_DRAWABLE_ERROR);
            object = new XmlPullParserException(((StringBuilder)object).toString());
            throw object;
        }
        if (n != -1 && n2 != -1) {
            return this.mState.addTransition(n, n2, (Drawable)object2, bl);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
        ((StringBuilder)object).append(TRANSITION_MISSING_FROM_TO_ID);
        throw new XmlPullParserException(((StringBuilder)object).toString());
    }

    private boolean selectTransition(int n) {
        int n2;
        Transition transition = this.mTransition;
        if (transition != null) {
            if (n == this.mTransitionToIndex) {
                return true;
            }
            if (n == this.mTransitionFromIndex && transition.canReverse()) {
                transition.reverse();
                this.mTransitionToIndex = this.mTransitionFromIndex;
                this.mTransitionFromIndex = n;
                return true;
            }
            n2 = this.mTransitionToIndex;
            transition.stop();
        } else {
            n2 = this.getCurrentIndex();
        }
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        transition = this.mState;
        int n3 = transition.getKeyframeIdAt(n2);
        int n4 = transition.getKeyframeIdAt(n);
        if (n4 == 0) return false;
        if (n3 == 0) {
            return false;
        }
        int n5 = transition.indexOfTransition(n3, n4);
        if (n5 < 0) {
            return false;
        }
        boolean bl = transition.transitionHasReversibleFlag(n3, n4);
        this.selectDrawable(n5);
        Drawable drawable = this.getCurrent();
        if (drawable instanceof AnimationDrawable) {
            boolean bl2 = transition.isTransitionReversed(n3, n4);
            transition = new AnimationDrawableTransition((AnimationDrawable)drawable, bl2, bl);
        } else if (drawable instanceof AnimatedVectorDrawableCompat) {
            transition = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat)drawable);
        } else {
            if (!(drawable instanceof Animatable)) return false;
            transition = new AnimatableTransition((Animatable)drawable);
        }
        transition.start();
        this.mTransition = transition;
        this.mTransitionFromIndex = n2;
        this.mTransitionToIndex = n;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        AnimatedStateListState animatedStateListState = this.mState;
        if (Build.VERSION.SDK_INT >= 21) {
            animatedStateListState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        }
        animatedStateListState.setVariablePadding(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, animatedStateListState.mVariablePadding));
        animatedStateListState.setConstantSize(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, animatedStateListState.mConstantSize));
        animatedStateListState.setEnterFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, animatedStateListState.mEnterFadeDuration));
        animatedStateListState.setExitFadeDuration(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, animatedStateListState.mExitFadeDuration));
        this.setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, animatedStateListState.mDither));
    }

    public void addState(int[] nArray, Drawable drawable, int n) {
        if (drawable == null) throw new IllegalArgumentException("Drawable must not be null");
        this.mState.addStateSet(nArray, drawable, n);
        this.onStateChange(this.getState());
    }

    public <T extends Drawable> void addTransition(int n, int n2, T t, boolean bl) {
        if (t == null) throw new IllegalArgumentException("Transition drawable must not be null");
        this.mState.addTransition(n, n2, t, bl);
    }

    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArray = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.AnimatedStateListDrawableCompat);
        this.setVisible(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        this.updateStateFromTypedArray(typedArray);
        this.updateDensity(resources);
        typedArray.recycle();
        this.inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        this.init();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition transition = this.mTransition;
        if (transition == null) return;
        transition.stop();
        this.mTransition = null;
        this.selectDrawable(this.mTransitionToIndex);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
    }

    public Drawable mutate() {
        if (this.mMutated) return this;
        if (super.mutate() != this) return this;
        this.mState.mutate();
        this.mMutated = true;
        return this;
    }

    protected boolean onStateChange(int[] nArray) {
        int n = this.mState.indexOfKeyframe(nArray);
        boolean bl = n != this.getCurrentIndex() && (this.selectTransition(n) || this.selectDrawable(n));
        Drawable drawable = this.getCurrent();
        boolean bl2 = bl;
        if (drawable == null) return bl2;
        bl2 = bl | drawable.setState(nArray);
        return bl2;
    }

    void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (!(drawableContainerState instanceof AnimatedStateListState)) return;
        this.mState = (AnimatedStateListState)drawableContainerState;
    }

    public boolean setVisible(boolean bl, boolean bl2) {
        boolean bl3 = super.setVisible(bl, bl2);
        if (this.mTransition == null) return bl3;
        if (!bl3) {
            if (!bl2) return bl3;
        }
        if (bl) {
            this.mTransition.start();
        } else {
            this.jumpToCurrentState();
        }
        return bl3;
    }
}
