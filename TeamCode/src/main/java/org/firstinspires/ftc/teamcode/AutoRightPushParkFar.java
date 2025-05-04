package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoRightPushParkFar v3",group = "Concept")
public class AutoRightPushParkFar extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(Robot.FIELD_TILE/5,0.75);
            robot.strafeLeft(Robot.FIELD_TILE*3.25,0.75);
            robot.strafeRight(Robot.FIELD_TILE*5.55,0.75);
            robot.driveBackward(Robot.FIELD_TILE/5,0.75);

        }
    }
}

