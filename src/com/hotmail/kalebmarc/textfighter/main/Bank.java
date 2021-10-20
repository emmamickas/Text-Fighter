package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

/* Player may visit the Bank to:
* Deposit coins to keep them safe in case of a death
* Withdraw coins from bank account to purchase items
* Open a loan/ pay off a loan in order to purchase items in the case they don't have accessible coins.
* */
public class Bank {

    private static double interest;
    private static int balance;

    public static void menu() {

        int amount;

        //Makes sure user level 2
        if (Xp.getLevel() < 2) {
            Ui.msg("You have to be at least level 2 to use the bank.");
            return;
        }

        while (true) {

            Ui.cls();
            Ui.println("---------------------------------------");
            Ui.println("                BANK              ");
            Ui.println();
            Ui.println("You can deposit your coins into");
            Ui.println("the bank, so they will be safe if");
            Ui.println("you die. However, you will need to");
            Ui.println("pay " + (interest * 100) + "% of what you're depositing");
            Ui.println("every time (Rounded to the nearest ");
            Ui.println("whole number).");
            Ui.println();
            Ui.println("Balance (Coins in the bank): " + get());
            Ui.println("Coins: " + Coins.get());
            Ui.println();
            Ui.println("1) Deposit");
            Ui.println("2) Withdraw");
            Ui.println("3) Loans");
            Ui.println("4) Back");
            Ui.println("---------------------------------------");

            switch (Ui.getValidInt()) {
                case 1:
                    //-----------------------------------------------------------------------------------
                    if (Loan.hasLoan()) {
                        Ui.msg("You can not deposit coins until you pay off your loan!");
                        break;
                    }
                    Ui.println("How much money would you like to deposit? (You will have to pay " + (interest * 100) + "% of this)");
                    Ui.println("You currently have " + Coins.get() + " coins.");
                    do {
                        amount = Ui.getValidInt();
                        if (amount > Coins.get()) {
                            Ui.println("You don't have enough coins. You only have " + Coins.get() + " coins.");
                            amount = -1;
                        }
                    } while (amount < 0);
                    if (amount == 0) return;

                    //Deposit
                    deposit(amount, interest);
                    //-----------------------------------------------------------------------------------
                    break;
                case 2:
                    //-----------------------------------------------------------------------------------
                    Ui.cls();

                    //Input
                    Ui.println("How much money would you like to withdraw?");
                    Ui.println("You currently have " + get() + " coins in your bank.");
                    do {
                        amount = Ui.getValidInt();
                        if (amount > get()) {
                            Ui.println("You don't have enough coins in your bank. You only have " + get() + " coins.");
                            amount = -1;
                        }
                    } while (amount < 0);

                    //Withdraw
                    withdraw(amount);
                    //-----------------------------------------------------------------------------------
                    break;
                case 3:
                    Loan.menu();
                    break;
                case 4:
                    return;
            }
        }
    }

    /**
     * Retrieves current coin balance
     * @return int The total number of coins
     */
    public static int get() {
        return balance;
    }

    /**
     * Updates players balance of coins
     *
     * @param amount the current player balance.
     * @param add add will be false when user saves game to local repository,
     *            add will be true when player is adding coins to bank
     */
    public static void set(int amount, boolean add) {
        if (!add) {
            balance = amount;
        } else {
            balance += amount;
            if (balance < 0) balance = 0;
        }
    }

    /**
     * Sets interest during initial game setup.
     *
     * @param price the current interest rate
     */
    public static void setInterest(double price) {
        interest = price;
    }



    /**
     *  User is withdrawing from their bank account.
     *  Their bank will deduct the amount and coins will be added to the player for use in the game.
     *
     * @param amount total number of coins player is withdrawing from bank account.
     */
    private static void withdraw(int amount) {

        Coins.set(amount, true);
        set(-amount, true);

        //Clears the window and displays the amount.
        Ui.cls();
        Ui.println("Amount withdrawn: " + amount);
        Ui.println("Current Balance: " + get());

        //Waiting for user to press enter to continue
        Ui.pause();
    }


    /**
     *  A player can deposit coins into the bank, so they will be used later if a player dies.
     *  Player will need to pay a fee in order to deposit coins in the bank account.
     *
     * @param amount total number of coins player is depositing into bank account
     * @param interest current interest rate
     */
    private static void deposit(int amount, double interest) {

        //
        interest = interest * amount;
        if (amount < 10) interest = 1;

        //Deduct coins from player
        Coins.set(-amount, true);

        //Deduct the interest fee from deposited amount

        amount -= Math.round(interest);
        Stats.totalCoinsSpent += Math.round(interest);
        Stats.coinsSpentOnBankInterest += Math.round(interest);

        //Add remaining coins to bank account
        set(amount, true);

        //Clear screen and display updated banking information
        Ui.cls();
        Ui.println("Amount Deposited: " + amount + " coins");
        Ui.println("Interest Paid: " + Math.round(interest) + " coins");
        Ui.println("Current Balance: " + get() + " coins");
        Ui.pause();
    }
}
