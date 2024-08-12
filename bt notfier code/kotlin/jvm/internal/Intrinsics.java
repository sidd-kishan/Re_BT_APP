/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNullPointerException
 *  kotlin.UninitializedPropertyAccessException
 */
package kotlin.jvm.internal;

import java.io.Serializable;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    private Intrinsics() {
    }

    public static boolean areEqual(double d, Double d2) {
        boolean bl = d2 != null && d == d2;
        return bl;
    }

    public static boolean areEqual(float f, Float f2) {
        boolean bl = f2 != null && f == f2.floatValue();
        return bl;
    }

    public static boolean areEqual(Double d, double d2) {
        boolean bl = d != null && d == d2;
        return bl;
    }

    public static boolean areEqual(Double d, Double d2) {
        boolean bl = true;
        if (d == null ? d2 == null : d2 != null && d.doubleValue() == d2.doubleValue()) return bl;
        bl = false;
        return bl;
    }

    public static boolean areEqual(Float f, float f2) {
        boolean bl = f != null && f.floatValue() == f2;
        return bl;
    }

    public static boolean areEqual(Float f, Float f2) {
        boolean bl = true;
        if (f == null ? f2 == null : f2 != null && f.floatValue() == f2.floatValue()) return bl;
        bl = false;
        return bl;
    }

    public static boolean areEqual(Object object, Object object2) {
        boolean bl = object == null ? object2 == null : object.equals(object2);
        return bl;
    }

    public static void checkExpressionValueIsNotNull(Object object, String string) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" must not be null");
        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(((StringBuilder)object).toString()));
    }

    public static void checkFieldIsNotNull(Object object, String string) {
        if (object == null) throw Intrinsics.sanitizeStackTrace(new IllegalStateException(string));
    }

    public static void checkFieldIsNotNull(Object object, String string, String string2) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Field specified as non-null is null: ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(".");
        ((StringBuilder)object).append(string2);
        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(((StringBuilder)object).toString()));
    }

    public static void checkHasClass(String charSequence) throws ClassNotFoundException {
        String string = ((String)charSequence).replace('/', '.');
        try {
            Class.forName(string);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Class ");
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append(" is not found. Please update the Kotlin runtime to the latest version");
            throw Intrinsics.sanitizeStackTrace(new ClassNotFoundException(((StringBuilder)charSequence).toString(), classNotFoundException));
        }
    }

    public static void checkHasClass(String string, String string2) throws ClassNotFoundException {
        string = string.replace('/', '.');
        try {
            Class.forName(string);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class ");
            stringBuilder.append(string);
            stringBuilder.append(" is not found: this code requires the Kotlin runtime of version at least ");
            stringBuilder.append(string2);
            throw Intrinsics.sanitizeStackTrace(new ClassNotFoundException(stringBuilder.toString(), classNotFoundException));
        }
    }

    public static void checkNotNull(Object object) {
        if (object != null) return;
        Intrinsics.throwJavaNpe();
    }

    public static void checkNotNull(Object object, String string) {
        if (object != null) return;
        Intrinsics.throwJavaNpe(string);
    }

    public static void checkNotNullExpressionValue(Object object, String string) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" must not be null");
        throw Intrinsics.sanitizeStackTrace(new NullPointerException(((StringBuilder)object).toString()));
    }

    public static void checkNotNullParameter(Object object, String string) {
        if (object != null) return;
        Intrinsics.throwParameterIsNullNPE(string);
    }

    public static void checkParameterIsNotNull(Object object, String string) {
        if (object != null) return;
        Intrinsics.throwParameterIsNullIAE(string);
    }

    public static void checkReturnedValueIsNotNull(Object object, String string) {
        if (object == null) throw Intrinsics.sanitizeStackTrace(new IllegalStateException(string));
    }

    public static void checkReturnedValueIsNotNull(Object object, String string, String string2) {
        if (object != null) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Method specified as non-null returned null: ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(".");
        ((StringBuilder)object).append(string2);
        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(((StringBuilder)object).toString()));
    }

    public static int compare(int n, int n2) {
        n = n < n2 ? -1 : (n == n2 ? 0 : 1);
        return n;
    }

    public static int compare(long l, long l2) {
        int n = l < l2 ? -1 : (l == l2 ? 0 : 1);
        return n;
    }

    private static String createParameterIsNullExceptionMessage(String string) {
        Serializable serializable = Thread.currentThread().getStackTrace()[4];
        String string2 = ((StackTraceElement)serializable).getClassName();
        String string3 = ((StackTraceElement)serializable).getMethodName();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("Parameter specified as non-null is null: method ");
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append(".");
        ((StringBuilder)serializable).append(string3);
        ((StringBuilder)serializable).append(", parameter ");
        ((StringBuilder)serializable).append(string);
        return ((StringBuilder)serializable).toString();
    }

    public static void needClassReification() {
        Intrinsics.throwUndefinedForReified();
    }

    public static void needClassReification(String string) {
        Intrinsics.throwUndefinedForReified(string);
    }

    public static void reifiedOperationMarker(int n, String string) {
        Intrinsics.throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int n, String string, String string2) {
        Intrinsics.throwUndefinedForReified(string2);
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return Intrinsics.sanitizeStackTrace(t, Intrinsics.class.getName());
    }

    static <T extends Throwable> T sanitizeStackTrace(T t, String string) {
        StackTraceElement[] stackTraceElementArray = t.getStackTrace();
        int n = stackTraceElementArray.length;
        int n2 = -1;
        int n3 = 0;
        while (true) {
            if (n3 >= n) {
                t.setStackTrace(Arrays.copyOfRange(stackTraceElementArray, n2 + 1, n));
                return t;
            }
            if (string.equals(stackTraceElementArray[n3].getClassName())) {
                n2 = n3;
            }
            ++n3;
        }
    }

    public static String stringPlus(String string, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    public static void throwAssert() {
        throw Intrinsics.sanitizeStackTrace(new AssertionError());
    }

    public static void throwAssert(String string) {
        throw Intrinsics.sanitizeStackTrace(new AssertionError((Object)string));
    }

    public static void throwIllegalArgument() {
        throw Intrinsics.sanitizeStackTrace(new IllegalArgumentException());
    }

    public static void throwIllegalArgument(String string) {
        throw Intrinsics.sanitizeStackTrace(new IllegalArgumentException(string));
    }

    public static void throwIllegalState() {
        throw Intrinsics.sanitizeStackTrace(new IllegalStateException());
    }

    public static void throwIllegalState(String string) {
        throw Intrinsics.sanitizeStackTrace(new IllegalStateException(string));
    }

    public static void throwJavaNpe() {
        throw Intrinsics.sanitizeStackTrace(new NullPointerException());
    }

    public static void throwJavaNpe(String string) {
        throw Intrinsics.sanitizeStackTrace(new NullPointerException(string));
    }

    public static void throwNpe() {
        throw Intrinsics.sanitizeStackTrace(new KotlinNullPointerException());
    }

    public static void throwNpe(String string) {
        throw Intrinsics.sanitizeStackTrace(new KotlinNullPointerException(string));
    }

    private static void throwParameterIsNullIAE(String string) {
        throw Intrinsics.sanitizeStackTrace(new IllegalArgumentException(Intrinsics.createParameterIsNullExceptionMessage(string)));
    }

    private static void throwParameterIsNullNPE(String string) {
        throw Intrinsics.sanitizeStackTrace(new NullPointerException(Intrinsics.createParameterIsNullExceptionMessage(string)));
    }

    public static void throwUndefinedForReified() {
        Intrinsics.throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(String string) {
        throw new UnsupportedOperationException(string);
    }

    public static void throwUninitializedProperty(String string) {
        throw Intrinsics.sanitizeStackTrace(new UninitializedPropertyAccessException(string));
    }

    public static void throwUninitializedPropertyAccessException(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lateinit property ");
        stringBuilder.append(string);
        stringBuilder.append(" has not been initialized");
        Intrinsics.throwUninitializedProperty(stringBuilder.toString());
    }
}
