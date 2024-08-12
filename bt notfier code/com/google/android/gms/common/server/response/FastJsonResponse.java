/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.server.response.FastJsonResponse$Field
 *  com.google.android.gms.common.util.Base64Utils
 *  com.google.android.gms.common.util.JsonUtils
 *  com.google.android.gms.common.util.MapUtils
 */
package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class FastJsonResponse {
    protected static final <O, I> I zaD(Field<I, O> field, Object object) {
        if (Field.zaj(field) == null) return (I)object;
        return (I)field.zai(object);
    }

    private final <I, O> void zaE(Field<I, O> object, I object2) {
        String string = ((Field)object).zae;
        object2 = object.zah(object2);
        int n = ((Field)object).zac;
        switch (n) {
            default: {
                object = new StringBuilder(44);
                ((StringBuilder)object).append("Unsupported type for conversion: ");
                ((StringBuilder)object).append(n);
                throw new IllegalStateException(((StringBuilder)object).toString());
            }
            case 8: 
            case 9: {
                if (object2 != null) {
                    this.setDecodedBytesInternal((Field<?, ?>)object, string, (byte[])object2);
                    return;
                }
                FastJsonResponse.zaG(string);
                return;
            }
            case 7: {
                this.setStringInternal((Field<?, ?>)object, string, (String)object2);
                return;
            }
            case 6: {
                if (object2 != null) {
                    this.setBooleanInternal((Field<?, ?>)object, string, (Boolean)object2);
                    return;
                }
                FastJsonResponse.zaG(string);
                return;
            }
            case 5: {
                this.zaA((Field<?, ?>)object, string, (BigDecimal)object2);
                return;
            }
            case 4: {
                if (object2 != null) {
                    this.zay((Field<?, ?>)object, string, (Double)object2);
                    return;
                }
                FastJsonResponse.zaG(string);
                return;
            }
            case 2: {
                if (object2 != null) {
                    this.setLongInternal((Field<?, ?>)object, string, (Long)object2);
                    return;
                }
                FastJsonResponse.zaG(string);
                return;
            }
            case 1: {
                this.zat((Field<?, ?>)object, string, (BigInteger)object2);
                return;
            }
            case 0: 
        }
        if (object2 != null) {
            this.setIntegerInternal((Field<?, ?>)object, string, (Integer)object2);
            return;
        }
        FastJsonResponse.zaG(string);
    }

    private static final void zaF(StringBuilder stringBuilder, Field object, Object object2) {
        int n = ((Field)object).zaa;
        if (n == 11) {
            object = ((Field)object).zag;
            Preconditions.checkNotNull((Object)object);
            stringBuilder.append(((FastJsonResponse)((Class)object).cast(object2)).toString());
            return;
        }
        if (n == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(JsonUtils.escapeString((String)((String)object2)));
            stringBuilder.append("\"");
            return;
        }
        stringBuilder.append(object2);
    }

    private static final <O> void zaG(String string) {
        if (!Log.isLoggable((String)"FastJsonResponse", (int)6)) return;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 58);
        stringBuilder.append("Output field (");
        stringBuilder.append(string);
        stringBuilder.append(") has a null value, but expected a primitive");
        Log.e((String)"FastJsonResponse", (String)stringBuilder.toString());
    }

    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field field, String string, ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    public <T extends FastJsonResponse> void addConcreteTypeInternal(Field field, String string, T t) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    public abstract Map<String, Field<?, ?>> getFieldMappings();

    protected Object getFieldValue(Field object) {
        String string = ((Field)object).zae;
        if (((Field)object).zag == null) return this.getValueObject(string);
        boolean bl = this.getValueObject(string) == null;
        Preconditions.checkState((boolean)bl, (String)"Concrete field shouldn't be value object: %s", (Object[])new Object[]{((Field)object).zae});
        bl = ((Field)object).zad;
        try {
            char c = Character.toUpperCase(string.charAt(0));
            string = string.substring(1);
            int n = String.valueOf(string).length();
            object = new StringBuilder(n + 4);
            ((StringBuilder)object).append("get");
            ((StringBuilder)object).append(c);
            ((StringBuilder)object).append(string);
            object = this.getClass().getMethod(((StringBuilder)object).toString(), new Class[0]).invoke(this, new Object[0]);
            return object;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    protected abstract Object getValueObject(String var1);

    protected boolean isFieldSet(Field object) {
        if (object.zac != 11) return this.isPrimitiveFieldSet(object.zae);
        if (object.zad) {
            object = object.zae;
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        object = object.zae;
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected abstract boolean isPrimitiveFieldSet(String var1);

    protected void setBooleanInternal(Field<?, ?> field, String string, boolean bl) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    protected void setDecodedBytesInternal(Field<?, ?> field, String string, byte[] byArray) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    protected void setIntegerInternal(Field<?, ?> field, String string, int n) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    protected void setLongInternal(Field<?, ?> field, String string, long l) {
        throw new UnsupportedOperationException("Long not supported");
    }

    protected void setStringInternal(Field<?, ?> field, String string, String string2) {
        throw new UnsupportedOperationException("String not supported");
    }

    protected void setStringMapInternal(Field<?, ?> field, String string, Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    protected void setStringsInternal(Field<?, ?> field, String string, ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    public String toString() {
        Map<String, Field<?, ?>> map = this.getFieldMappings();
        StringBuilder stringBuilder = new StringBuilder(100);
        block5: for (String string : map.keySet()) {
            Object object2;
            Field<?, ?> field;
            block14: {
                int n;
                ArrayList arrayList;
                field = map.get(string);
                if (!this.isFieldSet(field)) continue;
                object2 = FastJsonResponse.zaD(field, this.getFieldValue(field));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"");
                stringBuilder.append(string);
                stringBuilder.append("\":");
                if (object2 == null) {
                    stringBuilder.append("null");
                    continue;
                }
                switch (field.zac) {
                    default: {
                        if (field.zab) {
                            arrayList = (ArrayList)object2;
                            stringBuilder.append("[");
                            n = arrayList.size();
                            break;
                        }
                        break block14;
                    }
                    case 10: {
                        MapUtils.writeStringMapToJson((StringBuilder)stringBuilder, (HashMap)((HashMap)object2));
                        continue block5;
                    }
                    case 9: {
                        stringBuilder.append("\"");
                        stringBuilder.append(Base64Utils.encodeUrlSafe((byte[])((byte[])object2)));
                        stringBuilder.append("\"");
                        continue block5;
                    }
                    case 8: {
                        stringBuilder.append("\"");
                        stringBuilder.append(Base64Utils.encode((byte[])((byte[])object2)));
                        stringBuilder.append("\"");
                        continue block5;
                    }
                }
                for (int i = 0; i < n; ++i) {
                    if (i > 0) {
                        stringBuilder.append(",");
                    }
                    if ((object2 = arrayList.get(i)) == null) continue;
                    FastJsonResponse.zaF(stringBuilder, field, object2);
                }
                stringBuilder.append("]");
                continue;
            }
            FastJsonResponse.zaF(stringBuilder, field, object2);
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }

    protected void zaA(Field<?, ?> field, String string, BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    protected void zaB(Field<?, ?> field, String string, ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    protected void zaC(Field<?, ?> field, String string, ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final <O> void zaa(Field<Integer, O> field, int n) {
        if (Field.zaj(field) != null) {
            this.zaE(field, n);
            return;
        }
        this.setIntegerInternal(field, field.zae, n);
    }

    public final <O> void zab(Field<ArrayList<Integer>, O> field, ArrayList<Integer> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.zas(field, field.zae, arrayList);
    }

    public final <O> void zac(Field<BigInteger, O> field, BigInteger bigInteger) {
        if (Field.zaj(field) != null) {
            this.zaE(field, bigInteger);
            return;
        }
        this.zat(field, field.zae, bigInteger);
    }

    public final <O> void zad(Field<ArrayList<BigInteger>, O> field, ArrayList<BigInteger> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.zau(field, field.zae, arrayList);
    }

    public final <O> void zae(Field<Long, O> field, long l) {
        if (Field.zaj(field) != null) {
            this.zaE(field, l);
            return;
        }
        this.setLongInternal(field, field.zae, l);
    }

    public final <O> void zaf(Field<ArrayList<Long>, O> field, ArrayList<Long> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.zav(field, field.zae, arrayList);
    }

    public final <O> void zag(Field<Float, O> field, float f) {
        if (Field.zaj(field) != null) {
            this.zaE(field, Float.valueOf(f));
            return;
        }
        this.zaw(field, field.zae, f);
    }

    public final <O> void zah(Field<ArrayList<Float>, O> field, ArrayList<Float> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.zax(field, field.zae, arrayList);
    }

    public final <O> void zai(Field<Double, O> field, double d) {
        if (Field.zaj(field) != null) {
            this.zaE(field, d);
            return;
        }
        this.zay(field, field.zae, d);
    }

    public final <O> void zaj(Field<ArrayList<Double>, O> field, ArrayList<Double> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.zaz(field, field.zae, arrayList);
    }

    public final <O> void zak(Field<BigDecimal, O> field, BigDecimal bigDecimal) {
        if (Field.zaj(field) != null) {
            this.zaE(field, bigDecimal);
            return;
        }
        this.zaA(field, field.zae, bigDecimal);
    }

    public final <O> void zal(Field<ArrayList<BigDecimal>, O> field, ArrayList<BigDecimal> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.zaB(field, field.zae, arrayList);
    }

    public final <O> void zam(Field<Boolean, O> field, boolean bl) {
        if (Field.zaj(field) != null) {
            this.zaE(field, bl);
            return;
        }
        this.setBooleanInternal(field, field.zae, bl);
    }

    public final <O> void zan(Field<ArrayList<Boolean>, O> field, ArrayList<Boolean> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.zaC(field, field.zae, arrayList);
    }

    public final <O> void zao(Field<String, O> field, String string) {
        if (Field.zaj(field) != null) {
            this.zaE(field, string);
            return;
        }
        this.setStringInternal(field, field.zae, string);
    }

    public final <O> void zap(Field<ArrayList<String>, O> field, ArrayList<String> arrayList) {
        if (Field.zaj(field) != null) {
            this.zaE(field, arrayList);
            return;
        }
        this.setStringsInternal(field, field.zae, arrayList);
    }

    public final <O> void zaq(Field<byte[], O> field, byte[] byArray) {
        if (Field.zaj(field) != null) {
            this.zaE(field, byArray);
            return;
        }
        this.setDecodedBytesInternal(field, field.zae, byArray);
    }

    public final <O> void zar(Field<Map<String, String>, O> field, Map<String, String> map) {
        if (Field.zaj(field) != null) {
            this.zaE(field, map);
            return;
        }
        this.setStringMapInternal(field, field.zae, map);
    }

    protected void zas(Field<?, ?> field, String string, ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    protected void zat(Field<?, ?> field, String string, BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    protected void zau(Field<?, ?> field, String string, ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    protected void zav(Field<?, ?> field, String string, ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    protected void zaw(Field<?, ?> field, String string, float f) {
        throw new UnsupportedOperationException("Float not supported");
    }

    protected void zax(Field<?, ?> field, String string, ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    protected void zay(Field<?, ?> field, String string, double d) {
        throw new UnsupportedOperationException("Double not supported");
    }

    protected void zaz(Field<?, ?> field, String string, ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }
}
