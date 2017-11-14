package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by kevinburns on 11/3/17.
 */

@TeleOp(name="Teleop", group="Linear Opmode")
public class Teleop extends Hardware
{


    @Override
    public void runOpMode()
    {
        //Hardware robot   = new Hardware();
        init();

        setPower(0f);
        float wheelPower, turnPower;

        waitForStart();
        while(opModeIsActive())
        {
            wheelPower = gamepad1.left_stick_y;
            turnPower = -gamepad1.right_stick_x;

            if (gamepad1.right_bumper)
            {
                wheelPower = scaleInput(wheelPower) / 2;
                turnPower = scaleInput(turnPower) / 2;
            }

            else if (gamepad1.left_bumper)
            {
                wheelPower = scaleInput(wheelPower) / 4;
                turnPower = scaleInput(turnPower) / 4;
            }

            else
            {
                wheelPower = scaleInput(wheelPower);
                turnPower = scaleInput(turnPower);
            }

            // allows for tighter point turns
            if (Math.abs(turnPower) > 0.05f)
                setPower(turnPower, -turnPower);
            else
                setPower(-wheelPower);



//            //turn
//            robot.MotorFR.setPower(gamepad1.right_stick_x);
//            robot.MotorBR.setPower(gamepad1.right_stick_x);
//            robot.MotorFL.setPower(-gamepad1.right_stick_x);
//            robot.MotorBL.setPower(-gamepad1.right_stick_x);
//
//            //forward and backward
//            robot.MotorFR.setPower(gamepad1.left_stick_y);
//            robot.MotorBR.setPower(gamepad1.left_stick_y);
//            robot.MotorFL.setPower(gamepad1.left_stick_y);
//            robot.MotorBL.setPower(gamepad1.left_stick_y);
//
//            telemetry.addData("X", gamepad1.right_stick_x);
//            telemetry.addData("Y", gamepad1.left_stick_y);
//            telemetry.update();

            //waitOneFullHardwareCycle();

        }




    }
}
