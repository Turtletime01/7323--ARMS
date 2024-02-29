package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class ClimberSubsystem extends SubsystemBase{
    private WPI_TalonFX leftArmMotor;
    private WPI_TalonFX rightArmMotor;

    private double maxHeight = 7000; //Will change later
    private double currentHeight = 0;

    public ClimberSubsystem(WPI_TalonFX leftArmMotor, WPI_TalonFX rightArmMotor){
        this.leftArmMotor = leftArmMotor;
        this.rightArmMotor = rightArmMotor;

        leftArmMotor.setSelectedSensorPosition(0);
        rightArmMotor.setSelectedSensorPosition(0);
    
    }

    public void moveArms(double input){
        currentHeight = leftArmMotor.getSelectedSensorPosition();
        double nextHeight = currentHeight + input * Constants.Kinematics.climbDownVoltage;
        double downHeightPercentage = ((Math.abs(nextHeight-maxHeight))/maxHeight);
        double decreaseSpeed = Math.cos((((Math.PI/2)*downHeightPercentage)-Math.PI/8))*2;
        if (nextHeight > maxHeight)
        {
            stopAllMotors();
        }
        else if (input > 0)
        {
            leftArmMotor.setVoltage(input*Constants.Kinematics.climbUpVoltage);
            rightArmMotor.setVoltage(input*Constants.Kinematics.climbUpVoltage);
        }
        else if (input < 0)
        {
            leftArmMotor.setVoltage(input*decreaseSpeed*Constants.Kinematics.climbDownVoltage);
            rightArmMotor.setVoltage(input*decreaseSpeed*Constants.Kinematics.climbDownVoltage);
        }
        else
        {
            stopAllMotors();
        }
    }

    public double getHeight()
    {
        return leftArmMotor.getSelectedSensorPosition();
    }

    public void stopAllMotors()
    {
        leftArmMotor.setVoltage(0);
        rightArmMotor.setVoltage(0);
    }
}
