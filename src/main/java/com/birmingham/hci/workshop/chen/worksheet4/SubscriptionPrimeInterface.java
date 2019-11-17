package com.birmingham.hci.workshop.chen.worksheet4;

/**
 *  The class describes a prime journal subscription. In addition to a
 *  standard subscription, the customer receives a hardcopy of the
 *  journal. In order to store the corresponding address, where the
 *  hardcopy is to be sent to, a field variable address of type String
 *  is used.
 *
 *  @version 2019-11-04
 *  @author  Manfred Kerber
 */
public interface SubscriptionPrimeInterface {
    /**
     *  A standard getter for the address.
     *  @return The address to which the journal is to be sent.
     */
    public String getAddress();
    
    @Override
    /**
     * Standard toString method to represent the object in a human
     * readable form.
     * @return The object in a human readable form.
     */
    public String toString();
}
