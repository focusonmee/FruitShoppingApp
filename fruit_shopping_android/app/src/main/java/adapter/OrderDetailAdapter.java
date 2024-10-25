package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fruitshopping.R;

import java.util.List;

import model.OrderDetail;

public class OrderDetailAdapter extends BaseAdapter {
    private Context context;
    private List<OrderDetail> orderDetailList;

    public OrderDetailAdapter(Context context, List<OrderDetail> orderDetailList) {
        this.context = context;
        this.orderDetailList = orderDetailList;
    }

    @Override
    public int getCount() {
        return orderDetailList.size();
    }

    @Override
    public Object getItem(int position) {
        return orderDetailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return orderDetailList.get(position).getOrderDetailId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.orderdetail_item, parent, false);
        }

        // Lấy thông tin chi tiết đơn hàng
        OrderDetail orderDetail = orderDetailList.get(position);

        // Ánh xạ các TextView
        TextView textViewProductName = convertView.findViewById(R.id.name);
        TextView textViewProductPrice = convertView.findViewById(R.id.price);
        TextView textViewQuantity = convertView.findViewById(R.id.quantity);

        // Thiết lập dữ liệu cho các TextView
        textViewProductName.setText("Name: " + orderDetail.getProductName());
        textViewProductPrice.setText("Price: " + orderDetail.getProductPrice());
        textViewQuantity.setText("Quantity: " + orderDetail.getQuantity());

        return convertView;
    }

}