package com.birmingham.hci.workshop.chen.worksheet4;

/**
 *  The class describes a journal subscription using the title of the
 *  journal, the email address to where the subscription is to be
 *  sent, and the cost in pounds.
 *
 *  @version 2019-11-04
 *  @author  Manfred Kerber
 */
public interface SubscriptionInterface {

    /**
     *  A standard getter for the title.
     *  @return The title of the journal.
     */
    public String getTitle();

    /**
     *  A standard getter for the email.
     *  @return The email address to which the journal is to be sent.
     */
    public String getEmail();

    /**
     *  A standard getter for the cost.
     *  @return The price in GBP the customer has to pay for one issue
     *  of the journal.
     */
    public int getCost();

    /**
     * Standard toString method to represent the object in a human
     * readable form.
     * @return The object in a human readable form.
     */
    public String toString();
}

