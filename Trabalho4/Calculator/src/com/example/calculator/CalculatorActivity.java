package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class CalculatorActivity extends Activity {

	public enum CalcOperations{
		ADD,
		SUB,
		MULT,
		DIV,
		NONE
	};
	
	private CalcOperations operation = CalcOperations.NONE;
	
	private double oper1 = 0.0;
	
	private Button buttonAdd;
	private Button buttonSub;
	private Button buttonMult;
	private Button buttonDiv;
	private Button buttonEqual;
	private Button buttonCE;
	
	private EditText resultOutput;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		
		buttonAdd = (Button) this.findViewById(R.id.buttonAdd);
		buttonAdd.setOnClickListener(new calculatorButtonListener(CalcOperations.ADD));
		buttonSub = (Button) this.findViewById(R.id.buttonSub);
		buttonSub.setOnClickListener(new calculatorButtonListener(CalcOperations.SUB));
		buttonMult = (Button) this.findViewById(R.id.buttonMult);
		buttonMult.setOnClickListener(new calculatorButtonListener(CalcOperations.MULT));
		buttonDiv = (Button) this.findViewById(R.id.buttonDiv);
		buttonDiv.setOnClickListener(new calculatorButtonListener(CalcOperations.DIV));
		
		resultOutput = (EditText) this.findViewById(R.id.editOutput);
		resultOutput.setText("0");
		
		
		buttonEqual = (Button) this.findViewById(R.id.buttonEqual);
		buttonEqual.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				if(operation == CalcOperations.NONE)
					return;
				
				double oper2 = Double.parseDouble(resultOutput.getText().toString());
				double result = oper1;
				switch(operation){
					case ADD:
						result = oper1 + oper2;
						break;
					case SUB:
						result = oper1 - oper2;
						break;
					case MULT:
						result = oper1*oper2;
						break;
					case DIV:
						result = oper1/oper2;
						if(oper2 == 0){
							result = 0;
						}
						break;
					default:
						break;
				}
				
				oper1 = result;
				resultOutput.setText(Double.toString(result));
				operation = CalcOperations.NONE;
				
			}
			
		});
		
		buttonCE = (Button) this.findViewById(R.id.buttonCE);
		buttonCE.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				oper1 = 0.0;
				resultOutput.setText("0");
				operation = CalcOperations.NONE;
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calculator, menu);
		return true;
	}

    private class calculatorButtonListener implements OnClickListener{
    	
    	CalcOperations newOperation;
    	
    	public calculatorButtonListener(CalculatorActivity.CalcOperations newOperation){
    		this.newOperation = newOperation;
    	}
    	
		@Override
		public void onClick(View arg0) {
			if(operation != CalcOperations.NONE){
				double oper2 = Double.parseDouble(resultOutput.getText().toString());
				double result = oper1;
				switch(operation){
					case ADD:
						result = oper1 + oper2;
						break;
					case SUB:
						result = oper1 - oper2;
						break;
					case MULT:
						result = oper1*oper2;
						break;
					case DIV:
						if(oper2 == 0)
							result = 0;
						else
							result = oper1/oper2;
						break;
					case NONE:
						break;
				}
				
				oper1 = result;
				resultOutput.setText(Double.toString(result));
				operation = CalcOperations.NONE;
			}
			else{

				oper1 = Double.parseDouble(resultOutput.getText().toString());
				resultOutput.setText("0");
				operation = newOperation;
			}
			
			
		}
    }
    
	
}
