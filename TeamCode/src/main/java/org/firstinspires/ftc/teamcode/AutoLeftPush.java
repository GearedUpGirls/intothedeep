package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoLeftPush v2",group = "Concept")
public class AutoLeftPush extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(Robot.FIELD_TILE/5,0.75);
            robot.strafeLeft(Robot.FIELD_TILE*0.75,0.75);

        }
    }
}

