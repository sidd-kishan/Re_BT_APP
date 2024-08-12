/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  butterknife.internal.ImmutableList
 */
package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import butterknife.internal.ImmutableList;
import java.util.Arrays;
import java.util.List;

public final class Utils {
    private static final TypedValue VALUE = new TypedValue();

    private Utils() {
        throw new AssertionError((Object)"No instances.");
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T ... TArray) {
        int n = TArray.length;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            T t = TArray[i];
            int n3 = n2;
            if (t != null) {
                TArray[n2] = t;
                n3 = n2 + 1;
            }
            n2 = n3;
        }
        if (n2 == n) return TArray;
        TArray = Arrays.copyOf(TArray, n2);
        return TArray;
    }

    public static <T> T castParam(Object object, String string, int n, String string2, int n2, Class<T> serializable) {
        try {
            object = ((Class)serializable).cast(object);
        }
        catch (ClassCastException classCastException) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Parameter #");
            ((StringBuilder)serializable).append(n + 1);
            ((StringBuilder)serializable).append(" of method '");
            ((StringBuilder)serializable).append(string);
            ((StringBuilder)serializable).append("' was of the wrong type for parameter #");
            ((StringBuilder)serializable).append(n2 + 1);
            ((StringBuilder)serializable).append(" of method '");
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append("'. See cause for more info.");
            throw new IllegalStateException(((StringBuilder)serializable).toString(), classCastException);
        }
        return (T)object;
    }

    public static <T> T castView(View object, int n, String string, Class<T> clazz) {
        try {
            clazz = clazz.cast(object);
        }
        catch (ClassCastException classCastException) {
            String string2 = Utils.getResourceEntryName((View)object, n);
            object = new StringBuilder();
            ((StringBuilder)object).append("View '");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("' with ID ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" for ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" was of the wrong type. See cause for more info.");
            throw new IllegalStateException(((StringBuilder)object).toString(), classCastException);
        }
        return (T)clazz;
    }

    public static <T> T findOptionalViewAsType(View view, int n, String string, Class<T> clazz) {
        return Utils.castView(view.findViewById(n), n, string, clazz);
    }

    public static View findRequiredView(View object, int n, String string) {
        Object object2 = object.findViewById(n);
        if (object2 != null) {
            return object2;
        }
        object2 = Utils.getResourceEntryName((View)object, n);
        object = new StringBuilder();
        ((StringBuilder)object).append("Required view '");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("' with ID ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" for ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public static <T> T findRequiredViewAsType(View view, int n, String string, Class<T> clazz) {
        return Utils.castView(Utils.findRequiredView(view, n, string), n, string, clazz);
    }

    public static float getFloat(Context object, int n) {
        TypedValue typedValue = VALUE;
        object.getResources().getValue(n, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Resource ID #0x");
        ((StringBuilder)object).append(Integer.toHexString(n));
        ((StringBuilder)object).append(" type #0x");
        ((StringBuilder)object).append(Integer.toHexString(typedValue.type));
        ((StringBuilder)object).append(" is not valid");
        throw new Resources.NotFoundException(((StringBuilder)object).toString());
    }

    private static String getResourceEntryName(View view, int n) {
        if (!view.isInEditMode()) return view.getContext().getResources().getResourceEntryName(n);
        return "<unavailable while editing>";
    }

    public static Drawable getTintedDrawable(Context context, int n, int n2) {
        if (context.getTheme().resolveAttribute(n2, VALUE, true)) {
            Drawable drawable = DrawableCompat.wrap((Drawable)ContextCompat.getDrawable((Context)context, (int)n).mutate());
            DrawableCompat.setTint((Drawable)drawable, (int)ContextCompat.getColor((Context)context, (int)Utils.VALUE.resourceId));
            return drawable;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Required tint color attribute with name ");
        stringBuilder.append(context.getResources().getResourceEntryName(n2));
        stringBuilder.append(" and attribute ID ");
        stringBuilder.append(n2);
        stringBuilder.append(" was not found.");
        throw new Resources.NotFoundException(stringBuilder.toString());
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T ... TArray) {
        return new ImmutableList((Object[])Utils.arrayFilteringNull(TArray));
    }
}
