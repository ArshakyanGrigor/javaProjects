package com.company;

public class Store {
    private int countOfWorkers;
    private String name;
    private String phoneNumber;
    private int productNumber;

    public Store() {
    }

    public Store(int countOfWorkers, String name, String phoneNumber, int productNumber) {
        setCountOfWorkers(countOfWorkers);
        setName(name);
        setPhoneNumber(phoneNumber);
        this.productNumber = productNumber;
    }

    public int getCountOfWorkers() {
        return countOfWorkers;
    }

    public void setCountOfWorkers(int countOfWorkers) {
        if (countOfWorkers < 2 || countOfWorkers > 50) {
            System.out.println("Count of workers must be in range 2 - 50");
        } else {
            this.countOfWorkers = countOfWorkers;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) {
            System.out.println("Name must have at least 3 characters");
        } else {
            this.name = name;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8) {
            System.out.println("Phone number must have 8 digits");
            return;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            if (ch > '9' || ch < '0') {
                System.out.println("Phone number must have 8 digits");
                break;
            }
        }
        this.phoneNumber = phoneNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void sellProduct() {
        if (productNumber != 0) {
            productNumber--;
        } else {
            System.out.println("We don`t have product");
        }
    }
}