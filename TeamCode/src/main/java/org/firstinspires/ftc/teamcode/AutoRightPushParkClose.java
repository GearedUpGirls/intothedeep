package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoRightPushParkClose v3",group = "Concept")
public class AutoRightPushParkClose extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(Robot.FIELD_TILE/7,Robot.MAX_DRIVE_SPEED);
            robot.strafeLeft(Robot.FIELD_TILE*3.25,Robot.MAX_DRIVE_SPEED);
            robot.strafeRight(Robot.FIELD_TILE*4.45,Robot.MAX_DRIVE_SPEED);

        }
    }
}

