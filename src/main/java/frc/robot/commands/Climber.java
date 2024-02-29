package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberSubsystem;

public class climber extends CommandBase{
    public ClimberSubsystem climberSubsystem;
    public DoubleSupplier moveArmsInput;

    public climberCommand(ClimberSubsystem subsystem, DoubleSupplier moveArmsInput){
        climberSubsystem = subsystem;
        this.moveArmsInput = moveArmsInput;
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){
        climberSubsystem.stopAllMotors();
    }

    public void execute()
    {
        if (moveArmsInput.getAsDouble() < -0.1)
        {
            climberSubsystem.moveArms(-2.5);
        }
        else if(moveArmsInput.getAsDouble() > 0.1)
        {
            climberSubsystem.moveArms(5);
        }
        else
        {
            climberSubsystem.moveArms(0);
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        climberSubsystem.stopAllMotors();
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }
    
}
