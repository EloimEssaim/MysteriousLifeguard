public class Guard implements Comparable<Guard>{
    int startTime;
    int groupId;
    public Guard(int startTime, int groupId) {
        this.startTime = startTime;
        this.groupId = groupId;
    }

    public int compareTo(Guard guard) {
        return startTime - guard.startTime;
    }
}
