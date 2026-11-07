// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package team.gif.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import team.gif.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
    /** Creates a new ExampleSubsystem. */

    private WPI_TalonSRX lMotor;
    private WPI_TalonSRX rMotor;
    private DifferentialDrive differentialDrive;
    public DriveTrain() {
        lMotor = new WPI_TalonSRX(RobotMap.L_MOTOR_ID);
        lMotor.configFactoryDefault();
        lMotor.setNeutralMode(NeutralMode.Brake);

        rMotor = new WPI_TalonSRX(RobotMap.R_MOTOR_ID);
        rMotor.configFactoryDefault();
        rMotor.setNeutralMode(NeutralMode.Brake);

        differentialDrive = new DifferentialDrive(lMotor, rMotor);
    }
    public void arcadeD(double speed, double turn) {
        differentialDrive.arcadeDrive(speed, turn);
    }

}
