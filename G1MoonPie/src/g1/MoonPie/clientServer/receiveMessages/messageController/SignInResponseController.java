package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import g1.MoonPie.DecisionLinesFormActivity;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;
import g1.MoonPie.View.ChoiceFormView;
import g1.MoonPie.View.CloseEventView;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

/**
 * this class is used to process signInResponse xml messages and call the
 * necessary controller.
 * 
 * @author ncochran
 * 
 */
public class SignInResponseController {
	Event event;
	Activity activity;

	boolean isOpen;

	/**
	 * This constructor requires an event and activity so they can be passed to
	 * the next controller.
	 * 
	 * @param event
	 *            Event The event used to access model objects
	 * @param activity
	 *            Activity the activity used to access GUI objects
	 */
	public SignInResponseController(Event event, Activity activity) {
		this.event = event;
		this.activity = activity;
	}

	/**
	 * This method is used to do the actual processing of the message and
	 * calling of the controller.
	 * 
	 * @param response
	 *            MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response) {
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();

		String id = EncodeXML.decodeString(map.getNamedItem("id")
				.getNodeValue());
		String type = EncodeXML.decodeString(map.getNamedItem("type")
				.getNodeValue());
		String question = EncodeXML.decodeString(map.getNamedItem("question")
				.getNodeValue());
		int numChoices = Integer.parseInt(map.getNamedItem("numChoices")
				.getNodeValue());
		int numRounds = Integer.parseInt(map.getNamedItem("numRounds")
				.getNodeValue());
		int position = Integer.parseInt(map.getNamedItem("position")
				.getNodeValue());

		System.out.println("SignIn with id=" + id + " type=" + type
				+ " question=" + question + " numChoices=" + numChoices
				+ " numRounds=" + numRounds + " position=" + position);

		// mock server returns not if not a valid (so already existing) id
		if (!id.equals("no")) {

			// convert from string to boolean
			if (type.equals("open")) {
				isOpen = true;
			} else
				isOpen = false;

			// Update the Event

			event = Event.getInstance();
			Event.getInstance().setID(id);
			Event.getInstance().setOpen(isOpen);
			Event.getInstance().setQuestion(question);
			Event.getInstance().setNumChoices(numChoices);
			Event.getInstance().setNumRounds(numRounds);
			Event.getInstance().getUser().setPostion(position);

			NodeList list = child.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				NamedNodeMap map2 = node.getAttributes();

				String choice = map2.getNamedItem("value").getNodeValue();
				choice = EncodeXML.decodeString(choice);
				int index = Integer.parseInt(map2.getNamedItem("index")
						.getNodeValue());
				Event.getInstance().getLines()[index].setChoice(choice);

			}
			
			Line[] currentLines;
			currentLines = event.getLines();
			
			int lineCount = 0;
		
			//check to see how many choices
			for(int i=0; i<currentLines.length; i++){
				if(!currentLines[i].getChoice().equals("")){
					lineCount++;
				}
			}

			// launch choice form if open event and you aren't the moderator
			if (event.isOpen() && !(Event.getInstance().getUser().getPostion() == 0)) {

				ChoiceFormView view = new ChoiceFormView(event, activity);
				view.setChoicesVisibility();
			}
			//if open event without all choices added
			 else if (lineCount < Event.getInstance().getNumChoices()){
				 
					//this is to fake closing an open event
				 //TODO
					SendMessageController.addChoiceRequest(id, 1, "two");
					SendMessageController.addChoiceRequest(id,2, "three");

				 new CloseEventView(Event.getInstance(), ProcessThreadMessages.getActivity());
			 }

			// launch add edge form
			// if closed event then launch view
			// if open event and all choices are there
			else {

				Intent intent = new Intent(ProcessThreadMessages.getActivity(),
						DecisionLinesFormActivity.class);
				ProcessThreadMessages.getActivity().startActivity(intent);

			}
		} else
			Toast.makeText(ProcessThreadMessages.getActivity(),
					"Not a Valid ID", Toast.LENGTH_LONG).show();

	}

}
