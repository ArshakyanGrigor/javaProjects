package com.company;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private String sex;
    private String passportId;

    public Person() {

    }

    public Person(String firstName, String secondName, int age, String sex, String passportId) {
        setFirstName(firstName);
        setSecondName(secondName);
        setAge(age);
        setSex(sex);
        setPassportId(passportId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName.length() < 3 || firstName.length() > 15) {
            System.out.println("First name must be have 3 - 15 letters");
        } else {
            this.firstName = firstName;
        }
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName.length() < 6 || secondName.length() > 20) {
            System.out.println("First name must be have 6 - 20 letters");
        } else {
            this.secondName = secondName;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 99) {
            System.out.println("Age must be in range 18-99");
        } else {
            this.age = age;
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex.compareToIgnoreCase("female") == 0 || sex.compareToIgnoreCase("male") == 0) {
            this.sex = sex;
        }
        else {
            System.out.println("Sex must be male or female");
        }
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passport) {
        if (passport.length() != 8) {
            System.out.println("must be start with AN and contain 6 digits with length 8");
            return;
        }
        boolean isMatched = true;
        char[] charArray = passport.toCharArray();
        for (int i = 2; i < charArray.length; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                isMatched = false;
                System.out.println("must be start with - AN and contain 6 digits with length 8");
                break;
            }
        }
        if (isMatched) {
            if (!passport.startsWith("AN")) {
                System.out.println("must be start with - AN and contain 6 digits with length 8");
            }  else {
                this.passportId = passport;
            }
        }
    }

    public  void printInfo(){
        System.out.println("Person { " + "firstName = " + firstName  + ", secondName = " + secondName +
                ", age = " + age + ", sex = " + sex + ", passportId = " + passportId + " }");
    }
}
