package ru.myitschool.lab23;

public class FullAreaCalculator implements HexahedronCalculator {
    @Override
    public double calculate(double sideA, double sideB, double sideC) {
        return 2 * (sideA * sideB + sideB * sideC + sideA * sideC);
    }
}
