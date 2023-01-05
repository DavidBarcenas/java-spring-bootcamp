package com.spring.university.backenduniversity.data;

import com.spring.university.backenduniversity.persistence.entity.*;

import java.math.BigDecimal;

public class DummyData {
    public static Career career1() {
        return new Career(null, "Systems Engineering", 60, 5);
    }
    public static Career career2() {
        return new Career(null, "Industry Engineering", 30, 6);
    }
    public static Career career3() {
        return new Career(null, "Travel", 20, 2);
    }

    public static User employee1() {
        return new Employee(null, "Juan", "Perez", "dfresdw4",
                new Address(),
                new BigDecimal(26000), EmployeeType.ADMINISTRATIVE);
    }

    public static User employee2() {
        return new Employee(null, "Leandro", "Lopez", "lkjui23o",
                new Address(),
                new BigDecimal(20000), EmployeeType.MAINTENANCE);
    }

    public static User teacher1() {
        return new Teacher(null, "Romina", "Sanchez", "asdasd34",
                new Address(),
                new BigDecimal(40000));
    }

    public static User studen1() {
        return new Student(null, "Jhon", "Conde", "45gt65ht", new Address());
    }

    public static User studen2() {
        return new Student(null, "Karla", "Ramirez", "loper4p5", new Address());
    }

    public static User studen3() {
        return new Student(null, "Carlos", "Conde", "133lko6i", new Address());
    }
}
