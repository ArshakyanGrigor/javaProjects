package com.company;


public class CoffeeShop {
    private String name;
    private MenuItem[] menu;
    private String[] orders;

    public CoffeeShop() {
        this.menu = new MenuItem[100];
        this.orders = new String[100];
    }

    public boolean addOrder(String itemName) {
        boolean isExist = false;
        for (int i = 0; menu[i] != null; i++) {
            if (itemName.equals(menu[i].getName())) {
                orders[dueAmount()] = itemName;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            return true;
        } else {
            System.out.println("This item is currently unavailable!");
            return false;
        }
    }

    public boolean fulfillOrder() {
        if (orders[0] != null) {
            System.out.println("The {item} is ready!");
            return true;
        } else {
            System.out.println("All orders have been fulfilled!");
            return false;
        }
    }

    public String[] listOrders() {
        return orders;
    }

    public int dueAmount() {
        int i = 0;
        while (orders[i] != null)
            i++;
        return i;
    }

    public String cheapestItem() {
        if (menu[0] == null) {
            System.out.println("Menu is empty");
            return "";
        }
        double min = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; menu[i] != null; i++) {
            if (min > menu[i].getPrice()) {
                min = menu[i].getPrice();
                index = i;
            }
        }
        return menu[index].getName();
    }

    public void drinksOnly() {
        for (int i = 0; menu[i] != null; i++) {
            if (menu[i].isType()) {
                System.out.println(menu[i].getName());
            }
        }
    }

    public void foodOnly() {
        for (int i = 0; menu[i] != null; i++) {
            if (!menu[i].isType()) {
                System.out.println(menu[i].getName());
            }
        }
    }
}