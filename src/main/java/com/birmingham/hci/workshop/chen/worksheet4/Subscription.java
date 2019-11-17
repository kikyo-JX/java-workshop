package com.birmingham.hci.workshop.chen.worksheet4;

/**
 * The class describes a journal subscription using the title of the
 * journal, the email address to where the subscription is to be
 * sent, and the cost in pounds.
 * <p>
 * User: Chen Liu
 * Date: 2019/11/16
 * Time: 10:38 pm
 */
public class Subscription implements SubscriptionInterface {

    /**
     * The title of a subscription
     */
    protected String title;

    /**
     * The email to where the subscription is to be sent
     */
    protected String email;

    /**
     * The cost of a subscription
     */
    protected int cost;

    /**
     * Constructor
     *
     * @param title title
     * @param email email
     * @param cost  cost
     */
    public Subscription(String title, String email, int cost) {
        this.title = title;
        this.email = email;
        this.cost = cost;
    }

    /**
     * A standard getter for the title.
     *
     * @return The title of the journal.
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * A standard getter for the email.
     *
     * @return The email address to which the journal is to be sent.
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * A standard getter for the cost.
     *
     * @return The price in GBP the customer has to pay for one issue
     * of the journal.
     */
    @Override
    public int getCost() {
        return this.cost;
    }

    /**
     * Standard toString method to represent the object in a human
     * readable form.
     *
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        return "Subscription{" +
                "title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", cost=" + cost +
                '}';
    }
}
