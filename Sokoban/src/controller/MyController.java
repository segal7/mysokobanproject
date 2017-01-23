package controller;

import java.util.Observable;
import java.util.Observer;

import model.Model;
import view.View;

public class MyController implements Controller,Observer{
	Model _model;
	View _view;
	
	public MyController(Model model,View view){
		_model = model;
		_view = view;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
