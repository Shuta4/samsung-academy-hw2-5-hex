package ru.myitschool.lab23;

public class VolumeCalculator implements HexahedronCalculator {
    @Override
    public double calculate(double sideA, double sideB, double sideC) {
        return sideA * sideB * sideC;
    }
}
