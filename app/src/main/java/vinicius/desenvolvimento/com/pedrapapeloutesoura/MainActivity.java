package vinicius.desenvolvimento.com.pedrapapeloutesoura;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String opcaoSelecionada){
        //seleciona o objeto imageview e passa pra variavel, pode ser acessada todas as propriedades por ela
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);
        int numero = new Random().nextInt(3);
        String opcoes[] = {"pedra","papel","tesoura"};
        String opcaoApp = opcoes[numero];

        switch ( opcaoApp ) {
            case "pedra":
                // o R como param. pode acessar todos os recursos do proj e identificadores
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
            }
            //todas possibilidades do app ganhar
            if(
                     (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")||
                     (opcaoApp == "papel" && opcaoSelecionada == "pedra")||
                     (opcaoApp == "tesoura" && opcaoSelecionada == "papel")
               ){
                textoResultado.setText("Você perdeu! :(");
            }
             //todas possibidades do usuario ganhar
             else if(
                     (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")||
                     (opcaoSelecionada == "papel" && opcaoApp == "pedra")||
                     (opcaoSelecionada == "tesoura" && opcaoApp == "papel")
             ){
                textoResultado.setText("Você Ganhou :)!");
            }else{
                textoResultado.setText("Empatamos ;) ");
                }

        System.out.println("app selecionou " + opcaoApp);
    }
}

