package casestudy;

import java.util.Scanner;

public class CaseStudy {
    
    static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        
        char opt;
        double bal;
        boolean valid;
        boolean continueprogram = true;
        
        System.out.println("WELCOME to ABC BANK");
        
        do {
            bal = enter_Initbal();
            valid = validate_InitAmt(bal);
        } while (!valid);
        
        do {
        display_Menu(bal);
        opt = chk_SelOpt();
        
        switch (opt) {
            case 'D' -> { bal = make_Deposit(bal); continueprogram = chk_YN(); }
            case 'W' -> { bal = make_Wdraw(bal); continueprogram = chk_YN(); }
            case 'Q' -> continueprogram = quit_Program();
            }
        
        } while (continueprogram);
        
        System.out.println("\nThank you for using the program.");
    }
    
    // USED TO ENTER THE USER'S INITIAL BALANCE --------------------------------
    
    static double enter_Initbal(){
        
        System.out.print("\nEnter your initial balance: ");
        return sc.nextDouble();
    }
    
    // DISPLAYS THE MAIN MENU AFTER VALIDATION OF INITIAL BALANCE --------------
    
    static void display_Menu(double bal){
        System.out.println("\nWELCOME to ABC BANK\n");
         
        System.out.printf("Your current balance is P %,.2f%n", bal);
         
        System.out.println("\nD - Make deposit");
        System.out.println("W - Make withdrawal");
        System.out.println("Q - Quit");
        
    }
    
    // USED FOR DEPOSIT OPTION -------------------------------------------------
    
    static double make_Deposit(double bal){
        
        double balchkr = bal;
        
        System.out.printf("\nYour current balance is P %,.2f%n", bal);
        
        System.out.print("\nEnter amount to Deposit: ");
        double deposit = sc.nextDouble();
        
        bal = validate_DepAmt(deposit, bal);
        
        if (bal != balchkr) {
                System.out.printf("\nYour new balance is P %,.2f%n", bal);
        }
        
        return bal;
    }
    
    // USED FOR WITHDRAWAL OPTION ----------------------------------------------
    
    static double make_Wdraw(double bal){
        
        System.out.print("\nEnter amount to Withdraw: ");
        double withdraw = sc.nextDouble();
        
        bal = validate_WdrawAmt(withdraw, bal);
        
        return bal;
    }
    
// ===============================VALIDATORS====================================
    
    // VALIDATES INITIAL BALANCE -----------------------------------------------
    
    static boolean validate_InitAmt(double bal){
        
        if (bal <= 0 ){
            System.out.println("Invalid Amount, Initial balance must not be "
                    + "less than 0");
            return false;
        } else if (bal < 5000) {
            System.out.println("Invalid Amount, Minimum Initial Balance is P "
                    + "5000");
            return false;
        } else if (bal > 500000) {
            System.out.println("Invalid Amount, Initial Balance must not be greater "
                    + "than 500,000");
            return false;
        }
        else
            System.out.println("Initial Balance accepted!");
        return true;
    }
    
    // VALIDATES DEPOSIT AMOUNT ------------------------------------------------
    
    static double validate_DepAmt(double deposit, double bal){
        
        if (deposit <= 0){
            System.out.println("Deposit Amount must be greater than zero");
        } else if (deposit > 500000) {
            System.out.println("Deposit Amount must not be greater than P "
                    + "500,000");    
        } else {
            bal += deposit;
            System.out.println("Deposit Transaction is successfully completed.");
        }
        
        return bal;
    }
    
    // VALIDATES WITHDRAWAL AMOUNT ---------------------------------------------
    
    static double validate_WdrawAmt(double withdraw, double bal){
        
        if (withdraw <= 0){
            System.out.println("Withdrawal Amount must not be less than or "
                    + "equal to zero");
        } else if (withdraw > bal) {
            System.out.printf("Withdrawal Amount must not be greater than %,.2f%n" 
                    , bal);    
        } else if (withdraw % 100 != 0) { // 100 % 100 = 0 != 0
            System.out.println("Withdrawal Amount must be exactly divisible by 100");
        } else {
            bal -= withdraw; 
            System.out.println("Withdrawal Transaction is successfully completed.");
        }   
            
        return bal;
    }
    
    // VALIDATES THE SELECTED OPTION IN MAIN MENU ------------------------------
    
    static char chk_SelOpt(){
         
        while (true) {
         
            System.out.print("\nSelect an option: ");
            char selectedOpt = sc.next().charAt(0);
            selectedOpt = Character.toUpperCase(selectedOpt);
         
            switch (selectedOpt) {
                case 'D', 'W', 'Q' -> {
                    return selectedOpt;
                }
                default -> System.out.println("Invalid entry, "
                        + "enter any valid option: D/W/Q");
            }
        }
    }
    
    // VALIDATES IF THE TRANSACTION SHOULD CONTINUE ----------------------------
    
    static boolean chk_YN (){
        
        while (true){
        
        System.out.print("\nWant to Transact another (Y/N)? ");
        char chkYN = sc.next().charAt(0);
        chkYN = Character.toUpperCase(chkYN);
        
        switch (chkYN){
            case 'Y' -> { return true; }
            case 'N' -> { return false; }
            default -> System.out.println("Invalid entry, enter Y or N only");
            }    
        } 
    }

// =============================================================================    
    
    static boolean quit_Program(){
        
        while (true) {
        
        System.out.print("\nDo you really want to terminate the program? (Y/N) ");
        char ctn = sc.next().charAt(0);
        ctn = Character.toUpperCase(ctn);
        
        switch  (ctn){
            case 'Y' -> { return false; }
            case 'N' -> { return true; }
            default -> System.out.println("Invalid entry, enter Y or N only");
            }
        }
    }
}
