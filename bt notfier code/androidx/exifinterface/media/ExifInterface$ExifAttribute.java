/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.exifinterface.media.ExifInterface
 *  androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
 *  androidx.exifinterface.media.ExifInterface$Rational
 */
package androidx.exifinterface.media;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

private static class ExifInterface.ExifAttribute {
    public static final long BYTES_OFFSET_UNKNOWN = -1L;
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    ExifInterface.ExifAttribute(int n, int n2, long l, byte[] byArray) {
        this.format = n;
        this.numberOfComponents = n2;
        this.bytesOffset = l;
        this.bytes = byArray;
    }

    ExifInterface.ExifAttribute(int n, int n2, byte[] byArray) {
        this(n, n2, -1L, byArray);
    }

    public static ExifInterface.ExifAttribute createByte(String object) {
        if (((String)object).length() == 1 && ((String)object).charAt(0) >= '0' && ((String)object).charAt(0) <= '1') {
            return new ExifInterface.ExifAttribute(1, 1, new byte[]{(byte)(((String)object).charAt(0) - 48)});
        }
        object = ((String)object).getBytes(ExifInterface.ASCII);
        return new ExifInterface.ExifAttribute(1, ((Object)object).length, (byte[])object);
    }

    public static ExifInterface.ExifAttribute createDouble(double d, ByteOrder byteOrder) {
        return ExifInterface.ExifAttribute.createDouble(new double[]{d}, byteOrder);
    }

