package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Trisha on 10/19/2017.
 */

public class AutonomousMain extends LinearOpMode
{

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
//
        double power = 1;
//        float drive = 0.5f;
//        float turn = 0.5f;


        // checks to make sure the power values are between -1 and 1
//        power    = Range.clip(drive + turn, -1.0, 1.0) ;
//
//        leftDrive.setPower(power);
//        rightDrive.setPower(power);

        // run until the end of the match (driver presses STOP)

        // testing code:
        Autonomous.drive(power, 2000);
        Autonomous.turnLeft(power, 500);

        Autonomous.drive(power, 2000);
        Autonomous.turnRight(power, 500);
        Autonomous.drive(-power, 2000);
        Autonomous.stopDriving();

        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("Motors", "left (%.2f), right (%.2f)", 1);
        telemetry.update();
    }
}
