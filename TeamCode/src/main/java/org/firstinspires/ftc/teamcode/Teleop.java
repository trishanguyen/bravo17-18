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
    int direction = 0;
    @Override
    public void runOpMode() throws InterruptedException
    {




        waitForStart();

        while( opModeIsActive() )
        {
            if(gamepad1.right_stick_x > 0 && gamepad1.right_stick_y > 0){
                direction = Hardware.dRF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.right_stick_y > 0){
                direction = Hardware.dLF;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.right_stick_y < 0) {
                direction = Hardware.dLB;
            } else if (gamepad1.right_stick_x < 0 && gamepad1.right_stick_y > 0){
                direction = Hardware.dRB;
            } else if (gamepad1.right_stick_x > 0) {
                direction = Hardware.right;
            } else if (gamepad1.right_stick_x < 0) {
                direction = Hardware.left;
            } else if (gamepad1.right_stick_y > 0) {
                direction = Hardware.forward;
            } else if (gamepad1.right_stick_y < 0){
                direction = Hardware.backward;
            } else {
                direction = 0;
            }
            robot.omniDrive(power,direction );

//            motorFL.setPower( gamepad1.left_stick_y );
//            motorFR.setPower( gamepad1.right_stick_y );

            idle();
        }
    }
}

