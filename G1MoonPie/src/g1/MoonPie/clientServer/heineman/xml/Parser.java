package g1.MoonPie.clientServer.heineman.xml;

import java.io.*;

public class Parser {

	/** Common id across request/responses. */
	public final static String id = "id";
	
	/** Attributes in responses. */
	public final static String success = "success";
	public final static String reason = "reason";

	/** Connect initial request. */
	public final static String connectRequest = "connectRequest";
	public final static String connectResponse = "connectResponse";

	/** Return extracted request. */
	public static MessageXML extractRequest(BufferedReader in) {
		return extractMessage(in, "</request>");
	}

	/** Return extracted response. */
	public static MessageXML extractResponse(BufferedReader in) {
		return extractMessage(in, "</response>");
	}

	/** 
	 * Extract the XML message and construct validated Message object based on
	 * the terminator string (either "</request>" or "</response>"). Returns 
	 * null if communication is interrupted in any way.
	 */
	static MessageXML extractMessage(BufferedReader in, String terminator) {
		try {
			String line = in.readLine();
			if (line == null) { return null; }
			StringBuilder buf = new StringBuilder(line);
			while (!buf.substring(buf.length()-terminator.length(), buf.length()).equals(terminator)) {
				line = in.readLine();
				if (line == null) { return null; }
				buf.append(line);
			}

			return new MessageXML (buf.toString());
		} catch (IOException ioe) {
			return null;
		}
	}

}

