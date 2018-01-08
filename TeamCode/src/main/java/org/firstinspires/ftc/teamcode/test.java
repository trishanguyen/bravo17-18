package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.System.currentTimeMillis;

/**
 * Created by ad on 12/12/17.
 */
@TeleOp( name = "Test", group = "Linear Opmode" )
public class test extends LinearOpMode
{
    DcMotor elevatorMotor;
    Servo armL, armR;
    boolean closed = true;
    boolean xReleased = true;
    public void runOpMode()
    {

        Servo armR = hardwareMap.servo.get("armR");
        Servo armL = hardwareMap.servo.get("armL");
        waitForStart();
        armL.setPosition(.5);
        armR.setPosition(.5);
        while(opModeIsActive()) {
            armR.setPosition(.66);
            armL.setPosition(.12);
        }




        //        long startTime = currentTimeMillis();
//        jewelArm.setPosition(.5);
//        jewelArm.setPosition(.25);
//        jewelArm.setPosition(0);
//        while (currentTimeMillis() < startTime + 2000) ;
//        if ( color.red() > color.blue()) //hits the blue if red is bigger
//        {
//            omniDrive(.3,Hardware.backward,500);
//        }
//        else
//        {
//            omniDrive(.3,Hardware.forward,500);
//        }
//        jewelArm.setPosition(1.2);
    }

    public void closeGripper()
    {
        if(closed )
        {
            armR.setPosition(.66);
            armL.setPosition(.12);
            closed = false;
        }

        else
        {
            armR.setPosition(.28);
            armL.setPosition(.30);

            closed = true;
        }

    }
}