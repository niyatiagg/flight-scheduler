import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public void readingFromAFile(BufferedReader buffer, List<Node>[] graph) throws IOException {
        for(int i=0; i<10; i++) {
            graph[i] = new ArrayList<>();
        }
        String s = buffer.readLine();
        int n = Integer.parseInt(s);
        for(int i=0; i<n; i++) {
            String text = buffer.readLine();
            String[] input = text.split(" ");
            int first = Integer.parseInt(input[0]);
            int sec = Integer.parseInt(input[1]);
            int third = convertTimeIntoMinutes(input[2]);
            int fourth = convertTimeIntoMinutes(input[3]);
            int fifth = Integer.parseInt(input[5]);
            graph[first].add(new Node(sec, third, fourth, input[4], fifth));
        }

    }
    private int convertTimeIntoMinutes(String timeStamp) {
        int time = Integer.parseInt(timeStamp);
        return (time/100)*60 + time%100;
    }

}
