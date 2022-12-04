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
        String currency = "$";
        if(running){
            openMenu(running, scanner, balance, currency);
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
        // currencies [ $(dollar), €(euro), £(pound) ]
    };
    public static void openMenu(boolean running, Scanner scanner, Integer balance, String currency){
        System.out.println("Welcome To Cordre's Premium Banking Services");
        System.out.println("Would you like to view your current balance?(v)");
        System.out.println("Deposit balance(d)");
        System.out.println("Withdraw balance(w)");
        System.out.println("Quit(q)");
        String value = scanner.next().toLowerCase();
        switch(value){
            case "v": 
                viewBalance(running, scanner, balance, currency);
                break;
            case "d": 
                depositBalance(running, scanner, balance, currency);
                break;
            case "w": 
                withdrawBalance(running, scanner, balance, currency);
                break;
            case "q": 
                running = false;
                break;
            default: 
                System.out.println("Error");
                openMenu(running, scanner, balance, currency);
        }
    };
    public static void viewBalance(boolean running, Scanner scanner, Integer balance, String currency){
        //currency array
        System.out.println("Current Balance is: " + currency + balance);
        System.out.println("Exchange currencies(e)");
        System.out.println("Go back(b)");
        String value = scanner.next().toLowerCase();
        switch(value){
            case "e": 
                exchangeCurrency(running, scanner, balance, currency);
                break;
            case "b": 
                openMenu(running, scanner, balance, currency);
                break;
            case "q": 
                running = false;
                break;
            default: 
                System.out.println("Error");
                viewBalance(running, scanner, balance, currency);
        }
    };
    public static void withdrawBalance(boolean running, Scanner scanner, Integer balance, String currency){
        System.out.println("Current Balance is: " + currency + balance);
        System.out.println("How much would you like to withdraw?");
        System.out.println("Go back(b)");
        String value = scanner.next().toLowerCase();
        try{
            int withAmount = Integer.parseInt(value);
            if(withAmount > balance){
                System.out.println("Insufficient funds");
                withdrawBalance(running, scanner, balance, currency);
            }else{
                balance -= withAmount;
                System.out.println("Withdrew: " + currency + withAmount);
                withdrawBalance(running, scanner, balance, currency);
            }
        }catch(NumberFormatException e){
            switch(value){
                case "b": 
                    openMenu(running, scanner, balance, currency);
                    break;
                case "q": 
                    running = false;
                    break;
                default: 
                    System.out.println("Error");
                    withdrawBalance(running, scanner, balance, currency);
            }
        }
    };
    public static void depositBalance(boolean running, Scanner scanner, Integer balance, String currency){
        System.out.println("Current Balance is: " + currency + balance);
        System.out.println("How much would you like to deposit?");
        System.out.println("Go back(b)");
        String value = scanner.next().toLowerCase();
        try{
            int depoAmount = Integer.parseInt(value);
            balance += depoAmount;
            depositBalance(running, scanner, balance, currency);
        }catch(NumberFormatException e){
            switch(value){
                case "b": 
                    openMenu(running, scanner, balance, currency);
                    break;
                case "q": 
                    running = false;
                    break;
                default: 
                    System.out.println("Error");
                    depositBalance(running, scanner, balance, currency);
            }
        }
    };
    public static void exchangeCurrency(boolean running, Scanner scanner, Integer balance, String currency){
        System.out.println("Current Balance is: " + currency + balance);
        System.out.println("Current currencies are: Dollar(d), Pound(p), Euro(e)");
        System.out.println("Go back(b)");
        String value = scanner.next().toLowerCase();
        switch(value){
            case "e": 
                if(currency == "€"){
                    System.out.println("Error: Currently Selected");
                }else if(currency == "$"){
                    balance = (int)(balance / 1.05);
                }else if(currency == "£"){
                    balance = (int)(balance * 1.17);
                }
                currency = "€";
                exchangeCurrency(running, scanner, balance, currency);
                break;
            case "p": 
                if(currency == "£"){
                    System.out.println("Error: Currently Selected");
                }else if(currency == "$"){
                    balance = (int)(balance / 1.17);
                }else if(currency == "€"){
                    balance = (int)(balance / 1.23);
                }
                currency = "£";
                exchangeCurrency(running, scanner, balance, currency);
                break;
            case "d": 
                if(currency == "$"){
                    System.out.println("Error: Currently Selected");
                }else if(currency == "£"){
                    balance = (int)(balance * 1.23);
                }else if(currency == "€"){
                    balance = (int)(balance * 1.05);
                }
                currency = "$";
                exchangeCurrency(running, scanner, balance, currency);
                break;
            case "b": 
                viewBalance(running, scanner, balance, currency);
                break;
            case "q": 
                running = false;
                break;
            default: 
                System.out.println("Error");
                exchangeCurrency(running, scanner, balance, currency);
        }
    };
}
