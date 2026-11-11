package team.gif.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class AutosShooter extends Command {
    private double timeStart;


    public AutosShooter() {
        super();
        addRequirements(Robot.shooter);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timeStart = Timer.getFPGATimestamp();
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        timeStart += 1;
        Robot.shooter.moveMotor(Constants.SHOOTER_PERCENT_OUTPUT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return timeStart > (50);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.shooter.moveMotor(0);
    }
}
