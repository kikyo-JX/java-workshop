package com.birmingham.hci.workshop.chen.worksheet4;

import java.util.ArrayList;

/**
 * A standard account is an account for customers who can download
 * music from the music web site. They are represented by 3 field
 * variables: balance, titlesBought, and failedLoginAttempts of types
 * int, ArrayList<MusicTitle>, and int, respectively. Only three
 * login attempts are possible. If the password is entered 3 times
 * incorrectly, the account is disabled and only an administrator can
 * reinstate it.
 * <p>
 * User: Chen Liu
 * Date: 2019/11/16
 * Time: 11:17 pm
 */
public class AccountStandard extends Account implements AccountStandardInterface {

    /**
     * A fixed number of 3 maximal login attempts
     */
    public final static int MAXIMAL_LOGIN_ATTEMPTS = 3;

    /**
     * The balance in the account
     */
    private int balance;

    /**
     * The titles which are bought by the user in this account
     */
    private ArrayList<MusicTitle> titlesBought = new ArrayList<>();

    /**
     * The number of failed login attempts
     */
    private int failedLoginAttempts;

    /**
     * Constructor
     *
     * @param name       name
     * @param salutation salutation
     * @param email      email
     * @param password   password
     */
    public AccountStandard(String name, String salutation, String email, String password) {
        super(name, salutation, email, password);
    }


    /**
     * Getter method to return the balance.
     *
     * @return The balance of the account.
     */
    @Override
    public int getBalance() {
        return this.balance;
    }

    /**
     * Method for a user to log in to their account by providing a
     * password. It is first checked whether the account is still
     * active (that is, not too many failed login attempts were made
     * in the past) and secondly whether the password provided is
     * correct. In case of a correct login the number of login
     * attempts is reset to 0, else increased by 1.
     *
     * @param password The password provided for the login; this is
     *                 to be compared to the password stored on the system.
     */
    @Override
    public void login(String password) {
        if (this.getFailedLoginAttempts() >= MAXIMAL_LOGIN_ATTEMPTS) {
            // Too many failed login attempts
            System.out.println("This account is disabled due to too many failed login attempts," +
                    "please find an administrator to reinstate it");
        } else {
            if (this.checkPassword(password)) {
                // Password is correct
                // Set failed login attempts to zero
                this.setFailedLoginAttempts(0);
                // login
                this.setLoggedIn(true);
            } else {
                // Password is incorrect
                int currentFailedLoginAttempts = this.getFailedLoginAttempts();
                // Increase failed login attempts
                this.setFailedLoginAttempts(currentFailedLoginAttempts + 1);
            }
        }
    }

    /**
     * Getter method to return the list of all titles bought by the user.
     *
     * @return The current list of titles bought by the user.
     */
    @Override
    public ArrayList<MusicTitle> getTitlesBought() {
        return this.titlesBought;
    }

    /**
     * Adds the amount - if positive - to the current balance. For
     * non-positive amounts the action does nothing.
     *
     * @param amount The amount being deposited.
     */
    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            // amount is positive
            this.balance += amount;
        }
    }

    /**
     * Setter for the balance.
     *
     * @param balance The new balance of the account.
     */
    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Getter method to return the number of failed login attempts.
     *
     * @return The number of failed login attempts.
     */
    @Override
    public int getFailedLoginAttempts() {
        return this.failedLoginAttempts;
    }

    /**
     * Setter for the failed login attempts.
     *
     * @param failedLoginAttempts The new number of failed login attempts.
     */
    @Override
    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    /**
     * If the user is logged in and has sufficient funds, a music
     * title is bought by adding the title to the ArrayList of
     * titlesBought of the customer. Furthermore the price of the
     * title is subtracted from the funds of the customer. If the
     * user is not logged in, a corresponding warning is to be
     * printed. Likewise if the user has insufficient funds, they
     * should be asked to pay money into their account.
     *
     * @param musicTitle The music title that the customer wants to
     *                   buy.
     */
    @Override
    public void buy(MusicTitle musicTitle) {
        if (this.getLoggedIn()) {
            // Logged in
            if (this.getBalance() - musicTitle.getPrice() < 0) {
                // Insufficient funds
                System.out.println("You should pay money into your account before you buy a music");
            } else {
                // Sufficient funds
                this.getTitlesBought().add(musicTitle);
                // The price is subtracted from the funds of the customer
                int balance = this.getBalance();
                this.setBalance(balance - musicTitle.getPrice());
            }
        } else {
            System.out.println("You need login first.");
        }
    }

    /**
     * Standard toString method to represent the object in a human
     * readable form. If the user is not logged in, only a warning
     * should be printed, but no substantial information be given.
     *
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        if (!this.getLoggedIn()) {
            // Login first
            return "First a login is necessary";
        }
        return "AccountStandard{" +
                "balance=" + balance +
                ", titlesBought=" + titlesBought +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", name='" + name + '\'' +
                ", salutation='" + salutation + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
