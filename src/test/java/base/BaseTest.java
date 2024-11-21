package base;

import org.InterRAO.common.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Driver.setupBrowser("chrome");
    }

    @AfterAll
    public static void tearDown(){
        Driver.close();
    }
}
