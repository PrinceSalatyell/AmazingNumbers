import java.util.Arrays;
import java.util.Scanner;

public class AmazingNumbers {
    public static void main(String[] args) {
       
	   Scanner scanner = new Scanner(System.in);
	   
	   String parameters = "";
	   
	   instructions();
	   
	   String[] properties = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL",
   			"SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD"};
		
		while (true) {
		    String number = "";
		    String number2 = "";
		    String word = "";
		    long x = 0;
		    long y = 0;
		    
		    parameters = scanner.nextLine();
		    String[] parametersArray = parameters.split(" ");
		    
		    if (parametersArray[0].contentEquals("0")) {
		        System.out.println("Goodbye!");
		        System.out.println();
		        System.out.println("Process finished with exit code 0");
		        break;
		    } else if (parametersArray[0].isBlank()) {
		        instructions();
		        continue;
		    } else if (parametersArray[0].contains("exit")) {
		        System.out.println("The first parameter should be a natural number or zero.");
    		    System.out.println();
        	    System.out.println("Enter a request:");
    		    continue;
		    }
		    
		    if (parametersArray.length == 1) {
		        number = parametersArray[0];
		        onlyOneNumber(number, x);
		        continue;
		    } else if (parametersArray.length == 2) {
		        number = parametersArray[0];
		        number2 = parametersArray[1];
		        twoNumbers(number, number2, x, y);
		        continue;
		    } else {
		        number = parametersArray[0];
		        number2 = parametersArray[1];
		        multipleParameters(parametersArray, properties, number, number2, word, x, y);
		        continue;
		    }
		    
		}	
    }
    
    public static void instructions() {
    	
        System.out.println("Welcome to Amazing Numbers!");
	    System.out.println();
	    System.out.println("Supported requests:");
	    System.out.println("- enter a natural number to know its properties;");
	    System.out.println("- enter two natural numbers to obtain the properties of the list:");
	    System.out.println("  * the first parameter represents a starting number;");
	    System.out.println("  * the second parameters show how many consecutive numbers are to be processed;");
	    System.out.println("- two natural numbers and properties to search for;");
	    System.out.println("- a property preceded by minus must not be present in numbers;");
	    System.out.println("- separate the parameters with one space;");
	    System.out.println("- enter 0 to exit.");
	    System.out.println();
	    System.out.println("Enter a request:");
    	
    }
    
    public static void onlyOneNumber(String number, long x) {
    	
    	x = Long.valueOf(number);
    	
    	if (x < 0) {
    		System.out.println("The first parameter should be a natural number or zero.");
		    System.out.println();
    	    System.out.println("Enter a request:");
    	    return;
    	}
    	
        System.out.println("Properties of " + x);
	    System.out.println("    even:" + isEven(x));
	    System.out.println("    odd:" + isOdd(x));
	    System.out.println("    buzz:" + isBuzz(x));
	    System.out.println("    duck:" + isDuck(x));
	    System.out.println("    palindromic:" + isPalindromic(x));
	    System.out.println("    gapful:" + isGapful(number, x));
	    System.out.println("    spy:" + isSpy(number));
	    System.out.println("    square:" + isSquare(x));
	    System.out.println("    sunny:" + isSunny(x));
	    System.out.println("    jumping:" + isJumping(number));
	    System.out.println("    happy:" + isHappyOrSad(x));
	    System.out.println("    sad:" + !isHappyOrSad(x));
	    System.out.println();
	    System.out.println("Enter a request:");
    	
    }
    
    public static void twoNumbers (String number, String number2, long x, long y) {
    	
    	x = Long.valueOf(number);
    	y = Long.valueOf(number2);
    	
    	if (x < 0) {
		    System.out.println("The first parameter should be a natural number or zero.");
		    System.out.println();
    	    System.out.println("Enter a request:");
		    return;
		}
		if (y <= 0) {
		    System.out.println("The second parameter should be a natural number.");
		    System.out.println();
    	    System.out.println("Enter a request:");
		    return;
		}
    	
        for (int i = 0; i < y; i++) {
        	
        	number = String.valueOf(x + i);
    		
    	    System.out.print((x + i) + " is ");
    		
    	    if (isEven(x + i)) {
    	    	System.out.print("even");
    		}
    	    if (isOdd(x + i)) {
    		    System.out.print("odd");
    		}
    	    if (isBuzz(x + i)) {
    		    System.out.print(", ");
    		    System.out.print("buzz");
    		}
    	    if (isDuck(x + i)) {
    		    System.out.print(", ");
    		    System.out.print("duck");
    		}
    	    if (isPalindromic(x + i)) {
    		    System.out.print(", ");
    		    System.out.print("palindromic");
    		}
    	    if (isGapful(number, x + i)) {
    		    System.out.print(", ");
    		    System.out.print("gapful");
    		}
    	    if (isSpy(number)) {
    	        System.out.print(", ");
    	        System.out.print("spy");
    	    }
    	    if (isSquare(x + i)) {
    	    	System.out.print(", ");
    	    	System.out.print("square");
    	    }
    	    if (isSunny(x + i)) {
    	    	System.out.print(", ");
    	    	System.out.print("sunny");
    	    }
    	    if (isJumping(number)) {
    	        System.out.print(", ");
    	        System.out.print("jumping");
    	    }
    	    if (isHappyOrSad(x + i)) {
    	        System.out.print(", ");
    	        System.out.print("happy");
    	    }
    	    if (!isHappyOrSad(x + i)) {
    	        System.out.print(", ");
    	        System.out.print("sad");
    	    }
    	    System.out.println();
    	} System.out.println();
        System.out.println("Enter a request:");
    	
    }
    
    public static void multipleParameters (String[] parametersArray, String [] properties, String number, String number2,
    	    String word, long x, long y) {
    	
    	if(wrongParameters(parametersArray, properties, word)) {
    	    return;
    	}
    	
    	if (exclusiveProperties(parametersArray)) {
    	    return;
    	}
    	
    	x = Long.valueOf(number);
    	y = Long.valueOf(number2);
    	long a = 0;
    	
    	while (a < y) {
    		boolean n = true;
    		for (String w : parametersArray) {
    			switch (w.toUpperCase()) {
    				case "EVEN":
    					if (isEven(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "ODD":
    					if (isOdd(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "BUZZ":
    					if (isBuzz(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "DUCK":
    					if (isDuck(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "PALINDROMIC":
    					if (isPalindromic(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "GAPFUL":
    					if (isGapful(number, x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "SPY":
    					number = String.valueOf(x);
    					if (isSpy(number)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "SQUARE":
    					if (isSquare(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "SUNNY":
    					if (isSunny(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "JUMPING":
    					number = String.valueOf(x);
    					if (isJumping(number)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "HAPPY":
    					if (isHappyOrSad(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;
    				case "SAD":
    					if (!isHappyOrSad(x)) {
    					    n = n && true;
    					} else {
    					    n = n && false;
    					}
    					break;	
    				case "-EVEN":
    					if (isEven(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-ODD":
    					if (isOdd(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-BUZZ":
    					if (isBuzz(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-DUCK":
    					if (isDuck(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-PALINDROMIC":
    					if (isPalindromic(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-GAPFUL":
    					if (isGapful(number, x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-SPY":
    					number = String.valueOf(x);
    					if (isSpy(number)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-SQUARE":
    					if (isSquare(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-SUNNY":
    					if (isSunny(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-JUMPING":
    					number = String.valueOf(x);
    					if (isJumping(number)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-HAPPY":
    					if (isHappyOrSad(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    				case "-SAD":
    					if (!isHappyOrSad(x)) {
    					    n = n && false;
    					} else {
    					    n = n && true;
    					}
    					break;
    			}
    		}
    		if (n) {
    		    number = String.valueOf(x);
    		    System.out.print(x + " is ");
    		    System.out.print(isEven(x) ? "even" : "odd");
    		    System.out.print(isBuzz(x) ? ", buzz" : "");
    		    System.out.print(isDuck(x) ? ", duck" : "");
    		    System.out.print(isPalindromic(x) ? ", plindromic" : "");
    		    System.out.print(isGapful(number, x) ? ", gapful" : "");
    		    System.out.print(isSpy(number) ? ", spy" : "");
    		    System.out.print(isSquare(x) ? ", square" : "");
    		    System.out.print(isSunny(x) ? ", sunny" : "");
    		    System.out.print(isJumping(number) ? ", jumping" : "");
    		    System.out.print(isHappyOrSad(x) ? ", happy" : ", sad");
    		    System.out.println();
    		    ++a;
    		    ++x;
    		} else {
    		    ++x;
    		}
    	}
    	System.out.println();
    	System.out.println("Enter a request:");
    	
    	
    }

	
	public static boolean isEven(long x) {
		
		if (x % 2 == 0) {
		    return true;
		} else {
		    return false;
		}
		
	}
	
	public static boolean isOdd(long x) {
		
		if (x % 2 != 0) {
		    return true;
		} else {
		    return false;
		}
		
	}
	
	public static boolean isBuzz(long x) {
		
		if (x % 7 == 0 || (x + 3) % 10 == 0) {
		    return true;
		} else {
		    return false;
		}
		
	}
	
	public static boolean isDuck(long x) {
		
		if (String.valueOf(x).contains("0")) {
					    return true;
					} else {
					    return false;
					}
		
	}
	
	public static boolean isPalindromic(long x) {
		
		long a = x;
		long b = 0;
		long c = 0;
		
		while (a > 0) {
		    b = a % 10;
		    c = (c * 10) + b;
		    a = a / 10; 
		}
		
		if (c == x) {
		    return true;
		} else {
		    return false;
		}
		
	}
	
	public static boolean isGapful(String number, long x) {
		
		number = String.valueOf(x);
	    String firstNumber = number.substring(0, 1);
	    long lastNumber = x % 10;
	    String numberFound = firstNumber + lastNumber;
	    long dividend = Long.valueOf(numberFound);
		
		if (number.length() >= 3 && x % dividend == 0) {
		    return true;
		} else {
		    return false;
		}
		
	}
	
	public static boolean isSpy(String number) {
		
		String[] arrayOfNumbers = number.split("");
		int sum = 0;
		int product = 1;
		
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			
		   sum += Integer.valueOf(arrayOfNumbers[i]);
		   product *= Integer.valueOf(arrayOfNumbers[i]);
			
		}
		
		if (sum == product) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean isSquare(long x) {
		
		double a = Math.sqrt(x);
		long b = (long) a;
		
		if (a == b) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean isSunny(long x) {
		
		if (isSquare(x + 1)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static boolean isJumping(String number) {
		
		String[] arrayOfNumbers = number.split("");
		boolean result = false;
		
		for (int i = 1; i < arrayOfNumbers.length; i++) {
			
			int a = Integer.valueOf(arrayOfNumbers[i - 1]);
			int b = Integer.valueOf(arrayOfNumbers[i]);
			
			if (!(a + 1 == b || a - 1 == b)) {
				result = false;
				break;
			}	
			result = true;
		}
		if (arrayOfNumbers.length == 1) {
		result = true;
		}
		return result;
	}
	
	public static boolean isHappyOrSad(long x) {
		
		long a = x;
		long result = 0;
		long b = 0;
		
		while (result != 4) {
			
			b = 0;
			result = 0;
			
			while (a > 0) {
				b = a % 10;
				result = result + b * b;
				a = a / 10;
			}
			if (result == 1) {
				return true;
			}
			a = result;
		}
		return false;
	}
	
	public static boolean wrongParameters(String[] parametersArray, String[] properties, String word) {
		
		boolean z = false;
    	int wP= 0;
    	
    	for (int i = 2; i < parametersArray.length; i++) {
        	boolean isP = true;
        	word = parametersArray[i];
        	for (int j = 0; j < properties.length; j++) {
        		if (word.toUpperCase().contentEquals(properties[j]) ||
        				word.toUpperCase().contentEquals("-" + properties[j])) {
        			isP = false;
        			break;
        		}
        	}
        	if (isP) {
        		wP ++;        	
        	}	
        }
    	
    	String[] notProperties = new String[wP];
    	int l = 0;
    	
    	for (int i = 2; i < parametersArray.length; i++) {
        	boolean isP = true;
        	word = parametersArray[i];
        	for (int j = 0; j < properties.length; j++) {
        		if (word.toUpperCase().contentEquals(properties[j]) ||
        				word.toUpperCase().contentEquals("-" + properties[j])) {
        			isP = false;
        			break;
        		}
        	}
        	if (isP) {
        		notProperties[l] = word.toUpperCase(); 
        		l++;
        	}	
        }
    	
    	if (notProperties.length == 1) {
    	    System.out.println("The property " + Arrays.toString(notProperties) + " is wrong.");
    	    System.out.println("Available properties: " + Arrays.toString(properties));
    	    System.out.println();
            System.out.println("Enter a request:");
    	    z = true;
    	} else if (notProperties.length > 1) {
    	    System.out.println("The properties " + Arrays.toString(notProperties) + " are wrong.");
    	    System.out.println("Available properties: " + Arrays.toString(properties));
    	    System.out.println();
            System.out.println("Enter a request:");
    	    z = true;
    	}
    	return z;
	}
	
	public static boolean exclusiveProperties(String[] parametersArray) {
		
		boolean z = false;
		
		for (String w : parametersArray) {
			if (w.toUpperCase().contentEquals("EVEN")) {
				for (String o : parametersArray) {
					if (o.toUpperCase().contentEquals("ODD")) {
					    System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]");
					    System.out.println("There are no numbers with these properties.");
					    System.out.println();
					    System.out.println("Enter a request:");
					    z = true;
					}
				}
			}
		}
		
		for (String w : parametersArray) {
			if (w.toUpperCase().contentEquals("DUCK")) {
				for (String o : parametersArray) {
					if (o.toUpperCase().contentEquals("SPY")) {
					    System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
					    System.out.println("There are no numbers with these properties.");
					    System.out.println();
					    System.out.println("Enter a request:");
					    z = true;
					}
				}
			}
		}
		
		for (String w : parametersArray) {
			if (w.toUpperCase().contentEquals("SQUARE")) {
				for (String o : parametersArray) {
					if (o.toUpperCase().contentEquals("SUNNY")) {
					    System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
					    System.out.println("There are no numbers with these properties.");
					    System.out.println();
					    System.out.println("Enter a request:");
					    z = true;
					}
				}
			}
		}
		
		for (String w : parametersArray) {
			if (w.toUpperCase().contentEquals("HAPPY")) {
				for (String o : parametersArray) {
					if (o.toUpperCase().contentEquals("SAD")) {
					    System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]");
					    System.out.println("There are no numbers with these properties.");
					    System.out.println();
					    System.out.println("Enter a request:");
					    z = true;
					}
				}
			}
		}
		
		for (String w : parametersArray) {
			if (w.toUpperCase().contentEquals("-HAPPY")) {
				for (String o : parametersArray) {
					if (o.toUpperCase().contentEquals("-SAD")) {
					    System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]");
					    System.out.println("There are no numbers with these properties.");
					    System.out.println();
					    System.out.println("Enter a request:");
					    z = true;
					}
				}
			}
		}
		
		for (String w : parametersArray) {
			if (w.toUpperCase().contentEquals("-EVEN")) {
				for (String o : parametersArray) {
					if (o.toUpperCase().contentEquals("-ODD")) {
					    System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]");
					    System.out.println("There are no numbers with these properties.");
					    System.out.println();
					    System.out.println("Enter a request:");
					    z = true;
					}
				}
			}
		}
		
		for (String w : parametersArray) {
			if (true) {
				for (String o : parametersArray) {
					if (o.toUpperCase().contentEquals("-" + w.toUpperCase())) {
					    System.out.printf("The request contains mutually exclusive properties: [%s , -%s]%n",
					    		w.toUpperCase(), w.toUpperCase());
					    System.out.println("There are no numbers with these properties.");
					    System.out.println();
					    System.out.println("Enter a request:");
					    z = true;
					}
				}
			}
		}
		return z;
		
	}
		
}
