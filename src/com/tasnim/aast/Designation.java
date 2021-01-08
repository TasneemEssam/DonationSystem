package com.tasnim.aast;

import java.util.UUID;

public class Designation {
 private String designationID;
 private String designationName;

    public Designation(String designationName) {
        this.designationID = UUID.randomUUID().toString(); ;
        this.designationName = designationName;
    }

    public String getDesignationID() {
        return designationID;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    @Override
    public String toString() {
        return "Designation{" +
                "designationID='" + designationID + '\'' +
                ", designationName='" + designationName + '\'' +
                '}';
    }
}
