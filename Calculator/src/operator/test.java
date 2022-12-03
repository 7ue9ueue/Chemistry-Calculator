//package GUI;
//
//import java.io.IOException;
//import java.util.*;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.*;  
//
//public class Main extends Application{  
//  
//	public static String Equations;
//	GridPane root = new GridPane();  
//	ArrayList<Label> labels = new ArrayList<Label>();
//	ArrayList<TextField> entrys = new ArrayList<TextField>();
//	Label title = new Label("Chemistry Balance Equation Solver");
//	Button reset = new Button("reset");
//	Button solve = new Button("solve");
//	Button add = new Button("Add");
//	Button equal = new Button("=");
//	int equalPosition = -1;
//	HBox box = new HBox(); 
//	
//	public void printScreen (Stage primaryStage) 
//	{
//		root = new GridPane();
//		VBox = 
//		int ID = 0;
//		int n = labels.size();
//		root.addRow(ID++,title);
//		for (int i=0;i<n;i++) 
//		{
//			Label l = labels.get(i);
//			TextField t = entrys.get(i);
//			if (i==0) 
//			{
//				box = new HBox(); 
//				box.getChildren().addAll(l,t,add);
//				root.addRow(ID++,box);
//			}
//			else 
//			{
//				box = new HBox(); 
//				box.getChildren().addAll(l,t);
//				root.addRow(ID++,box); 
//			}
//			if (equalPosition-1==i) 
//			{
//				box = new HBox(); 
//				box.getChildren().addAll(new Label("="));
//				root.addRow(ID++,box);
//			}
//		}
//		box = new HBox(); 
//		box.getChildren().addAll(reset,solve,equal);
//	    root.addRow(ID++,box);
//	    
//	    Scene scene = new Scene(root,600,400); 
//	    primaryStage.setScene(scene);  
//	    primaryStage.setTitle("Chemsitry Calculator");  
//	    primaryStage.show();  
//	}
//	
//	public void initial ()
//	{
//		labels.clear();
//		entrys.clear();
//		labels.add(new Label());
//		entrys.add(new TextField("Enter Chemical Here"));
//		equalPosition = -1;
//	}
//    public void start (Stage stage) throws Exception 
//    {  
//    	initial();
//    	printScreen(stage);
//    	reset.setOnAction(new EventHandler<ActionEvent>() {  
//    		@Override  
//          	public void handle(ActionEvent arg) {  
//    			initial();
//    			root = new GridPane();
//    			printScreen(stage);
//    		}  
//    	});  
//    	solve.setOnAction (new EventHandler<ActionEvent>() {  
//    		@Override  
//          	public void handle(ActionEvent arg) {  
//    			ArrayList<String> names = new ArrayList<String>();
//    			int n = entrys.size();
//    			for (int i=0;i<entrys.size();i++) 
//    			{
//    				names.add(entrys.get(i).getText());
//    			}
//    			try 
//    			{
//					ArrayList<Integer> answer = operator.Main.solve(n,names);
//					if (answer==null)
//					{
//						
//					}
//				} 
//    			catch (IOException e) 
//    			{
//					e.printStackTrace();
//				}
//    			printScreen(stage);
//    		}  
//    	}); 
//    	equal.setOnAction (new EventHandler<ActionEvent>() {  
//    		@Override  
//          	public void handle(ActionEvent arg) {  
//    			if (equalPosition==-1&&labels.size()>0)
//    			{
//    				equalPosition = labels.size();
//    			}
//    			printScreen(stage);
//    		}  
//    	}); 
//    	add.setOnAction(new EventHandler<ActionEvent>() {  
//    		@Override  
//          	public void handle(ActionEvent arg) {  
//    			labels.add(new Label());
//    			entrys.add(new TextField("Enter Chemical Here"));
//    			printScreen(stage);
//    		}  
//    	}); 
//    	
////    	    Label test = new Label("Test");  
////    	    TextField text = new TextField();  
////    	    
////    	    Label input2 = new Label("Input");  
////    	    Label test2 = new Label("Test");  
////    
////    	    TextField text2 = new TextField();  
////    	    int x = 0;
////    	    Button submit = new Button("Solve");  
////    	    submit.setOnAction(new EventHandler<ActionEvent>() {  
////                
////                @Override  
////                public void handle(ActionEvent arg) {  
////                	input.setText("FUCKED");
////                    System.out.println("Button clicked");  
////                      
////                }  
////            } );  
////    	    GridPane root = new GridPane();  
////    	    root.addRow(0,test,input,text); 
////    	    root.addRow(1,test2,input2,text2);  
////    	    root.addRow(2,submit);  
////    	    Equations = text.getText();
//    }  
//    public static void main (String[] args)  
//    {  
//        launch(args);  
//    }  
//  
//}  