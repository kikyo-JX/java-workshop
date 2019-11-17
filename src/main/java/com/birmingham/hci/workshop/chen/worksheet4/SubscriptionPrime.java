package com.birmingham.hci.workshop.chen.worksheet4;

/**
 * The class describes a prime journal subscription. In addition to a
 * standard subscription, the customer receives a hardcopy of the
 * journal. In order to store the corresponding address, where the
 * hardcopy is to be sent to, a field variable address of type String
 * is used.
 * <p>
 * User: Chen Liu
 * Date: 2019/11/16
 * Time: 10:53 pm
 */
public class SubscriptionPrime extends Subscription implements SubscriptionPrimeInterface {

    /**
     * Where hard copies of the journal should be sent to
     */
    private String deliveryAddress;

    /**
     * A standard getter for the address.
     *
     * @return The address to which the journal is to be sent.
     */
    @Override
    public String getAddress() {
        return this.deliveryAddress;
    }

    /**
     * Standard toString method to represent the object in a human
     * readable form.
     *
     * @return The object in a human readable form.
     */
    @Override
    public String toString() {
        return "SubscriptionPrime{" +
                "deliveryAddress='" + deliveryAddress + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", cost=" + cost +
                '}';
    }

}
