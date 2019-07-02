package pl.rbudner.learn.littlegrid.model;

public enum Gender {

    FEMALE("Female"), MALE("Male");

    private String gender;

    // todo-rb usunąć modyfikator dostępu
    Gender(String gender) {
        this.gender = gender;
    }

    // todo ogólne
    public String getGender() {
        return gender;
    }

}
