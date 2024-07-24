package hibernate.object;

import hibernate.control.DriverControl;
import hibernate.control.LineControl;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "assignment")
public class Assignment {
    @Id
    private int id;
    @Column (name = "driver_id")
    private int driver_id;
    @Column (name = "line_id")
    private int line_id;
    @Column (name = "turns")
    private int turns;

    public Assignment() {
    }

    public Assignment(int driverId, int lineId, int turns) {
        this.driver_id = driverId;
        this.line_id = lineId;
        this.turns = turns;
    }

    public String getDriverName() {
        Driver driver = DriverControl.findById(driver_id);
        return (driver == null) ? String.valueOf(driver_id) : driver.getName();
    }

    public double getDrivingDistance() {
        Line line = LineControl.findById(line_id);
        return (line == null) ? 0 : (line.getDistance() * turns);
    }

    public int getId() {
        return id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public int getLine_id() {
        return line_id;
    }

    public void setTurns(int turns) {
        this.turns += turns;
    }

    public int getTurns() {
        return turns;
    }

    @Override
    public String toString() {
        return driver_id + " - Lai xe " + getDriverName() + " - Tuyen xe " + line_id + " - " + turns + " luot";
    }
}
