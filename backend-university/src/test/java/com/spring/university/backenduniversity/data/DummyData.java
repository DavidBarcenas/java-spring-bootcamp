package com.spring.university.backenduniversity.data;

import com.spring.university.backenduniversity.persistence.entity.Career;

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
}
