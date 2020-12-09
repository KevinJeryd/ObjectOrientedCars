public class VehicleFactory {
    public Vehicle saabCreator (Direction direction, int x, int y) {
        return new Saab95(direction, x, y);
    }

    public Vehicle volvoCreator (Direction direction, int x, int y) {
        return new Volvo240(direction, x, y);
    }

    public Vehicle volvoTransportCreator (Direction direction, int x, int y) {
        return new VolvoTransport(direction, x, y);
    }

    public Vehicle scaniaCreator (Direction direction, int x, int y) {
        return new Scania(direction, x, y);
    }

    public Saab95 saab95Creator (Direction dir, double x, double y) {
        return new Saab95(dir, x, y);
    }
}
