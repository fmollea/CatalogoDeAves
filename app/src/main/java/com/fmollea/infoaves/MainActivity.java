package com.fmollea.infoaves;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fmollea.infoaves.Adapters.adapterImageViewPager;

public class MainActivity extends AppCompatActivity {

    private TextView txtName;
    private TextView txtDescription;
    private ViewPager vpImages;
    private String[] url_arr;
    private String[] descr_arr;
    private String[] name_arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setComponents();
        eventViewPager();
    }

    private void setComponents(){
        //Binding del view pager
        vpImages = (ViewPager) findViewById(R.id.vpImages);
        txtName = (TextView) findViewById(R.id.name);
        txtDescription = (TextView) findViewById(R.id.description);

        initArray(); //this method init array with  urls of bird images
        initViewPager();
    }

    private void eventViewPager(){
        vpImages.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                txtName.setText(name_arr[position]);
                txtDescription.setText(descr_arr[position]);
            }
        });
    }

    private void initViewPager(){
        vpImages.setAdapter(new adapterImageViewPager(this, url_arr));
        txtName.setText(name_arr[0]);
        txtDescription.setText(descr_arr[0]);
    }

    private void initArray(){
        url_arr = new String[]{
                "https://static.vix.com/es/sites/default/files/styles/large/public/btg/curiosidades.batanga.com/files/Las-8-aves-mas-extranas-del-mundo-7.jpg",
                "https://static.vix.com/es/sites/default/files/styles/large/public/btg/curiosidades.batanga.com/files/Las-8-aves-mas-extranas-del-mundo-5.jpg",
                "https://static.vix.com/es/sites/default/files/styles/large/public/btg/curiosidades.batanga.com/files/Las-8-aves-mas-extranas-del-mundo-8.jpg",
                "https://www.euroresidentes.com/hogar/mascotas/wp-content/uploads/sites/5/2014/10/La-foto-del-dia-el-curioso-pajaro-bobo-de-patas-azules.jpg",
                "https://www.euroresidentes.com/hogar/mascotas/wp-content/uploads/sites/5/2014/10/rabi.jpg",
                "https://www.euroresidentes.com/hogar/mascotas/wp-content/uploads/sites/5/2014/10/El-Quetzal-de-bruno.jpg"
        };

        descr_arr = new String[]{
                "Este animal se encuentra en África, Europa y Asia, y es ampliamente reconocido por su corona de plumas.\nSe alimenta de insectos, gusanos y pequeñas ranas, al meter su cabeza dentro de la tierra puede abrir su pico para buscar su alimento.",
                "Son distinguidos por su cara extraña, con un pico muy largo que utilizan para comer carroña, de manera similar a los buitres.",
                "Su alimentación consiste en carroña, aprovechando los animales muertos que encuentre en su camino. Pueden llegar a vivir 50 años y sus alas desplegadas miden tres metros.",
                "Habita las costas existentes entre Perú y el golfo de California, además de las islas Galápagos. El característico color azul intenso de sus patas procede de los pigmentos carotenoides que proceden de su dieta, ya que estas aves son incapaces de sintetizar los carotenoides y tienen que asimilarlos a través de la alimentación",
                "Es una especie de ave suliforme de la familia Fregatidae endémica de la isla de Navidad y en grave peligro de extinción. La principal razón de su declive y una de sus mayores amenazas para su conservación, es la destrucción de su hábitat causada por la minería.",
                "Tienen una dieta variada, incluyendo muchos frutos (sobre todo de los árboles lauráceas) y también insectos y ranas. Su hábitat es la selva montañosa, en espacios húmedos.\nEsta ave tiene un papel importante en la mitología prehispánica y moderna de la región.  "
        };

        name_arr = new String[]{
                "Abubilla",
                "Marabú africano",
                "Cóndor de California",
                "Sula de patas azules",
                "Rabihorcado",
                "El Quetzal"
        };
    }
}
