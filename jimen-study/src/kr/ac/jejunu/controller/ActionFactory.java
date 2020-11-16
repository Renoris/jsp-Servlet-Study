package kr.ac.jejunu.controller;

import kr.ac.jejunu.controller.action.Action;
import kr.ac.jejunu.controller.action.ViewSelectRootAction;
import kr.ac.jejunu.controller.action.ViewWriteRootAction;
import kr.ac.jejunu.controller.action.WriteRootAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command, String method) {
		Action action= null;
		
		if(method.equals("get")) {
			if(command.equals("select")) {
				action=new ViewSelectRootAction();
			}else if(command.equals("insert")) {
				action=new ViewWriteRootAction();
			}
			
		}
		else {
			if(command.equals("insert")) {
				action=new WriteRootAction();
			}
		}
		
		
		
		
		return action;
	}
}
