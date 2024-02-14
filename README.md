# roman-numerals-kata
## Instructions
Write a program to convert Arabic numbers into their Roman numeral equivalents.

The Romans wrote their numbers using combinations of the following letters:

| Number | Numeral |
| ------ | ------- |
| 1      | I       |
| 5      | V       |
| 10     | X       |
| 50     | L       |
| 100    | C       |
| 500    | D       |
| 1000   | M       |

Initially, the Roman Numerals system consisted of expressing the number in terms of the most appropriate symbol that could be used.

To start, for the numbers 1-4, we would use the 'I' symbol in multiples to represent the number:

| Number | Numeral |
|--------|---------|
| 1      | I       |
| 2      | II      |
| 3      | III     |
| 4      | IIII    |

When the numbers got to 5, we would use 'V' as this symbol was the most efficient way to represent the number.

| Number | Numeral |
|--------|-------- |
| 5      | V       |

For the single integers greater than 5, a new rule came into effect: when 'smaller' symbols are appended one or more times behind the 'larger' symbol, it is considered to be added to the value representing the larger symbol.

| Number | Numeral |
|--------|---------|
| 6      | VI      |
| 7      | VII     |
| 8      | VIII    |
| 9      | VIIII   |

So, the initial sequence of Roman Numerals for the integers 1 - 9 were as follows:

|       |       |       |       |       |       |       |       |       |
|-------|-------|-------|-------|-------|-------|-------|-------|-------|
| 1     | 2     | 3     | 4     | 5     | 6     | 7     | 8     | 9     |
| I     | II    | III   | IIII  | V     | VI    | VII	  | VIII  | VIIII |

However, as you may have noticed the numbers for 4 and 9 don't look right. But the original formation of the numerals was this (even some clock faces still display IIII for 4). But this created problems as people kept confusing III with IIII and VIII with VIIII an additional rule was developed.

For numbers such as 4 and 9, the smaller symbol (I) is prepended with the larger symbol (V or 5 for the number 4, and X representing 10 for the number 9). When the smaller symbol appears before the larger symbol, it is considered to be subtracted from the larger symbol.

So, 'IV' is evaluated as: V - I = 5 - 1 = 4 and 'IX' is evaluated as: X - I = 10 - 1 = 9

Hence, the list of Roman Numerals for 1 - 9 are as amended to:

|       |       |       |       |       |       |       |       |       |
|-------|-------|-------|-------|-------|-------|-------|-------|-------|
| 1     | 2     | 3     | 4     | 5     | 6     | 7     | 8     | 9     |
| I     | II    | III   | IV    | V     | VI    | VII	  | VIII  | IX    |

Because Roman system is follow a decimal notation system, the same rules apply for the next order up: units of 10. In this case, use the symbols, 'X' for 10, 'L' for fifty and 'C' for a hundred.

|      |      |      |      |      |      |      |      |      |
|------|------|------|------|------|------|------|------|------|
| 10   | 20   | 30   | 40   | 50   | 60   | 70   | 80   | 90   |
| X    | XX   | XXX  | XL   | L    | LX   | LXX  | LXXX | XC   |

For the next decimal order up, use the same rules again with 'C' for 100, 'D' for 500 and 'M' for 1000

|      |      |      |      |      |      |      |      |      |
|------|------|------|------|------|------|------|------|------|
| 100  | 200  | 300  | 400  | 500  | 600  | 700  | 800  | 900  |
| C	   | CC   | CCC  | CD   | D    | DC   | DCC  | DCCC | CM   |

(As there are no symbols higher than 'M' (1000) the pattern stops here, and usually Roman Numerals don't consider numbers more than a few thousand)

There were certain rules that the numerals follow which should be observed:
- The 'base 1' symbols ('I', 'X', 'C', 'M') can be subtracted from the next highest 'base 5' symbol ('V', 'L', 'D') or 'base 1' symbol, but only one occurrence is allowed. The symbol cannot be prepended to a symbol that is the next decimal order higher. So 'IV', 'IX' is ok' but 'IL' or 'IC' are not. 'XL', 'XC' is valid' but XD and XM are not ('CD' and 'CM' are also valid)
- The symbols 'I' and 'X' can be repeated at most 3 times in a row when the symbol is being appended
- The 'base 5' symbols 'V', 'L' and 'D' can never be repeated

## More examples:

| Number | Numeral |
|--------|---------|
| 4      | IV      |
| 9      | IX      |
| 29     | XXIX    |
| 80     | LXXX    |
| 294    | CCXCIV  |
| 2019   | MMXIX   |

## Getting Started
Your solution should contain one method similar to:
`public string Convert(int amount)`

Here, amount represents the Arabic number and the value this method returns is the string of Roman numerals.

### Tips
- Take small steps. You should always be able to go to a green state (with all tests passing) quickly.
- Stick to the red, green and refactor steps.
- Try not to refactor in the red. If you write a failing test that would need a big rewrite to pass, consider removing the test, refactoring in the green, and then writing the test again.
- As you progress through the problem, you should see your algorithm start to evolve. In other words, as the tests get more specific, the code gets more generic.
- Don't be afraid to let the code get a little bit messy - sometimes that's the best way to spot the next refactoring step.

#### Potential ordering for initial test cases:
1. `assertEquals("i", new RomanNumeralConverter().convert(1));`
2. `assertEquals("ii", new RomanNumeralConverter().convert(2));`
3. `assertEquals("iii", new RomanNumeralConverter().convert(3));`
4. `assertEquals("v", new RomanNumeralConverter().convert(5));`
5. `assertEquals("vii", new RomanNumeralConverter().convert(7));`
6. `assertEquals("x", new RomanNumeralConverter().convert(10));`
7. `assertEquals("xviii", new RomanNumeralConverter().convert(18));`
