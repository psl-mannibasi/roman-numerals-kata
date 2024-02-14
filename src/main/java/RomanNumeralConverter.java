import java.util.Arrays;
import java.util.HashMap;

public class RomanNumeralConverter {

  HashMap<Integer, String> numeralMap = new HashMap<Integer, String>() {{
    put(1, "I");
    put(2, "II");
    put(3, "III");
    put(4, "IV");
    put(5, "V");
    put(6, "VI");
    put(7, "VII");
    put(8, "VIII");
    put(9, "IX");
    put(10, "X");
    put(20, "XX");
    put(30, "XXX");
    put(40, "XL");
    put(50, "L");
    put(60, "LX");
    put(70, "LXX");
    put(80, "LXXX");
    put(90, "XC");
    put(100, "C");
    put(200, "CC");
    put(300, "CCC");
    put(400, "CD");
    put(500, "D");
    put(600, "DC");
    put(700, "DCC");
    put(800, "DCCC");
    put(900, "CM");
    put(1000, "M");
  }};


  public String convert(final Integer number) {
    if (number == 0 || number > 3999) {
      throw new NumberFormatException("Cannot convert numbers lower than 1 or higher than 3999");
    }

    String output = "";
    String numberString = number.toString();
    for (int i = 0; i < numberString.length(); i++) {
      Integer num = Integer.valueOf(String.valueOf(numberString.charAt(i)));
      int powerOf = numberString.length() - i - 1; // eg if number is 3 this will be 0, 20 will be 1, 500 will be 2, 1000 will be 3 etc
      int powerOfNumber =  powerOf > 0 ? 1 * (int) Math.pow(10, powerOf) : num; // we only have number as a single digit so multiply it by the power of. eg num will be 2 for 200 so 1 * 10^2 = 1 * 100
      int multiplier =  powerOf > 0 ? num : 1; // for numbers less than 9, we only need one numeral
      if(num>0) output += repeatCharacterByNTimes(numeralMap.get(powerOfNumber), multiplier);
    }
    return output;
  }

  private String repeatCharacterByNTimes(final String character, final Integer number) {
    return new String(new char[number]).replace("\0", character);
  }


}
