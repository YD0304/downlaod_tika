package org.apache.tika.utils;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Pattern;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.util.Locale.ENGLISH;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

class CharsetUtils_forName_3_0_Test {

    @Test
    void testForName() {
        assertThrows(IllegalArgumentException.class, () -> CharsetUtils.forName(null));
        assertThrows(IllegalCharsetNameException.class, () -> CharsetUtils.forName("invalid name"));
        assertThrows(IllegalCharsetNameException.class, () -> CharsetUtils.forName("none"));
        assertThrows(IllegalCharsetNameException.class, () -> CharsetUtils.forName("no"));
        assertEquals(Charset.forName("UTF-8"), CharsetUtils.forName("UTF-8"));
        assertEquals(Charset.forName("ISO-8859-1"), CharsetUtils.forName("ISO 8859-1"));
        assertEquals(Charset.forName("cp1252"), CharsetUtils.forName("cp1252"));
        assertEquals(Charset.forName("windows-1252"), CharsetUtils.forName("win1252"));
    }
}
