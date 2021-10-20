package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Xp;
/**
Loan class is used as a tool for players to save coins.
If a player saves coins then they can retrieve coins after death.
Players must pay an interest rate if they have a loan. A player can only have one loan at a time.
 */
public class Loan {

    private static final double INTEREST_RATE = 0.15;
    private static int currentLoan;
    private static int netDue;

    public static void menu() {
        while (true) {
            Ui.cls();
            Ui.println("-------------------------------");
            Ui.println("          PLAYER LOAN          ");
            Ui.println();
            Ui.println("Current interest rate: " + INTEREST_RATE);
            Ui.println("Max loan amount: " + getMaxLoan());
            Ui.println("Current loan: " + currentLoan);
            Ui.println("-------------------------------");
            Ui.println("Net due: " + netDue);
            Ui.println("Interest due: " + (netDue * INTEREST_RATE));
            Ui.println("Gross due: " + getGrossDue());
            Ui.println("-------------------------------");
            Ui.println("1) Get loan");
            Ui.println("2) Pay off loan");
            Ui.println("3) Back");
            switch (Ui.getValidInt()) {
                case 1:
                    createLoan();
                    break;
                case 2:
                    payLoan();
                    break;
                case 3:
                    return;
            }
        }
    }

    /**
     * Create a loan for the user if requested. A user can only have one loan.
     */
    private static void createLoan() {

        if (hasLoan()) {
            Ui.msg("You can not request a loan while you already have one.");
            return;
        }

        Ui.cls();
        Ui.println("Enter the amount you would like");
        Ui.println("to borrow.");
        Ui.println("Your max amount allowed is " + getMaxLoan());
        int request = Ui.getValidInt();

        if (request > getMaxLoan()) {
            Ui.msg("Your max amount you can borrow is " + getMaxLoan() + "!");
            return;
        }
        if (request <= 0) {
            Ui.msg("You must enter at least 1 coin.");
            return;
        }

        //Give loan
        Coins.set(request, true);
        currentLoan = request;
        netDue = request;
        Ui.cls();
        Ui.println("You have borrowed " + request + " from the bank.");
        Ui.println("You will not be able to deposit coins into the bank until your loan is fully paid off.");
        Ui.pause();
    }

    /**
     * Pay off loan in full or a portion of the loan. Player cannot deposit coins until loan is paid.
     */
    private static void payLoan() {
        if (getGrossDue() == 0) {
            Ui.println("You must enter at least 1 coin.");
            Ui.pause();
            return;
        }

        Ui.cls();
        Ui.println("You currently owe " + getGrossDue() + " coins, and have " + Coins.get() + " with you.");
        Ui.println("You will not be able to deposit coins into the bank until your loan is fully paid off.");
        Ui.println("How much would you like to pay off?");
        int amountToPay = Ui.getValidInt();

        Ui.cls();
        if (Coins.get() < amountToPay) {
            Ui.println("You don't have enough coins.");
            Ui.pause();
            return;
        }

        if (amountToPay <= 0) {
            Ui.println("You must enter at least 1 coin.");
            Ui.pause();
            return;
        }

        if (amountToPay > getGrossDue()) {
            Ui.println("You only owe " + getGrossDue() + "! Enter a small amount");
            Ui.pause();
        }
        netDue = getGrossDue() - amountToPay;
        Coins.set(-amountToPay, true);

        Ui.println("You have paid back " + amountToPay + " coins.\nYou now have " + getGrossDue() + " left to pay.");
        if (getGrossDue() == 0) currentLoan = 0;
        Ui.pause();
    }

    /**
     * Max Loan is the players level * 100
     * @return int max loan amount is determined by the players current level
     */
    private static int getMaxLoan() {
        return Xp.getLevel() * 100;
    }

    /**
     * Get the players current loan.
     * @return int Players current loan amount
     */
    public static int getCurrentLoan() {
        return currentLoan;
    }

    /**
     * Set the players current loan amount
     * @param loan int loan amount
     */
    public static void setCurrentLoan(int loan) {
        currentLoan = loan;
    }

    /**
     * Checks to see if the Player has a loan.
     * @return true if player currently has a loan. Player cannot have > 1 loans
     * @return false if player doesn't have outstanding loan amount.
     */
    public static boolean hasLoan() {
        return getCurrentLoan() > 0;
    }

    /**
     * Getting total loan amount, loan + interest
     * @return int total amount owed to the bank.
     */
    public static int getGrossDue() {
        return (int) (netDue + (netDue * INTEREST_RATE));
    }

    /**
     * Getting net amount owed to the bank. (Loan amount)
     * @return int loaned amount
     */
    public static int getNetDue() {
        return netDue;
    }

    /**
     * Setting loan amount
     * @param due loan amount
     */
    public static void setNetDue(int due) {
        netDue = due;
    }
}
