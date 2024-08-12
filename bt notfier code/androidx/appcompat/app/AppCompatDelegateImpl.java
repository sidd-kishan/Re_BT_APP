/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.UiModeManager
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.AndroidRuntimeException
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.view.ContextThemeWrapper
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.PopupWindow
 *  android.widget.TextView
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$color
 *  androidx.appcompat.R$id
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.R$style
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.app.ActionBar
 *  androidx.appcompat.app.ActionBarDrawerToggle$Delegate
 *  androidx.appcompat.app.AppCompatActivity
 *  androidx.appcompat.app.AppCompatCallback
 *  androidx.appcompat.app.AppCompatDelegate
 *  androidx.appcompat.app.AppCompatDelegateImpl$ActionBarDrawableToggleImpl
 *  androidx.appcompat.app.AppCompatDelegateImpl$ActionMenuPresenterCallback
 *  androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9
 *  androidx.appcompat.app.AppCompatDelegateImpl$Api17Impl
 *  androidx.appcompat.app.AppCompatDelegateImpl$Api24Impl
 *  androidx.appcompat.app.AppCompatDelegateImpl$Api26Impl
 *  androidx.appcompat.app.AppCompatDelegateImpl$AppCompatWindowCallback
 *  androidx.appcompat.app.AppCompatDelegateImpl$AutoBatteryNightModeManager
 *  androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager
 *  androidx.appcompat.app.AppCompatDelegateImpl$AutoTimeNightModeManager
 *  androidx.appcompat.app.AppCompatDelegateImpl$ContextThemeWrapperCompatApi17Impl
 *  androidx.appcompat.app.AppCompatDelegateImpl$ListMenuDecorView
 *  androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState
 *  androidx.appcompat.app.AppCompatDelegateImpl$PanelMenuPresenterCallback
 *  androidx.appcompat.app.AppCompatDialog
 *  androidx.appcompat.app.AppCompatViewInflater
 *  androidx.appcompat.app.LayoutIncludeDetector
 *  androidx.appcompat.app.ResourcesFlusher
 *  androidx.appcompat.app.ToolbarActionBar
 *  androidx.appcompat.app.TwilightManager
 *  androidx.appcompat.app.WindowDecorActionBar
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.appcompat.view.StandaloneActionMode
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.widget.ActionBarContextView
 *  androidx.appcompat.widget.AppCompatDrawableManager
 *  androidx.appcompat.widget.ContentFrameLayout
 *  androidx.appcompat.widget.ContentFrameLayout$OnAttachListener
 *  androidx.appcompat.widget.DecorContentParent
 *  androidx.appcompat.widget.FitWindowsViewGroup
 *  androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.VectorEnabledTintResources
 *  androidx.appcompat.widget.ViewStubCompat
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.app.ActivityCompat
 *  androidx.core.app.NavUtils
 *  androidx.core.content.ContextCompat
 *  androidx.core.content.res.ResourcesCompat$ThemeCompat
 *  androidx.core.util.ObjectsCompat
 *  androidx.core.view.KeyEventDispatcher
 *  androidx.core.view.KeyEventDispatcher$Component
 *  androidx.core.view.LayoutInflaterCompat
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewPropertyAnimatorCompat
 *  androidx.core.view.ViewPropertyAnimatorListener
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.widget.PopupWindowCompat
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.app.LayoutIncludeDetector;
import androidx.appcompat.app.ResourcesFlusher;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.app.TwilightManager;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import org.xmlpull.v1.XmlPullParser;

/*
 * Exception performing whole class analysis ignored.
 */
