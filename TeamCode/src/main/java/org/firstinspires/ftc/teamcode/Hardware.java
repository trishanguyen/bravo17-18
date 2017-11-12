package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Hardware {
    public DcMotor MotorFL;
    public DcMotor MotorBL;
    public DcMotor MotorFR;
    public DcMotor MotorBR;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public Hardware(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        MotorFL = hwMap.dcMotor.get("flmotor");
        MotorBL = hwMap.dcMotor.get("blmotor");
        MotorFR = hwMap.dcMotor.get("frmotor");
        MotorBR = hwMap.dcMotor.get("brmotor");

        //Set Motor Directions
        MotorFL.setDirection(DcMotor.Direction.FORWARD);
        MotorBL.setDirection(DcMotor.Direction.FORWARD);
        MotorFR.setDirection(DcMotor.Direction.REVERSE);
        MotorBR.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        MotorFL.setPower(0);
        MotorBL.setPower(0);
        MotorFR.setPower(0);
        MotorBR.setPower(0);

        MotorFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        MotorBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        MotorFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        MotorBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
