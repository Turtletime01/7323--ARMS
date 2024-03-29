// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/* 
import java.util.List;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.USB;
*/

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ClimberCommand;
import frc.robot.subsystems.ClimberSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

        // The robot's subsystems and commands are defined here...
        private ClimberSubsystem climberSubsystem;

        private final XboxController controller = new XboxController(0);
        Trigger bButton = new JoystickButton(controller, XboxController.Button.kB.value);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
        public RobotContainer() {
                InitializeSubsystems();    
                // Configure the button bindings
                AssignCommands();
        }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

        private void InitializeSubsystems()
        {
                WPI_TalonFX leftArmMotor = new WPI_TalonFX(23);
                WPI_TalonFX rightArmMotor = new WPI_TalonFX(22);
                climberSubsystem = new ClimberSubsystem(leftArmMotor, rightArmMotor);
        }

        private void AssignCommands() 
        {
                Command climberCommand = new ClimberCommand(
                        climberSubsystem,
                        () -> -controller.getRawAxis(3)); 
                
                climberSubsystem.setDefaultCommand(climberCommand);
        }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
        // public Command getProgrammingSomeSleep()
        //ASkfhgkjbSLCHKSlkhkjsdng;ksjrth;kjsrkjgaso;dfhljerhglsehrg :D
  //      }
}
