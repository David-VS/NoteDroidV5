package be.ehb.notedroid.view.fragments.util;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import be.ehb.notedroid.R;
import be.ehb.notedroid.model.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    protected class NoteViewHolder extends RecyclerView.ViewHolder{

        TextView tvCreated, tvTitle;
        CardView row;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCreated = itemView.findViewById(R.id.tv_row_created);
            tvTitle = itemView.findViewById(R.id.tv_row_title);
            row = itemView.findViewById(R.id.cv_row);

            row.setOnClickListener((View v)->{
                Log.d("ROW", tvTitle.getText().toString());
            });
        }
    }

    private ArrayList<Note> items;

    public NoteAdapter() {
        items = new ArrayList<>();
    }

    public void addItems(List<Note> items){
        this.items = new ArrayList<>(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rendered = layoutInflater.inflate(R.layout.note_adapter_row, parent, false);
        return new NoteViewHolder(rendered);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentNoteForRow = items.get(position);
        holder.tvCreated.setText(currentNoteForRow.getDateCreated().toString());
        holder.tvTitle.setText(currentNoteForRow.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
