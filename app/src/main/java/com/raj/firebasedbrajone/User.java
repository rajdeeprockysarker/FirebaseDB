package com.raj.firebasedbrajone;

import java.util.Objects;

public class User {
    public String fName="";
    public String lNam="";

    public User(String fName, String lNam) {
        this.fName = fName;
        this.lNam = lNam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return fName.equals(user.fName) &&
                lNam.equals(user.lNam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, lNam);
    }
}
