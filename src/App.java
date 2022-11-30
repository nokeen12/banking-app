import java.util.Scanner; //scanner used for gathering user input in command line

//keys
// something.equals(something)
// scanner.close()
// String value = scanner.next();
// value = scanner.next().toLowerCase();
// String[] choices = {rock, paper, scissors}
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Integer balance = 0;
        if(running){
            openMenu(running, scanner, balance);
        }
        scanner.close();
        System.out.println("App Exited");
        //text
        // System.out.println("Would you like to view your current balance?(v)");
        // System.out.println("Current Balance is: ");
        // System.out.println("Exchange currencies(e)");
        // System.out.println("Available currencies are: ");
        // System.out.println("Go back(b)");
        // System.out.println("Quit(q)");
    };
    public static void openMenu(boolean running, Scanner scanner, Integer balance){
        System.out.println("Welcome To Cordre's Premium Banking Services");
        System.out.println("Would you like to view your current balance?(v)");
        System.out.println("Deposit balance(d)");
        System.out.println("Withdraw balance(w)");
        System.out.println("Quit(q)");
        String value = scanner.next().toLowerCase();
        switch(value){
            case "v": viewBalance(running, scanner, balance);
            break;
            case "d": depositBalance(running, scanner, balance);
            break;
            case "w": withdrawBalance(running, scanner, balance);
            break;
            case "q": running = false;
            break;
            default: System.out.println("Error");
            openMenu(running, scanner, balance);
        }
    };
    public static void viewBalance(boolean running, Scanner scanner, Integer balance){
        //currency array
        System.out.println("Current Balance is: " + balance);
        System.out.println("Available currencies are: ");//add array of currencies
        System.out.println("Exchange currencies(e)");
        System.out.println("Go back(b)");
        String value = scanner.next().toLowerCase();
        switch(value){
            case "e": exchangeCurrency(running, scanner, balance);
            break;
            case "b": openMenu(running, scanner, balance);
            break;
            case "q": running = false;
            break;
            default: System.out.println("Error");
            viewBalance(running, scanner, balance);
        }
    };
    public static void withdrawBalance(boolean running, Scanner scanner, Integer balance){
        System.out.println("Current Balance is: " + balance);
        System.out.println("How much would you like to withdraw?");
        System.out.println("Go back(b)");
        String value = scanner.next().toLowerCase();
        try{
            int withAmount = Integer.parseInt(value);
            if(withAmount > balance){
                System.out.println("Insufficient funds");
                withdrawBalance(running, scanner, balance);
            }else{
                balance -= withAmount;
                withdrawBalance(running, scanner, balance);
            }
        }catch(NumberFormatException e){
            switch(value){
                case "b": openMenu(running, scanner, balance);
                break;
                case "q": running = false;
                break;
                default: System.out.println("Error");
                withdrawBalance(running, scanner, balance);
            }
        }
    };
    public static void depositBalance(boolean running, Scanner scanner, Integer balance){
        System.out.println("Current Balance is: " + balance);
        System.out.println("How much would you like to deposit?");
        System.out.println("Go back(b)");
        String value = scanner.next().toLowerCase();
        try{
            int depoAmount = Integer.parseInt(value);
            balance += depoAmount;
            depositBalance(running, scanner, balance);
        }catch(NumberFormatException e){
            switch(value){
                case "b": openMenu(running, scanner, balance);
                break;
                case "q": running = false;
                break;
                default: System.out.println("Error");
                depositBalance(running, scanner, balance);
            }
        }
    };
    public static void exchangeCurrency(boolean running, Scanner scanner, Integer balance){};
}
