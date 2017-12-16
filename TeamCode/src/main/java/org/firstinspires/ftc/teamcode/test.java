package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by ad on 12/12/17.
 */
@TeleOp( name = "Test", group = "Linear Opmode" )
public class test extends LinearOpMode {

    public Servo jewelArm;

    public void runOpMode(){

        jewelArm = hardwareMap.servo.get("jewel");
        waitForStart();

        while( opModeIsActive() ) {
            jewelArm.setPosition(0.5);
        }
    }
}
