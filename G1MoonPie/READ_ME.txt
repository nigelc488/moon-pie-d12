Process to run MoonPie:

Ensure that you have Android 4.0.3(API 15) installed and an emulator for this version of Android.

For the most up to date version:
	Add the respository:
	https://moon-pie-d12.googlecode.com/svn/trunk/

	Import the projects G1MoonPie, MoonPieServer, and MoonPieJavaTest(which is one level above trunk).
	If there is a problem with MoonPieServer, check to ensure that it has ClientServer as a Project in the Java Build Path.

We never got proper integration with the server group.  Therefore you should run our mock server:

Find the IP address of your computer
Open MoonPie then src then g1.MoonPie then clientServer then ClientLauncher.
Replace the host IP address to be your IP address 
(in the " " in the line: ServerAccess sa = new ServerAccess("130.215.29.32", 9371);) as the server will be located on your computer.

To launch the server:
Open MoonPieServer then src then default package then run MoonPieServerLauncher as a Java App. 
Confirm the local server launched by viewing "Server waiting client connections."

To launch the application:
Open MoonPie then src then g1.MoonPie then launch MoonPieActivity as an Android App. 
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

Note: The event id "1234" is used for the response to creating an event.  
Therefore any id other than "1234", "admin", "Open", or "Closed" cannot be logged into.

To create an open event and and be able to force close it:
Ensure that there 4 or more choices 
(Because we don't have an actual server, need to artificially add 3 choices 
so if you have select 3 choices in the from it will automatically be full so you can't close it).

To view testing code coverage:
Run the MoonPieJavaTest project as Coverage as ... JUnit test
(This tests server communication functionaity and entity functionality)

To simulate code coverage for android controllers:
System print outs to Android's LogCat were placed in each block of code in our controllers
As the event is run, you see each of these print outs confirming that all of our code is covered
Please view videos of us manually running our test cases and showing the "coverage" as displayed by the print outs
