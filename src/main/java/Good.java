/**
 * User: Chen Liu
 * Date: 2019/10/20
 * Time: 9:22 pm
 */
public class Good {
    /**
     * name
     */
    private String name;

    /**
     * netPrice
     */
    private double netPrice;

    /**
     * VAT rate
     */
    private final static double VAT_RATE = 0.2;

    public double grossPrice() {
        return this.netPrice * (1 + VAT_RATE);
    }

    /**
     * discount
     *
     * @param rate rate
     */
    public void discount(double rate) {
        if (0 < rate && rate < 100) {
            this.netPrice *= (100 - rate) / 100;
        }
    }

    // constructor
    public Good(String name, double netPrice) {
        this.name = name;
        this.netPrice = netPrice;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    @Override
    public String toString() {
//        return "The " + this.name + " has a gross price of \u00A3 " + this.grossPrice() + ".";
        return String.format("The %s has a gross price of \u00A3 %.2f.", this.name, this.grossPrice());
    }

    public static void main(String[] args) {
        Good milk = new Good("Milk", 0.50);
        System.out.println(milk);
        milk.discount(20);
        System.out.println(milk);
    }
}
