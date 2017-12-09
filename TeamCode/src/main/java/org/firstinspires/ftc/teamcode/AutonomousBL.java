//Blue Left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

            robot.omniDrive(.5,Hardware.backward);
            time = System.currentTimeMillis();
            while (System.currentTimeMillis() < time + 1400);
            robot.omniDrive(.25,Hardware.left);
            time = System.currentTimeMillis();
            while(System.currentTimeMillis() < time + 2000);
            robot.omniDrive(0,Hardware.forward);
    }
}
