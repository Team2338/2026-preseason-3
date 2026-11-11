package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

import java.sql.Time;
import edu.wpi.first.wpilibj.Timer;

public class AutoShoot extends Command {
    private double Time;

    public AutoShoot() {
        super();
        addRequirements(Robot.shooter);
        //addRequirements(Robot.climber); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        Time = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        Time+=1;
        Robot.shooter.moveMotor(Constants.SHOOTER_PERCENT_OUTPUT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return Time > 50;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.shooter.moveMotor(0);
    }
}
