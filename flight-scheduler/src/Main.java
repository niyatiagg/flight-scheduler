import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 10;
        List<Node>[] graph = new List[n];

        // reading data from a file into the graph
        FileReader file = new FileReader("resources/input");
        BufferedReader buffer = new BufferedReader(file);
        Input input = new Input();
        input.readingFromAFile(buffer, graph);

        // reading query from file and computing ans;
        FileReader file1 = new FileReader("resources/query");
        BufferedReader buf = new BufferedReader(file1);
        FlightScheduler fs = new FlightScheduler();
        int[][] ans = fs.query(buf, graph);
        for(int i=0; i<ans.length; i++) {
            if(ans[i][2] > -1) {
                System.out.println("Cheapest flight from " + ans[i][0] + " to " + ans[i][1] + " costs :" + ans[i][2]);
            } else {
                System.out.println("No flights from " + ans[i][0] + " to " + ans[i][1] + " during this period.");
            }
        }
    }
}