// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

import static frc.robot.Constants.Controller.*;

public class DriveJoystick extends CommandBase {
  private Drivebase m_Drivebase;

  /** Creates a new ManualControl. */
  public DriveJoystick(Drivebase drivebase) {
    m_Drivebase = drivebase;

    addRequirements(m_Drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Manual Control Ran");
    double rotateSpeed = JOYSTICK0.getRawAxis(0); // Y joystick is inverted
    double xSpeed = 0; // X drive is inverted
    if (JOYSTICK0.getRawButton(11)) xSpeed = 0.8;
    if (JOYSTICK0.getRawButton(12)) xSpeed = -0.8;
    SmartDashboard.putNumber("xSpeed", xSpeed);
    SmartDashboard.putNumber("ySpeed", rotateSpeed);

    m_Drivebase.drive(rotateSpeed , xSpeed * 0.6);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}