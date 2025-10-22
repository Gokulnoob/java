public class ExceptionTest {
    public static void main(String args[]) {
        // 1. ArithmeticException (Trying to divide by zero)
        try {
            int a = 30, b = 0;
            int c = a / b;
            System.out.println("Result = " + c);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide a number by 0");
        }

        // 2. NumberFormatException (Trying to convert invalid string to integer)
        try {
            int num = Integer.parseInt("akki");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }

        // 3. ArrayIndexOutOfBoundsException (Trying to access index outside array bounds)
        try {
            int a[] = new int[5];
            a[6] = 9; // Array index out of bounds
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index is Out Of Bounds");
        }

        // 4. ArrayStoreException (Trying to store an object of an incompatible type in an array)
        try {
            Object[] objArray = new Integer[10];
            objArray[0] = "String"; // Trying to store a String in an Integer array
        } catch (ArrayStoreException e) {
            System.out.println("ArrayStoreException: " + e.getMessage());
        }

        // 5. NullPointerException (Trying to call a method on a null object)
        try {
            String a = null;
            System.out.println(a.charAt(0)); // Null object reference
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
    }
}
