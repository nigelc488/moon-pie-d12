Process to run MoonPie:

Ensure that you have Android 4.0.3(API 15) installed and an emulator for this version of Android.

Add the respository:
https://moon-pie-d12.googlecode.com/svn/trunk/

Import the projects G1MoonPie, MoonPieServer, and MoonPieJavaTest(which is one level above trunk).
If there is a problem with MoonPieServer, check to ensure that it has ClientServer as a Project in the Java Build Path.

We never got proper integration with the server group.  Therefore you should run our mock server:

Find the IP address of your computer (cmd then ipconfig /all for Windows).
Open MoonPie then src then g1.MoonPie then clientServer then ClientLauncher.
Replace the host IP address to be your IP address (in the " " in the line: ServerAccess sa = new ServerAccess("130.215.29.32", 9371);) as the server will be located on your computer.

To launch the server:
Open MoonPieServer then src then default package then run MoonPieServerLauncher.  This should open a local server.

To launch the application:
Open MoonPie then src then g1.MoonPie then launch MoonPieActivity.
This will connect to the server and then display the welcome screen.

To login as an admin:
event id = admin
username = admin
password = key

To test joining an open event where you are the last one joining:
event id = Open

To test joining a closed event:
event id = Closed
Note: because of no server integration, instead of waiting for other participants to add edges, it jumps straight to calculating results

The event id "1234" is used for the response to creating an event.  Therefore any id other than "1234", "admin", "Open", or "Closed" cannot be logged into.

To create an open event and then force close it:
ensure that there 4 or more choices (because we don't have an actual server, need to 
artificially add choices and if you have 3 choices it will automatically be full so you can't close it).