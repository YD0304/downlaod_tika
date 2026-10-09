package org.apache.tika.utils;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static java.util.Locale.ENGLISH;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ExtendWith(MockitoExtension.class)
public class CharsetUtils_isSupported_1_2_Test {

    private static final String CHARSET_NAME = "UTF-8";

    private static final boolean IS_SUPPORTED = true;

    private static final boolean IS_NOT_SUPPORTED = false;

    private static final String NOT_SUPPORTED_CHARSET_NAME = "invalid-charset";

    private static final String NULL_CHARSET_NAME = null;

    private static CharsetUtils charsetUtils;

    private static Field getCharsetICU;

    private static Field isSupportedICU;

    @BeforeAll
    public static void setUp() throws Exception {
        charsetUtils = new CharsetUtils();
        getCharsetICU = CharsetUtils.class.getDeclaredField("getCharsetICU");
        getCharsetICU.setAccessible(true);
        isSupportedICU = CharsetUtils.class.getDeclaredField("isSupportedICU");
        isSupportedICU.setAccessible(true);
    }

    @Test
    public void testIsSupportedWithValidCharsetName() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        boolean result = CharsetUtils.isSupported(CHARSET_NAME);
        assertEquals(IS_SUPPORTED, result);
    }

    @Test
    public void testIsSupportedWithNotSupportedCharsetName() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        boolean result = CharsetUtils.isSupported(NOT_SUPPORTED_CHARSET_NAME);
        assertEquals(IS_NOT_SUPPORTED, result);
    }

    @Test
    public void testIsSupportedWithNullCharsetName() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        boolean result = CharsetUtils.isSupported(NULL_CHARSET_NAME);
        assertEquals(IS_NOT_SUPPORTED, result);
    }
}
