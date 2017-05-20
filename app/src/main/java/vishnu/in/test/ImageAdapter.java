package vishnu.in.test;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import java.util.ArrayList;


public class ImageAdapter extends PagerAdapter {
    /**
     * Variables
     */
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int[] mResources;

    private String[] arr ;

    private ArrayList<String> arrayList = new ArrayList<String>();


    public ImageAdapter(Context context) {
        mContext = context;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    /**
     * Method to initialize the View
     */
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        mLayoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = mLayoutInflater.inflate(
                R.layout.adapter_images, container, false);

        final ImageView imageView = (ImageView) itemView
                .findViewById(R.id.adapter_image_view);

        Glide
                .with(mContext)
                .load(arrayList.get(position))
                .centerCrop()
                .crossFade()
                .into(imageView);

        // imageView.setBackgroundResource(mResources[position]);

        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    /**
     * Method to destroy the Child View
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public void setList(ArrayList <String> array) {
        arrayList = array;
    }
//    public void setList(String[] array) {
//        arr = array;
//    }

}
