package com.dugstudio.pmms.entity;

public class Good extends BaseEntity{
    private int number;
    private User clickUser;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public User getClickUser() {
        return clickUser;
    }

    public void setClickUser(User clickUser) {
        this.clickUser = clickUser;
    }
}
