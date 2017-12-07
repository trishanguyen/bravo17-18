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
    public Servo armL,armR;
    public static final int right = 1;
    public static final int left = 2;
    public static final int forward = 3;
    public static final int backward = 4;
    // Diagonal Right Forward
    public static final int dRF = 5;
    // Diagonal Right Backward
    public static final int dRB = 6;
    // Diagonal Left Forward
    public static final int dLF = 7;
    // Diagonal Left Backward
    public static final int dLB = 8;
    public static final int turnC = 9;
    public static final int turnCC = 10;
    private  byte direction;
    private double power;
    private boolean closed = true;
    private double startTime = getRuntime();

    HardwareMap   hwMap =  null;

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
            armL = hwMap.servo.get("armL");
            armR = hwMap.servo.get("armR");

            MotorFL.setDirection(DcMotor.Direction.FORWARD);
            MotorBL.setDirection(DcMotor.Direction.FORWARD);
            MotorFR.setDirection(DcMotor.Direction.REVERSE);
            MotorBR.setDirection(DcMotor.Direction.REVERSE);
            armL.setDirection(Servo.Direction.FORWARD);
            armR.setDirection(Servo.Direction.FORWARD);

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
    public void closeGripper(){
        if(closed){
            armR.setPosition(90);
            armL.setPosition(90);
            closed = false;
        }
        else {
            armR.setPosition(70);
            armL.setPosition(110);
            closed = true;
        }
    }
    public void omniDrive(double power, int direction){
         /*   MotorFL.setPower(y-x);
            MotorBL.setPower(x-y);
            MotorFR.setPower(x-y);
            MotorBR.setPower(y-x);*/
        switch (direction) {
            case right:
                MotorFL.setPower(-power);
                MotorBL.setPower(power);
                MotorFR.setPower(power);
                MotorBR.setPower(-power);
                break;
            case left:
                MotorFL.setPower(power);
                MotorBL.setPower(-power);
                MotorFR.setPower(-power);
                MotorBR.setPower(power);
                break;
            case forward:
                MotorFL.setPower(power);
                MotorBL.setPower(power);
                MotorFR.setPower(-power);
                MotorBR.setPower(-power);
                break;
            case backward:
                MotorFL.setPower(-power);
                MotorBL.setPower(-power);
                MotorFR.setPower(power);
                MotorBR.setPower(power);
                break;
            case dRF:
                MotorFL.setPower(0);
                MotorBL.setPower(power);
                MotorFR.setPower(0);
                MotorBR.setPower(-power);
                break;
            case dRB:
                MotorFL.setPower(0);
                MotorBL.setPower(-power);
                MotorFR.setPower(0);
                MotorBR.setPower(power);
                break;
            case dLF:
                MotorFL.setPower(power);
                MotorBL.setPower(0);
                MotorFR.setPower(-power);
                MotorBR.setPower(0);
                break;
            case dLB:
                MotorFL.setPower(-power);
                MotorBL.setPower(0);
                MotorFR.setPower(power);
                MotorBR.setPower(0);
                break;
            case turnC:
                MotorFL.setPower(power);
                MotorBL.setPower(power);
                MotorFR.setPower(power);
                MotorBR.setPower(power);
                break;
            case turnCC:
                MotorFL.setPower(-power);
                MotorBL.setPower(-power);
                MotorFR.setPower(-power);
                MotorBR.setPower(-power);
                break;
            default:
                MotorBL.setPower(0);
                MotorBR.setPower(0);
                MotorFL.setPower(0);
                MotorFR.setPower(0);

        }
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

