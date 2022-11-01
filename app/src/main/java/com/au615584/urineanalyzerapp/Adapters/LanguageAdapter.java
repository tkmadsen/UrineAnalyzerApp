package com.au615584.urineanalyzerapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.au615584.urineanalyzerapp.Model.Language;
import com.au615584.urineanalyzerapp.R;

import java.util.ArrayList;

//Custom implementation of the RecyclerView.Adaptor class that handles a list of Person objects
public class LanguageAdapter extends RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder> {

    //interface for handling when and Person item is clicked in various ways
    public interface ILanguageItemClickedListener{
        void onLanguageClicked(int index);
        void ChooseLanguage(Language language);
    }

    //callback interface for user actions on each item
    private ILanguageItemClickedListener listener;

    //data in the adapter
    private ArrayList<Language> languageList;

    //constructor
    public LanguageAdapter(ILanguageItemClickedListener listener){
        this.listener = listener;
    }

    //a method for updating the list - causes the adapter/recyclerview to update
    public void updateLanguageList(ArrayList<Language> lists){
        languageList = lists;
        notifyDataSetChanged();
    }

    //override this method to create the viewholder object the first time they are requested
    //use the inflater from parent (Activity's viewgroup) to get the view and then use view holders constructor
    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lan_item, parent, false);
        LanguageViewHolder vh = new LanguageViewHolder(v, listener);
        return vh;
    }


    //override this to fill in data from Person object at position into the view holder
    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder holder, int position) {

        holder.txtName.setText(languageList.get(position).language);
        holder.btnSend.setText((R.string.btnChooseLan));

        if(languageList.get(position).imageResourceId == 0){
            holder.imgIcon.setImageResource(R.drawable.dk);
        } else {
            holder.imgIcon.setImageResource(R.drawable.gb);
        }
    }

    //override this to return size of list
    @Override
    public int getItemCount() {
        return languageList.size();
    }

    //The ViewHolder class for holding information about each list item in the RecyclerView
    public class LanguageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //viewholder ui widget references
        ImageView imgIcon;
        TextView txtName;
        Button btnSend;

        //custom callback interface for user actions done the view holder item
        ILanguageItemClickedListener listener;

        //constructor
        public LanguageViewHolder(@NonNull View itemView, ILanguageItemClickedListener languageItemClickedListener) {
            super(itemView);

            //get references from the layout file
            imgIcon = itemView.findViewById(R.id.imgLan);
            txtName = itemView.findViewById(R.id.txtLan);
            btnSend = itemView.findViewById(R.id.btnChooseLan);
            listener = languageItemClickedListener;

            //set click listener for whole list item
            itemView.setOnClickListener(this);

            //set click listener specifically for the invite button
            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.ChooseLanguage(languageList.get(getAdapterPosition()));
                }
            });
        }

        //react to user clicking the listitem (implements OnClickListener)
        @Override
        public void onClick(View view) {
            listener.onLanguageClicked(getAdapterPosition());
        }
    }
}
