package com.jrogerio.skyscannerdam;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jrogerio.skyscannerdam.model.Vuelo;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class VueloFragment extends Fragment {

    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private List<Vuelo> vueloList;
    MyVueloRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public VueloFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vuelo_list, container, false);

        vueloList = new ArrayList<>();
        vueloList.add(new Vuelo("Sevilla", "Madrid", "13:30", 2.30, 100, "http://www.lavanguardia.com/r/GODO/LV/p4/WebSite/2017/08/28/Recortada/img_cpizcueto_20170828-120600_imagenes_lv_terceros_avion-kN7-U43885684875JvF-992x558@LaVanguardia-Web.jpg"));
        vueloList.add(new Vuelo("Sevilla", "Madrid", "13:30", 2.30, 100, "http://www.lavanguardia.com/r/GODO/LV/p4/WebSite/2017/08/28/Recortada/img_cpizcueto_20170828-120600_imagenes_lv_terceros_avion-kN7-U43885684875JvF-992x558@LaVanguardia-Web.jpg"));
        vueloList.add(new Vuelo("Sevilla", "Madrid", "13:30", 2.30, 100, "http://www.lavanguardia.com/r/GODO/LV/p4/WebSite/2017/08/28/Recortada/img_cpizcueto_20170828-120600_imagenes_lv_terceros_avion-kN7-U43885684875JvF-992x558@LaVanguardia-Web.jpg"));
        vueloList.add(new Vuelo("Sevilla", "Madrid", "13:30", 2.30, 100, "http://www.lavanguardia.com/r/GODO/LV/p4/WebSite/2017/08/28/Recortada/img_cpizcueto_20170828-120600_imagenes_lv_terceros_avion-kN7-U43885684875JvF-992x558@LaVanguardia-Web.jpg"));
        vueloList.add(new Vuelo("Sevilla", "Madrid", "13:30", 2.30, 100, "http://www.lavanguardia.com/r/GODO/LV/p4/WebSite/2017/08/28/Recortada/img_cpizcueto_20170828-120600_imagenes_lv_terceros_avion-kN7-U43885684875JvF-992x558@LaVanguardia-Web.jpg"));
        vueloList.add(new Vuelo("Sevilla", "Madrid", "13:30", 2.30, 100, "http://www.lavanguardia.com/r/GODO/LV/p4/WebSite/2017/08/28/Recortada/img_cpizcueto_20170828-120600_imagenes_lv_terceros_avion-kN7-U43885684875JvF-992x558@LaVanguardia-Web.jpg"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new MyVueloRecyclerViewAdapter(getActivity(), vueloList, mListener);
            recyclerView.setAdapter(adapter);

        }
        return view;
    }


    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }
    */

    /*
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    */

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Vuelo item);
    }

}
