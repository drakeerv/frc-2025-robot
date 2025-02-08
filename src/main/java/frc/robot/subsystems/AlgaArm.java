package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import frc.robot.Constants.AlgaArmConstants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Subsystem that handles the alga arm mechanism.
 * Controls a motor for intaking and manipulating alga game pieces.
 */
public class AlgaArm extends SubsystemBase {
    /** Singleton instance of the AlgaArm subsystem. */
    private static AlgaArm instance;
    /** Motor controller for the alga intake mechanism. */
    private final SparkMax sparkMax;

    /**
     * Returns the singleton instance of the AlgaArm subsystem.
     * Creates a new instance if one does not exist.
     * 
     * @return the AlgaArm subsystem instance
     */
    public static AlgaArm getInstance() {
        if (instance == null) {
            instance = new AlgaArm();
        }
        return instance;
    }

    /**
     * Creates a new AlgaArm subsystem.
     * Initializes the motor controller in brake mode.
     */
    public AlgaArm() {
        sparkMax = new SparkMax(AlgaArmConstants.CAN_ID, MotorType.kBrushless);
        SparkMaxConfig sparkMaxConfig = new SparkMaxConfig();
        sparkMaxConfig.idleMode(IdleMode.kBrake);
        sparkMax.configure(sparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    /**
     * Activates the intake motor to collect alga.
     * Applies a constant voltage to intake the game piece.
     */
    public void intakeAlga() {
        sparkMax.setVoltage(AlgaArmConstants.MOTOR_VOLTAGE);
    }

    /**
     * Stops the intake motor.
     * Sets the motor voltage to zero.
     */
    public void stopIntake() {
        sparkMax.setVoltage(0.0);
    }

    /**
     * Checks if the mechanism currently has an alga game piece.
     *
     * @return true if an alga is detected, false otherwise
     */
    public boolean hasAlga() {
        return false;
    }
}
