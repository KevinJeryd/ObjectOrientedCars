import java.awt.*;

public interface Vehicle {
    int getNrDoors();
    double getEnginePower();
    double getCurrentSpeed();
    Color getColor();
    void setColor(Color clr);
    void startEngine();
    void stopEngine();
    void setCurrentSpeed(double currentSpeed);
    double speedFactor();
    void incrementSpeed(double amount);
    void decrementSpeed(double amount);
    void gas(double amount);
    void brake(double amount);
}
