/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.view.inputmethod.EditorInfo
 *  androidx.core.util.Preconditions
 *  androidx.core.view.inputmethod.EditorInfoCompat$Impl30
 */
package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;
import androidx.core.view.inputmethod.EditorInfoCompat;

/*
 * Exception performing whole class analysis ignored.
 */
public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 0x1000000;
    static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    @Deprecated
    public EditorInfoCompat() {
    }

    public static String[] getContentMimeTypes(EditorInfo stringArray) {
        String[] stringArray2;
        if (Build.VERSION.SDK_INT >= 25) {
            stringArray = stringArray.contentMimeTypes;
            if (stringArray != null) return stringArray;
            stringArray = EMPTY_STRING_ARRAY;
            return stringArray;
        }
        if (stringArray.extras == null) {
            return EMPTY_STRING_ARRAY;
        }
        String[] stringArray3 = stringArray2 = stringArray.extras.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (stringArray2 == null) {
            stringArray3 = stringArray.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        }
        if (stringArray3 != null) return stringArray3;
        stringArray3 = EMPTY_STRING_ARRAY;
        return stringArray3;
    }

    public static CharSequence getInitialSelectedText(EditorInfo object, int n) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialSelectedText((EditorInfo)object, (int)n);
        }
        if (((EditorInfo)object).extras == null) {
            return null;
        }
        int n2 = ((EditorInfo)object).initialSelStart > ((EditorInfo)object).initialSelEnd ? ((EditorInfo)object).initialSelEnd : ((EditorInfo)object).initialSelStart;
        int n3 = ((EditorInfo)object).initialSelStart > ((EditorInfo)object).initialSelEnd ? ((EditorInfo)object).initialSelStart : ((EditorInfo)object).initialSelEnd;
        int n4 = ((EditorInfo)object).extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD");
        int n5 = ((EditorInfo)object).extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END");
        if (((EditorInfo)object).initialSelStart < 0) return null;
        if (((EditorInfo)object).initialSelEnd < 0) return null;
        if (n5 - n4 != n3 - n2) {
            return null;
        }
        object = ((EditorInfo)object).extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
        if (object == null) {
            return null;
        }
        object = (n & 1) != 0 ? object.subSequence(n4, n5) : TextUtils.substring((CharSequence)object, (int)n4, (int)n5);
        return object;
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo object, int n, int n2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialTextAfterCursor((EditorInfo)object, (int)n, (int)n2);
        }
        if (object.extras == null) {
            return null;
        }
        CharSequence charSequence = object.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
        if (charSequence == null) {
            return null;
        }
        int n3 = object.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END");
        n = Math.min(n, charSequence.length() - n3);
        object = (n2 & 1) != 0 ? charSequence.subSequence(n3, n + n3) : TextUtils.substring((CharSequence)charSequence, (int)n3, (int)(n + n3));
        return object;
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo object, int n, int n2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Impl30.getInitialTextBeforeCursor((EditorInfo)object, (int)n, (int)n2);
        }
        if (object.extras == null) {
            return null;
        }
        CharSequence charSequence = object.extras.getCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT");
        if (charSequence == null) {
            return null;
        }
        int n3 = object.extras.getInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD");
        n = Math.min(n, n3);
        object = (n2 & 1) != 0 ? charSequence.subSequence(n3 - n, n3) : TextUtils.substring((CharSequence)charSequence, (int)(n3 - n), (int)n3);
        return object;
    }

    static int getProtocol(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            return 1;
        }
        if (editorInfo.extras == null) {
            return 0;
        }
        boolean bl = editorInfo.extras.containsKey("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        boolean bl2 = editorInfo.extras.containsKey("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
        if (bl && bl2) {
            return 4;
        }
        if (bl) {
            return 3;
        }
        if (!bl2) return 0;
        return 2;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int n, int n2) {
        if (n2 == 0) return Character.isLowSurrogate(charSequence.charAt(n));
        if (n2 == 1) return Character.isHighSurrogate(charSequence.charAt(n));
        return false;
    }

    private static boolean isPasswordInputType(int n) {
        boolean bl = (n &= 0xFFF) == 129 || n == 225 || n == 18;
        return bl;
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] stringArray) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = stringArray;
        } else {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", stringArray);
            editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", stringArray);
        }
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int n) {
        Preconditions.checkNotNull((Object)charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setInitialSurroundingSubText((EditorInfo)editorInfo, (CharSequence)charSequence, (int)n);
            return;
        }
        int n2 = editorInfo.initialSelStart > editorInfo.initialSelEnd ? editorInfo.initialSelEnd : editorInfo.initialSelStart;
        int n3 = n2 - n;
        n2 = editorInfo.initialSelStart > editorInfo.initialSelEnd ? editorInfo.initialSelStart : editorInfo.initialSelEnd;
        int n4 = n2 - n;
        n2 = charSequence.length();
        if (n >= 0 && n3 >= 0 && n4 <= n2) {
            if (EditorInfoCompat.isPasswordInputType(editorInfo.inputType)) {
                EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
                return;
            }
            if (n2 <= 2048) {
                EditorInfoCompat.setSurroundingText(editorInfo, charSequence, n3, n4);
                return;
            }
            EditorInfoCompat.trimLongSurroundingText(editorInfo, charSequence, n3, n4);
            return;
        }
        EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.setInitialSurroundingSubText((EditorInfo)editorInfo, (CharSequence)charSequence, (int)0);
        } else {
            EditorInfoCompat.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int n, int n2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        charSequence = charSequence != null ? new SpannableStringBuilder(charSequence) : null;
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", n);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", n2);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int n, int n2) {
        int n3 = n2 - n;
        int n4 = n3 > 1024 ? 0 : n3;
        int n5 = charSequence.length();
        int n6 = 2048 - n4;
        double d = n6;
        Double.isNaN(d);
        int n7 = Math.min(n5 - n2, n6 - Math.min(n, (int)(d * 0.8)));
        n5 = Math.min(n, n6 - n7);
        int n8 = n - n5;
        n6 = n5;
        n = n8;
        if (EditorInfoCompat.isCutOnSurrogate(charSequence, n8, 0)) {
            n = n8 + 1;
            n6 = n5 - 1;
        }
        n5 = n7;
        if (EditorInfoCompat.isCutOnSurrogate(charSequence, n2 + n7 - 1, 1)) {
            n5 = n7 - 1;
        }
        charSequence = n4 != n3 ? TextUtils.concat((CharSequence[])new CharSequence[]{charSequence.subSequence(n, n + n6), charSequence.subSequence(n2, n5 + n2)}) : charSequence.subSequence(n, n6 + n4 + n5 + n);
        n = n6 + 0;
        EditorInfoCompat.setSurroundingText(editorInfo, charSequence, n, n4 + n);
    }
}
