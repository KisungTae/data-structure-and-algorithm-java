package com.company.objectorienteddesign.question2review;

abstract public class Employee {

    public String name;
    public boolean free;

    protected void takeCall(Call call) {
        free = false;
    }

    protected void endCall(Call call) {
        free = true;
    }
}
