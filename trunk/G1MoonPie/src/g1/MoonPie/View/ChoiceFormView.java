package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AddChoiceController;
import g1.MoonPie.Controller.BeginRoundController;
import g1.MoonPie.Controller.JoinEventMessageController;
import g1.MoonPie.Model.Event;
import android.app.Activity;
import android.widget.Button;

/**This class is used to run the begin rounds controller upon clicking the next button on the choice form.
 * 
 * @author Eric Cobane
 *
 */
public class ChoiceFormView {

	Activity activity;
	Event event;

	public ChoiceFormView(Event e, Activity a){

		this.event = e;
		this.activity = a;

		activity.setContentView(R.layout.choiceform);

		Button beginRoundButton = (Button) activity.findViewById(R.id.toDLFormButton);
		beginRoundButton.setOnClickListener(new AddChoiceController(event, activity));
	}
}
