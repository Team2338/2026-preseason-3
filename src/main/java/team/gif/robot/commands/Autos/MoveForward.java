package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Constants;
import team.gif.robot.Robot;

public class MoveForward extends Command {
    private double startTime;
    public MoveForward() {
        super();
        addRequirements(Robot.driveTrainC);
        addRequirements(Robot.shooter);
        // uncomment

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        startTime = 0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        startTime +=1;
        Robot.driveTrainC.arcadeD(0, -0.6);
        Robot.shooter.shoot(-Constants.SHOOTER_PERCENT_OUTPUT);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return startTime > 50 * 1.85;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveTrainC.arcadeD(0,0);
    }
}
