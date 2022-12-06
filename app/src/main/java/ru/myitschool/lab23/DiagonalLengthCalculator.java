package ru.myitschool.lab23;

public class DiagonalLengthCalculator implements HexahedronCalculator {
    @Override
    public double calculate(double sideA, double sideB, double sideC) {
        return Math.sqrt(sideA * sideA + sideB * sideB + sideC * sideC);
    }
}
