/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Headers
 *  okhttp3.internal.Util
 */
package okhttp3;

import java.util.Arrays;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007\u00a2\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007\u00a2\u0006\u0002\b\u000f\u00a8\u0006\u0015"}, d2={"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", "get", "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Headers.Companion {
    private Headers.Companion() {
    }

    public /* synthetic */ Headers.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ void access$checkName(Headers.Companion companion, String string) {
        companion.checkName(string);
    }

    public static final /* synthetic */ void access$checkValue(Headers.Companion companion, String string, String string2) {
        companion.checkValue(string, string2);
    }

    public static final /* synthetic */ String access$get(Headers.Companion companion, String[] stringArray, String string) {
        return companion.get(stringArray, string);
    }

    private final void checkName(String object) {
        int n = ((CharSequence)object).length() > 0 ? 1 : 0;
        if (n == 0) {
            object = new IllegalArgumentException("name is empty".toString());
            throw object;
        }
        int n2 = ((String)object).length() - 1;
        if (n2 < 0) return;
        n = 0;
        while (true) {
            int n3 = n + 1;
            char c = ((String)object).charAt(n);
            boolean bl = '!' <= c && c <= '~';
            if (!bl) {
                throw (Throwable)new IllegalArgumentException(Util.format((String)"Unexpected char %#04x at %d in header name: %s", (Object[])new Object[]{(int)c, n, object}).toString());
            }
            if (n3 > n2) {
                return;
            }
            n = n3;
        }
    }

    private final void checkValue(String string, String string2) {
        int n = string.length() - 1;
        if (n < 0) return;
        int n2 = 0;
        while (true) {
            boolean bl;
            int n3 = n2 + 1;
            char c = string.charAt(n2);
            bl = c == '\t' || (bl = ' ' <= c && c <= '~');
            if (!bl) {
                String string3 = Util.format((String)"Unexpected char %#04x at %d in %s value", (Object[])new Object[]{(int)c, n2, string2});
                string = Util.isSensitiveHeader((String)string2) ? "" : Intrinsics.stringPlus((String)": ", (Object)string);
                throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)string3, (Object)string).toString());
            }
            if (n3 > n) {
                return;
            }
            n2 = n3;
        }
    }

    private final String get(String[] stringArray, String string) {
        int n = stringArray.length - 2;
        int n2 = ProgressionUtilKt.getProgressionLastElement((int)n, (int)0, (int)-2);
        if (n2 > n) return null;
        while (!StringsKt.equals((String)string, (String)stringArray[n], (boolean)true)) {
            if (n == n2) {
                return null;
            }
            n -= 2;
        }
        return stringArray[n + 1];
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="function moved to extension", replaceWith=@ReplaceWith(expression="headers.toHeaders()", imports={}))
    public final Headers _deprecated_of(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, (String)"headers");
        return this.of(map);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="function name changed", replaceWith=@ReplaceWith(expression="headersOf(*namesAndValues)", imports={}))
    public final Headers _deprecated_of(String ... stringArray) {
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"namesAndValues");
        return this.of(Arrays.copyOf(stringArray, stringArray.length));
    }

    @JvmStatic
    public final Headers of(Map<String, String> object) {
        Intrinsics.checkNotNullParameter(object, (String)"<this>");
        String[] stringArray = new String[object.size() * 2];
        object = object.entrySet().iterator();
        int n = 0;
        while (object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string = (String)object2.getKey();
            object2 = (String)object2.getValue();
            if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            string = ((Object)StringsKt.trim((CharSequence)string)).toString();
            if (object2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            object2 = ((Object)StringsKt.trim((CharSequence)((CharSequence)object2))).toString();
            this.checkName(string);
            this.checkValue((String)object2, string);
            stringArray[n] = string;
            stringArray[n + 1] = object2;
            n += 2;
        }
        return new Headers(stringArray, null);
    }

    @JvmStatic
    public final Headers of(String ... stringArray) {
        String string;
        int n;
        Intrinsics.checkNotNullParameter((Object)stringArray, (String)"namesAndValues");
        int n2 = stringArray.length;
        int n3 = 0;
        n2 = n2 % 2 == 0 ? 1 : 0;
        if (n2 == 0) {
            stringArray = new IllegalArgumentException("Expected alternating header names and values".toString());
            throw stringArray;
        }
        int n4 = (stringArray = (String[])stringArray.clone()).length - 1;
        if (n4 >= 0) {
            n2 = 0;
            while (true) {
                int n5 = n2 + 1;
                n = stringArray[n2] != null ? 1 : 0;
                if (n == 0) throw (Throwable)new IllegalArgumentException("Headers cannot be null".toString());
                string = stringArray[n2];
                if (string == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                stringArray[n2] = ((Object)StringsKt.trim((CharSequence)string)).toString();
                if (n5 > n4) break;
                n2 = n5;
            }
        }
        if ((n = ProgressionUtilKt.getProgressionLastElement((int)0, (int)(stringArray.length - 1), (int)2)) < 0) return new Headers(stringArray, null);
        n2 = n3;
        while (true) {
            String string2 = stringArray[n2];
            string = stringArray[n2 + 1];
            this.checkName(string2);
            this.checkValue(string, string2);
            if (n2 == n) {
                return new Headers(stringArray, null);
            }
            n2 += 2;
        }
    }
}
