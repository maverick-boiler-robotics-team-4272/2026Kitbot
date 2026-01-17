package frc.robot.utils;

import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

public class Kraken extends TalonFX{
    public Kraken(int id) {
        super(id);
    }

    @Override
    public void set(double speed) {
        this.setControl(new DutyCycleOut(speed).withEnableFOC(true));
    }
}
