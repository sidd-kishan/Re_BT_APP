/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.Exif$Speed
 *  androidx.exifinterface.media.ExifInterface
 */
package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Exif;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * Exception performing whole class analysis ignored.
 */
public final class Exif {
    private static final ThreadLocal<SimpleDateFormat> DATETIME_FORMAT;
    private static final ThreadLocal<SimpleDateFormat> DATE_FORMAT;
    public static final long INVALID_TIMESTAMP = -1L;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG;
    private static final ThreadLocal<SimpleDateFormat> TIME_FORMAT;
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp = false;

    static {
        TAG = Exif.class.getSimpleName();
        DATE_FORMAT = new /* Unavailable Anonymous Inner Class!! */;
        TIME_FORMAT = new /* Unavailable Anonymous Inner Class!! */;
        DATETIME_FORMAT = new /* Unavailable Anonymous Inner Class!! */;
    }

    private Exif(ExifInterface exifInterface) {
        this.mExifInterface = exifInterface;
    }

    /*
     * Enabled force condition propagation
     */
    private void attachLastModifiedTimestamp() {
        long l = System.currentTimeMillis();
        String string = Exif.convertToExifDateTime(l);
        this.mExifInterface.setAttribute("DateTime", string);
        try {
            string = Long.toString(l - Exif.convertFromExifDateTime(string).getTime());
            this.mExifInterface.setAttribute("SubSecTime", string);
            return;
        }
        catch (ParseException parseException) {
            return;
        }
    }

    private static Date convertFromExifDate(String string) throws ParseException {
        return DATE_FORMAT.get().parse(string);
    }

    private static Date convertFromExifDateTime(String string) throws ParseException {
        return DATETIME_FORMAT.get().parse(string);
    }

    private static Date convertFromExifTime(String string) throws ParseException {
        return TIME_FORMAT.get().parse(string);
    }

    private static String convertToExifDateTime(long l) {
        return DATETIME_FORMAT.get().format(new Date(l));
    }

    public static Exif createFromFile(File file) throws IOException {
        return Exif.createFromFileString(file.toString());
    }

    public static Exif createFromFileString(String string) throws IOException {
        return new Exif(new ExifInterface(string));
    }

    public static Exif createFromInputStream(InputStream inputStream) throws IOException {
        return new Exif(new ExifInterface(inputStream));
    }

    /*
     * Enabled force condition propagation
     */
    private long parseTimestamp(String string) {
        long l = -1L;
        if (string == null) {
            return -1L;
        }
        try {
            return Exif.convertFromExifDateTime(string).getTime();
        }
        catch (ParseException parseException) {
            return l;
        }
    }

