/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.http.DatesKt$STANDARD_DATE_FORMAT$1
 */
package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

@Metadata(d1={"\u0000+\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\u001a\f\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0005\u001a\n\u0010\u000e\u001a\u00020\u0005*\u00020\r\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u000f"}, d2={"BROWSER_COMPATIBLE_DATE_FORMATS", "", "Ljava/text/DateFormat;", "[Ljava/text/DateFormat;", "BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS", "", "[Ljava/lang/String;", "MAX_DATE", "", "STANDARD_DATE_FORMAT", "okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Lokhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1;", "toHttpDateOrNull", "Ljava/util/Date;", "toHttpDateString", "okhttp"}, k=2, mv={1, 5, 1}, xi=48)
public final class DatesKt {
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    public static final long MAX_DATE = 253402300799999L;
    private static final STANDARD_DATE_FORMAT.1 STANDARD_DATE_FORMAT;

    static {
        STANDARD_DATE_FORMAT = new /* Unavailable Anonymous Inner Class!! */;
        String[] stringArray = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = stringArray;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[stringArray.length];
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static final Date toHttpDateOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        if (((CharSequence)string).length() == 0) {
            return null;
        }
        int n = 0;
        if (n != 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Cloneable cloneable = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(string, parsePosition);
        if (parsePosition.getIndex() == string.length()) {
            return cloneable;
        }
        String[] stringArray = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (stringArray) {
            int n2 = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
            if (n2 > 0) {
                n = 0;
                while (true) {
                    int n3 = n + 1;
                    DateFormat dateFormat = BROWSER_COMPATIBLE_DATE_FORMATS[n];
                    cloneable = dateFormat;
                    if (dateFormat == null) {
                        cloneable = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[n], Locale.US);
                        ((DateFormat)cloneable).setTimeZone(Util.UTC);
                        cloneable = (DateFormat)cloneable;
                        DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS[n] = cloneable;
                    }
                    parsePosition.setIndex(0);
                    cloneable = ((DateFormat)cloneable).parse(string, parsePosition);
                    n = parsePosition.getIndex();
                    if (n != 0) return cloneable;
                    if (n3 >= n2) break;
                    n = n3;
                }
            }
            string = Unit.INSTANCE;
            return null;
        }
    }

    public static final String toHttpDateString(Date object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = ((DateFormat)STANDARD_DATE_FORMAT.get()).format((Date)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"STANDARD_DATE_FORMAT.get().format(this)");
        return object;
    }
}
