/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 *  androidx.appcompat.graphics.drawable.DrawableContainer
 *  androidx.appcompat.graphics.drawable.DrawableContainer$Api21Impl
 *  androidx.core.graphics.drawable.DrawableCompat
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.core.graphics.drawable.DrawableCompat;

/*
 * Exception performing whole class analysis ignored.
 */
static abstract class DrawableContainer.DrawableContainerState
extends Drawable.ConstantState {
    boolean mAutoMirrored;
    boolean mCanConstantState;
    int mChangingConfigurations;
    boolean mCheckedConstantSize;
    boolean mCheckedConstantState;
    boolean mCheckedOpacity;
    boolean mCheckedPadding;
    boolean mCheckedStateful;
    int mChildrenChangingConfigurations;
    ColorFilter mColorFilter;
    int mConstantHeight;
    int mConstantMinimumHeight;
    int mConstantMinimumWidth;
    Rect mConstantPadding;
    boolean mConstantSize;
    int mConstantWidth;
    int mDensity;
    boolean mDither;
    SparseArray<Drawable.ConstantState> mDrawableFutures;
    Drawable[] mDrawables;
    int mEnterFadeDuration;
    int mExitFadeDuration;
    boolean mHasColorFilter;
    boolean mHasTintList;
    boolean mHasTintMode;
    int mLayoutDirection;
    boolean mMutated;
    int mNumChildren;
    int mOpacity;
    final DrawableContainer mOwner;
    Resources mSourceRes;
    boolean mStateful;
    ColorStateList mTintList;
    PorterDuff.Mode mTintMode;
    boolean mVariablePadding;

    DrawableContainer.DrawableContainerState(DrawableContainer.DrawableContainerState constantState, DrawableContainer object, Resources resources) {
        int n = 0;
        this.mVariablePadding = false;
        this.mConstantSize = false;
        this.mDither = true;
        this.mEnterFadeDuration = 0;
        this.mExitFadeDuration = 0;
        this.mOwner = object;
        Object var7_5 = null;
        object = resources != null ? resources : (constantState != null ? constantState.mSourceRes : null);
        this.mSourceRes = object;
        int n2 = constantState != null ? constantState.mDensity : 0;
        this.mDensity = n2 = DrawableContainer.resolveDensity((Resources)resources, (int)n2);
        if (constantState == null) {
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
            return;
        }
        this.mChangingConfigurations = constantState.mChangingConfigurations;
        this.mChildrenChangingConfigurations = constantState.mChildrenChangingConfigurations;
        this.mCheckedConstantState = true;
        this.mCanConstantState = true;
        this.mVariablePadding = constantState.mVariablePadding;
        this.mConstantSize = constantState.mConstantSize;
        this.mDither = constantState.mDither;
        this.mMutated = constantState.mMutated;
        this.mLayoutDirection = constantState.mLayoutDirection;
        this.mEnterFadeDuration = constantState.mEnterFadeDuration;
        this.mExitFadeDuration = constantState.mExitFadeDuration;
        this.mAutoMirrored = constantState.mAutoMirrored;
        this.mColorFilter = constantState.mColorFilter;
        this.mHasColorFilter = constantState.mHasColorFilter;
        this.mTintList = constantState.mTintList;
        this.mTintMode = constantState.mTintMode;
        this.mHasTintList = constantState.mHasTintList;
        this.mHasTintMode = constantState.mHasTintMode;
        if (constantState.mDensity == n2) {
            if (constantState.mCheckedPadding) {
                object = var7_5;
                if (constantState.mConstantPadding != null) {
                    object = new Rect(constantState.mConstantPadding);
                }
                this.mConstantPadding = object;
                this.mCheckedPadding = true;
            }
            if (constantState.mCheckedConstantSize) {
                this.mConstantWidth = constantState.mConstantWidth;
                this.mConstantHeight = constantState.mConstantHeight;
                this.mConstantMinimumWidth = constantState.mConstantMinimumWidth;
                this.mConstantMinimumHeight = constantState.mConstantMinimumHeight;
                this.mCheckedConstantSize = true;
            }
        }
        if (constantState.mCheckedOpacity) {
            this.mOpacity = constantState.mOpacity;
            this.mCheckedOpacity = true;
        }
        if (constantState.mCheckedStateful) {
            this.mStateful = constantState.mStateful;
            this.mCheckedStateful = true;
        }
        object = constantState.mDrawables;
        this.mDrawables = new Drawable[((Drawable[])object).length];
        this.mNumChildren = constantState.mNumChildren;
        constantState = constantState.mDrawableFutures;
        this.mDrawableFutures = constantState != null ? constantState.clone() : new SparseArray(this.mNumChildren);
        int n3 = this.mNumChildren;
        n2 = n;
        while (n2 < n3) {
            if (object[n2] != null) {
                constantState = object[n2].getConstantState();
                if (constantState != null) {
                    this.mDrawableFutures.put(n2, (Object)constantState);
                } else {
                    this.mDrawables[n2] = object[n2];
                }
            }
            ++n2;
        }
    }

    private void createAllFutures() {
        Drawable.ConstantState constantState = this.mDrawableFutures;
        if (constantState == null) return;
        int n = constantState.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mDrawableFutures = null;
                return;
            }
            int n3 = this.mDrawableFutures.keyAt(n2);
            constantState = (Drawable.ConstantState)this.mDrawableFutures.valueAt(n2);
            this.mDrawables[n3] = this.prepareDrawable(constantState.newDrawable(this.mSourceRes));
            ++n2;
        }
    }

    private Drawable prepareDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            DrawableCompat.setLayoutDirection((Drawable)drawable, (int)this.mLayoutDirection);
        }
        drawable = drawable.mutate();
        drawable.setCallback((Drawable.Callback)this.mOwner);
        return drawable;
    }

    public final int addChild(Drawable drawable) {
        int n = this.mNumChildren;
        if (n >= this.mDrawables.length) {
            this.growArray(n, n + 10);
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback((Drawable.Callback)this.mOwner);
        this.mDrawables[n] = drawable;
        ++this.mNumChildren;
        int n2 = this.mChildrenChangingConfigurations;
        this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | n2;
        this.invalidateCache();
        this.mConstantPadding = null;
        this.mCheckedPadding = false;
        this.mCheckedConstantSize = false;
        this.mCheckedConstantState = false;
        return n;
    }

    final void applyTheme(Resources.Theme theme) {
        if (theme == null) return;
        this.createAllFutures();
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.updateDensity(DrawableContainer.Api21Impl.getResources((Resources.Theme)theme));
                return;
            }
            if (drawableArray[n2] != null && DrawableCompat.canApplyTheme((Drawable)drawableArray[n2])) {
                DrawableCompat.applyTheme((Drawable)drawableArray[n2], (Resources.Theme)theme);
                this.mChildrenChangingConfigurations |= drawableArray[n2].getChangingConfigurations();
            }
            ++n2;
        }
    }

    public boolean canApplyTheme() {
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n2 = 0;
        while (n2 < n) {
            Drawable drawable = drawableArray[n2];
            if (drawable != null ? DrawableCompat.canApplyTheme((Drawable)drawable) : (drawable = (Drawable.ConstantState)this.mDrawableFutures.get(n2)) != null && DrawableContainer.Api21Impl.canApplyTheme((Drawable.ConstantState)drawable)) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public boolean canConstantState() {
        if (this.mCheckedConstantState) {
            return this.mCanConstantState;
        }
        this.createAllFutures();
        this.mCheckedConstantState = true;
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mCanConstantState = true;
                return true;
            }
            if (drawableArray[n2].getConstantState() == null) {
                this.mCanConstantState = false;
                return false;
            }
            ++n2;
        }
    }

    final void clearMutated() {
        this.mMutated = false;
    }

    protected void computeConstantSize() {
        this.mCheckedConstantSize = true;
        this.createAllFutures();
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        this.mConstantHeight = -1;
        this.mConstantWidth = -1;
        int n2 = 0;
        this.mConstantMinimumHeight = 0;
        this.mConstantMinimumWidth = 0;
        while (n2 < n) {
            Drawable drawable = drawableArray[n2];
            int n3 = drawable.getIntrinsicWidth();
            if (n3 > this.mConstantWidth) {
                this.mConstantWidth = n3;
            }
            if ((n3 = drawable.getIntrinsicHeight()) > this.mConstantHeight) {
                this.mConstantHeight = n3;
            }
            if ((n3 = drawable.getMinimumWidth()) > this.mConstantMinimumWidth) {
                this.mConstantMinimumWidth = n3;
            }
            if ((n3 = drawable.getMinimumHeight()) > this.mConstantMinimumHeight) {
                this.mConstantMinimumHeight = n3;
            }
            ++n2;
        }
    }

    final int getCapacity() {
        return this.mDrawables.length;
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
    }

    public final Drawable getChild(int n) {
        Drawable drawable = this.mDrawables[n];
        if (drawable != null) {
            return drawable;
        }
        drawable = this.mDrawableFutures;
        if (drawable == null) return null;
        int n2 = drawable.indexOfKey(n);
        if (n2 < 0) return null;
        this.mDrawables[n] = drawable = this.prepareDrawable(((Drawable.ConstantState)this.mDrawableFutures.valueAt(n2)).newDrawable(this.mSourceRes));
        this.mDrawableFutures.removeAt(n2);
        if (this.mDrawableFutures.size() != 0) return drawable;
        this.mDrawableFutures = null;
        return drawable;
    }

    public final int getChildCount() {
        return this.mNumChildren;
    }

    public final int getConstantHeight() {
        if (this.mCheckedConstantSize) return this.mConstantHeight;
        this.computeConstantSize();
        return this.mConstantHeight;
    }

    public final int getConstantMinimumHeight() {
        if (this.mCheckedConstantSize) return this.mConstantMinimumHeight;
        this.computeConstantSize();
        return this.mConstantMinimumHeight;
    }

    public final int getConstantMinimumWidth() {
        if (this.mCheckedConstantSize) return this.mConstantMinimumWidth;
        this.computeConstantSize();
        return this.mConstantMinimumWidth;
    }

    public final Rect getConstantPadding() {
        boolean bl = this.mVariablePadding;
        Rect rect = null;
        if (bl) {
            return null;
        }
        if (this.mConstantPadding != null) return this.mConstantPadding;
        if (this.mCheckedPadding) {
            return this.mConstantPadding;
        }
        this.createAllFutures();
        Rect rect2 = new Rect();
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mCheckedPadding = true;
                this.mConstantPadding = rect;
                return rect;
            }
            Rect rect3 = rect;
            if (drawableArray[n2].getPadding(rect2)) {
                Rect rect4 = rect;
                if (rect == null) {
                    rect4 = new Rect(0, 0, 0, 0);
                }
                if (rect2.left > rect4.left) {
                    rect4.left = rect2.left;
                }
                if (rect2.top > rect4.top) {
                    rect4.top = rect2.top;
                }
                if (rect2.right > rect4.right) {
                    rect4.right = rect2.right;
                }
                rect3 = rect4;
                if (rect2.bottom > rect4.bottom) {
                    rect4.bottom = rect2.bottom;
                    rect3 = rect4;
                }
            }
            ++n2;
            rect = rect3;
        }
    }

    public final int getConstantWidth() {
        if (this.mCheckedConstantSize) return this.mConstantWidth;
        this.computeConstantSize();
        return this.mConstantWidth;
    }

    public final int getEnterFadeDuration() {
        return this.mEnterFadeDuration;
    }

    public final int getExitFadeDuration() {
        return this.mExitFadeDuration;
    }

    public final int getOpacity() {
        if (this.mCheckedOpacity) {
            return this.mOpacity;
        }
        this.createAllFutures();
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n2 = n > 0 ? drawableArray[0].getOpacity() : -2;
        int n3 = 1;
        while (true) {
            if (n3 >= n) {
                this.mOpacity = n2;
                this.mCheckedOpacity = true;
                return n2;
            }
            n2 = Drawable.resolveOpacity((int)n2, (int)drawableArray[n3].getOpacity());
            ++n3;
        }
    }

    public void growArray(int n, int n2) {
        Drawable[] drawableArray = new Drawable[n2];
        Drawable[] drawableArray2 = this.mDrawables;
        if (drawableArray2 != null) {
            System.arraycopy(drawableArray2, 0, drawableArray, 0, n);
        }
        this.mDrawables = drawableArray;
    }

    void invalidateCache() {
        this.mCheckedOpacity = false;
        this.mCheckedStateful = false;
    }

    public final boolean isConstantSize() {
        return this.mConstantSize;
    }

    public final boolean isStateful() {
        boolean bl;
        if (this.mCheckedStateful) {
            return this.mStateful;
        }
        this.createAllFutures();
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        boolean bl2 = false;
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            if (drawableArray[n2].isStateful()) {
                bl = true;
                break;
            }
            ++n2;
        }
        this.mStateful = bl;
        this.mCheckedStateful = true;
        return bl;
    }

    void mutate() {
        int n = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mMutated = true;
                return;
            }
            if (drawableArray[n2] != null) {
                drawableArray[n2].mutate();
            }
            ++n2;
        }
    }

    public final void setConstantSize(boolean bl) {
        this.mConstantSize = bl;
    }

    public final void setEnterFadeDuration(int n) {
        this.mEnterFadeDuration = n;
    }

    public final void setExitFadeDuration(int n) {
        this.mExitFadeDuration = n;
    }

    final boolean setLayoutDirection(int n, int n2) {
        int n3 = this.mNumChildren;
        Drawable[] drawableArray = this.mDrawables;
        int n4 = 0;
        boolean bl = false;
        while (true) {
            if (n4 >= n3) {
                this.mLayoutDirection = n;
                return bl;
            }
            boolean bl2 = bl;
            if (drawableArray[n4] != null) {
                boolean bl3 = Build.VERSION.SDK_INT >= 23 ? DrawableCompat.setLayoutDirection((Drawable)drawableArray[n4], (int)n) : false;
                bl2 = bl;
                if (n4 == n2) {
                    bl2 = bl3;
                }
            }
            ++n4;
            bl = bl2;
        }
    }

    public final void setVariablePadding(boolean bl) {
        this.mVariablePadding = bl;
    }

    final void updateDensity(Resources resources) {
        if (resources == null) return;
        this.mSourceRes = resources;
        int n = DrawableContainer.resolveDensity((Resources)resources, (int)this.mDensity);
        int n2 = this.mDensity;
        this.mDensity = n;
        if (n2 == n) return;
        this.mCheckedConstantSize = false;
        this.mCheckedPadding = false;
    }
}
