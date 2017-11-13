package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by kevinburns on 11/3/17.
 */

@TeleOp(name="Teleop", group="Autonomous")
public class Teleop extends LinearOpMode
{
    Hardware robot   = new Hardware();

    @Override
    public void runOpMode()
    {
        robot.init(hardwareMap);

        waitForStart();
        while(opModeIsActive())
        {
            if(gamepad1.right_stick_x != 0){//turn
                robot.MotorFR.setPower(gamepad1.right_stick_x);
                robot.MotorBR.setPower(gamepad1.right_stick_x);
                robot.MotorFL.setPower(-gamepad1.right_stick_x);
                robot.MotorBL.setPower(-gamepad1.right_stick_x);
            }

            else
            {//forward and backward
                robot.MotorFR.setPower(gamepad1.left_stick_y);
                robot.MotorBR.setPower(gamepad1.left_stick_y);
                robot.MotorFL.setPower(gamepad1.left_stick_y);
                robot.MotorBL.setPower(gamepad1.left_stick_y);
            }

            telemetry.addData("X", gamepad1.right_stick_x);
            telemetry.addData("Y", gamepad1.left_stick_y);
            telemetry.update();
        }
    }
}