class AppCompatDelegateImpl
extends AppCompatDelegate
implements MenuBuilder.Callback,
LayoutInflater.Factory2 {
    static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP;
    private static final boolean sCanApplyOverrideConfiguration;
    private static final boolean sCanReturnDifferentContext;
    private static boolean sInstalledExceptionHandler;
    private static final SimpleArrayMap<String, Integer> sLocalNightModes;
    private static final int[] sWindowBackgroundStyleable;
    ActionBar mActionBar;
    private ActionMenuPresenterCallback mActionMenuPresenterCallback;
    ActionMode mActionMode;
    PopupWindow mActionModePopup;
    ActionBarContextView mActionModeView;
    private boolean mActivityHandlesUiMode;
    private boolean mActivityHandlesUiModeChecked;
    final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatWindowCallback mAppCompatWindowCallback;
    private AutoNightModeManager mAutoBatteryNightModeManager;
    private AutoNightModeManager mAutoTimeNightModeManager;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    ViewPropertyAnimatorCompat mFadeAnim = null;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes = true;
    boolean mHasActionBar;
    final Object mHost;
    int mInvalidatePanelMenuFeatures;
    boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable = new /* Unavailable Anonymous Inner Class!! */;
    boolean mIsDestroyed;
    boolean mIsFloating;
    private LayoutIncludeDetector mLayoutIncludeDetector;
    private int mLocalNightMode = -100;
    private boolean mLongPressBackDown;
    MenuInflater mMenuInflater;
    boolean mOverlayActionBar;
    boolean mOverlayActionMode;
    private PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private PanelFeatureState[] mPanels;
    private PanelFeatureState mPreparedPanel;
    Runnable mShowActionModePopup;
    private boolean mStarted;
    private View mStatusGuard;
    ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    Window mWindow;
    boolean mWindowNoTitle;

    static {
        sLocalNightModes = new SimpleArrayMap();
        int n = Build.VERSION.SDK_INT;
        boolean bl = false;
        boolean bl2 = n < 21;
        IS_PRE_LOLLIPOP = bl2;
        sWindowBackgroundStyleable = new int[]{16842836};
        sCanReturnDifferentContext = "robolectric".equals(Build.FINGERPRINT) ^ true;
        bl2 = bl;
        if (Build.VERSION.SDK_INT >= 17) {
            bl2 = true;
        }
        sCanApplyOverrideConfiguration = bl2;
        if (!IS_PRE_LOLLIPOP) return;
        if (sInstalledExceptionHandler) return;
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new /* Unavailable Anonymous Inner Class!! */);
        sInstalledExceptionHandler = true;
    }

    AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this((Context)activity, null, appCompatCallback, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        this(dialog.getContext(), dialog.getWindow(), appCompatCallback, dialog);
    }

    AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
    }

    AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    private AppCompatDelegateImpl(Context object, Window window, AppCompatCallback appCompatCallback, Object object2) {
        this.mContext = object;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = object2;
        if (this.mLocalNightMode == -100 && object2 instanceof Dialog && (object = this.tryUnwrapContext()) != null) {
            this.mLocalNightMode = object.getDelegate().getLocalNightMode();
        }
        if (this.mLocalNightMode == -100 && (object = (Integer)sLocalNightModes.get((Object)this.mHost.getClass().getName())) != null) {
            this.mLocalNightMode = (Integer)object;
            sLocalNightModes.remove((Object)this.mHost.getClass().getName());
        }
        if (window != null) {
            this.attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    private boolean applyDayNight(boolean bl) {
        AutoNightModeManager autoNightModeManager;
        if (this.mIsDestroyed) {
            return false;
        }
        int n = this.calculateNightMode();
        bl = this.updateForNightMode(this.mapNightMode(this.mContext, n), bl);
        if (n == 0) {
            this.getAutoTimeNightModeManager(this.mContext).setup();
        } else {
            autoNightModeManager = this.mAutoTimeNightModeManager;
            if (autoNightModeManager != null) {
                autoNightModeManager.cleanup();
            }
        }
        if (n == 3) {
            this.getAutoBatteryNightModeManager(this.mContext).setup();
        } else {
            autoNightModeManager = this.mAutoBatteryNightModeManager;
            if (autoNightModeManager == null) return bl;
            autoNightModeManager.cleanup();
        }
        return bl;
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(0x1020002);
        View view = this.mWindow.getDecorView();
        contentFrameLayout.setDecorPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        view = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        view.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        view.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (view.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            view.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        view.recycle();
        contentFrameLayout.requestLayout();
    }

    private void attachToWindow(Window window) {
        if (this.mWindow != null) throw new IllegalStateException("AppCompat has already installed itself into the Window");
        Window.Callback callback = window.getCallback();
        if (callback instanceof AppCompatWindowCallback) throw new IllegalStateException("AppCompat has already installed itself into the Window");
        callback = new AppCompatWindowCallback(this, callback);
        this.mAppCompatWindowCallback = callback;
        window.setCallback(callback);
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.mContext, null, (int[])sWindowBackgroundStyleable);
        callback = tintTypedArray.getDrawableIfKnown(0);
        if (callback != null) {
            window.setBackgroundDrawable((Drawable)callback);
        }
        tintTypedArray.recycle();
        this.mWindow = window;
    }

    private int calculateNightMode() {
        int n = this.mLocalNightMode;
        if (n != -100) return n;
        n = AppCompatDelegateImpl.getDefaultNightMode();
        return n;
    }

    private void cleanupAutoManagers() {
        AutoNightModeManager autoNightModeManager = this.mAutoTimeNightModeManager;
        if (autoNightModeManager != null) {
            autoNightModeManager.cleanup();
        }
        if ((autoNightModeManager = this.mAutoBatteryNightModeManager) == null) return;
        autoNightModeManager.cleanup();
    }

    private Configuration createOverrideConfigurationForDayNight(Context context, int n, Configuration configuration) {
        n = n != 1 ? (n != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 0x30 : 32) : 16;
        context = new Configuration();
        context.fontScale = 0.0f;
        if (configuration != null) {
            context.setTo(configuration);
        }
        context.uiMode = n | context.uiMode & 0xFFFFFFCF;
        return context;
    }

    private ViewGroup createSubDecor() {
        ContentFrameLayout contentFrameLayout;
        Object object = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (!object.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            object.recycle();
            object = new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            throw object;
        }
        if (object.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
            this.requestWindowFeature(1);
        } else if (object.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
            this.requestWindowFeature(108);
        }
        if (object.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            this.requestWindowFeature(109);
        }
        if (object.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            this.requestWindowFeature(10);
        }
        this.mIsFloating = object.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
        object.recycle();
        this.ensureWindow();
        this.mWindow.getDecorView();
        object = LayoutInflater.from((Context)this.mContext);
        if (!this.mWindowNoTitle) {
            if (this.mIsFloating) {
                object = (ViewGroup)object.inflate(R.layout.abc_dialog_title_material, null);
                this.mOverlayActionBar = false;
                this.mHasActionBar = false;
            } else if (this.mHasActionBar) {
                object = new TypedValue();
                this.mContext.getTheme().resolveAttribute(R.attr.actionBarTheme, (TypedValue)object, true);
                object = ((TypedValue)object).resourceId != 0 ? new ContextThemeWrapper(this.mContext, ((TypedValue)object).resourceId) : this.mContext;
                contentFrameLayout = (ViewGroup)LayoutInflater.from((Context)object).inflate(R.layout.abc_screen_toolbar, null);
                object = (DecorContentParent)contentFrameLayout.findViewById(R.id.decor_content_parent);
                this.mDecorContentParent = object;
                object.setWindowCallback(this.getWindowCallback());
                if (this.mOverlayActionBar) {
                    this.mDecorContentParent.initFeature(109);
                }
                if (this.mFeatureProgress) {
                    this.mDecorContentParent.initFeature(2);
                }
                object = contentFrameLayout;
                if (this.mFeatureIndeterminateProgress) {
                    this.mDecorContentParent.initFeature(5);
                    object = contentFrameLayout;
                }
            } else {
                object = null;
            }
        } else {
            object = this.mOverlayActionMode ? (ViewGroup)object.inflate(R.layout.abc_screen_simple_overlay_action_mode, null) : (ViewGroup)object.inflate(R.layout.abc_screen_simple, null);
        }
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("AppCompat does not support the current theme features: { windowActionBar: ");
            ((StringBuilder)object).append(this.mHasActionBar);
            ((StringBuilder)object).append(", windowActionBarOverlay: ");
            ((StringBuilder)object).append(this.mOverlayActionBar);
            ((StringBuilder)object).append(", android:windowIsFloating: ");
            ((StringBuilder)object).append(this.mIsFloating);
            ((StringBuilder)object).append(", windowActionModeOverlay: ");
            ((StringBuilder)object).append(this.mOverlayActionMode);
            ((StringBuilder)object).append(", windowNoTitle: ");
            ((StringBuilder)object).append(this.mWindowNoTitle);
            ((StringBuilder)object).append(" }");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            ViewCompat.setOnApplyWindowInsetsListener((View)object, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
        } else if (object instanceof FitWindowsViewGroup) {
            ((FitWindowsViewGroup)object).setOnFitSystemWindowsListener((FitWindowsViewGroup.OnFitSystemWindowsListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (this.mDecorContentParent == null) {
            this.mTitleView = (TextView)object.findViewById(R.id.title);
        }
        ViewUtils.makeOptionalFitsSystemWindows((View)object);
        contentFrameLayout = (ContentFrameLayout)object.findViewById(R.id.action_bar_activity_content);
        ViewGroup viewGroup = (ViewGroup)this.mWindow.findViewById(0x1020002);
        if (viewGroup != null) {
            while (viewGroup.getChildCount() > 0) {
                View view = viewGroup.getChildAt(0);
                viewGroup.removeViewAt(0);
                contentFrameLayout.addView(view);
            }
            viewGroup.setId(-1);
            contentFrameLayout.setId(0x1020002);
            if (viewGroup instanceof FrameLayout) {
                ((FrameLayout)viewGroup).setForeground(null);
            }
        }
        this.mWindow.setContentView((View)object);
        contentFrameLayout.setAttachListener((ContentFrameLayout.OnAttachListener)new /* Unavailable Anonymous Inner Class!! */);
        return object;
    }

    private void ensureSubDecor() {
        if (this.mSubDecorInstalled) return;
        this.mSubDecor = this.createSubDecor();
        CharSequence charSequence = this.getTitle();
        if (!TextUtils.isEmpty((CharSequence)charSequence)) {
            DecorContentParent decorContentParent = this.mDecorContentParent;
            if (decorContentParent != null) {
                decorContentParent.setWindowTitle(charSequence);
            } else if (this.peekSupportActionBar() != null) {
                this.peekSupportActionBar().setWindowTitle(charSequence);
            } else {
                decorContentParent = this.mTitleView;
                if (decorContentParent != null) {
                    decorContentParent.setText(charSequence);
                }
            }
        }
        this.applyFixedSizeWindow();
        this.onSubDecorInstalled(this.mSubDecor);
        this.mSubDecorInstalled = true;
        charSequence = this.getPanelState(0, false);
        if (this.mIsDestroyed) return;
        if (charSequence != null) {
            if (((PanelFeatureState)charSequence).menu != null) return;
        }
        this.invalidatePanelMenu(108);
    }

    private void ensureWindow() {
        Object object;
        if (this.mWindow == null && (object = this.mHost) instanceof Activity) {
            this.attachToWindow(((Activity)object).getWindow());
        }
        if (this.mWindow == null) throw new IllegalStateException("We have not been given a Window");
    }

    private static Configuration generateConfigDelta(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 == null) return configuration3;
        if (configuration.diff(configuration2) == 0) return configuration3;
        if (configuration.fontScale != configuration2.fontScale) {
            configuration3.fontScale = configuration2.fontScale;
        }
        if (configuration.mcc != configuration2.mcc) {
            configuration3.mcc = configuration2.mcc;
        }
        if (configuration.mnc != configuration2.mnc) {
            configuration3.mnc = configuration2.mnc;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Api24Impl.generateConfigDelta_locale((Configuration)configuration, (Configuration)configuration2, (Configuration)configuration3);
        } else if (!ObjectsCompat.equals((Object)configuration.locale, (Object)configuration2.locale)) {
            configuration3.locale = configuration2.locale;
        }
        if (configuration.touchscreen != configuration2.touchscreen) {
            configuration3.touchscreen = configuration2.touchscreen;
        }
        if (configuration.keyboard != configuration2.keyboard) {
            configuration3.keyboard = configuration2.keyboard;
        }
        if (configuration.keyboardHidden != configuration2.keyboardHidden) {
            configuration3.keyboardHidden = configuration2.keyboardHidden;
        }
        if (configuration.navigation != configuration2.navigation) {
            configuration3.navigation = configuration2.navigation;
        }
        if (configuration.navigationHidden != configuration2.navigationHidden) {
            configuration3.navigationHidden = configuration2.navigationHidden;
        }
        if (configuration.orientation != configuration2.orientation) {
            configuration3.orientation = configuration2.orientation;
        }
        if ((configuration.screenLayout & 0xF) != (configuration2.screenLayout & 0xF)) {
            configuration3.screenLayout |= configuration2.screenLayout & 0xF;
        }
        if ((configuration.screenLayout & 0xC0) != (configuration2.screenLayout & 0xC0)) {
            configuration3.screenLayout |= configuration2.screenLayout & 0xC0;
        }
        if ((configuration.screenLayout & 0x30) != (configuration2.screenLayout & 0x30)) {
            configuration3.screenLayout |= configuration2.screenLayout & 0x30;
        }
        if ((configuration.screenLayout & 0x300) != (configuration2.screenLayout & 0x300)) {
            configuration3.screenLayout |= configuration2.screenLayout & 0x300;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.generateConfigDelta_colorMode((Configuration)configuration, (Configuration)configuration2, (Configuration)configuration3);
        }
        if ((configuration.uiMode & 0xF) != (configuration2.uiMode & 0xF)) {
            configuration3.uiMode |= configuration2.uiMode & 0xF;
        }
        if ((configuration.uiMode & 0x30) != (configuration2.uiMode & 0x30)) {
            configuration3.uiMode |= configuration2.uiMode & 0x30;
        }
        if (configuration.screenWidthDp != configuration2.screenWidthDp) {
            configuration3.screenWidthDp = configuration2.screenWidthDp;
        }
        if (configuration.screenHeightDp != configuration2.screenHeightDp) {
            configuration3.screenHeightDp = configuration2.screenHeightDp;
        }
        if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
            configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
        }
        if (Build.VERSION.SDK_INT < 17) return configuration3;
        Api17Impl.generateConfigDelta_densityDpi((Configuration)configuration, (Configuration)configuration2, (Configuration)configuration3);
        return configuration3;
    }

    private AutoNightModeManager getAutoBatteryNightModeManager(Context context) {
        if (this.mAutoBatteryNightModeManager != null) return this.mAutoBatteryNightModeManager;
        this.mAutoBatteryNightModeManager = new AutoBatteryNightModeManager(this, context);
        return this.mAutoBatteryNightModeManager;
    }

    private AutoNightModeManager getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager != null) return this.mAutoTimeNightModeManager;
        this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(this, TwilightManager.getInstance((Context)context));
        return this.mAutoTimeNightModeManager;
    }

    private void initWindowDecorActionBar() {
        this.ensureSubDecor();
        if (!this.mHasActionBar) return;
        if (this.mActionBar != null) return;
        Object object = this.mHost;
        if (object instanceof Activity) {
            this.mActionBar = new WindowDecorActionBar((Activity)this.mHost, this.mOverlayActionBar);
        } else if (object instanceof Dialog) {
            this.mActionBar = new WindowDecorActionBar((Dialog)this.mHost);
        }
        object = this.mActionBar;
        if (object == null) return;
        object.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
    }

    private boolean initializePanelContent(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.createdPanelView;
        boolean bl = true;
        if (view != null) {
            panelFeatureState.shownPanelView = panelFeatureState.createdPanelView;
            return true;
        }
        if (panelFeatureState.menu == null) {
            return false;
        }
        if (this.mPanelMenuPresenterCallback == null) {
            this.mPanelMenuPresenterCallback = new PanelMenuPresenterCallback(this);
        }
        panelFeatureState.shownPanelView = (View)panelFeatureState.getListMenuView((MenuPresenter.Callback)this.mPanelMenuPresenterCallback);
        if (panelFeatureState.shownPanelView != null) return bl;
        bl = false;
        return bl;
    }

    private boolean initializePanelDecor(PanelFeatureState panelFeatureState) {
        panelFeatureState.setStyle(this.getActionBarThemedContext());
        panelFeatureState.decorView = new ListMenuDecorView(this, panelFeatureState.listPresenterContext);
        panelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(PanelFeatureState panelFeatureState) {
        Context context;
        block10: {
            Context context2;
            block9: {
                context2 = this.mContext;
                if (panelFeatureState.featureId == 0) break block9;
                context = context2;
                if (panelFeatureState.featureId != 108) break block10;
            }
            context = context2;
            if (this.mDecorContentParent != null) {
                TypedValue typedValue = new TypedValue();
                Resources.Theme theme = context2.getTheme();
                theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                context = null;
                if (typedValue.resourceId != 0) {
                    context = context2.getResources().newTheme();
                    context.setTo(theme);
                    context.applyStyle(typedValue.resourceId, true);
                    context.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                } else {
                    theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                }
                Context context3 = context;
                if (typedValue.resourceId != 0) {
                    context3 = context;
                    if (context == null) {
                        context3 = context2.getResources().newTheme();
                        context3.setTo(theme);
                    }
                    context3.applyStyle(typedValue.resourceId, true);
                }
                context = context2;
                if (context3 != null) {
                    context = new ContextThemeWrapper(context2, 0);
                    context.getTheme().setTo((Resources.Theme)context3);
                }
            }
        }
        context = new MenuBuilder(context);
        context.setCallback((MenuBuilder.Callback)this);
        panelFeatureState.setMenu((MenuBuilder)context);
        return true;
    }

    private void invalidatePanelMenu(int n) {
        this.mInvalidatePanelMenuFeatures = 1 << n | this.mInvalidatePanelMenuFeatures;
        if (this.mInvalidatePanelMenuPosted) return;
        ViewCompat.postOnAnimation((View)this.mWindow.getDecorView(), (Runnable)this.mInvalidatePanelMenuRunnable);
        this.mInvalidatePanelMenuPosted = true;
    }

    private boolean isActivityManifestHandlingUiMode() {
        if (!this.mActivityHandlesUiModeChecked && this.mHost instanceof Activity) {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int n = Build.VERSION.SDK_INT >= 29 ? 0x100C0000 : (Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                ComponentName componentName = new ComponentName(this.mContext, this.mHost.getClass());
                componentName = packageManager.getActivityInfo(componentName, n);
                boolean bl = componentName != null && (componentName.configChanges & 0x200) != 0;
                this.mActivityHandlesUiMode = bl;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.d((String)"AppCompatDelegate", (String)"Exception while getting ActivityInfo", (Throwable)nameNotFoundException);
                this.mActivityHandlesUiMode = false;
            }
        }
        this.mActivityHandlesUiModeChecked = true;
        return this.mActivityHandlesUiMode;
    }

    private boolean onKeyDownPanel(int n, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) return false;
        PanelFeatureState panelFeatureState = this.getPanelState(n, true);
        if (panelFeatureState.isOpen) return false;
        return this.preparePanel(panelFeatureState, keyEvent);
    }

    /*
     * Unable to fully structure code
     */
    private boolean onKeyUpPanel(int var1_1, KeyEvent var2_2) {
        block9: {
            block10: {
                block7: {
                    block8: {
                        if (this.mActionMode != null) {
                            return false;
                        }
                        var4_3 = true;
                        var5_4 = this.getPanelState(var1_1, true);
                        if (var1_1 != 0 || (var6_5 = this.mDecorContentParent) == null || !var6_5.canShowOverflowMenu() || ViewConfiguration.get((Context)this.mContext).hasPermanentMenuKey()) break block7;
                        if (this.mDecorContentParent.isOverflowMenuShowing()) break block8;
                        if (this.mIsDestroyed || !this.preparePanel(var5_4, var2_2)) ** GOTO lbl-1000
                        var3_6 = this.mDecorContentParent.showOverflowMenu();
                        break block9;
                    }
                    var3_6 = this.mDecorContentParent.hideOverflowMenu();
                    break block9;
                }
                if (var5_4.isOpen || var5_4.isHandled) break block10;
                if (!var5_4.isPrepared) ** GOTO lbl-1000
                if (var5_4.refreshMenuContent) {
                    var5_4.isPrepared = false;
                    var3_6 = this.preparePanel(var5_4, var2_2);
                } else {
                    var3_6 = true;
                }
                if (var3_6) {
                    this.openPanel(var5_4, var2_2);
                    var3_6 = var4_3;
                } else lbl-1000:
                // 3 sources

                {
                    var3_6 = false;
                }
                break block9;
            }
            var3_6 = var5_4.isOpen;
            this.closePanel(var5_4, true);
        }
        if (var3_6 == false) return var3_6;
        var2_2 = (AudioManager)this.mContext.getApplicationContext().getSystemService("audio");
        if (var2_2 != null) {
            var2_2.playSoundEffect(0);
        } else {
            Log.w((String)"AppCompatDelegate", (String)"Couldn't get audio manager");
        }
        return var3_6;
    }

    private void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        block18: {
            WindowManager windowManager;
            int n;
            block17: {
                block16: {
                    Window.Callback callback;
                    block15: {
                        if (panelFeatureState.isOpen) return;
                        if (this.mIsDestroyed) return;
                        if (panelFeatureState.featureId == 0 && (n = (this.mContext.getResources().getConfiguration().screenLayout & 0xF) == 4 ? 1 : 0) != 0) {
                            return;
                        }
                        callback = this.getWindowCallback();
                        if (callback != null && !callback.onMenuOpened(panelFeatureState.featureId, (Menu)panelFeatureState.menu)) {
                            this.closePanel(panelFeatureState, true);
                            return;
                        }
                        windowManager = (WindowManager)this.mContext.getSystemService("window");
                        if (windowManager == null) {
                            return;
                        }
                        if (!this.preparePanel(panelFeatureState, keyEvent)) {
                            return;
                        }
                        if (panelFeatureState.decorView == null || panelFeatureState.refreshDecorView) break block15;
                        if (panelFeatureState.createdPanelView == null || (keyEvent = panelFeatureState.createdPanelView.getLayoutParams()) == null || keyEvent.width != -1) break block16;
                        n = -1;
                        break block17;
                    }
                    if (panelFeatureState.decorView == null) {
                        if (!this.initializePanelDecor(panelFeatureState)) return;
                        if (panelFeatureState.decorView == null) {
                            return;
                        }
                    } else if (panelFeatureState.refreshDecorView && panelFeatureState.decorView.getChildCount() > 0) {
                        panelFeatureState.decorView.removeAllViews();
                    }
                    if (!this.initializePanelContent(panelFeatureState) || !panelFeatureState.hasPanelItems()) break block18;
                    callback = panelFeatureState.shownPanelView.getLayoutParams();
                    keyEvent = callback;
                    if (callback == null) {
                        keyEvent = new ViewGroup.LayoutParams(-2, -2);
                    }
                    n = panelFeatureState.background;
                    panelFeatureState.decorView.setBackgroundResource(n);
                    callback = panelFeatureState.shownPanelView.getParent();
                    if (callback instanceof ViewGroup) {
                        ((ViewGroup)callback).removeView(panelFeatureState.shownPanelView);
                    }
                    panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, (ViewGroup.LayoutParams)keyEvent);
                    if (!panelFeatureState.shownPanelView.hasFocus()) {
                        panelFeatureState.shownPanelView.requestFocus();
                    }
                }
                n = -2;
            }
            panelFeatureState.isHandled = false;
            keyEvent = new WindowManager.LayoutParams(n, -2, panelFeatureState.x, panelFeatureState.y, 1002, 0x820000, -3);
            keyEvent.gravity = panelFeatureState.gravity;
            keyEvent.windowAnimations = panelFeatureState.windowAnimations;
            windowManager.addView((View)panelFeatureState.decorView, (ViewGroup.LayoutParams)keyEvent);
            panelFeatureState.isOpen = true;
            return;
        }
        panelFeatureState.refreshDecorView = true;
    }

    private boolean performPanelShortcut(PanelFeatureState panelFeatureState, int n, KeyEvent keyEvent, int n2) {
        boolean bl;
        block6: {
            boolean bl2;
            block5: {
                bl = keyEvent.isSystem();
                bl2 = false;
                if (bl) {
                    return false;
                }
                if (panelFeatureState.isPrepared) break block5;
                bl = bl2;
                if (!this.preparePanel(panelFeatureState, keyEvent)) break block6;
            }
            bl = bl2;
            if (panelFeatureState.menu != null) {
                bl = panelFeatureState.menu.performShortcut(n, keyEvent, n2);
            }
        }
        if (!bl) return bl;
        if ((n2 & 1) != 0) return bl;
        if (this.mDecorContentParent != null) return bl;
        this.closePanel(panelFeatureState, true);
        return bl;
    }

    private boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        Window.Callback callback;
        if (this.mIsDestroyed) {
            return false;
        }
        if (panelFeatureState.isPrepared) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            this.closePanel(panelFeatureState2, false);
        }
        if ((callback = this.getWindowCallback()) != null) {
            panelFeatureState.createdPanelView = callback.onCreatePanelView(panelFeatureState.featureId);
        }
        int n = panelFeatureState.featureId != 0 && panelFeatureState.featureId != 108 ? 0 : 1;
        if (n != 0 && (panelFeatureState2 = this.mDecorContentParent) != null) {
            panelFeatureState2.setMenuPrepared();
        }
        if (!(panelFeatureState.createdPanelView != null || n != 0 && this.peekSupportActionBar() instanceof ToolbarActionBar)) {
            if (panelFeatureState.menu == null || panelFeatureState.refreshMenuContent) {
                if (panelFeatureState.menu == null) {
                    if (!this.initializePanelMenu(panelFeatureState)) return false;
                    if (panelFeatureState.menu == null) {
                        return false;
                    }
                }
                if (n != 0 && this.mDecorContentParent != null) {
                    if (this.mActionMenuPresenterCallback == null) {
                        this.mActionMenuPresenterCallback = new ActionMenuPresenterCallback(this);
                    }
                    this.mDecorContentParent.setMenu((Menu)panelFeatureState.menu, (MenuPresenter.Callback)this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                if (!callback.onCreatePanelMenu(panelFeatureState.featureId, (Menu)panelFeatureState.menu)) {
                    panelFeatureState.setMenu(null);
                    if (n == 0) return false;
                    panelFeatureState = this.mDecorContentParent;
                    if (panelFeatureState == null) return false;
                    panelFeatureState.setMenu(null, (MenuPresenter.Callback)this.mActionMenuPresenterCallback);
                    return false;
                }
                panelFeatureState.refreshMenuContent = false;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            if (panelFeatureState.frozenActionViewState != null) {
                panelFeatureState.menu.restoreActionViewStates(panelFeatureState.frozenActionViewState);
                panelFeatureState.frozenActionViewState = null;
            }
            if (!callback.onPreparePanel(0, panelFeatureState.createdPanelView, (Menu)panelFeatureState.menu)) {
                if (n != 0 && (keyEvent = this.mDecorContentParent) != null) {
                    keyEvent.setMenu(null, (MenuPresenter.Callback)this.mActionMenuPresenterCallback);
                }
                panelFeatureState.menu.startDispatchingItemsChanged();
                return false;
            }
            n = keyEvent != null ? keyEvent.getDeviceId() : -1;
            boolean bl = KeyCharacterMap.load((int)n).getKeyboardType() != 1;
            panelFeatureState.qwertyMode = bl;
            panelFeatureState.menu.setQwertyMode(panelFeatureState.qwertyMode);
            panelFeatureState.menu.startDispatchingItemsChanged();
        }
        panelFeatureState.isPrepared = true;
        panelFeatureState.isHandled = false;
        this.mPreparedPanel = panelFeatureState;
        return true;
    }

    private void reopenMenu(boolean bl) {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null && decorContentParent.canShowOverflowMenu() && (!ViewConfiguration.get((Context)this.mContext).hasPermanentMenuKey() || this.mDecorContentParent.isOverflowMenuShowPending())) {
            decorContentParent = this.getWindowCallback();
            if (this.mDecorContentParent.isOverflowMenuShowing() && bl) {
                this.mDecorContentParent.hideOverflowMenu();
                if (this.mIsDestroyed) return;
                decorContentParent.onPanelClosed(108, (Menu)this.getPanelState((int)0, (boolean)true).menu);
            } else {
                if (decorContentParent == null) return;
                if (this.mIsDestroyed) return;
                if (this.mInvalidatePanelMenuPosted && (this.mInvalidatePanelMenuFeatures & 1) != 0) {
                    this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
                    this.mInvalidatePanelMenuRunnable.run();
                }
                PanelFeatureState panelFeatureState = this.getPanelState(0, true);
                if (panelFeatureState.menu == null) return;
                if (panelFeatureState.refreshMenuContent) return;
                if (!decorContentParent.onPreparePanel(0, panelFeatureState.createdPanelView, (Menu)panelFeatureState.menu)) return;
                decorContentParent.onMenuOpened(108, (Menu)panelFeatureState.menu);
                this.mDecorContentParent.showOverflowMenu();
            }
            return;
        }
        decorContentParent = this.getPanelState(0, true);
        decorContentParent.refreshDecorView = true;
        this.closePanel((PanelFeatureState)decorContentParent, false);
        this.openPanel((PanelFeatureState)decorContentParent, null);
    }

    private int sanitizeWindowFeatureId(int n) {
        if (n == 8) {
            Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        int n2 = n;
        if (n != 9) return n2;
        Log.i((String)"AppCompatDelegate", (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        n2 = 109;
        return n2;
    }

    private boolean shouldInheritContext(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View view = this.mWindow.getDecorView();
        while (viewParent != null) {
            if (viewParent == view) return false;
            if (!(viewParent instanceof View)) return false;
            if (ViewCompat.isAttachedToWindow((View)((View)viewParent))) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) throw new AndroidRuntimeException("Window feature must be requested before adding content");
    }

    private AppCompatActivity tryUnwrapContext() {
        Context context = this.mContext;
        while (context != null) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity)context;
            }
            if (!(context instanceof ContextWrapper)) return null;
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    private boolean updateForNightMode(int n, boolean bl) {
        Object object = this.createOverrideConfigurationForDayNight(this.mContext, n, null);
        boolean bl2 = this.isActivityManifestHandlingUiMode();
        int n2 = this.mContext.getResources().getConfiguration().uiMode & 0x30;
        int n3 = object.uiMode & 0x30;
        boolean bl3 = true;
        if (n2 != n3 && bl && !bl2 && this.mBaseContextAttached && (sCanReturnDifferentContext || this.mCreated) && (object = this.mHost) instanceof Activity && !((Activity)object).isChild()) {
            ActivityCompat.recreate((Activity)((Activity)this.mHost));
            bl = true;
        } else {
            bl = false;
        }
        if (!bl && n2 != n3) {
            this.updateResourcesConfigurationForNightMode(n3, bl2, null);
            bl = bl3;
        }
        if (!bl) return bl;
        object = this.mHost;
        if (!(object instanceof AppCompatActivity)) return bl;
        ((AppCompatActivity)object).onNightModeChanged(n);
        return bl;
    }

    private void updateResourcesConfigurationForNightMode(int n, boolean bl, Configuration object) {
        Resources resources = this.mContext.getResources();
        Configuration configuration = new Configuration(resources.getConfiguration());
        if (object != null) {
            configuration.updateFrom(object);
        }
        configuration.uiMode = n | resources.getConfiguration().uiMode & 0xFFFFFFCF;
        resources.updateConfiguration(configuration, null);
        if (Build.VERSION.SDK_INT < 26) {
            ResourcesFlusher.flush((Resources)resources);
        }
        if ((n = this.mThemeResId) != 0) {
            this.mContext.setTheme(n);
            if (Build.VERSION.SDK_INT >= 23) {
                this.mContext.getTheme().applyStyle(this.mThemeResId, true);
            }
        }
        if (!bl) return;
        object = this.mHost;
        if (!(object instanceof Activity)) return;
        if ((object = (Activity)object) instanceof LifecycleOwner) {
            if (!((LifecycleOwner)object).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) return;
            object.onConfigurationChanged(configuration);
        } else {
            if (!this.mStarted) return;
            object.onConfigurationChanged(configuration);
        }
    }

    private void updateStatusGuardColor(View view) {
        int n = (ViewCompat.getWindowSystemUiVisibility((View)view) & 0x2000) != 0 ? 1 : 0;
        n = n != 0 ? ContextCompat.getColor((Context)this.mContext, (int)R.color.abc_decor_view_status_guard_light) : ContextCompat.getColor((Context)this.mContext, (int)R.color.abc_decor_view_status_guard);
        view.setBackgroundColor(n);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.ensureSubDecor();
        ((ViewGroup)this.mSubDecor.findViewById(0x1020002)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public boolean applyDayNight() {
        return this.applyDayNight(true);
    }

    public Context attachBaseContext2(Context context) {
        int n = 1;
        this.mBaseContextAttached = true;
        int n2 = this.mapNightMode(context, this.calculateNightMode());
        boolean bl = sCanApplyOverrideConfiguration;
        Configuration configuration = null;
        if (bl && context instanceof android.view.ContextThemeWrapper) {
            Configuration configuration2 = this.createOverrideConfigurationForDayNight(context, n2, null);
            try {
                ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper)((android.view.ContextThemeWrapper)context), (Configuration)configuration2);
                return context;
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
        }
        if (context instanceof ContextThemeWrapper) {
            Configuration configuration3 = this.createOverrideConfigurationForDayNight(context, n2, null);
            try {
                ((ContextThemeWrapper)context).applyOverrideConfiguration(configuration3);
                return context;
            }
            catch (IllegalStateException illegalStateException) {
                // empty catch block
            }
        }
        if (!sCanReturnDifferentContext) {
            return super.attachBaseContext2(context);
        }
        Configuration configuration4 = configuration;
        if (Build.VERSION.SDK_INT >= 17) {
            configuration4 = new Configuration();
            configuration4.uiMode = -1;
            configuration4.fontScale = 0.0f;
            Configuration configuration5 = Api17Impl.createConfigurationContext((Context)context, (Configuration)configuration4).getResources().getConfiguration();
            Configuration configuration6 = context.getResources().getConfiguration();
            configuration5.uiMode = configuration6.uiMode;
            configuration4 = configuration;
            if (!configuration5.equals(configuration6)) {
                configuration4 = AppCompatDelegateImpl.generateConfigDelta(configuration5, configuration6);
            }
        }
        configuration = this.createOverrideConfigurationForDayNight(context, n2, configuration4);
        configuration4 = new ContextThemeWrapper(context, R.style.Theme_AppCompat_Empty);
        configuration4.applyOverrideConfiguration(configuration);
        n2 = 0;
        try {
            context = context.getTheme();
            if (context == null) {
                n = 0;
            }
        }
        catch (NullPointerException nullPointerException) {
            n = n2;
        }
        if (n == 0) return super.attachBaseContext2((Context)configuration4);
        ResourcesCompat.ThemeCompat.rebase((Resources.Theme)configuration4.getTheme());
        return super.attachBaseContext2((Context)configuration4);
    }

    void callOnPanelClosed(int n, PanelFeatureState panelFeatureState, Menu menu) {
        PanelFeatureState panelFeatureState2 = panelFeatureState;
        Menu menu2 = menu;
        if (menu == null) {
            PanelFeatureState panelFeatureState3 = panelFeatureState;
            if (panelFeatureState == null) {
                panelFeatureState3 = panelFeatureState;
                if (n >= 0) {
                    panelFeatureState2 = this.mPanels;
                    panelFeatureState3 = panelFeatureState;
                    if (n < ((PanelFeatureState[])panelFeatureState2).length) {
                        panelFeatureState3 = panelFeatureState2[n];
                    }
                }
            }
            panelFeatureState2 = panelFeatureState3;
            menu2 = menu;
            if (panelFeatureState3 != null) {
                menu2 = panelFeatureState3.menu;
                panelFeatureState2 = panelFeatureState3;
            }
        }
        if (panelFeatureState2 != null && !panelFeatureState2.isOpen) {
            return;
        }
        if (this.mIsDestroyed) return;
        this.mAppCompatWindowCallback.getWrapped().onPanelClosed(n, menu2);
    }

    void checkCloseActionMenu(MenuBuilder menuBuilder) {
        if (this.mClosingActionMenu) {
            return;
        }
        this.mClosingActionMenu = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback callback = this.getWindowCallback();
        if (callback != null && !this.mIsDestroyed) {
            callback.onPanelClosed(108, (Menu)menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    void closePanel(int n) {
        this.closePanel(this.getPanelState(n, true), true);
    }

    void closePanel(PanelFeatureState panelFeatureState, boolean bl) {
        DecorContentParent decorContentParent;
        if (bl && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null && decorContentParent.isOverflowMenuShowing()) {
            this.checkCloseActionMenu(panelFeatureState.menu);
            return;
        }
        decorContentParent = (WindowManager)this.mContext.getSystemService("window");
        if (decorContentParent != null && panelFeatureState.isOpen && panelFeatureState.decorView != null) {
            decorContentParent.removeView((View)panelFeatureState.decorView);
            if (bl) {
                this.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel != panelFeatureState) return;
        this.mPreparedPanel = null;
    }

    public View createView(View view, String string, Context context, AttributeSet attributeSet) {
        Object object = this.mAppCompatViewInflater;
        boolean bl = false;
        if (object == null) {
            object = this.mContext.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (object == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (AppCompatViewInflater)Class.forName((String)object).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                }
                catch (Throwable throwable) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to instantiate custom view inflater ");
                    stringBuilder.append((String)object);
                    stringBuilder.append(". Falling back to default.");
                    Log.i((String)"AppCompatDelegate", (String)stringBuilder.toString(), (Throwable)throwable);
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                }
            }
        }
        if (IS_PRE_LOLLIPOP) {
            if (this.mLayoutIncludeDetector == null) {
                this.mLayoutIncludeDetector = new LayoutIncludeDetector();
            }
            if (this.mLayoutIncludeDetector.detect(attributeSet)) {
                bl = true;
            } else if (attributeSet instanceof XmlPullParser) {
                if (((XmlPullParser)((Object)attributeSet)).getDepth() <= 1) return this.mAppCompatViewInflater.createView(view, string, context, attributeSet, bl, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
                bl = true;
            } else {
                bl = this.shouldInheritContext((ViewParent)view);
            }
        } else {
            bl = false;
        }
        return this.mAppCompatViewInflater.createView(view, string, context, attributeSet, bl, IS_PRE_LOLLIPOP, true, VectorEnabledTintResources.shouldBeUsed());
    }

    void dismissPopups() {
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.dismissPopups();
        }
        if (this.mActionModePopup != null) {
            this.mWindow.getDecorView().removeCallbacks(this.mShowActionModePopup);
            if (this.mActionModePopup.isShowing()) {
                try {
                    this.mActionModePopup.dismiss();
                }
                catch (IllegalArgumentException illegalArgumentException) {}
            }
            this.mActionModePopup = null;
        }
        this.endOnGoingFadeAnimation();
        decorContentParent = this.getPanelState(0, false);
        if (decorContentParent == null) return;
        if (decorContentParent.menu == null) return;
        decorContentParent.menu.close();
    }

    boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Object object = this.mHost;
        boolean bl = object instanceof KeyEventDispatcher.Component;
        boolean bl2 = true;
        if ((bl || object instanceof AppCompatDialog) && (object = this.mWindow.getDecorView()) != null && KeyEventDispatcher.dispatchBeforeHierarchy((View)object, (KeyEvent)keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.mAppCompatWindowCallback.getWrapped().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int n = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            bl2 = false;
        }
        bl = bl2 ? this.onKeyDown(n, keyEvent) : this.onKeyUp(n, keyEvent);
        return bl;
    }

    void doInvalidatePanelMenu(int n) {
        Bundle bundle;
        PanelFeatureState panelFeatureState = this.getPanelState(n, true);
        if (panelFeatureState.menu != null) {
            bundle = new Bundle();
            panelFeatureState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelFeatureState.frozenActionViewState = bundle;
            }
            panelFeatureState.menu.stopDispatchingItemsChanged();
            panelFeatureState.menu.clear();
        }
        panelFeatureState.refreshMenuContent = true;
        panelFeatureState.refreshDecorView = true;
        if (n != 108) {
            if (n != 0) return;
        }
        if (this.mDecorContentParent == null) return;
        bundle = this.getPanelState(0, false);
        if (bundle == null) return;
        bundle.isPrepared = false;
        this.preparePanel((PanelFeatureState)bundle, null);
    }

    void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat == null) return;
        viewPropertyAnimatorCompat.cancel();
    }

    PanelFeatureState findMenuPanel(Menu menu) {
        PanelFeatureState[] panelFeatureStateArray = this.mPanels;
        int n = 0;
        int n2 = panelFeatureStateArray != null ? panelFeatureStateArray.length : 0;
        while (n < n2) {
            PanelFeatureState panelFeatureState = panelFeatureStateArray[n];
            if (panelFeatureState != null && panelFeatureState.menu == menu) {
                return panelFeatureState;
            }
            ++n;
        }
        return null;
    }

    public <T extends View> T findViewById(int n) {
        this.ensureSubDecor();
        return (T)this.mWindow.findViewById(n);
    }

    final Context getActionBarThemedContext() {
        Object object = this.getSupportActionBar();
        object = object != null ? object.getThemedContext() : null;
        ActionBar actionBar = object;
        if (object != null) return actionBar;
        actionBar = this.mContext;
        return actionBar;
    }

    final AutoNightModeManager getAutoTimeNightModeManager() {
        return this.getAutoTimeNightModeManager(this.mContext);
    }

    public final ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return new ActionBarDrawableToggleImpl(this);
    }

    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    public MenuInflater getMenuInflater() {
        if (this.mMenuInflater != null) return this.mMenuInflater;
        this.initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        actionBar = actionBar != null ? actionBar.getThemedContext() : this.mContext;
        this.mMenuInflater = new SupportMenuInflater((Context)actionBar);
        return this.mMenuInflater;
    }

    protected PanelFeatureState getPanelState(int n, boolean bl) {
        PanelFeatureState panelFeatureState;
        PanelFeatureState panelFeatureState2;
        PanelFeatureState panelFeatureState3;
        block5: {
            block4: {
                panelFeatureState3 = this.mPanels;
                if (panelFeatureState3 == null) break block4;
                panelFeatureState2 = panelFeatureState3;
                if (((PanelFeatureState[])panelFeatureState3).length > n) break block5;
            }
            panelFeatureState2 = new PanelFeatureState[n + 1];
            if (panelFeatureState3 != null) {
                System.arraycopy(panelFeatureState3, 0, panelFeatureState2, 0, ((PanelFeatureState)panelFeatureState3).length);
            }
            this.mPanels = panelFeatureState2;
        }
        panelFeatureState3 = panelFeatureState = panelFeatureState2[n];
        if (panelFeatureState != null) return panelFeatureState3;
        panelFeatureState2[n] = panelFeatureState3 = new PanelFeatureState(n);
        return panelFeatureState3;
    }

    ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    public ActionBar getSupportActionBar() {
        this.initWindowDecorActionBar();
        return this.mActionBar;
    }

    final CharSequence getTitle() {
        Object object = this.mHost;
        if (!(object instanceof Activity)) return this.mTitle;
        return ((Activity)object).getTitle();
    }

    final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public boolean hasWindowFeature(int n) {
        int n2 = this.sanitizeWindowFeatureId(n);
        boolean bl = true;
        boolean bl2 = n2 != 1 ? (n2 != 2 ? (n2 != 5 ? (n2 != 10 ? (n2 != 108 ? (n2 != 109 ? false : this.mOverlayActionBar) : this.mHasActionBar) : this.mOverlayActionMode) : this.mFeatureIndeterminateProgress) : this.mFeatureProgress) : this.mWindowNoTitle;
        boolean bl3 = bl;
        if (bl2) return bl3;
        bl3 = this.mWindow.hasFeature(n) ? bl : false;
        return bl3;
    }

    public void installViewFactory() {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.mContext);
        if (layoutInflater.getFactory() == null) {
            LayoutInflaterCompat.setFactory2((LayoutInflater)layoutInflater, (LayoutInflater.Factory2)this);
        } else {
            if (layoutInflater.getFactory2() instanceof AppCompatDelegateImpl) return;
            Log.i((String)"AppCompatDelegate", (String)"The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void invalidateOptionsMenu() {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null && actionBar.invalidateOptionsMenu()) {
            return;
        }
        this.invalidatePanelMenu(0);
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    int mapNightMode(Context context, int n) {
        if (n == -100) return -1;
        if (n == -1) return n;
        if (n != 0) {
            if (n == 1) return n;
            if (n == 2) return n;
            if (n != 3) throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            return this.getAutoBatteryNightModeManager(context).getApplyableNightMode();
        }
        if (Build.VERSION.SDK_INT < 23) return this.getAutoTimeNightModeManager(context).getApplyableNightMode();
        if (((UiModeManager)context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) return this.getAutoTimeNightModeManager(context).getApplyableNightMode();
        return -1;
    }

    boolean onBackPressed() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            return true;
        }
        actionMode = this.getSupportActionBar();
        if (actionMode == null) return false;
        if (!actionMode.collapseActionView()) return false;
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        ActionBar actionBar;
        if (this.mHasActionBar && this.mSubDecorInstalled && (actionBar = this.getSupportActionBar()) != null) {
            actionBar.onConfigurationChanged(configuration);
        }
        AppCompatDrawableManager.get().onConfigurationChanged(this.mContext);
        this.applyDayNight(false);
    }

    public void onCreate(Bundle object) {
        this.mBaseContextAttached = true;
        this.applyDayNight(false);
        this.ensureWindow();
        Object object2 = this.mHost;
        if (object2 instanceof Activity) {
            object = null;
            try {
                object2 = NavUtils.getParentActivityName((Activity)((Activity)object2));
                object = object2;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
            if (object != null) {
                object = this.peekSupportActionBar();
                if (object == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    object.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            AppCompatDelegateImpl.addActiveDelegate((AppCompatDelegate)this);
        }
        this.mCreated = true;
    }

    public final View onCreateView(View view, String string, Context context, AttributeSet attributeSet) {
        return this.createView(view, string, context, attributeSet);
    }

    public View onCreateView(String string, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string, context, attributeSet);
    }

    public void onDestroy() {
        Object object;
        if (this.mHost instanceof Activity) {
            AppCompatDelegateImpl.removeActivityDelegate((AppCompatDelegate)this);
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mStarted = false;
        this.mIsDestroyed = true;
        if (this.mLocalNightMode != -100 && (object = this.mHost) instanceof Activity && ((Activity)object).isChangingConfigurations()) {
            sLocalNightModes.put((Object)this.mHost.getClass().getName(), (Object)this.mLocalNightMode);
        } else {
            sLocalNightModes.remove((Object)this.mHost.getClass().getName());
        }
        object = this.mActionBar;
        if (object != null) {
            object.onDestroy();
        }
        this.cleanupAutoManagers();
    }

    boolean onKeyDown(int n, KeyEvent keyEvent) {
        boolean bl = true;
        if (n != 4) {
            if (n != 82) return false;
            this.onKeyDownPanel(0, keyEvent);
            return true;
        }
        if ((keyEvent.getFlags() & 0x80) == 0) {
            bl = false;
        }
        this.mLongPressBackDown = bl;
        return false;
    }

    boolean onKeyShortcut(int n, KeyEvent keyEvent) {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null && actionBar.onKeyShortcut(n, keyEvent)) {
            return true;
        }
        actionBar = this.mPreparedPanel;
        if (actionBar != null && this.performPanelShortcut((PanelFeatureState)actionBar, keyEvent.getKeyCode(), keyEvent, 1)) {
            keyEvent = this.mPreparedPanel;
            if (keyEvent == null) return true;
            keyEvent.isHandled = true;
            return true;
        }
        if (this.mPreparedPanel != null) return false;
        actionBar = this.getPanelState(0, true);
        this.preparePanel((PanelFeatureState)actionBar, keyEvent);
        boolean bl = this.performPanelShortcut((PanelFeatureState)actionBar, keyEvent.getKeyCode(), keyEvent, 1);
        actionBar.isPrepared = false;
        if (!bl) return false;
        return true;
    }

    boolean onKeyUp(int n, KeyEvent keyEvent) {
        if (n != 4) {
            if (n != 82) {
                return false;
            }
            this.onKeyUpPanel(0, keyEvent);
            return true;
        }
        boolean bl = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        keyEvent = this.getPanelState(0, false);
        if (keyEvent != null && keyEvent.isOpen) {
            if (bl) return true;
            this.closePanel((PanelFeatureState)keyEvent, true);
            return true;
        }
        if (!this.onBackPressed()) return false;
        return true;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Window.Callback callback = this.getWindowCallback();
        if (callback == null) return false;
        if (this.mIsDestroyed) return false;
        if ((menuBuilder = this.findMenuPanel((Menu)menuBuilder.getRootMenu())) == null) return false;
        return callback.onMenuItemSelected(menuBuilder.featureId, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        this.reopenMenu(true);
    }

    void onMenuOpened(int n) {
        if (n != 108) return;
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar == null) return;
        actionBar.dispatchMenuVisibilityChanged(true);
    }

    void onPanelClosed(int n) {
        if (n == 108) {
            ActionBar actionBar = this.getSupportActionBar();
            if (actionBar == null) return;
            actionBar.dispatchMenuVisibilityChanged(false);
        } else {
            if (n != 0) return;
            PanelFeatureState panelFeatureState = this.getPanelState(n, true);
            if (!panelFeatureState.isOpen) return;
            this.closePanel(panelFeatureState, false);
        }
    }

    public void onPostCreate(Bundle bundle) {
        this.ensureSubDecor();
    }

    public void onPostResume() {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setShowHideAnimationEnabled(true);
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mStarted = true;
        this.applyDayNight();
    }

    public void onStop() {
        this.mStarted = false;
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar == null) return;
        actionBar.setShowHideAnimationEnabled(false);
    }

    void onSubDecorInstalled(ViewGroup viewGroup) {
    }

    final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    public boolean requestWindowFeature(int n) {
        n = this.sanitizeWindowFeatureId(n);
        if (this.mWindowNoTitle && n == 108) {
            return false;
        }
        if (this.mHasActionBar && n == 1) {
            this.mHasActionBar = false;
        }
        if (n == 1) {
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        }
        if (n == 2) {
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        }
        if (n == 5) {
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        }
        if (n == 10) {
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        }
        if (n == 108) {
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        }
        if (n != 109) {
            return this.mWindow.requestFeature(n);
        }
        this.throwFeatureRequestIfSubDecorInstalled();
        this.mOverlayActionBar = true;
        return true;
    }

    public void setContentView(int n) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        LayoutInflater.from((Context)this.mContext).inflate(n, viewGroup);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void setContentView(View view) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void setHandleNativeActionModesEnabled(boolean bl) {
        this.mHandleNativeActionModes = bl;
    }

    public void setLocalNightMode(int n) {
        if (this.mLocalNightMode == n) return;
        this.mLocalNightMode = n;
        if (!this.mBaseContextAttached) return;
        this.applyDayNight();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        if (!(this.mHost instanceof Activity)) {
            return;
        }
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar instanceof WindowDecorActionBar) throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        this.mMenuInflater = null;
        if (actionBar != null) {
            actionBar.onDestroy();
        }
        if (toolbar != null) {
            toolbar = new ToolbarActionBar(toolbar, this.getTitle(), (Window.Callback)this.mAppCompatWindowCallback);
            this.mActionBar = toolbar;
            this.mWindow.setCallback(toolbar.getWrappedWindowCallback());
        } else {
            this.mActionBar = null;
            this.mWindow.setCallback((Window.Callback)this.mAppCompatWindowCallback);
        }
        this.invalidateOptionsMenu();
    }

    public void setTheme(int n) {
        this.mThemeResId = n;
    }

    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
        } else if (this.peekSupportActionBar() != null) {
            this.peekSupportActionBar().setWindowTitle(charSequence);
        } else {
            decorContentParent = this.mTitleView;
            if (decorContentParent == null) return;
            decorContentParent.setText(charSequence);
        }
    }

    final boolean shouldAnimateActionModeView() {
        ViewGroup viewGroup;
        boolean bl = this.mSubDecorInstalled && (viewGroup = this.mSubDecor) != null && ViewCompat.isLaidOut((View)viewGroup);
        return bl;
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        if (callback == null) throw new IllegalArgumentException("ActionMode callback can not be null.");
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        callback = new ActionModeCallbackWrapperV9(this, callback);
        actionMode = this.getSupportActionBar();
        if (actionMode != null) {
            ActionMode actionMode2;
            this.mActionMode = actionMode2 = actionMode.startActionMode(callback);
            if (actionMode2 != null && (actionMode = this.mAppCompatCallback) != null) {
                actionMode.onSupportActionModeStarted(actionMode2);
            }
        }
        if (this.mActionMode != null) return this.mActionMode;
        this.mActionMode = this.startSupportActionModeFromWindow(callback);
        return this.mActionMode;
    }

    ActionMode startSupportActionModeFromWindow(ActionMode.Callback callback) {
        this.endOnGoingFadeAnimation();
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        actionMode = callback;
        if (!(callback instanceof ActionModeCallbackWrapperV9)) {
            actionMode = new ActionModeCallbackWrapperV9(this, callback);
        }
        if ((callback = this.mAppCompatCallback) != null && !this.mIsDestroyed) {
            try {
                callback = callback.onWindowStartingSupportActionMode((ActionMode.Callback)actionMode);
            }
            catch (AbstractMethodError abstractMethodError) {}
        }
        callback = null;
        if (callback != null) {
            this.mActionMode = callback;
        } else {
            TypedValue typedValue;
            callback = this.mActionModeView;
            boolean bl = true;
            if (callback == null) {
                if (this.mIsFloating) {
                    Resources.Theme theme;
                    typedValue = new TypedValue();
                    callback = this.mContext.getTheme();
                    callback.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        theme = this.mContext.getResources().newTheme();
                        theme.setTo((Resources.Theme)callback);
                        theme.applyStyle(typedValue.resourceId, true);
                        callback = new ContextThemeWrapper(this.mContext, 0);
                        callback.getTheme().setTo(theme);
                    } else {
                        callback = this.mContext;
                    }
                    this.mActionModeView = new ActionBarContextView((Context)callback);
                    theme = new PopupWindow((Context)callback, null, R.attr.actionModePopupWindowStyle);
                    this.mActionModePopup = theme;
                    PopupWindowCompat.setWindowLayoutType((PopupWindow)theme, (int)2);
                    this.mActionModePopup.setContentView((View)this.mActionModeView);
                    this.mActionModePopup.setWidth(-1);
                    callback.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    int n = TypedValue.complexToDimensionPixelSize((int)typedValue.data, (DisplayMetrics)callback.getResources().getDisplayMetrics());
                    this.mActionModeView.setContentHeight(n);
                    this.mActionModePopup.setHeight(-2);
                    this.mShowActionModePopup = new /* Unavailable Anonymous Inner Class!! */;
                } else {
                    callback = (ViewStubCompat)this.mSubDecor.findViewById(R.id.action_mode_bar_stub);
                    if (callback != null) {
                        callback.setLayoutInflater(LayoutInflater.from((Context)this.getActionBarThemedContext()));
                        this.mActionModeView = (ActionBarContextView)callback.inflate();
                    }
                }
            }
            if (this.mActionModeView != null) {
                this.endOnGoingFadeAnimation();
                this.mActionModeView.killMode();
                callback = this.mActionModeView.getContext();
                typedValue = this.mActionModeView;
                if (this.mActionModePopup != null) {
                    bl = false;
                }
                callback = new StandaloneActionMode((Context)callback, (ActionBarContextView)typedValue, (ActionMode.Callback)actionMode, bl);
                if (actionMode.onCreateActionMode((ActionMode)callback, callback.getMenu())) {
                    callback.invalidate();
                    this.mActionModeView.initForMode((ActionMode)callback);
                    this.mActionMode = callback;
                    if (this.shouldAnimateActionModeView()) {
                        this.mActionModeView.setAlpha(0.0f);
                        callback = ViewCompat.animate((View)this.mActionModeView).alpha(1.0f);
                        this.mFadeAnim = callback;
                        callback.setListener((ViewPropertyAnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
                    } else {
                        this.mActionModeView.setAlpha(1.0f);
                        this.mActionModeView.setVisibility(0);
                        this.mActionModeView.sendAccessibilityEvent(32);
                        if (this.mActionModeView.getParent() instanceof View) {
                            ViewCompat.requestApplyInsets((View)((View)this.mActionModeView.getParent()));
                        }
                    }
                    if (this.mActionModePopup != null) {
                        this.mWindow.getDecorView().post(this.mShowActionModePopup);
                    }
                } else {
                    this.mActionMode = null;
                }
            }
        }
        actionMode = this.mActionMode;
        if (actionMode == null) return this.mActionMode;
        callback = this.mAppCompatCallback;
        if (callback == null) return this.mActionMode;
        callback.onSupportActionModeStarted(actionMode);
        return this.mActionMode;
    }

    final int updateStatusGuard(WindowInsetsCompat windowInsetsCompat, Rect rect) {
        int n;
        int n2;
        int n3 = 0;
        int n4 = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : (rect != null ? rect.top : 0);
        ActionBarContextView actionBarContextView = this.mActionModeView;
        if (actionBarContextView != null && actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            int n5;
            actionBarContextView = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
            boolean bl = this.mActionModeView.isShown();
            int n6 = 1;
            n2 = 1;
            if (bl) {
                if (this.mTempRect1 == null) {
                    this.mTempRect1 = new Rect();
                    this.mTempRect2 = new Rect();
                }
                Rect rect2 = this.mTempRect1;
                Rect rect3 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                }
                ViewUtils.computeFitSystemWindows((View)this.mSubDecor, (Rect)rect2, (Rect)rect3);
                int n7 = rect2.top;
                int n8 = rect2.left;
                n5 = rect2.right;
                windowInsetsCompat = ViewCompat.getRootWindowInsets((View)this.mSubDecor);
                n6 = windowInsetsCompat == null ? 0 : windowInsetsCompat.getSystemWindowInsetLeft();
                n = windowInsetsCompat == null ? 0 : windowInsetsCompat.getSystemWindowInsetRight();
                if (actionBarContextView.topMargin == n7 && actionBarContextView.leftMargin == n8 && actionBarContextView.rightMargin == n5) {
                    n5 = 0;
                } else {
                    actionBarContextView.topMargin = n7;
                    actionBarContextView.leftMargin = n8;
                    actionBarContextView.rightMargin = n5;
                    n5 = 1;
                }
                if (n7 > 0 && this.mStatusGuard == null) {
                    windowInsetsCompat = new View(this.mContext);
                    this.mStatusGuard = windowInsetsCompat;
                    windowInsetsCompat.setVisibility(8);
                    windowInsetsCompat = new FrameLayout.LayoutParams(-1, actionBarContextView.topMargin, 51);
                    windowInsetsCompat.leftMargin = n6;
                    windowInsetsCompat.rightMargin = n;
                    this.mSubDecor.addView(this.mStatusGuard, -1, (ViewGroup.LayoutParams)windowInsetsCompat);
                } else {
                    windowInsetsCompat = this.mStatusGuard;
                    if (windowInsetsCompat != null) {
                        windowInsetsCompat = (ViewGroup.MarginLayoutParams)windowInsetsCompat.getLayoutParams();
                        if (windowInsetsCompat.height != actionBarContextView.topMargin || windowInsetsCompat.leftMargin != n6 || windowInsetsCompat.rightMargin != n) {
                            windowInsetsCompat.height = actionBarContextView.topMargin;
                            windowInsetsCompat.leftMargin = n6;
                            windowInsetsCompat.rightMargin = n;
                            this.mStatusGuard.setLayoutParams((ViewGroup.LayoutParams)windowInsetsCompat);
                        }
                    }
                }
                n = this.mStatusGuard != null ? n2 : 0;
                if (n != 0 && this.mStatusGuard.getVisibility() != 0) {
                    this.updateStatusGuardColor(this.mStatusGuard);
                }
                n6 = n4;
                if (!this.mOverlayActionMode) {
                    n6 = n4;
                    if (n != 0) {
                        n6 = 0;
                    }
                }
                n4 = n6;
                n6 = n5;
                n5 = n;
            } else if (actionBarContextView.topMargin != 0) {
                actionBarContextView.topMargin = 0;
                n5 = 0;
            } else {
                n5 = 0;
                n6 = 0;
            }
            n = n4;
            n2 = n5;
            if (n6 != 0) {
                this.mActionModeView.setLayoutParams((ViewGroup.LayoutParams)actionBarContextView);
                n = n4;
                n2 = n5;
            }
        } else {
            n2 = 0;
            n = n4;
        }
        if ((windowInsetsCompat = this.mStatusGuard) == null) return n;
        n4 = n2 != 0 ? n3 : 8;
        windowInsetsCompat.setVisibility(n4);
        return n;
    }
}
