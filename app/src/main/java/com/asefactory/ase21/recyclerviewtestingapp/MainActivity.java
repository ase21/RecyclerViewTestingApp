package com.asefactory.ase21.recyclerviewtestingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.asefactory.ase21.recyclerviewtestingapp.pojo.BeerObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<BeerObject> beerObjectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBeer();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new BeerRecyclersAdapter(this, beerObjectList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initBeer() {
        beerObjectList.add(new BeerObject("Американские хмели – «Каскад» и «Пекко» ярко раскрываются, " +
                "создавая цветочно-фруктовый аромат с выраженными цитрусовыми оттенками. " +
                "Освежающий вкус с приятной характерной горчинкой несомненно запомнится насыщенным вкусом и ароматом. ",
                "5,0 %",
                "Волковская пивоварня",
                "СВЕТЛЯЧОК",
                "https://irecommend.ru/sites/default/files/product-images/298886/nd7guhq1Kk0GWmOUD8XRGw.png",
                "Лагер"));
        beerObjectList.add(new BeerObject("Вишнёвый эль, обладающий выраженным кисло-сладким вкусом, довольно освежающим и не слишком приторным. " +
                "Послевкусие горьковатое, миндальное с ощутимыми тонами вишнёвой косточки. Аромат у нашего эля восхитительный, легкий, фруктовый.",
                "6,2 %",
                "Волковская пивоварня",
                "МИШЕНЬКА ПОД ВИШЕНКОЙ",
                "https://i.otzovik.com/objects/b/1090000/1081551.png",
                "Фруктовый эль"));
        beerObjectList.add(new BeerObject("Десертный стаут с добавлением обжаренной кокосовой стружки, холодно заваренного кофе и капелькой ванили.",
                "7,0 %",
                "Plan B Brewery",
                "ЗАВТРАК ПАПУАСА",
                "https://untappd.akamaized.net/site/beer_logos/beer-2169923_814eb_sm.jpeg",
                "Молочный стаут"));
    }
}
