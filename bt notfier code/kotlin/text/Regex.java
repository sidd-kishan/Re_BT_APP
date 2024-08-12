/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.MatchResult
 *  kotlin.text.MatcherMatchResult
 *  kotlin.text.Regex$Companion
 *  kotlin.text.Regex$Serialized
 *  kotlin.text.Regex$findAll$2
 *  kotlin.text.Regex$fromInt$$inlined$apply$lambda$1
 *  kotlin.text.RegexKt
 *  kotlin.text.RegexOption
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;
import kotlin.text.Regex$fromInt$;
import kotlin.text.RegexKt;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u00062"}, d2={"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", "limit", "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class Regex
implements Serializable {
    public static final Companion Companion = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public Regex(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"pattern");
        object = Pattern.compile((String)object);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Pattern.compile(pattern)");
        this((Pattern)object);
    }

    public Regex(String object, Set<? extends RegexOption> set) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"pattern");
        Intrinsics.checkNotNullParameter(set, (String)"options");
        object = Pattern.compile((String)object, kotlin.text.Regex$Companion.access$ensureUnicodeCase((Companion)Companion, (int)RegexKt.access$toInt((Iterable)set)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Pattern.compile(pattern,\u2026odeCase(options.toInt()))");
        this((Pattern)object);
    }

    public Regex(String object, RegexOption regexOption) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"pattern");
        Intrinsics.checkNotNullParameter((Object)regexOption, (String)"option");
        object = Pattern.compile((String)object, kotlin.text.Regex$Companion.access$ensureUnicodeCase((Companion)Companion, (int)regexOption.getValue()));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"Pattern.compile(pattern,\u2026nicodeCase(option.value))");
        this((Pattern)object);
    }

    public Regex(Pattern pattern) {
        Intrinsics.checkNotNullParameter((Object)pattern, (String)"nativePattern");
        this.nativePattern = pattern;
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex regex) {
        return regex.nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return regex.find(charSequence, n);
        n = 0;
        return regex.find(charSequence, n);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return regex.findAll(charSequence, n);
        n = 0;
        return regex.findAll(charSequence, n);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return regex.split(charSequence, n);
        n = 0;
        return regex.split(charSequence, n);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int n, int n2, Object object) {
        if ((n2 & 2) == 0) return regex.splitToSequence(charSequence, n);
        n = 0;
        return regex.splitToSequence(charSequence, n);
    }

    private final Object writeReplace() {
        String string = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"nativePattern.pattern()");
        return new Serialized(string, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        return this.nativePattern.matcher(charSequence).find();
    }

    public final MatchResult find(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"nativePattern.matcher(input)");
        return RegexKt.access$findNext((Matcher)matcher, (int)n, (CharSequence)charSequence);
    }

    public final Sequence<MatchResult> findAll(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        if (n >= 0 && n <= charSequence.length()) {
            return SequencesKt.generateSequence((Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */), (Function1)((Function1)findAll.2.INSTANCE));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Start index out of bounds: ");
        stringBuilder.append(n);
        stringBuilder.append(", input length: ");
        stringBuilder.append(charSequence.length());
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final Set<RegexOption> getOptions() {
        Set<RegexOption> set = this._options;
        if (set != null) return set;
        int n = this.nativePattern.flags();
        set = EnumSet.allOf(RegexOption.class);
        CollectionsKt.retainAll((Iterable)set, (Function1)((Function1)new fromInt$$inlined$apply$lambda$1(n)));
        set = Collections.unmodifiableSet(set);
        Intrinsics.checkNotNullExpressionValue(set, (String)"Collections.unmodifiable\u2026mask == it.value }\n    })");
        this._options = set;
        return set;
    }

    public final String getPattern() {
        String string = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"nativePattern.pattern()");
        return string;
    }

    public final MatchResult matchAt(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        Matcher matcher = this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(n, charSequence.length());
        if (matcher.lookingAt()) {
            Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"this");
            charSequence = new MatcherMatchResult(matcher, charSequence);
        } else {
            charSequence = null;
        }
        return (MatchResult)charSequence;
    }

    public final MatchResult matchEntire(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue((Object)matcher, (String)"nativePattern.matcher(input)");
        return RegexKt.access$matchEntire((Matcher)matcher, (CharSequence)charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    public final boolean matchesAt(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        return this.nativePattern.matcher(charSequence).useAnchoringBounds(false).useTransparentBounds(true).region(n, charSequence.length()).lookingAt();
    }

    public final String replace(CharSequence charSequence, String string) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        Intrinsics.checkNotNullParameter((Object)string, (String)"replacement");
        charSequence = this.nativePattern.matcher(charSequence).replaceAll(string);
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"nativePattern.matcher(in\u2026).replaceAll(replacement)");
        return charSequence;
    }

    public final String replace(CharSequence charSequence, Function1<? super MatchResult, ? extends CharSequence> function1) {
        int n;
        MatchResult matchResult;
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        Intrinsics.checkNotNullParameter(function1, (String)"transform");
        int n2 = 0;
        MatchResult matchResult2 = Regex.find$default(this, charSequence, 0, 2, null);
        if (matchResult2 == null) return ((Object)charSequence).toString();
        int n3 = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(n3);
        do {
            Intrinsics.checkNotNull((Object)matchResult2);
            stringBuilder.append(charSequence, n2, (int)matchResult2.getRange().getStart());
            stringBuilder.append((CharSequence)function1.invoke((Object)matchResult2));
            n = matchResult2.getRange().getEndInclusive() + 1;
            matchResult = matchResult2.next();
            if (n >= n3) break;
            n2 = n;
            matchResult2 = matchResult;
        } while (matchResult != null);
        if (n < n3) {
            stringBuilder.append(charSequence, n, n3);
        }
        charSequence = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"sb.toString()");
        return charSequence;
    }

    public final String replaceFirst(CharSequence charSequence, String string) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        Intrinsics.checkNotNullParameter((Object)string, (String)"replacement");
        charSequence = this.nativePattern.matcher(charSequence).replaceFirst(string);
        Intrinsics.checkNotNullExpressionValue((Object)charSequence, (String)"nativePattern.matcher(in\u2026replaceFirst(replacement)");
        return charSequence;
    }

    public final List<String> split(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        StringsKt.requireNonNegativeLimit((int)n);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        if (n == 1) return CollectionsKt.listOf((Object)((Object)charSequence).toString());
        if (!matcher.find()) {
            return CollectionsKt.listOf((Object)((Object)charSequence).toString());
        }
        int n2 = 10;
        if (n > 0) {
            n2 = RangesKt.coerceAtMost((int)n, (int)10);
        }
        ArrayList<String> arrayList = new ArrayList<String>(n2);
        n2 = 0;
        int n3 = n - 1;
        n = n2;
        do {
            arrayList.add(((Object)charSequence.subSequence(n, matcher.start())).toString());
            n2 = matcher.end();
            if (n3 >= 0 && arrayList.size() == n3) break;
            n = n2;
        } while (matcher.find());
        arrayList.add(((Object)charSequence.subSequence(n2, charSequence.length())).toString());
        return arrayList;
    }

    public final Sequence<String> splitToSequence(CharSequence charSequence, int n) {
        Intrinsics.checkNotNullParameter((Object)charSequence, (String)"input");
        StringsKt.requireNonNegativeLimit((int)n);
        return SequencesKt.sequence((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"nativePattern.toString()");
        return string;
    }
}
