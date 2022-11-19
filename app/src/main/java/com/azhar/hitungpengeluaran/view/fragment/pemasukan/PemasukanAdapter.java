package com.azhar.hitungpengeluaran.view.fragment.pemasukan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.azhar.hitungpengeluaran.R;
import com.azhar.hitungpengeluaran.model.ModelDatabase;
import com.azhar.hitungpengeluaran.utils.FunctionHelper;

import java.util.List;

public class PemasukanAdapter extends RecyclerView.Adapter<PemasukanAdapter.ViewHolder> {

    private Context context;
    private List<ModelDatabase> list;
    private PemasukanAdapterCallback mAdapterCallback;

    public PemasukanAdapter(Context context, List<ModelDatabase> list,
                            PemasukanAdapterCallback adapterCallback) {
        this.context = context;
        this.list = list;
        this.mAdapterCallback = adapterCallback;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_data,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelDatabase modelDatabase = list.get(position);
        holder.bindData(modelDatabase);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void clear() {
        int size = this.list.size();
        this.list.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void addData(List<ModelDatabase> pengeluarans) {
        this.list = pengeluarans;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvPrice, tvNote, tvDate;
        public ImageView ivDelete;

        ViewHolder(View itemView) {
            super(itemView);

            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvNote = itemView.findViewById(R.id.tvNote);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivDelete = itemView.findViewById(R.id.ivDelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModelDatabase pemasukan = list.get(getAdapterPosition());
                    mAdapterCallback.onEdit(pemasukan);
                }
            });

            ivDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ModelDatabase pemasukan = list.get(getAdapterPosition());
                    mAdapterCallback.onDelete(pemasukan);
                }
            });
        }

        void bindData(ModelDatabase item) {
            int price = item.jmlUang;
            String initPrice = FunctionHelper.rupiahFormat(price);
            tvPrice.setText(initPrice);

            String note = item.keterangan;
            tvNote.setText(note);

            String date = item.tanggal;
            tvDate.setText(date);
        }
    }

    public interface PemasukanAdapterCallback {
        void onEdit(ModelDatabase modelDatabase);

        void onDelete(ModelDatabase modelDatabase);
    }

}