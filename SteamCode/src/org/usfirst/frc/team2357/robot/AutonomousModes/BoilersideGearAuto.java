package org.usfirst.frc.team2357.robot.AutonomousModes;

import org.usfirst.frc.team2357.robot.commands.DriveDistance;
import org.usfirst.frc.team2357.robot.commands.DriveUntilPegged;
import org.usfirst.frc.team2357.robot.commands.TurnToFixedAngle;
import org.usfirst.frc.team2357.robot.commands.TurnToVisionAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BoilersideGearAuto extends CommandGroup {

    public BoilersideGearAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveDistance(113.39));
    	addSequential(new TurnToFixedAngle(-60.0, true));
    	addSequential(new TurnToVisionAngle());
    	addSequential(new DriveDistance(6)); //TODO Requires Tuning
    	addSequential(new TurnToVisionAngle());
    	addSequential(new DriveUntilPegged(36));
    	addSequential(new DriveDistance(-48));
    	addSequential(new TurnToFixedAngle(60, true));
    	addSequential(new DriveDistance(60));
    	
    }
}
