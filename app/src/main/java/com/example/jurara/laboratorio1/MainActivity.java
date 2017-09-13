package com.example.jurara.laboratorio1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private final String NC="NAME";
    private final String CEL="ajsdj";
    private final String DIR="kkkk";
    private final String FEC="klall";
    private final String HOR="ooooo";
    private final String NP="aaaa";
    private final String NPO="kmkmk";
    private final String CHEECK = "qqqq";
    private final String SEE="a";



    private EditText nc,cel,dir,fec,hor,np,npo;
    CheckBox check;
    SeekBar see;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nc=(EditText)findViewById(R.id.txtNC);
        cel=(EditText)findViewById(R.id.txtC);
        dir=(EditText)findViewById(R.id.txtD);
        fec=(EditText)findViewById(R.id.txtF);
        hor=(EditText)findViewById(R.id.txtH);
        np=(EditText)findViewById(R.id.txtNP);
        npo=(EditText)findViewById(R.id.txtNPO);
        check=(CheckBox)findViewById(R.id.checkBox);
        see=(SeekBar)findViewById(R.id.seekBar);
        txt=(TextView)findViewById(R.id.textView);
        see.setMax(10);
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String ncli = sharedPreferences.getString(NC,null);
        String celcli = sharedPreferences.getString(CEL,null);
        String dircli = sharedPreferences.getString(DIR,null);
        String feccli = sharedPreferences.getString(NC,null);
        String horcli = sharedPreferences.getString(CEL,null);
        String npcli = sharedPreferences.getString(DIR,null);
        String npocli = sharedPreferences.getString(NC,null);
        String ch=sharedPreferences.getString(CHEECK,null);
        String can=sharedPreferences.getString(SEE,null);

        String a="";
        if (ncli==null) {
            nc.setText(a);
        }
        if(celcli==null){
            cel.setText(a);
        }
        if (dircli==null){
            dir.setText(a);
        }
        if(feccli==null){
            fec.setText(a);
        }
        if (horcli==null){
            hor.setText(a);
        }
        if (npcli==null){
            np.setText(a);
        }
        if (npocli==null){
            npo.setText(a);
        }
        if(ch==null){
            check.setActivated(false);
        }
        if(can==null){
            txt.setText("Cantidad de Meseros: 0");
        }
        else {
            nc.setText(ncli);
            cel.setText(celcli);
            dir.setText(dircli);
            fec.setText(feccli);
            hor.setText(horcli);
            np.setText(npcli);
            npo.setText(npocli);
            if(ch.equals("true")) {
                check.setChecked(true);
            }else{
                check.setChecked(false);
            }
            txt.setText("Cantidad de Meseros: "+can);
        }

    }


    public void saveText(View view) {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString(NC, nc.getText().toString());
        editor.putString(CEL,cel.getText().toString());
        editor.putString(DIR,dir.getText().toString());
        editor.putString(FEC,fec.getText().toString());
        editor.putString(HOR,hor.getText().toString());
        editor.putString(NP,np.getText().toString());
        editor.putString(NPO,npo.getText().toString());
        editor.putString(CHEECK,check.isChecked()+"");

        editor.putString(SEE,see.getProgress()+"");
        editor.commit();
        Toast.makeText(getApplicationContext(), "Datos Guardados!!!",
                Toast.LENGTH_LONG).show();
    }


}
