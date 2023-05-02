import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class FlightScheduler {
    public int[][] query(BufferedReader buffer, List<Node>[] graph) throws IOException {
        String s = buffer.readLine();
        int n = Integer.parseInt(s);
        int[][] ans = new int[n][3];
        for(int i=0; i<n; i++) {
            String text = buffer.readLine();
            String[] input = text.split(" ");
            int first = Integer.parseInt(input[0]);
            int sec = Integer.parseInt(input[1]);
            int third = convertTimeIntoMinutes(input[2]);
            int fourth = convertTimeIntoMinutes(input[3]);
            ans[i][0] = first;
            ans[i][1] = sec;
            ans[i][2] = cheapestFlight(first, sec, third, fourth, graph);
        }
        return ans;
    }
    private int cheapestFlight(int src, int dst, int after, int before, List<Node>[] graph) {
    int[] price = new int[10];
    Arrays.fill(price, Integer.MAX_VALUE);
    price[src] = 0;
    Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> price[a.city]));
    pq.offer(new Node(src, after, 0, 0));

    while(!pq.isEmpty()) {
        Node source = pq.poll();
        for(Node interm : graph[source.city]) {
            int dep = interm.dep_time;
            int arr = interm.arrival_time;
            if(dep < after || arr > before || dep - source.arrival_time < 30) {
                continue;
            }
            if(price[interm.city] > price[source.city] + interm.price) {
                price[interm.city] = price[source.city] + interm.price;
                pq.offer(new Node(interm.city, dep, arr, price[interm.city]));
            }
        }
    }
    return price[dst] == Integer.MAX_VALUE ? -1 : price[dst];
    }
    private int convertTimeIntoMinutes(String timeStamp) {
        int time = Integer.parseInt(timeStamp);
        return (time/100)*60 + time%100;
    }
}
