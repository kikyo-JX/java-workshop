package com.learning.worksheet4.Ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.birmingham.hci.workshop.chen.worksheet4.Subscription;
import com.birmingham.hci.workshop.chen.worksheet4.SubscriptionInterface;
import com.birmingham.hci.workshop.chen.worksheet4.SubscriptionPrime;
import com.birmingham.hci.workshop.chen.worksheet4.SubscriptionPrimeInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Public tests for Exercise 2, Worksheet 4.
 * 
 * @author Alexandros Evangelidis
 * @version 2019-11-15
 */
public class SubscriptionTests {

  private SubscriptionInterface sub1;
  private SubscriptionPrime subPrime1;
  private Subscription sub2;

  @BeforeEach
  public void init() {
    sub1 = new Subscription("Financial Times", "mary@mary.org", 2);
    subPrime1 = new SubscriptionPrime("Garden News", "josh@josh.org", 3, "CS Birmingham");
    sub2 = new SubscriptionPrime("Athletic News", "jack@jack.org", 4, "Bristol street 15092");
  }

  // testing sub1's getTitle()
  @Test
  public void test1() {
    String expectedTitle = "Financial Times";
    String actualTitle = sub1.getTitle();
    assertEquals(expectedTitle, actualTitle, "title should be: " + expectedTitle);
  }

  // testing sub1's getEmail()
  @Test
  public void test2() {
    String expectedEmail = "mary@mary.org";
    String actualEmail = sub1.getEmail();
    assertEquals(expectedEmail, actualEmail, "mail should be: " + expectedEmail);
  }

  // testing sub1's getCost()
  @Test
  public void test3() {
    int expectedCost = 2;
    int actualCost = sub1.getCost();
    assertEquals(expectedCost, actualCost, "cost should be: " + expectedCost);
  }

  // testing subPrime1's getTitle()
  @Test
  public void test4() {
    String expectedTitle = "Garden News";
    String actualTitle = subPrime1.getTitle();
    assertEquals(expectedTitle, actualTitle, "title should be: " + expectedTitle);
  }

  // testing subPrime1's getEmail()
  @Test
  public void test5() {
    String expectedEmail = "josh@josh.org";
    String actualEmail = subPrime1.getEmail();
    assertEquals(expectedEmail, actualEmail, "mail should be: " + expectedEmail);

  }

  // testing subPrime1's getCost()
  @Test
  public void test6() {
    int expectedCost = 3;
    int actualCost = subPrime1.getCost();
    assertEquals(expectedCost, actualCost, "cost should be: " + expectedCost);
  }

  // testing subPrime1's getAddress()
  @Test
  public void test7() {
    String expectedDeliveryAddress = "CS Birmingham";
    String actualDeliveryAddress = subPrime1.getAddress();
    assertEquals(expectedDeliveryAddress, actualDeliveryAddress,
        "address should be: " + expectedDeliveryAddress);
  }

  // testing getAddress()
  @Test
  public void test8() {
    SubscriptionPrimeInterface subPrime2 =
        new SubscriptionPrime("Garden News", "josh@josh.org", 3, "New Street 5005");
    String expectedAddress = "New Street 5005";
    String actualAddress = subPrime2.getAddress();
    assertEquals(expectedAddress, actualAddress, "address should be: " + expectedAddress);
  }

  // testing sub2's getTitle
  @Test
  public void test9() {
    String expectedTitle = "Athletic News";
    String actualTitle = sub2.getTitle();
    assertEquals(expectedTitle, actualTitle, "title should be: " + expectedTitle);
  }

  // testing sub2's getEmail()
  @Test
  public void test10() {
    String expectedEmail = "jack@jack.org";
    String actualEmail = sub2.getEmail();
    assertEquals(expectedEmail, actualEmail, "email should be: " + expectedEmail);
  }

  // testing sub2's getCost()
  @Test
  public void test11() {
    int expectedCost = 4;
    int actualCost = sub2.getCost();
    assertEquals(expectedCost, actualCost, "cost should be: " + expectedCost);
  }
}
