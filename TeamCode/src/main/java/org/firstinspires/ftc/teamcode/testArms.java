package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.System.currentTimeMillis;

/**
 * Created by cherma on 1/6/18.
 */
@TeleOp( name = "armTest", group = "Linear Opmode" )
public class testArms extends LinearOpMode
{
    DcMotor elevatorMotor;
    Servo armL, armR;
    boolean closed = true;
    boolean xReleased = true;
    public void runOpMode()
    {
        CRServo elevatorServo = hardwareMap.crservo.get("elevatorServo");
        Servo armR = hardwareMap.servo.get("armR");
        Servo armL = hardwareMap.servo.get("armL");
        waitForStart();

        long startTime = currentTimeMillis();

while (opModeIsActive()) {
    if(gamepad1.dpad_up){
        elevatorServo.setPower(1);
    } else if (gamepad1.dpad_down){
        elevatorServo.setPower(-1);
    } else {
        elevatorServo.setPower(0);
    }
    if (gamepad1.a && xReleased) {
        if(closed )
        {
            armR.setPosition(.28);
            armL.setPosition(.70);
            telemetry.addData("Robot", "Closed");
            telemetry.update();
            closed = false;
        }

        else
        {
            armR.setPosition(.56);
            armL.setPosition(.30);
            telemetry.addData("Robot", "Open");
            telemetry.update();
            closed = true;
        }
        xReleased = false;
    }
    if (!gamepad1.a) {
        xReleased = true;
    }
}
    }


    public void closeGripper()
    {
        if(closed )
        {
            armR.setPosition(.28);
            armL.setPosition(.70);
            telemetry.addData("Robot", "Closed");
            telemetry.update();
            closed = false;
        }

        else
        {
            armR.setPosition(.56);
            armL.setPosition(.30);
            telemetry.addData("Robot", "Open");
            telemetry.update();
            closed = true;
        }

    }
}