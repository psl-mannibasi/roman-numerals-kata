import java.util.HashMap;

public class RomanNumeralConverter {

  HashMap<Integer, String> numeralMap = new HashMap<Integer, String>() {{
    put(1, "I");
    put(5, "V");
    put(10, "X");
    put(50, "L");
    put(100, "C");
    put(500, "D");
    put(1000, "M");
  }};


  public String convert(final Integer number) {
    if (number == 0) {
      return "";
    }
    int lowerMagnitudeNumber = number;
    StringBuilder finalNumeral = new StringBuilder();
    while (lowerMagnitudeNumber>0)
    {
      Integer key = roundDownToPowerOf10(lowerMagnitudeNumber);
      String numeralCharacter = numeralMap.get(key);
      // find nth power bounds of number eg if 121 the bounds are is 100 - 500 - 1000, or 93 bound are 10 - 50 - 100
      // if number 30
      // next nth power of number  * 10 = 100
      int upperBound = key * 10;  // 100 is next nth power of number 30
      int middleBound = upperBound / 2; // upperBound / 2 = 50
      int lowerBound = key; // nth power of number e.g. 10th

      finalNumeral.append(getNumeralCharacter(lowerMagnitudeNumber, lowerBound, middleBound, upperBound));

      lowerMagnitudeNumber = lowerMagnitudeNumber % lowerBound;
    }
    return finalNumeral.toString();
  }

  private String getNumeralCharacter(final Integer number, final int lowerBound, final int middleBound,
      final int upperBound) {
    // check number against bounds
    if (number >= middleBound - lowerBound && number < middleBound) {
      // e.g. if number is 100 check 40 - 49
      return numeralMap.get(lowerBound) + numeralMap.get(middleBound);
    } else if (number >= upperBound - lowerBound && number < upperBound) {
      // e.g. if number is 100 check 90 - 99
      return numeralMap.get(lowerBound) + numeralMap.get(upperBound);
    } else if (number >= middleBound && number < middleBound + lowerBound) {
      // e.g. if number is 100 check 50 - 59
      return numeralMap.get(middleBound);
    } else if (number >= middleBound + lowerBound && number < upperBound - lowerBound) {
      // e.g. if number is 100 check 60-89
      return numeralMap.get(middleBound) + repeatCharacterByNTimes(numeralMap.get(lowerBound),
          (int) Math.floor(number - middleBound / lowerBound));
    } else if (number < middleBound - lowerBound) {
      // e.g. if number is 100 check 10 - 39
      return repeatCharacterByNTimes(numeralMap.get(lowerBound), (int) Math.floor(number / lowerBound));
    }
     return "";
  }


  private String repeatCharacterByNTimes(final String character, final Integer number) {
    return new String(new char[number]).replace("\0", character);
  }

  // Thanks ChatGPT
  public static int roundDownToPowerOf10(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException("Number should be greater than 0");
    }
    int power = 1;
    while (number >= 10) {
      number /= 10;
      power *= 10;
    }
    return power;
  }

}
