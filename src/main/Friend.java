package main;

public class Friend
{
    // Friend class to create friend objects with attributes and the Search function.
    private int user_id;
    private String name;
    private double latitude, longitude;

    public Friend(int user_id, String name, double latitude, double longitude) {
        this.user_id = user_id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Method to search friends by calculating the great-circle distance
    public boolean SearchFriend(double searchLat, double searchLon) {
        double radius = 6371.0; // Radius of the Earth in kilometers
        // Converting the latitude and longitude coordinates from degrees to radians.
        // This is done so that the Haversine formula for calculating great-circle distance can be used.
        double lat1Rad = Math.toRadians(searchLat);
        double lon1Rad = Math.toRadians(searchLon);
        double lat2Rad = Math.toRadians(this.latitude);
        double lon2Rad = Math.toRadians(this.longitude);

        // Calculating differences in latitude and longitude
        double dlat = lat2Rad - lat1Rad;
        double dlon = lon2Rad - lon1Rad;

        // Writing the Haversine formula in code
        // a = sin²(dlat/2) + cos(lat1) * cos(lat2) * sin²(dlon/2)
        // c = 2 * atan2(sqrt(a), sqrt(1 - a))
        // distance = R * c
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2)
                + Math.cos(lat1Rad) * Math.cos(lat2Rad)
                * Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // the calculated distance (in km)
        double distance = radius * c;

        // checking that the friend is within 100km of St. Stephen's Green
        // returns True or False.
        return distance <= 100.0;
    }
    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

}
