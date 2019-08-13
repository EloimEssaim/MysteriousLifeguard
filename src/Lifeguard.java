import java.io.*;
import java.util.Arrays;
import java.util.TreeSet;

public class Lifeguard {
    public static void main(String[] args) throws Exception {
        for(int index = 1; index <= 10; index++) {
            String filename = "src/input/" + index + ".in";
            BufferedReader input = new BufferedReader(new FileReader(filename));
            int n = Integer.parseInt(input.readLine());
            Guard[] guardArr = new Guard[n * 2];
            for(int i = 0; i < n ; i++) {
                String timeString = input.readLine();
                String[] splitArr = timeString.split(" ");
                int start = Integer.parseInt(splitArr[0]);
                int end = Integer.parseInt(splitArr[1]);
                guardArr[2 * i] = new Guard(start, i);
                guardArr[2 * i + 1] = new Guard(end, i);
            }

            Arrays.sort(guardArr);

            TreeSet<Integer> treeSet = new TreeSet<>();
            int[] covered = new int[n];
            int lastPosition = 0;
            int total = 0;
            for(Guard guard : guardArr) {
                if(!treeSet.isEmpty()) {
                    total += guard.startTime - lastPosition;
                }
                if(treeSet.size() == 1) {
                    covered[treeSet.first()] += guard.startTime - lastPosition;
                }
                if(treeSet.contains(guard.groupId)) {
                    treeSet.remove(guard.groupId);
                } else {
                    treeSet.add(guard.groupId);
                }

                lastPosition = guard.startTime;
            }

            int result = 0;
            for(int c : covered) {
                result = Math.max(result, total - c);
            }

            PrintWriter output = new PrintWriter(new FileWriter(index + ".out"));
            output.println(result);
            output.close();
            input.close();

        }
    }

}