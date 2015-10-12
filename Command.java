import java.awt.*;
/**
 * Command.java
 * Superclass for commands.
 * Provides empty definitions for the methods executeClick, executePress,
 * and executeDrag. Each subclass should override some of the methods.
 * 
 * Written by THC for CS 10 Lab Assigment 1.
 * 
 * @author Tom Cormen
 * @author Maxwell Coleman, Isaac Gluck
 * collaborated with Anish Chadalavada
 */
public class Command {
  public void executeClick(Point p, Drawing dwg) { }
  public void executePress(Point p, Drawing dwg) { }
  public void executeDrag(Point p, Drawing dwg) { }
  public void executeRelease(Point P, Drawing dwg) { } // Added release function for the shape cmd classes
}