package com.tasnim.aast;

public class InKind extends Donation {
    private  String description;

    public InKind(Donor donor, Event event, Designation designation, String description) {
        super(donor, event, designation);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return super.toString()+"InKind{" +
                "description='" + description + '\'' +
                '}';
    }
}
