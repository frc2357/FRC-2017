package org.usfirst.frc.team2357.robot.subsystems;

import org.usfirst.frc.team2357.robot.RobotMap;
import org.usfirst.frc.team2357.robot.Config;
import org.usfirst.frc.team2357.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveSub extends Subsystem {
	private CANTalon leftDrive = new CANTalon(RobotMap.LEFT_DRIVE_CAN_2);
	private CANTalon rightDrive = new CANTalon(RobotMap.RIGHT_DRIVE_CAN_1);
	private CANTalon leftDriveSlave = new CANTalon(RobotMap.LEFT_DRIVE_CAN_1);
	private CANTalon rightDriveSlave = new CANTalon(RobotMap.RIGHT_DRIVE_CAN_2);
	private RobotDrive robotDrive = new RobotDrive(leftDrive, rightDrive);
	
	public DriveSub(){
		//leftDriveSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		//leftDriveSlave.set(RobotMap.LEFT_DRIVE_CAN_2);
		//leftDriveSlave.reverseOutput(true);
		rightDriveSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightDriveSlave.set(RobotMap.RIGHT_DRIVE_CAN_1);
		//rightDriveSlave.reverseOutput(true);
		robotDrive.setSafetyEnabled(false);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	if (Config.driveMode == 0){
    		setDefaultCommand(new ArcadeDriveCommand());
    	}else{
    		setDefaultCommand(new TankDriveCommand());
    	}
    }
    
    public void arcadeDrive(double moveValue, double rotateValue) {
    	robotDrive.arcadeDrive(moveValue, rotateValue);
    }
    
    public void tankDrive(double leftValue, double rightValue){
    	robotDrive.tankDrive(leftValue, rightValue);
    }
    public void stop() {
    	arcadeDrive(0.0, 0.0);
    }
}

