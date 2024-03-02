// Program to implement string functions
public class PrE_QB7 
{
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "Hello World";
        String str3 = "Hello C++";
    
        // length() function - returns the length of the string
        System.out.println("Length of str1: " + str1.length());
        
        // charAt() function - returns the character at the specified index
        System.out.println("Character at index 6 in str1: " + str1.charAt(6));

        // indexOf() function - returns the index of the first occurrence of a substring
        System.out.println("Index of the first occurrence of 'l' in str1: " + str1.indexOf('l'));

         // lastIndexOf() function - returns the index of the last occurrence of a substring
         System.out.println("Index of the last occurrence of 'l' in str1: " + str1.lastIndexOf('l'));
        
        // substring() function - returns a substring of the string
        System.out.println("Substring of str1 from index 6 to 11: " + str1.substring(6, 11));
        
        // toUpperCase() function - returns a string with all uppercase letters
        System.out.println("str1 in uppercase: " + str1.toUpperCase());
        
        // toLowerCase() function - returns a string with all lowercase letters
        System.out.println("str1 in lowercase: " + str1.toLowerCase());
        
        // replace() function - replaces all occurrences of a character or substring with another
        System.out.println("Word 'World' replaced with 'Java': " + str1.replace("World","Java"));

        // startsWith() function - checks if the string starts with the specified substr1ing
        System.out.println("str1 starts with 'Hello': " + str1.startsWith("Hello"));
        
        // endsWith() function - checks if the string ends with the specified substr1ing
        System.out.println("str1 ends with 'World!': " + str1.endsWith("World"));
        
        // compareTo() function - compares two string lexicographically
        System.out.println("Comparison of str1 and str3: " + str1.compareTo(str3));

        // equals() function - checks if two string are equal
        System.out.println("str1 equals str3: " + str1.equals(str3));
       
        // equalsIgnoreCase() function - checks if two string are equal, ignoring case
        System.out.println("str2 equalsIgnoreCase str1: " + str2.equalsIgnoreCase(str1));
    }
}
