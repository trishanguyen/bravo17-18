package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import static java.lang.System.currentTimeMillis;

/**
 * Created by cherma on 1/6/18.
 */

public class testArms extends Hardware
{
    DcMotor elevatorMotor;
    Servo armL, armR;
    boolean closed = true;
    boolean xReleased = true;
    public void runOpMode()
    {
        init(hardwareMap);
        waitForStart();

        long startTime = currentTimeMillis();

        Servo armR = hardwareMap.servo.get("armR");
        Servo armL = hardwareMap.servo.get("armL");

        if (gamepad1.a && xReleased)
        {
            closeGripper();
            xReleased = false;
        }
        if (!gamepad1.a)
        {
            xReleased = true;
        }

    }


    public void closeGripper()
    {
        if(closed )
        {
            armR.setPosition(.28);
            armL.setPosition(.30);
            closed = false;
        }

        else
        {
            armR.setPosition(.66);
            armL.setPosition(.12);

            closed = true;
        }

    }
}