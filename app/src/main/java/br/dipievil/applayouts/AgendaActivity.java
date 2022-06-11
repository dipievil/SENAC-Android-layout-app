package br.dipievil.applayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AgendaActivity extends AppCompatActivity {

    private Spinner spCity, spState;
    private ArrayAdapter adapter;

    private String[] rs = {"Selecione a cidade...","Alvorada","Canoas","Porto Alegre"};

    private String[] sc = {"Selecione a cidade...","Balneário Camburiu","Blumenau","Florianópolis","Joinvile","Palhoça"};

    private String[] pr = {"Selecione a cidade...","Cascavel","Curitiba","Maringá"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        spCity = findViewById(R.id.spCity);
        spState = findViewById(R.id.spState);

        spState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadCities();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadCities(){
        int stateIndex = spState.getSelectedItemPosition();

        String[] cities = null;
        spCity.setEnabled(true);
        switch (stateIndex) {
            case 16:
                cities = pr;
                break;
            case 21:
                cities = rs;
                break;
            case 24:
                cities = sc;
                break;
            default:
                cities = new String[]{getString(R.string.txItemSelectStateWarning)};
                spCity.setEnabled(false);
                Toast.makeText(this, "O estado deve ser selecionado"+ stateIndex, Toast.LENGTH_LONG).show();
                break;
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        spCity.setAdapter(adapter);
    }
}