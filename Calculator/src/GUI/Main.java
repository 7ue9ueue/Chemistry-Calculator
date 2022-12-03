package GUI;

import java.io.IOException;
import java.util.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

public class Main extends Application{  
  
	public static String Equations;
	GridPane root = new GridPane();  
	ArrayList<Label> labels = new ArrayList<Label>();
	ArrayList<TextField> entrys = new ArrayList<TextField>();
	Label title = new Label("Chemistry Balance Equation Solver");
	Button reset = new Button("reset");
	Button solve = new Button("solve");
	Button add = new Button("Add");
	Button equal = new Button("=");
	int equalPosition = -1;
	HBox box = new HBox(); 
	String output = "";
	boolean error = false;
	Label result = new Label();
	public void printScreen (Stage primaryStage) 
	{
		root = new GridPane();
		VBox left = new VBox();
		VBox right = new VBox();
		int ID = 0;
		int n = labels.size();
		root.addRow(ID++,title);
		for (int i=0;i<n;i++) 
		{
			Label l = labels.get(i);
			l.setFont(new Font("Cambria",18));
			TextField t = entrys.get(i);
			if (i==0) 
			{
				box = new HBox(); 
				box.setSpacing(10);
				box.getChildren().addAll(l,t,add);
				//root.addRow(ID++,box);
				left.getChildren().add(box);
			}
			else 
			{
				box = new HBox(); 
				box.setSpacing(10);
				box.getChildren().addAll(l,t);
				//root.addRow(ID++,box);
				left.getChildren().add(box);
			}
			if (equalPosition-1==i) 
			{
				box = new HBox(); 
				box.getChildren().addAll(new Label("="));
				//root.addRow(ID++,box);
				left.getChildren().add(box);
			}
		}
		box = new HBox(); 
		box.setSpacing(5);
		if (equalPosition==-1) box.getChildren().addAll(reset,solve,equal);
		else box.getChildren().addAll(reset,solve);
		left.getChildren().add(box);
		result = new Label(output);
		right.getChildren().add(result);
		
		HBox screen = new HBox();
		screen.setSpacing(50);
		screen.getChildren().addAll(left,right);
		root.addRow(ID++,screen);
	    Scene scene = new Scene(root,600,400); 
	    
	    Decoration();
	    primaryStage.setScene(scene);  
	    primaryStage.setTitle("Chemsitry Calculator");  
	    primaryStage.show();  
	}
	
	public void Decoration () 
	{
		title.setTextFill((Color.web("#0076a3")));
		title.setFont(new Font("Cambria",32));
		if (error) result.setTextFill((Color.web("#ff0000")));
		result.setFont(new Font("Cambria",20));
	}

	public void initial ()
	{
		labels.clear();
		entrys.clear();
		result = new Label();
		labels.add(new Label());
		entrys.add(new TextField("Enter Chemical Here"));
		equalPosition = -1;
		output = "";
		error = false;
	}
    public void start (Stage stage) throws Exception 
    {  
    	initial();
    	printScreen(stage);
    	reset.setOnAction(new EventHandler<ActionEvent>() {  
    		@Override  
          	public void handle(ActionEvent arg) {  
    			initial();
    			root = new GridPane();
    			printScreen(stage);
    		}  
    	});  
    	solve.setOnAction (new EventHandler<ActionEvent>() {  
    		@Override  
          	public void handle(ActionEvent arg) {  
    			ArrayList<String> names = new ArrayList<String>();
    			int n = entrys.size();
    			for (int i=0;i<entrys.size();i++) 
    			{
    				String s = entrys.get(i).getText();
    				names.add(entrys.get(i).getText());
    				System.out.println(s);
    			}
    			try 
    			{
					ArrayList<Integer> answer = operator.Main.solve(n,names);
					if (answer==null)
					{
						error = true;
						output = "ERROR: invalid entry";
					}
					else 
					{
						labels.clear();
						for (int i=0;i<n;i++) 
						{
							String s = String.valueOf(Math.abs(answer.get(i)));
							Label l = new Label(s);
							//Decoration Begin
							l.prefWidth(10);
							if (answer.get(i)<0) l.setTextFill((Color.web("#0000ff")));
							//Decoration End
							labels.add(l);
						}
						convert(answer,names);
					}
					//printScreen(stage);
				} 
    			catch (IOException e) 
    			{
					e.printStackTrace();
				}
    			printScreen(stage);
    		}  
    	}); 
    	equal.setOnAction (new EventHandler<ActionEvent>() {  
    		@Override  
          	public void handle(ActionEvent arg) {  
    			if (equalPosition==-1&&labels.size()>0)
    			{
    				equalPosition = labels.size();
    			}
    			printScreen(stage);
    		}  
    	}); 
    	add.setOnAction(new EventHandler<ActionEvent>() {  
    		@Override  
          	public void handle(ActionEvent arg) {  
    			labels.add(new Label());
    			entrys.add(new TextField());
    			printScreen(stage);
    		}  
    	});
    }  
    public static void main (String[] args)  
    {  
        launch(args);  
    }  
  
    public void convert (ArrayList<Integer> answer, ArrayList<String> names) 
    {
    	error = false;
    	output = "";
		ArrayList<Integer> positive = new ArrayList<Integer>();
		ArrayList<Integer> negative = new ArrayList<Integer>();
		int n = answer.size();
		for (int i=0;i<n;i++) 
		{
			String name = names.get(i);
			int value = answer.get(i);
			if (value>0) positive.add(i);
			else negative.add(i);
		}
		for (int i=0;i<positive.size();i++) 
		{
			int index = positive.get(i);
			String name = names.get(index);
			int value = answer.get(index);
			output += value+"("+name+") ";
			if (i!=positive.size()-1) output += "+ ";
		}
		output += "= ";
		for (int i=0;i<negative.size();i++) 
		{
			int index = negative.get(i);
			String name = names.get(index);
			int value = answer.get(index);
			output += -value+"("+name+") ";
			if (i!=negative.size()-1) output += "+ ";
		}
    }
}  