    public static ExifInterface.ExifAttribute createDouble(double[] dArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArray.length]);
        byteBuffer.order(byteOrder);
        int n = dArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putDouble(dArray[n2]);
            ++n2;
        }
        return new ExifInterface.ExifAttribute(12, dArray.length, byteBuffer.array());
    }

    public static ExifInterface.ExifAttribute createSLong(int n, ByteOrder byteOrder) {
        return ExifInterface.ExifAttribute.createSLong(new int[]{n}, byteOrder);
    }

    public static ExifInterface.ExifAttribute createSLong(int[] nArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * nArray.length]);
        byteBuffer.order(byteOrder);
        int n = nArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putInt(nArray[n2]);
            ++n2;
        }
        return new ExifInterface.ExifAttribute(9, nArray.length, byteBuffer.array());
    }

    public static ExifInterface.ExifAttribute createSRational(ExifInterface.Rational rational, ByteOrder byteOrder) {
        return ExifInterface.ExifAttribute.createSRational(new ExifInterface.Rational[]{rational}, byteOrder);
    }

    public static ExifInterface.ExifAttribute createSRational(ExifInterface.Rational[] rationalArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArray.length]);
        byteBuffer.order(byteOrder);
        int n = rationalArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteOrder = rationalArray[n2];
            byteBuffer.putInt((int)((ExifInterface.Rational)byteOrder).numerator);
            byteBuffer.putInt((int)((ExifInterface.Rational)byteOrder).denominator);
            ++n2;
        }
        return new ExifInterface.ExifAttribute(10, rationalArray.length, byteBuffer.array());
    }

    public static ExifInterface.ExifAttribute createString(String object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append('\u0000');
        object = stringBuilder.toString().getBytes(ExifInterface.ASCII);
        return new ExifInterface.ExifAttribute(2, ((Object)object).length, (byte[])object);
    }

    public static ExifInterface.ExifAttribute createULong(long l, ByteOrder byteOrder) {
        return ExifInterface.ExifAttribute.createULong(new long[]{l}, byteOrder);
    }

    public static ExifInterface.ExifAttribute createULong(long[] lArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * lArray.length]);
        byteBuffer.order(byteOrder);
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putInt((int)lArray[n2]);
            ++n2;
        }
        return new ExifInterface.ExifAttribute(4, lArray.length, byteBuffer.array());
    }

    public static ExifInterface.ExifAttribute createURational(ExifInterface.Rational rational, ByteOrder byteOrder) {
        return ExifInterface.ExifAttribute.createURational(new ExifInterface.Rational[]{rational}, byteOrder);
    }

    public static ExifInterface.ExifAttribute createURational(ExifInterface.Rational[] rationalArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArray.length]);
        byteBuffer.order(byteOrder);
        int n = rationalArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteOrder = rationalArray[n2];
            byteBuffer.putInt((int)((ExifInterface.Rational)byteOrder).numerator);
            byteBuffer.putInt((int)((ExifInterface.Rational)byteOrder).denominator);
            ++n2;
        }
        return new ExifInterface.ExifAttribute(5, rationalArray.length, byteBuffer.array());
    }

    public static ExifInterface.ExifAttribute createUShort(int n, ByteOrder byteOrder) {
        return ExifInterface.ExifAttribute.createUShort(new int[]{n}, byteOrder);
    }

    public static ExifInterface.ExifAttribute createUShort(int[] nArray, ByteOrder byteOrder) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * nArray.length]);
        byteBuffer.order(byteOrder);
        int n = nArray.length;
        int n2 = 0;
        while (n2 < n) {
            byteBuffer.putShort((short)nArray[n2]);
            ++n2;
        }
        return new ExifInterface.ExifAttribute(3, nArray.length, byteBuffer.array());
    }

    public double getDoubleValue(ByteOrder rationalArray) {
        if ((rationalArray = this.getValue((ByteOrder)rationalArray)) == null) throw new NumberFormatException("NULL can't be converted to a double value");
        if (rationalArray instanceof String) {
            return Double.parseDouble((String)rationalArray);
        }
        if (rationalArray instanceof long[]) {
            if ((rationalArray = (ExifInterface.Rational[])((long[])rationalArray)).length != 1) throw new NumberFormatException("There are more than one component");
            return (double)rationalArray[0];
        }
        if (rationalArray instanceof int[]) {
            if ((rationalArray = (ExifInterface.Rational[])((int[])rationalArray)).length != 1) throw new NumberFormatException("There are more than one component");
            return (double)rationalArray[0];
        }
        if (rationalArray instanceof double[]) {
            if ((rationalArray = (ExifInterface.Rational[])((double[])rationalArray)).length != 1) throw new NumberFormatException("There are more than one component");
            return (double)rationalArray[0];
        }
        if (!(rationalArray instanceof ExifInterface.Rational[])) throw new NumberFormatException("Couldn't find a double value");
        if ((rationalArray = (ExifInterface.Rational[])rationalArray).length != 1) throw new NumberFormatException("There are more than one component");
        return rationalArray[0].calculate();
    }

    public int getIntValue(ByteOrder object) {
        if ((object = this.getValue((ByteOrder)object)) == null) throw new NumberFormatException("NULL can't be converted to a integer value");
        if (object instanceof String) {
            return Integer.parseInt((String)object);
        }
        if (object instanceof long[]) {
            if (((Object)(object = (Object)((long[])object))).length != 1) throw new NumberFormatException("There are more than one component");
            return (int)object[0];
        }
        if (!(object instanceof int[])) throw new NumberFormatException("Couldn't find a integer value");
        if (((Object)(object = (Object)((int[])object))).length != 1) throw new NumberFormatException("There are more than one component");
        return (int)object[0];
    }

    public String getStringValue(ByteOrder object) {
        Object object2 = this.getValue((ByteOrder)object);
        if (object2 == null) {
            return null;
        }
        if (object2 instanceof String) {
            return (String)object2;
        }
        object = new StringBuilder();
        boolean bl = object2 instanceof long[];
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        if (bl) {
            object2 = (long[])object2;
            n = n4;
            while (n < ((Object)object2).length) {
                ((StringBuilder)object).append((long)object2[n]);
                n = n3 = n + 1;
                if (n3 == ((ExifInterface.Rational[])object2).length) continue;
                ((StringBuilder)object).append(",");
                n = n3;
            }
            return ((StringBuilder)object).toString();
        }
        if (object2 instanceof int[]) {
            object2 = (int[])object2;
            while (n < ((Object)object2).length) {
                ((StringBuilder)object).append((int)object2[n]);
                n = n3 = n + 1;
                if (n3 == ((ExifInterface.Rational[])object2).length) continue;
                ((StringBuilder)object).append(",");
                n = n3;
            }
            return ((StringBuilder)object).toString();
        }
        if (object2 instanceof double[]) {
            object2 = (double[])object2;
            n = n2;
            while (n < ((ExifInterface.Rational[])object2).length) {
                ((StringBuilder)object).append((double)object2[n]);
                n = n3 = n + 1;
                if (n3 == ((ExifInterface.Rational[])object2).length) continue;
                ((StringBuilder)object).append(",");
                n = n3;
            }
            return ((StringBuilder)object).toString();
        }
        if (!(object2 instanceof ExifInterface.Rational[])) return null;
        object2 = object2;
        n = n3;
        while (n < ((ExifInterface.Rational[])object2).length) {
            ((StringBuilder)object).append(object2[n].numerator);
            ((StringBuilder)object).append('/');
            ((StringBuilder)object).append(object2[n].denominator);
            n = n3 = n + 1;
            if (n3 == ((ExifInterface.Rational[])object2).length) continue;
            ((StringBuilder)object).append(",");
            n = n3;
        }
        return ((StringBuilder)object).toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    Object getValue(ByteOrder var1_1) {
        block73: {
            block74: {
                block75: {
                    var13_7 = null;
                    var14_21 /* !! */  = new ExifInterface.ByteOrderedDataInputStream(this.bytes);
                    var13_7 = var14_21 /* !! */ ;
                    ** try [egrp 1[TRYBLOCK] [2, 3 : 21->37)] { 
lbl6:
                    // 1 sources

                    break block75;
lbl7:
                    // 1 sources

                    catch (Throwable var1_5) {
                        // empty catch block
                        break block73;
                    }
                    catch (Throwable var1_3) {
                        break block73;
                    }
                    catch (IOException var14_22) {
                        var1_1 = null;
                        break block74;
                    }
                }
                var14_21 /* !! */ .setByteOrder((ByteOrder)var1_1);
                var13_7 = var14_21 /* !! */ ;
                var12_23 = this.format;
                var5_24 = 1;
                var10_25 = 0;
                var7_26 = 0;
                var3_27 = 0;
                var9_28 = 0;
                var11_29 = 0;
                var8_30 = 0;
                var6_31 = 0;
                var4_32 = 0;
                var2_33 = 0;
                switch (var12_23) {
                    default: {
                        break;
                    }
                    case 12: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new double[this.numberOfComponents];
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = (ExifInterface.Rational)var14_21 /* !! */ .readDouble();
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_8) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_8);
                        }
                        return var1_1;
                    }
                    case 11: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new double[this.numberOfComponents];
                        var2_33 = var10_25;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = (ExifInterface.Rational)((double)var14_21 /* !! */ .readFloat());
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_9) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_9);
                        }
                        return var1_1;
                    }
                    case 10: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new ExifInterface.Rational[this.numberOfComponents];
                        var2_33 = var7_26;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = new ExifInterface.Rational((long)var14_21 /* !! */ .readInt(), (long)var14_21 /* !! */ .readInt());
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_10) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_10);
                        }
                        return var1_1;
                    }
                    case 9: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new int[this.numberOfComponents];
                        var2_33 = var3_27;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = (ExifInterface.Rational)var14_21 /* !! */ .readInt();
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_11) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_11);
                        }
                        return var1_1;
                    }
                    case 8: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new int[this.numberOfComponents];
                        var2_33 = var9_28;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = (ExifInterface.Rational)var14_21 /* !! */ .readShort();
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_12) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_12);
                        }
                        return var1_1;
                    }
                    case 5: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new ExifInterface.Rational[this.numberOfComponents];
                        var2_33 = var11_29;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = new ExifInterface.Rational(var14_21 /* !! */ .readUnsignedInt(), var14_21 /* !! */ .readUnsignedInt());
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_13) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_13);
                        }
                        return var1_1;
                    }
                    case 4: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new long[this.numberOfComponents];
                        var2_33 = var8_30;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = (ExifInterface.Rational)var14_21 /* !! */ .readUnsignedInt();
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_14) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_14);
                        }
                        return var1_1;
                    }
                    case 3: {
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new int[this.numberOfComponents];
                        var2_33 = var6_31;
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var1_1[var2_33] = (ExifInterface.Rational)var14_21 /* !! */ .readUnsignedShort();
                            ++var2_33;
                        }
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_15) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_15);
                        }
                        return var1_1;
                    }
                    case 2: 
                    case 7: {
                        var2_33 = var4_32;
                        var13_7 = var14_21 /* !! */ ;
                        if (this.numberOfComponents < ExifInterface.EXIF_ASCII_PREFIX.length) ** GOTO lbl204
                        var2_33 = 0;
                        while (true) {
                            var3_27 = var5_24;
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= ExifInterface.EXIF_ASCII_PREFIX.length) break;
                            var13_7 = var14_21 /* !! */ ;
                            if (this.bytes[var2_33] != ExifInterface.EXIF_ASCII_PREFIX[var2_33]) {
                                var3_27 = 0;
                                break;
                            }
                            ++var2_33;
                        }
                        var2_33 = var4_32;
                        if (var3_27 == 0) ** GOTO lbl204
                        var13_7 = var14_21 /* !! */ ;
                        var2_33 = ExifInterface.EXIF_ASCII_PREFIX.length;
