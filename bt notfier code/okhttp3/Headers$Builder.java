/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.internal.ProgressionUtilKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Headers
 *  okhttp3.Headers$Companion
 *  okhttp3.internal.http.DatesKt
 */
package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.http.DatesKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000\u00a2\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0018"}, d2={"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", "build", "get", "removeAll", "set", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Headers.Builder {
    private final List<String> namesAndValues = new ArrayList(20);

    public final Headers.Builder add(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"line");
        Headers.Builder builder = this;
        int n = StringsKt.indexOf$default((CharSequence)string, (char)':', (int)0, (boolean)false, (int)6, null);
        boolean bl = n != -1;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected header: ", (Object)string).toString());
        String string2 = string.substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        if (string2 == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        string2 = ((Object)StringsKt.trim((CharSequence)string2)).toString();
        string = string.substring(n + 1);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
        builder.add(string2, string);
        return builder;
    }

    public final Headers.Builder add(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Headers.Builder builder = this;
        Headers.Companion.access$checkName((Headers.Companion)Headers.Companion, (String)string);
        Headers.Companion.access$checkValue((Headers.Companion)Headers.Companion, (String)string2, (String)string);
        builder.addLenient$okhttp(string, string2);
        return builder;
    }

    public final Headers.Builder add(String string, Instant instant) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)instant, (String)"value");
        Headers.Builder builder = this;
        builder.add(string, new Date(instant.toEpochMilli()));
        return builder;
    }

    public final Headers.Builder add(String string, Date date) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)date, (String)"value");
        Headers.Builder builder = this;
        builder.add(string, DatesKt.toHttpDateString((Date)date));
        return builder;
    }

    public final Headers.Builder addAll(Headers headers) {
        Intrinsics.checkNotNullParameter((Object)headers, (String)"headers");
        Headers.Builder builder = this;
        int n = headers.size();
        if (n <= 0) return builder;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            builder.addLenient$okhttp(headers.name(n2), headers.value(n2));
            if (n3 >= n) {
                return builder;
            }
            n2 = n3;
        }
    }

    public final Headers.Builder addLenient$okhttp(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"line");
        Headers.Builder builder = this;
        int n = StringsKt.indexOf$default((CharSequence)string, (char)':', (int)1, (boolean)false, (int)4, null);
        if (n != -1) {
            String string2 = string.substring(0, n);
            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            string = string.substring(n + 1);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
            builder.addLenient$okhttp(string2, string);
        } else if (string.charAt(0) == ':') {
            string = string.substring(1);
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
            builder.addLenient$okhttp("", string);
        } else {
            builder.addLenient$okhttp("", string);
        }
        return builder;
    }

    public final Headers.Builder addLenient$okhttp(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Headers.Builder builder = this;
        builder.getNamesAndValues$okhttp().add(string);
        builder.getNamesAndValues$okhttp().add(((Object)StringsKt.trim((CharSequence)string2)).toString());
        return builder;
    }

    public final Headers.Builder addUnsafeNonAscii(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Headers.Builder builder = this;
        Headers.Companion.access$checkName((Headers.Companion)Headers.Companion, (String)string);
        builder.addLenient$okhttp(string, string2);
        return builder;
    }

    public final Headers build() {
        String[] stringArray = ((Collection)this.namesAndValues).toArray(new String[0]);
        if (stringArray == null) throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        return new Headers(stringArray, null);
    }

    public final String get(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        int n = this.namesAndValues.size() - 2;
        int n2 = ProgressionUtilKt.getProgressionLastElement((int)n, (int)0, (int)-2);
        if (n2 > n) return null;
        while (!StringsKt.equals((String)string, (String)this.namesAndValues.get(n), (boolean)true)) {
            if (n == n2) {
                return null;
            }
            n -= 2;
        }
        return this.namesAndValues.get(n + 1);
    }

    public final List<String> getNamesAndValues$okhttp() {
        return this.namesAndValues;
    }

    public final Headers.Builder removeAll(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Headers.Builder builder = this;
        int n = 0;
        while (n < builder.getNamesAndValues$okhttp().size()) {
            int n2 = n;
            if (StringsKt.equals((String)string, (String)builder.getNamesAndValues$okhttp().get(n), (boolean)true)) {
                builder.getNamesAndValues$okhttp().remove(n);
                builder.getNamesAndValues$okhttp().remove(n);
                n2 = n - 2;
            }
            n = n2 + 2;
        }
        return builder;
    }

    public final Headers.Builder set(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        Headers.Builder builder = this;
        Headers.Companion.access$checkName((Headers.Companion)Headers.Companion, (String)string);
        Headers.Companion.access$checkValue((Headers.Companion)Headers.Companion, (String)string2, (String)string);
        builder.removeAll(string);
        builder.addLenient$okhttp(string, string2);
        return builder;
    }

    public final Headers.Builder set(String string, Instant instant) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)instant, (String)"value");
        return this.set(string, new Date(instant.toEpochMilli()));
    }

    public final Headers.Builder set(String string, Date date) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)date, (String)"value");
        Headers.Builder builder = this;
        builder.set(string, DatesKt.toHttpDateString((Date)date));
        return builder;
    }
}
