/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.text.CharDirectionality$Companion
 *  kotlin.text.CharDirectionality$Companion$directionalityMap$2
 */
package kotlin.text;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.CharDirectionality;

@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0001\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u00a8\u0006\u001c"}, d2={"Lkotlin/text/CharDirectionality;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class CharDirectionality
extends Enum<CharDirectionality> {
    private static final CharDirectionality[] $VALUES;
    public static final /* enum */ CharDirectionality ARABIC_NUMBER;
    public static final /* enum */ CharDirectionality BOUNDARY_NEUTRAL;
    public static final /* enum */ CharDirectionality COMMON_NUMBER_SEPARATOR;
    public static final Companion Companion;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER_SEPARATOR;
    public static final /* enum */ CharDirectionality EUROPEAN_NUMBER_TERMINATOR;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT_EMBEDDING;
    public static final /* enum */ CharDirectionality LEFT_TO_RIGHT_OVERRIDE;
    public static final /* enum */ CharDirectionality NONSPACING_MARK;
    public static final /* enum */ CharDirectionality OTHER_NEUTRALS;
    public static final /* enum */ CharDirectionality PARAGRAPH_SEPARATOR;
    public static final /* enum */ CharDirectionality POP_DIRECTIONAL_FORMAT;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_ARABIC;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_EMBEDDING;
    public static final /* enum */ CharDirectionality RIGHT_TO_LEFT_OVERRIDE;
    public static final /* enum */ CharDirectionality SEGMENT_SEPARATOR;
    public static final /* enum */ CharDirectionality UNDEFINED;
    public static final /* enum */ CharDirectionality WHITESPACE;
    private static final Lazy directionalityMap$delegate;
    private final int value;

    static {
        CharDirectionality charDirectionality;
        CharDirectionality charDirectionality2;
        CharDirectionality charDirectionality3;
        CharDirectionality charDirectionality4;
        CharDirectionality charDirectionality5;
        CharDirectionality charDirectionality6;
        CharDirectionality charDirectionality7;
        CharDirectionality charDirectionality8;
        CharDirectionality charDirectionality9;
        CharDirectionality charDirectionality10;
        CharDirectionality charDirectionality11;
        CharDirectionality charDirectionality12;
        CharDirectionality charDirectionality13;
        CharDirectionality charDirectionality14;
        CharDirectionality charDirectionality15;
        CharDirectionality charDirectionality16;
        CharDirectionality charDirectionality17;
        CharDirectionality charDirectionality18;
        CharDirectionality charDirectionality19;
        CharDirectionality charDirectionality20;
        UNDEFINED = charDirectionality20 = new CharDirectionality(-1);
        LEFT_TO_RIGHT = charDirectionality19 = new CharDirectionality(0);
        RIGHT_TO_LEFT = charDirectionality18 = new CharDirectionality(1);
        RIGHT_TO_LEFT_ARABIC = charDirectionality17 = new CharDirectionality(2);
        EUROPEAN_NUMBER = charDirectionality16 = new CharDirectionality(3);
        EUROPEAN_NUMBER_SEPARATOR = charDirectionality15 = new CharDirectionality(4);
        EUROPEAN_NUMBER_TERMINATOR = charDirectionality14 = new CharDirectionality(5);
        ARABIC_NUMBER = charDirectionality13 = new CharDirectionality(6);
        COMMON_NUMBER_SEPARATOR = charDirectionality12 = new CharDirectionality(7);
        NONSPACING_MARK = charDirectionality11 = new CharDirectionality(8);
        BOUNDARY_NEUTRAL = charDirectionality10 = new CharDirectionality(9);
        PARAGRAPH_SEPARATOR = charDirectionality9 = new CharDirectionality(10);
        SEGMENT_SEPARATOR = charDirectionality8 = new CharDirectionality(11);
        WHITESPACE = charDirectionality7 = new CharDirectionality(12);
        OTHER_NEUTRALS = charDirectionality6 = new CharDirectionality(13);
        LEFT_TO_RIGHT_EMBEDDING = charDirectionality5 = new CharDirectionality(14);
        LEFT_TO_RIGHT_OVERRIDE = charDirectionality4 = new CharDirectionality(15);
        RIGHT_TO_LEFT_EMBEDDING = charDirectionality3 = new CharDirectionality(16);
        RIGHT_TO_LEFT_OVERRIDE = charDirectionality2 = new CharDirectionality(17);
        POP_DIRECTIONAL_FORMAT = charDirectionality = new CharDirectionality(18);
        $VALUES = new CharDirectionality[]{charDirectionality20, charDirectionality19, charDirectionality18, charDirectionality17, charDirectionality16, charDirectionality15, charDirectionality14, charDirectionality13, charDirectionality12, charDirectionality11, charDirectionality10, charDirectionality9, charDirectionality8, charDirectionality7, charDirectionality6, charDirectionality5, charDirectionality4, charDirectionality3, charDirectionality2, charDirectionality};
        Companion = new Companion(null);
        directionalityMap$delegate = LazyKt.lazy((Function0)((Function0)Companion.directionalityMap.2.INSTANCE));
    }

    private CharDirectionality(int n2) {
        this.value = n2;
    }

    public static final /* synthetic */ Lazy access$getDirectionalityMap$cp() {
        return directionalityMap$delegate;
    }

    public static CharDirectionality valueOf(String string) {
        return Enum.valueOf(CharDirectionality.class, string);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[])$VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