lbl204:
                        // 3 sources

                        var13_7 = var14_21 /* !! */ ;
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new StringBuilder();
                        while (true) {
                            var13_7 = var14_21 /* !! */ ;
                            if (var2_33 >= this.numberOfComponents) break;
                            var13_7 = var14_21 /* !! */ ;
                            var3_27 = this.bytes[var2_33];
                            if (var3_27 == 0) break;
                            if (var3_27 >= 32) {
                                var13_7 = var14_21 /* !! */ ;
                                var1_1.append((char)var3_27);
                            } else {
                                var13_7 = var14_21 /* !! */ ;
                                var1_1.append('?');
                            }
                            ++var2_33;
                        }
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = var1_1.toString();
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_16) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_16);
                        }
                        return var1_1;
                    }
                    case 1: 
                    case 6: {
                        var13_7 = var14_21 /* !! */ ;
                        if (this.bytes.length != 1) ** GOTO lbl250
                        var13_7 = var14_21 /* !! */ ;
                        if (this.bytes[0] < 0) ** GOTO lbl250
                        var13_7 = var14_21 /* !! */ ;
                        if (this.bytes[0] > 1) ** GOTO lbl250
                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new String(new char[]{(char)(this.bytes[0] + 48)});
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_17) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_17);
                        }
                        return var1_1;
