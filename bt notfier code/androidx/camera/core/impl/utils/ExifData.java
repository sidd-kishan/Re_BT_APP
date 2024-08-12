/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.ExifAttribute
 *  androidx.camera.core.impl.utils.ExifData$Builder
 *  androidx.camera.core.impl.utils.ExifTag
 *  androidx.camera.core.impl.utils.LongRational
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl.utils;

import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.impl.utils.ExifTag;
import androidx.camera.core.impl.utils.LongRational;
import androidx.core.util.Preconditions;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ExifData {
    private static final boolean DEBUG = false;
    static final ExifTag[] EXIF_POINTER_TAGS;
    static final ExifTag[][] EXIF_TAGS;
    private static final ExifTag[] IFD_EXIF_TAGS;
    static final String[] IFD_FORMAT_NAMES;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    static final int IFD_TYPE_EXIF = 1;
    static final int IFD_TYPE_GPS = 2;
    static final int IFD_TYPE_INTEROPERABILITY = 3;
    static final int IFD_TYPE_PRIMARY = 0;
    private static final int MM_IN_MICRONS = 1000;
    private static final String TAG = "ExifData";
    static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    static final HashSet<String> sTagSetForCompatibility;
    private final List<Map<String, ExifAttribute>> mAttributes;
    private final ByteOrder mByteOrder;

    static {
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_TIFF_TAGS = new ExifTag[]{new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("Orientation", 274, 3), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_EXIF_TAGS = new ExifTag[]{new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("SensitivityType", 34864, 3), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3)};
        IFD_GPS_TAGS = new ExifTag[]{new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestDistanceRef", 25, 2)};
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(TAG_SUB_IFD_POINTER, 330, 4), new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4), new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4), new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4)};
        ExifTag[] exifTagArray = new ExifTag[]{new ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArray;
        EXIF_TAGS = new ExifTag[][]{IFD_TIFF_TAGS, IFD_EXIF_TAGS, IFD_GPS_TAGS, exifTagArray};
        sTagSetForCompatibility = new HashSet<String>(Arrays.asList("FNumber", "ExposureTime", "GPSTimeStamp"));
    }

    ExifData(ByteOrder byteOrder, List<Map<String, ExifAttribute>> list) {
        boolean bl = list.size() == EXIF_TAGS.length;
        Preconditions.checkState((boolean)bl, (String)"Malformed attributes list. Number of IFDs mismatch.");
        this.mByteOrder = byteOrder;
        this.mAttributes = list;
    }

    public static Builder builderForDevice() {
        return new Builder(ByteOrder.BIG_ENDIAN).setAttribute("Orientation", String.valueOf(1)).setAttribute("XResolution", "72/1").setAttribute("YResolution", "72/1").setAttribute("ResolutionUnit", String.valueOf(2)).setAttribute("YCbCrPositioning", String.valueOf(1)).setAttribute("Make", Build.MANUFACTURER).setAttribute("Model", Build.MODEL);
    }

    private ExifAttribute getExifAttribute(String string) {
        String string2 = string;
        if ("ISOSpeedRatings".equals(string)) {
            string2 = "PhotographicSensitivity";
        }
        int n = 0;
        while (n < EXIF_TAGS.length) {
            string = this.mAttributes.get(n).get(string2);
            if (string != null) {
                return string;
            }
            ++n;
        }
        return null;
    }

    public String getAttribute(String object) {
        Object object2 = this.getExifAttribute((String)object);
        if (object2 == null) return null;
        if (!sTagSetForCompatibility.contains(object)) {
            return object2.getStringValue(this.mByteOrder);
        }
        if (((String)object).equals("GPSTimeStamp")) {
            if (((ExifAttribute)object2).format != 5 && ((ExifAttribute)object2).format != 10) {
                object = new StringBuilder();
                ((StringBuilder)object).append("GPS Timestamp format is not rational. format=");
                ((StringBuilder)object).append(((ExifAttribute)object2).format);
                Logger.w((String)TAG, (String)((StringBuilder)object).toString());
                return null;
            }
            object = (LongRational[])object2.getValue(this.mByteOrder);
            if (object != null && ((LongRational[])object).length == 3) {
                return String.format(Locale.US, "%02d:%02d:%02d", (int)((float)object[0].getNumerator() / (float)object[0].getDenominator()), (int)((float)object[1].getNumerator() / (float)object[1].getDenominator()), (int)((float)object[2].getNumerator() / (float)object[2].getDenominator()));
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Invalid GPS Timestamp array. array=");
            ((StringBuilder)object2).append(Arrays.toString((Object[])object));
            Logger.w((String)TAG, (String)((StringBuilder)object2).toString());
            return null;
        }
        try {
            object = Double.toString(object2.getDoubleValue(this.mByteOrder));
            return object;
        }
        catch (NumberFormatException numberFormatException) {
        }
        return null;
    }

    Map<String, ExifAttribute> getAttributes(int n) {
        int n2 = EXIF_TAGS.length;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid IFD index: ");
        stringBuilder.append(n);
        stringBuilder.append(". Index should be between [0, EXIF_TAGS.length] ");
        Preconditions.checkArgumentInRange((int)n, (int)0, (int)n2, (String)stringBuilder.toString());
        return this.mAttributes.get(n);
    }

    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }
}
