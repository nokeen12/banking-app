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

        if(running){
            openMenu(running, scanner);
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
    public static void openMenu(boolean running, Scanner scanner){
        System.out.println("Welcome To Cordre's Premium Banking Services");
        System.out.println("Would you like to view your current balance?(v)");
        System.out.println("Deposit balance(d)");
        System.out.println("Withdraw balance(w)");
        System.out.println("Quit(q)");
        String value = scanner.next().toLowerCase();
        switch(value){
            case "v":  System.out.println("view balance");
            break;
            case "d": System.out.println("deposit balance");
            break;
            case "w": System.out.println("withdraw balance");
            break;
            case "q": System.out.println("quit");
            running = false;
            break;
            default: System.out.println("Error");
            openMenu(running, scanner);
        }
    };
    public static void viewBalance(){};
    public static void withdrawBalance(){};
    public static void depositBalance(){};
    public static void exchangeCurrency(){};
}
