import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class ProductProfit {
    String name;
    int profit;

    ProductProfit(String name, int profit) {
        this.name = name;
        this.profit = profit;
    }
}

class Quantity {
    int q;

    Quantity(int z) {
        q = z;
    }

    void add_q(int z) {
        q += z;
    }

    boolean sub_q(int z) {
        if (q >= z) {
            q -= z;
            return true;
        } else {
            System.out.println("Not enough stock! Available: " + q);
            return false;
        }
    }
}

public class Order extends Quantity {
    static final int MAX_VALUE = 100;

    Order(int z) {
        super(z);
    }

    static void add_o(Order product, int quantity) {
        product.add_q(quantity);
    }

    static boolean input_o(Order product, int quantity) {
        return product.sub_q(quantity);
    }

    // Cost Prices
    static int Pen_c = 5;
    static int TB_c = 15;
    static int HB_c = 50;
    static int MS_c = 10;

    // Product Instances
    static Order Pen = new Order(MAX_VALUE);
    static Order TB = new Order(MAX_VALUE);
    static Order HB = new Order(MAX_VALUE);
    static Order MS = new Order(MAX_VALUE);

    // Selling Prices
    static int Pen_p = 20;
    static int TB_p = 50;
    static int HB_p = 120;
    static int MS_p = 30;

    // Discounts (as percentage)
    static int Pen_discount = 0;
    static int TB_discount = 0;
    static int HB_discount = 0;
    static int MS_discount = 0;

    // Quantities Sold
    static int Pen_sold = 0;
    static int TB_sold = 0;
    static int HB_sold = 0;
    static int MS_sold = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orderCount = 0;
        int userChoice;

        do {
            System.out.println("\nEnter:");
            System.out.println("1] Create Order");
            System.out.println("2] Add Quantity");
            System.out.println("3] Display Quantities");
            System.out.println("4] Gross Profit");
            System.out.println("5] Profit Ranking");
            System.out.println("6] Set Discount");
            System.out.println("7] Finish");

            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    createOrder(scanner);
                    orderCount++;
                    System.out.println("Orders placed today: " + orderCount);
                    break;
                case 2:
                    addQuantity(scanner);
                    break;
                case 3:
                    displayQuantities();
                    break;
                case 4:
                    showGrossProfit();
                    break;
                case 5:
                    showProfitRanking();
                    break;
                case 6:
                    System.out.print("Enter discount % : ");
                    int discount = scanner.nextInt();
                    setDiscounts(discount);
                    break;
                case 7:
                    System.out.println("It was a GREAT DAY!!");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (userChoice != 7);

        scanner.close();
    }

    static void createOrder(Scanner scanner) {
        int productChoice;
        int orderAmount = 0;

        do {
            System.out.println("\nSelect product to order:");
            System.out.println("1] Seed Pen");
            System.out.println("2] Wooden Tooth Brush");
            System.out.println("3] Handmade Books");
            System.out.println("4] Metal Straws");
            System.out.println("5] Finish");

            productChoice = scanner.nextInt();

            switch (productChoice) {
                case 1:
                    System.out.print("Enter quantity for Seed Pen: ");
                    int penQty = scanner.nextInt();
                    if (input_o(Pen, penQty)) {
                        Pen_sold += penQty;
                        orderAmount += getDiscountedPrice(Pen_p, Pen_discount) * penQty;
                    }
                    break;
                case 2:
                    System.out.print("Enter quantity for Wooden Tooth Brush: ");
                    int tbQty = scanner.nextInt();
                    if (input_o(TB, tbQty)) {
                        TB_sold += tbQty;
                        orderAmount += getDiscountedPrice(TB_p, TB_discount) * tbQty;
                    }
                    break;
                case 3:
                    System.out.print("Enter quantity for Handmade Books: ");
                    int hbQty = scanner.nextInt();
                    if (input_o(HB, hbQty)) {
                        HB_sold += hbQty;
                        orderAmount += getDiscountedPrice(HB_p, HB_discount) * hbQty;
                    }
                    break;
                case 4:
                    System.out.print("Enter quantity for Metal Straws: ");
                    int msQty = scanner.nextInt();
                    if (input_o(MS, msQty)) {
                        MS_sold += msQty;
                        orderAmount += getDiscountedPrice(MS_p, MS_discount) * msQty;
                    }
                    break;
                case 5:
                    System.out.println("Order Complete.");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (productChoice != 5);

        System.out.println("Total Order Amount: ₹" + orderAmount);

        // Reset discount after the order
        Pen_discount = TB_discount = HB_discount = MS_discount = 0;
    }

    static void addQuantity(Scanner scanner) {
        int productChoice;

        do {
            System.out.println("\nWhich product to add?");
            System.out.println("1] Seed Pen");
            System.out.println("2] Wooden Tooth Brush");
            System.out.println("3] Handmade Books");
            System.out.println("4] Metal Straws");
            System.out.println("5] Finish");

            productChoice = scanner.nextInt();

            switch (productChoice) {
                case 1:
                    System.out.print("Enter quantity to add for Seed Pens: ");
                    add_o(Pen, scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter quantity to add for Wooden Tooth Brushes: ");
                    add_o(TB, scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter quantity to add for Handmade Books: ");
                    add_o(HB, scanner.nextInt());
                    break;
                case 4:
                    System.out.print("Enter quantity to add for Metal Straws: ");
                    add_o(MS, scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Finished adding quantities.");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (productChoice != 5);
    }

    static void displayQuantities() {
        System.out.println("\nAvailable Quantities:");
        System.out.println("Seed Pens: " + Pen.q);
        System.out.println("Wooden Tooth Brushes: " + TB.q);
        System.out.println("Handmade Books: " + HB.q);
        System.out.println("Metal Straws: " + MS.q);
    }

    static void showGrossProfit() {
        int revenue = (Pen_sold * getDiscountedPrice(Pen_p, Pen_discount)) + (TB_sold * getDiscountedPrice(TB_p, TB_discount)) + (HB_sold * getDiscountedPrice(HB_p, HB_discount)) + (MS_sold * getDiscountedPrice(MS_p, MS_discount));
        int cost = (Pen_sold * Pen_c) + (TB_sold * TB_c) + (HB_sold * HB_c) + (MS_sold * MS_c);
        int grossProfit = revenue - cost;

        System.out.println("\nGross Profit Summary:");
        System.out.println("Total Revenue: ₹" + revenue);
        System.out.println("Total Cost: ₹" + cost);
        System.out.println("Gross Profit: ₹" + grossProfit);
    }

    static void showProfitRanking() {
        List<ProductProfit> productList = new ArrayList<>();

        productList.add(new ProductProfit("Seed Pen", (Pen_p - Pen_c) * Pen_sold));
        productList.add(new ProductProfit("Wooden Tooth Brush", (TB_p - TB_c) * TB_sold));
        productList.add(new ProductProfit("Handmade Books", (HB_p - HB_c) * HB_sold));
        productList.add(new ProductProfit("Metal Straws", (MS_p - MS_c) * MS_sold));

        Collections.sort(productList, (a, b) -> b.profit - a.profit);

        System.out.println("\nProducts Ranked by Profit:");
        for (ProductProfit p : productList) {
            System.out.println(p.name + " → ₹" + p.profit);
        }
    }

    static int getDiscountedPrice(int price, int discountPercent) {
        return price - (price * discountPercent / 100);
    }

    static void setDiscounts(int local_discount) {
        Pen_discount = local_discount;
        TB_discount = local_discount;
        HB_discount = local_discount;
        MS_discount = local_discount;
        System.out.println("Discounts updated successfully.");
    }
}
