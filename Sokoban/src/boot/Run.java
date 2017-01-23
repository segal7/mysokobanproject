package boot;

import commands.CLI;
import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args) throws Exception {	
		
		/*CLI cli = new CLI();
		/*cli.start();
		 */
		
		MyModel model = new MyModel();
		MyView view = new MyView();
		MyController controller = new MyController(model,view);
	}

}
