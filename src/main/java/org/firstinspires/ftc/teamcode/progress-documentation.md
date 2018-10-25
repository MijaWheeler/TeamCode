### FTC Rover Ruckus 2018 Progress Documentation
##

# Test op modes
    - Op modes with the `@Disabled` decorator under the `@OpMode()` initialization decorator are disabled,
     remove the disabled decorator to enable them.
    - Our current TestOpMode is coppied from LinearOpMode example class in
     `FtcRobotController.org.firstinspires.ftc.robotcontroller.external.samples.*`
    - Enabled Team related Op modes are located in `TeamCode.org.firstinspires.ftc.teamcode`.
    - ...
## Configuring for REV electronics..
#Documentation can be found (here)[http://www.revrobotics.com/content/docs/REV-31-1153-GS.pdf]

# What we have done:

9/20
  - Connected the driver station phone to the rev "Expantion Hub".
  - Created a new robot configuration and scanned for devices.
    - Problem: nothing is found by the controller app.
    - Potential solutions: Battery not charged.

9/21
  -eletrical gave me a list of tthe motor ports and thier corresponding attachments
  -we were not able to configure the robot and the controller because both of the phones were not
    charged
  -i watched the intro videos in order to set up the basic drive

9/26
 -found out the phones I was using were old; switched over to new ones
 -began setting up the phones; downloaded the driver station and robot contol app
 -as the apps downloaded, i started fixing the forward drive b/c originally the software showed me
    a bunch of errors; one of my hypothesis' is that the robot controller and driver station
    hasn't been configure, i have little doubt that this is the soulotion b/c the configuation is
    not done via computer

9/27
    -i found that many of my problems originate from the fact that the gradle sync has failed;
    -i need to do more research on how to do fix the sync on Android studio, otherwise I need to check
        my files and make sure i downloaded everything that is needed

9/28
    -i finnaly configured the robot controler; i need to configure the drive station phone. I assigned all the
        motor ports to the drive motors
    - i need to fix the build configuration; if time allows, ill spend some free time to figure out how
        to get the thing to work

10/1
    -the gradle finnaly synced after downloading an update for android studios
    -this fixed most of the errors found in program, however there are still multiple variable that are unresolved
        and typos


10/3
    -with the help of a past ftc programmed, we resolved all the missing symbols; turns out many of the lines were
        mislabled
    -forward drive (teleOp) now works [theoretically]; phones needed to be charged so we couldn't test
    -driver station phone needs to be configured
    -started working on the program for the verticle slide (teleOp)
    -need to test forward drive; figure out how the controller connects to the driver station
    

-Fall break schedule [TBD]
    -Mon, Fri : 2:30-4:30 Reid will chap mon, do we do fri
    -Tues, Thurs: 3:30-5:30 Mr. Reid will chap both days
    -Sat: do we do?

10/8
    -Verticle Slide Tele-Op is programmed; needs to be tested
    -Intake Tele-Op is programmed; needs to be tested
    -Outake Tele_Op is programmed; needs to be tested
    -Robot Controller still needs to be configured
    -Need to figure out how to upload code after phone configuration

10/9
    -Figured out that the Driver Station and Robot Controller Phones need to be paierd in order to function
    properly
        -Began researching and troubleshooting ways to pair the phones
    - I want to have the phones paired by next work day

10/12
    -Driver Station and Robot Controller Phones are paired; need to test with eletrical board to ensure
    they are synced properly
    -Began researching how to write a basic Linear OpMode Auto
    -Wrote down the basic order and requirements for the Auto according to the Team's prefrenced order
     (previosly discussed at the begining of the season):

        AUTO ORDER
        1)Land
            ~Down... vertSlide[DcMotor]
            ~Detatch by pulling pin... hook[Servo]
        2)Claim/Mark
            ~Drive to Depo... leftDrive && rightDrive [DcMotor(s)]
            ~Place marker Down... mark[Servo]
        3)Sample (Possibility...Put on the bottom of priotery list)
        {Move Gold Marker ONLY}
            ~COlor Sensor
        4)Park
            ~Drive

     Mech
     -removed rear support bar back to fit the vertSlide to fit better
     -Grinded out a notch to remove execess interference
     -Made the vertSlide longer

10/15
   -Paired the phones
   -Figured how to set up the driving configurationn
   -Troubleshot code after experiencing alot of coding errors; turns out all I had to do was
   refresh
   -Need to figure out how to download code and test

   _______________________________________________________________________________________________

   ********* HOW TO SET UP RC AND DS FOR DRIVE  *********
   1) Disconnect everything
   2) Close all apps [Including the FTC app on the RC and DS]
   3) Plug in MiniUSB cord via HUB side
   4) Plug in the battery to the HUB
   5) Plug the RC phone into the HUB
   6) Start the DS & RC app
   *******************************************************

   ***********PORT CONFIGURATION**************************

 Expansion Hub 1 [DC Motor]
  Motor Port
   0) Left Drive {left}
   1) Right Drive
   2) Intake
   3)

 Expansion Hub 2 [
  Motor Port
   0) Climb (Phase 1 Arm)
   1) Arm (Phase 2)
   2)
   3)

   Servo Port
    0) Hook
    1) Marker
    2)
    3)
    4)
    5)

   *******************************************************

   10/17
   -Went over the final port configurations for both expansion hubs. It took longer then expected
   becuause there was miscommunication on the fact that are was two types of ports [Motor & Servos].
   -Need to do:
    -Configure Expansion HUB 1 & 2 on DS phone using bot HUBS
    -Download Tele-Op code from computer to phone. [Don't know which one, probally Driver Station]
    -Make a "Trouble Shoot Cheat Sheet" for Programming Backup
    -My code is not compiling because the phones are not in developer mode and I don't know how to
    do that
    -Android Studio is missing a few files I think because the comiler is telling me that the SDK and
    Android ADK isn't uploded

    10/22
    -I fixed the SDK and ADK problem by downloading the recuired parts