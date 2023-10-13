package main;

public class Friend
{
    private int user_id;
    private String name;
    private double latitude, longitude;

    public Friend(int user_id, String name, double latitude, double longitude) {
        this.user_id = user_id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
