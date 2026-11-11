package team.gif.robot.commands.Autos;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class MoveBackward extends Command {
    private double startTime;
    public MoveBackward() {
        super();
        addRequirements(Robot.driveTrainC);
        addRequirements(Robot.shooter);
        // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        startTime = Timer.getFPGATimestamp();
        Robot.shooter.shoot(0);
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        startTime +=1;
        Robot.driveTrainC.arcadeD(0, 0.6);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return startTime > 50 * 2;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveTrainC.arcadeD(0,0);
    }
}
