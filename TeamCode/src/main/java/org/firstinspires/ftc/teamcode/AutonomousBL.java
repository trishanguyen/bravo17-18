//Blue Left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.System.currentTimeMillis;

/**
 * Created by rootroot on 11/12/17.
 */
@Autonomous( name = "AutoBL" )
public class AutonomousBL extends HardwareSad
{
    public Servo armL,armR,armLUpper,armRUpper,jewelArm;
    long time;
    @Override
    public void runOpMode()
    {
        armL = hardwareMap.servo.get("armL");
        armR = hardwareMap.servo.get("armR");
        waitForStart();

        init(hardwareMap);

//        long startTime = currentTimeMillis();
//        ColorSensor color = hardwareMap.colorSensor.get("colorSensor");
//        Servo jewelArm  = hardwareMap.servo.get("jewel");
        armR.setPosition(.56);
        armL.setPosition(.35);
        elevator(-1);
        chersTimer(100);
        elevator(0);
/*
        while (currentTimeMillis() < startTime + 2000) ;
        if ( color.red() > color.blue()) //hits the blue if red is bigger
        {
            sadDrive(.3,Hardware.backward,500);
        }
        else
        {
            sadDrive(.3,Hardware.forward,500);
        }*/
//        jewelArm.setPosition(1.2);

        sadDrive(.5,Hardware.backward,2400);
        
        sadDrive(0,Hardware.forward);
    }
}
