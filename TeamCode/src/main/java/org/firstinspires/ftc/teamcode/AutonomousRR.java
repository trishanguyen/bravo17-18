//Red left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous( name = "AutoRR" )
public class AutonomousRR extends LinearOpMode
{

    Hardware robot = new Hardware();
    double DRIVE_POWER = 1.0;
    private ElapsedTime period  = new ElapsedTime();


    @Override
    public void runOpMode()
    {



        waitForStart();


        robot.omniDrive( DRIVE_POWER,Hardware.forward);
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        robot.omniDrive(DRIVE_POWER,Hardware.left);

        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        robot.omniDrive(DRIVE_POWER,Hardware.forward);
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        robot.omniDrive(DRIVE_POWER,Hardware.right);
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        robot.omniDrive(DRIVE_POWER,Hardware.forward);
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        robot.omniDrive(0,0);

    }




}
