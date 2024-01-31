import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralGeneratorTests{


    @ParameterizedTest()
    @CsvSource({
        "1,I",
        "7,VII",
        "14,XIV",
        "15,XV",
        "16,XVI",
        "20,XX",
        "29,XXIX",
        "101,CI",
        "110,CX",
        "1001,MI",
        "2019,MMXIX",
    })
    public void should_return_Numeral_for_Character(final int number, final String numeral) {
        assertEquals(numeral, new RomanNumeralConverter().convert(number));
    }

}
