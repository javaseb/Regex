package charland.seb.questions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Java Regular Expression is similar to Perl.
 * 
 * Glossary:
 * 
 * comma (virgule) = ',' dash (trait d'union) = '-' (eg: June-December) dot
 * (point) = '.' hyphen (trait d'union) = '-' (eg: toll-free) slash (barre
 * oblique) = '/' backslash (barre oblique inverse)= '\' question mark = '?'
 * star = '*'
 * 
 * {@link java.util.regex.Pattern} {@link java.util.regex.Matcher}
 * 
 * Positions: ^ = line start $ = line end \< = word boundary (match the position
 * at the start of a word) \> = word boundary (match the position at the end of
 * a word)
 * 
 * Quantifiers: ? = one allowed, but it is optional * = any number allowed, but
 * it is optional + = at least one required, additional is optional {min, max} =
 * min required, max allowed
 *
 * Other: | = alternation (like an or) () = 1 - Limite the scope of an
 * alternation, 2 - grouping, 3- captures for backreferences \1, \2 =
 * backreferences
 *
 *
 * outside character class: . = match any character
 * 
 * 
 * 
 * 
 * Character class = []: [^...] means every character except these in the
 * character class
 * 
 * 
 * 
 * Beware of end of lines (which are different between OS): Windows = '\r\n' Mac
 * (OS 9-) = '\r' Mac (OS 10+)= '\n' Unix/Linux = '\n'
 *
 * 
 */

public class REGEX {

  static final String CHARACTER_TABULATION =    "\t";
  static final String CHARACTER_NEW_LINE = "\n";
  static final String CHARACTER_CARRIAGE_RETURN = "\r";

  static final String SHORTHAND_ANY_WHITESPACE = "\\s"; // whitespace character : space, tab, newline, formfeed, etc.)
  static final String SHORTHAND_ANY_WHITESPACE_NOT = "\\S"; // inverse of \s
  static final String SHORTHAND_WORD = "\\w"; // a word. Same as [a-zA-Z0-9_]
  static final String SHORTHAND_WORD_NOT = "\\W"; // not a word. Same as [^a-zA-Z0-9_]
  static final String SHORTHAND_DIGIT = "\\d"; // a digit. Same as [0-9]
  static final String SHORTHAND_DIGIT_NOT = "\\D"; // not a digit. Same as [^0-9]

  static final String CHARACTER_CLASS_LOWERCASE = "[a-z]"; // a to z characters
  static final String CHARACTER_CLASS_LOWERCASE_NOT = "[^a-z]"; // not a to z characters
  static final String CHARACTER_CLASS_UPPERCASE = "[A-Z]"; // A to Z characters
  static final String CHARACTER_CLASS_DIGIT = "[0-9]";
  static final String CHARACTER_CLASS_COMBINED = "[a-zA-Z0-9]";
  
  static final String UNICODE_X = "\\p{IsTitlecase}";

  /*
   * Unicode are more than a mapping of characters.
   */

  /** only letters */
  static final String UNICODE_PROPERTY_LETTER = "\\p{L}"; // note: one property name may omit the braces (e.g. it can be
                                                          // \\pL
  /** only letters (braces are omited) */
  static final String UNICODE_PROPERTY_LETTER2 = "\\pL"; // same as \\p{L}
  /** only lower case letters */
  static final String UNICODE_PROPERTY_LOWERCASE_LETTER = "\\p{Ll}";
  /** only upper case letters */
  static final String UNICODE_PROPERTY_UPPERCASE_LETTER = "\\p{Lu}";
  /** only title case letters */
  static final String UNICODE_PROPERTY_TITLECASE_LETTER = "\\p{Lt}"; // Title case Beware: The Title case mapping in Unicode differs from the uppercase mapping in that a number of characters require special handling. These are chiefly ligatures and digraphs such as 'fl', 'dz', and 'lj', plus a number of polytonic Greek characters. For example, U+01C7 (LJ) maps to U+01C8 (Lj) rather than to U+01C9 (lj).

  @Test
  public void tabCharacterPattern() {
    assertTrue("The tab character if found.", Pattern.compile(CHARACTER_TABULATION).matcher("\t").find()); // the
                                                                                                           // string
                                                                                                           // is a
                                                                                                           // tabulation
  }

  @Test
  public void the_WordShortand_isWorkingAsExpected() {
    assertTrue("A word is found.", Pattern.compile(SHORTHAND_WORD).matcher("a").find());
    assertFalse("A character that is not a word is not found.", Pattern.compile(SHORTHAND_WORD).matcher("%").find());
  }

  @Test
  public void sameReference() {
    String a = "mot";
    String b = "mot";
    assertTrue("The 2 strings HAVE the same reference.", a == b); // true, they have the same memory reference
    assertTrue("The 2 strings are equals.", a.equals(b)); // true the 2 variables have the same value.
  }

  @Test
  public void notTheSameReference() {
    String a = "DE";
    String b = "D";
    String c = "E";
    String d = b + c;
    assertFalse("The 2 strings HAVE NOT the same reference.", a == d); // false, the d string is not in the pool
    assertTrue("The 2 strings are equals.", a.equals(d)); // true the 2 variables have the same value.
  }

  @Test
  public void sameReferenceWithInternMethod() {
    String a = "DE";
    String b = "D";
    String c = "E";
    String d = b + c;
    d = d.intern(); // put the d String value into the pool
    assertTrue("The 2 strings HAVE the same reference.", a == d); // true, they have the same memory reference
    assertTrue("The 2 strings are equals.", a.equals(d)); // true the 2 variables have the same value.
  }

  @Test
  public void the_Unicode_Property_Letter_isWorkingCorrectly() {
    Pattern unicodeLetterPattern = Pattern.compile(UNICODE_PROPERTY_LETTER);
    assertTrue("A lowercase letter is found", unicodeLetterPattern.matcher("a").find());
    assertTrue("A uppercase letter is found", unicodeLetterPattern.matcher("A").find());
    assertFalse("A punctuation character is not found", unicodeLetterPattern.matcher("?").find());
  }

  @Test
  public void the_Unicode_Property_Letter2_isWorkingCorrectly() {
    Pattern unicodeLetter2Pattern = Pattern.compile(UNICODE_PROPERTY_LETTER2);
    assertTrue("A lowercase letter is found", unicodeLetter2Pattern.matcher("a").find());
    assertTrue("A uppercase letter is found", unicodeLetter2Pattern.matcher("A").find());
    assertFalse("A punctuation character is not found", unicodeLetter2Pattern.matcher("?").find());
  }

  @Test
  public void the_Unicode_Property_LowerCaseLetter_isWorkingCorrectly() {
    Pattern unicodeLowerCaseLetterPattern = Pattern.compile(UNICODE_PROPERTY_LOWERCASE_LETTER);
    assertTrue("A lowercase letter is found", unicodeLowerCaseLetterPattern.matcher("a").find());
    assertFalse("A uppercase letter is not found", unicodeLowerCaseLetterPattern.matcher("A").find());
    assertFalse("A punctuation character is not found", unicodeLowerCaseLetterPattern.matcher("?").find());
  }

  @Test
  public void the_Unicode_Property_UpperCaseLetter_isWorkingCorrectly() {
    Pattern unicodeUpperCaseLetterPattern = Pattern.compile(UNICODE_PROPERTY_UPPERCASE_LETTER);
    assertFalse("A lowercase letter is not found", unicodeUpperCaseLetterPattern.matcher("a").find());
    assertTrue("A uppercase letter is found", unicodeUpperCaseLetterPattern.matcher("A").find());
    assertFalse("A punctuation character is not found", unicodeUpperCaseLetterPattern.matcher("?").find());
  }

  @Test
  public void the_Unicode_Property_TitleCaseLetter_isWorkingCorrectly() {
    char c = Character.toTitleCase('a');
    Pattern unicodeTitleCaseLetterPattern = Pattern.compile(UNICODE_PROPERTY_TITLECASE_LETTER);
    assertFalse("A lowercase letter is not found", unicodeTitleCaseLetterPattern.matcher("no title case here.").find());
    assertTrue("A uppercase letter is found", unicodeTitleCaseLetterPattern.matcher("ǅ").find());
  }

  @Test
  public void simpleTest() {
    char z = (char) 65538;
    int i = z;
    System.out.println(i);

    byte b = (byte) 129;
    System.out.println(b);
  }

}
