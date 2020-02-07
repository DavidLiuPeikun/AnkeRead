package cn.njcit.ankeread.ui.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.njcit.ankeread.Bean.RankBean;
import cn.njcit.ankeread.Bean.SortBook;
import cn.njcit.ankeread.R;
import cn.njcit.ankeread.ui.Activity.SearchActivity;

/**
 * Create by ankele
 * <p>
 * 2020/2/7 - 18:13
 */
public class RankBookAdapter extends RecyclerView.Adapter<RankBookAdapter.ViewHolder> {

    private Context context;
    private List<RankBean.BooksBean> books;

    public RankBookAdapter(Context context, List<RankBean.BooksBean> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_sortbook,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RankBean.BooksBean book = books.get(position);
        Glide.with(context).load(book.getCover()).into(holder.sortBookPic);
        holder.sortBookName.setText(book.getTitle());
        holder.sortBookAuthor.setText("作者："+book.getAuthor());
        holder.sortBookTag.setText("分类："+book.getCat());
        holder.sortBookInfo.setText("    "+book.getLongIntro());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SearchActivity.class);
                intent.putExtra("Name",book.getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView sortBookPic;
        TextView sortBookName;
        TextView sortBookAuthor;
        TextView sortBookTag;
        TextView sortBookInfo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sortBookPic = (ImageView)itemView.findViewById(R.id.sortBook_pic);
            sortBookName = (TextView)itemView.findViewById(R.id.sortBook_name);
            sortBookAuthor = (TextView)itemView.findViewById(R.id.sortBook_author);
            sortBookTag = (TextView)itemView.findViewById(R.id.sortBook_cat);
            sortBookInfo = (TextView)itemView.findViewById(R.id.sortBook_info);
        }
    }
}
