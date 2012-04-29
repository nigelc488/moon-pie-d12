package g1.MoonPie.clientServer.client;

//import xml.Message;
import g1.MoonPie.clientServer.xml.*;

public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(MessageXML response);
}