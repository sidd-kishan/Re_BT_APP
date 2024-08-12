/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UInt
 *  kotlin.ULong
 *  kotlin.UShort
 *  kotlin.UnsignedKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015\u001a\u001c\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\u001a\u0011\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u001a\u0011\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u00f8\u0001\u0000\u001a\u0019\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u00f8\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2={"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class UStringsKt {
    public static final String toString_JSWoG40(long l, int n) {
        return UnsignedKt.ulongToString((long)l, (int)CharsKt.checkRadix((int)n));
    }

    public static final String toString_LxnNnR4(byte by, int n) {
        String string = Integer.toString(by & 0xFF, CharsKt.checkRadix((int)n));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    public static final String toString_V7xB4Y4(int n, int n2) {
        String string = Long.toString((long)n & 0xFFFFFFFFL, CharsKt.checkRadix((int)n2));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Long.toString(this, checkRadix(radix))");
        return string;
    }

    public static final String toString_olVBNx4(short s, int n) {
        String string = Integer.toString(s & 0xFFFF, CharsKt.checkRadix((int)n));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string;
    }

    public static final byte toUByte(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUByte");
        UByte uByte = UStringsKt.toUByteOrNull(string);
        if (uByte != null) {
            return uByte.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final byte toUByte(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUByte");
        UByte uByte = UStringsKt.toUByteOrNull(string, n);
        if (uByte != null) {
            return uByte.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final UByte toUByteOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUByteOrNull");
        return UStringsKt.toUByteOrNull(string, 10);
    }

    public static final UByte toUByteOrNull(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUByteOrNull");
        string = UStringsKt.toUIntOrNull(string, n);
        if (string == null) return null;
        n = string.unbox_impl();
        if (UnsignedKt.uintCompare((int)n, (int)UInt.constructor_impl((int)255)) <= 0) return UByte.box_impl((byte)UByte.constructor_impl((byte)((byte)n)));
        return null;
    }

    public static final int toUInt(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUInt");
        UInt uInt = UStringsKt.toUIntOrNull(string);
        if (uInt != null) {
            return uInt.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final int toUInt(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUInt");
        UInt uInt = UStringsKt.toUIntOrNull(string, n);
        if (uInt != null) {
            return uInt.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final UInt toUIntOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUIntOrNull");
        return UStringsKt.toUIntOrNull(string, 10);
    }

    public static final UInt toUIntOrNull(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUIntOrNull");
        CharsKt.checkRadix((int)n);
        int n2 = string.length();
        if (n2 == 0) {
            return null;
        }
        int n3 = 0;
        int n4 = string.charAt(0);
        int n5 = Intrinsics.compare((int)n4, (int)48);
        int n6 = 1;
        if (n5 < 0) {
            if (n2 == 1) return null;
            if (n4 != 43) {
                return null;
            }
        } else {
            n6 = 0;
        }
        int n7 = UInt.constructor_impl((int)n);
        n5 = 0x71C71C7;
        n4 = n6;
        while (n4 < n2) {
            int n8 = CharsKt.digitOf((char)string.charAt(n4), (int)n);
            if (n8 < 0) {
                return null;
            }
            n6 = n5;
            if (UnsignedKt.uintCompare((int)n3, (int)n5) > 0) {
                if (n5 != 0x71C71C7) return null;
                n6 = n5 = UnsignedKt.uintDivide_J1ME1BU((int)-1, (int)n7);
                if (UnsignedKt.uintCompare((int)n3, (int)n5) > 0) {
                    return null;
                }
            }
            n5 = UInt.constructor_impl((int)(n3 * n7));
            n3 = UInt.constructor_impl((int)(UInt.constructor_impl((int)n8) + n5));
            if (UnsignedKt.uintCompare((int)n3, (int)n5) < 0) {
                return null;
            }
            ++n4;
            n5 = n6;
        }
        return UInt.box_impl((int)n3);
    }

    public static final long toULong(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toULong");
        ULong uLong = UStringsKt.toULongOrNull(string);
        if (uLong != null) {
            return uLong.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final long toULong(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toULong");
        ULong uLong = UStringsKt.toULongOrNull(string, n);
        if (uLong != null) {
            return uLong.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final ULong toULongOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toULongOrNull");
        return UStringsKt.toULongOrNull(string, 10);
    }

    public static final ULong toULongOrNull(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toULongOrNull");
        CharsKt.checkRadix((int)n);
        int n2 = string.length();
        if (n2 == 0) {
            return null;
        }
        int n3 = 0;
        int n4 = string.charAt(0);
        if (Intrinsics.compare((int)n4, (int)48) < 0) {
            if (n2 == 1) return null;
            if (n4 != 43) {
                return null;
            }
            n3 = 1;
        }
        long l = ULong.constructor_impl((long)n);
        long l2 = 0L;
        long l3 = 0x71C71C71C71C71CL;
        while (n3 < n2) {
            n4 = CharsKt.digitOf((char)string.charAt(n3), (int)n);
            if (n4 < 0) {
                return null;
            }
            long l4 = l3;
            if (UnsignedKt.ulongCompare((long)l2, (long)l3) > 0) {
                if (l3 != 0x71C71C71C71C71CL) return null;
                l4 = l3 = UnsignedKt.ulongDivide_eb3DHEI((long)-1L, (long)l);
                if (UnsignedKt.ulongCompare((long)l2, (long)l3) > 0) {
                    return null;
                }
            }
            l3 = ULong.constructor_impl((long)(l2 * l));
            l2 = ULong.constructor_impl((long)(ULong.constructor_impl((long)((long)UInt.constructor_impl((int)n4) & 0xFFFFFFFFL)) + l3));
            if (UnsignedKt.ulongCompare((long)l2, (long)l3) < 0) {
                return null;
            }
            ++n3;
            l3 = l4;
        }
        return ULong.box_impl((long)l2);
    }

    public static final short toUShort(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUShort");
        UShort uShort = UStringsKt.toUShortOrNull(string);
        if (uShort != null) {
            return uShort.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final short toUShort(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUShort");
        UShort uShort = UStringsKt.toUShortOrNull(string, n);
        if (uShort != null) {
            return uShort.unbox_impl();
        }
        StringsKt.numberFormatError((String)string);
        throw new KotlinNothingValueException();
    }

    public static final UShort toUShortOrNull(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUShortOrNull");
        return UStringsKt.toUShortOrNull(string, 10);
    }

    public static final UShort toUShortOrNull(String string, int n) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"$this$toUShortOrNull");
        string = UStringsKt.toUIntOrNull(string, n);
        if (string == null) return null;
        n = string.unbox_impl();
        if (UnsignedKt.uintCompare((int)n, (int)UInt.constructor_impl((int)65535)) <= 0) return UShort.box_impl((short)UShort.constructor_impl((short)((short)n)));
        return null;
    }
}
