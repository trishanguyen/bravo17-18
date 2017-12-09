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

    @Override
    public void runOpMode()
    {
        waitForStart();

        robot.init(hardwareMap);
            robot.jewel(1);
            while (true) {
                if (robot.scanColor().equals("red")) {
                    robot.omniDrive(1, Hardware.right);
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                        telemetry.addData("ERROR", e.getStackTrace()[0]);
                    }
                    break;
                } else if (robot.scanColor().equals("blue")) {
                    robot.omniDrive(1, Hardware.left);
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e)
                    {
                        telemetry.addData("ERROR", e.getStackTrace()[0]);
                    }
                    break;
                }

            }
    }
}
