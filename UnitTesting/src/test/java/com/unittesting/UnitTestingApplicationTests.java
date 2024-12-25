package com.unittesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UnitTestingApplicationTests {
    private Calculator c = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    void testSum() {
        // expectedResult result
        int expectedResult = 20;

        // actualResult result
        int actualResult = c.doSum(12, 2, 6);

        // assertion
        assertThat(actualResult).isEqualTo(expectedResult);
    }
    @Test
    @Disabled
    void testProduct() {
        // expectedResult result
        int expectedResult = 24;

        // actualResult result
        int actualResult = c.doProduct(12, 2);

        // assertion
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testComparison() {
        // actualResult result
        boolean actualResult = c.compareNum(12, 12);

        // assertion
        assertThat(actualResult).isTrue();
    }
}
