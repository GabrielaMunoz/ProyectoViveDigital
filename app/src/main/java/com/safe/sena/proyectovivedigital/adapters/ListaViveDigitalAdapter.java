package com.safe.sena.proyectovivedigital.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.safe.sena.proyectovivedigital.R;
import com.safe.sena.proyectovivedigital.models.PuntoViveDigital;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListaViveDigitalAdapter extends RecyclerView.Adapter<ListaViveDigitalAdapter.ViewHolder> {

    private ArrayList<PuntoViveDigital> dataset;
    private Context context;

    public ListaViveDigitalAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vive_digital, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PuntoViveDigital p = dataset.get(position);
        holder.campo1.setText(p.getDirecci_n_pvd());
        holder.campo2.setText(p.getEjecutor());
        holder.campo3.setText(p.getEstado_actual_de_la_carpeta());
        holder.campo4.setText(p.getFecha_de_convenio());

        ArrayList<String> urlsImg = new ArrayList<String>(Arrays.asList(
                "http://static.panoramio.com/photos/original/14133930.jpg",
                "http://www.asoticscolombia.com/wp-content/uploads/2014/09/colombiavivedigital.jpg",
                "http://juventic.colnodo.apc.org/apc-aa-files/73667361667364666473667364667364/minticactual1_thumb.png",
                "http://www.siliconweek.com/wp-content/uploads/2013/11/vive-digital.jpg",
                "http://www.parquesoftpasto.com/wp-content/uploads/2012/08/nvd_andicom.jpg",
                "https://colombiadigital.net/media/k2/items/cache/524deb06c01def4049c6aaafce7043bd_M.jpg",
                "https://image.slidesharecdn.com/andicom2013finfinal-130829134041-phpapp01-130829182259-phpapp01/95/rendicin-de-cuentas-luego-de-tres-aos-del-plan-vive-digital-4-638.jpg",
                "http://www.eluniversal.com.co/sites/default/files/invitacion_conferencia_0.jpg",
                "http://1.bp.blogspot.com/-Ex1IRICz2yY/U7BkxQI0KGI/AAAAAAAABe8/Rze33feodP0/s1600/vivedigital.PNG",
                "http://1.bp.blogspot.com/-0l0Y_QarGwU/VcFAwBMeuDI/AAAAAAAAFFk/bRG2-4yuICU/s1600/Fondo.jpg",
                "https://seeklogo.com/images/V/vive-colombia-logo-839B9475A9-seeklogo.com.gif"
        ));

        Glide.with(context)
                .load(urlsImg.get((int) (Math.random() * 10) + 1))
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);


        holder.btnShowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("error1", "presiono");
                Toast.makeText(context, "press", Toast.LENGTH_LONG);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                final View view = inflater.inflate(R.layout.show_punto_detail, null);
                builder.setView(view);

                builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                TextView tv = (TextView)view.findViewById(R.id.coordenadas);
                tv.setText(p.getCoordenadas_pvd_validadas().getCoordinates().toString());

                tv = (TextView)view.findViewById(R.id.departamento);
                tv.setText(p.getDepartamento());

                tv = (TextView)view.findViewById(R.id.direccion);
                tv.setText(p.getDirecci_n_pvd());

                tv = (TextView)view.findViewById(R.id.ejecutor);
                tv.setText(p.getEjecutor());

                tv = (TextView)view.findViewById(R.id.fue_donando);
                tv.setText(p.getEl_punto_ya_fue_donado_si_no());

                tv = (TextView)view.findViewById(R.id.escritura_de_donaci_n);
                tv.setText(p.getEscritura_de_donaci_n());

                tv = (TextView)view.findViewById(R.id.estado_actual_de_la_carpeta);
                tv.setText(p.getEstado_actual_de_la_carpeta());

                tv = (TextView)view.findViewById(R.id.fase);
                tv.setText(p.getFase());

                tv = (TextView)view.findViewById(R.id.fecha_de_convenio);
                tv.setText(p.getFecha_de_convenio());

                tv = (TextView)view.findViewById(R.id.horario_atenci_n_del_pvd);
                tv.setText(p.getHorario_atenci_n_del_pvd());

                tv = (TextView)view.findViewById(R.id.integrador_de_servicio);
                tv.setText(p.getIntegrador_de_servicio());

                tv = (TextView)view.findViewById(R.id.municipio);
                tv.setText(p.getMunicipio());

                tv = (TextView)view.findViewById(R.id.tipo_de_beneficiario);
                tv.setText(p.getTipo_de_beneficiario());

                tv = (TextView)view.findViewById(R.id.tipo_ejecutor);
                tv.setText(p.getTipo_ejecutor());

                tv = (TextView)view.findViewById(R.id.tipologia);
                tv.setText(p.getTipologia());

                final AlertDialog dialog = builder.create();
                dialog.show();

                //ocultar los botones por defecto
                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setVisibility(View.GONE);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<PuntoViveDigital> listaNueva) {
        dataset.addAll(listaNueva);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView fotoImageView;
        private TextView campo1;
        private TextView campo2;
        private TextView campo3;
        private TextView campo4;
        private Button btnShowMore;


        public ViewHolder(View itemView) {
            super(itemView);

            campo1 = (TextView) itemView.findViewById(R.id.campo1);
            campo2 = (TextView) itemView.findViewById(R.id.campo2);
            campo3 = (TextView) itemView.findViewById(R.id.campo3);
            campo4 = (TextView) itemView.findViewById(R.id.campo4);

            fotoImageView = (CircleImageView) itemView.findViewById(R.id.profile_image);
            btnShowMore = (Button) itemView.findViewById(R.id.btn_show_more);
        }
    }
}
