package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;



@TeleOp( name = "Teleop", group = "Linear Opmode" )
public class Teleop extends LinearOpMode {

    Hardware robot = new Hardware();
    byte power = 1;
    int direction;
    @Override
    public void runOpMode() throws InterruptedException
    {




        waitForStart();

        while( opModeIsActive() )
        {

              robot.omniDrive(gamepad1.right_stick_x ,gamepad1.left_stick_y );
//            motorFL.setPower( gamepad1.left_stick_y );
//            motorFR.setPower( gamepad1.right_stick_y );

            idle();
        }
    }
}

