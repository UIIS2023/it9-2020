package mvc;

import javax.swing.JFrame;

public class DrawingApp {
	
	public static void main(String[] args) {
		DrawingModel model = new DrawingModel();
		DrawingFrame frame = new DrawingFrame();
		frame.getView().setModel(model);
		DrawingController controller = new DrawingController(model, frame);
		controller.addObservers(frame);
		frame.setDrawingController(controller);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.initialize();
		frame.setVisible(true);
	}

}

	
