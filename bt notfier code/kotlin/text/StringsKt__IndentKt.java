/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.internal.PlatformImplementationsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 *  kotlin.text.StringsKt__AppendableKt
 *  kotlin.text.StringsKt__IndentKt$getIndentFunction$1
 */
package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__AppendableKt;
import kotlin.text.StringsKt__IndentKt;

@Metadata(d1={"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002\u00a2\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b\u00a2\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2={"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__IndentKt
extends StringsKt__AppendableKt {
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String string) {
        boolean bl = ((CharSequence)string).length() == 0;
        string = bl ? (Function1)getIndentFunction.1.INSTANCE : (Function1)new /* Unavailable Anonymous Inner Class!! */;
        return string;
    }

    private static final int indentWidth$StringsKt__IndentKt(String string) {
        int n;
        int n2;
        block2: {
            CharSequence charSequence = string;
            n2 = charSequence.length();
            for (n = 0; n < n2; ++n) {
                if (!(CharsKt.isWhitespace((char)charSequence.charAt(n)) ^ true)) {
                    continue;
                }
                break block2;
            }
            n = -1;
        }
        n2 = n;
        if (n != -1) return n2;
        n2 = string.length();
        return n2;
    }

    public static final String prependIndent(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$prependIndent");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"indent");
        return SequencesKt.joinToString$default((Sequence)SequencesKt.map((Sequence)StringsKt.lineSequence((CharSequence)string), (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */)), (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null);
    }

    public static /* synthetic */ String prependIndent$default(String string, String string2, int n, Object object) {
        if ((n & 1) == 0) return StringsKt.prependIndent((String)string, (String)string2);
        string2 = "    ";
        return StringsKt.prependIndent((String)string, (String)string2);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> object, int n, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        int n2 = CollectionsKt.getLastIndex(object);
        object = (Iterable)object;
        Collection collection = new ArrayList();
        Iterator<String> iterator = object.iterator();
        int n3 = 0;
        while (true) {
            if (!iterator.hasNext()) {
                object = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)((List)collection), (Appendable)new StringBuilder(n), (CharSequence)"\n", null, null, (int)0, null, null, (int)124, null)).toString();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
                return object;
            }
            object = iterator.next();
            if (n3 < 0) {
                if (!PlatformImplementationsKt.apiVersionIsAtLeast((int)1, (int)3, (int)0)) throw (Throwable)new ArithmeticException("Index overflow has happened.");
                CollectionsKt.throwIndexOverflow();
            }
            String string = (String)object;
            if ((n3 == 0 || n3 == n2) && StringsKt.isBlank((CharSequence)string)) {
                object = null;
            } else {
                String string2 = (String)function12.invoke((Object)string);
                object = string;
                if (string2 != null) {
                    string2 = (String)function1.invoke((Object)string2);
                    object = string;
                    if (string2 != null) {
                        object = string2;
                    }
                }
            }
            if (object != null) {
                collection.add(object);
            }
            ++n3;
        }
    }

    public static final String replaceIndent(String object, String string) {
        Object object2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$replaceIndent");
        Intrinsics.checkNotNullParameter((Object)string, (String)"newIndent");
        Collection<String> collection = StringsKt.lines((CharSequence)((CharSequence)object));
        Object object3 = collection;
        Iterator iterator = new ArrayList();
        Iterator iterator2 = object3.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            if (!(StringsKt.isBlank((CharSequence)((String)object2)) ^ true)) continue;
            iterator.add(object2);
        }
        iterator = (List)((Object)iterator);
        object2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)((Object)iterator), (int)10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2.add(StringsKt__IndentKt.indentWidth$StringsKt__IndentKt((String)iterator.next()));
        }
        object2 = (Integer)CollectionsKt.minOrNull((Iterable)((List)object2));
        int n = 0;
        int n2 = object2 != null ? (Integer)object2 : 0;
        int n3 = ((String)object).length();
        int n4 = string.length();
        int n5 = collection.size();
        object2 = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(string);
        int n6 = CollectionsKt.getLastIndex((List)collection);
        collection = new ArrayList();
        iterator = object3.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                object = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)collection, (Appendable)new StringBuilder(n3 + n4 * n5), (CharSequence)"\n", null, null, (int)0, null, null, (int)124, null)).toString();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
                return object;
            }
            object = iterator.next();
            if (n < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            string = object;
            if ((n == 0 || n == n6) && StringsKt.isBlank((CharSequence)string)) {
                object = null;
            } else {
                object3 = StringsKt.drop((String)string, (int)n2);
                object = string;
                if (object3 != null) {
                    object3 = (String)object2.invoke(object3);
                    object = string;
                    if (object3 != null) {
                        object = object3;
                    }
                }
            }
            if (object != null) {
                collection.add((String)object);
            }
            ++n;
        }
    }

    public static /* synthetic */ String replaceIndent$default(String string, String string2, int n, Object object) {
        if ((n & 1) == 0) return StringsKt.replaceIndent((String)string, (String)string2);
        string2 = "";
        return StringsKt.replaceIndent((String)string, (String)string2);
    }

    public static final String replaceIndentByMargin(String object, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"$this$replaceIndentByMargin");
        Intrinsics.checkNotNullParameter((Object)string, (String)"newIndent");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"marginPrefix");
        if (!(StringsKt.isBlank((CharSequence)string2) ^ true)) {
            object = new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
            throw object;
        }
        Object object2 = StringsKt.lines((CharSequence)((CharSequence)object));
        int n = ((String)object).length();
        int n2 = string.length();
        int n3 = object2.size();
        Function1<String, String> function1 = StringsKt__IndentKt.getIndentFunction$StringsKt__IndentKt(string);
        int n4 = CollectionsKt.getLastIndex((List)object2);
        object = (Iterable)object2;
        Collection collection = new ArrayList();
        Iterator iterator = object.iterator();
        int n5 = 0;
        while (true) {
            if (!iterator.hasNext()) {
                object = ((StringBuilder)CollectionsKt.joinTo$default((Iterable)((List)collection), (Appendable)new StringBuilder(n + n2 * n3), (CharSequence)"\n", null, null, (int)0, null, null, (int)124, null)).toString();
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"mapIndexedNotNull { inde\u2026\"\\n\")\n        .toString()");
                return object;
            }
            object = iterator.next();
            if (n5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            object2 = (String)object;
            object = null;
            string = null;
            if (n5 != 0 && n5 != n4 || !StringsKt.isBlank((CharSequence)((CharSequence)object2))) {
                int n6;
                int n7;
                block11: {
                    object = (CharSequence)object2;
                    n7 = object.length();
                    for (n6 = 0; n6 < n7; ++n6) {
                        if (!(CharsKt.isWhitespace((char)object.charAt(n6)) ^ true)) {
                            continue;
                        }
                        break block11;
                    }
                    n6 = -1;
                }
                if (n6 != -1 && StringsKt.startsWith$default((String)object2, (String)string2, (int)n6, (boolean)false, (int)4, null)) {
                    n7 = string2.length();
                    if (object2 == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    string = ((String)object2).substring(n6 + n7);
                    Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.String).substring(startIndex)");
                }
                object = object2;
                if (string != null) {
                    string = (String)function1.invoke((Object)string);
                    object = object2;
                    if (string != null) {
                        object = string;
                    }
                }
            }
            if (object != null) {
                collection.add(object);
            }
            ++n5;
        }
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String string, String string2, String string3, int n, Object object) {
        if ((n & 1) != 0) {
            string2 = "";
        }
        if ((n & 2) == 0) return StringsKt.replaceIndentByMargin((String)string, (String)string2, (String)string3);
        string3 = "|";
        return StringsKt.replaceIndentByMargin((String)string, (String)string2, (String)string3);
    }

    public static final String trimIndent(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$trimIndent");
        return StringsKt.replaceIndent((String)string, (String)"");
    }

    public static final String trimMargin(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$trimMargin");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"marginPrefix");
        return StringsKt.replaceIndentByMargin((String)string, (String)"", (String)string2);
    }

    public static /* synthetic */ String trimMargin$default(String string, String string2, int n, Object object) {
        if ((n & 1) == 0) return StringsKt.trimMargin((String)string, (String)string2);
        string2 = "|";
        return StringsKt.trimMargin((String)string, (String)string2);
    }
}
