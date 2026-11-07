package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import team.gif.robot.Robot;
import team.gif.robot.subsystems.DriveTrain;

public class ArcadeDrives extends Command {

    public ArcadeDrives() {
        super();
        addRequirements(Robot.driveTrainC); // uncomment
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs (~20ms) while the command is scheduled
    @Override
    public void execute() {
        double speed = Robot.oi.driver.getRightX();
        double turn = -Robot.oi.driver.getLeftY();
        Robot.driveTrainC.arcadeD(speed, turn);
    }

    // Return true when the command should end, false if it should continue. Runs every ~20ms.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called when the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
