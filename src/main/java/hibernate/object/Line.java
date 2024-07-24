package hibernate.object;

import hibernate.main.Main;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "line")
public class Line {
    @Id
    @Column (name = "id")
    private int id;
    @Column (name = "distance")
    private double distance;
    @Column (name = "bus_stop")
    private int bus_stop;

    public Line() {
    }

    public Line(int id, double distance, int busStop) {
        this.id = Main.lineId++;
        this.distance = distance;
        this.bus_stop = busStop;
    }

    public int getId() {
        return id;
    }

    public double getDistance() {
        return distance;
    }

    public int getBus_stop() {
        return bus_stop;
    }

    @Override
    public String toString() {
        return id + " - Khoang cach: " + distance + "km - So diem dung: " + bus_stop;
    }
}
