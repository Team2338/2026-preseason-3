package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;

public class AutoDriveBackward extends Command {
    private double timeStart;


    public AutoDriveBackward() {
        super();
        addRequirements(Robot.driveTrainC); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        timeStart = 0;
    }

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        timeStart += 1;
        Robot.driveTrainC.arcadeD(0,-0.8);

    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return timeStart > (50*3);
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.driveTrainC.arcadeD(0,0);
    }
}
