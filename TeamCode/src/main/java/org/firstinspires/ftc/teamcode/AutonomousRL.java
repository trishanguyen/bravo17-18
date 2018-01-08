//Red left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.System.currentTimeMillis;

/**
 * Created by rootroot on 11/12/17.
 */
@Autonomous( name = "AutoRL" )
public class AutonomousRL extends Hardware
{
    long time;

    @Override
    public void runOpMode()
    {
        waitForStart();

        init(hardwareMap);


        long startTime = currentTimeMillis();
        ColorSensor color = hardwareMap.colorSensor.get("colorSensor");
        Servo jewelArm  = hardwareMap.servo.get("jewel");

        while (currentTimeMillis() < startTime + 2000) ;
        if ( color.red() < color.blue())
        {
            omniDrive(.3,Hardware.forward,500);
        }
        else
        {
            omniDrive(.3,Hardware.backward,500);
        }
        jewelArm.setPosition(1.2);




        omniDrive(.5,Hardware.backward);
        chersTimer(1400);
        omniDrive(.25,Hardware.right);
        chersTimer(2000);
        omniDrive(0,Hardware.forward);
    }
}
