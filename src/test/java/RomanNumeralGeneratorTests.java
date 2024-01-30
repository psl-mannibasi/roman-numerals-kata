import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralGeneratorTests{
    @Test
    public void should_return_i_for_1() {
        assertEquals("i", new RomanNumeralConverter().convert(1));
    }
}
