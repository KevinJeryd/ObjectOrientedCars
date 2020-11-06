import java.awt.*;

public interface Vehicle {
    public int getNrDoors();
    public double getEnginePower();
    public double getCurrentSpeed();
    public Color getColor();
    public void setColor(Color clr);
    public void startEngine();
    public void stopEngine();
    public void setCurrentSpeed(double currentSpeed);
    public double speedFactor();
    public void incrementSpeed(double amount);
    public void decrementSpeed(double amount);
    public void gas(double amount);
    public void brake(double amount);
}
