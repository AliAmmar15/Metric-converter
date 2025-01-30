import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrance = new Scanner(System.in);
        System.out.println("Welcome to metric converter!");
        System.out.println("Please input your query <value> <from_unit> <to_unit>." );
        System.out.println( "For example, 1 km = m.");
        System.out.println("Enter 'exit' to exit program");

        while (true){
            System.out.println("Enter your query:");
            String input = entrance.nextLine();

            // Exit
            if (input.equals("exit")) {
                System.out.println("Now Exiting. Goodbye");
                break;
            }

            // Proccess input
            String[] parts = input.split(" ");
            if (parts.length != 4 || !parts[2].equals("=")) {
                System.out.println("Invalid format! Please input in the format: <value> <from_unit> = <to_unit>");
                continue;
            }
            try {
                double value = Double.parseDouble(parts[0]);
                String fromUnit = parts[1];
                String toUnit = parts[3];
                double result = convert(value, fromUnit, toUnit);

                if (result == Double.MIN_VALUE) {
                    System.out.println("Conversion not supported! Please try again with valid units.");
                } else {
                    System.out.printf("%.2f %s = %.2f %s%n", value, fromUnit, result, toUnit);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format! Please enter a valid value.");
            }
        }

        entrance.close();
    }

    // Conversion logic
    public static double convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit.toLowerCase() + " to " + toUnit.toLowerCase()) {
            case "kg to lb":
                return value * 2.20462; // Kilograms to Pounds
            case "lb to kg":
                return value / 2.20462; // Pounds to Kilograms
            case "km to mile":
                return value * 0.621371; // Kilometers to Miles
            case "mile to km":
                return value / 0.621371; // Miles to Kilometers
            case "mm to inch":
                return value * 0.0393701; // Millimeters to Inches
            case "inch to mm":
                return value / 0.0393701; // Inches to Millimeters
            case "gram to ounce":
                return value * 0.035274; // Grams to Ounces
            case "ounce to gram":
                return value / 0.035274; // Ounces to Grams
            default:
                return Double.MIN_VALUE; // unsupported conversion
        }
    }





        


    }

