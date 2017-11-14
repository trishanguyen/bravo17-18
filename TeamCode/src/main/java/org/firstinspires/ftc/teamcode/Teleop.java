package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;



@TeleOp( name = "Teleop", group = "Linear Opmode" )
public class Teleop extends LinearOpMode
{

    private DcMotor motorFR, motorFL, motorBR, motorBL;


    @Override
    public void runOpMode() throws InterruptedException
    {

        motorFR = hardwareMap.dcMotor.get( "motorFR" );
        motorFL = hardwareMap.dcMotor.get( "motorFL" );

        motorFL.setDirection( DcMotor.Direction.REVERSE );


        waitForStart();

        while( opModeIsActive() )
        {

            motorFL.setPower( gamepad1.left_stick_y );
            motorFR.setPower( gamepad1.right_stick_y );

            idle();
        }



    }
}
