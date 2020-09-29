package com.example.multiobjectrecyclerview.adapter;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiobjectrecyclerview.R;
import com.example.multiobjectrecyclerview.domain.ExtraHoliday;
import com.example.multiobjectrecyclerview.domain.Items;
import com.example.multiobjectrecyclerview.domain.Note;
import com.example.multiobjectrecyclerview.domain.OrganizerItem;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter {
    private List<Items> itemsList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        itemsList = new ArrayList<>();

        Note note = new Note(20201111, "Notatka: lorem ipsum lorem ipsum ");
        itemsList.add(note);

        ExtraHoliday extraHoliday = new ExtraHoliday(20201111, "Boże narodzenie");
        itemsList.add(extraHoliday);

        OrganizerItem organizerItem = new OrganizerItem(20201111, "Dzienniczek obiad o 12");
        itemsList.add(organizerItem);
        View itemView;

        switch (viewType) {
            case Items.TYPE_NOTE:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
                return new NoteViewHolder(itemView);
            case Items.TYPE_EXTRAHOLIDAY:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_extraholiday, parent, false);
                return new ExtraHolidayViewHolder(itemView);
            default:
                itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_organizeritem, parent, false);
                return new OrganizerItemViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case Items.TYPE_NOTE:
                ((NoteViewHolder) holder).bindView(position);
                break;
            case Items.TYPE_EXTRAHOLIDAY:
                ((ExtraHolidayViewHolder) holder).bindView(position);
                break;
            case Items.TYPE_ORGINIZERITEM:
                ((OrganizerItemViewHolder) holder).bindView(position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (itemsList == null) {
            return 0;
        } else {
            return itemsList.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return itemsList.get(position).getType();
    }

    public void setItemsList(List<? extends Items> itemsListt) {
        if(itemsList == null){
            itemsList = new ArrayList<>();
        }
        itemsList.clear();
        itemsList.addAll(itemsListt);
        notifyDataSetChanged();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public NoteViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_note);
        }

        void bindView(int position) {
            Note note = (Note) itemsList.get(position);
            textView.setText(note.getText());
        }
    }

    class ExtraHolidayViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ExtraHolidayViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_extraHoliday);
        }

        void bindView(int position) {
            ExtraHoliday extraHoliday = (ExtraHoliday) itemsList.get(position);
            textView.setText(extraHoliday.getName());
        }
    }

    class OrganizerItemViewHolder extends RecyclerView.ViewHolder {
        private TextView time;
        private TextView prefix;
        private TextView text;

        public OrganizerItemViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.organizer_time);
            prefix = itemView.findViewById(R.id.organizer_prefix);
            text = itemView.findViewById(R.id.organizer_text);
        }

        void bindView(int position) {
            OrganizerItem organizerItem = (OrganizerItem) itemsList.get(position);
            time.setText("9:12");
            text.setText(organizerItem.getText());
        }
    }
}
