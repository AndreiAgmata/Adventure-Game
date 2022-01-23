package package1;

public class VisibilityManager {
	
	UI ui;
	
	public VisibilityManager(UI userInterface) {
		
		ui = userInterface;
		
		
	}
	
	public void showTitleScreen() {
		
		//Shows Title Screen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
          
            	//Hides Game Screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		
	}
	
	public void showGameScreen() {
		
		//Hides Title Screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		//Shows Game Screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
	}
	

}
