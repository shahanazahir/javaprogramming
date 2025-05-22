package shahanas;
import java.util.*;

interface BillGen {
    int calculate();
}

class productB implements BillGen {
    String name;
    int prod_id, quantity, unit_price, total;
    
    productB() {}

    productB(String n, int p, int q, int u) {
        name = n;
        prod_id = p;
        quantity = q;
        unit_price = u;
    }

    public int calculate() {
        total = quantity * unit_price;
        return total;
    }
}

public class Bill {
    public static void main(String[] args) {
        productB[][] order;
        System.out.println("enter no.of orders: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        order = new productB[n][];
        
        for (int i = 0; i < n; i++) {
            System.out.println("enter no.of products: ");
            int m = sc.nextInt();
            order[i] = new productB[m];
            
            for (int j = 0; j < m; j++) {
                System.out.println("enter product " + j + " Name: ");
                String a = sc.next();
                System.out.println("enter product ID: ");
                int b = sc.nextInt();
                System.out.println("enter product quantity: ");
                int c = sc.nextInt();
                System.out.println("enter product unit_price: ");
                int d = sc.nextInt();
                productB pb = new productB(a, b, c, d);
                order[i][j] = pb;
                order[i][j].total = order[i][j].calculate();
            }
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            System.out.println("order no:" + (i + 1));
            Date date = java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            System.out.println("..........................................");
            System.out.printf("%8s %20s %10s %12s %12s\n", "prod_id", "name", "Quantity", "Unit_Price", "Total");
            System.out.println("..........................................");
            
            for (int j = 0; j < order[i].length; j++) {
                System.out.printf("%8d %20s %10d %12d %12d\n", 
                    order[i][j].prod_id, 
                    order[i][j].name, 
                    order[i][j].quantity, 
                    order[i][j].unit_price, 
                    order[i][j].total);
                System.out.println();
            }
            
            System.out.println("..........................................");
            for (int k = 0; k < order[i].length; k++) sum = sum + order[i][k].total;
            System.out.println("Net Amount : " + sum);
            System.out.println("...........................................");
        }
    }
}
