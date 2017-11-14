//Red left
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous( name = "AutoRR" )
public class AutonomousRR extends LinearOpMode
{
    DcMotor motorFR = null, motorFL = null, motorBR = null, motorBL = null;

    double DRIVE_POWER = 1.0;
    private ElapsedTime period  = new ElapsedTime();


    @Override
    public void runOpMode()
    {


        motorFR = hardwareMap.dcMotor.get( "motorFR" );
        motorFL = hardwareMap.dcMotor.get( "motorFL" );

        motorFL.setMode( DcMotor.RunMode.RUN_WITHOUT_ENCODER );
        motorFR.setMode( DcMotor.RunMode.RUN_WITHOUT_ENCODER );

        motorFL.setDirection( DcMotor.Direction.REVERSE );

        waitForStart();


        DriveForward( DRIVE_POWER);
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        TurnLeft( DRIVE_POWER );

        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        DriveForward(DRIVE_POWER );
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        TurnRight( DRIVE_POWER );
        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        DriveForward(DRIVE_POWER );
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

        StopDriving();

    }


    //Doesn't work for some reason rn bc of the exception stuff
    public void DriveForwardTime( double power, long time ) throws InterruptedException
    {
        DriveForward( power );
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }

    }


    public void DriveForward( double power )
    {
        motorFL.setPower( power );
        motorFR.setPower( power );
    }

    public void StopDriving()
    {
        DriveForward( 0 );
    }

    public void TurnLeft( double power )
    {
        motorFL.setPower( -power );
        motorFR.setPower( power );
    }

    public void TurnLeftTime( double power, long time ) throws InterruptedException
    {
        TurnLeft( power );

        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }
    }

    public void TurnRight( double power )
    {
        TurnLeft( -power );
    }

    public void TurnRightTime( double power, long time ) throws InterruptedException
    {
        TurnRight( power );

        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e)
        {
            telemetry.addData("ERROR", e.getStackTrace()[0]);
        }
    }


}
