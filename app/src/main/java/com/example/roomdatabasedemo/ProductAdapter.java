package com.example.roomdatabasedemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {

    private List<Product> products = new ArrayList<>();

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.product_view_card, viewGroup, false);
        return new ProductHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder productHolder, int position) {
        Product currentProduct = products.get(position);
        productHolder.productTitle.setText(currentProduct.getProductName());
        productHolder.productPrice.setText(currentProduct.getProductPrice());
        //productHolder.productImg.
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    class ProductHolder extends RecyclerView.ViewHolder {

        private TextView productTitle, productPrice;
        private ImageView productImg;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            productImg = itemView.findViewById(R.id.product_card_img);
            productTitle = itemView.findViewById(R.id.product_card_title);
            productPrice = itemView.findViewById(R.id.product_card_price);
        }
    }
}
