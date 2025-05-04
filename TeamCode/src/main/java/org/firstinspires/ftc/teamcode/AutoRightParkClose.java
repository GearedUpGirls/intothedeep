package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "AutoRightParkClose v3",group = "Concept")
public class AutoRightParkClose extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            robot.driveForward(robot.FIELD_TILE/5,Robot.MAX_DRIVE_SPEED);
            robot.strafeRight(robot.FIELD_TILE*1.2,Robot.MAX_DRIVE_SPEED);

        }
    }
}
