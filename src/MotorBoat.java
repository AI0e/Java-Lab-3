import java.util.Objects;

/**
 * Represents a Motor Boat class as required by Lab 3, Variant 3.
 * This class is immutable (fields are final) and validates
 * input in its constructor.
 */
public class MotorBoat {

    private final String model;
    private final int passengerCapacity;
    private final double maxSpeed; // in knots
    private final double price;
    private final String engineType;

    /**
     * Constructs a new MotorBoat with specified details.
     * Validates all input parameters.
     *
     * @param model             The model name (non-empty).
     * @param passengerCapacity The maximum number of passengers (positive).
     * @param maxSpeed          The maximum speed in knots (positive).
     * @param price             The price of the boat (non-negative).
     * @param engineType        The type of engine (non-empty).
     * @throws IllegalArgumentException if any argument is invalid.
     */
    public MotorBoat(String model, int passengerCapacity, double maxSpeed, double price, String engineType) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Model must be non-empty.");
        }
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be positive.");
        }
        if (maxSpeed <= 0) {
            throw new IllegalArgumentException("Max speed must be positive.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non-negative.");
        }
        if (engineType == null || engineType.trim().isEmpty()) {
            throw new IllegalArgumentException("Engine type must be non-empty.");
        }

        this.model = model;
        this.passengerCapacity = passengerCapacity;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return String.format(
                "Boat[Model: %-15s | Capacity: %2d | Max Speed: %.1f kn | Price: $%.2f | Engine: %s]",
                model, passengerCapacity, maxSpeed, price, engineType);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        MotorBoat motorBoat = (MotorBoat) obj;
        return passengerCapacity == motorBoat.passengerCapacity &&
                Double.compare(motorBoat.maxSpeed, maxSpeed) == 0 &&
                Double.compare(motorBoat.price, price) == 0 &&
                model.equals(motorBoat.model) &&
                engineType.equals(motorBoat.engineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, passengerCapacity, maxSpeed, price, engineType);
    }
}