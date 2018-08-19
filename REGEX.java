package charland.seb.questions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/**
 * Java Regular Expression is similar to Perl.
 * 
 * Glossary:
 * 
 * comma (virgule) 					=  		','
 * dash (trait d'union) 			= 		'-' (eg: June-December)
 * dot (point) 						= 		'.'
 * hyphen (trait d'union) 			= 		'-' (eg: toll-free)
 * slash (barre oblique) 			= 		'/'
 * backslash (barre oblique inverse)=		'\'
 * question mark					=		'?'
 * star								=		'*'
 * 
 * {@link java.util.regex.Pattern}
 * {@link java.util.regex.Matcher}
 * 
 * Positions: 
 * 		^ = line start
 * 		$ = line end
 *		\< = word boundary (match the position at the start of a word)
 *		\> = word boundary (match the position at the end of a word)
 * 
 * Quantifiers: 
 *  	? = one allowed, but it is optional
 * 		* = any number allowed, but it is optional
 * 		+ = at least one required, additional is optional
 *		{min, max} = min required, max allowed 
 *
 * Other: 
 * 		|  = alternation (like an or)
 * 		() = 	1 - Limite the scope of an alternation, 2 - grouping, 3- captures for backreferences
 *		\1, \2 = backreferences
 *
 *
 * outside character class: 
 * . = match any character
 * 
 * 
 * 
 * 
 * Character class = []:
 * [^...] means every character except these in the character class
 * 
 * 
 * 
 * Beware of end of lines (which are different between OS): 
 *  Windows		= '\r\n'
 *  Mac (OS 9-)	= '\r'
 *  Mac (OS 10+)= '\n'
 *  Unix/Linux	= '\n'
 *
 * 
 */

public class REGEX {
	
	static final String CHARACTER_TABULATION 		= "\t";
	static final String CHARACTER_NEW_LINE			= "\n";
	static final String CHARACTER_CARRIAGE_RETURN 	= "\r";

	static final String SHORTHAND_ANY_WHITESPACE	= "\\s"; //whitespace character : space, tab, newline, formfeed, etc.) 
	static final String SHORTHAND_ANY_WHITESPACE_NOT= "\\S"; //inverse of \s
	static final String SHORTHAND_WORD 				= "\\w"; //a word. Same as  [a-zA-Z0-9_]
	static final String SHORTHAND_WORD_NOT 			= "\\W"; //not a word. Same as [^a-zA-Z0-9_]
	static final String SHORTHAND_DIGIT 			= "\\d"; //a digit. Same as [0-9]
	static final String SHORTHAND_DIGIT_NOT			= "\\D"; //not a digit. Same as [^0-9]

	
	static final String CHARACTER_CLASS_LOWERCASE 		= "[a-z]"; 	//a to z characters
	static final String CHARACTER_CLASS_LOWERCASE_NOT 	= "[^a-z]"; //not a to z characters
	static final String CHARACTER_CLASS_UPPERCASE 		= "[A-Z]";	//A to Z characters
	static final String CHARACTER_CLASS_DIGIT			= "[0-9]";
	static final String CHARACTER_CLASS_COMBINED		= "[a-zA-Z0-9]";
	
	
	
	
	@Test
	public void tabCharacterPattern() {
		assertTrue("The tab character if found.",Pattern.compile(CHARACTER_TABULATION).matcher("	").find()); //the string is a tabulation
	}
	
	@Test
	public void the_WordShortand_isWorkingAsExpected() {
		assertTrue("A word is found.",Pattern.compile(SHORTHAND_WORD).matcher("a").find());
		assertFalse("A character that is not a word is not found.",Pattern.compile(SHORTHAND_WORD).matcher("%").find());
	}
	
}