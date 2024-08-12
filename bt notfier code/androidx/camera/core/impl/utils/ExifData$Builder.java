/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CameraCaptureMetaData$FlashState
 *  androidx.camera.core.impl.utils.ExifAttribute
 *  androidx.camera.core.impl.utils.ExifData
 *  androidx.camera.core.impl.utils.ExifData$1
 *  androidx.camera.core.impl.utils.ExifData$WhiteBalanceMode
 *  androidx.camera.core.impl.utils.ExifTag
 *  androidx.camera.core.impl.utils.LongRational
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils;

import android.util.Pair;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifTag;
import androidx.camera.core.impl.utils.LongRational;
import androidx.core.util.Preconditions;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public static final class ExifData.Builder {
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final Pattern GPS_TIMESTAMP_PATTERN;
    static final List<HashMap<String, ExifTag>> sExifTagMapsForWriting;
    final List<Map<String, ExifAttribute>> mAttributes = Collections.list(new /* Unavailable Anonymous Inner Class!! */);
    private final ByteOrder mByteOrder;

    static {
        GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        sExifTagMapsForWriting = Collections.list(new /* Unavailable Anonymous Inner Class!! */);
    }

    ExifData.Builder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    private static Pair<Integer, Integer> guessDataFormat(String pair) {
        boolean bl = pair.contains(",");
        int n = 1;
        Integer n2 = 2;
        Integer n3 = -1;
        if (bl) {
            Pair pair2;
            String[] stringArray = pair.split(",", -1);
            pair = pair2 = ExifData.Builder.guessDataFormat(stringArray[0]);
            if ((Integer)pair2.first == 2) {
                return pair2;
            }
            while (n < stringArray.length) {
                pair2 = ExifData.Builder.guessDataFormat(stringArray[n]);
                int n4 = !((Integer)pair2.first).equals(pair.first) && !((Integer)pair2.second).equals(pair.first) ? -1 : (Integer)pair.first;
                int n5 = (Integer)pair.second != -1 && (((Integer)pair2.first).equals(pair.second) || ((Integer)pair2.second).equals(pair.second)) ? (Integer)pair.second : -1;
                if (n4 == -1 && n5 == -1) {
                    return new Pair((Object)n2, (Object)n3);
                }
                if (n4 == -1) {
                    pair = new Pair((Object)n5, (Object)n3);
                } else if (n5 == -1) {
                    pair = new Pair((Object)n4, (Object)n3);
                }
                ++n;
            }
            return pair;
        }
        if (pair.contains("/")) {
            if (((String[])(pair = pair.split("/", -1))).length != 2) return new Pair((Object)n2, (Object)n3);
            try {
                long l = (long)Double.parseDouble(pair[0]);
                long l2 = (long)Double.parseDouble((String)pair[1]);
                if (l >= 0L && l2 >= 0L) {
                    if (l > Integer.MAX_VALUE) return new Pair((Object)5, (Object)n3);
                    if (l2 <= Integer.MAX_VALUE) return new Pair((Object)10, (Object)5);
                    return new Pair((Object)5, (Object)n3);
                }
                pair = new Pair((Object)10, (Object)n3);
                return pair;
            }
            catch (NumberFormatException numberFormatException) {}
        } else {
            try {
                long l = Long.parseLong((String)pair);
                if (l >= 0L && l <= 65535L) {
                    return new Pair((Object)3, (Object)4);
                }
                if (l < 0L) {
                    return new Pair((Object)9, (Object)n3);
                }
                Pair pair3 = new Pair((Object)4, (Object)n3);
                return pair3;
            }
            catch (NumberFormatException numberFormatException) {
                try {
                    Double.parseDouble((String)pair);
                    pair = new Pair((Object)12, (Object)n3);
                    return pair;
                }
                catch (NumberFormatException numberFormatException2) {
                    return new Pair((Object)n2, (Object)n3);
                }
            }
        }
        return new Pair((Object)n2, (Object)n3);
    }

    private void setAttributeIfMissing(String string, String string2, List<Map<String, ExifAttribute>> list) {
        Iterator<Map<String, ExifAttribute>> iterator = list.iterator();
        do {
            if (iterator.hasNext()) continue;
            this.setAttributeInternal(string, string2, list);
            return;
        } while (!iterator.next().containsKey(string));
    }

    private void setAttributeInternal(String object, String object2, List<Map<String, ExifAttribute>> list) {
        Object[] objectArray;
        String string;
        Object[] objectArray2;
        block34: {
            block33: {
                objectArray2 = this;
                string = object2;
                if ("DateTime".equals(object) || "DateTimeOriginal".equals(object)) break block33;
                objectArray = string;
                if (!"DateTimeDigitized".equals(object)) break block34;
            }
            objectArray = string;
            if (string != null) {
                boolean bl = DATETIME_PRIMARY_FORMAT_PATTERN.matcher(string).find();
                boolean bl2 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher(string).find();
                if (((String)object2).length() == 19 && (bl || bl2)) {
                    objectArray = string;
                    if (bl2) {
                        objectArray = string.replaceAll("-", ":");
                    }
                } else {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Invalid value for ");
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(" : ");
                    ((StringBuilder)object2).append(string);
                    Logger.w((String)"ExifData", (String)((StringBuilder)object2).toString());
                    return;
                }
            }
        }
        string = object;
        if ("ISOSpeedRatings".equals(object)) {
            string = "PhotographicSensitivity";
        }
        object = objectArray;
        if (objectArray != null) {
            object = objectArray;
            if (ExifData.sTagSetForCompatibility.contains(string)) {
                if (string.equals("GPSTimeStamp")) {
                    object = GPS_TIMESTAMP_PATTERN.matcher((CharSequence)objectArray);
                    if (!((Matcher)object).find()) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Invalid value for ");
                        ((StringBuilder)object).append(string);
                        ((StringBuilder)object).append(" : ");
                        ((StringBuilder)object).append((String)objectArray);
                        Logger.w((String)"ExifData", (String)((StringBuilder)object).toString());
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(Integer.parseInt((String)Preconditions.checkNotNull((Object)((Matcher)object).group(1))));
                    ((StringBuilder)object2).append("/1,");
                    ((StringBuilder)object2).append(Integer.parseInt((String)Preconditions.checkNotNull((Object)((Matcher)object).group(2))));
                    ((StringBuilder)object2).append("/1,");
                    ((StringBuilder)object2).append(Integer.parseInt((String)Preconditions.checkNotNull((Object)((Matcher)object).group(3))));
                    ((StringBuilder)object2).append("/1");
                    object = ((StringBuilder)object2).toString();
                } else {
                    try {
                        double d = Double.parseDouble((String)objectArray);
                        object = new LongRational(d);
                        object = object.toString();
                    }
                    catch (NumberFormatException numberFormatException) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Invalid value for ");
                        ((StringBuilder)object).append(string);
                        ((StringBuilder)object).append(" : ");
                        ((StringBuilder)object).append((String)objectArray);
                        Logger.w((String)"ExifData", (String)((StringBuilder)object).toString(), (Throwable)numberFormatException);
                        return;
                    }
                }
            }
        }
        int n = 0;
        object2 = objectArray2;
        while (n < ExifData.EXIF_TAGS.length) {
            block41: {
                block35: {
                    int n2;
                    block39: {
                        block37: {
                            block40: {
                                block38: {
                                    block36: {
                                        objectArray2 = sExifTagMapsForWriting.get(n).get(string);
                                        objectArray = object2;
                                        if (objectArray2 == null) break block35;
                                        if (object != null) break block36;
                                        list.get(n).remove(string);
                                        objectArray = object2;
                                        break block35;
                                    }
                                    objectArray = ExifData.Builder.guessDataFormat((String)object);
                                    if (objectArray2.primaryFormat == (Integer)objectArray.first || objectArray2.primaryFormat == (Integer)objectArray.second) break block37;
                                    if (objectArray2.secondaryFormat == -1 || objectArray2.secondaryFormat != (Integer)objectArray.first && objectArray2.secondaryFormat != (Integer)objectArray.second) break block38;
                                    n2 = objectArray2.secondaryFormat;
                                    break block39;
                                }
                                if (objectArray2.primaryFormat == 1 || objectArray2.primaryFormat == 7) break block40;
                                objectArray = object2;
                                if (objectArray2.primaryFormat != 2) break block35;
                            }
                            n2 = objectArray2.primaryFormat;
                            break block39;
                        }
                        n2 = objectArray2.primaryFormat;
                    }
                    objectArray = "/";
                    switch (n2) {
                        default: {
                            objectArray = object2;
                            break;
                        }
                        case 12: {
                            objectArray2 = ((String)object).split(",", -1);
                            objectArray = new double[objectArray2.length];
                            for (n2 = 0; n2 < objectArray2.length; ++n2) {
                                objectArray[n2] = Double.parseDouble(objectArray2[n2]);
                            }
                            list.get(n).put(string, ExifAttribute.createDouble((double[])objectArray, (ByteOrder)((ExifData.Builder)object2).mByteOrder));
                            objectArray = object2;
                            break;
                        }
                        case 10: {
                            String[] stringArray = ((String)object).split(",", -1);
                            objectArray2 = new LongRational[stringArray.length];
                            object2 = objectArray;
                            for (n2 = 0; n2 < stringArray.length; ++n2) {
                                objectArray = stringArray[n2].split((String)object2, -1);
                                objectArray2[n2] = new LongRational((long)Double.parseDouble((String)objectArray[0]), (long)Double.parseDouble((String)objectArray[1]));
                            }
                            object2 = list.get(n);
                            objectArray = this;
                            object2.put(string, ExifAttribute.createSRational((LongRational[])objectArray2, (ByteOrder)objectArray.mByteOrder));
                            break;
                        }
                        case 9: {
                            objectArray = ((String)object).split(",", -1);
                            objectArray2 = new int[objectArray.length];
                            for (n2 = 0; n2 < objectArray.length; ++n2) {
                                objectArray2[n2] = (String)Integer.parseInt((String)objectArray[n2]);
                            }
                            list.get(n).put(string, ExifAttribute.createSLong((int[])objectArray2, (ByteOrder)((ExifData.Builder)object2).mByteOrder));
                            objectArray = object2;
                            break;
                        }
                        case 5: {
                            objectArray = "/";
                            String[] stringArray = ((String)object).split(",", -1);
                            objectArray2 = new LongRational[stringArray.length];
                            for (n2 = 0; n2 < stringArray.length; ++n2) {
                                String[] stringArray2 = stringArray[n2].split((String)objectArray, -1);
                                objectArray2[n2] = new LongRational((long)Double.parseDouble(stringArray2[0]), (long)Double.parseDouble(stringArray2[1]));
                            }
                            list.get(n).put(string, ExifAttribute.createURational((LongRational[])objectArray2, (ByteOrder)((ExifData.Builder)object2).mByteOrder));
                            break block41;
                        }
                        case 4: {
                            objectArray2 = ((String)object).split(",", -1);
                            objectArray = new long[objectArray2.length];
                            for (n2 = 0; n2 < objectArray2.length; ++n2) {
                                objectArray[n2] = Long.parseLong(objectArray2[n2]);
                            }
                            list.get(n).put(string, ExifAttribute.createULong((long[])objectArray, (ByteOrder)((ExifData.Builder)object2).mByteOrder));
                            break block41;
                        }
                        case 3: {
                            objectArray = ((String)object).split(",", -1);
                            objectArray2 = new int[objectArray.length];
                            for (n2 = 0; n2 < objectArray.length; ++n2) {
                                objectArray2[n2] = (String)Integer.parseInt((String)objectArray[n2]);
                            }
                            list.get(n).put(string, ExifAttribute.createUShort((int[])objectArray2, (ByteOrder)((ExifData.Builder)object2).mByteOrder));
                            break block41;
                        }
                        case 2: 
                        case 7: {
                            list.get(n).put(string, ExifAttribute.createString((String)object));
                            break block41;
                        }
                        case 1: {
                            list.get(n).put(string, ExifAttribute.createByte((String)object));
                            break block41;
                        }
                    }
                }
                object2 = objectArray;
            }
            ++n;
        }
    }

    public ExifData build() {
        ArrayList<Map<String, ExifAttribute>> arrayList = Collections.list(new /* Unavailable Anonymous Inner Class!! */);
        if (!((Map)arrayList.get(1)).isEmpty()) {
            this.setAttributeIfMissing("ExposureProgram", String.valueOf(0), arrayList);
            this.setAttributeIfMissing("ExifVersion", "0230", arrayList);
            this.setAttributeIfMissing("ComponentsConfiguration", "1,2,3,0", arrayList);
            this.setAttributeIfMissing("MeteringMode", String.valueOf(0), arrayList);
            this.setAttributeIfMissing("LightSource", String.valueOf(0), arrayList);
            this.setAttributeIfMissing("FlashpixVersion", "0100", arrayList);
            this.setAttributeIfMissing("FocalPlaneResolutionUnit", String.valueOf(2), arrayList);
            this.setAttributeIfMissing("FileSource", String.valueOf(3), arrayList);
            this.setAttributeIfMissing("SceneType", String.valueOf(1), arrayList);
            this.setAttributeIfMissing("CustomRendered", String.valueOf(0), arrayList);
            this.setAttributeIfMissing("SceneCaptureType", String.valueOf(0), arrayList);
            this.setAttributeIfMissing("Contrast", String.valueOf(0), arrayList);
            this.setAttributeIfMissing("Saturation", String.valueOf(0), arrayList);
            this.setAttributeIfMissing("Sharpness", String.valueOf(0), arrayList);
        }
        if (((Map)arrayList.get(2)).isEmpty()) return new ExifData(this.mByteOrder, arrayList);
        this.setAttributeIfMissing("GPSVersionID", "2300", arrayList);
        this.setAttributeIfMissing("GPSSpeedRef", "K", arrayList);
        this.setAttributeIfMissing("GPSTrackRef", "T", arrayList);
        this.setAttributeIfMissing("GPSImgDirectionRef", "T", arrayList);
        this.setAttributeIfMissing("GPSDestBearingRef", "T", arrayList);
        this.setAttributeIfMissing("GPSDestDistanceRef", "K", arrayList);
        return new ExifData(this.mByteOrder, arrayList);
    }

    public ExifData.Builder removeAttribute(String string) {
        this.setAttributeInternal(string, null, this.mAttributes);
        return this;
    }

    public ExifData.Builder setAttribute(String string, String string2) {
        this.setAttributeInternal(string, string2, this.mAttributes);
        return this;
    }

    public ExifData.Builder setExposureTimeNanos(long l) {
        double d = l;
        double d2 = TimeUnit.SECONDS.toNanos(1L);
        Double.isNaN(d);
        Double.isNaN(d2);
        return this.setAttribute("ExposureTime", String.valueOf(d / d2));
    }

    public ExifData.Builder setFlashState(CameraCaptureMetaData.FlashState flashState) {
        if (flashState == CameraCaptureMetaData.FlashState.UNKNOWN) {
            return this;
        }
        int n = ExifData.1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[flashState.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown flash state: ");
                    stringBuilder.append(flashState);
                    Logger.w((String)"ExifData", (String)stringBuilder.toString());
                    return this;
                }
                n = 1;
            } else {
                n = 32;
            }
        } else {
            n = 0;
        }
        if ((n & 1) != 1) return this.setAttribute("Flash", String.valueOf(n));
        this.setAttribute("LightSource", String.valueOf(4));
        return this.setAttribute("Flash", String.valueOf(n));
    }

    public ExifData.Builder setFocalLength(float f) {
        return this.setAttribute("FocalLength", new LongRational((long)(f * 1000.0f), 1000L).toString());
    }

    public ExifData.Builder setImageHeight(int n) {
        return this.setAttribute("ImageLength", String.valueOf(n));
    }

    public ExifData.Builder setImageWidth(int n) {
        return this.setAttribute("ImageWidth", String.valueOf(n));
    }

    public ExifData.Builder setIso(int n) {
        return this.setAttribute("SensitivityType", String.valueOf(3)).setAttribute("PhotographicSensitivity", String.valueOf(Math.min(65535, n)));
    }

    public ExifData.Builder setLensFNumber(float f) {
        return this.setAttribute("FNumber", String.valueOf(f));
    }

    public ExifData.Builder setOrientationDegrees(int n) {
        if (n != 0) {
            if (n != 90) {
                if (n != 180) {
                    if (n != 270) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected orientation value: ");
                        stringBuilder.append(n);
                        stringBuilder.append(". Must be one of 0, 90, 180, 270.");
                        Logger.w((String)"ExifData", (String)stringBuilder.toString());
                        n = 0;
                    } else {
                        n = 8;
                    }
                } else {
                    n = 3;
                }
            } else {
                n = 6;
            }
        } else {
            n = 1;
        }
        return this.setAttribute("Orientation", String.valueOf(n));
    }

    public ExifData.Builder setWhiteBalanceMode(ExifData.WhiteBalanceMode object) {
        int n = ExifData.1.$SwitchMap$androidx$camera$core$impl$utils$ExifData$WhiteBalanceMode[object.ordinal()];
        object = n != 1 ? (n != 2 ? null : String.valueOf(1)) : String.valueOf(0);
        return this.setAttribute("WhiteBalance", (String)object);
    }
}
