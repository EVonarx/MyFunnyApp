package com.example.FunnyApp.controller1;

import com.example.FunnyApp.models.Person;

public final class Controller1 {

    private static Controller1 monInstance = null;
    private Person myPerson;

    private Controller1() {
        super();
    }

    public static final Controller1 getMonInstance() {
        if(monInstance ==null){
            Controller1.monInstance = new Controller1();
        }
        return monInstance;
    }

    public void createPerson(String strName, Integer iSex, Integer iAge){
        myPerson  = new Person(strName, iSex, iAge);
    }

    public Person getMyPerson() {
        return myPerson;
    }
}
