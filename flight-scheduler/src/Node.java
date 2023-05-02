public class Node {
    String flight_no;
    int arrival_time;
    int dep_time;
    int city;
    int price;
    public Node(int city, int dep_time, int arrival_time, String flight_num, int price) {
        this.city = city;
        this.flight_no = flight_num;
        this.arrival_time = arrival_time;
        this.dep_time = dep_time;
        this.price = price;
    }
    public Node(int city, int dep_time, int arrival_time, int price) {
        this.city = city;
        this.arrival_time = arrival_time;
        this.dep_time = dep_time;
        this.price = price;
    }
}
