package main.animals;

public enum HumanFriendsEnum {
    DOG("Dog"),
    CAT("Cat"),
    HAMSTER("Hamster"),
    HORSE("Horse"),
    CAMEL("Camel"),
    DONKEY("Donkey");

    private String title;

    HumanFriendsEnum(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
