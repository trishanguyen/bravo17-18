package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.Range;

public class Hardware extends LinearOpMode
{

    final int degreeError = 2;


    public DcMotor MotorFL, MotorBL, MotorFR, MotorBR;
    public Servo arm;

    private double startTime = getRuntime();

    HardwareMap hwMap =  null;

    @Override
    public void runOpMode() throws InterruptedException
    {
    }




    /* Initialize standard Hardware interfaces */
    public void initHardware() throws InterruptedException
    {
        try
        {
            MotorFL = hwMap.dcMotor.get("flmotor");
            MotorBL = hwMap.dcMotor.get("blmotor");
            MotorFR = hwMap.dcMotor.get("frmotor");
            MotorBR = hwMap.dcMotor.get("brmotor");

            MotorFL.setDirection(DcMotor.Direction.FORWARD);
            MotorBL.setDirection(DcMotor.Direction.FORWARD);
            MotorFR.setDirection(DcMotor.Direction.REVERSE);
            MotorBR.setDirection(DcMotor.Direction.REVERSE);

            MotorFL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            MotorBL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            MotorFR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            MotorBR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }


        catch (Exception e)
        {
            telemetry.addData("[ERROR]:", "driving wheels setup");
        }
    }

    void setTime()
    {
        startTime = this.getRuntime();
    }

    double getTime()
    {
        return getRuntime() - startTime;
    }

    void setPower( float power )
    {
        MotorFL.setPower( -power );
        MotorBL.setPower( -power );
        MotorFR.setPower( -power );
        MotorBR.setPower( -power );
    }

    void setPower( float left, float right )
    {
        MotorFL.setPower( -left );
        MotorBL.setPower( -left );
        MotorFR.setPower( -right );
        MotorBR.setPower( -right );
    }

    float scaleInput(float input)
    {
        input = Range.clip(input, -1, 1);

        if (input > 0)
            return (float)Math.pow(input, 4);

        return -(float)Math.pow(input, 4);
    }


    void done()
    {
        telemetry.addData("Finished in:", getTime());
    }

    /*
    //drives to correct throw dist and returns if done
    boolean driveToDist(double dist){
        if(sonar.getUltrasonicLevel() == dist){
            setPower(0);
            return true;
        }

        if(sonar.getUltrasonicLevel() > dist){
            setPower(0.15f);
        } else if(sonar.getUltrasonicLevel() < dist){
            setPower(-0.15f);
        }
        return false;
    }
    */



}
