/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager$AssetInputStream
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.location.Location
 *  android.media.MediaDataSource
 *  android.media.MediaMetadataRetriever
 *  android.os.Build$VERSION
 *  android.system.Os
 *  android.system.OsConstants
 *  android.util.Log
 *  android.util.Pair
 *  androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream
 *  androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream
 *  androidx.exifinterface.media.ExifInterface$ExifAttribute
 *  androidx.exifinterface.media.ExifInterface$ExifTag
 *  androidx.exifinterface.media.ExifInterface$Rational
 */
package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/*
 * Exception performing whole class analysis ignored.
 */
public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2;
    public static final int[] BITS_PER_SAMPLE_RGB;
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final boolean DEBUG;
    static final byte[] EXIF_ASCII_PREFIX;
    private static final ExifTag[] EXIF_POINTER_TAGS;
    static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN;
    private static final byte[] HEIF_BRAND_HEIC;
    private static final byte[] HEIF_BRAND_MIF1;
    private static final byte[] HEIF_TYPE_FTYP;
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_HEIF = 12;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_PNG = 13;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final int IMAGE_TYPE_WEBP = 14;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG;
    static final byte[] JPEG_SIGNATURE;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] PNG_CHUNK_TYPE_EXIF;
    private static final byte[] PNG_CHUNK_TYPE_IEND;
    private static final byte[] PNG_CHUNK_TYPE_IHDR;
    private static final byte[] PNG_SIGNATURE;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    @Deprecated
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_ANIM;
    private static final byte[] WEBP_CHUNK_TYPE_ANMF;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_EXIF;
    private static final byte[] WEBP_CHUNK_TYPE_VP8;
    private static final byte[] WEBP_CHUNK_TYPE_VP8L;
    private static final byte[] WEBP_CHUNK_TYPE_VP8X;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_SIGNATURE_1;
    private static final byte[] WEBP_SIGNATURE_2;
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final byte[] WEBP_VP8_SIGNATURE;
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap;
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet<String> sTagSetForCompatibility;
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;

    static {
        Integer n = 3;
        DEBUG = Log.isLoggable((String)"ExifInterface", (int)3);
        Integer n2 = 1;
        Integer n3 = 2;
        Integer n4 = 8;
        ROTATION_ORDER = Arrays.asList(n2, 6, n, n4);
        Integer n5 = 7;
        Integer n6 = 5;
        FLIPPED_ROTATION_ORDER = Arrays.asList(n3, n5, 4, n6);
        BITS_PER_SAMPLE_RGB = new int[]{8, 8, 8};
        BITS_PER_SAMPLE_GREYSCALE_1 = new int[]{4};
        BITS_PER_SAMPLE_GREYSCALE_2 = new int[]{8};
        JPEG_SIGNATURE = new byte[]{-1, -40, -1};
        HEIF_TYPE_FTYP = new byte[]{102, 116, 121, 112};
        HEIF_BRAND_MIF1 = new byte[]{109, 105, 102, 49};
        HEIF_BRAND_HEIC = new byte[]{104, 101, 105, 99};
        ORF_MAKER_NOTE_HEADER_1 = new byte[]{79, 76, 89, 77, 80, 0};
        ORF_MAKER_NOTE_HEADER_2 = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        PNG_SIGNATURE = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_CHUNK_TYPE_EXIF = new byte[]{101, 88, 73, 102};
        PNG_CHUNK_TYPE_IHDR = new byte[]{73, 72, 68, 82};
        PNG_CHUNK_TYPE_IEND = new byte[]{73, 69, 78, 68};
        WEBP_SIGNATURE_1 = new byte[]{82, 73, 70, 70};
        WEBP_SIGNATURE_2 = new byte[]{87, 69, 66, 80};
        WEBP_CHUNK_TYPE_EXIF = new byte[]{69, 88, 73, 70};
        WEBP_VP8_SIGNATURE = new byte[]{-99, 1, 42};
        WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes(Charset.defaultCharset());
        WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes(Charset.defaultCharset());
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        IFD_FORMAT_BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        EXIF_ASCII_PREFIX = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        IFD_TIFF_TAGS = new ExifTag[]{new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", 700, 1)};
        IFD_EXIF_TAGS = new ExifTag[]{new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        IFD_GPS_TAGS = new ExifTag[]{new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        IFD_INTEROPERABILITY_TAGS = new ExifTag[]{new ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_THUMBNAIL_TAGS = new ExifTag[]{new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        TAG_RAF_IMAGE_SIZE = new ExifTag("StripOffsets", 273, 3);
        ORF_MAKER_NOTE_TAGS = new ExifTag[]{new ExifTag("ThumbnailImage", 256, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
        ORF_CAMERA_SETTINGS_TAGS = new ExifTag[]{new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4)};
        ORF_IMAGE_PROCESSING_TAGS = new ExifTag[]{new ExifTag("AspectFrame", 4371, 3)};
        Object object = new ExifTag[]{new ExifTag("ColorSpace", 55, 3)};
        PEF_TAGS = object;
        ExifTag[] object22 = IFD_TIFF_TAGS;
        EXIF_TAGS = new ExifTag[][]{object22, IFD_EXIF_TAGS, IFD_GPS_TAGS, IFD_INTEROPERABILITY_TAGS, IFD_THUMBNAIL_TAGS, object22, ORF_MAKER_NOTE_TAGS, ORF_CAMERA_SETTINGS_TAGS, ORF_IMAGE_PROCESSING_TAGS, object};
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
        JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag("JPEGInterchangeFormat", 513, 4);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
        object = EXIF_TAGS;
        sExifTagMapsForReading = new HashMap[((ExifTag[])object).length];
        sExifTagMapsForWriting = new HashMap[((ExifTag[])object).length];
        sTagSetForCompatibility = new HashSet<String>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        sExifPointerTagMap = new HashMap();
        object = Charset.forName("US-ASCII");
        ASCII = object;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes((Charset)object);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(ASCII);
        sFormatterPrimary = object = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.US);
        ((DateFormat)object).setTimeZone(TimeZone.getTimeZone("UTC"));
        sFormatterSecondary = object = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        ((DateFormat)object).setTimeZone(TimeZone.getTimeZone("UTC"));
        int n7 = 0;
        while (true) {
            if (n7 >= EXIF_TAGS.length) {
                sExifPointerTagMap.put(ExifInterface.EXIF_POINTER_TAGS[0].number, n6);
                sExifPointerTagMap.put(ExifInterface.EXIF_POINTER_TAGS[1].number, n2);
                sExifPointerTagMap.put(ExifInterface.EXIF_POINTER_TAGS[2].number, n3);
                sExifPointerTagMap.put(ExifInterface.EXIF_POINTER_TAGS[3].number, n);
                sExifPointerTagMap.put(ExifInterface.EXIF_POINTER_TAGS[4].number, n5);
                sExifPointerTagMap.put(ExifInterface.EXIF_POINTER_TAGS[5].number, n4);
                NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
                GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            ExifInterface.sExifTagMapsForReading[n7] = new HashMap();
            ExifInterface.sExifTagMapsForWriting[n7] = new HashMap();
            for (ExifTag exifTag : EXIF_TAGS[n7]) {
                sExifTagMapsForReading[n7].put(exifTag.number, exifTag);
                sExifTagMapsForWriting[n7].put(exifTag.name, exifTag);
            }
            ++n7;
        }
    }

    public ExifInterface(File file) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet<Integer>(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (file == null) throw new NullPointerException("file cannot be null");
        this.initForFilename(file.getAbsolutePath());
    }

    /*
     * WARNING - void declaration
     */
    public ExifInterface(FileDescriptor fileDescriptor) throws IOException {
        void var4_7;
        FileInputStream fileInputStream;
        boolean bl;
        block8: {
            this.mAttributes = new HashMap[EXIF_TAGS.length];
            this.mAttributesOffsets = new HashSet<Integer>(EXIF_TAGS.length);
            this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
            if (fileDescriptor == null) throw new NullPointerException("fileDescriptor cannot be null");
            this.mAssetInputStream = null;
            this.mFilename = null;
            bl = false;
            if (Build.VERSION.SDK_INT >= 21 && ExifInterface.isSeekableFD(fileDescriptor)) {
                this.mSeekableFileDescriptor = fileDescriptor;
                try {
                    fileDescriptor = Os.dup((FileDescriptor)fileDescriptor);
                    bl = true;
                }
                catch (Exception exception) {
                    throw new IOException("Failed to duplicate file descriptor", exception);
                }
            } else {
                this.mSeekableFileDescriptor = null;
            }
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
            }
            catch (Throwable throwable) {
                fileInputStream = null;
                break block8;
            }
            try {
                this.loadAttributes(fileInputStream);
            }
            catch (Throwable throwable) {
                break block8;
            }
            ExifInterface.closeQuietly(fileInputStream);
            if (!bl) return;
            ExifInterface.closeFileDescriptor(fileDescriptor);
            return;
        }
        ExifInterface.closeQuietly(fileInputStream);
        if (!bl) throw var4_7;
        ExifInterface.closeFileDescriptor(fileDescriptor);
        throw var4_7;
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public ExifInterface(InputStream inputStream, int n) throws IOException {
        FileInputStream fileInputStream;
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet<Integer>(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (inputStream == null) throw new NullPointerException("inputStream cannot be null");
        this.mFilename = null;
        n = n == 1 ? 1 : 0;
        if (n != 0) {
            if (!ExifInterface.isExifDataOnly((BufferedInputStream)(inputStream = new BufferedInputStream(inputStream, 5000)))) {
                Log.w((String)"ExifInterface", (String)"Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.mIsExifDataOnly = true;
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.mAssetInputStream = (AssetManager.AssetInputStream)inputStream;
            this.mSeekableFileDescriptor = null;
        } else if (inputStream instanceof FileInputStream && ExifInterface.isSeekableFD((fileInputStream = (FileInputStream)inputStream).getFD())) {
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = fileInputStream.getFD();
        } else {
            this.mAssetInputStream = null;
            this.mSeekableFileDescriptor = null;
        }
        this.loadAttributes(inputStream);
    }

    public ExifInterface(String string) throws IOException {
        this.mAttributes = new HashMap[EXIF_TAGS.length];
        this.mAttributesOffsets = new HashSet<Integer>(EXIF_TAGS.length);
        this.mExifByteOrder = ByteOrder.BIG_ENDIAN;
        if (string == null) throw new NullPointerException("filename cannot be null");
        this.initForFilename(string);
    }

    private void addDefaultValuesForCompatibility() {
        String string = this.getAttribute("DateTimeOriginal");
        if (string != null && this.getAttribute("DateTime") == null) {
            this.mAttributes[0].put("DateTime", ExifAttribute.createString((String)string));
        }
        if (this.getAttribute("ImageWidth") == null) {
            this.mAttributes[0].put("ImageWidth", ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
        }
        if (this.getAttribute("ImageLength") == null) {
            this.mAttributes[0].put("ImageLength", ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
        }
        if (this.getAttribute("Orientation") == null) {
            this.mAttributes[0].put("Orientation", ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
        }
        if (this.getAttribute("LightSource") != null) return;
        this.mAttributes[1].put("LightSource", ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
    }

    private static String byteArrayToHexString(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder(byArray.length * 2);
        int n = 0;
        while (n < byArray.length) {
            stringBuilder.append(String.format("%02x", byArray[n]));
            ++n;
        }
        return stringBuilder.toString();
    }

    private static void closeFileDescriptor(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.close((FileDescriptor)fileDescriptor);
            }
            catch (Exception exception) {
                Log.e((String)"ExifInterface", (String)"Error closing fd.");
            }
        } else {
            Log.e((String)"ExifInterface", (String)"closeFileDescriptor is called in API < 21, which must be wrong.");
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
        }
    }

    private String convertDecimalDegree(double d) {
        long l = (long)d;
        double d2 = l;
        Double.isNaN(d2);
        long l2 = (long)((d -= d2) * 60.0);
        d2 = l2;
        Double.isNaN(d2);
        long l3 = Math.round((d - d2 / 60.0) * 3600.0 * 1.0E7);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l);
        stringBuilder.append("/1,");
        stringBuilder.append(l2);
        stringBuilder.append("/1,");
        stringBuilder.append(l3);
        stringBuilder.append("/10000000");
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private static double convertRationalLatLonToDouble(String object, String string) {
        double d;
        try {
            object = object.split(",", -1);
            String[] stringArray = object[0].split("/", -1);
            double d2 = Double.parseDouble(stringArray[0].trim()) / Double.parseDouble(stringArray[1].trim());
            stringArray = object[1].split("/", -1);
            double d3 = Double.parseDouble(stringArray[0].trim()) / Double.parseDouble(stringArray[1].trim());
            object = object[2].split("/", -1);
            d = Double.parseDouble(object[0].trim()) / Double.parseDouble(object[1].trim());
            d = d2 + d3 / 60.0 + d / 3600.0;
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException runtimeException) {
            throw new IllegalArgumentException();
        }
        {
            if (string.equals("S")) return -d;
            if (string.equals("W")) return -d;
            if (string.equals("N")) return d;
            if (string.equals("E")) {
                return d;
            }
            object = new IllegalArgumentException();
            throw object;
        }
    }

    private static long[] convertToLongArray(Object object) {
        if (!(object instanceof int[])) {
            if (!(object instanceof long[])) return null;
            return (long[])object;
        }
        object = (int[])object;
        long[] lArray = new long[((Object)object).length];
        int n = 0;
        while (n < ((Object)object).length) {
            lArray[n] = (long)object[n];
            ++n;
        }
        return lArray;
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        int n;
        byte[] byArray = new byte[8192];
        int n2 = 0;
        while ((n = inputStream.read(byArray)) != -1) {
            n2 += n;
            outputStream.write(byArray, 0, n);
        }
        return n2;
    }

    private static void copy(InputStream inputStream, OutputStream outputStream, int n) throws IOException {
        byte[] byArray = new byte[8192];
        while (n > 0) {
            int n2 = Math.min(n, 8192);
            int n3 = inputStream.read(byArray, 0, n2);
            if (n3 != n2) throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            n -= n3;
            outputStream.write(byArray, 0, n3);
        }
    }

    private void copyChunksUpToGivenChunkType(ByteOrderedDataInputStream object, ByteOrderedDataOutputStream object2, byte[] byArray, byte[] byArray2) throws IOException {
        byte[] byArray3;
        do {
            if (object.read(byArray3 = new byte[4]) != 4) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Encountered invalid length while copying WebP chunks up tochunk type ");
                ((StringBuilder)object2).append(new String(byArray, ASCII));
                if (byArray2 == null) {
                    object = "";
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(" or ");
                    ((StringBuilder)object).append(new String(byArray2, ASCII));
                    object = ((StringBuilder)object).toString();
                }
                ((StringBuilder)object2).append((String)object);
                throw new IOException(((StringBuilder)object2).toString());
            }
            this.copyWebPChunk((ByteOrderedDataInputStream)object, (ByteOrderedDataOutputStream)object2, byArray3);
            if (Arrays.equals(byArray3, byArray)) return;
        } while (byArray2 == null || !Arrays.equals(byArray3, byArray2));
    }

    private void copyWebPChunk(ByteOrderedDataInputStream byteOrderedDataInputStream, ByteOrderedDataOutputStream byteOrderedDataOutputStream, byte[] byArray) throws IOException {
        int n = byteOrderedDataInputStream.readInt();
        byteOrderedDataOutputStream.write(byArray);
        byteOrderedDataOutputStream.writeInt(n);
        int n2 = n;
        if (n % 2 == 1) {
            n2 = n + 1;
        }
        ExifInterface.copy((InputStream)byteOrderedDataInputStream, (OutputStream)byteOrderedDataOutputStream, n2);
    }

    private ExifAttribute getExifAttribute(String object) {
        if (object == null) {
            object = new NullPointerException("tag shouldn't be null");
            throw object;
        }
        String string = object;
        if ("ISOSpeedRatings".equals(object)) {
            if (DEBUG) {
                Log.d((String)"ExifInterface", (String)"getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            string = "PhotographicSensitivity";
        }
        int n = 0;
        while (n < EXIF_TAGS.length) {
            object = this.mAttributes[n].get(string);
            if (object != null) {
                return object;
            }
            ++n;
        }
        return null;
    }

    private void getHeifAttributes(ByteOrderedDataInputStream object) throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            int n;
            int n2;
            Object object2;
            if (Build.VERSION.SDK_INT >= 23) {
                object2 = new /* Unavailable Anonymous Inner Class!! */;
                mediaMetadataRetriever.setDataSource((MediaDataSource)object2);
            } else if (this.mSeekableFileDescriptor != null) {
                mediaMetadataRetriever.setDataSource(this.mSeekableFileDescriptor);
            } else {
                if (this.mFilename == null) return;
                mediaMetadataRetriever.setDataSource(this.mFilename);
            }
            String string = mediaMetadataRetriever.extractMetadata(33);
            Object object3 = mediaMetadataRetriever.extractMetadata(34);
            String string2 = mediaMetadataRetriever.extractMetadata(26);
            object2 = mediaMetadataRetriever.extractMetadata(17);
            boolean bl = "yes".equals(string2);
            String string3 = null;
            if (bl) {
                string3 = mediaMetadataRetriever.extractMetadata(29);
                object2 = mediaMetadataRetriever.extractMetadata(30);
                string2 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(object2)) {
                string3 = mediaMetadataRetriever.extractMetadata(18);
                object2 = mediaMetadataRetriever.extractMetadata(19);
                string2 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                object2 = null;
                string2 = null;
            }
            if (string3 != null) {
                this.mAttributes[0].put("ImageWidth", ExifAttribute.createUShort((int)Integer.parseInt(string3), (ByteOrder)this.mExifByteOrder));
            }
            if (object2 != null) {
                this.mAttributes[0].put("ImageLength", ExifAttribute.createUShort((int)Integer.parseInt((String)object2), (ByteOrder)this.mExifByteOrder));
            }
            if (string2 != null) {
                n2 = 1;
                n = Integer.parseInt(string2);
                if (n != 90) {
                    if (n != 180) {
                        if (n == 270) {
                            n2 = 8;
                        }
                    } else {
                        n2 = 3;
                    }
                } else {
                    n2 = 6;
                }
                this.mAttributes[0].put("Orientation", ExifAttribute.createUShort((int)n2, (ByteOrder)this.mExifByteOrder));
            }
            if (string != null && object3 != null) {
                n2 = Integer.parseInt(string);
                n = Integer.parseInt((String)object3);
                if (n <= 6) {
                    object = new IOException("Invalid exif length");
                    throw object;
                }
                object.seek((long)n2);
                object3 = new byte[6];
                if (object.read((byte[])object3) != 6) {
                    object = new IOException("Can't read identifier");
                    throw object;
                }
                n -= 6;
                if (!Arrays.equals((byte[])object3, IDENTIFIER_EXIF_APP1)) {
                    object = new IOException("Invalid identifier");
                    throw object;
                }
                object3 = new byte[n];
                if (object.read((byte[])object3) != n) {
                    object = new IOException("Can't read exif");
                    throw object;
                }
                this.mOffsetToExifData = n2 + 6;
                this.readExifSegment((byte[])object3, 0);
            }
            if (!DEBUG) return;
            object = new StringBuilder();
            ((StringBuilder)object).append("Heif meta: ");
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append("x");
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(", rotation ");
            ((StringBuilder)object).append(string2);
            Log.d((String)"ExifInterface", (String)((StringBuilder)object).toString());
            return;
        }
        finally {
            mediaMetadataRetriever.release();
        }
    }

    private void getJpegAttributes(ByteOrderedDataInputStream object, int n, int n2) throws IOException {
        Object object2;
        boolean bl = DEBUG;
        String string = "ExifInterface";
        if (bl) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("getJpegAttributes starting with: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"ExifInterface", (String)((StringBuilder)object2).toString());
        }
        object.mark(0);
        object.setByteOrder(ByteOrder.BIG_ENDIAN);
        int n3 = object.readByte();
        if (n3 != -1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid marker: ");
            ((StringBuilder)object).append(Integer.toHexString(n3 & 0xFF));
            object = new IOException(((StringBuilder)object).toString());
            throw object;
        }
        if (object.readByte() != -40) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid marker: ");
            ((StringBuilder)object).append(Integer.toHexString(n3 & 0xFF));
            throw new IOException(((StringBuilder)object).toString());
        }
        n3 = 2;
        while (true) {
            int n4;
            int n5;
            block26: {
                block27: {
                    block24: {
                        block25: {
                            if ((n5 = object.readByte()) != -1) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("Invalid marker:");
                                ((StringBuilder)object).append(Integer.toHexString(n5 & 0xFF));
                                throw new IOException(((StringBuilder)object).toString());
                            }
                            byte by = object.readByte();
                            if (DEBUG) {
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("Found JPEG segment indicator: ");
                                ((StringBuilder)object2).append(Integer.toHexString(by & 0xFF));
                                Log.d((String)string, (String)((StringBuilder)object2).toString());
                            }
                            if (by == -39 || by == -38) break;
                            n4 = object.readUnsignedShort() - 2;
                            n5 = n3 + 1 + 1 + 2;
                            if (DEBUG) {
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("JPEG segment: ");
                                ((StringBuilder)object2).append(Integer.toHexString(by & 0xFF));
                                ((StringBuilder)object2).append(" (length: ");
                                ((StringBuilder)object2).append(n4 + 2);
                                ((StringBuilder)object2).append(")");
                                Log.d((String)string, (String)((StringBuilder)object2).toString());
                            }
                            if (n4 < 0) throw new IOException("Invalid length");
                            if (by == -31) break block24;
                            if (by == -2) break block25;
                            block0 : switch (by) {
                                default: {
                                    switch (by) {
                                        default: {
                                            switch (by) {
                                                default: {
                                                    switch (by) {
                                                        default: {
                                                            n3 = n4;
                                                            break block0;
                                                        }
                                                        case -51: 
                                                        case -50: 
                                                        case -49: 
                                                    }
                                                }
                                                case -55: 
                                                case -54: 
                                                case -53: 
                                            }
                                        }
                                        case -59: 
                                        case -58: 
                                        case -57: 
                                    }
                                }
                                case -64: 
                                case -63: 
                                case -62: 
                                case -61: {
                                    if (object.skipBytes(1) != 1) throw new IOException("Invalid SOFx");
                                    this.mAttributes[n2].put("ImageLength", ExifAttribute.createULong((long)object.readUnsignedShort(), (ByteOrder)this.mExifByteOrder));
                                    this.mAttributes[n2].put("ImageWidth", ExifAttribute.createULong((long)object.readUnsignedShort(), (ByteOrder)this.mExifByteOrder));
                                    n3 = n4 - 5;
                                }
                            }
                            n4 = n5;
                            n5 = n3;
                            break block26;
                        }
                        object2 = new byte[n4];
                        if (object.read((byte[])object2) != n4) throw new IOException("Invalid exif");
                        if (this.getAttribute("UserComment") == null) {
                            this.mAttributes[1].put("UserComment", ExifAttribute.createString((String)new String((byte[])object2, ASCII)));
                        }
                        n3 = n5;
                        break block27;
                    }
                    byte[] byArray = new byte[n4];
                    object.readFully(byArray);
                    if (ExifInterface.startsWith(byArray, IDENTIFIER_EXIF_APP1)) {
                        object2 = Arrays.copyOfRange(byArray, IDENTIFIER_EXIF_APP1.length, n4);
                        this.mOffsetToExifData = n + n5 + IDENTIFIER_EXIF_APP1.length;
                        this.readExifSegment((byte[])object2, n2);
                        this.setThumbnailData(new ByteOrderedDataInputStream((byte[])object2));
                    } else if (ExifInterface.startsWith(byArray, IDENTIFIER_XMP_APP1)) {
                        object2 = IDENTIFIER_XMP_APP1;
                        n3 = ((Object)object2).length;
                        object2 = Arrays.copyOfRange(byArray, ((Object)object2).length, n4);
                        if (this.getAttribute("Xmp") == null) {
                            this.mAttributes[0].put("Xmp", new ExifAttribute(1, ((Object)object2).length, (long)(n5 + n3), (byte[])object2));
                            this.mXmpIsFromSeparateMarker = true;
                        }
                    }
                    n3 = n5 + n4;
                }
                n5 = 0;
                n4 = n3;
            }
            if (n5 < 0) throw new IOException("Invalid length");
            if (object.skipBytes(n5) != n5) throw new IOException("Invalid JPEG segment");
            n3 = n4 + n5;
        }
        object.setByteOrder(this.mExifByteOrder);
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] byArray = new byte[5000];
        bufferedInputStream.read(byArray);
        bufferedInputStream.reset();
        if (ExifInterface.isJpegFormat(byArray)) {
            return 4;
        }
        if (this.isRafFormat(byArray)) {
            return 9;
        }
        if (this.isHeifFormat(byArray)) {
            return 12;
        }
        if (this.isOrfFormat(byArray)) {
            return 7;
        }
        if (this.isRw2Format(byArray)) {
            return 10;
        }
        if (this.isPngFormat(byArray)) {
            return 13;
        }
        if (!this.isWebpFormat(byArray)) return 0;
        return 14;
    }

    private void getOrfAttributes(ByteOrderedDataInputStream object) throws IOException {
        this.getRawAttributes((ByteOrderedDataInputStream)object);
        object = this.mAttributes[1].get("MakerNote");
        if (object == null) return;
        Object object2 = new ByteOrderedDataInputStream(object.bytes);
        object2.setByteOrder(this.mExifByteOrder);
        byte[] byArray = new byte[ORF_MAKER_NOTE_HEADER_1.length];
        object2.readFully(byArray);
        object2.seek(0L);
        object = new byte[ORF_MAKER_NOTE_HEADER_2.length];
        object2.readFully((byte[])object);
        if (Arrays.equals(byArray, ORF_MAKER_NOTE_HEADER_1)) {
            object2.seek(8L);
        } else if (Arrays.equals((byte[])object, ORF_MAKER_NOTE_HEADER_2)) {
            object2.seek(12L);
        }
        this.readImageFileDirectory((ByteOrderedDataInputStream)object2, 6);
        object2 = this.mAttributes[7].get("PreviewImageStart");
        object = this.mAttributes[7].get("PreviewImageLength");
        if (object2 != null && object != null) {
            this.mAttributes[5].put("JPEGInterchangeFormat", (ExifAttribute)object2);
            this.mAttributes[5].put("JPEGInterchangeFormatLength", (ExifAttribute)object);
        }
        if ((object = this.mAttributes[8].get("AspectFrame")) == null) return;
        if ((object = (Object)((int[])object.getValue(this.mExifByteOrder))) != null && ((ByteOrderedDataInputStream)object).length == 4) {
            reference var3_8;
            reference var2_10;
            if (object[2] <= object[0]) return;
            if (object[3] <= object[1]) return;
            reference var5_4 = object[2] - object[0] + true;
            reference var4_5 = object[3] - object[1] + true;
            reference var3_6 = var5_4;
            reference var2_9 = var4_5;
            if (var5_4 < var4_5) {
                reference var3_7 = var5_4 + var4_5;
                var2_10 = var3_7 - var4_5;
                var3_8 = var3_7 - var2_10;
            }
            object2 = ExifAttribute.createUShort((int)var3_8, (ByteOrder)this.mExifByteOrder);
            object = ExifAttribute.createUShort((int)var2_10, (ByteOrder)this.mExifByteOrder);
            this.mAttributes[0].put("ImageWidth", (ExifAttribute)object2);
            this.mAttributes[0].put("ImageLength", (ExifAttribute)object);
        } else {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Invalid aspect frame values. frame=");
            ((StringBuilder)object2).append(Arrays.toString((int[])object));
            Log.w((String)"ExifInterface", (String)((StringBuilder)object2).toString());
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void getPngAttributes(ByteOrderedDataInputStream object) throws IOException {
        Object object2;
        if (DEBUG) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("getPngAttributes starting with: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"ExifInterface", (String)((StringBuilder)object2).toString());
        }
        object.mark(0);
        object.setByteOrder(ByteOrder.BIG_ENDIAN);
        object.skipBytes(PNG_SIGNATURE.length);
        int n = PNG_SIGNATURE.length + 0;
        try {
            while (true) {
                int n2 = object.readInt();
                object2 = new byte[4];
                if (object.read((byte[])object2) != 4) break;
                if ((n = n + 4 + 4) == 16 && !Arrays.equals((byte[])object2, PNG_CHUNK_TYPE_IHDR)) {
                    object = new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    throw object;
                }
                if (Arrays.equals((byte[])object2, PNG_CHUNK_TYPE_IEND)) {
                    return;
                }
                if (Arrays.equals((byte[])object2, PNG_CHUNK_TYPE_EXIF)) {
                    Object object3 = new byte[n2];
                    if (object.read(object3) != n2) {
                        object3 = new IOException;
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Failed to read given length for given PNG chunk type: ");
                        ((StringBuilder)object).append(ExifInterface.byteArrayToHexString((byte[])object2));
                        object3(((StringBuilder)object).toString());
                        throw object3;
                    }
                    n2 = object.readInt();
                    object = new CRC32();
                    ((CRC32)object).update((byte[])object2);
                    ((CRC32)object).update((byte[])object3);
                    if ((int)((CRC32)object).getValue() == n2) {
                        this.mOffsetToExifData = n;
                        this.readExifSegment((byte[])object3, 0);
                        this.validateImages();
                        object = new ByteOrderedDataInputStream(object3);
                        this.setThumbnailData((ByteOrderedDataInputStream)object);
                        return;
                    }
                    object3 = new IOException;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: ");
                    ((StringBuilder)object2).append(n2);
                    ((StringBuilder)object2).append(", calculated CRC value: ");
                    ((StringBuilder)object2).append(((CRC32)object).getValue());
                    object3(((StringBuilder)object2).toString());
                    throw object3;
                }
                object.skipBytes(n2 += 4);
                n += n2;
            }
            object = new IOException("Encountered invalid length while parsing PNG chunktype");
            throw object;
        }
        catch (EOFException eOFException) {
            IOException iOException = new IOException("Encountered corrupt PNG file.");
            throw iOException;
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream object) throws IOException {
        Object object2;
        if (DEBUG) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("getRafAttributes starting with: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"ExifInterface", (String)((StringBuilder)object2).toString());
        }
        object.mark(0);
        object.skipBytes(84);
        byte[] byArray = new byte[4];
        object2 = new byte[4];
        byte[] byArray2 = new byte[4];
        object.read(byArray);
        object.read((byte[])object2);
        object.read(byArray2);
        int n = ByteBuffer.wrap(byArray).getInt();
        int n2 = ByteBuffer.wrap((byte[])object2).getInt();
        int n3 = ByteBuffer.wrap(byArray2).getInt();
        object2 = new byte[n2];
        object.seek((long)n);
        object.read((byte[])object2);
        this.getJpegAttributes(new ByteOrderedDataInputStream((byte[])object2), n, 5);
        object.seek((long)n3);
        object.setByteOrder(ByteOrder.BIG_ENDIAN);
        n2 = object.readInt();
        if (DEBUG) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("numberOfDirectoryEntry: ");
            ((StringBuilder)object2).append(n2);
            Log.d((String)"ExifInterface", (String)((StringBuilder)object2).toString());
        }
        n3 = 0;
        while (n3 < n2) {
            int n4 = object.readUnsignedShort();
            n = object.readUnsignedShort();
            if (n4 == ExifInterface.TAG_RAF_IMAGE_SIZE.number) {
                n3 = object.readShort();
                n2 = object.readShort();
                object = ExifAttribute.createUShort((int)n3, (ByteOrder)this.mExifByteOrder);
                object2 = ExifAttribute.createUShort((int)n2, (ByteOrder)this.mExifByteOrder);
                this.mAttributes[0].put("ImageLength", (ExifAttribute)object);
                this.mAttributes[0].put("ImageWidth", (ExifAttribute)object2);
                if (!DEBUG) return;
                object = new StringBuilder();
                ((StringBuilder)object).append("Updated to length: ");
                ((StringBuilder)object).append(n3);
                ((StringBuilder)object).append(", width: ");
                ((StringBuilder)object).append(n2);
                Log.d((String)"ExifInterface", (String)((StringBuilder)object).toString());
                return;
            }
            object.skipBytes(n);
            ++n3;
        }
    }

    private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        this.parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        this.readImageFileDirectory(byteOrderedDataInputStream, 0);
        this.updateImageSizeValues(byteOrderedDataInputStream, 0);
        this.updateImageSizeValues(byteOrderedDataInputStream, 5);
        this.updateImageSizeValues(byteOrderedDataInputStream, 4);
        this.validateImages();
        if (this.mMimeType != 8) return;
        byteOrderedDataInputStream = this.mAttributes[1].get("MakerNote");
        if (byteOrderedDataInputStream == null) return;
        byteOrderedDataInputStream = new ByteOrderedDataInputStream(byteOrderedDataInputStream.bytes);
        byteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
        byteOrderedDataInputStream.seek(6L);
        this.readImageFileDirectory(byteOrderedDataInputStream, 9);
        byteOrderedDataInputStream = this.mAttributes[9].get("ColorSpace");
        if (byteOrderedDataInputStream == null) return;
        this.mAttributes[1].put("ColorSpace", (ExifAttribute)byteOrderedDataInputStream);
    }

    private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        StringBuilder stringBuilder;
        if (DEBUG) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("getRw2Attributes starting with: ");
            stringBuilder.append(byteOrderedDataInputStream);
            Log.d((String)"ExifInterface", (String)stringBuilder.toString());
        }
        this.getRawAttributes(byteOrderedDataInputStream);
        byteOrderedDataInputStream = this.mAttributes[0].get("JpgFromRaw");
        if (byteOrderedDataInputStream != null) {
            this.getJpegAttributes(new ByteOrderedDataInputStream(byteOrderedDataInputStream.bytes), (int)byteOrderedDataInputStream.bytesOffset, 5);
        }
        byteOrderedDataInputStream = this.mAttributes[0].get("ISO");
        stringBuilder = this.mAttributes[1].get("PhotographicSensitivity");
        if (byteOrderedDataInputStream == null) return;
        if (stringBuilder != null) return;
        this.mAttributes[1].put("PhotographicSensitivity", (ExifAttribute)byteOrderedDataInputStream);
    }

    private void getStandaloneAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(IDENTIFIER_EXIF_APP1.length);
        byte[] byArray = new byte[byteOrderedDataInputStream.available()];
        byteOrderedDataInputStream.readFully(byArray);
        this.mOffsetToExifData = IDENTIFIER_EXIF_APP1.length;
        this.readExifSegment(byArray, 0);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void getWebpAttributes(ByteOrderedDataInputStream object) throws IOException {
        Object object2;
        if (DEBUG) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("getWebpAttributes starting with: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"ExifInterface", (String)((StringBuilder)object2).toString());
        }
        object.mark(0);
        object.setByteOrder(ByteOrder.LITTLE_ENDIAN);
        object.skipBytes(WEBP_SIGNATURE_1.length);
        int n = object.readInt() + 8;
        int n2 = object.skipBytes(WEBP_SIGNATURE_2.length) + 8;
        try {
            while (object.read((byte[])(object2 = (Object)new byte[4])) == 4) {
                int n3 = object.readInt();
                int n4 = n2 + 4 + 4;
                if (Arrays.equals(WEBP_CHUNK_TYPE_EXIF, (byte[])object2)) {
                    Object object3 = new byte[n3];
                    if (object.read(object3) == n3) {
                        this.mOffsetToExifData = n4;
                        this.readExifSegment((byte[])object3, 0);
                        object = new ByteOrderedDataInputStream(object3);
                        this.setThumbnailData((ByteOrderedDataInputStream)object);
                        return;
                    }
                    object3 = new StringBuilder;
                    object3();
                    object3.append("Failed to read given length for given PNG chunk type: ");
                    object3.append(ExifInterface.byteArrayToHexString((byte[])object2));
                    object = new IOException(object3.toString());
                    throw object;
                }
                n2 = n3;
                if (n3 % 2 == 1) {
                    n2 = n3 + 1;
                }
                if ((n3 = n4 + n2) == n) {
                    return;
                }
                if (n3 <= n) {
                    n3 = object.skipBytes(n2);
                    if (n3 != n2) {
                        object = new IOException("Encountered WebP file with invalid chunk size");
                        throw object;
                    }
                    n2 = n4 + n3;
                    continue;
                }
                object = new IOException("Encountered WebP file with invalid chunk size");
                throw object;
            }
            object = new IOException("Encountered invalid length while parsing WebP chunktype");
            throw object;
        }
        catch (EOFException eOFException) {
            IOException iOException = new IOException("Encountered corrupt WebP file.");
            throw iOException;
        }
    }

    private static Pair<Integer, Integer> guessDataFormat(String pair) {
        boolean bl = pair.contains(",");
        int n = 1;
        Integer n2 = 2;
        Integer n3 = -1;
        if (bl) {
            Pair pair2;
            String[] stringArray = pair.split(",", -1);
            pair = pair2 = ExifInterface.guessDataFormat(stringArray[0]);
            if ((Integer)pair2.first == 2) {
                return pair2;
            }
            while (n < stringArray.length) {
                pair2 = ExifInterface.guessDataFormat(stringArray[n]);
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
                Long l = Long.parseLong((String)pair);
                if (l >= 0L && l <= 65535L) {
                    return new Pair((Object)3, (Object)4);
                }
                if (l < 0L) {
                    return new Pair((Object)9, (Object)n3);
                }
                l = new Pair((Object)4, (Object)n3);
                return l;
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

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream object, HashMap object2) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute)((HashMap)object2).get("JPEGInterchangeFormat");
        object2 = (ExifAttribute)((HashMap)object2).get("JPEGInterchangeFormatLength");
        if (exifAttribute == null) return;
        if (object2 == null) return;
        int n = exifAttribute.getIntValue(this.mExifByteOrder);
        int n2 = object2.getIntValue(this.mExifByteOrder);
        int n3 = n;
        if (this.mMimeType == 7) {
            n3 = n + this.mOrfMakerNoteOffset;
        }
        n = Math.min(n2, object.getLength() - n3);
        if (n3 > 0 && n > 0) {
            this.mHasThumbnail = true;
            if (this.mFilename == null && this.mAssetInputStream == null && this.mSeekableFileDescriptor == null) {
                object2 = new byte[n];
                object.skip((long)n3);
                object.read((byte[])object2);
                this.mThumbnailBytes = (byte[])object2;
            }
            this.mThumbnailOffset = n3;
            this.mThumbnailLength = n;
        }
        if (!DEBUG) return;
        object = new StringBuilder();
        ((StringBuilder)object).append("Setting thumbnail attributes with offset: ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(", length: ");
        ((StringBuilder)object).append(n);
        Log.d((String)"ExifInterface", (String)((StringBuilder)object).toString());
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream object, HashMap object2) throws IOException {
        block10: {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            long l;
            Object object3;
            Object object4;
            block9: {
                block7: {
                    block8: {
                        object4 = (ExifAttribute)((HashMap)object2).get("StripOffsets");
                        object3 = (ExifAttribute)((HashMap)object2).get("StripByteCounts");
                        if (object4 == null) return;
                        if (object3 == null) return;
                        object2 = ExifInterface.convertToLongArray(object4.getValue(this.mExifByteOrder));
                        object3 = ExifInterface.convertToLongArray(object3.getValue(this.mExifByteOrder));
                        if (object2 == null || ((Object)object2).length == 0) break block7;
                        if (object3 == null || ((ExifAttribute)object3).length == 0) break block8;
                        if (((Object)object2).length != ((ExifAttribute)object3).length) {
                            Log.w((String)"ExifInterface", (String)"stripOffsets and stripByteCounts should have same length.");
                            return;
                        }
                        l = 0L;
                        n5 = ((ExifAttribute)object3).length;
                        for (n4 = 0; n4 < n5; l += object3[n4], ++n4) {
                        }
                        n3 = (int)l;
                        object4 = new byte[n3];
                        this.mAreThumbnailStripsConsecutive = true;
                        this.mHasThumbnailStrips = true;
                        this.mHasThumbnail = true;
                        n2 = 0;
                        n4 = 0;
                        break block9;
                    }
                    Log.w((String)"ExifInterface", (String)"stripByteCounts should not be null or have zero length.");
                    return;
                }
                Log.w((String)"ExifInterface", (String)"stripOffsets should not be null or have zero length.");
                break block10;
            }
            for (n5 = 0; n5 < ((Object)object2).length; n4 += n, ++n5) {
                int n6 = (int)object2[n5];
                n = (int)object3[n5];
                if (n5 < ((Object)object2).length - 1 && (long)(n6 + n) != object2[n5 + 1]) {
                    this.mAreThumbnailStripsConsecutive = false;
                }
                if ((n6 -= n2) < 0) {
                    Log.d((String)"ExifInterface", (String)"Invalid strip offset value");
                    return;
                }
                l = n6;
                if (object.skip(l) != l) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Failed to skip ");
                    ((StringBuilder)object).append(n6);
                    ((StringBuilder)object).append(" bytes.");
                    Log.d((String)"ExifInterface", (String)((StringBuilder)object).toString());
                    return;
                }
                byte[] byArray = new byte[n];
                if (object.read(byArray) != n) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Failed to read ");
                    ((StringBuilder)object).append(n);
                    ((StringBuilder)object).append(" bytes.");
                    Log.d((String)"ExifInterface", (String)((StringBuilder)object).toString());
                    return;
                }
                n2 = n2 + n6 + n;
                System.arraycopy(byArray, 0, object4, n4, n);
            }
            this.mThumbnailBytes = (byte[])object4;
            if (!this.mAreThumbnailStripsConsecutive) return;
            this.mThumbnailOffset = (int)object2[0];
            this.mThumbnailLength = n3;
        }
    }

    /*
     * WARNING - void declaration
     */
    private void initForFilename(String string) throws IOException {
        void var1_4;
        FileInputStream fileInputStream;
        block4: {
            FileInputStream fileInputStream2;
            if (string == null) throw new NullPointerException("filename cannot be null");
            fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = string;
            try {
                fileInputStream2 = new FileInputStream(string);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block4;
            }
            try {
                this.mSeekableFileDescriptor = ExifInterface.isSeekableFD(fileInputStream2.getFD()) ? fileInputStream2.getFD() : null;
                this.loadAttributes(fileInputStream2);
            }
            catch (Throwable throwable) {
                fileInputStream = fileInputStream2;
                break block4;
            }
            ExifInterface.closeQuietly(fileInputStream2);
            return;
        }
        ExifInterface.closeQuietly(fileInputStream);
        throw var1_4;
    }

    private static boolean isExifDataOnly(BufferedInputStream object) throws IOException {
        ((BufferedInputStream)object).mark(IDENTIFIER_EXIF_APP1.length);
        byte[] byArray = new byte[IDENTIFIER_EXIF_APP1.length];
        ((FilterInputStream)object).read(byArray);
        ((BufferedInputStream)object).reset();
        int n = 0;
        while (n < ((Object)(object = (Object)IDENTIFIER_EXIF_APP1)).length) {
            if (byArray[n] != object[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    private boolean isHeifFormat(byte[] var1_1) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 6[TRYBLOCK] [18 : 330->351)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static boolean isJpegFormat(byte[] byArray) throws IOException {
        byte[] byArray2;
        int n = 0;
        while (n < (byArray2 = JPEG_SIGNATURE).length) {
            if (byArray[n] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private boolean isOrfFormat(byte[] object) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        block7: {
            void var1_5;
            block6: {
                boolean bl;
                block8: {
                    bl = false;
                    Object var6_8 = null;
                    Object var5_9 = null;
                    try {
                        byteOrderedDataInputStream = new ByteOrderedDataInputStream(object);
                    }
                    catch (Throwable throwable) {
                        byteOrderedDataInputStream = var5_9;
                        break block6;
                    }
                    catch (Exception exception) {
                        byteOrderedDataInputStream = var6_8;
                        break block7;
                    }
                    try {
                        object = this.readByteOrder(byteOrderedDataInputStream);
                        this.mExifByteOrder = object;
                        byteOrderedDataInputStream.setByteOrder((ByteOrder)object);
                        short s = byteOrderedDataInputStream.readShort();
                        if (s != 20306 && s != 21330) break block8;
                        bl = true;
                    }
                    catch (Throwable throwable) {
                        break block6;
                    }
                    catch (Exception exception) {
                        break block7;
                    }
                }
                byteOrderedDataInputStream.close();
                return bl;
            }
            if (byteOrderedDataInputStream == null) throw var1_5;
            byteOrderedDataInputStream.close();
            throw var1_5;
        }
        if (byteOrderedDataInputStream == null) return false;
        byteOrderedDataInputStream.close();
        return false;
    }

    private boolean isPngFormat(byte[] byArray) throws IOException {
        byte[] byArray2;
        int n = 0;
        while (n < (byArray2 = PNG_SIGNATURE).length) {
            if (byArray[n] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private boolean isRafFormat(byte[] byArray) throws IOException {
        byte[] byArray2 = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int n = 0;
        while (n < byArray2.length) {
            if (byArray[n] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    private boolean isRw2Format(byte[] object) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream;
        block7: {
            void var1_5;
            block6: {
                boolean bl;
                block8: {
                    bl = false;
                    Object var6_8 = null;
                    Object var5_9 = null;
                    try {
                        byteOrderedDataInputStream = new ByteOrderedDataInputStream(object);
                    }
                    catch (Throwable throwable) {
                        byteOrderedDataInputStream = var5_9;
                        break block6;
                    }
                    catch (Exception exception) {
                        byteOrderedDataInputStream = var6_8;
                        break block7;
                    }
                    try {
                        object = this.readByteOrder(byteOrderedDataInputStream);
                        this.mExifByteOrder = object;
                        byteOrderedDataInputStream.setByteOrder((ByteOrder)object);
                        short s = byteOrderedDataInputStream.readShort();
                        if (s != 85) break block8;
                        bl = true;
                    }
                    catch (Throwable throwable) {
                        break block6;
                    }
                    catch (Exception exception) {
                        break block7;
                    }
                }
                byteOrderedDataInputStream.close();
                return bl;
            }
            if (byteOrderedDataInputStream == null) throw var1_5;
            byteOrderedDataInputStream.close();
            throw var1_5;
        }
        if (byteOrderedDataInputStream == null) return false;
        byteOrderedDataInputStream.close();
        return false;
    }

    private static boolean isSeekableFD(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT < 21) return false;
        try {
            Os.lseek((FileDescriptor)fileDescriptor, (long)0L, (int)OsConstants.SEEK_CUR);
            return true;
        }
        catch (Exception exception) {
            if (!DEBUG) return false;
            Log.d((String)"ExifInterface", (String)"The file descriptor for the given input is not seekable");
        }
        return false;
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        Object object = (ExifAttribute)hashMap.get("BitsPerSample");
        if (object != null) {
            if (Arrays.equals(BITS_PER_SAMPLE_RGB, (int[])(object = (Object)((int[])object.getValue(this.mExifByteOrder))))) {
                return true;
            }
            if (this.mMimeType == 3 && (hashMap = (ExifAttribute)hashMap.get("PhotometricInterpretation")) != null) {
                int n = hashMap.getIntValue(this.mExifByteOrder);
                if (n == 1) {
                    if (Arrays.equals((int[])object, BITS_PER_SAMPLE_GREYSCALE_2)) return true;
                }
                if (n == 6 && Arrays.equals((int[])object, BITS_PER_SAMPLE_RGB)) {
                    return true;
                }
            }
        }
        if (!DEBUG) return false;
        Log.d((String)"ExifInterface", (String)"Unsupported data type value");
        return false;
    }

    private boolean isSupportedFormatForSavingAttributes() {
        int n = this.mMimeType;
        if (n == 4) return true;
        if (n == 13) return true;
        if (n != 14) return false;
        return true;
    }

    public static boolean isSupportedMimeType(String string) {
        if (string == null) throw new NullPointerException("mimeType shouldn't be null");
        string = string.toLowerCase(Locale.ROOT);
        int n = -1;
        switch (string.hashCode()) {
            default: {
                break;
            }
            case 2111234748: {
                if (!string.equals("image/x-canon-cr2")) break;
                n = 2;
                break;
            }
            case 2099152524: {
                if (!string.equals("image/x-nikon-nrw")) break;
                n = 4;
                break;
            }
            case 2099152104: {
                if (!string.equals("image/x-nikon-nef")) break;
                n = 3;
                break;
            }
            case 1378106698: {
                if (!string.equals("image/x-olympus-orf")) break;
                n = 7;
                break;
            }
            case -332763809: {
                if (!string.equals("image/x-pentax-pef")) break;
                n = 8;
                break;
            }
            case -879258763: {
                if (!string.equals("image/png")) break;
                n = 13;
                break;
            }
            case -985160897: {
                if (!string.equals("image/x-panasonic-rw2")) break;
                n = 6;
                break;
            }
            case -1423313290: {
                if (!string.equals("image/x-adobe-dng")) break;
                n = 1;
                break;
            }
            case -1487018032: {
                if (!string.equals("image/webp")) break;
                n = 14;
                break;
            }
            case -1487394660: {
                if (!string.equals("image/jpeg")) break;
                n = 0;
                break;
            }
            case -1487464690: {
                if (!string.equals("image/heif")) break;
                n = 12;
                break;
            }
            case -1487464693: {
                if (!string.equals("image/heic")) break;
                n = 11;
                break;
            }
            case -1594371159: {
                if (!string.equals("image/x-sony-arw")) break;
                n = 5;
                break;
            }
            case -1635437028: {
                if (!string.equals("image/x-samsung-srw")) break;
                n = 9;
                break;
            }
            case -1875291391: {
                if (!string.equals("image/x-fuji-raf")) break;
                n = 10;
            }
        }
        switch (n) {
            default: {
                return false;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
        }
        return true;
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute)hashMap.get("ImageLength");
        hashMap = (ExifAttribute)hashMap.get("ImageWidth");
        if (exifAttribute == null) return false;
        if (hashMap == null) return false;
        int n = exifAttribute.getIntValue(this.mExifByteOrder);
        int n2 = hashMap.getIntValue(this.mExifByteOrder);
        if (n > 512) return false;
        if (n2 > 512) return false;
        return true;
    }

    private boolean isWebpFormat(byte[] byArray) throws IOException {
        byte[] byArray2;
        int n;
        for (n = 0; n < (byArray2 = WEBP_SIGNATURE_1).length; ++n) {
            if (byArray[n] == byArray2[n]) continue;
            return false;
        }
        n = 0;
        while (n < (byArray2 = WEBP_SIGNATURE_2).length) {
            if (byArray[WEBP_SIGNATURE_1.length + n + 4] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    private void loadAttributes(InputStream var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 7[TRYBLOCK] [26 : 326->343)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    private static Long parseDateTime(String object, String string, String string2) {
        long l;
        long l2;
        block10: {
            int n;
            int n2;
            int n3;
            if (object == null) return null;
            if (!NON_ZERO_TIME_PATTERN.matcher((CharSequence)object).matches()) {
                return null;
            }
            ParsePosition parsePosition = new ParsePosition(0);
            try {
                Date date = sFormatterPrimary.parse((String)object, parsePosition);
                Object object2 = date;
                if (date == null) {
                    object2 = object = sFormatterSecondary.parse((String)object, parsePosition);
                    if (object == null) {
                        return null;
                    }
                }
                l = l2 = ((Date)object2).getTime();
                if (string2 == null) break block10;
                n3 = 1;
                object = string2.substring(0, 1);
                n2 = Integer.parseInt(string2.substring(1, 3));
                n = Integer.parseInt(string2.substring(4, 6));
                boolean bl = "+".equals(object);
                if (!bl) {
                    l = l2;
                    if (!"-".equals(object)) break block10;
                }
                l = l2;
                if (!":".equals(string2.substring(3, 4))) break block10;
                l = l2;
                if (n2 > 14) break block10;
                bl = "-".equals(object);
                if (!bl) {
                    n3 = -1;
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return null;
            }
            l = l2 + (long)((n2 * 60 + n) * 60 * 1000 * n3);
        }
        l2 = l;
        if (string == null) return l2;
        try {
            for (l2 = Long.parseLong(string); l2 > 1000L; l2 /= 10L) {
            }
            l2 = l + l2;
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            l2 = l;
            return l2;
        }
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream object, int n) throws IOException {
        ByteOrder byteOrder;
        this.mExifByteOrder = byteOrder = this.readByteOrder((ByteOrderedDataInputStream)object);
        object.setByteOrder(byteOrder);
        int n2 = object.readUnsignedShort();
        int n3 = this.mMimeType;
        if (n3 != 7 && n3 != 10 && n2 != 42) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid start code: ");
            ((StringBuilder)object).append(Integer.toHexString(n2));
            throw new IOException(((StringBuilder)object).toString());
        }
        n3 = object.readInt();
        if (n3 >= 8 && n3 < n) {
            n = n3 - 8;
            if (n <= 0) return;
            if (object.skipBytes(n) == n) {
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Couldn't jump to first Ifd: ");
            ((StringBuilder)object).append(n);
            throw new IOException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid first Ifd offset: ");
        ((StringBuilder)object).append(n3);
        throw new IOException(((StringBuilder)object).toString());
    }

    private void printAttributes() {
        int n = 0;
        while (n < this.mAttributes.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The size of tag group[");
            stringBuilder.append(n);
            stringBuilder.append("]: ");
            stringBuilder.append(this.mAttributes[n].size());
            Log.d((String)"ExifInterface", (String)stringBuilder.toString());
            for (Map.Entry<String, ExifAttribute> entry : this.mAttributes[n].entrySet()) {
                stringBuilder = entry.getValue();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("tagName: ");
                stringBuilder2.append(entry.getKey());
                stringBuilder2.append(", tagType: ");
                stringBuilder2.append(stringBuilder.toString());
                stringBuilder2.append(", tagValue: '");
                stringBuilder2.append(stringBuilder.getStringValue(this.mExifByteOrder));
                stringBuilder2.append("'");
                Log.d((String)"ExifInterface", (String)stringBuilder2.toString());
            }
            ++n;
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream object) throws IOException {
        short s = object.readShort();
        if (s == 18761) {
            if (!DEBUG) return ByteOrder.LITTLE_ENDIAN;
            Log.d((String)"ExifInterface", (String)"readExifSegment: Byte Align II");
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            if (!DEBUG) return ByteOrder.BIG_ENDIAN;
            Log.d((String)"ExifInterface", (String)"readExifSegment: Byte Align MM");
            return ByteOrder.BIG_ENDIAN;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid byte order: ");
        ((StringBuilder)object).append(Integer.toHexString(s));
        throw new IOException(((StringBuilder)object).toString());
    }

    private void readExifSegment(byte[] byArray, int n) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(byArray);
        this.parseTiffHeaders(byteOrderedDataInputStream, byArray.length);
        this.readImageFileDirectory(byteOrderedDataInputStream, n);
    }

    private void readImageFileDirectory(ByteOrderedDataInputStream object, int n) throws IOException {
        long l;
        Object object2;
        this.mAttributesOffsets.add(((ByteOrderedDataInputStream)object).mPosition);
        if (((ByteOrderedDataInputStream)object).mPosition + 2 > ((ByteOrderedDataInputStream)object).mLength) {
            return;
        }
        short s = object.readShort();
        boolean bl = DEBUG;
        String string = "ExifInterface";
        if (bl) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("numberOfDirectoryEntry: ");
            ((StringBuilder)object2).append(s);
            Log.d((String)"ExifInterface", (String)((StringBuilder)object2).toString());
        }
        if (((ByteOrderedDataInputStream)object).mPosition + s * 12 > ((ByteOrderedDataInputStream)object).mLength) return;
        if (s <= 0) return;
        for (short s2 = 0; s2 < s; s2 = (short)(s2 + 1)) {
            int n2;
            int n3;
            Object object3;
            long l2;
            int n4;
            int n5;
            block43: {
                block47: {
                    block48: {
                        block44: {
                            block45: {
                                block46: {
                                    StringBuilder stringBuilder;
                                    int n6;
                                    block42: {
                                        block39: {
                                            block40: {
                                                block41: {
                                                    block38: {
                                                        n6 = object.readUnsignedShort();
                                                        n5 = object.readUnsignedShort();
                                                        n4 = object.readInt();
                                                        l2 = (long)object.peek() + 4L;
                                                        object3 = sExifTagMapsForReading[n].get(n6);
                                                        if (DEBUG) {
                                                            object2 = object3 != null ? ((ExifTag)object3).name : null;
                                                            Log.d((String)string, (String)String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", n, n6, object2, n5, n4));
                                                        }
                                                        if (object3 != null) break block38;
                                                        if (DEBUG) {
                                                            object2 = new StringBuilder();
                                                            ((StringBuilder)object2).append("Skip the tag entry since tag number is not defined: ");
                                                            ((StringBuilder)object2).append(n6);
                                                            Log.d((String)string, (String)((StringBuilder)object2).toString());
                                                        }
                                                        break block39;
                                                    }
                                                    if (n5 <= 0 || n5 >= IFD_FORMAT_BYTES_PER_FORMAT.length) break block40;
                                                    if (object3.isFormatCompatible(n5)) break block41;
                                                    if (DEBUG) {
                                                        object2 = new StringBuilder();
                                                        ((StringBuilder)object2).append("Skip the tag entry since data format (");
                                                        ((StringBuilder)object2).append(IFD_FORMAT_NAMES[n5]);
                                                        ((StringBuilder)object2).append(") is unexpected for tag: ");
                                                        ((StringBuilder)object2).append(((ExifTag)object3).name);
                                                        Log.d((String)string, (String)((StringBuilder)object2).toString());
                                                    }
                                                    break block39;
                                                }
                                                n3 = n5;
                                                if (n5 == 7) {
                                                    n3 = ((ExifTag)object3).primaryFormat;
                                                }
                                                l = n4;
                                                if ((l = (long)IFD_FORMAT_BYTES_PER_FORMAT[n3] * l) >= 0L && l <= Integer.MAX_VALUE) {
                                                    n5 = 1;
                                                } else {
                                                    if (DEBUG) {
                                                        object2 = new StringBuilder();
                                                        ((StringBuilder)object2).append("Skip the tag entry since the number of components is invalid: ");
                                                        ((StringBuilder)object2).append(n4);
                                                        Log.d((String)string, (String)((StringBuilder)object2).toString());
                                                    }
                                                    n5 = 0;
                                                }
                                                break block42;
                                            }
                                            if (DEBUG) {
                                                object2 = new StringBuilder();
                                                ((StringBuilder)object2).append("Skip the tag entry since data format is invalid: ");
                                                ((StringBuilder)object2).append(n5);
                                                Log.d((String)string, (String)((StringBuilder)object2).toString());
                                            }
                                        }
                                        n2 = 0;
                                        l = 0L;
                                        n3 = n5;
                                        n5 = n2;
                                    }
                                    if (n5 == 0) {
                                        object.seek(l2);
                                        continue;
                                    }
                                    if (l > 4L) {
                                        long l3;
                                        n5 = object.readInt();
                                        if (DEBUG) {
                                            object2 = new StringBuilder();
                                            ((StringBuilder)object2).append("seek to data offset: ");
                                            ((StringBuilder)object2).append(n5);
                                            Log.d((String)string, (String)((StringBuilder)object2).toString());
                                        }
                                        if (this.mMimeType == 7) {
                                            if ("MakerNote".equals(((ExifTag)object3).name)) {
                                                this.mOrfMakerNoteOffset = n5;
                                            } else if (n == 6 && "ThumbnailImage".equals(((ExifTag)object3).name)) {
                                                this.mOrfThumbnailOffset = n5;
                                                this.mOrfThumbnailLength = n4;
                                                stringBuilder = ExifAttribute.createUShort((int)6, (ByteOrder)this.mExifByteOrder);
                                                ExifAttribute exifAttribute = ExifAttribute.createULong((long)this.mOrfThumbnailOffset, (ByteOrder)this.mExifByteOrder);
                                                object2 = ExifAttribute.createULong((long)this.mOrfThumbnailLength, (ByteOrder)this.mExifByteOrder);
                                                this.mAttributes[4].put("Compression", (ExifAttribute)stringBuilder);
                                                this.mAttributes[4].put("JPEGInterchangeFormat", exifAttribute);
                                                this.mAttributes[4].put("JPEGInterchangeFormatLength", (ExifAttribute)object2);
                                            }
                                        }
                                        if ((l3 = (long)n5) + l <= (long)((ByteOrderedDataInputStream)object).mLength) {
                                            object.seek(l3);
                                        } else {
                                            if (DEBUG) {
                                                object2 = new StringBuilder();
                                                ((StringBuilder)object2).append("Skip the tag entry since data offset is invalid: ");
                                                ((StringBuilder)object2).append(n5);
                                                Log.d((String)string, (String)((StringBuilder)object2).toString());
                                            }
                                            object.seek(l2);
                                            continue;
                                        }
                                    }
                                    object2 = sExifPointerTagMap.get(n6);
                                    if (DEBUG) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append("nextIfdType: ");
                                        stringBuilder.append(object2);
                                        stringBuilder.append(" byteCount: ");
                                        stringBuilder.append(l);
                                        Log.d((String)string, (String)stringBuilder.toString());
                                    }
                                    if (object2 == null) break block43;
                                    l = -1L;
                                    if (n3 == 3) break block44;
                                    if (n3 == 4) break block45;
                                    if (n3 == 8) break block46;
                                    if (n3 != 9 && n3 != 13) break block47;
                                    n3 = object.readInt();
                                    break block48;
                                }
                                n3 = object.readShort();
                                break block48;
                            }
                            l = object.readUnsignedInt();
                            break block47;
                        }
                        n3 = object.readUnsignedShort();
                    }
                    l = n3;
                }
                if (DEBUG) {
                    Log.d((String)string, (String)String.format("Offset: %d, tagName: %s", l, ((ExifTag)object3).name));
                }
                if (l > 0L && l < (long)((ByteOrderedDataInputStream)object).mLength) {
                    if (!this.mAttributesOffsets.contains((int)l)) {
                        object.seek(l);
                        this.readImageFileDirectory((ByteOrderedDataInputStream)object, (Integer)object2);
                    } else if (DEBUG) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Skip jump into the IFD since it has already been read: IfdType ");
                        ((StringBuilder)object3).append(object2);
                        ((StringBuilder)object3).append(" (at ");
                        ((StringBuilder)object3).append(l);
                        ((StringBuilder)object3).append(")");
                        Log.d((String)string, (String)((StringBuilder)object3).toString());
                    }
                } else if (DEBUG) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Skip jump into the IFD since its offset is invalid: ");
                    ((StringBuilder)object2).append(l);
                    Log.d((String)string, (String)((StringBuilder)object2).toString());
                }
                object.seek(l2);
                continue;
            }
            n5 = object.peek();
            n2 = this.mOffsetToExifData;
            object2 = new byte[(int)l];
            object.readFully((byte[])object2);
            object2 = new ExifAttribute(n3, n4, (long)(n5 + n2), (byte[])object2);
            this.mAttributes[n].put(((ExifTag)object3).name, (ExifAttribute)object2);
            if ("DNGVersion".equals(((ExifTag)object3).name)) {
                this.mMimeType = 3;
            }
            if (("Make".equals(((ExifTag)object3).name) || "Model".equals(((ExifTag)object3).name)) && object2.getStringValue(this.mExifByteOrder).contains("PENTAX") || "Compression".equals(((ExifTag)object3).name) && object2.getIntValue(this.mExifByteOrder) == 65535) {
                this.mMimeType = 8;
            }
            if ((long)object.peek() == l2) continue;
            object.seek(l2);
        }
        if (object.peek() + 4 > ((ByteOrderedDataInputStream)object).mLength) return;
        n = object.readInt();
        if (DEBUG) {
            Log.d((String)string, (String)String.format("nextIfdOffset: %d", n));
        }
        if ((l = (long)n) > 0L && n < ((ByteOrderedDataInputStream)object).mLength) {
            if (!this.mAttributesOffsets.contains(n)) {
                object.seek(l);
                if (this.mAttributes[4].isEmpty()) {
                    this.readImageFileDirectory((ByteOrderedDataInputStream)object, 4);
                } else {
                    if (!this.mAttributes[5].isEmpty()) return;
                    this.readImageFileDirectory((ByteOrderedDataInputStream)object, 5);
                }
            } else {
                if (!DEBUG) return;
                object = new StringBuilder();
                ((StringBuilder)object).append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                ((StringBuilder)object).append(n);
                Log.d((String)string, (String)((StringBuilder)object).toString());
            }
        } else {
            if (!DEBUG) return;
            object = new StringBuilder();
            ((StringBuilder)object).append("Stop reading file since a wrong offset may cause an infinite loop: ");
            ((StringBuilder)object).append(n);
            Log.d((String)string, (String)((StringBuilder)object).toString());
        }
    }

    private void removeAttribute(String string) {
        int n = 0;
        while (n < EXIF_TAGS.length) {
            this.mAttributes[n].remove(string);
            ++n;
        }
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int n) throws IOException {
        ExifAttribute exifAttribute = this.mAttributes[n].get("ImageLength");
        Object object = this.mAttributes[n].get("ImageWidth");
        if (exifAttribute != null) {
            if (object != null) return;
        }
        exifAttribute = this.mAttributes[n].get("JPEGInterchangeFormat");
        object = this.mAttributes[n].get("JPEGInterchangeFormatLength");
        if (exifAttribute == null) return;
        if (object == null) return;
        int n2 = exifAttribute.getIntValue(this.mExifByteOrder);
        int n3 = exifAttribute.getIntValue(this.mExifByteOrder);
        byteOrderedDataInputStream.seek((long)n2);
        object = new byte[n3];
        byteOrderedDataInputStream.read((byte[])object);
        this.getJpegAttributes(new ByteOrderedDataInputStream((byte[])object), n2, n);
    }

    /*
     * Unable to fully structure code
     */
    private void saveJpegAttributes(InputStream var1_1, OutputStream var2_2) throws IOException {
        if (ExifInterface.DEBUG) {
            var5_3 = new StringBuilder();
            var5_3.append("saveJpegAttributes starting with (inputStream: ");
            var5_3.append(var1_1);
            var5_3.append(", outputStream: ");
            var5_3.append(var2_2);
            var5_3.append(")");
            Log.d((String)"ExifInterface", (String)var5_3.toString());
        }
        var5_3 = new DataInputStream((InputStream)var1_1);
        var6_4 = new ByteOrderedDataOutputStream((OutputStream)var2_2, ByteOrder.BIG_ENDIAN);
        if (var5_3.readByte() != -1) {
            var1_1 = new IOException("Invalid marker");
            throw var1_1;
        }
        var6_4.writeByte(-1);
        if (var5_3.readByte() != -40) throw new IOException("Invalid marker");
        var6_4.writeByte(-40);
        var1_1 = var2_2 = null;
        if (this.getAttribute("Xmp") != null) {
            var1_1 = var2_2;
            if (this.mXmpIsFromSeparateMarker) {
                var1_1 = this.mAttributes[0].remove("Xmp");
            }
        }
        var6_4.writeByte(-1);
        var6_4.writeByte(-31);
        this.writeExifSegment(var6_4);
        if (var1_1 != null) {
            this.mAttributes[0].put("Xmp", (ExifAttribute)var1_1);
        }
        var2_2 = new byte[4096];
        block0: while (true) {
            if (var5_3.readByte() != -1) throw new IOException("Invalid marker");
            var3_5 = var5_3.readByte();
            if (var3_5 == -39 || var3_5 == -38) break;
            if (var3_5 != -31) {
                var6_4.writeByte(-1);
                var6_4.writeByte(var3_5);
                var3_5 = var5_3.readUnsignedShort();
                var6_4.writeUnsignedShort(var3_5);
                if ((var3_5 -= 2) < 0) throw new IOException("Invalid length");
                while (true) {
                    if (var3_5 <= 0 || (var4_6 = var5_3.read((byte[])var2_2, 0, Math.min(var3_5, 4096))) < 0) continue block0;
                    var6_4.write((byte[])var2_2, 0, var4_6);
                    var3_5 -= var4_6;
                }
            }
            var4_6 = var5_3.readUnsignedShort() - 2;
            if (var4_6 < 0) throw new IOException("Invalid length");
            var1_1 = new byte[6];
            if (var4_6 >= 6) {
                if (var5_3.read((byte[])var1_1) != 6) throw new IOException("Invalid exif");
                if (Arrays.equals((byte[])var1_1, ExifInterface.IDENTIFIER_EXIF_APP1)) {
                    var3_5 = var4_6 - 6;
                    if (var5_3.skipBytes(var3_5) != var3_5) throw new IOException("Invalid length");
                    continue;
                }
            }
            var6_4.writeByte(-1);
            var6_4.writeByte(var3_5);
            var6_4.writeUnsignedShort(var4_6 + 2);
            var3_5 = var4_6;
            if (var4_6 >= 6) {
                var3_5 = var4_6 - 6;
                var6_4.write((byte[])var1_1);
            }
            while (true) {
                if (var3_5 > 0 && (var4_6 = var5_3.read((byte[])var2_2, 0, Math.min(var3_5, 4096))) >= 0) ** break;
                continue block0;
                var6_4.write((byte[])var2_2, 0, var4_6);
                var3_5 -= var4_6;
            }
            break;
        }
        var6_4.writeByte(-1);
        var6_4.writeByte(var3_5);
        ExifInterface.copy((InputStream)var5_3, (OutputStream)var6_4);
    }

    /*
     * WARNING - void declaration
     */
    private void savePngAttributes(InputStream inputStream, OutputStream object) throws IOException {
        void var1_4;
        block7: {
            Object object2;
            if (DEBUG) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("savePngAttributes starting with (inputStream: ");
                ((StringBuilder)object2).append(inputStream);
                ((StringBuilder)object2).append(", outputStream: ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(")");
                Log.d((String)"ExifInterface", (String)((StringBuilder)object2).toString());
            }
            inputStream = new DataInputStream(inputStream);
            ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream((OutputStream)object, ByteOrder.BIG_ENDIAN);
            ExifInterface.copy(inputStream, (OutputStream)byteOrderedDataOutputStream, PNG_SIGNATURE.length);
            int n = this.mOffsetToExifData;
            if (n == 0) {
                n = ((DataInputStream)inputStream).readInt();
                byteOrderedDataOutputStream.writeInt(n);
                ExifInterface.copy(inputStream, (OutputStream)byteOrderedDataOutputStream, n + 4 + 4);
            } else {
                ExifInterface.copy(inputStream, (OutputStream)byteOrderedDataOutputStream, n - PNG_SIGNATURE.length - 4 - 4);
                ((DataInputStream)inputStream).skipBytes(((DataInputStream)inputStream).readInt() + 4 + 4);
            }
            object2 = null;
            try {
                object = new ByteArrayOutputStream();
            }
            catch (Throwable throwable) {
                object = object2;
                break block7;
            }
            try {
                object2 = new ByteOrderedDataOutputStream((OutputStream)object, ByteOrder.BIG_ENDIAN);
                this.writeExifSegment((ByteOrderedDataOutputStream)object2);
                byte[] byArray = ((ByteArrayOutputStream)((ByteOrderedDataOutputStream)object2).mOutputStream).toByteArray();
                byteOrderedDataOutputStream.write(byArray);
                object2 = new CRC32();
                ((CRC32)object2).update(byArray, 4, byArray.length - 4);
                byteOrderedDataOutputStream.writeInt((int)((CRC32)object2).getValue());
            }
            catch (Throwable throwable) {
                break block7;
            }
            ExifInterface.closeQuietly((Closeable)object);
            ExifInterface.copy(inputStream, (OutputStream)byteOrderedDataOutputStream);
            return;
        }
        ExifInterface.closeQuietly((Closeable)object);
        throw var1_4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void saveWebpAttributes(InputStream var1_1, OutputStream var2_6) throws IOException {
        block22: {
            block23: {
                block19: {
                    block21: {
                        block20: {
                            block25: {
                                block24: {
                                    if (ExifInterface.DEBUG) {
                                        var10_7 = new StringBuilder();
                                        var10_7.append("saveWebpAttributes starting with (inputStream: ");
                                        var10_7.append(var1_1);
                                        var10_7.append(", outputStream: ");
                                        var10_7.append(var2_6);
                                        var10_7.append(")");
                                        Log.d((String)"ExifInterface", (String)var10_7.toString());
                                    }
                                    var13_9 = new ByteOrderedDataInputStream((InputStream)var1_1, ByteOrder.LITTLE_ENDIAN);
                                    var14_10 = new ByteOrderedDataOutputStream((OutputStream)var2_6, ByteOrder.LITTLE_ENDIAN);
                                    ExifInterface.copy((InputStream)var13_9, (OutputStream)var14_10, ExifInterface.WEBP_SIGNATURE_1.length);
                                    var13_9.skipBytes(ExifInterface.WEBP_SIGNATURE_2.length + 4);
                                    var11_11 = null;
                                    var12_12 = null;
                                    var2_6 = var12_12;
                                    var2_6 = var12_12;
                                    var10_7 = new ByteArrayOutputStream();
                                    var2_6 = new ByteOrderedDataOutputStream((OutputStream)var10_7, ByteOrder.LITTLE_ENDIAN);
                                    if (this.mOffsetToExifData == 0) break block24;
                                    var3_13 = ExifInterface.WEBP_SIGNATURE_1.length;
                                    var4_16 = ExifInterface.WEBP_SIGNATURE_2.length;
                                    ExifInterface.copy((InputStream)var13_9, (OutputStream)var2_6, this.mOffsetToExifData - (var3_13 + 4 + var4_16) - 4 - 4);
                                    var13_9.skipBytes(4);
                                    var13_9.skipBytes(var13_9.readInt());
                                    this.writeExifSegment((ByteOrderedDataOutputStream)var2_6);
                                    ** GOTO lbl135
                                }
                                var11_11 = new byte[4];
                                if (var13_9.read((byte[])var11_11) != 4) break block19;
                                var9_19 = Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_VP8X);
                                var5_20 = 1;
                                if (!var9_19) ** GOTO lbl74
                                var4_17 = var13_9.readInt();
                                var3_14 = var4_17 % 2 == 1 ? var4_17 + 1 : var4_17;
                                var11_11 = new byte[var3_14];
                                var13_9.read((byte[])var11_11);
                                var11_11[0] = (byte)(8 | var11_11[0]);
                                var3_14 = (var11_11[0] >> 1 & 1) == 1 ? var5_20 : 0;
                                var2_6.write(ExifInterface.WEBP_CHUNK_TYPE_VP8X);
                                var2_6.writeInt(var4_17);
                                var2_6.write((byte[])var11_11);
                                if (var3_14 == 0) break block25;
                                this.copyChunksUpToGivenChunkType(var13_9, (ByteOrderedDataOutputStream)var2_6, ExifInterface.WEBP_CHUNK_TYPE_ANIM, null);
                                while (true) {
                                    block26: {
                                        var11_11 = new byte[4];
                                        var1_1.read((byte[])var11_11);
                                        if (Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_ANMF)) break block26;
                                        this.writeExifSegment((ByteOrderedDataOutputStream)var2_6);
                                        ** GOTO lbl135
                                    }
                                    this.copyWebPChunk(var13_9, (ByteOrderedDataOutputStream)var2_6, (byte[])var11_11);
                                }
                            }
                            this.copyChunksUpToGivenChunkType(var13_9, (ByteOrderedDataOutputStream)var2_6, ExifInterface.WEBP_CHUNK_TYPE_VP8, ExifInterface.WEBP_CHUNK_TYPE_VP8L);
                            this.writeExifSegment((ByteOrderedDataOutputStream)var2_6);
                            ** GOTO lbl135
lbl74:
                            // 1 sources

                            if (!Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_VP8) && !Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_VP8L)) ** GOTO lbl135
                            var8_21 = var13_9.readInt();
                            var3_15 = var8_21 % 2 == 1 ? var8_21 + 1 : var8_21;
                            var1_1 = new byte[3];
                            if (!Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_VP8)) ** GOTO lbl93
                            var13_9.read((byte[])var1_1);
                            var12_12 = new byte[3];
                            if (var13_9.read(var12_12) != 3 || !Arrays.equals(ExifInterface.WEBP_VP8_SIGNATURE, var12_12)) break block20;
                            var4_18 = var13_9.readInt();
                            var5_20 = var4_18 << 18 >> 18;
                            var6_22 = var4_18 << 2 >> 18;
                            var3_15 -= 10;
                            ** GOTO lbl108
                        }
                        var1_1 = new IOException("Encountered error while checking VP8 signature");
                        throw var1_1;
lbl93:
                        // 1 sources

                        if (!Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_VP8L)) ** GOTO lbl105
                        if (var13_9.readByte() != 47) break block21;
                        var4_18 = var13_9.readInt();
                        var7_23 = var4_18 & 8;
                        var3_15 -= 5;
                        var6_22 = (var4_18 << 4 >> 18) + 1;
                        var5_20 = (var4_18 << 18 >> 18) + 1;
                        ** GOTO lbl109
                    }
                    var1_1 = new IOException("Encountered error while checking VP8L signature");
                    throw var1_1;
lbl105:
                    // 1 sources

                    var4_18 = 0;
                    var5_20 = 0;
                    var6_22 = 0;
lbl108:
                    // 2 sources

                    var7_23 = 0;
lbl109:
                    // 2 sources

                    var2_6.write(ExifInterface.WEBP_CHUNK_TYPE_VP8X);
                    var2_6.writeInt(10);
                    var12_12 = new byte[10];
                    var12_12[0] = (byte)(var12_12[0] | 8);
                    var12_12[0] = (byte)(var12_12[0] | var7_23 << 4);
                    var12_12[4] = (byte)(--var5_20);
                    var12_12[5] = (byte)(var5_20 >> 8);
                    var12_12[6] = (byte)(var5_20 >> 16);
                    var12_12[7] = (byte)(--var6_22);
                    var12_12[8] = (byte)(var6_22 >> 8);
                    var12_12[9] = (byte)(var6_22 >> 16);
                    var2_6.write(var12_12);
                    var2_6.write((byte[])var11_11);
                    var2_6.writeInt(var8_21);
                    if (Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_VP8)) {
                        var2_6.write((byte[])var1_1);
                        var2_6.write(ExifInterface.WEBP_VP8_SIGNATURE);
                        var2_6.writeInt(var4_18);
                    } else if (Arrays.equals((byte[])var11_11, ExifInterface.WEBP_CHUNK_TYPE_VP8L)) {
                        var2_6.write(47);
                        var2_6.writeInt(var4_18);
                    }
                    ExifInterface.copy((InputStream)var13_9, (OutputStream)var2_6, var3_15);
                    this.writeExifSegment((ByteOrderedDataOutputStream)var2_6);
lbl135:
                    // 5 sources

                    ExifInterface.copy((InputStream)var13_9, (OutputStream)var2_6);
                    var14_10.writeInt(var10_7.size() + ExifInterface.WEBP_SIGNATURE_2.length);
                    var14_10.write(ExifInterface.WEBP_SIGNATURE_2);
                    var10_7.writeTo((OutputStream)var14_10);
                    ExifInterface.closeQuietly((Closeable)var10_7);
                    return;
                }
                try {
                    var1_1 = new IOException("Encountered invalid length while parsing WebP chunk type");
                    throw var1_1;
                }
                catch (Throwable var1_2) {
                    var2_6 = var10_7;
                    break block22;
                }
                catch (Exception var1_3) {
                    var2_6 = var10_7;
                    var10_7 = var1_3;
                    var1_1 = var2_6;
                    break block23;
                }
                catch (Throwable var1_4) {
                    break block22;
                }
                catch (Exception var10_8) {
                    var1_1 = var11_11;
                }
            }
            var2_6 = var1_1;
            {
                var2_6 = var1_1;
                var11_11 = new IOException("Failed to save WebP file", (Throwable)var10_7);
                var2_6 = var1_1;
                throw var11_11;
            }
        }
        ExifInterface.closeQuietly((Closeable)var2_6);
        throw var1_5;
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        block3: {
            HashMap<String, ExifAttribute> hashMap;
            block0: {
                block1: {
                    block2: {
                        int n;
                        hashMap = this.mAttributes[4];
                        ExifAttribute exifAttribute = hashMap.get("Compression");
                        if (exifAttribute == null) break block0;
                        this.mThumbnailCompression = n = exifAttribute.getIntValue(this.mExifByteOrder);
                        if (n == 1) break block1;
                        if (n == 6) break block2;
                        if (n == 7) break block1;
                        break block3;
                    }
                    this.handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    break block3;
                }
                if (!this.isSupportedDataType(hashMap)) return;
                this.handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                break block3;
            }
            this.mThumbnailCompression = 6;
            this.handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
        }
    }

    private static boolean startsWith(byte[] byArray, byte[] byArray2) {
        if (byArray == null) return false;
        if (byArray2 == null) {
            return false;
        }
        if (byArray.length < byArray2.length) {
            return false;
        }
        int n = 0;
        while (n < byArray2.length) {
            if (byArray[n] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private void swapBasedOnImageSize(int n, int n2) throws IOException {
        if (!this.mAttributes[n].isEmpty() && !this.mAttributes[n2].isEmpty()) {
            HashMap<String, ExifAttribute>[] hashMapArray = this.mAttributes[n].get("ImageLength");
            ExifAttribute exifAttribute = this.mAttributes[n].get("ImageWidth");
            Object object = this.mAttributes[n2].get("ImageLength");
            ExifAttribute exifAttribute2 = this.mAttributes[n2].get("ImageWidth");
            if (hashMapArray != null && exifAttribute != null) {
                if (object != null && exifAttribute2 != null) {
                    int n3 = hashMapArray.getIntValue(this.mExifByteOrder);
                    int n4 = exifAttribute.getIntValue(this.mExifByteOrder);
                    int n5 = object.getIntValue(this.mExifByteOrder);
                    int n6 = exifAttribute2.getIntValue(this.mExifByteOrder);
                    if (n3 >= n5) return;
                    if (n4 >= n6) return;
                    hashMapArray = this.mAttributes;
                    object = hashMapArray[n];
                    hashMapArray[n] = hashMapArray[n2];
                    hashMapArray[n2] = object;
                } else {
                    if (!DEBUG) return;
                    Log.d((String)"ExifInterface", (String)"Second image does not contain valid size information");
                }
            } else {
                if (!DEBUG) return;
                Log.d((String)"ExifInterface", (String)"First image does not contain valid size information");
            }
            return;
        }
        if (!DEBUG) return;
        Log.d((String)"ExifInterface", (String)"Cannot perform swap since only one image data exists");
    }

    /*
     * Enabled force condition propagation
     */
    private void updateImageSizeValues(ByteOrderedDataInputStream objectArray, int n) throws IOException {
        ExifAttribute exifAttribute;
        Object object;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3;
        block4: {
            block8: {
                block7: {
                    ExifAttribute exifAttribute4;
                    block5: {
                        block6: {
                            exifAttribute4 = this.mAttributes[n].get("DefaultCropSize");
                            exifAttribute3 = this.mAttributes[n].get("SensorTopBorder");
                            exifAttribute2 = this.mAttributes[n].get("SensorLeftBorder");
                            object = this.mAttributes[n].get("SensorBottomBorder");
                            exifAttribute = this.mAttributes[n].get("SensorRightBorder");
                            if (exifAttribute4 == null) break block4;
                            if (exifAttribute4.format != 5) break block5;
                            objectArray = (Rational[])exifAttribute4.getValue(this.mExifByteOrder);
                            if (objectArray == null || objectArray.length != 2) break block6;
                            object = ExifAttribute.createURational((Rational)objectArray[0], (ByteOrder)this.mExifByteOrder);
                            objectArray = ExifAttribute.createURational((Rational)objectArray[1], (ByteOrder)this.mExifByteOrder);
                            break block7;
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Invalid crop size values. cropSize=");
                        ((StringBuilder)object).append(Arrays.toString(objectArray));
                        Log.w((String)"ExifInterface", (String)((StringBuilder)object).toString());
                        return;
                    }
                    objectArray = (int[])exifAttribute4.getValue(this.mExifByteOrder);
                    if (objectArray == null || objectArray.length != 2) break block8;
                    object = ExifAttribute.createUShort((int)objectArray[0], (ByteOrder)this.mExifByteOrder);
                    objectArray = ExifAttribute.createUShort((int)objectArray[1], (ByteOrder)this.mExifByteOrder);
                }
                this.mAttributes[n].put("ImageWidth", (ExifAttribute)object);
                this.mAttributes[n].put("ImageLength", (ExifAttribute)objectArray);
                return;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid crop size values. cropSize=");
            ((StringBuilder)object).append(Arrays.toString((int[])objectArray));
            Log.w((String)"ExifInterface", (String)((StringBuilder)object).toString());
            return;
        }
        if (exifAttribute3 != null && exifAttribute2 != null && object != null && exifAttribute != null) {
            int n2 = exifAttribute3.getIntValue(this.mExifByteOrder);
            int n3 = object.getIntValue(this.mExifByteOrder);
            int n4 = exifAttribute.getIntValue(this.mExifByteOrder);
            int n5 = exifAttribute2.getIntValue(this.mExifByteOrder);
            if (n3 <= n2) return;
            if (n4 <= n5) return;
            object = ExifAttribute.createUShort((int)(n3 - n2), (ByteOrder)this.mExifByteOrder);
            objectArray = ExifAttribute.createUShort((int)(n4 - n5), (ByteOrder)this.mExifByteOrder);
            this.mAttributes[n].put("ImageLength", (ExifAttribute)object);
            this.mAttributes[n].put("ImageWidth", (ExifAttribute)objectArray);
            return;
        }
        this.retrieveJpegImageSize((ByteOrderedDataInputStream)objectArray, n);
    }

    private void validateImages() throws IOException {
        this.swapBasedOnImageSize(0, 5);
        this.swapBasedOnImageSize(0, 4);
        this.swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get("PixelXDimension");
        HashMap<String, ExifAttribute>[] hashMapArray = this.mAttributes[1].get("PixelYDimension");
        if (exifAttribute != null && hashMapArray != null) {
            this.mAttributes[0].put("ImageWidth", exifAttribute);
            this.mAttributes[0].put("ImageLength", (ExifAttribute)hashMapArray);
        }
        if (this.mAttributes[4].isEmpty() && this.isThumbnail(this.mAttributes[5])) {
            hashMapArray = this.mAttributes;
            hashMapArray[4] = hashMapArray[5];
            hashMapArray[5] = new HashMap();
        }
        if (this.isThumbnail(this.mAttributes[4])) return;
        Log.d((String)"ExifInterface", (String)"No image meets the size requirements of a thumbnail image.");
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        int n;
        int n2;
        Object object = EXIF_TAGS;
        int[] nArray = new int[((ExifTag[][])object).length];
        object = new int[((ExifTag[][])object).length];
        ExifTag[] object22 = EXIF_POINTER_TAGS;
        int n3 = object22.length;
        for (n2 = 0; n2 < n3; ++n2) {
            this.removeAttribute(object22[n2].name);
        }
        this.removeAttribute(ExifInterface.JPEG_INTERCHANGE_FORMAT_TAG.name);
        this.removeAttribute(ExifInterface.JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        for (n2 = 0; n2 < EXIF_TAGS.length; ++n2) {
            Object[] objectArray = this.mAttributes[n2].entrySet().toArray();
            n = objectArray.length;
            for (n3 = 0; n3 < n; ++n3) {
                Map.Entry entry = (Map.Entry)objectArray[n3];
                if (entry.getValue() != null) continue;
                this.mAttributes[n2].remove(entry.getKey());
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(ExifInterface.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(ExifInterface.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(ExifInterface.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(ExifInterface.JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong((long)0L, (ByteOrder)this.mExifByteOrder));
            this.mAttributes[4].put(ExifInterface.JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong((long)this.mThumbnailLength, (ByteOrder)this.mExifByteOrder));
        }
        for (n2 = 0; n2 < EXIF_TAGS.length; ++n2) {
            Iterator<Map.Entry<String, ExifAttribute>> iterator = this.mAttributes[n2].entrySet().iterator();
            n3 = 0;
            while (iterator.hasNext()) {
                n = iterator.next().getValue().size();
                if (n <= 4) continue;
                n3 += n;
            }
            object[n2] = object[n2] + n3;
        }
        n2 = 8;
        for (n3 = 0; n3 < EXIF_TAGS.length; ++n3) {
            n = n2;
            if (!this.mAttributes[n3].isEmpty()) {
                nArray[n3] = n2;
                n = n2 + (this.mAttributes[n3].size() * 12 + 2 + 4 + object[n3]);
            }
            n2 = n;
        }
        n3 = n2;
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(ExifInterface.JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong((long)n2, (ByteOrder)this.mExifByteOrder));
            this.mThumbnailOffset = n2;
            n3 = n2 + this.mThumbnailLength;
        }
        n2 = n3;
        if (this.mMimeType == 4) {
            n2 = n3 + 8;
        }
        if (DEBUG) {
            for (n3 = 0; n3 < EXIF_TAGS.length; ++n3) {
                Log.d((String)"ExifInterface", (String)String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", n3, nArray[n3], this.mAttributes[n3].size(), (int)object[n3], n2));
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(ExifInterface.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long)nArray[1], (ByteOrder)this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(ExifInterface.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long)nArray[2], (ByteOrder)this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(ExifInterface.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long)nArray[3], (ByteOrder)this.mExifByteOrder));
        }
        if ((n3 = this.mMimeType) != 4) {
            if (n3 != 13) {
                if (n3 == 14) {
                    byteOrderedDataOutputStream.write(WEBP_CHUNK_TYPE_EXIF);
                    byteOrderedDataOutputStream.writeInt(n2);
                }
            } else {
                byteOrderedDataOutputStream.writeInt(n2);
                byteOrderedDataOutputStream.write(PNG_CHUNK_TYPE_EXIF);
            }
        } else {
            byteOrderedDataOutputStream.writeUnsignedShort(n2);
            byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        }
        short s = this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? (short)19789 : 18761;
        byteOrderedDataOutputStream.writeShort(s);
        byteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (n3 = 0; n3 < EXIF_TAGS.length; ++n3) {
            if (this.mAttributes[n3].isEmpty()) continue;
            byteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[n3].size());
            n = nArray[n3] + 2 + this.mAttributes[n3].size() * 12 + 4;
            for (Map.Entry entry : this.mAttributes[n3].entrySet()) {
                int n4;
                int n5 = ExifInterface.sExifTagMapsForWriting[n3].get(entry.getKey()).number;
                ExifAttribute exifAttribute = (ExifAttribute)entry.getValue();
                byteOrderedDataOutputStream.writeUnsignedShort(n5);
                byteOrderedDataOutputStream.writeUnsignedShort(exifAttribute.format);
                byteOrderedDataOutputStream.writeInt(exifAttribute.numberOfComponents);
                if (n4 > 4) {
                    byteOrderedDataOutputStream.writeUnsignedInt((long)n);
                    n += n4;
                    continue;
                }
                byteOrderedDataOutputStream.write(exifAttribute.bytes);
                if (n4 >= 4) continue;
                for (n4 = exifAttribute.size(); n4 < 4; ++n4) {
                    byteOrderedDataOutputStream.writeByte(0);
                }
            }
            if (n3 == 0 && !this.mAttributes[4].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedInt((long)nArray[4]);
            } else {
                byteOrderedDataOutputStream.writeUnsignedInt(0L);
            }
            object = this.mAttributes[n3].entrySet().iterator();
            while (object.hasNext()) {
                ExifAttribute exifAttribute = (ExifAttribute)((Map.Entry)object.next()).getValue();
                if (exifAttribute.bytes.length <= 4) continue;
                byteOrderedDataOutputStream.write(exifAttribute.bytes, 0, exifAttribute.bytes.length);
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream.write(this.getThumbnailBytes());
        }
        if (this.mMimeType == 14 && n2 % 2 == 1) {
            byteOrderedDataOutputStream.writeByte(0);
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        return n2;
    }

    public void flipHorizontally() {
        int n = 1;
        switch (this.getAttributeInt("Orientation", 1)) {
            default: {
                n = 0;
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
            case 1: {
                n = 2;
                break;
            }
            case 2: 
        }
        this.setAttribute("Orientation", Integer.toString(n));
    }

    public void flipVertically() {
        int n = 1;
        switch (this.getAttributeInt("Orientation", 1)) {
            default: {
                n = 0;
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
            case 3: {
                n = 2;
                break;
            }
            case 2: {
                n = 3;
                break;
            }
            case 1: {
                n = 4;
                break;
            }
            case 4: 
        }
        this.setAttribute("Orientation", Integer.toString(n));
    }

    public double getAltitude(double d) {
        double d2 = this.getAttributeDouble("GPSAltitude", -1.0);
        int n = -1;
        int n2 = this.getAttributeInt("GPSAltitudeRef", -1);
        if (!(d2 >= 0.0)) return d;
        if (n2 < 0) return d;
        if (n2 != 1) {
            n = 1;
        }
        d = n;
        Double.isNaN(d);
        return d2 * d;
    }

    public String getAttribute(String object) {
        if (object == null) throw new NullPointerException("tag shouldn't be null");
        Object object2 = this.getExifAttribute((String)object);
        if (object2 == null) return null;
        if (!sTagSetForCompatibility.contains(object)) {
            return object2.getStringValue(this.mExifByteOrder);
        }
        if (((String)object).equals("GPSTimeStamp")) {
            if (((ExifAttribute)object2).format != 5 && ((ExifAttribute)object2).format != 10) {
                object = new StringBuilder();
                ((StringBuilder)object).append("GPS Timestamp format is not rational. format=");
                ((StringBuilder)object).append(((ExifAttribute)object2).format);
                Log.w((String)"ExifInterface", (String)((StringBuilder)object).toString());
                return null;
            }
            object = (Rational[])object2.getValue(this.mExifByteOrder);
            if (object != null && ((Rational[])object).length == 3) {
                return String.format("%02d:%02d:%02d", (int)((float)((Rational)object[0]).numerator / (float)((Rational)object[0]).denominator), (int)((float)((Rational)object[1]).numerator / (float)((Rational)object[1]).denominator), (int)((float)((Rational)object[2]).numerator / (float)((Rational)object[2]).denominator));
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Invalid GPS Timestamp array. array=");
            ((StringBuilder)object2).append(Arrays.toString((Object[])object));
            Log.w((String)"ExifInterface", (String)((StringBuilder)object2).toString());
            return null;
        }
        try {
            object = Double.toString(object2.getDoubleValue(this.mExifByteOrder));
            return object;
        }
        catch (NumberFormatException numberFormatException) {
        }
        return null;
    }

    public byte[] getAttributeBytes(String string) {
        if (string == null) throw new NullPointerException("tag shouldn't be null");
        if ((string = this.getExifAttribute(string)) == null) return null;
        return ((ExifAttribute)string).bytes;
    }

    public double getAttributeDouble(String string, double d) {
        if (string == null) throw new NullPointerException("tag shouldn't be null");
        if ((string = this.getExifAttribute(string)) == null) {
            return d;
        }
        try {
            double d2 = string.getDoubleValue(this.mExifByteOrder);
            return d2;
        }
        catch (NumberFormatException numberFormatException) {
            return d;
        }
    }

    public int getAttributeInt(String string, int n) {
        if (string == null) throw new NullPointerException("tag shouldn't be null");
        if ((string = this.getExifAttribute(string)) == null) {
            return n;
        }
        try {
            int n2 = string.getIntValue(this.mExifByteOrder);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public long[] getAttributeRange(String string) {
        if (string == null) throw new NullPointerException("tag shouldn't be null");
        if (this.mModified) throw new IllegalStateException("The underlying file has been modified since being parsed");
        if ((string = this.getExifAttribute(string)) == null) return null;
        return new long[]{((ExifAttribute)string).bytesOffset, ((ExifAttribute)string).bytes.length};
    }

    public Long getDateTime() {
        return ExifInterface.parseDateTime(this.getAttribute("DateTime"), this.getAttribute("SubSecTime"), this.getAttribute("OffsetTime"));
    }

    public Long getDateTimeDigitized() {
        return ExifInterface.parseDateTime(this.getAttribute("DateTimeDigitized"), this.getAttribute("SubSecTimeDigitized"), this.getAttribute("OffsetTimeDigitized"));
    }

    public Long getDateTimeOriginal() {
        return ExifInterface.parseDateTime(this.getAttribute("DateTimeOriginal"), this.getAttribute("SubSecTimeOriginal"), this.getAttribute("OffsetTimeOriginal"));
    }

    public Long getGpsDateTime() {
        block4: {
            long l;
            Object object = this.getAttribute("GPSDateStamp");
            Object object2 = this.getAttribute("GPSTimeStamp");
            if (object == null) return null;
            if (object2 == null) return null;
            if (!NON_ZERO_TIME_PATTERN.matcher((CharSequence)object).matches() && !NON_ZERO_TIME_PATTERN.matcher((CharSequence)object2).matches()) return null;
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(' ');
            ((StringBuilder)object3).append((String)object2);
            String string = ((StringBuilder)object3).toString();
            object3 = new ParsePosition(0);
            try {
                object = object2 = sFormatterPrimary.parse(string, (ParsePosition)object3);
                if (object2 == null) {
                    object = object2 = sFormatterSecondary.parse(string, (ParsePosition)object3);
                    if (object2 == null) {
                        return null;
                    }
                }
                l = ((Date)object).getTime();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                break block4;
            }
            return l;
        }
        return null;
    }

    @Deprecated
    public boolean getLatLong(float[] fArray) {
        double[] dArray = this.getLatLong();
        if (dArray == null) {
            return false;
        }
        fArray[0] = (float)dArray[0];
        fArray[1] = (float)dArray[1];
        return true;
    }

    public double[] getLatLong() {
        block2: {
            double d;
            double d2;
            String string = this.getAttribute("GPSLatitude");
            String string2 = this.getAttribute("GPSLatitudeRef");
            String string3 = this.getAttribute("GPSLongitude");
            String string4 = this.getAttribute("GPSLongitudeRef");
            if (string == null) return null;
            if (string2 == null) return null;
            if (string3 == null) return null;
            if (string4 == null) return null;
            try {
                d2 = ExifInterface.convertRationalLatLonToDouble(string, string2);
                d = ExifInterface.convertRationalLatLonToDouble(string3, string4);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Latitude/longitude values are not parsable. ");
                stringBuilder.append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", string, string2, string3, string4));
                Log.w((String)"ExifInterface", (String)stringBuilder.toString());
                break block2;
            }
            return new double[]{d2, d};
        }
        return null;
    }

    public int getRotationDegrees() {
        switch (this.getAttributeInt("Orientation", 1)) {
            default: {
                return 0;
            }
            case 6: 
            case 7: {
                return 90;
            }
            case 5: 
            case 8: {
                return 270;
            }
            case 3: 
            case 4: 
        }
        return 180;
    }

    public byte[] getThumbnail() {
        int n = this.mThumbnailCompression;
        if (n == 6) return this.getThumbnailBytes();
        if (n != 7) return null;
        return this.getThumbnailBytes();
    }

    public Bitmap getThumbnailBitmap() {
        int n;
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = this.getThumbnailBytes();
        }
        if ((n = this.mThumbnailCompression) == 6) return BitmapFactory.decodeByteArray((byte[])this.mThumbnailBytes, (int)0, (int)this.mThumbnailLength);
        if (n == 7) {
            return BitmapFactory.decodeByteArray((byte[])this.mThumbnailBytes, (int)0, (int)this.mThumbnailLength);
        }
        if (n != 1) return null;
        int n2 = this.mThumbnailBytes.length / 3;
        int[] nArray = new int[n2];
        n = 0;
        while (true) {
            Object object;
            if (n >= n2) {
                object = this.mAttributes[4].get("ImageLength");
                ExifAttribute exifAttribute = this.mAttributes[4].get("ImageWidth");
                if (object == null) return null;
                if (exifAttribute == null) return null;
                n = object.getIntValue(this.mExifByteOrder);
                return Bitmap.createBitmap((int[])nArray, (int)exifAttribute.getIntValue(this.mExifByteOrder), (int)n, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            }
            object = this.mThumbnailBytes;
            int n3 = n * 3;
            nArray[n] = (object[n3] << 16) + 0 + (object[n3 + 1] << 8) + object[n3 + 2];
            ++n;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public byte[] getThumbnailBytes() {
        block23: {
            block24: {
                block22: {
                    var3_1 = this.mHasThumbnail;
                    var8_2 = null;
                    if (!var3_1) {
                        return null;
                    }
                    var6_8 /* !! */  = this.mThumbnailBytes;
                    if (var6_8 /* !! */  != null) {
                        return var6_8 /* !! */ ;
                    }
                    if (this.mAssetInputStream == null) break block22;
                    var7_12 = this.mAssetInputStream;
                    try {
                        if (var7_12.markSupported()) {
                            var7_12.reset();
lbl14:
                            // 2 sources

                            while (true) {
                                var6_8 /* !! */  = null;
                                break block23;
                                break;
                            }
                        }
                        Log.d((String)"ExifInterface", (String)"Cannot read thumbnail from inputstream without mark/reset support");
                    }
                    catch (Throwable var6_9) {
                        var10_14 = null;
                    }
                    ExifInterface.closeQuietly((Closeable)var7_12);
                    return null;
lbl23:
                    // 4 sources

                    while (true) {
                        ExifInterface.closeQuietly((Closeable)var7_12);
                        if (var10_14 == null) throw var6_8 /* !! */ ;
                        ExifInterface.closeFileDescriptor((FileDescriptor)var10_14);
                        throw var6_8 /* !! */ ;
                    }
                    catch (Exception var8_3) {
                        var6_8 /* !! */  = null;
                        ** GOTO lbl119
                    }
                }
                if (this.mFilename != null) {
                    var7_12 = new FileInputStream(this.mFilename);
                    ** continue;
                }
                if (Build.VERSION.SDK_INT < 21) break block24;
                var6_8 /* !! */  = (byte[])Os.dup((FileDescriptor)this.mSeekableFileDescriptor);
                try {
                    Os.lseek((FileDescriptor)var6_8 /* !! */ , (long)0L, (int)OsConstants.SEEK_SET);
                    var7_12 = new FileInputStream((FileDescriptor)var6_8 /* !! */ );
                    break block23;
                }
                catch (Throwable var7_13) {
                    var10_14 = var6_8 /* !! */ ;
                    var6_8 /* !! */  = (byte[])var7_13;
                    var7_12 = var8_2;
                    ** GOTO lbl23
                }
                catch (Exception var8_4) {
                    var7_12 = null;
                    ** GOTO lbl119
                }
            }
            var7_12 = null;
            var6_8 /* !! */  = null;
        }
        if (var7_12 == null) ** GOTO lbl111
        var9_16 /* !! */  = var7_12;
        var10_14 = var6_8 /* !! */ ;
        ** try [egrp 4[TRYBLOCK] [12, 13 : 201->306)] { 
lbl59:
        // 1 sources

        ** GOTO lbl71
lbl60:
        // 1 sources

        catch (Throwable var6_11) {
            var7_12 = var9_16 /* !! */ ;
            ** GOTO lbl23
        }
        {
            block25: {
                catch (Throwable var6_10) {
                    var10_14 = null;
                    var7_12 = var8_2;
                    ** continue;
                }
                catch (Exception var8_6) {
                    var7_12 = null;
                    var6_8 /* !! */  = null;
                    break block25;
                }
lbl71:
                // 1 sources

                var4_18 = var7_12.skip(this.mThumbnailOffset + this.mOffsetToExifData);
                var9_16 /* !! */  = var7_12;
                var10_14 = var6_8 /* !! */ ;
                var2_19 = this.mThumbnailOffset;
                var9_16 /* !! */  = var7_12;
                var10_14 = var6_8 /* !! */ ;
                var1_20 = this.mOffsetToExifData;
                if (var4_18 != (long)(var2_19 + var1_20)) ** GOTO lbl101
                var9_16 /* !! */  = var7_12;
                var10_14 = var6_8 /* !! */ ;
                var8_2 = new byte[this.mThumbnailLength];
                var9_16 /* !! */  = var7_12;
                var10_14 = var6_8 /* !! */ ;
                if (var7_12.read((byte[])var8_2) == this.mThumbnailLength) {
                    var9_16 /* !! */  = var7_12;
                    var10_14 = var6_8 /* !! */ ;
                    this.mThumbnailBytes = (byte[])var8_2;
                    ExifInterface.closeQuietly((Closeable)var7_12);
                    if (var6_8 /* !! */  == null) return var8_2;
                    ExifInterface.closeFileDescriptor((FileDescriptor)var6_8 /* !! */ );
                    return var8_2;
                }
                var9_16 /* !! */  = var7_12;
                var10_14 = var6_8 /* !! */ ;
                try {
                    var9_16 /* !! */  = var7_12;
                    var10_14 = var6_8 /* !! */ ;
                    var8_2 = new IOException("Corrupted image");
                    var9_16 /* !! */  = var7_12;
                    var10_14 = var6_8 /* !! */ ;
                    throw var8_2;
lbl101:
                    // 1 sources

                    var9_16 /* !! */  = var7_12;
                    var10_14 = var6_8 /* !! */ ;
                    var9_16 /* !! */  = var7_12;
                    var10_14 = var6_8 /* !! */ ;
                    var8_2 = new IOException("Corrupted image");
                    var9_16 /* !! */  = var7_12;
                    var10_14 = var6_8 /* !! */ ;
                    throw var8_2;
                }
lbl109:
                // 2 sources

                catch (Exception var8_5) {}
                break block25;
lbl111:
                // 1 sources

                var9_17 = var7_12;
                var10_15 /* !! */  = var6_8 /* !! */ ;
                var9_17 = var7_12;
                var10_15 /* !! */  = var6_8 /* !! */ ;
                var8_2 = new FileNotFoundException();
                var9_17 = var7_12;
                var10_15 /* !! */  = var6_8 /* !! */ ;
                throw var8_2;
            }
            var9_16 /* !! */  = var7_12;
            var10_14 = var6_8 /* !! */ ;
            Log.d((String)"ExifInterface", (String)"Encountered exception while getting thumbnail", (Throwable)var8_7);
        }
        ExifInterface.closeQuietly((Closeable)var7_12);
        if (var6_8 /* !! */  == null) return null;
        ExifInterface.closeFileDescriptor((FileDescriptor)var6_8 /* !! */ );
        return null;
    }

    public long[] getThumbnailRange() {
        if (this.mModified) throw new IllegalStateException("The underlying file has been modified since being parsed");
        if (!this.mHasThumbnail) return null;
        if (!this.mHasThumbnailStrips || this.mAreThumbnailStripsConsecutive) return new long[]{this.mThumbnailOffset + this.mOffsetToExifData, this.mThumbnailLength};
        return null;
    }

    public boolean hasAttribute(String string) {
        boolean bl = this.getExifAttribute(string) != null;
        return bl;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        boolean bl = true;
        int n = this.getAttributeInt("Orientation", 1);
        boolean bl2 = bl;
        if (n == 2) return bl2;
        bl2 = bl;
        if (n == 7) return bl2;
        bl2 = bl;
        if (n == 4) return bl2;
        bl2 = bl;
        if (n == 5) return bl2;
        bl2 = false;
        return bl2;
    }

    public boolean isThumbnailCompressed() {
        if (!this.mHasThumbnail) {
            return false;
        }
        int n = this.mThumbnailCompression;
        if (n == 6) return true;
        if (n != 7) return false;
        return true;
    }

    public void resetOrientation() {
        this.setAttribute("Orientation", Integer.toString(1));
    }

    public void rotate(int n) {
        if (n % 90 != 0) throw new IllegalArgumentException("degree should be a multiple of 90");
        int n2 = this.getAttributeInt("Orientation", 1);
        boolean bl = ROTATION_ORDER.contains(n2);
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        if (bl) {
            n3 = (ROTATION_ORDER.indexOf(n2) + n / 90) % 4;
            n = n5;
            if (n3 < 0) {
                n = 4;
            }
            n5 = ROTATION_ORDER.get(n3 + n);
        } else {
            n5 = n4;
            if (FLIPPED_ROTATION_ORDER.contains(n2)) {
                n5 = (FLIPPED_ROTATION_ORDER.indexOf(n2) + n / 90) % 4;
                n = n3;
                if (n5 < 0) {
                    n = 4;
                }
                n5 = FLIPPED_ROTATION_ORDER.get(n5 + n);
            }
        }
        this.setAttribute("Orientation", Integer.toString(n5));
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     */
    public void saveAttributes() throws IOException {
        Object object;
        Object object2;
        Object object3;
        block46: {
            Object object4;
            block47: {
                block48: {
                    void var5_13;
                    Object object5;
                    boolean bl;
                    File file;
                    block50: {
                        block53: {
                            Object object6;
                            boolean bl2;
                            block55: {
                                block56: {
                                    FileInputStream fileInputStream;
                                    boolean bl3;
                                    Object object7;
                                    block52: {
                                        block51: {
                                            block54: {
                                                block49: {
                                                    if (!this.isSupportedFormatForSavingAttributes()) throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
                                                    if (this.mSeekableFileDescriptor == null) {
                                                        if (this.mFilename == null) throw new IOException("ExifInterface does not support saving attributes for the current input.");
                                                    }
                                                    this.mModified = true;
                                                    this.mThumbnailBytes = this.getThumbnail();
                                                    object3 = null;
                                                    object2 = null;
                                                    object = null;
                                                    object4 = null;
                                                    try {
                                                        file = File.createTempFile("temp", "tmp");
                                                        if (this.mFilename != null) {
                                                            object2 = object7 = new FileInputStream(this.mFilename);
                                                        } else if (Build.VERSION.SDK_INT >= 21) {
                                                            Os.lseek((FileDescriptor)this.mSeekableFileDescriptor, (long)0L, (int)OsConstants.SEEK_SET);
                                                            object2 = object7 = new FileInputStream(this.mSeekableFileDescriptor);
                                                        } else {
                                                            object2 = null;
                                                        }
                                                    }
                                                    catch (Throwable throwable) {
                                                        object4 = null;
                                                        object3 = object;
                                                        object = object4;
                                                        break block46;
                                                    }
                                                    catch (Exception exception) {
                                                        object = null;
                                                        break block47;
                                                    }
                                                    try {
                                                        object = new FileOutputStream(file);
                                                    }
                                                    catch (Throwable throwable) {
                                                        object = null;
                                                        break block48;
                                                    }
                                                    catch (Exception exception) {
                                                        object = null;
                                                        break block47;
                                                    }
                                                    try {
                                                        ExifInterface.copy((InputStream)object2, (OutputStream)object);
                                                    }
                                                    catch (Throwable throwable) {
                                                        break block48;
                                                    }
                                                    catch (Exception exception) {
                                                        break block47;
                                                    }
                                                    ExifInterface.closeQuietly((Closeable)object2);
                                                    ExifInterface.closeQuietly((Closeable)object);
                                                    bl2 = false;
                                                    bl = false;
                                                    boolean bl4 = false;
                                                    bl3 = false;
                                                    try {
                                                        object = new FileInputStream(file);
                                                        break block49;
                                                    }
                                                    catch (Throwable throwable) {
                                                        object5 = null;
                                                        object = object3;
                                                        bl = bl4;
                                                        break block50;
                                                    }
                                                    catch (Exception exception) {
                                                        object = object4;
                                                        break block51;
                                                    }
                                                }
                                                try {
                                                    if (this.mFilename != null) {
                                                        object2 = new FileOutputStream(this.mFilename);
                                                    } else if (Build.VERSION.SDK_INT >= 21) {
                                                        Os.lseek((FileDescriptor)this.mSeekableFileDescriptor, (long)0L, (int)OsConstants.SEEK_SET);
                                                        object2 = new FileOutputStream(this.mSeekableFileDescriptor);
                                                    } else {
                                                        object2 = null;
                                                    }
                                                }
                                                catch (Exception exception) {
                                                    break block51;
                                                }
                                                try {
                                                    object4 = new BufferedInputStream((InputStream)object);
                                                }
                                                catch (Exception exception) {
                                                    object3 = null;
                                                    object4 = null;
                                                    break block52;
                                                }
                                                try {
                                                    object3 = new BufferedOutputStream((OutputStream)object2);
                                                    bl = bl2;
                                                    object6 = object4;
                                                    object5 = object3;
                                                }
                                                catch (Throwable throwable) {
                                                    object5 = null;
                                                    break block53;
                                                }
                                                catch (Exception exception) {
                                                    object3 = null;
                                                    break block52;
                                                }
                                                try {
                                                    if (this.mMimeType == 4) {
                                                        bl = bl2;
                                                        object6 = object4;
                                                        object5 = object3;
                                                        this.saveJpegAttributes((InputStream)object4, (OutputStream)object3);
                                                        break block54;
                                                    }
                                                    bl = bl2;
                                                    object6 = object4;
                                                    object5 = object3;
                                                    if (this.mMimeType == 13) {
                                                        bl = bl2;
                                                        object6 = object4;
                                                        object5 = object3;
                                                        this.savePngAttributes((InputStream)object4, (OutputStream)object3);
                                                        break block54;
                                                    }
                                                    bl = bl2;
                                                    object6 = object4;
                                                    object5 = object3;
                                                    if (this.mMimeType != 14) break block54;
                                                    bl = bl2;
                                                    object6 = object4;
                                                    object5 = object3;
                                                    this.saveWebpAttributes((InputStream)object4, (OutputStream)object3);
                                                }
                                                catch (Exception exception) {}
                                            }
                                            ExifInterface.closeQuietly((Closeable)object4);
                                            ExifInterface.closeQuietly((Closeable)object3);
                                            file.delete();
                                            this.mThumbnailBytes = null;
                                            return;
                                            break block52;
                                        }
                                        object3 = null;
                                        object4 = null;
                                        object7 = object2;
                                        object2 = null;
                                    }
                                    try {
                                        fileInputStream = new FileInputStream(file);
                                        object6 = object2;
                                        object5 = object2;
                                    }
                                    catch (Throwable throwable) {
                                        bl2 = bl3;
                                        break block55;
                                    }
                                    catch (Exception exception) {
                                        // empty catch block
                                        break block56;
                                    }
                                    try {
                                        block58: {
                                            block59: {
                                                block57: {
                                                    if (this.mFilename != null) break block57;
                                                    object = object2;
                                                    object6 = object2;
                                                    object5 = object2;
                                                    if (Build.VERSION.SDK_INT < 21) break block58;
                                                    object6 = object2;
                                                    object5 = object2;
                                                    Os.lseek((FileDescriptor)this.mSeekableFileDescriptor, (long)0L, (int)OsConstants.SEEK_SET);
                                                    object6 = object2;
                                                    object5 = object2;
                                                    object6 = object2;
                                                    object5 = object2;
                                                    object2 = object = new FileOutputStream(this.mSeekableFileDescriptor);
                                                    break block59;
                                                }
                                                object6 = object2;
                                                object5 = object2;
                                                object2 = new FileOutputStream(this.mFilename);
                                            }
                                            object = object2;
                                        }
                                        object6 = object;
                                        object5 = object;
                                        ExifInterface.copy(fileInputStream, (OutputStream)object);
                                        bl = bl2;
                                        object6 = object4;
                                        object5 = object3;
                                    }
                                    catch (Throwable throwable) {
                                        object = fileInputStream;
                                        bl2 = bl3;
                                        object2 = object6;
                                        break block55;
                                    }
                                    catch (Exception exception) {
                                        object2 = object5;
                                        object = fileInputStream;
                                        break block56;
                                    }
                                    {
                                        ExifInterface.closeQuietly(fileInputStream);
                                        bl = bl2;
                                        object6 = object4;
                                        object5 = object3;
                                        ExifInterface.closeQuietly((Closeable)object);
                                        bl = bl2;
                                        object6 = object4;
                                        object5 = object3;
                                        bl = bl2;
                                        object6 = object4;
                                        object5 = object3;
                                        object2 = new IOException("Failed to save new file", (Throwable)object7);
                                        bl = bl2;
                                        object6 = object4;
                                        object5 = object3;
                                        throw object2;
                                    }
                                }
                                try {
                                    void var9_27;
                                    object5 = new StringBuilder();
                                    ((StringBuilder)object5).append("Failed to save new file. Original file is stored in ");
                                    ((StringBuilder)object5).append(file.getAbsolutePath());
                                    object6 = new IOException(((StringBuilder)object5).toString(), (Throwable)var9_27);
                                    throw object6;
                                }
                                catch (Throwable throwable) {
                                    bl2 = true;
                                }
                            }
                            bl = bl2;
                            object6 = object4;
                            object5 = object3;
                            {
                                void var9_29;
                                ExifInterface.closeQuietly((Closeable)object);
                                bl = bl2;
                                object6 = object4;
                                object5 = object3;
                                ExifInterface.closeQuietly((Closeable)object2);
                                bl = bl2;
                                object6 = object4;
                                object5 = object3;
                                throw var9_29;
                            }
                        }
                        object = object4;
                    }
                    ExifInterface.closeQuietly((Closeable)object);
                    ExifInterface.closeQuietly(object5);
                    if (bl) throw var5_13;
                    file.delete();
                    throw var5_13;
                }
                object4 = object2;
                object2 = object3;
                object3 = object4;
                break block46;
            }
            try {
                object4 = new IOException("Failed to copy original file to temp file", (Throwable)object3);
                throw object4;
            }
            catch (Throwable throwable) {
                object3 = object2;
                object2 = throwable;
            }
        }
        ExifInterface.closeQuietly((Closeable)object3);
        ExifInterface.closeQuietly((Closeable)object);
        throw object2;
    }

    public void setAltitude(double d) {
        String string = d >= 0.0 ? "0" : "1";
        this.setAttribute("GPSAltitude", new Rational(Math.abs(d)).toString());
        this.setAttribute("GPSAltitudeRef", string);
    }

    public void setAttribute(String object, String object2) {
        Object object3;
        Object object4;
        block40: {
            block39: {
                object4 = object2;
                if (object == null) {
                    object = new NullPointerException("tag shouldn't be null");
                    throw object;
                }
                if ("DateTime".equals(object) || "DateTimeOriginal".equals(object)) break block39;
                object3 = object4;
                if (!"DateTimeDigitized".equals(object)) break block40;
            }
            object3 = object4;
            if (object4 != null) {
                boolean bl = DATETIME_PRIMARY_FORMAT_PATTERN.matcher((CharSequence)object4).find();
                boolean bl2 = DATETIME_SECONDARY_FORMAT_PATTERN.matcher((CharSequence)object4).find();
                if (((String)object2).length() == 19 && (bl || bl2)) {
                    object3 = object4;
                    if (bl2) {
                        object3 = object4.replaceAll("-", ":");
                    }
                } else {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Invalid value for ");
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(" : ");
                    ((StringBuilder)object2).append((String)object4);
                    Log.w((String)"ExifInterface", (String)((StringBuilder)object2).toString());
                    return;
                }
            }
        }
        object2 = object;
        if ("ISOSpeedRatings".equals(object)) {
            if (DEBUG) {
                Log.d((String)"ExifInterface", (String)"setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            object2 = "PhotographicSensitivity";
        }
        object = object3;
        if (object3 != null) {
            object = object3;
            if (sTagSetForCompatibility.contains(object2)) {
                if (((String)object2).equals("GPSTimeStamp")) {
                    object = GPS_TIMESTAMP_PATTERN.matcher((CharSequence)object3);
                    if (!((Matcher)object).find()) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Invalid value for ");
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(" : ");
                        ((StringBuilder)object).append((String)object3);
                        Log.w((String)"ExifInterface", (String)((StringBuilder)object).toString());
                        return;
                    }
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(Integer.parseInt(((Matcher)object).group(1)));
                    ((StringBuilder)object3).append("/1,");
                    ((StringBuilder)object3).append(Integer.parseInt(((Matcher)object).group(2)));
                    ((StringBuilder)object3).append("/1,");
                    ((StringBuilder)object3).append(Integer.parseInt(((Matcher)object).group(3)));
                    ((StringBuilder)object3).append("/1");
                    object = ((StringBuilder)object3).toString();
                } else {
                    try {
                        double d = Double.parseDouble((String)object3);
                        object = new Rational(d);
                        object = object.toString();
                    }
                    catch (NumberFormatException numberFormatException) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid value for ");
                        stringBuilder.append((String)object2);
                        stringBuilder.append(" : ");
                        stringBuilder.append((String)object3);
                        Log.w((String)"ExifInterface", (String)stringBuilder.toString());
                        return;
                    }
                }
            }
        }
        int n = 0;
        while (n < EXIF_TAGS.length) {
            block41: {
                Object object5;
                int n2;
                block45: {
                    block43: {
                        block46: {
                            Pair<Integer, Integer> pair;
                            block44: {
                                block42: {
                                    if (n == 4 && !this.mHasThumbnail || (object3 = sExifTagMapsForWriting[n].get(object2)) == null) break block41;
                                    if (object != null) break block42;
                                    this.mAttributes[n].remove(object2);
                                    break block41;
                                }
                                pair = ExifInterface.guessDataFormat((String)object);
                                if (((ExifTag)object3).primaryFormat == (Integer)pair.first || ((ExifTag)object3).primaryFormat == (Integer)pair.second) break block43;
                                if (((ExifTag)object3).secondaryFormat == -1 || ((ExifTag)object3).secondaryFormat != (Integer)pair.first && ((ExifTag)object3).secondaryFormat != (Integer)pair.second) break block44;
                                n2 = ((ExifTag)object3).secondaryFormat;
                                break block45;
                            }
                            if (((ExifTag)object3).primaryFormat == 1 || ((ExifTag)object3).primaryFormat == 7 || ((ExifTag)object3).primaryFormat == 2) break block46;
                            if (!DEBUG) break block41;
                            object5 = new StringBuilder();
                            ((StringBuilder)object5).append("Given tag (");
                            ((StringBuilder)object5).append((String)object2);
                            ((StringBuilder)object5).append(") value didn't match with one of expected formats: ");
                            ((StringBuilder)object5).append(IFD_FORMAT_NAMES[((ExifTag)object3).primaryFormat]);
                            n2 = ((ExifTag)object3).secondaryFormat;
                            object4 = "";
                            if (n2 == -1) {
                                object3 = "";
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(", ");
                                stringBuilder.append(IFD_FORMAT_NAMES[((ExifTag)object3).secondaryFormat]);
                                object3 = stringBuilder.toString();
                            }
                            ((StringBuilder)object5).append((String)object3);
                            ((StringBuilder)object5).append(" (guess: ");
                            ((StringBuilder)object5).append(IFD_FORMAT_NAMES[(Integer)pair.first]);
                            if ((Integer)pair.second == -1) {
                                object3 = object4;
                            } else {
                                object3 = new StringBuilder();
                                ((StringBuilder)object3).append(", ");
                                ((StringBuilder)object3).append(IFD_FORMAT_NAMES[(Integer)pair.second]);
                                object3 = ((StringBuilder)object3).toString();
                            }
                            ((StringBuilder)object5).append((String)object3);
                            ((StringBuilder)object5).append(")");
                            Log.d((String)"ExifInterface", (String)((StringBuilder)object5).toString());
                            break block41;
                        }
                        n2 = ((ExifTag)object3).primaryFormat;
                        break block45;
                    }
                    n2 = ((ExifTag)object3).primaryFormat;
                }
                switch (n2) {
                    default: {
                        if (!DEBUG) break;
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Data format isn't one of expected formats: ");
                        ((StringBuilder)object3).append(n2);
                        Log.d((String)"ExifInterface", (String)((StringBuilder)object3).toString());
                        break;
                    }
                    case 12: {
                        object3 = ((String)object).split(",", -1);
                        object4 = new double[((CharSequence)object3).length];
                        for (n2 = 0; n2 < ((Object)object3).length; ++n2) {
                            object4[n2] = (String)Double.parseDouble((String)object3[n2]);
                        }
                        this.mAttributes[n].put((String)object2, ExifAttribute.createDouble((double[])object4, (ByteOrder)this.mExifByteOrder));
                        break;
                    }
                    case 10: {
                        object3 = ((String)object).split(",", -1);
                        object4 = new Rational[((CharSequence)object3).length];
                        for (n2 = 0; n2 < ((Object)object3).length; ++n2) {
                            object5 = ((String)object3[n2]).split("/", -1);
                            object4[n2] = new Rational((long)Double.parseDouble((String)object5[0]), (long)Double.parseDouble((String)object5[1]));
                        }
                        this.mAttributes[n].put((String)object2, ExifAttribute.createSRational((Rational[])object4, (ByteOrder)this.mExifByteOrder));
                        break;
                    }
                    case 9: {
                        object3 = ((String)object).split(",", -1);
                        object4 = new int[((CharSequence)object3).length];
                        for (n2 = 0; n2 < ((Object)object3).length; ++n2) {
                            object4[n2] = (String)Integer.parseInt((String)object3[n2]);
                        }
                        this.mAttributes[n].put((String)object2, ExifAttribute.createSLong((int[])object4, (ByteOrder)this.mExifByteOrder));
                        break;
                    }
                    case 5: {
                        object3 = ((String)object).split(",", -1);
                        object5 = new Rational[((CharSequence)object3).length];
                        for (n2 = 0; n2 < ((Object)object3).length; ++n2) {
                            object4 = ((String)object3[n2]).split("/", -1);
                            object5[n2] = new Rational((long)Double.parseDouble(object4[0]), (long)Double.parseDouble(object4[1]));
                        }
                        this.mAttributes[n].put((String)object2, ExifAttribute.createURational((Rational[])object5, (ByteOrder)this.mExifByteOrder));
                        break;
                    }
                    case 4: {
                        object3 = ((String)object).split(",", -1);
                        object4 = new long[((CharSequence)object3).length];
                        for (n2 = 0; n2 < ((Object)object3).length; ++n2) {
                            object4[n2] = (String)Long.parseLong((String)object3[n2]);
                        }
                        this.mAttributes[n].put((String)object2, ExifAttribute.createULong((long[])object4, (ByteOrder)this.mExifByteOrder));
                        break;
                    }
                    case 3: {
                        object4 = ((String)object).split(",", -1);
                        object3 = new int[((String[])object4).length];
                        for (n2 = 0; n2 < ((String[])object4).length; ++n2) {
                            object3[n2] = Integer.parseInt(object4[n2]);
                        }
                        this.mAttributes[n].put((String)object2, ExifAttribute.createUShort((int[])object3, (ByteOrder)this.mExifByteOrder));
                        break;
                    }
                    case 2: 
                    case 7: {
                        this.mAttributes[n].put((String)object2, ExifAttribute.createString((String)object));
                        break;
                    }
                    case 1: {
                        this.mAttributes[n].put((String)object2, ExifAttribute.createByte((String)object));
                        break;
                    }
                }
            }
            ++n;
        }
    }

    public void setDateTime(Long l) {
        long l2 = l;
        this.setAttribute("DateTime", sFormatterPrimary.format(new Date(l)));
        this.setAttribute("SubSecTime", Long.toString(l2 % 1000L));
    }

    public void setGpsInfo(Location stringArray) {
        if (stringArray == null) {
            return;
        }
        this.setAttribute("GPSProcessingMethod", stringArray.getProvider());
        this.setLatLong(stringArray.getLatitude(), stringArray.getLongitude());
        this.setAltitude(stringArray.getAltitude());
        this.setAttribute("GPSSpeedRef", "K");
        this.setAttribute("GPSSpeed", new Rational((double)(stringArray.getSpeed() * (float)TimeUnit.HOURS.toSeconds(1L) / 1000.0f)).toString());
        stringArray = sFormatterPrimary.format(new Date(stringArray.getTime())).split("\\s+", -1);
        this.setAttribute("GPSDateStamp", stringArray[0]);
        this.setAttribute("GPSTimeStamp", stringArray[1]);
    }

    public void setLatLong(double d, double d2) {
        if (!(d < -90.0 || d > 90.0 || Double.isNaN(d))) {
            if (!(d2 < -180.0 || d2 > 180.0 || Double.isNaN(d2))) {
                String string = d >= 0.0 ? "N" : "S";
                this.setAttribute("GPSLatitudeRef", string);
                this.setAttribute("GPSLatitude", this.convertDecimalDegree(Math.abs(d)));
                string = d2 >= 0.0 ? "E" : "W";
                this.setAttribute("GPSLongitudeRef", string);
                this.setAttribute("GPSLongitude", this.convertDecimalDegree(Math.abs(d2)));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Longitude value ");
            stringBuilder.append(d2);
            stringBuilder.append(" is not valid.");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Latitude value ");
        stringBuilder.append(d);
        stringBuilder.append(" is not valid.");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
