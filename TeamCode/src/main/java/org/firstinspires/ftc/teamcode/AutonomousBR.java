//Blue right
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.System.currentTimeMillis;

/**
 * Created by rootroot on 11/12/17.
 */
@Autonomous( name = "AutuBR" )
public class AutonomousBR extends HardwareSad
{
    long time;
    public Servo armL,armR,armLUpper,armRUpper,jewelArm;
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

        armR.setPosition(.28);
        armL.setPosition(.70);

//        jewelArm.setPosition(0.0);
//        while (currentTimeMillis() < startTime + 2000) ;
//        if ( color.red() > color.blue())
//        {
//            sadDrive(.3,Hardware.backward,500);
//        }
//        else
//        {
//            sadDrive(.3,Hardware.forward,500);
//        }
//        jewelArm.setPosition(1.2);

        sadDrive(.5,Hardware.backward,1300);
        sadDrive(.25,Hardware.right,400);
        sadDrive(1,Hardware.backward,100);
        sadDrive(0,Hardware.forward);


    }
}
