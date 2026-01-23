// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.RobotContainer.joystick;

import java.util.function.DoubleSupplier;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  SparkFlex motor = new SparkFlex(7, MotorType.kBrushless);
  SparkFlexConfig config = new SparkFlexConfig();
  public Intake() { //horrible motor config
    config.smartCurrentLimit(40,60);
    config.inverted(false);
    config.idleMode(IdleMode.kBrake);
    motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    //... so disgusting
  }

  public void set(double speed) {
    motor.set(speed);
  }
  public Runnable runIntake(DoubleSupplier speed) {
    return (() -> motor.set(speed.getAsDouble())); // This is NOT it's own custome class now... YAY!!!
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // motor.set(joystick.getLeftTriggerAxis() + 0.25);
  }
}
