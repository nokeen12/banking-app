import java.util.Scanner; //scanner used for gathering user input in command line

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        if(running){
            openMenu(running, scanner);
        }
        //text
        System.out.println("Welcome To Cordre's Premium Banking Services");
        System.out.println("Would you like to view your current balance?(v)");
        System.out.println("Current Balance is: ");
        System.out.println("Deposit balance(d)");
        System.out.println("Withdraw balance(w)");
        System.out.println("Exchange currencies(e)");
        System.out.println("Available currencies are: ");
        System.out.println("Go back(b)");
        System.out.println("Quit(q)");
    };
    public static void openMenu(boolean running, Scanner scanner){};
    public static void viewBalance(){};
    public static void withdrawBalance(){};
    public static void depositBalance(){};
    public static void exchangeCurrency(){};
}
