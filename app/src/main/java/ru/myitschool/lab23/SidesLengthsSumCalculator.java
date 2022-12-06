package ru.myitschool.lab23;

public class SidesLengthsSumCalculator implements HexahedronCalculator {
    @Override
    public double calculate(double sideA, double sideB, double sideC) {
        return 4 * sideA + 4 * sideB + 4 * sideC;
    }
}
