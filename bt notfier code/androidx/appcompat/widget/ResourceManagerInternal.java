/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.Xml
 *  androidx.appcompat.resources.R$drawable
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.ResourceManagerInternal$AsldcInflateDelegate
 *  androidx.appcompat.widget.ResourceManagerInternal$AvdcInflateDelegate
 *  androidx.appcompat.widget.ResourceManagerInternal$ColorFilterLruCache
 *  androidx.appcompat.widget.ResourceManagerInternal$DrawableDelegate
 *  androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate
 *  androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks
 *  androidx.appcompat.widget.ResourceManagerInternal$VdcInflateDelegate
 *  androidx.appcompat.widget.TintInfo
 *  androidx.appcompat.widget.VectorEnabledTintResources
 *  androidx.collection.LongSparseArray
 *  androidx.collection.SimpleArrayMap
 *  androidx.collection.SparseArrayCompat
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourceManagerInternal {
    private static final ColorFilterLruCache COLOR_FILTER_CACHE;
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE;
    private static ResourceManagerInternal INSTANCE;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, InflateDelegate> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    }

    private void addDelegate(String string, InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap();
        }
        this.mDelegates.put((Object)string, (Object)inflateDelegate);
    }

    private boolean addDrawableToCache(Context object, long l, Drawable longSparseArray) {
        synchronized (this) {
            LongSparseArray longSparseArray2;
            Drawable.ConstantState constantState = longSparseArray.getConstantState();
            if (constantState == null) return false;
            longSparseArray = longSparseArray2 = this.mDrawableCaches.get(object);
            if (longSparseArray2 == null) {
                longSparseArray = new LongSparseArray();
                this.mDrawableCaches.put((Context)object, (LongSparseArray<WeakReference<Drawable.ConstantState>>)longSparseArray);
            }
            object = new WeakReference(constantState);
            longSparseArray.put(l, object);
            return true;
        }
    }

    private void addTintListToCache(Context context, int n, ColorStateList colorStateList) {
        SparseArrayCompat sparseArrayCompat;
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap();
        }
        SparseArrayCompat sparseArrayCompat2 = sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat2 = new SparseArrayCompat();
            this.mTintLists.put(context, (SparseArrayCompat<ColorStateList>)sparseArrayCompat2);
        }
        sparseArrayCompat2.append(n, (Object)colorStateList);
    }

    private void checkVectorDrawableSetup(Context context) {
        if (this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        if ((context = this.getDrawable(context, R.drawable.abc_vector_test)) != null && ResourceManagerInternal.isVectorDrawable((Drawable)context)) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    }

    private static long createCacheKey(TypedValue typedValue) {
        return (long)typedValue.assetCookie << 32 | (long)typedValue.data;
    }

    private Drawable createDrawableIfNeeded(Context context, int n) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(n, typedValue, true);
        long l = ResourceManagerInternal.createCacheKey(typedValue);
        Object object = this.getCachedDrawable(context, l);
        if (object != null) {
            return object;
        }
        object = this.mHooks;
        object = object == null ? null : object.createDrawableFor(this, context, n);
        if (object == null) return object;
        object.setChangingConfigurations(typedValue.changingConfigurations);
        this.addDrawableToCache(context, l, (Drawable)object);
        return object;
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] nArray) {
        if (colorStateList == null) return null;
        if (mode != null) return ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(nArray, 0), mode);
        return null;
    }

    public static ResourceManagerInternal get() {
        synchronized (ResourceManagerInternal.class) {
            ResourceManagerInternal resourceManagerInternal;
            if (INSTANCE == null) {
                INSTANCE = resourceManagerInternal = new ResourceManagerInternal();
                ResourceManagerInternal.installDefaultInflateDelegates(resourceManagerInternal);
            }
            resourceManagerInternal = INSTANCE;
            return resourceManagerInternal;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private Drawable getCachedDrawable(Context context, long l) {
        synchronized (this) {
            void var2_2;
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference)longSparseArray.get((long)var2_2);
            if (weakReference == null) return null;
            if ((weakReference = (Drawable.ConstantState)weakReference.get()) != null) {
                return weakReference.newDrawable(context.getResources());
            }
            longSparseArray.remove((long)var2_2);
            return null;
        }
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int n, PorterDuff.Mode mode) {
        synchronized (ResourceManagerInternal.class) {
            PorterDuffColorFilter porterDuffColorFilter;
            PorterDuffColorFilter porterDuffColorFilter2 = porterDuffColorFilter = COLOR_FILTER_CACHE.get(n, mode);
            if (porterDuffColorFilter != null) return porterDuffColorFilter2;
            porterDuffColorFilter2 = new PorterDuffColorFilter(n, mode);
            COLOR_FILTER_CACHE.put(n, mode, porterDuffColorFilter2);
            return porterDuffColorFilter2;
        }
    }

    private ColorStateList getTintListFromCache(Context sparseArrayCompat, int n) {
        ColorStateList colorStateList;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
        ColorStateList colorStateList2 = colorStateList = null;
        if (weakHashMap == null) return colorStateList2;
        sparseArrayCompat = weakHashMap.get(sparseArrayCompat);
        colorStateList2 = colorStateList;
        if (sparseArrayCompat == null) return colorStateList2;
        colorStateList2 = (ColorStateList)sparseArrayCompat.get(n);
        return colorStateList2;
    }

    private static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT >= 24) return;
        resourceManagerInternal.addDelegate("vector", (InflateDelegate)new VdcInflateDelegate());
        resourceManagerInternal.addDelegate("animated-vector", (InflateDelegate)new AvdcInflateDelegate());
        resourceManagerInternal.addDelegate("animated-selector", (InflateDelegate)new AsldcInflateDelegate());
        resourceManagerInternal.addDelegate("drawable", (InflateDelegate)new DrawableDelegate());
    }

    private static boolean isVectorDrawable(Drawable drawable2) {
        boolean bl = drawable2 instanceof VectorDrawableCompat || PLATFORM_VD_CLAZZ.equals(drawable2.getClass().getName());
        return bl;
    }

    private Drawable loadDrawableFromDelegates(Context object, int n) {
        Object object2 = this.mDelegates;
        if (object2 == null) return null;
        if (object2.isEmpty()) return null;
        object2 = this.mKnownDrawableIdTags;
        if (object2 != null) {
            if (SKIP_DRAWABLE_TAG.equals(object2 = (String)object2.get(n))) return null;
            if (object2 != null && this.mDelegates.get(object2) == null) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new SparseArrayCompat();
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        object2 = object.getResources();
        object2.getValue(n, typedValue, true);
        long l = ResourceManagerInternal.createCacheKey(typedValue);
        Drawable drawable2 = this.getCachedDrawable((Context)object, l);
        if (drawable2 != null) {
            return drawable2;
        }
        Drawable drawable3 = drawable2;
        if (typedValue.string != null) {
            drawable3 = drawable2;
            if (typedValue.string.toString().endsWith(".xml")) {
                drawable3 = drawable2;
                try {
                    int n2;
                    XmlResourceParser xmlResourceParser = object2.getXml(n);
                    drawable3 = drawable2;
                    AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlResourceParser);
                    do {
                        drawable3 = drawable2;
                    } while ((n2 = xmlResourceParser.next()) != 2 && n2 != 1);
                    if (n2 != 2) {
                        drawable3 = drawable2;
                        drawable3 = drawable2;
                        object = new XmlPullParserException("No start tag found");
                        drawable3 = drawable2;
                        throw object;
                    }
                    drawable3 = drawable2;
                    object2 = xmlResourceParser.getName();
                    drawable3 = drawable2;
                    this.mKnownDrawableIdTags.append(n, object2);
                    drawable3 = drawable2;
                    InflateDelegate inflateDelegate = (InflateDelegate)this.mDelegates.get(object2);
                    object2 = drawable2;
                    if (inflateDelegate != null) {
                        drawable3 = drawable2;
                        object2 = inflateDelegate.createFromXmlInner(object, (XmlPullParser)xmlResourceParser, attributeSet, object.getTheme());
                    }
                    drawable3 = object2;
                    if (object2 != null) {
                        drawable3 = object2;
                        object2.setChangingConfigurations(typedValue.changingConfigurations);
                        drawable3 = object2;
                        this.addDrawableToCache((Context)object, l, (Drawable)object2);
                        drawable3 = object2;
                    }
                }
                catch (Exception exception) {
                    Log.e((String)TAG, (String)"Exception while inflating drawable", (Throwable)exception);
                }
            }
        }
        if (drawable3 != null) return drawable3;
        this.mKnownDrawableIdTags.append(n, (Object)SKIP_DRAWABLE_TAG);
        return drawable3;
    }

    private Drawable tintDrawable(Context context, int n, boolean bl, Drawable drawable2) {
        ColorStateList colorStateList = this.getTintList(context, n);
        if (colorStateList != null) {
            context = drawable2;
            if (DrawableUtils.canSafelyMutateDrawable((Drawable)drawable2)) {
                context = drawable2.mutate();
            }
            context = DrawableCompat.wrap((Drawable)context);
            DrawableCompat.setTintList((Drawable)context, (ColorStateList)colorStateList);
            drawable2 = this.getTintMode(n);
            colorStateList = context;
            if (drawable2 == null) return colorStateList;
            DrawableCompat.setTintMode((Drawable)context, (PorterDuff.Mode)drawable2);
            colorStateList = context;
        } else {
            colorStateList = this.mHooks;
            if (colorStateList != null && colorStateList.tintDrawable(context, n, drawable2)) {
                colorStateList = drawable2;
            } else {
                colorStateList = drawable2;
                if (this.tintDrawableUsingColorFilter(context, n, drawable2)) return colorStateList;
                colorStateList = drawable2;
                if (!bl) return colorStateList;
                colorStateList = null;
            }
        }
        return colorStateList;
    }

    static void tintDrawable(Drawable drawable2, TintInfo tintInfo, int[] nArray) {
        if (DrawableUtils.canSafelyMutateDrawable((Drawable)drawable2) && drawable2.mutate() != drawable2) {
            Log.d((String)TAG, (String)"Mutated drawable is not the same instance as the input.");
            return;
        }
        if (!tintInfo.mHasTintList && !tintInfo.mHasTintMode) {
            drawable2.clearColorFilter();
        } else {
            ColorStateList colorStateList = tintInfo.mHasTintList ? tintInfo.mTintList : null;
            tintInfo = tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE;
            drawable2.setColorFilter((ColorFilter)ResourceManagerInternal.createTintFilter(colorStateList, (PorterDuff.Mode)tintInfo, nArray));
        }
        if (Build.VERSION.SDK_INT > 23) return;
        drawable2.invalidateSelf();
    }

    public Drawable getDrawable(Context context, int n) {
        synchronized (this) {
            context = this.getDrawable(context, n, false);
            return context;
        }
    }

    Drawable getDrawable(Context context, int n, boolean bl) {
        synchronized (this) {
            Drawable drawable2;
            this.checkVectorDrawableSetup(context);
            Drawable drawable3 = drawable2 = this.loadDrawableFromDelegates(context, n);
            if (drawable2 == null) {
                drawable3 = this.createDrawableIfNeeded(context, n);
            }
            drawable2 = drawable3;
            if (drawable3 == null) {
                drawable2 = ContextCompat.getDrawable((Context)context, (int)n);
            }
            drawable3 = drawable2;
            if (drawable2 != null) {
                drawable3 = this.tintDrawable(context, n, bl, drawable2);
            }
            if (drawable3 == null) return drawable3;
            DrawableUtils.fixDrawable((Drawable)drawable3);
            return drawable3;
        }
    }

    ColorStateList getTintList(Context context, int n) {
        synchronized (this) {
            Object object;
            ColorStateList colorStateList = object = this.getTintListFromCache(context, n);
            if (object != null) return colorStateList;
            object = this.mHooks == null ? null : this.mHooks.getTintListForDrawableRes(context, n);
            colorStateList = object;
            if (object == null) return colorStateList;
            this.addTintListToCache(context, n, (ColorStateList)object);
            colorStateList = object;
            return colorStateList;
        }
    }

    PorterDuff.Mode getTintMode(int n) {
        Object object = this.mHooks;
        object = object == null ? null : object.getTintModeForDrawableRes(n);
        return object;
    }

    public void onConfigurationChanged(Context longSparseArray) {
        synchronized (this) {
            longSparseArray = this.mDrawableCaches.get(longSparseArray);
            if (longSparseArray == null) return;
            longSparseArray.clear();
            return;
        }
    }

    Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int n) {
        synchronized (this) {
            Drawable drawable2;
            Drawable drawable3 = drawable2 = this.loadDrawableFromDelegates(context, n);
            if (drawable2 == null) {
                drawable3 = vectorEnabledTintResources.superGetDrawable(n);
            }
            if (drawable3 == null) return null;
            context = this.tintDrawable(context, n, false, drawable3);
            return context;
        }
    }

    public void setHooks(ResourceManagerHooks resourceManagerHooks) {
        synchronized (this) {
            this.mHooks = resourceManagerHooks;
            return;
        }
    }

    boolean tintDrawableUsingColorFilter(Context context, int n, Drawable drawable2) {
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        boolean bl = resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, n, drawable2);
        return bl;
    }
}
