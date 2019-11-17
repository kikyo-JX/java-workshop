package com.birmingham.hci.workshop.chen.worksheet4;

import java.util.ArrayList;

/**
 * AccountAdminstrator is a sub-class of Account. An adminstrator can
 * reset the accounts of standard users (in case they hae forgotten
 * their password or have attempted to login unsuccessfully to
 * often). An administrator can have arbitrarily many unsuccessful
 * login attempts.
 * <p>
 * User: Chen Liu
 * Date: 2019/11/16
 * Time: 11:52 pm
 */
public class AccountAdministrator extends Account implements AccountAdministratorInterface {

    /**
     * A list of standard accounts
     */
    private ArrayList<Account> accounts = new ArrayList<>();

    /**
     * Constructor
     *
     * @param name       name
     * @param salutation salutation
     * @param email      email
     * @param password   password
     */
    public AccountAdministrator(String name, String salutation, String email, String password) {
        super(name, salutation, email, password);
    }

    /**
     * Getter method to return the list of accounts the administrator
     * looks after.
     *
     * @return The list of accounts the administrator looks after.
     */
    @Override
    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    /**
     * The method adds an account to the list of accounts the
     * administrator looks after.
     *
     * @param customer The new account to be added to the list of accounts
     *                 the administrator looks after.
     */
    @Override
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    /**
     * If an account can no longer be used, since either the user has
     * forgotten their password or in case of a standard user has
     * entered the password incorrectly too often the administrator
     * can reset the account by setting a new password and resetting
     * the number of failed login attempts to zero (the latter only
     * if the account is a standard account).
     *
     * @param account  The account that is to be reset.
     * @param password The new password for the account that is to be
     *                 reset.
     */
    @Override
    public void resetAccount(Account account, String password) {
        if (this.accounts.contains(account)) {
            // account is looked after by this administrator
            // Reset password
            account.setPassword(password);
            if (account instanceof AccountStandard) {
                // account is a instance of AccountStandard
                // Reset failed login attempts to zero
                ((AccountStandard) account).setFailedLoginAttempts(0);
            }
        }
    }

    /**
     * Method for an adminstrator to log in by providing a
     * password. It is checked whether the password provided is
     * correct.
     *
     * @param password The password provided for the login; this is
     *                 to be compared to the password stored on the system.
     */
    @Override
    public void login(String password) {
        super.login(password);
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
        return "AccountAdministrator{" +
                "accounts=" + accounts +
                ", name='" + name + '\'' +
                ", salutation='" + salutation + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}
