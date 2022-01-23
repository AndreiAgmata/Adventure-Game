package package1;



import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import package2.weapon_knife;
import package2.weapon_pistol;

public class Story {
	
	game game;
	UI ui;
	VisibilityManager vm;
	player player = new player();
	String text;
        String day;
	int i;
        String person=("");
        int counter=0;
        Random random;
        int dayNumber;
        String event="";
        int dayCounter=1;
	
	
	public Story(game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
        
	
	Timer timer = new Timer(0, new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			char character[] = text.toCharArray();
			int arrayNumber = character.length;
			
			String addedCharacter = "";
			String blank = "";
			
			addedCharacter = blank + character[i];
			ui.mainTextArea.append(addedCharacter);
			
			i++;
			
			if (i == arrayNumber) {
				i=0;
				timer.stop();
			}
		}
		
	});
	
	public void prepareText() {
		ui.mainTextArea.setText("");
		timer.start();
	}
	
	
	

	public void defaultPlayer() {
           
               random = new Random();
               dayNumber= random.nextInt(5)+1;
               
                 switch (dayNumber){
                   case 1 : day = "Monday";
                            dayCounter += 1; break;
                   case 2 : day = "Tuesday";
                            dayCounter += 1; break;
                   case 3 : day = "Wednesday"; 
                            dayCounter += 1;break;
                   case 4 : day = "Thursday"; break; 
                   case 5 : day = "Friday"; break;
                   
                 }
                
               ui.dayLabelName.setText(day);
               
             
               
                
                
		
		player.currentWeapon = new weapon_knife();
               
			
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
                        case "intro1" : intro(); person="smart";  break;
                        case "intro2" : intro(); person="brauns";  break;
                        case "teacher" : teacher(); break;
                        case "washroomCase" : washroomCase(); break;
                        case "stay" : stayedInClass(); break;
                        case "chance1" : chance1(); break;
                        case "firstDeath" : firstDeath(); break;
                        case "wentWashroom" : wentWashroom(); break;
                        case "nearestRoom" : nearestRoom(); break;
                        case "keepKnocking" : keepKnocking(); break;
                        case "mainMenu" : vm.showTitleScreen();break;
                        case "outsideAfterLockdown" : outsideAfterLockdown(); break;
                        case "outsideBeforeLockdown" : outsideBeforeLockdown(); break;
                        case "runHome" : runHome(); break;
                        case "outside" : if (counter == 1){
                                         outsideAfterLockdown();  
                                         counter=0; break;
                                         }
                                         else if (counter == 2){
                                         outsideBeforeLockdown();
                                         counter = 0; break;  
                                         }
                        case "inCar" : inCar(); break;
                        case "inCarContinue" : inCarContinue(); break;
                        case "driveOut" : highway(); break;
                        case "goToStore" : switch (dayCounter){
                                           case 1 : storeTraffic(); break;
                                           case 2 : storeNoTraffic(); break;
                                            } break;
                        case "food" : food(); break;
                        case "choseWeapons" : choseWeapons(); break;                        
                        
                        
			
			
			
		}
		
	}
	
	public void start() {
		text = ("Choose your character:\n"
                        + "Daniel, male, smart but has a small build.\n"
                        + "Sharron, female, athletic but has low grades\n"
                        + "Mike, male, has a big build but doesn't go to his classes\n"
                        + "Jaymie, female, nerdy and get picked on because\nshe's short");
		prepareText();
		
		
		ui.choice1.setText("Daniel");
		ui.choice2.setText("Sharon");
		ui.choice3.setText("Mike");
		ui.choice4.setText("Jaymie");
		
		game.nextPosition1 = "intro1";
		game.nextPosition2 = "intro2";
		game.nextPosition3 = "intro2";
		game.nextPosition4 = "intro1";
	
	}
        
        public void intro(){
                
           switch (day){
                    case "Monday" : event= (" stayed in class and wait for her."); break;
                    case "Tuesday" : event= (" stayed in class and wait for her."); break;
                    case "Wednesday" : event= (" stayed in class and wait for her."); break;
                    case "Thursday" : event= ("went to the caf to get food because she'll prolly be late again."); break;
                    case "Friday" : event= ("went to the caf to get food because she'll prolly be late again."); break;
                }
                
                text = ("You are a Grade 11 student experiencing a normal day at school.You noticed the past few weeks that your first period teacher is usually late because of traffic on Thursdays and Fridays. Its a "+ day + " today so you " + event);
                prepareText();
                
		ui.choice1.setText("Continue");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "teacher";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
        }
        
        public void teacher(){
                text = ("Ms. Caulifiene arrives. She immediately tells the class to settle down and get to work, staying true to her strict philosophies. She arrives late as always because from Monday to Wednesday there is a lot of traffic. She comes with extra pencils because of the high demand for them in the class just before the stores got busy. "); //text for monday to wednesday
                prepareText();
                
                ui.choice1.setText("Continue");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "washroomCase";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
        }
        
        public void washroomCase(){
                text = ("You suddenly had the urge to use the washroom. Go to the washroom now or wait till the class ends?");
                prepareText();
                
                ui.choice1.setText("Now");
		ui.choice2.setText("Wait till the class ends");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "wentWashroom";
		game.nextPosition2 = "stay";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
        }
        
        public void stayedInClass(){
                text = ("Lockdown! Lockdown! Lock Down!\n"
                        + "This is not a drill!\n"
                        + "You are locked inside the class you have no way out the class because all doors and windows are closed."
                        + "You looked at your phone and an unknown virus has taken over your city.");
                prepareText();
                
                ui.choice1.setText("Continue");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "chance1";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
        }
        
        public  void chance1(){
                text = ("Ms. Caulifiene looks at her phone....."
                        + "                                      \n"
                        + "Ms. Caulifiene : Oh my!! I have to go your'e all on your own!!!"
                        + "                                      \n"
                        + "You see her leave the door open.");
                prepareText();
                
                ui.choice1.setText("Stay");
		ui.choice2.setText("Get out of the school");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "firstDeath";
		game.nextPosition2 = "outsideAfterLockdown";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
                        
        }
        
        public void firstDeath(){
                text = ("You have been in the classroom for an hour now....."
                        + "                                             \n"
                        + "                                             \n"
                        + "You hear shouting noises in the hallway when a zombie entered your room.....\n"
                        + "                                             \n"
                        + "                                             \n"
                        + "                              G  A  M  E    O  V  E  R");
                prepareText();
                
                ui.choice1.setText("Try Again");
		ui.choice2.setText("Main Menu");
		ui.choice3.setText("Exit");
		ui.choice4.setText("");
		
		game.nextPosition1 = "washroomCase";
		game.nextPosition2 = "mainMenu";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
        }
        
        public void wentWashroom(){
                text = ("Lockdown! Lockdown! Lock Down!\n"
                        + "This is not a drill!\n"
                        + "You are locked inside the class you have no way out the class because all doors and windows are closed."
                        + "You looked at your phone and an unknown virus has taken over your city.");
                prepareText();
                
                ui.choice1.setText("Run to the nearest room");
		ui.choice2.setText("Try to get out of the school");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "nearestRoom";
		game.nextPosition2 = "outsideBeforeLockdown";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
    
        }
        
        public void nearestRoom(){
                text = ("You're knocking on the nearest room but he teacher won't risk opening the door for you.");
                prepareText();
                
                ui.choice1.setText("Look for another room");
		ui.choice2.setText("Go outside");
		ui.choice3.setText("Keep knocking");
		ui.choice4.setText("");
		
		game.nextPosition1 = "";
		game.nextPosition2 = "outsideAfterLockdown";
		game.nextPosition3 = "keepKnocking";
		game.nextPosition4 = "";            
        }
        
        public void lookForAnotherRoom(){
                text = ("You are knocking on every door you pass by but no teacher opens a door for you.\n"
                        + "             \n"
                        + "You are running in the hallway when your chool custodian jumps at you and bites your neck\n"
                        + "\n"
                        + "                              G  A  M  E    O  V  E  R");
                prepareText();
                
                ui.choice1.setText("Try Again");
		ui.choice2.setText("Main Menu");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "nearestRoom";
		game.nextPosition2 = "mainMenu";
		game.nextPosition3 = "";
		game.nextPosition4 = "";                  
        }
        
        public void keepKnocking(){
                text = ("The teacher refuses to open the door. As you turn to find another room, Mr. Donstratine comes up to you filled with blood all over his mouth. You are frozen in fear, you scream for you life as he eats away at your neck. You are dead."
                        + "                                             \n"
                        + "                              G  A  M  E    O  V  E  R");
                prepareText();
                
                ui.choice1.setText("Try Again");
		ui.choice2.setText("Main Menu");
		ui.choice3.setText("Exit");
		ui.choice4.setText("");
		
		game.nextPosition1 = "nearestRoom";
		game.nextPosition2 = "mainMenu";
		game.nextPosition3 = "";
		game.nextPosition4 = "";            
        }
        
        public void outsideAfterLockdown(){
                text = ("Your'e outside the school now. You see Ms. Caulifiene openeing her car.\n"
                        + "                                                                  \n"
                        + "Suddenly...                         \n"
                        + "A zombie pops out and bites her as soon as she opened her car.");
                prepareText();
                counter =+ 1;
                
                ui.choice1.setText("Get in the car");
		ui.choice2.setText("Run home");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "inCar";
		game.nextPosition2 = "runHome";
		game.nextPosition3 = "";
		game.nextPosition4 = "";             
        }
        
        public void outsideBeforeLockdown(){
                text = ("You are now outside the school. You check for people but there is no one around. You see Mr. Donstratine being eaten alive by an unknown person. You hear screaming in the school, glass shattering, and shots being fired near by. Mr. Donstratine's car is open, with the key in the ignition. Do you take the car, or go back?");
                prepareText();
                counter=+2;
                
                ui.choice1.setText("Try to steal a car");
		ui.choice2.setText("Run home");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "inCar";
		game.nextPosition2 = "runHome";
		game.nextPosition3 = "";
		game.nextPosition4 = "";  
        }
        
        public void runHome(){
                text = ("Your'e almost there.....              \n"
                        + "                                       \n"
                        + "Suddenly...     \n"
                        + "       \n"
                        + "A horde  of zombies appear infront of you. You try to run back but you see another horde coming from behind\n"
                        + "       \n"
                        + "                              G  A  M  E    O  V  E  R");
                prepareText();
                
                ui.choice1.setText("Try Again");
		ui.choice2.setText("Main Menu");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "outside";
		game.nextPosition2 = "mainMenu";
		game.nextPosition3 = "";
		game.nextPosition4 = "";  
        }
        
        public void inCar(){
                text = ("You are now pulling out of your school driveway. You check the car, you find nothing valuable for your survival. You know that if it's Monday to Wednesday, there's no traffic and the stores are clear. Thursday to Friday, there's a lot of traffic and the stores are full. You want little to no interaction with other poeple for your chances of survival to increase. Your main goal is to get to your parents house on the other side of the city with supplies to save them.");
                prepareText();
                
                ui.choice1.setText("Continue");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "inCarContinue";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";  
        }
        
        public void inCarContinue(){
                text = ("Do you want to go to the store, or head to the Highway?");
                prepareText();
                
                ui.choice1.setText("Go to Store");
		ui.choice2.setText("Head to the highway");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "goToStore";
		game.nextPosition2 = "driveOut";
		game.nextPosition3 = "";
		game.nextPosition4 = "";    
        }
        
        public void storeTraffic(){
                text = ("You get near the store but there is a lot of traffic and chaos has broken out.You realize its a " + day + " today and the streets are busy on this day. You get out of your car and you get knocked down\n"
                        + "                            \n"
                        + "                              G  A  M  E    O  V  E  R");
                prepareText();
                
                ui.choice1.setText("Try Again");
		ui.choice2.setText("Main Menu");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "inCar";
		game.nextPosition2 = "mainMenu";
		game.nextPosition3 = "";
		game.nextPosition4 = "";  
    
    }       
        
        public void storeNoTraffic(){
                text = ("You find a nearby Walmart. You grab canned foods, water bottles. But you also want weapons. Do you want to take the food and water, or the weapons?");
                prepareText();
                
                ui.choice1.setText("Food and Water");
		ui.choice2.setText("Weapons");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "food";
		game.nextPosition2 = "choseWeapons";
		game.nextPosition3 = "";
		game.nextPosition4 = "";          
        }
        public void food(){
                text = ("You head on the road. You have food and water, but no weapons to defend yourself. You feel very hungry and thirsty since you haven't eaten since the morning of the attack. You refresh yourself. As you drive for hours on end, you see a woman passed out in her car on the Highway. Her baby is crying very loud, attracting nearby zombies. Do you keep driving, or help her?");
                prepareText();
                //player sees a woman passed out with her baby. Baby is attracting zombies. Playwe will decide whether to keep driving or help them. If player helps, will get betrayed. Risky move or safe move, risky will get the car back, safe move will leave him without car and he dies. If he keeps driving he wins the game.
                
                ui.choice1.setText("Help her");
		ui.choice2.setText("Drive away");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "helpHer";
		game.nextPosition2 = "driveAway";
		game.nextPosition3 = "";
		game.nextPosition4 = "";          
        }
        
        public void choseWeapons(){
                text = ("You took the weapons and left the store. You drive hours on end. You haven't eaten since the morning of the attack. You look for food and water but you realize you never took any, but instead took the weapons. Greed has forsaken you.\n"
                        + "                              G  A  M  E    O  V  E  R");
                prepareText();
                
            
                
                ui.choice1.setText("Try Again");
		ui.choice2.setText("Main Menu");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "inCarContinue";
		game.nextPosition2 = "mainMenu";
		game.nextPosition3 = "";
		game.nextPosition4 = "";              
        }
        
        public void highway(){
                text = ("You got out of the city. You are now driving on a clear highway.\n"
                        + "\n"
                        + "You see an on-the-go store. ");
                prepareText();
                
                ui.choice1.setText("Get food");
		ui.choice2.setText("Check the news for safe places");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";  
        }
}

