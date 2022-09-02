package dat3.experiments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleSanitizerTest {


    @Test
    public void simpleSanitizeTest(){
        String result = SimpleSanitizer.simpleSanitize("Hello World");
        assertEquals("Hello World", result);
    }

}