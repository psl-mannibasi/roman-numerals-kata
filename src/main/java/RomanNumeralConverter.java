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
    return getNumeral(number);
  }

  private String getNumeral(final Integer number) {
    if (number == 0) {
      return "";
    }
    Integer key = roundDownToPowerOf10(number);
    String numeralCharacter = numeralMap.get(key);
    // find nth power bounds of number eg if 121 the bounds are is 100 - 500 - 1000, or 93 bound are 10 - 50 - 100
    // if number 30
    // next nth power of number  * 10 = 100
    int upperBound = key * 10;  // 100 is next nth power of number 30
    int middleBound = upperBound / 2; // upperBound / 2 = 50
    int lowerBound = key; // nth power of number e.g. 10th
    // check number against bounds
    if (number >= middleBound - key && number < middleBound) {
      // e.g. if upper is 100 check 40 - 49
      numeralCharacter = numeralMap.get(lowerBound) + numeralMap.get(middleBound);
    } else if (number >= upperBound - key && number < upperBound) {
      // e.g. if upper is 100 check 90 - 99
      numeralCharacter = numeralMap.get(lowerBound) + numeralMap.get(upperBound);
    } else if (number >= middleBound && number < middleBound + lowerBound) {
      // e.g. if upper is 100 check 50 - 59
      numeralCharacter = numeralMap.get(middleBound);
    } else if (number >= middleBound + lowerBound && number < upperBound - lowerBound) {
      // e.g. if upper is 100 check 60-89
      numeralCharacter = numeralMap.get(middleBound) + repeatCharacterByNTimes(numeralMap.get(lowerBound),
          (int) Math.floor(number - middleBound / lowerBound));
    } else if (number < middleBound - key) {
      // e.g. if upper is 100 check 10 - 39
      numeralCharacter = repeatCharacterByNTimes(numeralMap.get(lowerBound), (int) Math.floor(number / lowerBound));
    }
    // now find the numeral for the lower magnitude eg if number is 110, 110 modulus lower bound find numeral of 10
    return numeralCharacter + getNumeral(number % lowerBound);
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
