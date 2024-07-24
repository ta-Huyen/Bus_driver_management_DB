package jdbc.object;

public class BusLines {
    private static int currentId = 100;
    private final int lineId;
    private final double distance;
    private final int busStop;

    public BusLines(int id, double distance, int busStop) {
        this.lineId = (id == 0) ? currentId : id;
        currentId = this.lineId + 1;
        this.distance = distance;
        this.busStop = busStop;
    }

    public int getLineId() {
        return lineId;
    }

    public double getDistance() {
        return distance;
    }

    public int getBusStop() {
        return busStop;
    }

    @Override
    public String toString() {
        return lineId + " - Khoang cach: " + distance + "km - So diem dung: " + busStop;
    }
}
