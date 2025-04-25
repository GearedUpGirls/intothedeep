package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoMiddlePushParkFar v1",group = "Concept")
public class AutoMiddlePushParkFar extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(robot.FIELD_TILE/5,0.75);
            robot.strafeLeft(robot.FIELD_TILE*5,0.75);
            robot.strafeRight(robot.FIELD_TILE*5,0.75);

        }
    }
}

