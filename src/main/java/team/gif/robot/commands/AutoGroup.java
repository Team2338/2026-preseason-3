package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoGroup extends SequentialCommandGroup {
    public AutoGroup () {
        addCommands(new AutosForward(), new AutosShooter());
    }
}
