package g1.MoonPie.clientServer.client;

import g1.MoonPie.clientServer.xml.*;

/**
 * This interface is unmodified from Professor Heineman's code.
 * @author ncochran, heineman
 *
 */
public interface IMessageHandler {
	
  /** Process the protocol response*/
  void process(MessageXML response);
}