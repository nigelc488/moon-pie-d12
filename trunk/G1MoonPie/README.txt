Process to run MoonPie:

Ensure that you have Android 4.0.3(API 15) installed and an emulator for this version of Android.

Add the respository:
https://moon-pie-d12.googlecode.com/svn/trunk/

Import the projects G1MoonPie and MoonPieServer (if you do not have ClientServer import that too).
If there is a problem with MoonPieServer, check to ensure that it has ClientServer as a Project in the Java Build Path.


Find the IP address of your computer (cmd then ipconfig /all for Windows).
Open MoonPie then src then g1.MoonPie then clientServer then ClientLauncher.
Replace the host IP address to be your IP address (in the " " in the line: ServerAccess sa = new ServerAccess("130.215.29.32", 9371);) as the server will be located on your computer.

Open MoonPieServer then src then default package then launch MoonPieServerLauncher.  This should open a local server.

Open MoonPie then src then g1.MoonPie then launch MoonPieActivity.
This will connect to the server and then display the welcome screen.
Press "Create New Event" and it will launch the Create New Event Form.