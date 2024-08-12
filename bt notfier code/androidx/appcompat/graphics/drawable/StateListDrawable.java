/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.StateSet
 *  androidx.appcompat.graphics.drawable.DrawableContainer
 *  androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState
 *  androidx.appcompat.graphics.drawable.StateListDrawable$StateListState
 *  androidx.appcompat.resources.R$styleable
 *  androidx.appcompat.widget.ResourceManagerInternal
 *  androidx.core.content.res.TypedArrayUtils
 */
package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.StateListDrawable;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class StateListDrawable
extends DrawableContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawable";
    private boolean mMutated;
    private StateListState mStateListState;

    StateListDrawable() {
        this(null, null);
    }

    StateListDrawable(StateListState stateListState) {
        if (stateListState == null) return;
        this.setConstantState((DrawableContainer.DrawableContainerState)stateListState);
    }

    StateListDrawable(StateListState stateListState, Resources resources) {
        this.setConstantState((DrawableContainer.DrawableContainerState)new StateListState(stateListState, this, resources));
        this.onStateChange(this.getState());
    }

    private void inflateChildElements(Context object, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int n;
        StateListState stateListState = this.mStateListState;
        int n2 = xmlPullParser.getDepth() + 1;
        while ((n = xmlPullParser.next()) != 1) {
            int n3 = xmlPullParser.getDepth();
            if (n3 < n2) {
                if (n == 3) return;
            }
            if (n != 2 || n3 > n2 || !xmlPullParser.getName().equals("item")) continue;
            TypedArray typedArray = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.StateListDrawableItem);
            Drawable drawable = null;
            n = typedArray.getResourceId(R.styleable.StateListDrawableItem_android_drawable, -1);
            if (n > 0) {
                drawable = ResourceManagerInternal.get().getDrawable((Context)object, n);
            }
            typedArray.recycle();
            int[] nArray = this.extractStateSet(attributeSet);
            typedArray = drawable;
            if (drawable == null) {
                while ((n = xmlPullParser.next()) == 4) {
                }
                if (n != 2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(xmlPullParser.getPositionDescription());
                    ((StringBuilder)object).append(": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    throw new XmlPullParserException(((StringBuilder)object).toString());
                }
                typedArray = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet, (Resources.Theme)theme) : Drawable.createFromXmlInner((Resources)resources, (XmlPullParser)xmlPullParser, (AttributeSet)attributeSet);
            }
            stateListState.addStateSet(nArray, (Drawable)typedArray);
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        StateListState stateListState = this.mStateListState;
        if (Build.VERSION.SDK_INT >= 21) {
            stateListState.mChangingConfigurations |= typedArray.getChangingConfigurations();
        }
        stateListState.mVariablePadding = typedArray.getBoolean(R.styleable.StateListDrawable_android_variablePadding, stateListState.mVariablePadding);
        stateListState.mConstantSize = typedArray.getBoolean(R.styleable.StateListDrawable_android_constantSize, stateListState.mConstantSize);
        stateListState.mEnterFadeDuration = typedArray.getInt(R.styleable.StateListDrawable_android_enterFadeDuration, stateListState.mEnterFadeDuration);
        stateListState.mExitFadeDuration = typedArray.getInt(R.styleable.StateListDrawable_android_exitFadeDuration, stateListState.mExitFadeDuration);
        stateListState.mDither = typedArray.getBoolean(R.styleable.StateListDrawable_android_dither, stateListState.mDither);
    }

    public void addState(int[] nArray, Drawable drawable) {
        if (drawable == null) return;
        this.mStateListState.addStateSet(nArray, drawable);
        this.onStateChange(this.getState());
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        this.onStateChange(this.getState());
    }

    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    int[] extractStateSet(AttributeSet attributeSet) {
        int n = attributeSet.getAttributeCount();
        int[] nArray = new int[n];
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            int n4 = attributeSet.getAttributeNameResource(n2);
            int n5 = n3;
            if (n4 != 0) {
                n5 = n3;
                if (n4 != 0x10100D0) {
                    n5 = n3;
                    if (n4 != 0x1010199) {
                        n5 = attributeSet.getAttributeBooleanValue(n2, false) ? n4 : -n4;
                        nArray[n3] = n5;
                        n5 = n3 + 1;
                    }
                }
            }
            ++n2;
            n3 = n5;
        }
        return StateSet.trimStateSet((int[])nArray, (int)n3);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    Drawable getStateDrawable(int n) {
        return this.mStateListState.getChild(n);
    }

    int getStateDrawableIndex(int[] nArray) {
        return this.mStateListState.indexOfStateSet(nArray);
    }

    StateListState getStateListState() {
        return this.mStateListState;
    }

    int[] getStateSet(int n) {
        return this.mStateListState.mStateSets[n];
    }

    public void inflate(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArray = TypedArrayUtils.obtainAttributes((Resources)resources, (Resources.Theme)theme, (AttributeSet)attributeSet, (int[])R.styleable.StateListDrawable);
        this.setVisible(typedArray.getBoolean(R.styleable.StateListDrawable_android_visible, true), true);
        this.updateStateFromTypedArray(typedArray);
        this.updateDensity(resources);
        typedArray.recycle();
        this.inflateChildElements(context, resources, xmlPullParser, attributeSet, theme);
        this.onStateChange(this.getState());
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (this.mMutated) return this;
        if (super.mutate() != this) return this;
        this.mStateListState.mutate();
        this.mMutated = true;
        return this;
    }

    protected boolean onStateChange(int[] nArray) {
        int n;
        boolean bl = super.onStateChange(nArray);
        int n2 = n = this.mStateListState.indexOfStateSet(nArray);
        if (n < 0) {
            n2 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
        }
        bl = this.selectDrawable(n2) || bl;
        return bl;
    }

    void setConstantState(DrawableContainer.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (!(drawableContainerState instanceof StateListState)) return;
        this.mStateListState = (StateListState)drawableContainerState;
    }
}
