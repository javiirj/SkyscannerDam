package com.jrogerio.skyscannerdam;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jrogerio.skyscannerdam.VueloFragment.OnListFragmentInteractionListener;

import com.jrogerio.skyscannerdam.model.Vuelo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyVueloRecyclerViewAdapter extends RecyclerView.Adapter<MyVueloRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Vuelo> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyVueloRecyclerViewAdapter(Context context, List<Vuelo> items, OnListFragmentInteractionListener listener) {
        ctx = context;
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_vuelo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewOrigen.setText(holder.mItem.getOrigen());
        holder.textViewDestino.setText(holder.mItem.getDestino());
        holder.textViewHoraSalida.setText(holder.mItem.getHoraSalida());
        holder.textViewDuracion.setText(String.valueOf(holder.mItem.getDuracion()));
        holder.textViewPrecio.setText(String.valueOf(holder.mItem.getPrecio()));

        Picasso.with(ctx)
                .load(holder.mItem.getUrlFoto())
                .resize(500,150)
                .centerCrop()
                .into(holder.imageViewFoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public final TextView textViewOrigen;
        public final TextView textViewDestino;
        public final TextView textViewHoraSalida;
        public final TextView textViewDuracion;
        public final TextView textViewPrecio;
        private final ImageView imageViewFoto;

        public Vuelo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewOrigen = view.findViewById(R.id.textViewOrigen);
            textViewDestino = view.findViewById(R.id.textViewDestino);
            textViewHoraSalida = view.findViewById(R.id.textViewHoraSalida);
            textViewDuracion = view.findViewById(R.id.textViewDuracion);
            textViewPrecio = view.findViewById(R.id.textViewPrecio);
            imageViewFoto = view.findViewById(R.id.imageViewFoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewOrigen.getText() + "'";
        }
    }
}
