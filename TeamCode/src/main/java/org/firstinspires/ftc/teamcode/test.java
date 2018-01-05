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
public class test extends Hardware {
    DcMotor elevatorMotor;
    Servo armL, armR;
    public void runOpMode(){
        
        elevatorMotor = hardwareMap.dcMotor.get("elevatormotor");
        armL = hardwareMap.servo.get( "armL");
        armR = hardwareMap.servo.get( "armR");

        waitForStart();



        closeGripper();


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
}
