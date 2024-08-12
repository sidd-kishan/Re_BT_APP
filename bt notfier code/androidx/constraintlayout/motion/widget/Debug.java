/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.constraintlayout.motion.widget.MotionLayout
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Debug {
    /*
     * Unable to fully structure code
     */
    public static void dumpLayoutParams(ViewGroup.LayoutParams var0, String var1_1) {
        var3_2 = new Throwable().getStackTrace()[1];
        var4_3 = new StringBuilder();
        var4_3.append(".(");
        var4_3.append(var3_2.getFileName());
        var4_3.append(":");
        var4_3.append(var3_2.getLineNumber());
        var4_3.append(") ");
        var4_3.append(var1_1);
        var4_3.append("  ");
        var1_1 = var4_3.toString();
        var3_2 = System.out;
        var4_3 = new StringBuilder();
        var4_3.append(" >>>>>>>>>>>>>>>>>>. dump ");
        var4_3.append(var1_1);
        var4_3.append("  ");
        var4_3.append(var0.getClass().getName());
        var3_2.println(var4_3.toString());
        var3_2 = var0.getClass().getFields();
        var2_5 = 0;
        block2: while (true) {
            if (var2_5 >= ((Field[])var3_2).length) {
                var0 = System.out;
                var3_2 = new StringBuilder();
                var3_2.append(" <<<<<<<<<<<<<<<<< dump ");
                var3_2.append(var1_1);
                var0.println(var3_2.toString());
                return;
            }
            var5_6 = var3_2[var2_5];
            try {
                var4_3 = var5_6.get(var0);
                var6_7 = var5_6.getName();
                if (var6_7.contains("To") && !var4_3.toString().equals("-1")) {
                    var7_8 = System.out;
                    var5_6 = new StringBuilder();
                    var5_6.append(var1_1);
                    var5_6.append("       ");
                    var5_6.append(var6_7);
                    var5_6.append(" ");
                    var5_6.append(var4_3);
                    var7_8.println(var5_6.toString());
                }
lbl59:
                // 4 sources

                while (true) {
                    ++var2_5;
                    continue block2;
                    break;
                }
            }
            catch (IllegalAccessException var4_4) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void dumpLayoutParams(ViewGroup var0, String var1_1) {
        var6_2 = new Throwable().getStackTrace()[1];
        var5_3 /* !! */  = new StringBuilder();
        var5_3 /* !! */ .append(".(");
        var5_3 /* !! */ .append(var6_2.getFileName());
        var5_3 /* !! */ .append(":");
        var5_3 /* !! */ .append(var6_2.getLineNumber());
        var5_3 /* !! */ .append(") ");
        var5_3 /* !! */ .append(var1_1);
        var5_3 /* !! */ .append("  ");
        var5_3 /* !! */  = var5_3 /* !! */ .toString();
        var4_4 = var0.getChildCount();
        var7_5 = System.out;
        var6_2 = new StringBuilder();
        var6_2.append(var1_1);
        var6_2.append(" children ");
        var6_2.append(var4_4);
        var7_5.println(var6_2.toString());
        var2_7 = 0;
        while (var2_7 < var4_4) {
            var1_1 = var0.getChildAt(var2_7);
            var6_2 = System.out;
            var7_5 = new StringBuilder();
            var7_5.append((String)var5_3 /* !! */ );
            var7_5.append("     ");
            var7_5.append(Debug.getName((View)var1_1));
            var6_2.println(var7_5.toString());
            var1_1 = var1_1.getLayoutParams();
            var6_2 = var1_1.getClass().getFields();
            block3: for (var3_8 = 0; var3_8 < var6_2.length; ++var3_8) {
                var7_5 = var6_2[var3_8];
                try {
                    var9_10 = var7_5.get(var1_1);
                    if (var7_5.getName().contains("To") && !var9_10.toString().equals("-1")) {
                        var10_11 = System.out;
                        var8_9 = new StringBuilder();
                        var8_9.append((String)var5_3 /* !! */ );
                        var8_9.append("       ");
                        var8_9.append(var7_5.getName());
                        var8_9.append(" ");
                        var8_9.append(var9_10);
                        var10_11.println(var8_9.toString());
                    }
lbl60:
                    // 4 sources

                    continue block3;
                }
                catch (IllegalAccessException var7_6) {
                    ** continue;
                }
            }
            ++var2_7;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void dumpPoc(Object var0) {
        var2_1 = new Throwable().getStackTrace()[1];
        var3_2 /* !! */  = new StringBuilder();
        var3_2 /* !! */ .append(".(");
        var3_2 /* !! */ .append(var2_1.getFileName());
        var3_2 /* !! */ .append(":");
        var3_2 /* !! */ .append(var2_1.getLineNumber());
        var3_2 /* !! */ .append(")");
        var3_2 /* !! */  = var3_2 /* !! */ .toString();
        var2_1 = var0.getClass();
        var5_3 = System.out;
        var4_5 = new StringBuilder();
        var4_5.append((String)var3_2 /* !! */ );
        var4_5.append("------------- ");
        var4_5.append(var2_1.getName());
        var4_5.append(" --------------------");
        var5_3.println(var4_5.toString());
        var4_5 = var2_1.getFields();
        var1_6 = 0;
        block2: while (true) {
            if (var1_6 >= ((Field[])var4_5).length) {
                var4_5 = System.out;
                var0 = new StringBuilder();
                var0.append((String)var3_2 /* !! */ );
                var0.append("------------- ");
                var0.append(var2_1.getSimpleName());
                var0.append(" --------------------");
                var4_5.println(var0.toString());
                return;
            }
            var6_7 = var4_5[var1_6];
            try {
                var8_9 = var6_7.get(var0);
                if (!(!var6_7.getName().startsWith("layout_constraint") || var8_9 instanceof Integer && var8_9.toString().equals("-1") || var8_9 instanceof Integer && var8_9.toString().equals("0") || var8_9 instanceof Float && var8_9.toString().equals("1.0") || var8_9 instanceof Float && var8_9.toString().equals("0.5"))) {
                    var5_3 = System.out;
                    var7_8 = new StringBuilder();
                    var7_8.append((String)var3_2 /* !! */ );
                    var7_8.append("    ");
                    var7_8.append(var6_7.getName());
                    var7_8.append(" ");
                    var7_8.append(var8_9);
                    var5_3.println(var7_8.toString());
                }
lbl59:
                // 4 sources

                while (true) {
                    ++var1_6;
                    continue block2;
                    break;
                }
            }
            catch (IllegalAccessException var5_4) {
                ** continue;
            }
        }
    }

    public static String getActionType(MotionEvent fieldArray) {
        int n = fieldArray.getAction();
        fieldArray = MotionEvent.class.getFields();
        int n2 = 0;
        while (n2 < fieldArray.length) {
            Object object = fieldArray[n2];
            try {
                if (Modifier.isStatic(((Field)object).getModifiers()) && ((Field)object).getType().equals(Integer.TYPE) && ((Field)object).getInt(null) == n) {
                    object = ((Field)object).getName();
                    return object;
                }
            }
            catch (IllegalAccessException illegalAccessException) {}
            ++n2;
        }
        return "---";
    }

    public static String getCallFrom(int n) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[n + 2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(":");
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(":");
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(") ");
        stringBuilder.append(stackTraceElement.getMethodName());
        stringBuilder.append("()");
        return stringBuilder.toString();
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(":");
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(".(");
        stringBuilder.append(stackTraceElement.getFileName());
        stringBuilder.append(":");
        stringBuilder.append(stackTraceElement.getLineNumber());
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static String getName(Context context, int n) {
        if (n == -1) return "UNKNOWN";
        try {
            return context.getResources().getResourceEntryName(n);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("?");
            stringBuilder.append(n);
            return stringBuilder.toString();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static String getName(Context object, int[] nArray) {
        CharSequence charSequence;
        try {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(nArray.length);
            ((StringBuilder)charSequence).append("[");
            charSequence = ((StringBuilder)charSequence).toString();
            for (int i = 0; i < nArray.length; ++i) {
                CharSequence charSequence2 = new StringBuilder();
                charSequence2.append((String)charSequence);
                charSequence = i == 0 ? "" : " ";
                charSequence2.append((String)charSequence);
                charSequence2 = charSequence2.toString();
                try {
                    charSequence = object.getResources().getResourceEntryName(nArray[i]);
                }
                catch (Resources.NotFoundException notFoundException) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("? ");
                    ((StringBuilder)charSequence).append(nArray[i]);
                    ((StringBuilder)charSequence).append(" ");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence2);
                stringBuilder.append((String)charSequence);
                charSequence = stringBuilder.toString();
            }
        }
        catch (Exception exception) {
            Log.v((String)"DEBUG", (String)exception.toString());
            return "UNKNOWN";
        }
        {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append("]");
            object = ((StringBuilder)object).toString();
            return object;
        }
    }

    public static String getName(View object) {
        try {
            object = object.getContext().getResources().getResourceEntryName(object.getId());
            return object;
        }
        catch (Exception exception) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int n) {
        if (n != -1) return motionLayout.getContext().getResources().getResourceEntryName(n);
        return "UNDEFINED";
    }

    public static void logStack(String string, String string2, int n) {
        StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
        int n2 = stackTraceElementArray.length;
        int n3 = 1;
        n2 = Math.min(n, n2 - 1);
        String string3 = " ";
        n = n3;
        while (n <= n2) {
            Object object = stackTraceElementArray[n];
            object = new StringBuilder();
            ((StringBuilder)object).append(".(");
            ((StringBuilder)object).append(stackTraceElementArray[n].getFileName());
            ((StringBuilder)object).append(":");
            ((StringBuilder)object).append(stackTraceElementArray[n].getLineNumber());
            ((StringBuilder)object).append(") ");
            ((StringBuilder)object).append(stackTraceElementArray[n].getMethodName());
            object = ((StringBuilder)object).toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(" ");
            string3 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            Log.v((String)string, (String)stringBuilder.toString());
            ++n;
        }
    }

    public static void printStack(String string, int n) {
        StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
        int n2 = stackTraceElementArray.length;
        int n3 = 1;
        n2 = Math.min(n, n2 - 1);
        String string2 = " ";
        n = n3;
        while (n <= n2) {
            Object object = stackTraceElementArray[n];
            object = new StringBuilder();
            ((StringBuilder)object).append(".(");
            ((StringBuilder)object).append(stackTraceElementArray[n].getFileName());
            ((StringBuilder)object).append(":");
            ((StringBuilder)object).append(stackTraceElementArray[n].getLineNumber());
            ((StringBuilder)object).append(") ");
            object = ((StringBuilder)object).toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(" ");
            string2 = stringBuilder.toString();
            PrintStream printStream = System.out;
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            printStream.println(stringBuilder.toString());
            ++n;
        }
    }
}
