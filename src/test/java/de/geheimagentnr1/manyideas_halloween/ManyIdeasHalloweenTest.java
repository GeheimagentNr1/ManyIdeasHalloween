package de.geheimagentnr1.manyideas_halloween;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ManyIdeasHalloweenTest {

    @Test
    void modIdIsValid() {

        String modId = "manyideas_halloween";
        assertTrue( modId.matches( "[a-z][a-z0-9_]{1,63}" ) );
    }
}
