package com.example.appsms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView celular,mensaje;
    Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celular=(TextView)findViewById(R.id.etCelular);
        mensaje=(TextView)findViewById(R.id.etMensaje);
        enviar=(Button)findViewById(R.id.btnEnviar);

        //Añadimos un escuchador al boton
        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Creamos las variables que guardaran los datos proporcionados por el usuario
        String sms;
        String number;
        switch (v.getId()){
            case R.id.btnEnviar:{
                try{
                    //Vinculamos las variables creadas con los objetos que contendran la informacion del usuario
                    number=celular.getText().toString();
                    sms=mensaje.getText().toString();

                    SmsManager manager= SmsManager.getDefault();

                    if(!sms.equals("")){
                        Toast t=Toast.makeText(this,"Ingrese mensaje",Toast.LENGTH_LONG);
                        t.show();
                    }else if(!number.equals("")){
                        Toast t=Toast.makeText(this,"Ingrese numero de celular",Toast.LENGTH_LONG);
                        t.show();
                    }else{
                        //Enviamos el mensaje al numero ingresado por el usuario
                        manager.sendTextMessage(number,null,sms,null,null);
                        //Mostramos un mensaje indicandole al usuario que su operacion fue exitosa
                        Toast t=Toast.makeText(this,"Mensaje Enviado correctamente !!",Toast.LENGTH_LONG);
                        t.show();
                    }
                }catch (Exception ex){
                    Toast t=Toast.makeText(this,"Mensaje Enviado correctamente !!",Toast.LENGTH_LONG);
                    t.show();
                }
            }break;
        }
    }
}
