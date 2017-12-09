//Blue right
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by rootroot on 11/12/17.
 */
@Autonomous( name = "AutuBR" )
public class AutonomousBR extends LinearOpMode
{
    long time;
    Hardware robot   = new Hardware();
    @Override
    public void runOpMode()
    {
        waitForStart();

        robot.init(hardwareMap);

        robot.omniDrive(.5,Hardware.backward);
        time = System.currentTimeMillis();
        while (System.currentTimeMillis() < time + 1300);
        robot.omniDrive(.25,Hardware.right);
        time = System.currentTimeMillis();
        while(System.currentTimeMillis() < time + 300);
        robot.omniDrive(0,Hardware.forward);


    }
}
