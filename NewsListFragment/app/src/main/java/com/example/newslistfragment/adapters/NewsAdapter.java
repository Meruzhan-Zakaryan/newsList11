package com.example.newslistfragment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newslistfragment.news.News;
import com.example.newslistfragment.OnItemClicked;
import com.example.newslistfragment.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<News> newsList;
    private OnItemClicked onItemClicked;

    public void setOnItemClicked(OnItemClicked onItemClicked) {
        this.onItemClicked = onItemClicked;
    }

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NewsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News currentNews = newsList.get(position);
        holder.tvNewsTitle.setText(currentNews.getTitle());
        holder.tvNewsDescription.setText(currentNews.getDescription());

        Glide.with((holder).ivNews.getContext())
                .load(currentNews.getUrl())
                .into(holder.ivNews);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsHolder extends RecyclerView.ViewHolder {

        private ImageView ivNews;
        private TextView tvNewsDescription;
        private TextView tvNewsTitle;
        private CheckBox checkBox;


        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            ivNews = itemView.findViewById(R.id.iv_news_photo);
            tvNewsDescription = itemView.findViewById(R.id.tv_news_description);
            tvNewsTitle = itemView.findViewById(R.id.tv_news_title);
            checkBox = itemView.findViewById(R.id.cb_favorit);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicked.itemClickInFragment(getAdapterPosition());
                }
            });
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicked.checkBoxClick(getAdapterPosition());
                }
            });

        }
    }
}
