/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.InflateException
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.app.AppCompatViewInflater$DeclaredOnClickListener
 *  androidx.appcompat.view.ContextThemeWrapper
 *  androidx.appcompat.widget.AppCompatAutoCompleteTextView
 *  androidx.appcompat.widget.AppCompatButton
 *  androidx.appcompat.widget.AppCompatCheckBox
 *  androidx.appcompat.widget.AppCompatCheckedTextView
 *  androidx.appcompat.widget.AppCompatEditText
 *  androidx.appcompat.widget.AppCompatImageButton
 *  androidx.appcompat.widget.AppCompatImageView
 *  androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView
 *  androidx.appcompat.widget.AppCompatRadioButton
 *  androidx.appcompat.widget.AppCompatRatingBar
 *  androidx.appcompat.widget.AppCompatSeekBar
 *  androidx.appcompat.widget.AppCompatSpinner
 *  androidx.appcompat.widget.AppCompatTextView
 *  androidx.appcompat.widget.AppCompatToggleButton
 *  androidx.appcompat.widget.TintContextWrapper
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.view.ViewCompat
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Constructor;

public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList;
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap;
    private static final Class<?>[] sConstructorSignature;
    private static final int[] sOnClickAttrs;
    private final Object[] mConstructorArgs = new Object[2];

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{16843375};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    private void checkOnClickListener(View view, AttributeSet attributeSet) {
        Object object = view.getContext();
        if (!(object instanceof ContextWrapper)) return;
        if (Build.VERSION.SDK_INT >= 15 && !ViewCompat.hasOnClickListeners((View)view)) return;
        if ((object = (attributeSet = object.obtainStyledAttributes(attributeSet, sOnClickAttrs)).getString(0)) != null) {
            view.setOnClickListener((View.OnClickListener)new DeclaredOnClickListener(view, (String)object));
        }
        attributeSet.recycle();
    }

    /*
     * Unable to fully structure code
     */
    private View createViewByPrefix(Context var1_1, String var2_3, String var3_4) throws ClassNotFoundException, InflateException {
        var5_5 = (Constructor)AppCompatViewInflater.sConstructorMap.get((Object)var2_3);
        var4_6 = var5_5;
        if (var5_5 != null) ** GOTO lbl18
        if (var3_4 == null) ** GOTO lbl13
        try {
            block2: {
                var4_6 = new Constructor<View>();
                var4_6.append(var3_4);
                var4_6.append(var2_3);
                var3_4 = var4_6.toString();
                break block2;
lbl13:
                // 1 sources

                var3_4 = var2_3;
            }
            var4_6 = Class.forName(var3_4, false, var1_1.getClassLoader()).asSubclass(View.class).getConstructor(AppCompatViewInflater.sConstructorSignature);
            AppCompatViewInflater.sConstructorMap.put((Object)var2_3, var4_6);
lbl18:
            // 2 sources

            var4_6.setAccessible(true);
            var1_1 = (View)var4_6.newInstance(this.mConstructorArgs);
            return var1_1;
        }
        catch (Exception var1_2) {
            return null;
        }
    }

    private View createViewFromTag(Context objectArray, String view, AttributeSet attributeSet) {
        View view2;
        block8: {
            int n;
            view2 = view;
            if (view.equals("view")) {
                view2 = attributeSet.getAttributeValue(null, "class");
            }
            try {
                this.mConstructorArgs[0] = objectArray;
                this.mConstructorArgs[1] = attributeSet;
                if (-1 != view2.indexOf(46)) break block8;
                n = 0;
            }
            catch (Throwable throwable) {
                objectArray = this.mConstructorArgs;
                objectArray[0] = null;
                objectArray[1] = null;
                throw throwable;
            }
            catch (Exception exception) {
                Object[] objectArray2 = this.mConstructorArgs;
                objectArray2[0] = null;
                objectArray2[1] = null;
                return null;
            }
            while (true) {
                if (n >= sClassPrefixList.length) {
                    objectArray = this.mConstructorArgs;
                    objectArray[0] = null;
                    objectArray[1] = null;
                    return null;
                }
                view = this.createViewByPrefix((Context)objectArray, (String)view2, sClassPrefixList[n]);
                if (view != null) {
                    objectArray = this.mConstructorArgs;
                    objectArray[0] = null;
                    objectArray[1] = null;
                    return view;
                }
                ++n;
            }
        }
        objectArray = this.createViewByPrefix((Context)objectArray, (String)view2, null);
        view = this.mConstructorArgs;
        view[0] = null;
        view[1] = null;
        return objectArray;
    }

    private static Context themifyContext(Context context, AttributeSet attributeSet, boolean bl, boolean bl2) {
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
        int n = bl ? attributeSet.getResourceId(R.styleable.View_android_theme, 0) : 0;
        int n2 = n;
        if (bl2) {
            n2 = n;
            if (n == 0) {
                n2 = n = attributeSet.getResourceId(R.styleable.View_theme, 0);
                if (n != 0) {
                    Log.i((String)LOG_TAG, (String)"app:theme is now deprecated. Please move to using android:theme instead.");
                    n2 = n;
                }
            }
        }
        attributeSet.recycle();
        attributeSet = context;
        if (n2 == 0) return attributeSet;
        if (context instanceof ContextThemeWrapper) {
            attributeSet = context;
            if (((ContextThemeWrapper)context).getThemeResId() == n2) return attributeSet;
        }
        attributeSet = new ContextThemeWrapper(context, n2);
        return attributeSet;
    }

    private void verifyNotNull(View object, String string) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(this.getClass().getName());
        ((StringBuilder)object).append(" asked to inflate view for <");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(">, but returned null");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckBox(context, attributeSet);
    }

    protected AppCompatCheckedTextView createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatCheckedTextView(context, attributeSet);
    }

    protected AppCompatEditText createEditText(Context context, AttributeSet attributeSet) {
        return new AppCompatEditText(context, attributeSet);
    }

    protected AppCompatImageButton createImageButton(Context context, AttributeSet attributeSet) {
        return new AppCompatImageButton(context, attributeSet);
    }

    protected AppCompatImageView createImageView(Context context, AttributeSet attributeSet) {
        return new AppCompatImageView(context, attributeSet);
    }

    protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatMultiAutoCompleteTextView(context, attributeSet);
    }

    protected AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new AppCompatRadioButton(context, attributeSet);
    }

    protected AppCompatRatingBar createRatingBar(Context context, AttributeSet attributeSet) {
        return new AppCompatRatingBar(context, attributeSet);
    }

    protected AppCompatSeekBar createSeekBar(Context context, AttributeSet attributeSet) {
        return new AppCompatSeekBar(context, attributeSet);
    }

    protected AppCompatSpinner createSpinner(Context context, AttributeSet attributeSet) {
        return new AppCompatSpinner(context, attributeSet);
    }

    protected AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    protected AppCompatToggleButton createToggleButton(Context context, AttributeSet attributeSet) {
        return new AppCompatToggleButton(context, attributeSet);
    }

    protected View createView(Context context, String string, AttributeSet attributeSet) {
        return null;
    }

    final View createView(View view, String string, Context context, AttributeSet attributeSet, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Context context2;
        block39: {
            block38: {
                context2 = bl && view != null ? view.getContext() : context;
                if (bl2) break block38;
                view = context2;
                if (!bl3) break block39;
            }
            view = AppCompatViewInflater.themifyContext(context2, attributeSet, bl2, bl3);
        }
        context2 = view;
        if (bl4) {
            context2 = TintContextWrapper.wrap((Context)view);
        }
        int n = -1;
        switch (string.hashCode()) {
            default: {
                break;
            }
            case 2001146706: {
                if (!string.equals("Button")) break;
                n = 2;
                break;
            }
            case 1666676343: {
                if (!string.equals("EditText")) break;
                n = 3;
                break;
            }
            case 1601505219: {
                if (!string.equals("CheckBox")) break;
                n = 6;
                break;
            }
            case 1413872058: {
                if (!string.equals("AutoCompleteTextView")) break;
                n = 9;
                break;
            }
            case 1125864064: {
                if (!string.equals("ImageView")) break;
                n = 1;
                break;
            }
            case 799298502: {
                if (!string.equals("ToggleButton")) break;
                n = 13;
                break;
            }
            case 776382189: {
                if (!string.equals("RadioButton")) break;
                n = 7;
                break;
            }
            case -339785223: {
                if (!string.equals("Spinner")) break;
                n = 4;
                break;
            }
            case -658531749: {
                if (!string.equals("SeekBar")) break;
                n = 12;
                break;
            }
            case -937446323: {
                if (!string.equals("ImageButton")) break;
                n = 5;
                break;
            }
            case -938935918: {
                if (!string.equals("TextView")) break;
                n = 0;
                break;
            }
            case -1346021293: {
                if (!string.equals("MultiAutoCompleteTextView")) break;
                n = 10;
                break;
            }
            case -1455429095: {
                if (!string.equals("CheckedTextView")) break;
                n = 8;
                break;
            }
            case -1946472170: {
                if (!string.equals("RatingBar")) break;
                n = 11;
            }
        }
        switch (n) {
            default: {
                view = this.createView(context2, string, attributeSet);
                break;
            }
            case 13: {
                view = this.createToggleButton(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 12: {
                view = this.createSeekBar(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 11: {
                view = this.createRatingBar(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 10: {
                view = this.createMultiAutoCompleteTextView(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 9: {
                view = this.createAutoCompleteTextView(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 8: {
                view = this.createCheckedTextView(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 7: {
                view = this.createRadioButton(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 6: {
                view = this.createCheckBox(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 5: {
                view = this.createImageButton(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 4: {
                view = this.createSpinner(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 3: {
                view = this.createEditText(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 2: {
                view = this.createButton(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 1: {
                view = this.createImageView(context2, attributeSet);
                this.verifyNotNull(view, string);
                break;
            }
            case 0: {
                view = this.createTextView(context2, attributeSet);
                this.verifyNotNull(view, string);
            }
        }
        View view2 = view;
        if (view == null) {
            view2 = view;
            if (context != context2) {
                view2 = this.createViewFromTag(context2, string, attributeSet);
            }
        }
        if (view2 == null) return view2;
        this.checkOnClickListener(view2, attributeSet);
        return view2;
    }
}
