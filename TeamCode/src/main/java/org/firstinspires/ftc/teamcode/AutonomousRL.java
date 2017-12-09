//Red left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by rootroot on 11/12/17.
 */
@Autonomous( name = "AutoRL" )
public class AutonomousRL extends LinearOpMode
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
        while (System.currentTimeMillis() < time + 1400);
        robot.omniDrive(.25,Hardware.right);
        time = System.currentTimeMillis();
        while(System.currentTimeMillis() < time + 2000);
        robot.omniDrive(0,Hardware.forward);
    }
}
