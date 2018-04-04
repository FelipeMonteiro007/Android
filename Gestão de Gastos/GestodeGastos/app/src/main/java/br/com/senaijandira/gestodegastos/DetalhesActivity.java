package br.com.senaijandira.gestodegastos;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class DetalhesActivity extends AppCompatActivity {

    TabLayout tb_detalhe;
    ViewPager vp_detalhe;
    Fragmento fragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tb_detalhe = (TabLayout) findViewById(R.id.tb_detalhe);
        vp_detalhe = (ViewPager) findViewById(R.id.vp_detalhes);

        //Criando divisao de telas

        fragmento = new Fragmento(getSupportFragmentManager());

        vp_detalhe.setAdapter(fragmento);
        tb_detalhe.setupWithViewPager(vp_detalhe);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public class Fragmento extends FragmentPagerAdapter {

        public Fragmento(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0){
                return new DespesasFragment();

            }else if (position == 1){
                return new ReceitasFragment();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return "Despesas";
            }else if (position == 1){
                return "Receitas";
            }
            return null;
        }
    }

}
