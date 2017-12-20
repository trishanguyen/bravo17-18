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
public class AutonomousBL extends LinearOpMode
{
    Hardware robot   = new Hardware();
    long time;
    @Override
    public void runOpMode()
    {
        waitForStart();

        robot.init(hardwareMap);

        long startTime = currentTimeMillis();
        ColorSensor color = hardwareMap.colorSensor.get("colorSensor");
        Servo jewelArm  = hardwareMap.servo.get("jewel");

        while (currentTimeMillis() < startTime + 2000) ;
        if ( color.red() > color.blue()) //hits the blue if red is bigger
        {
            robot.omniDrive(.3,Hardware.backward,500);
        }
        else
        {
            robot.omniDrive(.3,Hardware.forward,500);
        }
        jewelArm.setPosition(1.2);

        robot.omniDrive(.5,Hardware.backward);
        time = System.currentTimeMillis();
        while (System.currentTimeMillis() < time + 1400);
        robot.omniDrive(.25,Hardware.left);
        time = System.currentTimeMillis();
        while(System.currentTimeMillis() < time + 2000);
        robot.omniDrive(0,Hardware.forward);
    }
}