lbl250:
                        // 3 sources

                        var13_7 = var14_21 /* !! */ ;
                        var1_1 = new String(this.bytes, ExifInterface.ASCII);
                        try {
                            var14_21 /* !! */ .close();
                        }
                        catch (IOException var13_18) {
                            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_18);
                        }
                        return var1_1;
                    }
                }
                try {
                    var14_21 /* !! */ .close();
                }
                catch (IOException var1_2) {
                    Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var1_2);
                }
                return null;
lbl267:
                // 14 sources

                catch (IOException var13_19) {
                    var1_1 = var14_21 /* !! */ ;
                    var14_21 /* !! */  = var13_19;
                }
            }
            var13_7 = var1_1;
            {
                Log.w((String)"ExifInterface", (String)"IOException occurred during reading a value", (Throwable)var14_21 /* !! */ );
                if (var1_1 == null) return null;
            }
            try {
                var1_1.close();
            }
            catch (IOException var1_4) {
                Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var1_4);
            }
            return null;
        }
        if (var13_7 == null) throw var1_6;
        try {
            var13_7.close();
        }
        catch (IOException var13_20) {
            Log.e((String)"ExifInterface", (String)"IOException occurred while closing InputStream", (Throwable)var13_20);
        }
        throw var1_6;
    }

    public int size() {
        return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
        stringBuilder.append(", data length:");
        stringBuilder.append(this.bytes.length);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
