package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;



import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

import static java.lang.Math.abs;


@TeleOp( name = "Teleop", group = "Linear Opmode" )
public class Teleop extends LinearOpMode {

    Hardware robot = new Hardware();

    double power = 1;
    int direction = 0;

    boolean xReleased = true;
    @Override
    public void runOpMode() throws InterruptedException
    {



    robot.init(hardwareMap);
        waitForStart();

        while( opModeIsActive() )
        {
            if(gamepad1.right_stick_x > 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dRF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dLF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y < 0) {
                direction = Hardware.dLB;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.left_stick_y > 0){
                direction = Hardware.dRB;
            } else if (gamepad1.right_stick_x > 0) {
                direction = Hardware.right;
            } else if (gamepad1.right_stick_x < 0) {
                direction = Hardware.left;
            } else if (gamepad1.left_stick_y > 0) {
                direction = Hardware.forward;
            } else if (gamepad1.left_stick_y < 0){
                direction = Hardware.backward;
            } else if (gamepad1.dpad_left){
                direction = Hardware.turnCC;
            } else if (gamepad1.dpad_right){
                direction = Hardware.turnC;
            } else {
                direction = 0;
            }
            if (gamepad1.a){
                power = 1;
            }  else if (gamepad1.b){
                power = .5;
            }
            if (gamepad1.x && xReleased){
                robot.closeGripper();
                xReleased = false;
            }
            if (!gamepad1.x){
                xReleased = true;
            }

            //robot.elevator(gamepad2.right_stick_y);
            if (abs(gamepad1.left_stick_y) > 0 && abs(gamepad1.right_stick_x) > 0){
                power = (gamepad1.left_stick_y + gamepad1.right_stick_x)/2;
            }else if (abs(gamepad1.left_stick_y) > 1){
                power = gamepad1.left_stick_y;
            } else if (abs(gamepad1.right_stick_x) > 1){
                power = gamepad1.right_stick_x;
            }
            robot.omniDrive(power,direction);

//            motorFL.setPower( gamepad1.left_stick_y );
//            motorFR.setPower( gamepad1.right_stick_y );

            idle();
        }
    }
}

