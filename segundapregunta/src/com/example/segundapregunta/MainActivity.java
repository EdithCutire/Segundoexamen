package com.example.segundapregunta;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText vl1;
	private EditText vl2;
	private EditText vl3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        vl1=(EditText)findViewById(R.id.editText1);
        vl2=(EditText)findViewById(R.id.editText2);
        vl3=(EditText)findViewById(R.id.editText3);
    }
public void guardar (View View){
	//llamando al administrador
	AdminSQLite adminsql=new AdminSQLite(this,"administrador",null,1);
	//llamando a la base de datos
	SQLiteDatabase bdcanchis=adminsql.getWritableDatabase();
	//lllamando los datos a ingresar
	String vl1_temporal1=vl1.getText().toString();
	String vl2_temporal2=vl2.getText().toString();
	String vl3_temporal3=vl3.getText().toString();
	ContentValues formulario= new ContentValues();
	formulario.put("nombre", vl1_temporal1);
	formulario.put("apellido", vl2_temporal2);
	formulario.put("edad", vl3_temporal3);
	
	try {
		bdcanchis.insert("registro", null, formulario);
		Toast.makeText(this, "personal guardado", Toast.LENGTH_LONG).show();
		vl1.setText(" ");
		vl2.setText(" ");
		vl3.setText(" ");
	} catch (Exception e) {
		// TODO: handle exception
		Toast.makeText(this, "error"+e.getMessage(), Toast.LENGTH_LONG).show();
	}
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
