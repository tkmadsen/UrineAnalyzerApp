package com.au615584.urineanalyzerapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.au615584.urineanalyzerapp.Model.AnalysisType;
import com.au615584.urineanalyzerapp.R;

import java.util.ArrayList;

//This is a custom implementation of the RecyclerView.Adaptor class that handles a list of analysistypes objects
public class AnalysisTypeAdapter extends RecyclerView.Adapter<AnalysisTypeAdapter.AnalysisTypeViewHolder>{

    //interface for handling when and Person item is clicked in various ways
    public interface IAnalysisTypeItemClickedListener{
        void onAnalysisItemClicked(int index);
        void ChooseAnalysisType(AnalysisType analysisType);
    }

    //callback interface for user actions on each item
    private IAnalysisTypeItemClickedListener listener;

    //data in the adapter
    private ArrayList<AnalysisType> typeList;

    //constructor
    public AnalysisTypeAdapter(IAnalysisTypeItemClickedListener listener){
        this.listener = listener;
    }

    //a method for updating the list - causes the adapter/recyclerview to update
    public void updateAnalysisTypeList(ArrayList<AnalysisType> lists){
        typeList = lists;
        notifyDataSetChanged();
    }

    //override this method to create the viewholder object the first time they are requested
    //use the inflater from parent (Activity's viewgroup) to get the view and then use view holders constructor
    @NonNull
    @Override
    public AnalysisTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.analysistype_item, parent, false);
        AnalysisTypeViewHolder vh = new AnalysisTypeViewHolder(v, listener);
        return vh;
    }


    //override this to fill in data from Person object at position into the view holder
    @Override
    public void onBindViewHolder(@NonNull AnalysisTypeViewHolder holder, int position) {

        holder.txtType.setText(typeList.get(position).name);
        holder.btnChooseType.setText((R.string.btnChooseLan));
    }

    //override this to return size of list
    @Override
    public int getItemCount() {
        return typeList.size();
    }

    //The ViewHolder class for holding information about each list item in the RecyclerView
    public class AnalysisTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //viewholder ui widget references
        ImageView imgIcon;
        TextView txtType;
        Button btnChooseType;

        //custom callback interface for user actions done the view holder item
        IAnalysisTypeItemClickedListener listener;

        //constructor
        public AnalysisTypeViewHolder(@NonNull View itemView, IAnalysisTypeItemClickedListener analysisTypeItemClickedListener) {
            super(itemView);

            //get references from the layout file
            txtType = itemView.findViewById(R.id.txtAnalysisType);
            btnChooseType = itemView.findViewById(R.id.btnChooseType);
            listener = analysisTypeItemClickedListener;

            //set click listener for whole list item
            itemView.setOnClickListener(this);

            //set click listener specifically for the invite button
            btnChooseType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.ChooseAnalysisType(typeList.get(getAdapterPosition()));
                }
            });
        }

        //react to user clicking the listitem (implements OnClickListener)
        @Override
        public void onClick(View view) {
            listener.onAnalysisItemClicked(getAdapterPosition());
        }
    }
}