    private long parseTimestamp(String string, String string2) {
        if (string == null && string2 == null) {
            return -1L;
        }
        if (string2 == null) {
            try {
                long l = Exif.convertFromExifDate(string).getTime();
                return l;
            }
            catch (ParseException parseException) {
                return -1L;
            }
        }
        if (string != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" ");
            stringBuilder.append(string2);
            return this.parseTimestamp(stringBuilder.toString());
        }
        try {
            long l = Exif.convertFromExifTime(string2).getTime();
            return l;
        }
        catch (ParseException parseException) {
            return -1L;
        }
    }

    public void attachLocation(Location location) {
        this.mExifInterface.setGpsInfo(location);
    }

    /*
     * Unable to fully structure code
     */
    public void attachTimestamp() {
        var1_1 = System.currentTimeMillis();
        var3_2 = Exif.convertToExifDateTime(var1_1);
        this.mExifInterface.setAttribute("DateTimeOriginal", var3_2);
        this.mExifInterface.setAttribute("DateTimeDigitized", var3_2);
        try {
            var3_2 = Long.toString(var1_1 - Exif.convertFromExifDateTime(var3_2).getTime());
            this.mExifInterface.setAttribute("SubSecTimeOriginal", var3_2);
            this.mExifInterface.setAttribute("SubSecTimeDigitized", var3_2);
lbl9:
            // 2 sources

            while (true) {
                this.mRemoveTimestamp = false;
                return;
            }
        }
        catch (ParseException var3_3) {
            ** continue;
        }
    }

    public void flipHorizontally() {
        int n;
        switch (this.getOrientation()) {
            default: {
                n = 2;
                break;
            }
            case 8: {
                n = 7;
                break;
            }
            case 7: {
                n = 8;
                break;
            }
            case 6: {
                n = 5;
                break;
            }
            case 5: {
                n = 6;
                break;
            }
            case 4: {
                n = 3;
                break;
            }
            case 3: {
                n = 4;
                break;
            }
            case 2: {
                n = 1;
            }
        }
        this.mExifInterface.setAttribute("Orientation", String.valueOf(n));
    }

    public void flipVertically() {
        int n;
        switch (this.getOrientation()) {
            default: {
                n = 4;
                break;
            }
            case 8: {
                n = 5;
                break;
            }
            case 7: {
                n = 6;
                break;
            }
            case 6: {
                n = 7;
                break;
            }
            case 5: {
                n = 8;
                break;
            }
            case 4: {
                n = 1;
                break;
            }
            case 3: {
                n = 2;
                break;
            }
            case 2: {
                n = 3;
            }
        }
        this.mExifInterface.setAttribute("Orientation", String.valueOf(n));
    }

    public String getDescription() {
        return this.mExifInterface.getAttribute("ImageDescription");
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt("ImageLength", 0);
    }

    public long getLastModifiedTimestamp() {
        long l = this.parseTimestamp(this.mExifInterface.getAttribute("DateTime"));
        if (l == -1L) {
            return -1L;
        }
        String string = this.mExifInterface.getAttribute("SubSecTime");
        long l2 = l;
        if (string == null) return l2;
        try {
            for (l2 = Long.parseLong(string); l2 > 1000L; l2 /= 10L) {
            }
            l2 = l + l2;
        }
        catch (NumberFormatException numberFormatException) {
            l2 = l;
        }
        return l2;
    }

    public Location getLocation() {
        String string;
        String string2 = this.mExifInterface.getAttribute("GPSProcessingMethod");
        double[] dArray = this.mExifInterface.getLatLong();
        double d = this.mExifInterface.getAltitude(0.0);
        double d2 = this.mExifInterface.getAttributeDouble("GPSSpeed", 0.0);
        String string3 = string = this.mExifInterface.getAttribute("GPSSpeedRef");
        if (string == null) {
            string3 = "K";
        }
        long l = this.parseTimestamp(this.mExifInterface.getAttribute("GPSDateStamp"), this.mExifInterface.getAttribute("GPSTimeStamp"));
        if (dArray == null) {
            return null;
        }
        string = string2;
        if (string2 == null) {
            string = TAG;
        }
        string = new Location(string);
        string.setLatitude(dArray[0]);
        string.setLongitude(dArray[1]);
        if (d != 0.0) {
            string.setAltitude(d);
        }
        if (d2 != 0.0) {
            int n = -1;
            int n2 = string3.hashCode();
            if (n2 != 75) {
                if (n2 != 77) {
                    if (n2 == 78 && string3.equals("N")) {
                        n = 1;
                    }
                } else if (string3.equals("M")) {
                    n = 0;
                }
            } else if (string3.equals("K")) {
                n = 2;
            }
            d2 = n != 0 ? (n != 1 ? Speed.fromKilometersPerHour((double)d2).toMetersPerSecond() : Speed.fromKnots((double)d2).toMetersPerSecond()) : Speed.fromMilesPerHour((double)d2).toMetersPerSecond();
            string.setSpeed((float)d2);
        }
        if (l == -1L) return string;
        string.setTime(l);
        return string;
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt("Orientation", 0);
    }

    public int getRotation() {
        switch (this.getOrientation()) {
            default: {
                return 0;
            }
            case 8: {
                return 270;
            }
            case 6: 
            case 7: {
                return 90;
            }
            case 5: {
                return 270;
            }
            case 3: 
            case 4: 
        }
        return 180;
    }

    public long getTimestamp() {
        long l = this.parseTimestamp(this.mExifInterface.getAttribute("DateTimeOriginal"));
        if (l == -1L) {
            return -1L;
        }
        String string = this.mExifInterface.getAttribute("SubSecTimeOriginal");
        long l2 = l;
        if (string == null) return l2;
        try {
            for (l2 = Long.parseLong(string); l2 > 1000L; l2 /= 10L) {
            }
            l2 = l + l2;
        }
        catch (NumberFormatException numberFormatException) {
            l2 = l;
        }
        return l2;
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt("ImageWidth", 0);
    }

    public boolean isFlippedHorizontally() {
        if (this.getOrientation() == 2) return true;
        return false;
    }

    public boolean isFlippedVertically() {
        int n = this.getOrientation();
        if (n == 4) return true;
        if (n == 5) return true;
        if (n == 7) return true;
        return false;
    }

    public void removeLocation() {
        this.mExifInterface.setAttribute("GPSProcessingMethod", null);
        this.mExifInterface.setAttribute("GPSLatitude", null);
        this.mExifInterface.setAttribute("GPSLatitudeRef", null);
        this.mExifInterface.setAttribute("GPSLongitude", null);
        this.mExifInterface.setAttribute("GPSLongitudeRef", null);
        this.mExifInterface.setAttribute("GPSAltitude", null);
        this.mExifInterface.setAttribute("GPSAltitudeRef", null);
        this.mExifInterface.setAttribute("GPSSpeed", null);
        this.mExifInterface.setAttribute("GPSSpeedRef", null);
        this.mExifInterface.setAttribute("GPSDateStamp", null);
        this.mExifInterface.setAttribute("GPSTimeStamp", null);
    }

    public void removeTimestamp() {
        this.mExifInterface.setAttribute("DateTime", null);
        this.mExifInterface.setAttribute("DateTimeOriginal", null);
        this.mExifInterface.setAttribute("DateTimeDigitized", null);
        this.mExifInterface.setAttribute("SubSecTime", null);
        this.mExifInterface.setAttribute("SubSecTimeOriginal", null);
        this.mExifInterface.setAttribute("SubSecTimeDigitized", null);
        this.mRemoveTimestamp = true;
    }

    public void rotate(int n) {
        int n2;
        if (n % 90 != 0) {
            Logger.w((String)TAG, (String)String.format(Locale.US, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", n));
            this.mExifInterface.setAttribute("Orientation", String.valueOf(0));
            return;
        }
        int n3 = n % 360;
        int n4 = this.getOrientation();
        block17: while (true) {
            n = n4;
            n2 = n3;
            if (n3 >= 0) break;
            n3 += 90;
            switch (n4) {
                default: {
                    n4 = 8;
                    continue block17;
                }
                case 7: {
                    n4 = 2;
                    continue block17;
                }
                case 6: {
                    n4 = 1;
                    continue block17;
                }
                case 5: {
                    n4 = 4;
                    continue block17;
                }
                case 4: {
                    n4 = 7;
                    continue block17;
                }
                case 3: 
                case 8: {
                    n4 = 6;
                    continue block17;
                }
                case 2: 
            }
            n4 = 5;
        }
        block18: while (true) {
            if (n2 <= 0) {
                this.mExifInterface.setAttribute("Orientation", String.valueOf(n));
                return;
            }
            n2 -= 90;
            switch (n) {
                default: {
                    n = 6;
                    continue block18;
                }
                case 8: {
                    n = 1;
                    continue block18;
                }
                case 7: {
                    n = 4;
                    continue block18;
                }
                case 6: {
                    n = 3;
                    continue block18;
                }
                case 5: {
                    n = 2;
                    continue block18;
                }
                case 4: {
                    n = 5;
                    continue block18;
                }
                case 3: {
                    n = 8;
                    continue block18;
                }
                case 2: 
            }
            n = 7;
        }
    }

    public void save() throws IOException {
        if (!this.mRemoveTimestamp) {
            this.attachLastModifiedTimestamp();
        }
        this.mExifInterface.saveAttributes();
    }

    public void setDescription(String string) {
        this.mExifInterface.setAttribute("ImageDescription", string);
    }

    public void setOrientation(int n) {
        this.mExifInterface.setAttribute("Orientation", String.valueOf(n));
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", this.getWidth(), this.getHeight(), this.getRotation(), this.isFlippedVertically(), this.isFlippedHorizontally(), this.getLocation(), this.getTimestamp(), this.getDescription());
    }
}
