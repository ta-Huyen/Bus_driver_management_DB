package jdbc.object;

public class AssignmentBoard {
    private final BusDriver driver;
    private final BusLines line;
    private int turns;

    public AssignmentBoard(BusDriver driver, BusLines line, int turns) {
        this.driver = driver;
        this.line = line;
        this.turns = turns;
    }

    public double getDrivingDistance() {
        return (line.getDistance() * turns);
    }

    public BusDriver getDriver() {
        return driver;
    }

    public BusLines getLine() {
        return line;
    }

    public void setTurns(int turns) {
        this.turns += turns;
    }

    public int getTurns() {
        return turns;
    }

    @Override
    public String toString() {
        return "Lai xe " + driver.getName() + " - Tuyen xe " + line.getLineId() + " - " + turns + " luot";
    }

}
