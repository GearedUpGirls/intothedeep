package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "ArmTest v1",group = "Concept")
public class ArmTest extends LinearOpMode {

    @Override
    public void runOpMode(){
        Robot robot = new Robot();
        waitForStart();
        if (opModeIsActive()){
            robot.init(hardwareMap);
            {
                //forward
                robot.driveForward(Robot.FIELD_TILE/6,Robot.MAX_DRIVE_SPEED);
                //strafe left
                robot.strafeLeft(Robot.FIELD_TILE*0.75,Robot.MAX_DRIVE_SPEED);
                //forward
                robot.driveForward(Robot.FIELD_TILE,Robot.MAX_DRIVE_SPEED);
                //arm up
                robot.autoArmPivot(15);
                // open claw
                robot.openClaw();
                //lower arm
                robot.autoArmPivot(15);
                //close claw
                robot.closeClaw();
                //arm up
                robot.autoArmPivot(15);
                //spin 170ish
                robot.turnRight(170,Robot.MAX_DRIVE_SPEED);
                //arm up
                robot.autoArmPivot(160);
                //slide up
                //robot.autoMoveSlide();
                //arm down
                robot.autoArmPivot(-15);
                //open grabber
                robot.openClaw();
                //arm up
                robot.autoArmPivot(15);
                //slide down
                //robot.autoMoveSlide(-);
                //bakc
                robot.driveBackward(Robot.FIELD_TILE,Robot.MAX_DRIVE_SPEED);
                //lower arm
                robot.autoArmPivot(-160);
                // spin 170ish
                robot.turnLeft(170,Robot.MAX_DRIVE_SPEED);

            }
        }
    }
}